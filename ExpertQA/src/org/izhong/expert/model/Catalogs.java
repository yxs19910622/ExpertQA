package org.izhong.expert.model;

import java.io.Serializable;

public class Catalogs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String catalogID;
	private String catalogName;
	private String fullCatalogName;
	private String parentCatalogID;
	private int inParentIndexNo;
	private int levelName;
	private String nodetype;
	private String extensionField1;
	private String extensionField2;
	private String projectName;
	
	public Catalogs() {
	}

	public String getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(String catalogID) {
		this.catalogID = catalogID;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getFullCatalogName() {
		return fullCatalogName;
	}

	public void setFullCatalogName(String fullCatalogName) {
		this.fullCatalogName = fullCatalogName;
	}

	public String getParentCatalogID() {
		return parentCatalogID;
	}

	public void setParentCatalogID(String parentCatalogID) {
		this.parentCatalogID = parentCatalogID;
	}

	public int getInParentIndexNo() {
		return inParentIndexNo;
	}

	public void setInParentIndexNo(int inParentIndexNo) {
		this.inParentIndexNo = inParentIndexNo;
	}

	public int getLevelName() {
		return levelName;
	}

	public void setLevelName(int levelName) {
		this.levelName = levelName;
	}

	public String getNodetype() {
		return nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
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
