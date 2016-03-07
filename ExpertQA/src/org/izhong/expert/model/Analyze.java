package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Analyze implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long tid;
	private String currentuserstate;
	private String operatuserstate;
	private String loginname;
	private String deviceserial;
	private String operationtype;
	private String operationarea;
	private Date createtime;
	private Date writetime;
	private int time;
	private String oid;
	private String projectname;
	private String istest;
	
	public Analyze() {
	}
	
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getCurrentuserstate() {
		return currentuserstate;
	}
	public void setCurrentuserstate(String currentuserstate) {
		this.currentuserstate = currentuserstate;
	}
	public String getOperatuserstate() {
		return operatuserstate;
	}
	public void setOperatuserstate(String operatuserstate) {
		this.operatuserstate = operatuserstate;
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
	public String getOperationtype() {
		return operationtype;
	}
	public void setOperationtype(String operationtype) {
		this.operationtype = operationtype;
	}
	public String getOperationarea() {
		return operationarea;
	}
	public void setOperationarea(String operationarea) {
		this.operationarea = operationarea;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Date getWritetime() {
		return writetime;
	}

	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}

	public String getIstest() {
		return istest;
	}

	public void setIstest(String istest) {
		this.istest = istest;
	}
}
