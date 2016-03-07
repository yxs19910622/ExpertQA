package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class DeviceRegisters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String deviceSerialNumber;
	private String createPerson;
	private Date createDate;
	private String deviceStatus;
	
	public DeviceRegisters() {
	}

	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
}
