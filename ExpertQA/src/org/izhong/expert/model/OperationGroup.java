package org.izhong.expert.model;

import java.io.Serializable;

public class OperationGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String operationGroupID;
	private String operationGroup;
	private String parentGroupID;
	private int inParentIndexNo;
	private int levelName;
	
	public OperationGroup() {
	}

	public String getOperationGroupID() {
		return operationGroupID;
	}

	public void setOperationGroupID(String operationGroupID) {
		this.operationGroupID = operationGroupID;
	}

	public String getOperationGroup() {
		return operationGroup;
	}

	public void setOperationGroup(String operationGroup) {
		this.operationGroup = operationGroup;
	}

	public String getParentGroupID() {
		return parentGroupID;
	}

	public void setParentGroupID(String parentGroupID) {
		this.parentGroupID = parentGroupID;
	}

	public int getInParentIndexNo() {
		return inParentIndexNo;
	}

	public void setInParentIndexNo(int inParentIndexNo) {
		this.inParentIndexNo = inParentIndexNo;
	}

	public int getLevelName() {
		return levelName;
	}

	public void setLevelName(int levelName) {
		this.levelName = levelName;
	}
}
