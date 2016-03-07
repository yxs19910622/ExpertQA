package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class RESUDP_Catalog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String catalogid;
	private String catalogname;
	private String fullcatalogname;
	private String parentcatalogid;
	private int inparentindexno;
	private int levelname;
	private String nodetype;
	private String extensionfield1;
	private String extensionfield2;
	private String projectname;
	
	public String getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(String catalogid) {
		this.catalogid = catalogid;
	}
	public String getCatalogname() {
		return catalogname;
	}
	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}
	public String getFullcatalogname() {
		return fullcatalogname;
	}
	public void setFullcatalogname(String fullcatalogname) {
		this.fullcatalogname = fullcatalogname;
	}
	public String getParentcatalogid() {
		return parentcatalogid;
	}
	public void setParentcatalogid(String parentcatalogid) {
		this.parentcatalogid = parentcatalogid;
	}
	public int getInparentindexno() {
		return inparentindexno;
	}
	public void setInparentindexno(int inparentindexno) {
		this.inparentindexno = inparentindexno;
	}
	public int getLevelname() {
		return levelname;
	}
	public void setLevelname(int levelname) {
		this.levelname = levelname;
	}
	public String getNodetype() {
		return nodetype;
	}
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
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
