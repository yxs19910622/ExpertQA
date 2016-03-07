package org.izhong.expert.model.survey;

import java.io.Serializable;
import java.util.Date;

public class WJ_Question implements Serializable{
	
    private static final long serialVersionUID = 1L;
	
    private String oid;//主题Id
	private String content;//信息
	private String qtype;//问题样式
	private String seq;//序号
	private String remark;//备注
	
	public WJ_Question(){
		
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
