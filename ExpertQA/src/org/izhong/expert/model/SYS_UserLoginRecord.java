package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class SYS_UserLoginRecord implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String deviceserialnumber;
	private Date logintime;
	private Date endtime;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDeviceserialnumber() {
		return deviceserialnumber;
	}
	public void setDeviceserialnumber(String deviceserialnumber) {
		this.deviceserialnumber = deviceserialnumber;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	

}
