package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class RESUDP_QuestionLawRef implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String questionid;
	private String documentid;
	private String documentname;
	private String entityno;
	private String description;
	private String extensionfield1;
	private String extensionfield2;
	private String projectname;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getDocumentid() {
		return documentid;
	}
	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}
	public String getDocumentname() {
		return documentname;
	}
	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}
	public String getEntityno() {
		return entityno;
	}
	public void setEntityno(String entityno) {
		this.entityno = entityno;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
