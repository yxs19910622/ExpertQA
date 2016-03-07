package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class TMPOrders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderDetailNo;
	private String orderMasterNo;
	private String userID;
	private String productNo;
	private Date distributeDate;
	private Date paymentDate;
	private Date serviceStartDate;
	private Date serviceEndDate;
	private String orderStatus;
	private String invoiceNo;
	private Date importDate;
	
	public TMPOrders() {
	}

	public String getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public String getOrderMasterNo() {
		return orderMasterNo;
	}

	public void setOrderMasterNo(String orderMasterNo) {
		this.orderMasterNo = orderMasterNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getDistributeDate() {
		return distributeDate;
	}

	public void setDistributeDate(Date distributeDate) {
		this.distributeDate = distributeDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
}
