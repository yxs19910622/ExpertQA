package org.izhong.expert.model;

import java.io.Serializable;

public class RESUDP_LawDocumentEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String documentID;
	private String documentName;
	private String entityNo;
	private String description;
	
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
	
}
