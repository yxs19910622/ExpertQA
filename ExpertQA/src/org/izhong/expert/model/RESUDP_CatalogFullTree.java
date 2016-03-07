package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class RESUDP_CatalogFullTree implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String catalognodeid;
	private String catalognodename;
	private String catalogid;
	private String nodetype;
	private String viewresource;
	private String editresource;
	private String saveresource;
	private String transmitresource;
	private String cancatalogsearch;
	private String canfulltextsearch;
	private String fulltextsearchresource;
	private String canshowextensions;
	private int indexno;
	private String extensionfield1;
	private String extensionfield2;
	private String projectname;
	
	public String getCatalognodeid() {
		return catalognodeid;
	}
	public void setCatalognodeid(String catalognodeid) {
		this.catalognodeid = catalognodeid;
	}
	public String getCatalognodename() {
		return catalognodename;
	}
	public void setCatalognodename(String catalognodename) {
		this.catalognodename = catalognodename;
	}
	public String getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(String catalogid) {
		this.catalogid = catalogid;
	}
	public String getNodetype() {
		return nodetype;
	}
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
	public String getViewresource() {
		return viewresource;
	}
	public void setViewresource(String viewresource) {
		this.viewresource = viewresource;
	}
	public String getEditresource() {
		return editresource;
	}
	public void setEditresource(String editresource) {
		this.editresource = editresource;
	}
	public String getSaveresource() {
		return saveresource;
	}
	public void setSaveresource(String saveresource) {
		this.saveresource = saveresource;
	}
	public String getTransmitresource() {
		return transmitresource;
	}
	public void setTransmitresource(String transmitresource) {
		this.transmitresource = transmitresource;
	}
	public String getCancatalogsearch() {
		return cancatalogsearch;
	}
	public void setCancatalogsearch(String cancatalogsearch) {
		this.cancatalogsearch = cancatalogsearch;
	}
	public String getCanfulltextsearch() {
		return canfulltextsearch;
	}
	public void setCanfulltextsearch(String canfulltextsearch) {
		this.canfulltextsearch = canfulltextsearch;
	}
	public String getFulltextsearchresource() {
		return fulltextsearchresource;
	}
	public void setFulltextsearchresource(String fulltextsearchresource) {
		this.fulltextsearchresource = fulltextsearchresource;
	}
	public String getCanshowextensions() {
		return canshowextensions;
	}
	public void setCanshowextensions(String canshowextensions) {
		this.canshowextensions = canshowextensions;
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
