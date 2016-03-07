package org.izhong.expert.model;

import java.io.Serializable;

public class MsgGroups implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msgGroupID;
	private String msgGroupName;
	private String description;
	
	public MsgGroups() {
	}

	public String getMsgGroupID() {
		return msgGroupID;
	}

	public void setMsgGroupID(String msgGroupID) {
		this.msgGroupID = msgGroupID;
	}

	public String getMsgGroupName() {
		return msgGroupName;
	}

	public void setMsgGroupName(String msgGroupName) {
		this.msgGroupName = msgGroupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
