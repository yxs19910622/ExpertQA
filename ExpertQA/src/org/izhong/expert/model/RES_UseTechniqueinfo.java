package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class RES_UseTechniqueinfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String techname;
	private String techtext;
	private int indexno;
	private String extensionfield1;
	private String extensionfield2;
	private String projectname;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTechname() {
		return techname;
	}
	public void setTechname(String techname) {
		this.techname = techname;
	}
	public String getTechtext() {
		return techtext;
	}
	public void setTechtext(String techtext) {
		this.techtext = techtext;
	}
	public int getIndexno() {
		return indexno;
	}
	public void setIndexno(int indexno) {
		this.indexno = indexno;
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
