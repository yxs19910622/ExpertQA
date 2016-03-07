package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class UserProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;             
	private String ownerUserId;     
	private String productNo;       
	private String productAlias;    
	private Date serviceStartDate;
	private Date serviceEndDate;  
	private String activeCode;      
	private String activeUser;      
	private Date activeDate;
	
	//计算变量
	private String productName;
	
	public UserProducts() {
	}

	public UserProducts(String ownerUserId, String productNo,
			String productAlias, String activeCode) {
		this.ownerUserId = ownerUserId;
		this.productNo = productNo;
		this.productAlias = productAlias;
		this.activeCode = activeCode;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductAlias() {
		return productAlias;
	}

	public void setProductAlias(String productAlias) {
		this.productAlias = productAlias;
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public String getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(String activeUser) {
		this.activeUser = activeUser;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
