package org.izhong.expert.abs;

import org.apache.log4j.Logger;
import org.izhong.expert.model.Operations;
import org.izhong.expert.service.RoleService;

public abstract class RoleAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected RoleService roleService;
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public abstract void operationAdd(Operations operation);

}
