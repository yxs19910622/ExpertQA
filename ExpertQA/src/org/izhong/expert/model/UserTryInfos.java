package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class UserTryInfos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private long tid;
	private String preOrderNo;
	private String consigneeName;
	private String province;
	private String prefectureLevelCity;
	private String area;
	private String street;
	private String postCode;
	private String mobile;
	private String telephone;
	private String email;
	private Date applyTryDate;
	private String tryProductNo;
	private String tryProductName;
	private String notes;
	private String visitorIP;
	private String userId;
	private String status;
	
	public UserTryInfos() {
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPrefectureLevelCity() {
		return prefectureLevelCity;
	}

	public void setPrefectureLevelCity(String prefectureLevelCity) {
		this.prefectureLevelCity = prefectureLevelCity;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getApplyTryDate() {
		return applyTryDate;
	}

	public void setApplyTryDate(Date applyTryDate) {
		this.applyTryDate = applyTryDate;
	}

	public String getTryProductNo() {
		return tryProductNo;
	}

	public void setTryProductNo(String tryProductNo) {
		this.tryProductNo = tryProductNo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPreOrderNo() {
		return preOrderNo;
	}

	public void setPreOrderNo(String preOrderNo) {
		this.preOrderNo = preOrderNo;
	}

	public String getVisitorIP() {
		return visitorIP;
	}

	public void setVisitorIP(String visitorIP) {
		this.visitorIP = visitorIP;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTryProductName() {
		return tryProductName;
	}

	public void setTryProductName(String tryProductName) {
		this.tryProductName = tryProductName;
	}
}
