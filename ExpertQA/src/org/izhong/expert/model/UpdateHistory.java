package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class UpdateHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String userID;
	private String deviceSerialNumber;
	private Date downloadTime;
	private String downloadNotes;
	private String updateIndexNo;
	private String projectName;
	
	public UpdateHistory() {
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}

	public Date getDownloadTime() {
		return downloadTime;
	}

	public void setDownloadTime(Date downloadTime) {
		this.downloadTime = downloadTime;
	}

	public String getDownloadNotes() {
		return downloadNotes;
	}

	public void setDownloadNotes(String downloadNotes) {
		this.downloadNotes = downloadNotes;
	}

	public String getUpdateIndexNo() {
		return updateIndexNo;
	}

	public void setUpdateIndexNo(String updateIndexNo) {
		this.updateIndexNo = updateIndexNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
