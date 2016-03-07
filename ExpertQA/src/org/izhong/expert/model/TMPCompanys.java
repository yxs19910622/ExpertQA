package org.izhong.expert.model;

import java.io.Serializable;

public class TMPCompanys implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String companyID;
	private String companyName;
	private String incorporator;
	private String province;
	private String prefecturelevelCity;
	private String area;
	private String street;
	private String postcode;
	private String telephone;
	private String fax;
	private String notes;
	private String summary;
	
	public TMPCompanys() {
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIncorporator() {
		return incorporator;
	}

	public void setIncorporator(String incorporator) {
		this.incorporator = incorporator;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
