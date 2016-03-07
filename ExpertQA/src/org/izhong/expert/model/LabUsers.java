package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class LabUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String userID;
	private String userName;
	private String companyID;
	private String position;
	private String province;
	private String prefecturelevelCity;
	private String area;
	private String street;
	private String postcode;
	private String mobile;
	private String telephone;
	private String fax;
	private String email;
	private Date registerDate;
	private Date firstPayDate;
	private String userTypeName;
	private String activeStatus;
	private String aliasName;
	private String userPicture;
	
	private Companys company;
	private ExpertExtends extend;
	private ExpertReport report;
	
	public LabUsers() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPrefecturelevelCity() {
		return prefecturelevelCity;
	}

	public void setPrefecturelevelCity(String prefecturelevelCity) {
		this.prefecturelevelCity = prefecturelevelCity;
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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getFirstPayDate() {
		return firstPayDate;
	}

	public void setFirstPayDate(Date firstPayDate) {
		this.firstPayDate = firstPayDate;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public Companys getCompany() {
		return company;
	}

	public void setCompany(Companys company) {
		this.company = company;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public ExpertExtends getExtend() {
		return extend;
	}

	public void setExtend(ExpertExtends extend) {
		this.extend = extend;
	}

	public ExpertReport getReport() {
		return report;
	}

	public void setReport(ExpertReport report) {
		this.report = report;
	}
}