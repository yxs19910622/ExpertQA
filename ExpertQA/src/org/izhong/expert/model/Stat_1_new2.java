package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Stat_1_new2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int currentuserstate;//总使用时长
	private int loginname;//总操作次数
	private int deviceserial;//总使用次数
	
	public Stat_1_new2() {
	}

	public int getCurrentuserstate() {
		return currentuserstate;
	}

	public void setCurrentuserstate(int currentuserstate) {
		this.currentuserstate = currentuserstate;
	}

	public int getLoginname() {
		return loginname;
	}

	public void setLoginname(int loginname) {
		this.loginname = loginname;
	}

	public int getDeviceserial() {
		return deviceserial;
	}

	public void setDeviceserial(int deviceserial) {
		this.deviceserial = deviceserial;
	}
	

}
