package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class RES_UpdateTableInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int tid;
	private String tablename;
	private Date lastdate;
	private String extensionfield1;
	private String extensionfield2;
	private String projectname;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public String getExtensionfield1() {
		return extensionfield1;
	}
	public void setExtensionfield1(String extensionfield1) {
		this.extensionfield1 = extensionfield1;
	}
	public String getExtensionfield2() {
		return extensionfield2;
	}
	public void setExtensionfield2(String extensionfield2) {
		this.extensionfield2 = extensionfield2;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

}
