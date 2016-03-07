package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class SYS_AccessLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String currentuserstate;
	private String operatuserstate;
	private String loginname;
	private String username;
	private String deviceserial;
	private String operationtype;
	private String operationarea;
	private Date operationdate;
	private Date createtime;
	private String projectname;
	
	public SYS_AccessLog()
	{ 
	}
	
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public String getCurrentUserState() {
		return currentuserstate;
	}
	public void setCurrentUserState(String currentuserstate) {
		this.currentuserstate = currentuserstate;
	}
	public String getOperatuserstate() {
		return operatuserstate;
	}
	public void setOperatUserState(String operatuserstate) {
		this.operatuserstate = operatuserstate;
	}
	public String getLoginName() {
		return loginname;
	}
	public void setLoginName(String loginname) {
		this.loginname = loginname;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getDeviceSerial() {
		return deviceserial;
	}
	public void setDeviceSerial(String deviceserial) {
		this.deviceserial = deviceserial;
	}
	public String getOperationType() {
		return operationtype;
	}
	public void setOperationType(String operationtype) {
		this.operationtype = operationtype;
	}
	public String getOperationArea() {
		return operationarea;
	}
	public void setOperationArea(String operationarea) {
		this.operationarea = operationarea;
	}
	public Date getOperationDate() {
		return operationdate;
	}
	public void setOperationDate(Date operationdate) {
		this.operationdate = operationdate;
	}
	public Date getCreateTime() {
		return createtime;
	}
	public void setCreateTime(Date createtime) {
		this.createtime = createtime;
	}
	public String getProjectName() {
		return projectname;
	}
	public void setProjectName(String projectname) {
		this.projectname = projectname;
	}
}
