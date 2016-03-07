package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Advertisements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String qaTypeID;
	private String userTypeName;
	private String url;
	private Date startTime;
	private Date endTime;
	
	public Advertisements() {
	}
	
	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getQaTypeID() {
		return qaTypeID;
	}
	public void setQaTypeID(String qaTypeID) {
		this.qaTypeID = qaTypeID;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
