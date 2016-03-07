package org.izhong.expert.dao;

import org.izhong.expert.model.ClientAccessLogs;
import org.izhong.expert.model.OperationLogs;
import org.izhong.expert.model.UseAccessLogs;

public interface LogsDao {

	
	/**
	 * 取客户最后一次访问信息
	 * @param userID
	 * @return
	 * @author whz
	 */
	public UseAccessLogs qryUseLastInfo(String userID);
	
	/**
	 * 新增用户操作日志־
	 * @param operationLogs
	 * @author whz
	 */
	public void addOperation(OperationLogs operationLogs);

}
