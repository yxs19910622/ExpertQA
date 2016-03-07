package org.izhong.expert.model;

import java.io.Serializable;

public class RES_UserAnnouncement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tid;
	private String messagetext;
	private String extensionlink;
	private String userid;
	private String usergroupid;
	private int indexno;;
	private String messagetype;


	private String projectname;
	
	public RES_UserAnnouncement()
	{
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getMessagetext() {
		return messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public String getExtensionlink() {
		return extensionlink;
	}

	public void setExtensionlink(String extensionlink) {
		this.extensionlink = extensionlink;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(String usergroupid) {
		this.usergroupid = usergroupid;
	}

	public int getIndexno() {
		return indexno;
	}

	public void setIndexno(int indexno) {
		this.indexno = indexno;
	}
	
	public String getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}
	
	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	
}
