package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class VerifyLogs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String verifyType;
	private long verifyItemID;
	private String userID;
	private Date verifyTime;
	private String noPassCause;
	
	public VerifyLogs() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public long getVerifyItemID() {
		return verifyItemID;
	}

	public void setVerifyItemID(long verifyItemID) {
		this.verifyItemID = verifyItemID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public String getNoPassCause() {
		return noPassCause;
	}

	public void setNoPassCause(String noPassCause) {
		this.noPassCause = noPassCause;
	}
}
