package org.izhong.expert.model;

import java.io.Serializable;

public class InitShowNumbers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String typeName;
	private int showNumber;
	
	public InitShowNumbers() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}
}
