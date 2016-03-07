package org.izhong.expert.service;

import org.izhong.expert.model.OperationLogs;
import org.izhong.expert.model.UseAccessLogs;

public interface LogsService {

	
	public UseAccessLogs qryUseLastInfo(String userID);
	
	public void addOperation(OperationLogs operationLogs);

}
