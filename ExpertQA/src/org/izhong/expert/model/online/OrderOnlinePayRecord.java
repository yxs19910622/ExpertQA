package org.izhong.expert.model.online;

public class OrderOnlinePayRecord {
	private String tid;
	private String orderMasterno;
	private String transactionMoney;
	private String transactionStatus;
	private String submitData;
	private String exceptionInfo;
	private String synchronousDatano;
	private String createTime;
	private String transactionNo;//交易号
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getOrderMasterno() {
		return orderMasterno;
	}
	public void setOrderMasterno(String orderMasterno) {
		this.orderMasterno = orderMasterno;
	}
	public String getTransactionMoney() {
		return transactionMoney;
	}
	public void setTransactionMoney(String transactionMoney) {
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
	public String getSynchronousDatano() {
		return synchronousDatano;
	}
	public void setSynchronousDatano(String synchronousDatano) {
		this.synchronousDatano = synchronousDatano;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}