package org.izhong.expert.model;

import java.io.Serializable;

public class QATypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String qaTypeID;
	private String qaTypeName;
	private int qaTypeLevel;
	private String parentTypeID;
	private String topic;
	private String status;
	private String hasChild;
	
	public QATypes() {
	}

	public String getQaTypeID() {
		return qaTypeID;
	}

	public void setQaTypeID(String qaTypeID) {
		this.qaTypeID = qaTypeID;
	}

	public String getQaTypeName() {
		return qaTypeName;
	}

	public void setQaTypeName(String qaTypeName) {
		this.qaTypeName = qaTypeName;
	}

	public int getQaTypeLevel() {
		return qaTypeLevel;
	}

	public void setQaTypeLevel(int qaTypeLevel) {
		this.qaTypeLevel = qaTypeLevel;
	}

	public String getParentTypeID() {
		return parentTypeID;
	}

	public void setParentTypeID(String parentTypeID) {
		this.parentTypeID = parentTypeID;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}
}
