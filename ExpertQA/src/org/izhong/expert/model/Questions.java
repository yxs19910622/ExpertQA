package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Questions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String questionID;
	private String qaTypeID;
	private String captionText;
	private String questionContent;
	private String userID;
	private String isExigentQuestion;
	private Date createTime;
	private int replyCount;
	private String isAlreadyChecked;
	private String isHotQuestion;
	private String isAlreadyClosed;
	private String isAlreadyDeleted;
	private String status;
	private int clickNumber;
	
	private String author;		//提问人姓名
	private String typeName;	//提问类型
	private String replysCount;		//问题的回答总数(已审核)
	
	public Questions() {
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getQaTypeID() {
		return qaTypeID;
	}

	public void setQaTypeID(String qaTypeID) {
		this.qaTypeID = qaTypeID;
	}

	public String getCaptionText() {
		return captionText;
	}

	public void setCaptionText(String captionText) {
		this.captionText = captionText;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getIsExigentQuestion() {
		return isExigentQuestion;
	}

	public void setIsExigentQuestion(String isExigentQuestion) {
		this.isExigentQuestion = isExigentQuestion;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getIsAlreadyChecked() {
		return isAlreadyChecked;
	}

	public void setIsAlreadyChecked(String isAlreadyChecked) {
		this.isAlreadyChecked = isAlreadyChecked;
	}

	public String getIsHotQuestion() {
		return isHotQuestion;
	}

	public void setIsHotQuestion(String isHotQuestion) {
		this.isHotQuestion = isHotQuestion;
	}

	public String getIsAlreadyClosed() {
		return isAlreadyClosed;
	}

	public void setIsAlreadyClosed(String isAlreadyClosed) {
		this.isAlreadyClosed = isAlreadyClosed;
	}

	public String getIsAlreadyDeleted() {
		return isAlreadyDeleted;
	}

	public void setIsAlreadyDeleted(String isAlreadyDeleted) {
		this.isAlreadyDeleted = isAlreadyDeleted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(int clickNumber) {
		this.clickNumber = clickNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getReplysCount() {
		return replysCount;
	}

	public void setReplysCount(String replysCount) {
		this.replysCount = replysCount;
	}
}
