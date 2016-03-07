package org.izhong.expert.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.AnalyzeTimes;
import org.izhong.expert.model.SYS_AccessLog;
import org.izhong.expert.model.Stat_1_new1;

public interface AccessLogService {
	
	/**
	 * 添加 SYS_ACCESSLOGS
	 * @param accessLog
	 */
	public void addSYS_AccessLog(SYS_AccessLog accessLog);
	
	//取出所有记录
	public List<SYS_AccessLog> getAccessLog();
		
	//取出1天的记录
	public List<SYS_AccessLog> getAccessLogOneDay(Timestamp date);
	
	//根据时间取出记录
	public List<SYS_AccessLog> getAccessLogByTime(Date date);
	
	//取出分析记录
	public List<Analyze> getAnalyze();
	
	//添加新的分析数据
	public void addAnaylze(Analyze accessLog);
	
	public List<Analyze> getAnalyzeByTime(Date date);

	public void addAnalyzeTimes(AnalyzeTimes at);

	public List<AnalyzeTimes> getAnalyze_1();

	public Long getAnalyzeSum(String name);

	public Long getgetAnalyzeSum_1(String dev);

	public Date getOvertime(String email);

	public String isPay(String email);

	public List<AnalyzeTimes> getAnalyze_1s(Map map);

	public List<Analyze> getAnalyze_s(Map map);

	public Long stat_1_headcount(Map map);

	public Long stat_1_durationcount(Map map);

	public Long stat_1_timescount(Map map);

	public List<String> getLearningContent();

	public Long getHeadByLearning(Map map);

	public Long getTimeByLearning(Map map);

	public List<String> getLoginnameAnalyze();

	public void userState(Map map);

	public List<String> isLoginNull(String deviceSerial);

	public void changeLogin(Map map);

	public Long stat_1_usecount(Map map);

	public List<Map> stat_1_headcount_new1(Map map);
	
	
}
