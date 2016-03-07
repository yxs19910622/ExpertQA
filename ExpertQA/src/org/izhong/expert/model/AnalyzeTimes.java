package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class AnalyzeTimes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String loginname;
	private String oid;
	private int time;
	private String sum;
	private String status;
	private String dev;
	private String allsum;
	private Date createtime;
	private String istest;
	
	public AnalyzeTimes(){
		
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getAllsum() {
		return allsum;
	}

	public void setAllsum(String allsum) {
		this.allsum = allsum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDev() {
		return dev;
	}

	public void setDev(String dev) {
		this.dev = dev;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getIstest() {
		return istest;
	}

	public void setIstest(String istest) {
		this.istest = istest;
	}

	
	
}
