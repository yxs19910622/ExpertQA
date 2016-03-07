package org.izhong.expert.model;

import java.io.Serializable;

public class SYS_TryDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String catalognodeid;
	private String projectname;
	
	public SYS_TryDocument() {
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
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	
}
