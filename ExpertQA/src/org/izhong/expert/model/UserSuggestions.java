package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class UserSuggestions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String userID;
	private String suggestionType;
	private String captionText;
	private String suggestionContent;
	private Date suggestionTime;
	private String repayPerson;
	private Date repayTime;
	private String repayNotes;
	private String status;
	
	public UserSuggestions() {
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

	public String getSuggestionType() {
		return suggestionType;
	}

	public void setSuggestionType(String suggestionType) {
		this.suggestionType = suggestionType;
	}

	public String getCaptionText() {
		return captionText;
	}

	public void setCaptionText(String captionText) {
		this.captionText = captionText;
	}

	public String getSuggestionContent() {
		return suggestionContent;
	}

	public void setSuggestionContent(String suggestionContent) {
		this.suggestionContent = suggestionContent;
	}

	public String getRepayPerson() {
		return repayPerson;
	}

	public void setRepayPerson(String repayPerson) {
		this.repayPerson = repayPerson;
	}

	public String getRepayNotes() {
		return repayNotes;
	}

	public void setRepayNotes(String repayNotes) {
		this.repayNotes = repayNotes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSuggestionTime() {
		return suggestionTime;
	}

	public void setSuggestionTime(Date suggestionTime) {
		this.suggestionTime = suggestionTime;
	}

	public Date getRepayTime() {
		return repayTime;
	}

	public void setRepayTime(Date repayTime) {
		this.repayTime = repayTime;
	}
}
