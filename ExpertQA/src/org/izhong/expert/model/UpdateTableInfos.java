package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class UpdateTableInfos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String tableName;
	private Date lastDate;
	private String extensionField1;
	private String extensionField2;
	private String projectName;
	
	public UpdateTableInfos() {
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getExtensionField1() {
		return extensionField1;
	}

	public void setExtensionField1(String extensionField1) {
		this.extensionField1 = extensionField1;
	}

	public String getExtensionField2() {
		return extensionField2;
	}

	public void setExtensionField2(String extensionField2) {
		this.extensionField2 = extensionField2;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
