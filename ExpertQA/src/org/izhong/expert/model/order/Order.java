package org.izhong.expert.model.order;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderMasterNo;
	private String customerID;
	private double productMoney;
	private double lateFee;      
	private double actualMoney;  
	private String isNeedInvoice;
	private String notes;        
	private String payType;      
	private String payBank;     
	private String payStatus;    
	private String orderStatus;  
	private String linkId;       
	private double fareMoney;    
	private double totalPayMoney;
	private String createTime;   
	private String titleType;    
	private String invoiceTitle; 
	private String invoiceNotes; 
	private String postType;     
	private String postTime;     
	private String invoiceCode;  
	private String invoiceNo;    
	private double payMoney;     
	private String transactionNo;
	private String employeeId;
	
	public Order() {
	}

	public String getOrderMasterNo() {
		return orderMasterNo;
	}

	public void setOrderMasterNo(String orderMasterNo) {
		this.orderMasterNo = orderMasterNo;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public double getProductMoney() {
		return productMoney;
	}

	public void setProductMoney(double productMoney) {
		this.productMoney = productMoney;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public double getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(double actualMoney) {
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

	public double getFareMoney() {
		return fareMoney;
	}

	public void setFareMoney(double fareMoney) {
		this.fareMoney = fareMoney;
	}

	public double getTotalPayMoney() {
		return totalPayMoney;
	}

	public void setTotalPayMoney(double totalPayMoney) {
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

	public double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
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
