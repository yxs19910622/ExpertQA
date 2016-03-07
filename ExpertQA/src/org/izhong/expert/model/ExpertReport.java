package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class ExpertReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String userID;
	private String areaType;
	private Date startDate;
	private Date endDate;
	private int recommendNumber;
	private int answerNumber;
	private int bestAnswerNumber;
	private int approvalNumber;
	
	public ExpertReport(String userID, int recommendNumber, int answerNumber,
			int bestAnswerNumber, int approvalNumber) {
		this.userID = userID;
		this.recommendNumber = recommendNumber;
		this.answerNumber = answerNumber;
		this.bestAnswerNumber = bestAnswerNumber;
		this.approvalNumber = approvalNumber;
	}

	public ExpertReport() {
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

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
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

	public int getRecommendNumber() {
		return recommendNumber;
	}

	public void setRecommendNumber(int recommendNumber) {
		this.recommendNumber = recommendNumber;
	}

	public int getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}

	public int getBestAnswerNumber() {
		return bestAnswerNumber;
	}

	public void setBestAnswerNumber(int bestAnswerNumber) {
		this.bestAnswerNumber = bestAnswerNumber;
	}

	public int getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(int approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
}
