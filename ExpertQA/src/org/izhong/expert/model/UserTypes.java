package org.izhong.expert.model;

import java.io.Serializable;

public class UserTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long userTypeID;
	private String userTypeName;
	private String description;
	
	public UserTypes() {
	}

	public long getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(long userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
