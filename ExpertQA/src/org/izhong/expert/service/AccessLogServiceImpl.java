/**
 * 
 */
package org.izhong.expert.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.AccessLogServiceDao;
import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.AnalyzeTimes;
import org.izhong.expert.model.SYS_AccessLog;
import org.izhong.expert.model.Stat_1_new1;

public class AccessLogServiceImpl implements AccessLogService {

	private AccessLogServiceDao serviceDao;

	public void setAccessLogServiceDao(AccessLogServiceDao ServiceDao) {
		this.serviceDao = ServiceDao;
	}
	
	/* (non-Javadoc)
	 * @see org.izhong.expert.service.AccessLogService#addSYS_AccessLog(org.izhong.expert.model.SYS_AccessLog)
	 */
	@Override
	public void addSYS_AccessLog(SYS_AccessLog accessLog) {
		this.serviceDao.addSYS_AccessLog(accessLog);
	}

	@Override
	public List<SYS_AccessLog> getAccessLog() {
		return this.serviceDao.getAccessLog();
	}

	@Override
	public List<SYS_AccessLog> getAccessLogOneDay(Timestamp date) {
		return this.serviceDao.getAccessLogOneDay(date);
	}

	@Override
	public List<Analyze> getAnalyze() {
		return serviceDao.getAnalyze();
	}

	@Override
	public void addAnaylze(Analyze accessLog) {
		serviceDao.addAnaylze(accessLog);
	}


	@Override
	public List<SYS_AccessLog> getAccessLogByTime(Date date) {
		return serviceDao.getAccessLogByTime(date);
	}

	@Override
	public List<Analyze> getAnalyzeByTime(Date date) {
		return serviceDao.getAnalyzeByTime(date);
	}

	@Override
	public void addAnalyzeTimes(AnalyzeTimes at) {
		serviceDao.addAnalyzeTimes(at);
	}

	@Override
	public List<AnalyzeTimes> getAnalyze_1() {
		return serviceDao.getAnalyze_1();
	}

	@Override
	public Long getAnalyzeSum(String name) {
		return serviceDao.getAnalyzeSum(name);
	}

	@Override
	public Long getgetAnalyzeSum_1(String dev) {
		return serviceDao.getAnalyzeSum_1(dev);
	}

	@Override
	public Date getOvertime(String email) {
		return serviceDao.getOverTime(email);
	}

	@Override
	public String isPay(String email) {
		return serviceDao.isPay(email);
	}

	@Override
	public List<AnalyzeTimes> getAnalyze_1s(Map map) {
		return serviceDao.getAnalyze_1s(map);
	}

	@Override
	public List<Analyze> getAnalyze_s(Map map) {
		return serviceDao.getAnalyze_s(map);
	}

	@Override
	public Long stat_1_headcount(Map map) {
		return serviceDao.stat_1_headcount(map);
	}

	@Override
	public Long stat_1_durationcount(Map map) {
		return serviceDao.stat_1_durationcount(map);
	}

	@Override
	public Long stat_1_timescount(Map map) {
		return serviceDao.stat_1_timescount(map);
	}

	@Override
	public List<String> getLearningContent() {
		return serviceDao.getLearningContent();
	}

	@Override
	public Long getHeadByLearning(Map map) {
		return serviceDao.getHeadByLearning(map);
	}

	@Override
	public Long getTimeByLearning(Map map) {
		return serviceDao.getTimeByLearning(map);
	}

	@Override
	public List<String> getLoginnameAnalyze() {
		return serviceDao.getLoginnameAnalyze();
	}

	@Override
	public void userState(Map map) {
		serviceDao.userState(map);
	}

	@Override
	public List<String> isLoginNull(String deviceSerial) {
		return serviceDao.isLoginNull(deviceSerial);
	}

	@Override
	public void changeLogin(Map map) {
		serviceDao.changeLogin(map);
	}

	@Override
	public Long stat_1_usecount(Map map) {
		return serviceDao.stat_1_usecount(map);
	}

	@Override
	public List<Map> stat_1_headcount_new1(Map map) {
		return serviceDao.stat_1_headcount_new1(map);
	}
	
	

}
