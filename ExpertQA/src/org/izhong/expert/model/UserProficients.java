package org.izhong.expert.model;

import java.io.Serializable;

public class UserProficients implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String userID;
	private String qaTypeID;
	
	public UserProficients() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getQaTypeID() {
		return qaTypeID;
	}

	public void setQaTypeID(String qaTypeID) {
		this.qaTypeID = qaTypeID;
	}
}
