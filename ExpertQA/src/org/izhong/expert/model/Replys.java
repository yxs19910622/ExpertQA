package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Replys implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String replyID;
	private String questionID;
	private String replyContent;
	private String userID;
	private Date replyTime;
	private int pollCount;
	private String isAlreadyChecked;
	private String isAlreadyDeleted;
	private String isTop;
	
	private String questionTitle;
	
	public Replys() {
	}

	public String getReplyID() {
		return replyID;
	}

	public void setReplyID(String replyID) {
		this.replyID = replyID;
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getPollCount() {
		return pollCount;
	}

	public void setPollCount(int pollCount) {
		this.pollCount = pollCount;
	}

	public String getIsAlreadyChecked() {
		return isAlreadyChecked;
	}

	public void setIsAlreadyChecked(String isAlreadyChecked) {
		this.isAlreadyChecked = isAlreadyChecked;
	}

	public String getIsAlreadyDeleted() {
		return isAlreadyDeleted;
	}

	public void setIsAlreadyDeleted(String isAlreadyDeleted) {
		this.isAlreadyDeleted = isAlreadyDeleted;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
}
