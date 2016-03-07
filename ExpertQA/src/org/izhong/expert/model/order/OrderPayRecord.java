package org.izhong.expert.model.order;

import java.io.Serializable;

public class OrderPayRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tid;
	private String orderMasterNo;    
	private double transactionMoney; 
	private String transactionStatus;
	private String submitData;       
	private String exceptionInfo;    
	private String synchronousDataNo;
	private String createTime;       
	private String transactionNo;
	
	public OrderPayRecord() {
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getOrderMasterNo() {
		return orderMasterNo;
	}

	public void setOrderMasterNo(String orderMasterNo) {
		this.orderMasterNo = orderMasterNo;
	}

	public double getTransactionMoney() {
		return transactionMoney;
	}

	public void setTransactionMoney(double transactionMoney) {
		this.transactionMoney = transactionMoney;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getSubmitData() {
		return submitData;
	}

	public void setSubmitData(String submitData) {
		this.submitData = submitData;
	}

	public String getExceptionInfo() {
		return exceptionInfo;
	}

	public void setExceptionInfo(String exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}

	public String getSynchronousDataNo() {
		return synchronousDataNo;
	}

	public void setSynchronousDataNo(String synchronousDataNo) {
		this.synchronousDataNo = synchronousDataNo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
}
