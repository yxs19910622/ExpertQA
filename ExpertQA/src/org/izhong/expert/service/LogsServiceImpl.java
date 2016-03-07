package org.izhong.expert.service;

import org.izhong.expert.dao.LogsDao;
import org.izhong.expert.model.ClientAccessLogs;
import org.izhong.expert.model.OperationLogs;
import org.izhong.expert.model.UseAccessLogs;

public class LogsServiceImpl implements LogsService {

	private LogsDao logsDao;

	public void setLogsDao(LogsDao logsDao) {
		this.logsDao = logsDao;
	}

	@Override
	public UseAccessLogs qryUseLastInfo(String userID) {
		return logsDao.qryUseLastInfo(userID);
	}

	@Override
	public void addOperation(OperationLogs operationLogs) {
		logsDao.addOperation(operationLogs);
	}
}
