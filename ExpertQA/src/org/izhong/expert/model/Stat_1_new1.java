package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Stat_1_new1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String currentuserstate;//用户状态
	private String loginname;//用户名
	private String deviceserial;//设备编号
	
	public Stat_1_new1() {
	}

	public String getCurrentuserstate() {
		return currentuserstate;
	}

	public void setCurrentuserstate(String currentuserstate) {
		this.currentuserstate = currentuserstate;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getDeviceserial() {
		return deviceserial;
	}

	public void setDeviceserial(String deviceserial) {
		this.deviceserial = deviceserial;
	}

}
