package org.izhong.expert.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.izhong.expert.abs.BuyOnlineAbs;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.order.Order;
import org.izhong.expert.model.order.OrderDetails;
import org.izhong.expert.model.order.OrderPayRecord;
import org.izhong.expert.model.order.OrderProducts;
import org.izhong.expert.util.Alipay_fuction;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.CookieUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.UtilDate;
import org.izhong.web.util.SendMail;

public class BuyOnlineAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productNo = "";
	private int cartSize = 0;
	private double totalPrice;
	private String orderMasterNo;
	private LabUsers labuser;
	private SysUsers sysuser;
	private List<OrderProducts> lstop=null;
	private List<OrderDetails> lstod=null;
	private List<Order> lstOrder=null;
	private BuyOnlineAbs buyOnlineAbs;
	private int yuanjia;
	private int preferPrice;
	private int coupon;
	
	private String str = "8708418";
	
	/**
	 * 加入购物车
	 * @return
	 * @author whz
	 */
	public String addCart()
	{
		//String userId = getUserID();
		/*if(BaseUtil.isNotEmpty(userId)){
			lstop = new ArrayList<OrderProducts>();
			Cookie no = CookieUtil.getCookieByName(getRequest(), "No");
			if(BaseUtil.isNotEmpty(productNo)){
				if(no!=null){
					if(no.getValue().indexOf(productNo)<0){
						productNo = no.getValue()+","+productNo;
					}else{
						productNo = no.getValue();
					}
					String [] spValue = productNo.split(",");
					for (int i = 0; i < spValue.length; i++) {
						if(BaseUtil.isNotEmpty(spValue[i])){
							lstop.add(buyOnlineAbs.getOrderProductByNo(spValue[i]));
						}
					}
				}else{
	//				if(BaseUtil.isNotEmpty(productNo)){
						String [] spValue = productNo.split(",");
						for (int i = 0; i < spValue.length; i++) {
							if(BaseUtil.isNotEmpty(spValue[i])){
								lstop.add(buyOnlineAbs.getOrderProductByNo(spValue[i]));
							}
						}
	//					lstop.add(buyOnlineAbs.getOrderProductByNo(productNo));
	//				}
				}
//			if(BaseUtil.isNotEmpty(productNo)){
				CookieUtil.addCookie(getResponse(), "No", productNo);
//			}
			}
			cartSize = lstop.size();
		}*/
		lstop = new ArrayList<OrderProducts>();
		Cookie no = CookieUtil.getCookieByName(getRequest(), "No");
		if(BaseUtil.isNotEmpty(productNo)){
			if(no!=null){
				if(no.getValue().indexOf(productNo)<0){
					productNo = no.getValue()+","+productNo;
				}else{
					productNo = no.getValue();
				}
				String [] spValue = productNo.split(",");
				for (int i = 0; i < spValue.length; i++) {
					if(BaseUtil.isNotEmpty(spValue[i])){
						lstop.add(buyOnlineAbs.getOrderProductByNo(spValue[i]));
					}
				}
			}else{
//				if(BaseUtil.isNotEmpty(productNo)){
					String [] spValue = productNo.split(",");
					for (int i = 0; i < spValue.length; i++) {
						if(BaseUtil.isNotEmpty(spValue[i])){
							lstop.add(buyOnlineAbs.getOrderProductByNo(spValue[i]));
						}
					}
//					lstop.add(buyOnlineAbs.getOrderProductByNo(productNo));
//				}
			}
//			if(BaseUtil.isNotEmpty(productNo)){
			CookieUtil.addCookie(getResponse(), "No", productNo);
//			}
		}
		cartSize = lstop.size();
		return SUCCESS;
	}

	/**
	 * 移除购物车中的商品
	 * @return
	 * @author whz
	 */
	public String removeCart(){
		/*String userId = getUserID();
		Cookie no = CookieUtil.getCookieByName(getRequest(), "No");
		if(no!=null && userId!=null){
			productNo = no.getValue().replace(productNo, "");
			String [] spValue = productNo.split(",");
			lstop = new ArrayList<OrderProducts>();
			for (int i = 0; i < spValue.length; i++) {
				if(BaseUtil.isNotEmpty(spValue[i])){
					lstop.add(buyOnlineAbs.getOrderProductByNo(spValue[i]));
				}
			}
			CookieUtil.addCookie(getResponse(), "No", productNo);
			cartSize = lstop.size();
		}*/
		Cookie no = CookieUtil.getCookieByName(getRequest(), "No");
		productNo = no.getValue().replace(productNo, "");
		String [] spValue = productNo.split(",");
		lstop = new ArrayList<OrderProducts>();
		for (int i = 0; i < spValue.length; i++) {
			if(BaseUtil.isNotEmpty(spValue[i])){
				lstop.add(buyOnlineAbs.getOrderProductByNo(spValue[i]));
			}
		}
		CookieUtil.addCookie(getResponse(), "No", productNo);
		cartSize = lstop.size();
		return SUCCESS;
	}

	/**
	 * 提交购物车
	 * @return
	 * @author whz
	 */
	public String submitCart(){

		
		String totalPrice1 = getParameter("finalPrice");
		String preferPrice = getParameter("preferPrice");
		String yuanjia = getParameter("totalPrice");
		String coupon1 = getParameter("coupon");
		int preferPrice1 = Integer.parseInt(preferPrice);
		int yuanjia1 = Integer.parseInt(yuanjia);
		if(coupon1!=null&&(!"".equals(coupon1))){
			coupon = Integer.parseInt(coupon1);
		}
		int totalPrice2 = Integer.parseInt(totalPrice1);
		totalPrice = totalPrice2;
		String userId = getUserID();
		Cookie no = CookieUtil.getCookieByName(getRequest(), "No");
		if(no!=null && userId!=null){
			String [] spValue = no.getValue().split(",");
			int j = 0;
			double totalPayMoney = 0;
			int actualPrice = 0;
			int productPrice = 0;
			Order order = new Order();
			OrderDetails od = null;
			lstod = new ArrayList<OrderDetails>();
			order.setOrderMasterNo(UtilDate.getSix());
			order.setLinkId(userId);
			order.setCreateTime(DateUtil.getCurrDate());
			for (int i = 0; i < spValue.length; i++) {
				if(BaseUtil.isNotEmpty(spValue[i])){
					String productNo = spValue[i];
					j++;
					OrderProducts op = buyOnlineAbs.getOrderProductByNo(productNo);
					String pid = "orderQuantity_"+(j);
					if(op!=null){
						od = new OrderDetails();
						od.setOrderMasterNo(order.getOrderMasterNo());
						od.setOrderDetailNo(UtilDate.getSix());
						od.setProductNo(productNo);
						od.setProductPrice(op.getProductPrice());
						od.setActualPrice(op.getActualPrice());
						od.setOrderAmount(Integer.valueOf(getParameter(pid)));
						od.setOrderMoney(totalPrice);
						od.setFareMoney(0);
						od.setSubTotal(totalPrice);
						od.setState("insert");
						od.setTid(BaseUtil.generateIdentifier());
						productPrice+=od.getProductPrice()*od.getOrderAmount();
						actualPrice+=od.getActualPrice()*od.getOrderAmount();
						totalPayMoney=totalPrice2;
						buyOnlineAbs.addOrderDetails(od);
						od.setProductName(op.getProductName());
						od.setProductUrl(op.getProducTimagePath());
						lstod.add(od);
					}
				}
			}
			order.setProductMoney(productPrice);
			order.setActualMoney(actualPrice);
			order.setTotalPayMoney(totalPayMoney);
			buyOnlineAbs.addOrder(order);
			this.setYuanjia(yuanjia1);
			this.setCoupon(coupon);
			this.setPreferPrice(preferPrice1);
			CookieUtil.removeCookie(getRequest(), getResponse(), "No");
			orderMasterNo = order.getOrderMasterNo();
			labuser = buyOnlineAbs.findLabUserInfo(userId);
			sysuser = buyOnlineAbs.findSysUserInfo(userId);
		}
		return SUCCESS;
	}
	/*public String submitCart(){

		String totalPrice1 = getParameter("finalPrice");
		String preferPrice = getParameter("preferPrice");
		String yuanjia = getParameter("totalPrice");
		String coupon1 = getParameter("coupon");
		int preferPrice1 = Integer.parseInt(preferPrice);
		int yuanjia1 = Integer.parseInt(yuanjia);
		if(coupon1!=null&&(!"".equals(coupon1))){
			int coupon = Integer.parseInt(coupon1);
		}
		int totalPrice2 = Integer.parseInt(totalPrice1);
		totalPrice = totalPrice2;
		String userId = getUserID();
		Cookie no = CookieUtil.getCookieByName(getRequest(), "No");
		if(no!=null && userId!=null){
			String [] spValue = no.getValue().split(",");
			int j = 0;
			double totalPayMoney = 0.01;
			int actualPrice = 0;
			double productPrice = 0.01;
			Order order = new Order();
			OrderDetails od = null;
			lstod = new ArrayList<OrderDetails>();
			order.setOrderMasterNo(UtilDate.getSix());
			order.setLinkId(userId);
			order.setCreateTime(DateUtil.getCurrDate());
			for (int i = 0; i < spValue.length; i++) {
				if(BaseUtil.isNotEmpty(spValue[i])){
					String productNo = spValue[i];
					j++;
					OrderProducts op = buyOnlineAbs.getOrderProductByNo(productNo);
					String pid = "orderQuantity_"+(j);
					if(op!=null){
						od = new OrderDetails();
						od.setOrderMasterNo(order.getOrderMasterNo());
						od.setOrderDetailNo(UtilDate.getSix());
						od.setProductNo(productNo);
						od.setProductPrice(op.getProductPrice());
						od.setActualPrice(op.getActualPrice());
						od.setOrderAmount(Integer.valueOf(getParameter(pid)));
						od.setOrderMoney(totalPrice);
						od.setFareMoney(0);
						od.setSubTotal(totalPrice);
						od.setState("insert");
						od.setTid(BaseUtil.generateIdentifier());
						productPrice+=od.getProductPrice()*od.getOrderAmount();
						actualPrice+=od.getActualPrice()*od.getOrderAmount();
						buyOnlineAbs.addOrderDetails(od);
						od.setProductName(op.getProductName());
						od.setProductUrl(op.getProducTimagePath());
						lstod.add(od);
					}
				}
			}
			order.setProductMoney(productPrice);
			order.setActualMoney(actualPrice);
			order.setTotalPayMoney(totalPayMoney);
			buyOnlineAbs.addOrder(order);
			this.setYuanjia(yuanjia1);
			this.setCoupon(coupon);
			this.setPreferPrice(preferPrice1);
			CookieUtil.removeCookie(getRequest(), getResponse(), "No");
			orderMasterNo = order.getOrderMasterNo();
			labuser = buyOnlineAbs.findLabUserInfo(userId);
			sysuser = buyOnlineAbs.findSysUserInfo(userId);
		}
		return SUCCESS;
	}*/
	
	/**
	 *  查看我的订单列表
	 * @return
	 * @author whz
	 */
	public String orderList()
	{
		
		String userId = getUserID();
		if(BaseUtil.isEmpty(userId)){
			return ERROR;
		}
		lstOrder = buyOnlineAbs.getOrderByUserId(userId);
		return SUCCESS;
	}
	
	/**
	 * 我的订单列表付款
	 * @return
	 * @author whz
	 */
	public String orderListPayment()
	{
		String userId = getUserID();
		String orderNo = getParameter("orderMasterNo");
		if(BaseUtil.isEmpty(userId) || BaseUtil.isEmpty(orderNo)){
			return ERROR;
		}
		Order order = buyOnlineAbs.getOrderByOrderMasterNo(userId, orderNo);
		if(order==null){
			return ERROR;
		}
		lstod = buyOnlineAbs.getOrderDetailsByNo(orderNo);
		totalPrice = order.getTotalPayMoney();
		orderMasterNo = order.getOrderMasterNo();
		labuser = buyOnlineAbs.findLabUserInfo(userId);
		sysuser = buyOnlineAbs.findSysUserInfo(userId);
		return SUCCESS;
	}

	public String orderPayment(){
		String userId = getUserID();
		String orderMasterNo = getParameter("orderMasterNo");
		String payType = getParameter("payType");
		String payBank = getParameter("payBank");
		String notes = getParameter("notes");
		String isNeedInvoice = getParameter("isNeedInvoice");
		String titleType = getParameter("titleType");
		String invoiceTitle = getParameter("invoiceTitle");

		if(BaseUtil.isNotEmpty(userId) && BaseUtil.isNotEmpty(orderMasterNo)){
			Order order = new Order();
			order.setLinkId(userId);
			order.setOrderMasterNo(orderMasterNo);
			order.setPayType(payType);
			order.setPayBank(payBank);
			order.setIsNeedInvoice(isNeedInvoice);
			order.setTitleType(titleType);
			order.setInvoiceTitle(invoiceTitle);
			order.setTransactionNo(UtilDate.getOrderCode());
			order.setPayStatus("1");
			if(BaseUtil.isEmpty(notes)){
				order.setNotes("支付信息");
			}else{
				order.setNotes(notes);
			}
			buyOnlineAbs.updateOrder(order);
			buyOnlineAbs.addOrderPayRecord(orderMasterNo,userId);
			String payUrl = buyOnlineAbs.orderPayment(orderMasterNo, userId);
			if(BaseUtil.isNotEmpty(payUrl)){
				try {
					this.getResponse().sendRedirect(payUrl);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				return ERROR;
			}
		}
		return null;
	}
	/*public String snakeTest(){
		SendMail send = new SendMail();
		//str = (String) getRequest().getAttribute("masterNo");
		OrderDetails message4Email = buyOnlineAbs.getMessage4Email("8708418");
		try {
			send.send_buy("yxs19910622@163.com", message4Email);
//			send.send_buy("yangxs@haufe.cn", message4Email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}*/
	
	
	/**
	 * 支付宝回调
	 * 
	 * @author whz
	 */
	public String buyOnlineCallback(){
		HttpServletRequest request = this.getRequest();
		String out_trade_no = request.getParameter("out_trade_no") != null ? request.getParameter("out_trade_no") : "";//获取返回的ORDERCODE
		Order order = new Order();
		order = buyOnlineAbs.getOrderByTransactionId(out_trade_no);
		boolean isAlipaySuccess = Alipay_fuction.isAlipaySuccess(request);	//验证支付宝是否支付成功
		if(isAlipaySuccess && !order.getPayStatus().equals("2")) {	//支付宝方式支付成功并且为未支付（防止支付平台二次回调）
			order.setPayStatus("2");
			OrderPayRecord payRecord = buyOnlineAbs.getPayRecordByTransactionId(out_trade_no);
			if(null != request.getParameter("total_fee") && !request.getParameter("total_fee").equals("")) {
				String total_fee = request.getParameter("total_fee");
				payRecord.setTransactionMoney(Double.valueOf(total_fee.split("\\.")[0]));
			}
			payRecord.setSubmitData(
					(DateUtil.getCurrTimeStr()+"==============================================================\n")+
					(payRecord.getSubmitData() == null ? "" : payRecord.getSubmitData()) + 
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
			payRecord.setTransactionStatus("2");
			buyOnlineAbs.updateOrderStatus(order);
			buyOnlineAbs.updateOrderPayRecord(payRecord);
			/*buyOnlineAbs.GenerateActivation(order.getLinkId(), out_trade_no);*/
			
			
			//购买成功以后发个邮件
//			SendMail send = new SendMail();
//			OrderDetails message4Email = buyOnlineAbs.getMessage4Email(order.getOrderMasterNo());
//			try {
//				send.send_buy("yangxs@haufe.cn", message4Email);
//				send.send_buy("2873668751@qq.com", message4Email);
////				send.send_buy("2873668751@qq.com", "1123");
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//System.out.println(order.getOrderMasterNo());
			//snakeTest();
//			getRequest().setAttribute("masterNo", order.getOrderMasterNo());
			
			SendMail send = new SendMail();
			//str = (String) getRequest().getAttribute("masterNo");
			OrderDetails message4Email = buyOnlineAbs.getMessage4Email(order.getOrderMasterNo());
			try {
				send.send_buy("yxs19910622@163.com", message4Email,order.getNotes());
				send.send_buy("yangxs@haufe.cn", message4Email,order.getNotes());
				send.send_buy("lis@haufe.cn", message4Email,order.getNotes());
				send.send_buy("2873668751@qq.com", message4Email,order.getNotes());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return SUCCESS; //支付成功
		} else {
			return "error01";//支付未成功
		}
	}

	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public void setBuyOnlineAbs(BuyOnlineAbs buyOnlineAbs) {
		this.buyOnlineAbs = buyOnlineAbs;
	}
	public List<OrderProducts> getLstop() {
		return lstop;
	}
	public void setLstop(List<OrderProducts> lstop) {
		this.lstop = lstop;
	}
	public int getCartSize() {
		return cartSize;
	}
	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}

	public List<OrderDetails> getLstod() {
		return lstod;
	}

	public void setLstod(List<OrderDetails> lstod) {
		this.lstod = lstod;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LabUsers getLabuser() {
		return labuser;
	}

	public void setLabuser(LabUsers labuser) {
		this.labuser = labuser;
	}

	public SysUsers getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUsers sysuser) {
		this.sysuser = sysuser;
	}

	public String getOrderMasterNo() {
		return orderMasterNo;
	}

	public void setOrderMasterNo(String orderMasterNo) {
		this.orderMasterNo = orderMasterNo;
	}

	public List<Order> getLstOrder() {
		return lstOrder;
	}

	public void setLstOrder(List<Order> lstOrder) {
		this.lstOrder = lstOrder;
	}

	public int getYuanjia() {
		return yuanjia;
	}

	public void setYuanjia(int yuanjia) {
		this.yuanjia = yuanjia;
	}

	public int getPreferPrice() {
		return preferPrice;
	}

	public void setPreferPrice(int preferPrice) {
		this.preferPrice = preferPrice;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
}
