package org.izhong.expert.model.survey;

import java.io.Serializable;
import java.util.Date;

public class WJ_Replay implements Serializable{

    private static final long serialVersionUID = 1L;
	
    private String replayId;//回复Id
	private String replayCode;//回复代码
	private String replayIp;//回复者ip
	private String oid;//主题id
	private Date replayTime;//回复时间
	private String remark;//备注
	
	public WJ_Replay(){
		
	}

	public String getReplayId() {
		return replayId;
	}

	public void setReplayId(String replayId) {
		this.replayId = replayId;
	}

	public String getReplayCode() {
		return replayCode;
	}

	public void setReplayCode(String replayCode) {
		this.replayCode = replayCode;
	}

	public String getReplayIp() {
		return replayIp;
	}

	public void setReplayIp(String replayIp) {
		this.replayIp = replayIp;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getReplayTime() {
		return replayTime;
	}

	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
