package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String userID;
	private Date startDate;
	private Date endDate;
	private int questionNumber;
	
	public CustomerReport() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}


	public long getTid() {
		return tid;
	}


	public void setTid(long tid) {
		this.tid = tid;
	}
}
