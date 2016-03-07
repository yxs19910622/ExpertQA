package org.izhong.expert.model;

import java.io.Serializable;

public class HypertextLinks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String hypertextName;
	private String hypertextText;
	private String viewText;
	private String hypertextAddress;
	private String hypertextTip;
	private String mustLogin;
	private String extensionField1;
	private String extensionField2;
	private String projectName;
	
	public HypertextLinks() {
	}

	public String getHypertextName() {
		return hypertextName;
	}

	public void setHypertextName(String hypertextName) {
		this.hypertextName = hypertextName;
	}

	public String getHypertextText() {
		return hypertextText;
	}

	public void setHypertextText(String hypertextText) {
		this.hypertextText = hypertextText;
	}

	public String getViewText() {
		return viewText;
	}

	public void setViewText(String viewText) {
		this.viewText = viewText;
	}

	public String getHypertextAddress() {
		return hypertextAddress;
	}

	public void setHypertextAddress(String hypertextAddress) {
		this.hypertextAddress = hypertextAddress;
	}

	public String getHypertextTip() {
		return hypertextTip;
	}

	public void setHypertextTip(String hypertextTip) {
		this.hypertextTip = hypertextTip;
	}

	public String getMustLogin() {
		return mustLogin;
	}

	public void setMustLogin(String mustLogin) {
		this.mustLogin = mustLogin;
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
