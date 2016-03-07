package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Code implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String userID;//用户编号
	private String preferentialno;//优惠码
	private int discountmoney;//优惠金额
	private Date startdate;//生效日期
	private Date enddate;//失效日期
	private String applicableproduct;//适用产品
	private String createno;//生成批次编号
	
	public Code() {
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPreferentialno() {
		return preferentialno;
	}

	public void setPreferentialno(String preferentialno) {
		this.preferentialno = preferentialno;
	}

	public int getDiscountmoney() {
		return discountmoney;
	}

	public void setDiscountmoney(int discountmoney) {
		this.discountmoney = discountmoney;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getApplicableproduct() {
		return applicableproduct;
	}

	public void setApplicableproduct(String applicableproduct) {
		this.applicableproduct = applicableproduct;
	}

	public String getCreateno() {
		return createno;
	}

	public void setCreateno(String createno) {
		this.createno = createno;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	
	
}
