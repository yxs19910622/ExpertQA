package org.izhong.expert.model.online;

public class OrderProduction {
	
	private String orderMasterno;//			订单编号
	private String orderDetailno	;//			订单明细编号
	private String productNo	;//			产品代码
	private Integer productPrice;//			产品单价
	private Integer payPrice	;//			支付单价
	private Integer actualPrice;//			优惠后单价
	private Integer orderAmount	;//			订购数量
	private Integer orderMoney;//			订购金额
	private Integer fareMoney	;//			运费
	private Integer latefee	;//			滞纳金
	private Integer subTotal	;//			小计金额
	private String state;
	private String tid;
	public String getOrderMasterno() {
		return orderMasterno;
	}
	public void setOrderMasterno(String orderMasterno) {
		this.orderMasterno = orderMasterno;
	}
	public String getOrderDetailno() {
		return orderDetailno;
	}
	public void setOrderDetailno(String orderDetailno) {
		this.orderDetailno = orderDetailno;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
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
	public Integer getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Integer getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Integer orderMoney) {
		this.orderMoney = orderMoney;
	}
	public Integer getFareMoney() {
		return fareMoney;
	}
	public void setFareMoney(Integer fareMoney) {
		this.fareMoney = fareMoney;
	}
	public Integer getLatefee() {
		return latefee;
	}
	public void setLatefee(Integer latefee) {
		this.latefee = latefee;
	}
	public Integer getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	

}