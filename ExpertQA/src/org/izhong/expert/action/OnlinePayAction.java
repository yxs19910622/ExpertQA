package org.izhong.expert.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.izhong.expert.abs.OnlinePaymentAbs;
import org.izhong.expert.abs.UserLoginAbs;
import org.izhong.expert.model.online.OrderInfo;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.model.online.OrderProduction;
import org.izhong.expert.model.online.TempProduction;
import org.izhong.expert.util.Alipay_fuction;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.DateHelper;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.Payment;
import org.izhong.expert.util.UtilDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OnlinePayAction extends BaseAction{

    private UserLoginAbs userLoginAbs;
    private String payType;
    private String defaultbank;

	private static final long serialVersionUID = 1L;
	@Autowired
	private OnlinePaymentAbs service;
	//用户提交订单
	String shoppingCartParams;
	String radPostage;
	String orderRemark;
	String invoinceYesorno;
	String invoincePttt;
	String invoiceUnitTitName;
	String pIdPostagetype;
	

	private String orderMasterNo;
	private String orderDetailNo;
	public String saveOnlinePay() {
		//存储订购信息
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setTransactionNo(UtilDate.getOrderCode());
		orderInfo.setOrderMasterno(orderMasterNo);
		orderInfo.setCreateTime(DateHelper.getYMDHMSFormatDateStr(new Date()));
		orderInfo.setPayStatus("1");	//1-未支付
        orderInfo.setPayType("100");
        orderInfo.setPayBank(defaultbank);
        if(orderRemark == null || "".equals(orderRemark)){
        	 orderInfo.setNotes("支付信息");
        }else{
        	 orderInfo.setNotes(orderRemark);
        }
       
      //取得购物车种产品及订购数量计算总价格
        int actualMoney = 0;
        int productMoney = 0;
        int faredMoney = 0;
        int lateMoney = 0;
		String params[] = shoppingCartParams.split("#");
		if(null != params && params.length > 0) {
			this.service.deleteOrderDetails(orderMasterNo);//删除上次添加的明细
			HashMap tempProMap = this.getOneTempProductByProductNo();
			for(int i = 0;i < params.length; i++){
				String[] arrs = params[i].split("\\*");//LDPUTZ*3#
				TempProduction t_pro = (TempProduction)tempProMap.get(arrs[0]);//获取一个产品的基本信息
				Integer number = Integer.parseInt(arrs[1]);//产品的数量
				actualMoney += t_pro.getActualPrice() * number;
				productMoney += t_pro.getPayPrice() * number;
				faredMoney += t_pro.getLocalFareMoney();
				OrderProduction pro = new OrderProduction();
				pro.setOrderMasterno(orderMasterNo);
				pro.setProductNo(arrs[0]);
				pro.setProductPrice(t_pro.getPayPrice());
				pro.setPayPrice(t_pro.getPayPrice());
				pro.setActualPrice(t_pro.getActualPrice());
				pro.setOrderAmount(number);
				pro.setOrderMoney(t_pro.getActualPrice() * number);
				pro.setFareMoney(t_pro.getLocalFareMoney());//运费
				pro.setLatefee(t_pro.getLateFee());//滞纳金
				pro.setSubTotal(t_pro.getActualPrice() * number + t_pro.getLocalFareMoney());
				String[] detailNo = orderDetailNo.split("#");//明细编号
				if(detailNo.length - 1 >= i){//前面的商品编号保留
					pro.setOrderDetailno(detailNo[i]);
					pro.setState("edit");
					pro.setTid(BaseUtil.generateIdentifier());
					this.service.addOrderProduction(pro);
					//this.service.updateOrderProduction(pro);
				}else{
					pro.setOrderDetailno("0");
					pro.setState("insert");
					pro.setTid(BaseUtil.generateIdentifier());
				    this.service.addOrderProduction(pro);
				}
				
			}
		}
		orderInfo.setActualMoney(actualMoney);//优惠后金额
		orderInfo.setFareMoney(faredMoney);//运费
		orderInfo.setTotalPayMoney(actualMoney + faredMoney);//总金额
		orderInfo.setProductMoney(productMoney);//商品金额
		orderInfo.setLateFee(lateMoney);//滞纳金
		orderInfo.setPayMoney(0);//支付金额
		if(null != invoinceYesorno && !invoinceYesorno.equals("")){//是否要发票
			if(invoinceYesorno.equals("2")){//no不需要发票
				orderInfo.setIsNeedInvoice("false");
			}else{//yes需要发票
				orderInfo.setIsNeedInvoice("true");
				if(null != invoincePttt && !invoincePttt.equals("")) {
					if(invoincePttt.equals("4")) {	//发票类型为个人
						orderInfo.setTitleType("个人");//个人
					} else if(invoincePttt.equals("5")) {//发票类型为个人
						orderInfo.setTitleType("单位");//单位
					}
					//存储发票信息invoiceUnitTitName
					orderInfo.setInvoiceTitle(invoiceUnitTitName);
				}
			}
		}
		service.editOrderInfo(orderInfo);
		
		
		//========================================================以下是支付信息====================================================
		
		OrderInfo order = service.queryOrderInfo(orderInfo.getOrderMasterno());
		OrderOnlinePayRecord orderOnlinePayRecord = service.queryOrderOnlinePayRecordByOrderId(order.getOrderMasterno());
		
		if(null != order) {
			if(order.getPayStatus().equals("1")) {	//支付状态为1未支付
				if(null != payType && !payType.equals("")) {
					if(payType.equals("100")||payType.equals("1000")) {	//此时在线支付方式未支付宝支付
						//修改支付方式为支付宝支付
						order.setPayType("100");
						service.editOrderInfo(order);					
						//保存在线支付交易记录
						if(null != orderOnlinePayRecord) {
							orderOnlinePayRecord.setTransactionNo(order.getTransactionNo());
							this.service.editOrderOnlinePaymentRecord(orderOnlinePayRecord);
						} else {
							orderOnlinePayRecord = new OrderOnlinePayRecord();
							orderOnlinePayRecord.setCreateTime(DateHelper.getYMDHMSFormatDateStr(new Date()));
							orderOnlinePayRecord.setOrderMasterno(order.getOrderMasterno());
							orderOnlinePayRecord.setTransactionNo(order.getTransactionNo());
                            orderOnlinePayRecord.setTid(order.getOrderMasterno());
							orderOnlinePayRecord.setTransactionMoney(order.getActualMoney()+"");	//支付金额
							orderOnlinePayRecord.setTransactionStatus("1");	//此时保存为1-失败状态，支付成功返回修改为2-成功
							orderOnlinePayRecord.setSubmitData(
									
									"sub_data{customerId:" + order.getCustomerId() + ",orderCode:" + order.getTransactionNo() + 
									",orderStatus:" + order.getOrderStatus() + ",payType:" + order.getPayType() +
									",payStatus:" + order.getPayStatus() + ",orderMoney:" + order.getActualMoney() + 
									",payMoney:" + order.getPayMoney() +
									",isNeedInvoice:" + order.getIsNeedInvoice() + 
									",notes:" + (order.getNotes() == null ? "" : order.getNotes()) + 
									",createTime:" + order.getCreateTime() +"}\n"
							);
							service.addOrderOnlinePayRecord(orderOnlinePayRecord);
						}


						if(null != order.getPayType()) {
							
							String payUrl = "";
							if(order.getPayType().equals("100")||order.getPayType().equals("1000")) {//在线支付方式为支付宝
								
							    if(payType.equals("1000")){
								payUrl = Payment.CreateUrl_Get_1(order.getOrderMasterno(), order.getTransactionNo(), order.getNotes(), 
										order.getActualMoney().toString(),
										order.getNotes(),"bankPay",defaultbank);
							    }else if(payType.equals("100")){
								   payUrl = Payment.CreateUrl_Get1(order.getOrderMasterno(), order.getTransactionNo(), order.getNotes(), 
										   order.getActualMoney().toString(), order.getNotes());	
										   }							
							    }
							try {
								this.getResponse().sendRedirect(payUrl);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			} else {
				return "";
			}
		}
		return null;
	}
	
	/**
	 * 支付宝方式在线支付回调方法
	 * @param model
	 * @param request
	 * @return
	 */
	public String alipayCallBack() {
		HttpServletRequest request = this.getRequest();
		String out_trade_no = request.getParameter("out_trade_no") != null ? request.getParameter("out_trade_no") : "";//获取返回的ORDERCODE
		OrderInfo order = new OrderInfo();
		order = service.selectOrderInfoByTransactionId(out_trade_no);
		boolean isAlipaySuccess = Alipay_fuction.isAlipaySuccess(request);	//验证支付宝是否支付成功
		if(isAlipaySuccess && !order.getPayStatus().equals("2")) {	//支付宝方式支付成功并且为未支付（防止支付平台二次回调）
			order.setPayStatus("2");
			service.editOrderInfo(order);
			OrderOnlinePayRecord onlinePaymentRecord = service.selectOrderOnlinePayRecordByTransactionId(out_trade_no);
			if(null != request.getParameter("total_fee") && !request.getParameter("total_fee").equals("")) {
				String total_fee = request.getParameter("total_fee");
				onlinePaymentRecord.setTransactionMoney(total_fee.split("\\.")[0]);
			}
			onlinePaymentRecord.setSubmitData(
					(DateUtil.getCurrTimeStr()+"==============================================================\n")+
					(onlinePaymentRecord.getSubmitData() == null ? "" : onlinePaymentRecord.getSubmitData()) + 
					"body:" + (request.getParameter("body") == null ? "" : request.getParameter("body")) + "\n" +
					"buyer_email:" + (request.getParameter("buyer_email") == null ? "" : request.getParameter("buyer_email")) + "\n" + 
					"buyer_id:" + (request.getParameter("buyer_id") == null ? "" : request.getParameter("buyer_id")) + "\n" +
					"exterface:" + (request.getParameter("exterface") == null ? "" : request.getParameter("exterface")) + "\n" +
					"extra_common_param:" + (request.getParameter("extra_common_param") == null ? "" : request.getParameter("extra_common_param")) + "\n" +
					"is_success:" + (request.getParameter("is_success") == null ? "" : request.getParameter("is_success")) + "\n" +
					"notify_id:" + (request.getParameter("notify_id") == null ? "" : request.getParameter("notify_id")) + "\n" +
					"notify_time:" + (request.getParameter("notify_time") == null ? "" : request.getParameter("notify_time")) + "\n" +
					"notify_type:" + (request.getParameter("notify_type") == null ? "" : request.getParameter("notify_type")) + "\n" +
					"out_trade_no:" + (request.getParameter("out_trade_no") == null ? "" : request.getParameter("out_trade_no")) + "\n" +
					"payment_type:" + (request.getParameter("payment_type") == null ? "" : request.getParameter("payment_type")) + "\n" +
					"seller_email:" + (request.getParameter("seller_email") == null ? "" : request.getParameter("seller_email")) + "\n" +
					"seller_id:" + (request.getParameter("seller_id") == null ? "" : request.getParameter("seller_id")) + "\n" +
					"subject:" + (request.getParameter("subject") == null ? "" : request.getParameter("subject")) + "\n" +
					"total_fee:" + (request.getParameter("total_fee") == null ? "" : request.getParameter("total_fee")) + "\n" +
					"trade_no:" + (request.getParameter("trade_no") == null ? "" : request.getParameter("trade_no")) + "\n" +
				    "trade_status:" + (request.getParameter("trade_status") == null ? "" : request.getParameter("trade_status")) + "\n");
				
			onlinePaymentRecord.setTransactionStatus("2");
			service.editOrderOnlinePaymentRecord(onlinePaymentRecord);
			try{
			this.service.updateOrderData(order.getOrderMasterno());//同步icream数据
			}catch(Exception ex){
				String error = this.exceptionToString(ex);
				onlinePaymentRecord.setExceptionInfo(DateUtil.getCurrTimeStr()+"==============================================================\n"+error);
				this.service.editOrderOnlinePaymentRecord(onlinePaymentRecord);
			}
			return "success"; //支付成功
		} else {
			return "error";//支付未成功
		}
	}
	 public HashMap getOneTempProductByProductNo(){
			HashMap<String,Object> map = new HashMap();
		    List list = this.service.getTempProductList();
		    for(int i = 0; i < list.size(); i++){
		    	TempProduction temp = (TempProduction)list.get(i);
		    	map.put(temp.getProductNo(), temp);
		    }
		    return map;
		}

	private static String exceptionToString(Exception ex) {
        try{  
            StringWriter sw = new StringWriter();  
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);  
            return sw.toString();  
        }catch (Exception e) {  
            return "bad process exception";
        } 
    }

   

	public OnlinePaymentAbs getService() {
		return service;
	}
	public void setService(OnlinePaymentAbs service) {
		this.service = service;
	}

	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getDefaultbank() {
		return defaultbank;
	}
	public void setDefaultbank(String defaultbank) {
		this.defaultbank = defaultbank;
	}

	public UserLoginAbs getUserLoginAbs() {
		return userLoginAbs;
	}
	public void setUserLoginAbs(UserLoginAbs userLoginAbs) {
		this.userLoginAbs = userLoginAbs;
	}

	public String getShoppingCartParams() {
		return shoppingCartParams;
	}

	public void setShoppingCartParams(String shoppingCartParams) {
		this.shoppingCartParams = shoppingCartParams;
	}

	public String getRadPostage() {
		return radPostage;
	}

	public void setRadPostage(String radPostage) {
		this.radPostage = radPostage;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getInvoinceYesorno() {
		return invoinceYesorno;
	}

	public void setInvoinceYesorno(String invoinceYesorno) {
		this.invoinceYesorno = invoinceYesorno;
	}

	public String getInvoincePttt() {
		return invoincePttt;
	}

	public void setInvoincePttt(String invoincePttt) {
		this.invoincePttt = invoincePttt;
	}

	public String getInvoiceUnitTitName() {
		return invoiceUnitTitName;
	}

	public void setInvoiceUnitTitName(String invoiceUnitTitName) {
		this.invoiceUnitTitName = invoiceUnitTitName;
	}

	public String getpIdPostagetype() {
		return pIdPostagetype;
	}

	public void setpIdPostagetype(String pIdPostagetype) {
		this.pIdPostagetype = pIdPostagetype;
	}

	public String getOrderMasterNo() {
		return orderMasterNo;
	}

	public void setOrderMasterNo(String orderMasterNo) {
		this.orderMasterNo = orderMasterNo;
	}

	public String getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}
}