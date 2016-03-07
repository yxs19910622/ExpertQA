package org.izhong.expert.abs;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.AnalyzeTimes;
import org.izhong.expert.model.Code;
import org.izhong.expert.model.Companys;
import org.izhong.expert.model.HypertextLinkExtends;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.Operations;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.Questions;
import org.izhong.expert.model.Replys;
import org.izhong.expert.model.Roles;
import org.izhong.expert.model.SYS_AccessLog;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserProducts;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.service.AccessLogService;
import org.izhong.expert.service.ExpertService;
import org.izhong.expert.service.HyperService;
import org.izhong.expert.service.KeyWordService;
import org.izhong.expert.service.LogsService;
import org.izhong.expert.service.MessageService;
import org.izhong.expert.service.OnlinePaymentService;
import org.izhong.expert.service.OrderService;
import org.izhong.expert.service.QATypeService;
import org.izhong.expert.service.QuestionsService;
import org.izhong.expert.service.ReplysService;
import org.izhong.expert.service.RoleService;
import org.izhong.expert.service.SyncCustomerService;
import org.izhong.expert.service.UserInfoService;
import org.izhong.expert.service.UserRegisterService;

public abstract class MemberAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected RoleService roleService;
	protected UserInfoService userInfoService;
	protected QATypeService qatypeService;
	protected KeyWordService keyWordService;
	protected UserRegisterService userRegisterService;
	protected QuestionsService questionService;
	protected ReplysService replysService;
	protected ExpertService expertService;
	protected SyncCustomerService syncCustomerService;
	protected MessageService messageService;
	protected HyperService hyperService;
	protected LogsService logsService;
	protected OnlinePaymentService onlineService;
	protected OrderService orderService;
	protected AccessLogService accessLogService;
	
	public abstract List<Operations> findOperationAll();
	public abstract List<Operations> findOperationValid();
	public abstract List<Roles> findRoleAll();
	public abstract List<Roles> findRoleAllValid();
	public abstract void addRole(Roles role,String[] operation);
	public abstract String findUserRoleID(String userId);
	public abstract String initMenu(String path,String userId);
	public abstract LabUsers findLabUserInfo(String userId);
	public abstract SysUsers findSysUserInfo(String userId);
	public abstract void updateSysUserName(SysUsers sysuser);
	public abstract void updateLabUser(LabUsers labuser);
	public abstract void updateCompany(Companys company);
	public abstract String updatePassword(String userId,String oldPassword,String newPassword);
	public abstract String updatePassword2(String userId,String newPassword);
	public abstract List<LabUsers> findLabUserList(int status);
	public abstract void updateAuditUser(String userId);
	public abstract List<LabUsers> findLabUsersAll();
	public abstract void addUserProfiType(String userId,String typeId);
	public abstract void delUserProfiType(String userId,String typeId);
	public abstract String findUserProfiByUserID(String userId);
	public abstract List<QueryHotWords> findHotWordsAll();
	public abstract void updateQueryHotWord(String keyword,String type);
	public abstract void updatePlacard(String type,String value,String tid);
	public abstract String initJSONType();
	public abstract String loadJSONkeyWord();
	public abstract String initJSONRole();
	public abstract void GridHotWord(HttpServletResponse response, String startStr, String limitStr);
	public abstract void GridPlacard(HttpServletResponse response, String startStr,String limitStr);
	public abstract void GridAuditQuestion(HttpServletResponse response, String startStr, String limitStr);
	public abstract void GridHyper(HttpServletResponse response, String startStr, String limitStr);
	public abstract void GridAccountManage(HttpServletResponse response,String startStr,String limitStr,Map<String, String> paramMap);
	public abstract void GridQAManage(HttpServletResponse response,String startStr,String limitStr);
	public abstract void GridPayHistory(HttpServletResponse response,String startStr,String limitStr);
	public abstract void GridAnalyze(HttpServletResponse response,String startStr,String limitStr,String sortBy,String sortDir, Map map);
	public abstract void GridAnalyze(HttpServletResponse response,String startStr,String limitStr);
	public abstract void GridAnalyze_1(HttpServletResponse response,String startStr,String limitStr);
	public abstract void GridAnalyze_1(HttpServletResponse response,String startStr,String limitStr,String sortBy,String sortDir);
	public abstract void AddUser(SysUsers sysuser,LabUsers labuser,long roleId);
	public abstract void auditQuestion(int auditStatus,String questionId);
	public abstract void auditReply(int auditStatus,String replyId);
	public abstract List<Questions> findQuestionByUserId(String userId);
	public abstract List<Questions> findUserFavorite(String userId);
	public abstract List<Questions> findQuestionUnaudited();
	public abstract List<Questions> findQuestionPending();
	public abstract List<Replys> findReplysByUserId(String userId);
	public abstract List<Replys> findReplysUnaudited();
	public abstract List<Replys> findReplysByQuestionId(String questionId);
	public abstract Questions findQuestionById(String questionId);
	public abstract void optimalAnswer(String replyId);
	public abstract void swithQuestion(int isClosed, String questionId);
	public abstract String findAttestStatus(String userId);
	public abstract String initAjxQAType();
	public abstract void updateQuestionType(String qaType,String questionId);
	public abstract void updateUserRole(String userId);
	public abstract void updateReplyCount(String questionId);
	public abstract void updateHyper(String type,HypertextLinkExtends hle);
	public abstract void resetUserPassword(String operator,String userId,String resetPass,String ip);
	public abstract List<OrderOnlinePayRecord> selectOrderOnlinePayRecord(HashMap map);
	public abstract void delQuestion(String questionId);
	public abstract void updateUserTime(String userId,String ip,String userTimeId,String tryStart,String tryEnd,String serviceStart,String serviceEnd);
	public abstract List<Replys> getReplysAll(String questionId);
	public abstract void updateReplyForContent(Replys reply);
	public abstract List<UserProducts> getUserProductByUserId(String userId);
	public abstract void updateActivateUser(HttpServletResponse response,String userId,String activateCode);
	public abstract void addCode(Code code);
	public abstract List<Code> allCode();
	public abstract void verifiCode(HttpServletResponse response, String preferentialno);
	public abstract Map orderM(String ordermasterno);
	public abstract SysUsers getUserByEmail(String email);
	public abstract String isPay(String email);//通过邮箱获取服务结束日期
	public abstract Date getOverTime(String email);//通过邮箱获取服务结束日期
	public abstract List<SYS_AccessLog> getAccessLog();//获取所有用户原始分析数据
	public abstract List<SYS_AccessLog> getAccessLogOneDay(Timestamp date);
	public abstract List<SYS_AccessLog> getAccessLogByTime(Date date);//获取所有用户原始分析数据
	public abstract void addAnaylze(Analyze ana);//写入新的分析数据(无操作时长)
	public abstract List<Analyze> getAnalyze();
	public abstract List<Analyze> getAnalyzeByTime(Date date);
	public abstract List<String> getLoginnameAnalyze();
	public abstract void userState(Map map);
	public abstract List<String> isLoginNull(String deviceSerial);
	public abstract void changeLogin(Map map);
	
	public abstract void addAnalyzeTimes(AnalyzeTimes at);
	public abstract void GridAnalyze_1(HttpServletResponse response, String startStr,String limitStr, String sortBy, String sortDir, Map map);
	public abstract void GridStat_1(HttpServletResponse response, String startStr,String limitStr, String sortBy, String sortDir, Map map);
	public abstract void GridStat_2(HttpServletResponse response, String startStr,String limitStr, String sortBy, String sortDir, Map map);
	public abstract void GridStat_3(HttpServletResponse response, String startStr,String limitStr, String sortBy, String sortDir, Map map);

	public abstract String excel(String path);
	//	public abstract void updateSysUserServiceDate(SysUsers sysuser);
//	
//	public abstract void updateSysUserTryDate(SysUsers sysuser);
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public void setQatypeService(QATypeService qatypeService) {
		this.qatypeService = qatypeService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}
	
	public void setUserRegisterService(UserRegisterService userRegisterService) {
		this.userRegisterService = userRegisterService;
	}

	public void setQuestionService(QuestionsService questionService) {
		this.questionService = questionService;
	}

	public void setReplysService(ReplysService replysService) {
		this.replysService = replysService;
	}

	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
	}

	public void setSyncCustomerService(SyncCustomerService syncCustomerService) {
		this.syncCustomerService = syncCustomerService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setHyperService(HyperService hyperService) {
		this.hyperService = hyperService;
	}

	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}

	public void setOnlineService(OnlinePaymentService onlineService) {
		this.onlineService = onlineService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void setAccessLogService(AccessLogService accessLogService) {
		this.accessLogService = accessLogService;
	}
	
	
}
