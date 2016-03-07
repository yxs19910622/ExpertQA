package org.izhong.expert.model;

import java.io.Serializable;

public class Operations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long operationID;
	private String operationName;
	private String operationGroupID;
	private String url;
	private String description;
	private String activeStatus;
	private String operationCode;
	private String type;
	
	public Operations() {
	}

	public long getOperationID() {
		return operationID;
	}

	public void setOperationID(long operationID) {
		this.operationID = operationID;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getOperationGroupID() {
		return operationGroupID;
	}

	public void setOperationGroupID(String operationGroupID) {
		this.operationGroupID = operationGroupID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
