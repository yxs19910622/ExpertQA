package org.izhong.expert.model.online;

import java.util.List;

public class MyOrderInfo {
    
	private String orderId;
	
	private String productId;
	
	private String productName;
	
	private String productCode;
	
	private String orderCode;
	
	private String smallPicture;
	
	private String linkmanName;
	
	private Integer payMoney;
	
	private String createTime;
	
	private Integer orderStatus;
	
    private Integer payStatus;
    
    private String province;

    private String city;

    private String section;

    private String streetAddress;

    private String postCode;

    private String phone;

    private String mobilePhone;
	
    private Integer payType;
    
    private Integer invoiceTitleType;
    
    private String invoiceTitle;
    
    private Integer orderPrice;
    
    private Integer orderPostageFee;
    
    private String orderRemark;
    
    @SuppressWarnings("unchecked")
	private List productionList;
    
	@SuppressWarnings("unchecked")
	public List getProductionList() {
		return productionList;
	}

	@SuppressWarnings("unchecked")
	public void setProductionList(List productionList) {
		this.productionList = productionList;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSmallPicture() {
		return smallPicture;
	}

	public void setSmallPicture(String smallPicture) {
		this.smallPicture = smallPicture;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public Integer getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getInvoiceTitleType() {
		return invoiceTitleType;
	}

	public void setInvoiceTitleType(Integer invoiceTitleType) {
		this.invoiceTitleType = invoiceTitleType;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public Integer getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Integer getOrderPostageFee() {
		return orderPostageFee;
	}

	public void setOrderPostageFee(Integer orderPostageFee) {
		this.orderPostageFee = orderPostageFee;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
}