package org.izhong.expert.model;

import java.io.Serializable;

public class MsgGroupPersons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String msgGroupID;
	private String userID;
	
	public MsgGroupPersons() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getMsgGroupID() {
		return msgGroupID;
	}

	public void setMsgGroupID(String msgGroupID) {
		this.msgGroupID = msgGroupID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
