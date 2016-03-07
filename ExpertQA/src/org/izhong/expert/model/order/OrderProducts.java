package org.izhong.expert.model.order;

import java.io.Serializable;

public class OrderProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productNo;
	private String productName;
	private double productPrice;
	private String productType;
	private double actualPrice;
	private double localFareMoney;
	private double otherFareMoney;
	private String producTimagePath;
	private String producTversion;
	private String producTservice;
	
	public OrderProducts() {
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public double getLocalFareMoney() {
		return localFareMoney;
	}

	public void setLocalFareMoney(double localFareMoney) {
		this.localFareMoney = localFareMoney;
	}

	public double getOtherFareMoney() {
		return otherFareMoney;
	}

	public void setOtherFareMoney(double otherFareMoney) {
		this.otherFareMoney = otherFareMoney;
	}

	public String getProducTimagePath() {
		return producTimagePath;
	}

	public void setProducTimagePath(String producTimagePath) {
		this.producTimagePath = producTimagePath;
	}

	public String getProducTversion() {
		return producTversion;
	}

	public void setProducTversion(String producTversion) {
		this.producTversion = producTversion;
	}

	public String getProducTservice() {
		return producTservice;
	}

	public void setProducTservice(String producTservice) {
		this.producTservice = producTservice;
	}
}
