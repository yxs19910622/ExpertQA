package org.izhong.expert.abs;

import org.izhong.expert.model.Operations;

public class RoleAbsImpl extends RoleAbs {

	@Override
	public void operationAdd(Operations operation) {
		Operations opera = new Operations();
		opera.setOperationID(01);
		opera.setOperationName("劳动法");
//		opera.setOperationGroup("");
		opera.setUrl("/");
		opera.setDescription("劳动法相关");
		roleService.addOperation(opera);
		log.info("新增功能完毕");
	}
}
