package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class UpdateProcess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String updateIndexNo;
	private String description;
	private Date createTime;
	private String isSystemUpdate;
	private String isResourceUpdate;
	private String projectName;
	
	public UpdateProcess() {
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getUpdateIndexNo() {
		return updateIndexNo;
	}

	public void setUpdateIndexNo(String updateIndexNo) {
		this.updateIndexNo = updateIndexNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsSystemUpdate() {
		return isSystemUpdate;
	}

	public void setIsSystemUpdate(String isSystemUpdate) {
		this.isSystemUpdate = isSystemUpdate;
	}

	public String getIsResourceUpdate() {
		return isResourceUpdate;
	}

	public void setIsResourceUpdate(String isResourceUpdate) {
		this.isResourceUpdate = isResourceUpdate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
