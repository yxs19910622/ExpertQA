package org.izhong.expert.model.survey;

import java.io.Serializable;
import java.util.Date;

public class WJ_Object implements Serializable{
	
    private static final long serialVersionUID = 1L;
	
    private String oid;//主题Id
	private String title;//标题
	private String discribe;//描述
	private Date createtime;//创建时间
	private String state;//状态
	private String anonymousFlag;//是否匿名
	private String remark;//备注
	private String uid;//创建者
	
	public WJ_Object(){
		
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAnonymousFlag() {
		return anonymousFlag;
	}

	public void setAnonymousFlag(String anonymousFlag) {
		this.anonymousFlag = anonymousFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
