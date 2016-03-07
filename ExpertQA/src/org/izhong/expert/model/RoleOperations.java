package org.izhong.expert.model;

import java.io.Serializable;

public class RoleOperations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long tid;
	private long roleID;
	private long operationID;
	
	public RoleOperations() {
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public long getOperationID() {
		return operationID;
	}

	public void setOperationID(long operationID) {
		this.operationID = operationID;
	}
}
