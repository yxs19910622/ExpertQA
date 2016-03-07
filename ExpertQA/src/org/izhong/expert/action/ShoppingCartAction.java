package org.izhong.expert.action;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.izhong.expert.abs.OnlinePaymentAbs;
import org.izhong.expert.abs.UserLoginAbs;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.online.OrderContact;
import org.izhong.expert.model.online.TempProduction;
import org.izhong.expert.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;


public class ShoppingCartAction  extends BaseAction{

	private static final long serialVersionUID = 1L;
	private String indexNo;//客户订购的产品类型
	private String productCount;//产品的数量
	private int totalPrice;//客户支付总金额
	private int productPrice;//商品价格
	private int farePrice;
	private List list;
	private String customerId; //客户id号
	private String flag;
	protected Logger log = Logger.getLogger(getClass());
	//用户提交订单

	String shoppingCartParams;
	String orderRemark;
	String paymentType;
	String invoinceYesorno;
	String invoincePttt;
	String invoiceUnitTitName;

	private String orderMasterNo;
	private String orderDetailNo;
	private String linkId;
	@Autowired
	private OnlinePaymentAbs service;
	private UserLoginAbs userLoginAbs;
	 
	private List<QueryHotWords> lstqhw;
	private List<TempProduction> tmp_pro;
	private Integer length;
	private OrderContact contact;
	public String onlinePayment(){
		HttpServletRequest request = this.getRequest();
		if(request.getParameter("u") != null){
			HashMap map = this.service.manageUrlData(request.getParameter("u"));
			//根据用户名密码判断是否有客户号
			HashMap userInfo = new HashMap();
			userInfo.put("email",map.get("LoginName"));
			userInfo.put("deviceNo",map.get("DeviceSN"));
			userInfo.put("passWord", map.get("PassWord")); 
			customerId = this.service.getCustomerIdByEmailAndPasswd(userInfo);
			if(customerId == null || "".equals(customerId)){
				customerId = request.getParameter("customerId");
			}
			//String userId = this.service.getUserIdByEmailAndPasswd(userInfo);
			userLoginAbs.toLogin(getResponse(), map.get("LoginName")+"", map.get("PassWord")+"");//登录
			if(customerId != null && !customerId.equals("")){//进入订单审核页 
				Map orderMap = service.getOrderByCustomerId(customerId);
				if(orderMap.size() > 0){
					orderMasterNo = orderMap.get("OrderMasterNo")+"";//订单编号
					List orderDetails = (ArrayList)orderMap.get("orderDetail");
					indexNo = productCount = orderDetailNo = "";
					for(int j = 0; j< orderDetails.size();j++){
						Map orderDetail = (HashMap)orderDetails.get(j);
						indexNo += changePorductType(orderDetail.get("ProductNo")+"")+"#";
						productCount += orderDetail.get("OrderAmount")+"#";
						orderDetailNo += orderDetail.get("OrderDetailNo")+"#";//订单明细编号
					}
					indexNo = indexNo.substring(0, indexNo.length()-1);
					productCount = productCount.substring(0, productCount.length()-1);
					orderDetailNo = orderDetailNo.substring(0, orderDetailNo.length()-1);
					linkId = orderMap.get("LinkID")+"";
					tmp_pro = this.service.getTempProductList();
					length = this.tmp_pro.size();
					return "success";
				}else{
					try {
						//this.getResponse().sendRedirect("member/attestAccount?online=online");//
						this.getResponse().sendRedirect("onlinepayCustomerNo?online=online");//用户手动输入客户号
					} catch (IOException e) {
						e.printStackTrace();
					}
					//log.error("Icream订单数据和劳动法问答数据不同步");
				}
			}else{//进入用户认证页
				try {
					//this.getResponse().sendRedirect("member/attestAccount?online=online");//
					this.getResponse().sendRedirect("onlinepayCustomerNo");//用户手动输入客户号
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			//进入登录页面
			try {
				if(this.getUserID() != null){//cookie中的用户id
					//从cookie中获取用户名 密码 查询到客户id
					Cookie email = CookieUtil.getCookieByName(request, "Eemail");
					HashMap userInfo = new HashMap();
					String eml = email != null?email.getValue():null;
					userInfo.put("email", eml);
					customerId = this.service.getCustomerIdByEmailAndPasswd(userInfo);
					if(customerId == null || "".equals(customerId)){
						customerId = request.getParameter("customerId");
					}
					if(customerId != null && !customerId.equals("")){
						Map orderMap = service.getOrderByCustomerId(customerId);
						if(orderMap.size() > 0){
							orderMasterNo = orderMap.get("OrderMasterNo")+"";//订单编号
							List orderDetails = (ArrayList)orderMap.get("orderDetail");
							indexNo = productCount = orderDetailNo = "";
							for(int j = 0; j< orderDetails.size();j++){
								Map orderDetail = (HashMap)orderDetails.get(j);
								indexNo += changePorductType(orderDetail.get("ProductNo")+"")+"#";
								productCount += orderDetail.get("OrderAmount")+"#";
								orderDetailNo += orderDetail.get("OrderDetailNo")+"#";//订单明细编号
							}
							indexNo = indexNo.substring(0, indexNo.length()-1);
							productCount = productCount.substring(0, productCount.length()-1);
							orderDetailNo = orderDetailNo.substring(0, orderDetailNo.length()-1);
							linkId = orderMap.get("LinkID")+"";
							tmp_pro = this.service.getTempProductList();
							length = this.tmp_pro.size();
							return "success";//test 
						}else{
							try {
								//this.getResponse().sendRedirect("member/attestAccount?online=online");//
								this.getResponse().sendRedirect("onlinepayCustomerNo?online=online");//用户手动输入客户号
							} catch (IOException e) {
								e.printStackTrace();
							}
							//log.error("Icream没有取到客户号为:"+customerId+"的订单数据");
						}
					}else{
						try {
							//this.getResponse().sendRedirect("member/attestAccount?online=online");
							this.getResponse().sendRedirect("onlinepayCustomerNo");//用户手动输入客户号
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}else{
					flag = "online";
					lstqhw = userLoginAbs.findHotWordsAll();
					return "login";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	//进入订单审核
	public String changePorductType(String type){
		List list = this.service.getTempProductList();
		for(int i = 0;i < list.size(); i++){
			TempProduction temp = (TempProduction)list.get(i);
			if(temp.getProductNo().equals(type)){
				return (i+1)+"";
			}
		}
		return "0";
	}
	//进入支付页面
	public String initOnline(){
        List tmp_list = this.service.getTempProductList();
        HashMap tmp_map = new HashMap();
        for(int i = 0;i < tmp_list.size();i++){
        	tmp_map.put((i+1)+"", tmp_list.get(i));
        }
		HttpServletRequest request = this.getRequest();
		Map mName = request.getParameterMap();
		Set set = mName.keySet();
		Iterator iter = set.iterator();
		farePrice = 0;
		totalPrice = 0;
		list = new ArrayList<HashMap<String,String>>();
		StringBuffer sb = new StringBuffer();
		HashMap<String, Object> map;
		while(iter.hasNext()){
			String key = (String)iter.next();
			if(key.startsWith("orderQuantity_")){
				if(request.getParameter(key) != null){
					String index = key.replace("orderQuantity_", "");//产品的序号
					Integer number = Integer.parseInt(request.getParameter(key));//产品的数量
					TempProduction tempPro = (TempProduction)tmp_map.get(index);//一个产品对象
					totalPrice += (tempPro.getActualPrice() * number + tempPro.getLocalFareMoney() * number);//产品加运费总金额
					farePrice += (tempPro.getLocalFareMoney() * number);//运费
					map = new HashMap<String,Object>();
					map.put("name", tempPro.getProductName());
					map.put("oldPrice", tempPro.getPayPrice());
					map.put("type", tempPro.getProductNo());
					map.put("price", tempPro.getActualPrice());
					map.put("number", number);
					map.put("fare", tempPro.getLocalFareMoney());
					list.add(map);
					sb.append(tempPro.getProductNo()+"*"+number+"#");
				}
			}
		}
		productPrice = totalPrice - farePrice;
		contact = this.service.selectOrderContactByLinkId(linkId);//发货联系人地址
		shoppingCartParams = sb.toString();
		return "success";
	}
	
	public String orderPayment(){
		
		return SUCCESS;
	}
	
	
	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public OnlinePaymentAbs getService() {
		return service;
	}

	public void setService(OnlinePaymentAbs service) {
		this.service = service;
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

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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
	
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getFarePrice() {
		return farePrice;
	}

	public void setFarePrice(int farePrice) {
		this.farePrice = farePrice;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<QueryHotWords> getLstqhw() {
		return lstqhw;
	}

	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}

	public OrderContact getContact() {
		return contact;
	}

	public void setContact(OrderContact contact) {
		this.contact = contact;
	}

	public String getProductCount() {
		return productCount;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public List<TempProduction> getTmp_pro() {
		return tmp_pro;
	}

	public void setTmp_pro(List<TempProduction> tmpPro) {
		tmp_pro = tmpPro;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

}
