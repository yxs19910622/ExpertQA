package org.izhong.expert.model;

import java.io.Serializable;

public class CatalogFullTree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String catalogNodeID;
	private String catalogNodeName;
	private String catalogID;
	private String nodeType;
	private String viewResource;
	private String editResource;
	private String saveResource;
	private String transmitResource;
	private String canCatalogSearch;
	private String canFullTextSearch;
	private String fullTextSearchResource;
	private String canShowExtensions;
	private int indexNo;
	private String extensionField1;
	private String extensionField2;
	private String projectName;
	
	public CatalogFullTree() {
	}

	public String getCatalogNodeID() {
		return catalogNodeID;
	}

	public void setCatalogNodeID(String catalogNodeID) {
		this.catalogNodeID = catalogNodeID;
	}

	public String getCatalogNodeName() {
		return catalogNodeName;
	}

	public void setCatalogNodeName(String catalogNodeName) {
		this.catalogNodeName = catalogNodeName;
	}

	public String getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(String catalogID) {
		this.catalogID = catalogID;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getViewResource() {
		return viewResource;
	}

	public void setViewResource(String viewResource) {
		this.viewResource = viewResource;
	}

	public String getEditResource() {
		return editResource;
	}

	public void setEditResource(String editResource) {
		this.editResource = editResource;
	}

	public String getSaveResource() {
		return saveResource;
	}

	public void setSaveResource(String saveResource) {
		this.saveResource = saveResource;
	}

	public String getTransmitResource() {
		return transmitResource;
	}

	public void setTransmitResource(String transmitResource) {
		this.transmitResource = transmitResource;
	}

	public String getCanCatalogSearch() {
		return canCatalogSearch;
	}

	public void setCanCatalogSearch(String canCatalogSearch) {
		this.canCatalogSearch = canCatalogSearch;
	}

	public String getCanFullTextSearch() {
		return canFullTextSearch;
	}

	public void setCanFullTextSearch(String canFullTextSearch) {
		this.canFullTextSearch = canFullTextSearch;
	}

	public String getFullTextSearchResource() {
		return fullTextSearchResource;
	}

	public void setFullTextSearchResource(String fullTextSearchResource) {
		this.fullTextSearchResource = fullTextSearchResource;
	}

	public String getCanShowExtensions() {
		return canShowExtensions;
	}

	public void setCanShowExtensions(String canShowExtensions) {
		this.canShowExtensions = canShowExtensions;
	}

	public int getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(int indexNo) {
		this.indexNo = indexNo;
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
