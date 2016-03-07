package org.izhong.expert.model;

import java.io.Serializable;

public class RESUDP_LawExample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String exampleid;
	private String subject;
	private String title;
	private String example;
	private String interpretation;
	private String notes;
	private String projectname;
	
	public String getExampleid() {
		return exampleid;
	}
	public void setExampleid(String exampleid) {
		this.exampleid = exampleid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public String getInterpretation() {
		return interpretation;
	}
	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
}
