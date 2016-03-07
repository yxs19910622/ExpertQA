package org.izhong.expert.model.online;

import java.util.Date;



public class OrderInfo {
	
	private String orderMasterno 	;//			订单编号
	private String customerId	;//			客户编号
	private Integer productMoney	;//			产品金额
	private Integer payMoney	;//			支付金额
	private Integer actualMoney	;//			优惠后金额
	private String isNeedInvoice;//			是否需要发票
	private String notes	;//			订单备注
	private String payType	;//			支付方式（网上银行｜支付宝）
	private String payBank	;//			支付银行（如果为网上银行，则为银行名称，如BBC等）
	private String payStatus	;//			当前支付状态
	private String orderStatus	;//			订单状态
	private String linkId;//			收货人编号
	private Integer fareMoney;//			运费
	private Integer totalPayMoney;//			合计应付费用
	private String createTime	;//			订单时间
	
	private String titleType	;//			发票抬头类型（个人｜公司）
	private String invoiceTitle	;//			发票抬头
	private String invoiceNotes	;//			发票备注
	private String postType	;//			邮寄方式
	private String postTime;//			邮寄时间
	private String invoiceCode	;//			发票代码
	private String invoiceNo	;//			发票编号
	private Integer lateFee;//滞纳金
	private String transactionNo;//交易号
	private String employeeId;
	public String getOrderMasterno() {
		return orderMasterno;
	}
	public void setOrderMasterno(String orderMasterno) {
		this.orderMasterno = orderMasterno;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getProductMoney() {
		return productMoney;
	}
	public void setProductMoney(Integer productMoney) {
		this.productMoney = productMoney;
	}
	public Integer getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}
	public Integer getActualMoney() {
		return actualMoney;
	}
	public void setActualMoney(Integer actualMoney) {
		this.actualMoney = actualMoney;
	}
	public String getIsNeedInvoice() {
		return isNeedInvoice;
	}
	public void setIsNeedInvoice(String isNeedInvoice) {
		this.isNeedInvoice = isNeedInvoice;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayBank() {
		return payBank;
	}
	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	public Integer getFareMoney() {
		return fareMoney;
	}
	public void setFareMoney(Integer fareMoney) {
		this.fareMoney = fareMoney;
	}
	public Integer getTotalPayMoney() {
		return totalPayMoney;
	}
	public void setTotalPayMoney(Integer totalPayMoney) {
		this.totalPayMoney = totalPayMoney;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getTitleType() {
		return titleType;
	}
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getInvoiceNotes() {
		return invoiceNotes;
	}
	public void setInvoiceNotes(String invoiceNotes) {
		this.invoiceNotes = invoiceNotes;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Integer getLateFee() {
		return lateFee;
	}
	public void setLateFee(Integer lateFee) {
		this.lateFee = lateFee;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}