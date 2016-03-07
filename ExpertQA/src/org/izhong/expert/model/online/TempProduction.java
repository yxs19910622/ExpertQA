package org.izhong.expert.model.online;

public class TempProduction {
	private String productNo;
	private String productName;
	private Integer productPrice;
	private String productType;
	private Integer payPrice;
	private Integer actualPrice;
	private Integer localFareMoney;
	private Integer otherFareMoney;
	private Integer lateFee;
	private String productImagePath;
	private String productVersion;
	private String productService;
	private Integer index;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	public String getProductService() {
		return productService;
	}
	public void setProductService(String productService) {
		this.productService = productService;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(Integer payPrice) {
		this.payPrice = payPrice;
	}
	public Integer getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(Integer actualPrice) {
		this.actualPrice = actualPrice;
	}
	public Integer getLocalFareMoney() {
		return localFareMoney;
	}
	public void setLocalFareMoney(Integer localFareMoney) {
		this.localFareMoney = localFareMoney;
	}
	public Integer getOtherFareMoney() {
		return otherFareMoney;
	}
	public void setOtherFareMoney(Integer otherFareMoney) {
		this.otherFareMoney = otherFareMoney;
	}
	public Integer getLateFee() {
		return lateFee;
	}
	public void setLateFee(Integer lateFee) {
		this.lateFee = lateFee;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
}
