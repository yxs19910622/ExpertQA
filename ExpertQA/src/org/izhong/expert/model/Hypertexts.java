package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Hypertexts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long tid;
	private String hypertextName;
	private String hypertextAddress;
	private String hypertextPicture;
	private String description;
	private String groupType;
	private int indexNo;
	private Date startDate;
	private Date endDate;
	
	public Hypertexts() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getHypertextName() {
		return hypertextName;
	}

	public void setHypertextName(String hypertextName) {
		this.hypertextName = hypertextName;
	}

	public String getHypertextAddress() {
		return hypertextAddress;
	}

	public void setHypertextAddress(String hypertextAddress) {
		this.hypertextAddress = hypertextAddress;
	}

	public String getHypertextPicture() {
		return hypertextPicture;
	}

	public void setHypertextPicture(String hypertextPicture) {
		this.hypertextPicture = hypertextPicture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
