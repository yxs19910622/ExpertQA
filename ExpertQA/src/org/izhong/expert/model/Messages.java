package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Messages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String sourceUserID;
	private String targetUserID;
	private String msgGroupID;
	private String title;
	private String content;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public Messages() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getSourceUserID() {
		return sourceUserID;
	}

	public void setSourceUserID(String sourceUserID) {
		this.sourceUserID = sourceUserID;
	}

	public String getTargetUserID() {
		return targetUserID;
	}

	public void setTargetUserID(String targetUserID) {
		this.targetUserID = targetUserID;
	}

	public String getMsgGroupID() {
		return msgGroupID;
	}

	public void setMsgGroupID(String msgGroupID) {
		this.msgGroupID = msgGroupID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
