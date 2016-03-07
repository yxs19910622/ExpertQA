package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class RESUDP_DocumentInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String documentid;
	private String title;
	private String creator;
	private String subject;
	private String description;
	private String publisher;
	private String contributor;
	private Date documentdate;
	private String type;
	private String format;
	private String source;
	private String identifier;
	private String language;
	private String relation;
	private String coverage;
	private String rights;
	private String md5;
	private String version;
	private String location;
	private String fileextension;
	private String deletestatus;
	private String projectname;
	
	public String getDocumentid() {
		return documentid;
	}
	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getContributor() {
		return contributor;
	}
	public void setContributor(String contributor) {
		this.contributor = contributor;
	}
	public Date getDocumentdate() {
		return documentdate;
	}
	public void setDocumentdate(Date documentdate) {
		this.documentdate = documentdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFileextension() {
		return fileextension;
	}
	public void setFileextension(String fileextension) {
		this.fileextension = fileextension;
	}
	public String getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
}
