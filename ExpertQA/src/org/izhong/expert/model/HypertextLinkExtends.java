package org.izhong.expert.model;

import java.io.Serializable;

public class HypertextLinkExtends implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String hypertextName;
	private String viewText;
	private String extendAddress;
	private String mustLogin;
	private String extensionField1;
	private String extensionField2;
	private String projectName;
	
	public HypertextLinkExtends() {
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getHypertextName() {
		return hypertextName;
	}

	public void setHypertextName(String hypertextName) {
		this.hypertextName = hypertextName;
	}

	public String getViewText() {
		return viewText;
	}

	public void setViewText(String viewText) {
		this.viewText = viewText;
	}

	public String getExtendAddress() {
		return extendAddress;
	}

	public void setExtendAddress(String extendAddress) {
		this.extendAddress = extendAddress;
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
