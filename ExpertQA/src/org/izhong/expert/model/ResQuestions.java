package org.izhong.expert.model;

import java.io.Serializable;

public class ResQuestions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String questionID;
	private String subject;
	private String title;
	private String description;
	private String answer;
	private String referenceNotes;
	private String example;
	private String interpretation;
	private String notes;
	private String extensionField1;
	private String extensionField2;
	private String projectName;
	
	public ResQuestions() {
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
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

	public String getReferenceNotes() {
		return referenceNotes;
	}

	public void setReferenceNotes(String referenceNotes) {
		this.referenceNotes = referenceNotes;
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
