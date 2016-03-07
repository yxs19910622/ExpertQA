package org.izhong.expert.model.survey;

import java.io.Serializable;

public class WJ_Answer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String answerId;//答案ID
	private String replayId;//回答者Id
	private String oid;//回复主题Id
	private String qSeq;//问题序号
	private String seSeq;//选项序号
	private String seValue;//选项内容
	private String remark;//备注
	
	public WJ_Answer(){
		
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getReplayId() {
		return replayId;
	}

	public void setReplayId(String replayId) {
		this.replayId = replayId;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getqSeq() {
		return qSeq;
	}

	public void setqSeq(String qSeq) {
		this.qSeq = qSeq;
	}

	public String getSeSeq() {
		return seSeq;
	}

	public void setSeSeq(String seSeq) {
		this.seSeq = seSeq;
	}

	public String getSeValue() {
		return seValue;
	}

	public void setSeValue(String seValue) {
		this.seValue = seValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
