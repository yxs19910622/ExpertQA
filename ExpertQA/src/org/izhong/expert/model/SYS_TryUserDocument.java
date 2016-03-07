package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class SYS_TryUserDocument  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String catalognodeid;
	private String deviceserialnumber;
	private Date downloadtime;
	private String projectname;
	public SYS_TryUserDocument() {
		super();
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getCatalogNodeID() {
		return catalognodeid;
	}
	public void setCatalogNodeID(String catalogNodeID) {
		this.catalognodeid = catalogNodeID;
	}
	public String getDeviceSerialNumber() {
		return deviceserialnumber;
	}
	public void setDeviceSerialNumber(String deviceSN) {
		this.deviceserialnumber = deviceSN;
	}
	public Date getDownloadTime() {
		return downloadtime;
	}
	public void setDownloadTime(Date downloadtime) {
		this.downloadtime = downloadtime;
	}
	public String getProjectName() {
		return projectname;
	}
	public void setProjectName(String projectname) {
		this.projectname = projectname;
	}
	
}
