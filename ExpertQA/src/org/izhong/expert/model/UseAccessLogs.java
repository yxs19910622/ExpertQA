package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class UseAccessLogs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String userID;
	private String ipAddress;
	private String accessOperation;
	private Date accessTime;
	private String deviceSerialNumber;
	
	public UseAccessLogs() {
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getAccessOperation() {
		return accessOperation;
	}

	public void setAccessOperation(String accessOperation) {
		this.accessOperation = accessOperation;
	}

	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
}
