package org.izhong.expert.model;

import java.io.Serializable;

public class RES_QuestionExample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private String questionid;
	private String catalognodeid;
	private String catalognodename;
	private String nodetype;
	
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getCatalognodeid() {
		return catalognodeid;
	}
	public void setCatalognodeid(String catalognodeid) {
		this.catalognodeid = catalognodeid;
	}
	public String getCatalognodename() {
		return catalognodename;
	}
	public void setCatalognodename(String catalognodename) {
		this.catalognodename = catalognodename;
	}
	public String getNodetype() {
		return nodetype;
	}
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
	
}
