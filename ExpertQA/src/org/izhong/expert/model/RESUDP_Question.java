package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class RESUDP_Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String questionid;
	private String subject;
	private String title;
	private String description;
	private String answer;
	private String referencenotes;
	private String example;
	private String interpretation;
	private String notes;
	private String extensionfield1;
	private String extensionfield2;
	private String projectname;
	
	public RESUDP_Question() {
	}
	
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getReferencenotes() {
		return referencenotes;
	}
	public void setReferencenotes(String referencenotes) {
		this.referencenotes = referencenotes;
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
