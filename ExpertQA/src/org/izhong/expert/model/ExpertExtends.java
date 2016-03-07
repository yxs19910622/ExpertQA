package org.izhong.expert.model;

import java.io.Serializable;

public class ExpertExtends implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userID;
	private String summary;
	private String recommendation;
	private String successCase;
	private String simpleSuccessCase;
	private String simpleExpertArea;
	
	public ExpertExtends() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getSuccessCase() {
		return successCase;
	}

	public void setSuccessCase(String successCase) {
		this.successCase = successCase;
	}

	public String getSimpleSuccessCase() {
		return simpleSuccessCase;
	}

	public void setSimpleSuccessCase(String simpleSuccessCase) {
		this.simpleSuccessCase = simpleSuccessCase;
	}

	public String getSimpleExpertArea() {
		return simpleExpertArea;
	}

	public void setSimpleExpertArea(String simpleExpertArea) {
		this.simpleExpertArea = simpleExpertArea;
	}
}
