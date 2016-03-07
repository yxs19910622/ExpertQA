package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class OperationLogs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String operationText;
	private String operator;
	private Date operationTime;
	private String operationNotes;
	private String ipAddress;
	
	public OperationLogs(String operationText, String operator,
			Date operationTime, String operationNotes, String ipAddress) {
		super();
		this.operationText = operationText;
		this.operator = operator;
		this.operationTime = operationTime;
		this.operationNotes = operationNotes;
		this.ipAddress = ipAddress;
	}

	public OperationLogs() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getOperationText() {
		return operationText;
	}

	public void setOperationText(String operationText) {
		this.operationText = operationText;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperationNotes() {
		return operationNotes;
	}

	public void setOperationNotes(String operationNotes) {
		this.operationNotes = operationNotes;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
}
