package org.izhong.expert.model;

import java.io.Serializable;

public class QuestionLawRefs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String questionID;
	private String documentID;
	private String documentName;
	private String entityNo;
	private String description;
	private String extensionField1;
	private String extensionField2;
	private String projectName;
	
	public QuestionLawRefs() {
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getEntityNo() {
		return entityNo;
	}

	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
