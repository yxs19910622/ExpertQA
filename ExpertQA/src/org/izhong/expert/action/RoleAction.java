package org.izhong.expert.action;

import org.izhong.expert.abs.RoleAbs;

public class RoleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoleAbs roleAbs;

	public void setRoleAbs(RoleAbs roleAbs) {
		this.roleAbs = roleAbs;
	}

	@Override
	public String execute() throws Exception {
		roleAbs.operationAdd(null);
		return SUCCESS;
	}
}
