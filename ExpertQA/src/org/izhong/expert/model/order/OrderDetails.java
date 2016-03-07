package org.izhong.expert.model.order;

import java.io.Serializable;

public class OrderDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderMasterNo;
	private String orderDetailNo;
	private String productNo;    
	private double productPrice; 
	private double actualPrice;  
	private int orderAmount;  
	private double orderMoney;   
	private double fareMoney;    
	private double lateFee;      
	private double subTotal;     
	private double payPrice;   
	private String state;        
	private String tid;
	
	
	private String province;
	private String prefecturelevelcity;
	private String area;
	private String street;
	private String mobile;
	private String titletype;
	private String invoicetitle;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPrefecturelevelcity() {
		return prefecturelevelcity;
	}

	public void setPrefecturelevelcity(String prefecturelevelcity) {
		this.prefecturelevelcity = prefecturelevelcity;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTitletype() {
		return titletype;
	}

	public void setTitletype(String titletype) {
		this.titletype = titletype;
	}

	public String getInvoicetitle() {
		return invoicetitle;
	}

	public void setInvoicetitle(String invoicetitle) {
		this.invoicetitle = invoicetitle;
	}

	//计算变量
	private String productName;
	private String productUrl;
	private String productAlias;
	private String transactionNo;
	private double totalPayMoney;
	private String email;
	private String userId;
	
	private String createtime;
	private String username;
	private String paytype;
	private String paybank;
	
	
	public OrderDetails() {
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

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public double getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}

	public double getFareMoney() {
		return fareMoney;
	}

	public void setFareMoney(double fareMoney) {
		this.fareMoney = fareMoney;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(double payPrice) {
		this.payPrice = payPrice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public double getTotalPayMoney() {
		return totalPayMoney;
	}

	public void setTotalPayMoney(double totalPayMoney) {
		this.totalPayMoney = totalPayMoney;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductAlias() {
		return productAlias;
	}

	public void setProductAlias(String productAlias) {
		this.productAlias = productAlias;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getPaybank() {
		return paybank;
	}

	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}
}
