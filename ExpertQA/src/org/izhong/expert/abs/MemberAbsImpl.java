package org.izhong.expert.abs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.AnalyzeTimes;
import org.izhong.expert.model.Code;
import org.izhong.expert.model.Companys;
import org.izhong.expert.model.ExpertReport;
import org.izhong.expert.model.HypertextLinkExtends;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.Messages;
import org.izhong.expert.model.OperationGroup;
import org.izhong.expert.model.OperationLogs;
import org.izhong.expert.model.Operations;
import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.Questions;
import org.izhong.expert.model.Replys;
import org.izhong.expert.model.RoleOperations;
import org.izhong.expert.model.Roles;
import org.izhong.expert.model.SYS_AccessLog;
import org.izhong.expert.model.Stat_1;
import org.izhong.expert.model.Stat_1_new1;
import org.izhong.expert.model.Stat_2;
import org.izhong.expert.model.Stat_3;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserProducts;
import org.izhong.expert.model.UserProficients;
import org.izhong.expert.model.UserRoles;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.model.order.OrderDetails;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.Constant;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.ExportExcel;
import org.izhong.expert.util.GridDataModel;
import org.izhong.expert.util.JsonUtil;
import org.izhong.expert.util.ServletUtil;

public class MemberAbsImpl extends MemberAbs {

	private List<Analyze> oldList = null;//存查询出的Analyze
	private String term  = null;//存查询的条件
	
	@Override
	public List<Operations> findOperationAll() {
		return roleService.qryOperationAll();
	}

	@Override
	public List<Roles> findRoleAll() {
		return roleService.qryRoleAll();
	}

	@Override
	public List<Operations> findOperationValid() {
		return roleService.qryOperationValid();
	}

	@Override
	public void addRole(Roles role, String[] operation) {
		roleService.addRole(role);
		if(operation!=null)
		{
			for (int i = 0; i < operation.length; i++) {
				RoleOperations ro = new RoleOperations();
				ro.setRoleID(role.getRoleID());
				ro.setOperationID(Integer.valueOf(operation[i]));
				roleService.addRoleOperation(ro);
			}
		}
	}

	@Override
	public String findUserRoleID(String userId) {
		return roleService.qryUserRoleID(userId);
	}

	@Override
	public String initMenu(String path,String userId) {
		StringBuilder sb = new StringBuilder();
		String roleId = findUserRoleID(userId);
		if(roleId!=null)
		{
			List<OperationGroup> lstGroup = roleService.qryOperationGroupByRoleID(Integer.valueOf(roleId));
			List<Operations> lstOperation = roleService.qryOperationByRoleID(Integer.valueOf(roleId));
			if(lstGroup!=null && lstOperation!=null)
			{
				for(int i=0;i<lstGroup.size();i++)
				{
					sb.append("<div class=\"wbgUser_menu\">");
					sb.append("<h3><span></span>"+lstGroup.get(i).getOperationGroup()+"</h3>");
					sb.append("<ul>");
					for(int j=0;j<lstOperation.size();j++)
					{
						if(lstGroup.get(i).getOperationGroupID().equals(lstOperation.get(j).getOperationGroupID()))
						{
							sb.append("<li id=\""+lstOperation.get(j).getUrl()+"\"><a href=\""+path+"/member/"+lstOperation.get(j).getUrl()+"\">"+lstOperation.get(j).getOperationName()+"</a></li>");
						}
					}
					sb.append("</ul>");
					sb.append("</div>");
				}
			}
		}
		return sb.toString();
	}

	@Override
	public LabUsers findLabUserInfo(String userId) {
		return userInfoService.qryLabUserInfo(userId);
	}

	@Override
	public SysUsers findSysUserInfo(String userId) {
		return userInfoService.qrySysUserInfo(userId);
	}

	@Override
	public void updateSysUserName(SysUsers sysuser) {
		userInfoService.modSysUserName(sysuser);
	}

	@Override
	public void updateLabUser(LabUsers labuser) {
		userInfoService.modLabUsers(labuser);
	}

	@Override
	public void updateCompany(Companys company) {
		userInfoService.modCompanys(company);
	}

	@Override
	public String updatePassword(String userId, String oldPassword,
			String newPassword) {
		SysUsers sysuser = userInfoService.qrySysUserInfo(userId);
		if(BaseUtil.Md5(oldPassword+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			sysuser.setPasswordSalt(BaseUtil.getPasswordSalt());
			sysuser.setPassword(BaseUtil.Md5(newPassword+sysuser.getPasswordSalt()));
			userInfoService.modPassWord(sysuser);
			return "密码修改成功!";
		}else{
			return "原始密码错误，请重新输入!";
		}
	}

	@Override
	public String updatePassword2(String userId, String newPassword) {
		SysUsers sysuser = userInfoService.qrySysUserInfo(userId);
		sysuser.setPasswordSalt(BaseUtil.getPasswordSalt());
		sysuser.setPassword(BaseUtil.Md5(newPassword+sysuser.getPasswordSalt()));
		userInfoService.modPassWord(sysuser);
		return "密码修改成功!";
	}

	@Override
	public List<LabUsers> findLabUserList(int status) {
		return userInfoService.qryLabUserList(status);
	}

	@Override
	public void updateAuditUser(String userId) {
		userInfoService.modAuditUser(userId);
	}

	@Override
	public List<Roles> findRoleAllValid() {
		return roleService.qryRoleAllValid();
	}

	@Override
	public List<LabUsers> findLabUsersAll() {
		return userInfoService.qryLabUsersAll();
	}

	@Override
	public String initJSONType() {
		StringBuilder sb = new StringBuilder();
		List<QATypes> lstQATypes = qatypeService.qryQATypeValid();
		if(lstQATypes!=null)
		{
			for (int i = 0; i < lstQATypes.size(); i++) {
				QATypes qatype = lstQATypes.get(i);
				if((i+1)==lstQATypes.size())
				{
					sb.append("{text:'"+qatype.getQaTypeName()+"',value:'"+qatype.getQaTypeID()+"'}");
				}else{
					sb.append("{text:'"+qatype.getQaTypeName()+"',value:'"+qatype.getQaTypeID()+"'},");
				}
			}
		}
		return sb.toString();
	}
	
	@Override
	public String loadJSONkeyWord() {
		StringBuilder sb = new StringBuilder();
		List<QueryHotWords> lstHot = keyWordService.qryHotWordsAll();
		if(lstHot!=null)
		{
			sb.append("{'total':"+lstHot.size()+", 'rows':[");
			for (int i = 0; i < lstHot.size(); i++) {
				if((i+1)==lstHot.size())
				{
					sb.append("{'keyword':'"+lstHot.get(i).getWord()+"'}");
				}else{
					sb.append("{'keyword':'"+lstHot.get(i).getWord()+"'},");
				}
			}
			sb.append("]}");
			return sb.toString();
		}else{
			return null;
		}
	}
	
	@Override
	public String initJSONRole() {
		StringBuilder sb = new StringBuilder();
		sb.append("{text:'所有',value:''}");
		List<Roles> lstRole = roleService.qryRoleAllValid();
		if(lstRole!=null)
		{	
			sb.append(",");
			for (int i = 0; i < lstRole.size(); i++) {
				if((i+1)==lstRole.size())
				{
					sb.append("{text:'"+lstRole.get(i).getRoleName()+"',value:'"+lstRole.get(i).getRoleID()+"'}");
				}else{
					sb.append("{text:'"+lstRole.get(i).getRoleName()+"',value:'"+lstRole.get(i).getRoleID()+"'},");
				}
			}
		}
		return sb.toString();
	}

	@Override
	public void addUserProfiType(String userId, String typeId) {
		qatypeService.addUserProfiType(userId, typeId);
	}

	@Override
	public void delUserProfiType(String userId, String typeId) {
		qatypeService.delUserProfiType(userId, typeId);
	}

	@Override
	public String findUserProfiByUserID(String userId) {
		StringBuilder sb = new StringBuilder();
		List<UserProficients> lstUserPro = qatypeService.qryUserProfiByUserID(userId);
		if(lstUserPro!=null)
		{
			for (int i = 0; i < lstUserPro.size(); i++) {
				if((i+1)==lstUserPro.size())
				{
					sb.append("'"+lstUserPro.get(i).getQaTypeID()+"'");
				}else{
					sb.append("'"+lstUserPro.get(i).getQaTypeID()+"',");
				}
			}
		}
		return sb.toString();
	}

	@Override
	public void updateQueryHotWord(String keyword, String type) {
		if(BaseUtil.isNotEmpty(type) && BaseUtil.isNotEmpty(keyword))
		{
			if("add".equals(type))
			{
				keyWordService.addQueryHotWord(keyword);
			}else
			if("del".equals(type)){
				keyWordService.delQueryHotWord(keyword);
			}
		}
	}
	
	@Override
	public void updatePlacard(String type,String value,String tid) {
		if(BaseUtil.isNotEmpty(type))
		{
			if("add".equals(type) && BaseUtil.isNotEmpty(value))
			{
				Messages message = new Messages();
				message.setContent(value);
				message.setStatus("0");//默认首页不显示
				messageService.addMessage(message);
			}else
			if("del".equals(type))
			{
				messageService.delMessage(Integer.valueOf(tid));
			}else
			if("status".equals(type) && BaseUtil.isNotEmpty(value))
			{
				messageService.modMessageStatus(Integer.valueOf(tid),Integer.valueOf(value));
			}
		}
	}

	@Override
	public List<QueryHotWords> findHotWordsAll() {
		return keyWordService.qryHotWordsAll();
	}

	@Override
	public void GridHotWord(HttpServletResponse response, String startStr,
			String limitStr) {
		List<QueryHotWords> lstqhw = keyWordService.qryHotWordsAll();
		if(lstqhw==null)
		{
			return;
		}
		GridDataModel<QueryHotWords> model = new GridDataModel<QueryHotWords>();
		JsonUtil.GenerateGrid(response, startStr, limitStr, lstqhw, model);
	}
	
	public void GridPlacard(HttpServletResponse response, String startStr,String limitStr)
	{
		List<Messages> lstMessage = messageService.getAllMessage();
		if(lstMessage==null)
		{
			return;
		}
		GridDataModel<Messages> model = new GridDataModel<Messages>();
	    JsonUtil.GenerateGrid(response, startStr, limitStr, lstMessage, model);
	}
	
	@Override
	public void GridAuditQuestion(HttpServletResponse response,
			String startStr, String limitStr) {
		List<Questions> lstQuestion = questionService.qryQuestionUnaudited();
		if(lstQuestion==null)
		{
			return;
		}
		GridDataModel<Questions> model = new GridDataModel<Questions>();
		JsonUtil.GenerateGrid(response, startStr, limitStr, lstQuestion, model);
	}
	
	@Override
	public void GridHyper(HttpServletResponse response, String startStr,
			String limitStr) {
		List<HypertextLinkExtends> lstHyper = hyperService.getAllHyper();
		if(lstHyper==null)
		{
			return;
		}
		
		GridDataModel<HypertextLinkExtends> model = new GridDataModel<HypertextLinkExtends>();
		JsonUtil.GenerateGrid(response, startStr, limitStr, lstHyper, model);
	}
	
	@Override
	public void GridAccountManage(HttpServletResponse response,
			String startStr, String limitStr, Map<String, String> paramMap) {
		List<SysUsers> lstSysUser = userInfoService.qrySysUsersAll(paramMap);
		if(lstSysUser==null)
		{
			return;
		}
		GridDataModel<SysUsers> model = new GridDataModel<SysUsers>();
		JsonUtil.GenerateGridsfDate(response, startStr, limitStr, lstSysUser, model);
	}
	
	@Override
	public SysUsers getUserByEmail(String email) {
		Map map = new HashMap();
		map.put("email", email);
		List<SysUsers> lstSysUser = userInfoService.qrySysUsersAll(map);
		SysUsers user = lstSysUser.get(0);
		return user;
	}
	
	@Override
	public void GridQAManage(HttpServletResponse response, String startStr,
			String limitStr) {
		List<Questions> lstQuestion = questionService.qryQuestionPending();
		if(lstQuestion==null)
		{
			return;
		}
		GridDataModel<Questions> model = new GridDataModel<Questions>();
		JsonUtil.GenerateGridsfDate(response, startStr, limitStr, lstQuestion, model);
	}

	@Override
	public void GridPayHistory(HttpServletResponse response, String startStr,
			String limitStr) {
		List<OrderDetails> lstod = orderService.getPayHistory();

		for(int i = 0;i<lstod.size();i++){
			String yinhang = lstod.get(i).getPaybank();
			if(yinhang=="ICBCB2C"||"ICBCB2C".equals(yinhang)){
				lstod.get(i).setPaybank("中国工商银行");
			}else if(yinhang=="CCB"||"CCB".equals(yinhang)){
				lstod.get(i).setPaybank("中国建设银行");
			}else if(yinhang=="ABC"||"ABC".equals(yinhang)){
				lstod.get(i).setPaybank("中国农业银行");
			}else if(yinhang=="CMB"||"CMB".equals(yinhang)){
				lstod.get(i).setPaybank("招商银行");
			}else if(yinhang=="COMM"||"COMM".equals(yinhang)){
				lstod.get(i).setPaybank("交通银行");
			}else if(yinhang=="POSTGC"||"POSTGC".equals(yinhang)){
				lstod.get(i).setPaybank("中国邮政储蓄银行");
			}else if(yinhang=="BOCB2C"||"BOCB2C".equals(yinhang)){
				lstod.get(i).setPaybank("中国银行");
			}else if(yinhang=="CEBBANK"||"CEBBANK".equals(yinhang)){
				lstod.get(i).setPaybank("中国光大银行");
			}else if(yinhang=="CITIC"||"CITIC".equals(yinhang)){
				lstod.get(i).setPaybank("中信银行");
			}else if(yinhang=="SDB"||"SDB".equals(yinhang)){
				lstod.get(i).setPaybank("深发展银行");
			}else if(yinhang=="SPDB"||"SPDB".equals(yinhang)){
				lstod.get(i).setPaybank("浦发银行");
			}else if(yinhang=="CMBC"||"CMBC".equals(yinhang)){
				lstod.get(i).setPaybank("中国民生银行");
			}else if(yinhang=="CIB"||"CIB".equals(yinhang)){
				lstod.get(i).setPaybank("兴业银行");
			}else if(yinhang=="GDB"||"GDB".equals(yinhang)){
				lstod.get(i).setPaybank("广发银行");
			}else if(yinhang=="SPABANK"||"SPABANK".equals(yinhang)){
				lstod.get(i).setPaybank("平安银行");
			}else if(yinhang=="SHRCB"||"SHRCB".equals(yinhang)){
				lstod.get(i).setPaybank("上海农商银行");
			}else if(yinhang=="SHBANK"||"SHBANK".equals(yinhang)){
				lstod.get(i).setPaybank("上海银行");
			}else if(yinhang=="NBBANK"||"NBBANK".equals(yinhang)){
				lstod.get(i).setPaybank("宁波银行");
			}else if(yinhang=="SPDBB2B"||"SPDBB2B".equals(yinhang)){
				lstod.get(i).setPaybank("浦发银行(企业)");
			}else if(yinhang=="ABCBTB"||"ABCBTB".equals(yinhang)){
				lstod.get(i).setPaybank("农业银行(企业)");
			}else if(yinhang=="CCBBTB"||"CCBBTB".equals(yinhang)){
				lstod.get(i).setPaybank("建设银行(企业)");
			}else if(yinhang=="ICBCBTB"||"ICBCBTB".equals(yinhang)){
				lstod.get(i).setPaybank("工商银行(企业)");
			}else if(yinhang=="100"||"100".equals(yinhang)){
				lstod.get(i).setPaybank("支付宝");
			}
			
			if(lstod.get(i).getPaytype()=="100"||"100".equals(lstod.get(i).getPaytype())){
				lstod.get(i).setPaytype("支付宝");
			}else if(lstod.get(i).getPaytype()=="1000"||"1000".equals(lstod.get(i).getPaytype())){
				lstod.get(i).setPaytype("网上银行");
			}
		}

		if(lstod==null){
			return;
		}
		GridDataModel<OrderDetails> model = new GridDataModel<OrderDetails>();
		JsonUtil.GenerateGrid(response, startStr, limitStr, lstod, model);
	}
	
	@Override
	public void GridAnalyze(HttpServletResponse response, String startStr,
			String limitStr) {
		List<Analyze> lstan = accessLogService.getAnalyze();
		
		
		if(lstan==null){
			return;
		}
		GridDataModel<Analyze> model = new GridDataModel<Analyze>();
		//TODO 这里有个替换,因为日期格式,暂用
		JsonUtil.GenerateGridsfDate(response, startStr, limitStr, lstan, model);
	}
	
	@Override
	public String excel(String path) {
		// TODO Auto-generated method stub
		//当用户执行打印操作的时候
        ExportExcel<Analyze> ex = new ExportExcel<Analyze>();
        String[] headers = { "","序号", "用户状态", "操作时状态", "用户名", "设备编号", "点击区域", "点击点", "操作时间", "写入时间", "操作时长", "操作序号","登录端","是否测试用户" };
        List<Analyze> dataset = new ArrayList<Analyze>();
        for(int i=0;i<oldList.size();i++){
        	dataset.add(oldList.get(i));
        }
        term = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHms");
		term = format.format(new Date())+"";
        String url = path+"xls/"+term+".xls";
        
        try {
        	OutputStream out = new FileOutputStream(url);
			ex.exportExcel(headers, dataset, out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return term+".xls";
	}
	
	@Override
	public void GridAnalyze(HttpServletResponse response, String startStr,
			String limitStr, String sortBy,String sortDir,Map map) {

		//构造当前查询条件字符串
		term = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-H-m-s");
		//term = format.format(new Date())+"--操作记录列表--查询";
		List<Analyze> lstan = null;
		String str  = (String) map.get("obj");
		String str1 = "已付费";
		String str2 = "未付费";
		String str3 = "待续费";
		String str4 = "游客";
		if(str!=null){
			if(str=="01"||"01".equals(str)){
				map.put("cs", "");
				map.put("os", str3);
				//term = term+"用户在待续费期间";
			}else if(str=="02"||"02".equals(str)){
				map.put("cs", str1);
				map.put("os", str3);
				//term = term+"付费用户在待续费期间";
			}else if(str=="03"||"03".equals(str)){
				map.put("cs", str1);
				map.put("os", "");
				//term = term+"付费用户操作期间";
			}else if(str=="04"||"04".equals(str)){
				map.put("cs", str3);
				map.put("os", str1);
				//term = term+"待续费用户在付费期间";
			}else if(str=="05"||"05".equals(str)){
				map.put("cs", "05");
				map.put("os", str2);
				//term = term+"付费用户和待续费用户在付费之前";
			}else if(str=="06"||"06".equals(str)){
				map.put("cs", str2);
				map.put("os", str2);
				//term = term+"为付费用户";
			}else if(str=="07"||"07".equals(str)){
				map.put("cs", str4);
				map.put("os", str4);
				//term = term+"游客";
			}else if(str=="08"||"08".equals(str)){
				map.put("cs", "08");
				map.put("os", str4);
				//term = term+"注册用户在注册之前";
			}
		}
//		if(map.get("zt")=="02"){
//			term = term+"--测试账户";
//		}else if(map.get("zt")=="03"){
//			term = term+"--正常用户";
//		}
//		if(map.get("t1")!=null&&map.get("t2")!=null){
//			term = term+"--时长"+map.get("t1")+map.get("t2")+"min";
//		}
//		if(map.get("sd")!=null&&map.get("ed")!=null){
//			term = term+"--在"+format.format(map.get("sd"))+"和"+format.format(map.get("sd"))+"之间";
//		}
//		
//		term = term+"的查询结果";
		
		
		lstan = accessLogService.getAnalyze_s(map);
		oldList = lstan;//每次查询后存上结果,供导出excel时使用
		if(lstan==null){
			return;
		}
		
		
		GridDataModel<Analyze> model = new GridDataModel<Analyze>();
		//TODO 这里有个替换,因为日期格式,暂用 已经过全局排序
		JsonUtil.GenerateGridsfDate(response, startStr, limitStr, lstan, model,sortBy,sortDir);
		
	}
	
	@Override
	public void GridAnalyze_1(HttpServletResponse response, String startStr,
			String limitStr) {
		List<AnalyzeTimes> lstan = accessLogService.getAnalyze_1();
		
		if(lstan==null){
			return;
		}
		String name = null;
		for(int i=0;i<lstan.size();i++){
			name = lstan.get(i).getLoginname();
			Long sum = accessLogService.getAnalyzeSum(name);
			lstan.get(i).setAllsum(Long.toString(sum));
		}
		
		GridDataModel<Analyze> model = new GridDataModel<Analyze>();
		//TODO 这里有个替换,因为日期格式,暂用
		JsonUtil.GenerateGridsfDate(response, startStr, limitStr, lstan, model);
	}
	
	public void GridAnalyze_1(HttpServletResponse response, String startStr,
			String limitStr, String sortBy,String sortDir) {
		List<AnalyzeTimes> lstan = accessLogService.getAnalyze_1();
		
		if(lstan==null){
			return;
		}
		String name = null;
		for(int i=0;i<lstan.size();i++){
			name = lstan.get(i).getLoginname();
			Long sum = accessLogService.getAnalyzeSum(name);
			lstan.get(i).setAllsum(Long.toString(sum));
		}
		
		
		GridDataModel<Analyze> model = new GridDataModel<Analyze>();
		//TODO 这里有个替换,因为日期格式,暂用
		JsonUtil.GenerateGridsfDate_1(response, startStr, limitStr, lstan, model,sortBy,sortDir);
	}
	
	public void GridAnalyze_1(HttpServletResponse response, String startStr,
			String limitStr, String sortBy,String sortDir,Map map) {
		
		String str  = (String) map.get("obj");
		String str1 = "已付费";
		String str2 = "未付费";
		String str3 = "待续费";
		String str4 = "游客";
		if(str!=null){
			if(str=="01"||"01".equals(str)){
				map.put("cs", "");
				map.put("os", str3);
			}else if(str=="02"||"02".equals(str)){
				map.put("cs", str1);
				map.put("os", str3);
			}else if(str=="03"||"03".equals(str)){
				map.put("cs", str1);
				map.put("os", "");
			}else if(str=="04"||"04".equals(str)){
				map.put("cs", str3);
				map.put("os", str1);
			}else if(str=="05"||"05".equals(str)){
				map.put("cs", "05");
				map.put("os", str2);
			}else if(str=="06"||"06".equals(str)){
				map.put("cs", str2);
				map.put("os", str2);
			}else if(str=="07"||"07".equals(str)){
				map.put("cs", str4);
				map.put("os", str4);
			}else if(str=="08"||"08".equals(str)){
				map.put("cs", "08");
				map.put("os", str4);
			}
		}
		
		List<AnalyzeTimes> lstan = accessLogService.getAnalyze_1s(map);
		
		if(lstan==null){
			return;
		}
		/*String name = null;
		for(int i=0;i<lstan.size();i++){
			name = lstan.get(i).getLoginname();
			Long sum = accessLogService.getAnalyzeSum(name);
			lstan.get(i).setAllsum(Long.toString(sum));
		}*/
		
		GridDataModel<Analyze> model = new GridDataModel<Analyze>();
		//TODO 这里有个替换,因为日期格式,暂用
		JsonUtil.GenerateGridsfDate_1(response, startStr, limitStr, lstan, model,sortBy,sortDir);
	}
	

	@Override
	public void AddUser(SysUsers sysuser, LabUsers labuser,long roleId) {
		sysuser.setUserID(BaseUtil.generateIdentifier());
		sysuser.setPasswordSalt(BaseUtil.getPasswordSalt());
		sysuser.setPassword(BaseUtil.Md5(sysuser.getPassword()+sysuser.getPasswordSalt()));
		sysuser.setActiveStatus("1");//默认已审核״̬
		sysuser.setTryStartDate(DateUtil.getCurrTime());
		sysuser.setTryEndDate(DateUtil.getServiceEnd(sysuser.getTryStartDate()));
		
		Companys company = labuser.getCompany();
		company.setCompanyID(BaseUtil.generateIdentifier());
		
		labuser.setUserID(sysuser.getUserID());
		labuser.setCompanyID(company.getCompanyID());
		labuser.setRegisterDate(DateUtil.getCurrTime());
		labuser.setMobile(sysuser.getMobile());
		labuser.setEmail(sysuser.getEmail());
		
		UserRoles userRole = new UserRoles();
		userRole.setUserID(sysuser.getUserID());
		userRole.setRoleID(roleId);
		
		ExpertReport expertReport = new ExpertReport(sysuser.getUserID(), 0, 0, 0, 0);
		userRegisterService.addSysUser(sysuser);
		userRegisterService.addCompany(company);
		userRegisterService.addLabUser(labuser);
		roleService.addUserRole(userRole);
		expertService.addExpertReport(expertReport);
	}

	@Override
	public void auditQuestion(int auditStatus,String questionId) {
		questionService.verifyQuestion(auditStatus,questionId);
	}
	
	@Override
	public void auditReply(int auditStatus,String replyId) {
		replysService.verifyReply(auditStatus,replyId);
	}

	@Override
	public List<Questions> findQuestionByUserId(String userId) {
		return questionService.qryQuestionByUserId(userId);
	}

	@Override
	public List<Questions> findUserFavorite(String userId) {
		return questionService.qryUserFavorite(userId);
	}
	
	@Override
	public List<Questions> findQuestionUnaudited() {
		return questionService.qryQuestionUnaudited();
	}

	@Override
	public List<Replys> findReplysByUserId(String userId) {
		return replysService.qryReplysByUserId(userId);
	}

	@Override
	public List<Replys> findReplysUnaudited() {
		return replysService.qryReplysUnaudited();
	}

	@Override
	public List<Questions> findQuestionPending() {
		return questionService.qryQuestionPending();
	}

	@Override
	public List<Replys> findReplysByQuestionId(String questionId) {
		return replysService.qryReplysByQuestionId(questionId);
	}

	@Override
	public Questions findQuestionById(String questionId) {
		return questionService.qryQuestionById(questionId);
	}

	@Override
	public void optimalAnswer(String replyId) {
		replysService.optimalAnswer(replyId);
	}

	@Override
	public void swithQuestion(int isClosed, String questionId) {
		questionService.swithQuestion(isClosed, questionId);
	}

	@Override
	public String findAttestStatus(String userId) {
		SysUsers sysuser = userInfoService.qrySysUserInfo(userId);
		if(sysuser.getServiceStartDate()!=null)
		{
			if(DateUtil.getCurrTime().before(sysuser.getServiceEndDate()))
			{
				return "已认证,"+DateUtil.formatShortDate(sysuser.getServiceEndDate())+"到期";
			}
			
		}
		
		if(sysuser.getTryStartDate()!=null)
		{
			if(DateUtil.getCurrTime().before(sysuser.getTryEndDate()))
			{
				return "试用用户,"+DateUtil.formatDate(sysuser.getTryEndDate())+"到期";
			}
		}
		return "未认证,在线提问功能不可用";
	}

	@Override
	public String initAjxQAType() {
		List<QATypes> lstQaType = qatypeService.qryQATypeValid();
		StringBuilder sb = new StringBuilder();
		if(lstQaType!=null)
		{
			for (int i = 0; i < lstQaType.size(); i++) {
				QATypes qaType = lstQaType.get(i);
				if("0".equals(qaType.getParentTypeID()))
				{
					sb.append("{id:'"+qaType.getQaTypeID()+"',text:'"+qaType.getQaTypeName()+"'}");
				}else{
					sb.append("{id:'"+qaType.getQaTypeID()+"',pid:'"+qaType.getParentTypeID()+"',text:'"+qaType.getQaTypeName()+"'}");
				}
				if(i+1!=lstQaType.size())
				{
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}

	@Override
	public void updateQuestionType(String qaType, String questionId) {
		questionService.modQuestionType(qaType, questionId);
	}

	@Override
	public void updateUserRole(String userId) {
		UserRoles userRole = new UserRoles();
		userRole.setUserID(userId);
		userRole.setRoleID(Constant.ATTESTUSER);
		roleService.modUserRole(userRole);
	}

	@Override
	public void updateReplyCount(String questionId) {
		questionService.modReplyCount(questionId);
	}

	@Override
	public void updateHyper(String type, HypertextLinkExtends hle) {
		if(BaseUtil.isNotEmpty(type) && hle!=null)
		{
			if("add".equals(type))
			{
				hle.setHypertextName("HYPERTEXT_TRUNDLEADVERTAREA");
				hle.setProjectName("劳动法");
				if(null!=hle.getMustLogin() && "on".equals(hle.getMustLogin()))
				{
					hle.setMustLogin("TRUE");
				}else{
					hle.setMustLogin("FALSE");
				}
				hyperService.addHyper(hle);
			}else
			if("mod".equals(type))
			{
				if(null!=hle.getMustLogin() && "on".equals(hle.getMustLogin()))
				{
					hle.setMustLogin("TRUE");
				}else{
					hle.setMustLogin("FALSE");
				}
				hyperService.modHyper(hle);
			}else
			if("del".equals(type))
			{
				hyperService.delHyper(hle.getTid());
			}
		}
	}
	
	@Override
	public void resetUserPassword(String operator, String userId,
			String resetPass,String ip) {
		if(BaseUtil.isEmpty(operator) || BaseUtil.isEmpty(userId) || BaseUtil.isEmpty(resetPass))
		{
			return;
		}
		SysUsers sysuser = userInfoService.qrySysUserInfo(userId);
		if(sysuser!=null)
		{
			OperationLogs log = new OperationLogs();
			log.setOperator(operator);
			log.setOperationTime(DateUtil.getCurrTime());
			log.setIpAddress(ip);
			log.setOperationText("重置密码");
			log.setOperationNotes("用户ID："+userId+",用户上次密码为:"+sysuser.getPassword()+","+sysuser.getPasswordSalt());
			logsService.addOperation(log);
			
			sysuser.setPasswordSalt(BaseUtil.getPasswordSalt());
			sysuser.setPassword(BaseUtil.Md5(resetPass+sysuser.getPasswordSalt()));
			userInfoService.resetPassword(sysuser);
		}
	}
	public List<OrderOnlinePayRecord> selectOrderOnlinePayRecord(HashMap map){
		return this.onlineService.selectOrderOnlinePayRecord(map);
	}

	@Override
	public void delQuestion(String questionId) {
		questionService.delQuestion(questionId);
	}

	@Override
	public void updateUserTime(String userId, String ip, String userTimeId,
			String tryStart, String tryEnd, String serviceStart,
			String serviceEnd) {
		SysUsers userTime = new SysUsers();
		userTime.setUserID(userTimeId);
		String note = "修改["+userTimeId+"]客户";
		if(BaseUtil.isNotEmpty(tryStart) && BaseUtil.isNotEmpty(tryEnd))
		{
			userTime.setTryStartDate(DateUtil.formatStrToDate(tryStart));
			userTime.setTryEndDate(DateUtil.formatStrToDate(tryEnd));
			userInfoService.modSysUserTryDate(userTime);
			note+="试用日期";
		}
		if(BaseUtil.isNotEmpty(serviceStart) && BaseUtil.isNotEmpty(serviceEnd))
		{
			userTime.setServiceStartDate(DateUtil.formatStrToDate(serviceStart));
			userTime.setServiceEndDate(DateUtil.formatStrToDate(serviceEnd));
			userInfoService.modSysUserServiceDate(userTime);
			note+="服务日期";
		}
		OperationLogs logs = new OperationLogs("管理操作", userId, DateUtil.getCurrTime(), note, ip);
		logsService.addOperation(logs);
	}

	@Override
	public List<Replys> getReplysAll(String questionId) {
		return replysService.qryReplysAll(questionId);
	}

	@Override
	public void updateReplyForContent(Replys reply) {
		replysService.modReplyForContent(reply);
	}
	
	@Override
	public List<UserProducts> getUserProductByUserId(String userId) {
		return userInfoService.getUserProductByUserId(userId);
	}

	@Override
	public void updateActivateUser(HttpServletResponse response,String userId, String activateCode) {
		UserProducts up = userInfoService.getUserProductByCode(activateCode);
		if(up==null){
			ServletUtil.writerToClient(response, "激活码错误！请重新输入");
			return;
		}
		if(BaseUtil.isNotEmpty(up.getActiveUser())){
			ServletUtil.writerToClient(response, "该激活码已被使用！");
			return;
		}
		List<UserProducts> lstup = userInfoService.getUserProductsByProNo(up.getProductNo(), userId);
		for (int i = 0; i < lstup.size(); i++) {
			if(DateUtil.getCurrTime().before(lstup.get(i).getServiceEndDate())){
				ServletUtil.writerToClient(response, "您的激活码还在有效期内，请勿重复激活！");
				return;
			}
		}
		UserProducts userProduct = new UserProducts();
		userProduct.setActiveCode(activateCode);
		userProduct.setServiceStartDate(DateUtil.getCurrTime());
		userProduct.setServiceEndDate(DateUtil.addYears(userProduct.getServiceStartDate(), 1));
		userProduct.setActiveUser(userId);
		userProduct.setActiveDate(DateUtil.getCurrTime());
		userInfoService.updateUserProduct(userProduct);
		if(up.getProductNo().equals("P0002") || up.getProductNo().equals("P0004")){
			UserRoles userRole = new UserRoles();
			userRole.setUserID(userId);
			userRole.setRoleID(Constant.ATTESTUSER);
			roleService.modUserRole(userRole);
		}
		userInfoService.delUserAnnouncement(userId, "USERTRYTYPE");
		ServletUtil.writerToClient(response, "恭喜您，账户激活成功!请重新登录账户！");
	}

	@Override
	public void addCode(Code code) {
		orderService.addCode(code);
		
	}

	@Override
	public List<Code> allCode() {
		return orderService.allCode();
	}

	@Override
	public void verifiCode(HttpServletResponse response, String preferentialno) {
		int count = orderService.verifiCode(preferentialno);
		ServletUtil.writerToClient(response, Boolean.toString((count==0?true:false)));
	}

	@Override
	public Map orderM(String ordermasterno) {
		return null;
	}

	@Override
	public List<SYS_AccessLog> getAccessLog() {
		return accessLogService.getAccessLog();
	}

	@Override
	public void addAnaylze(Analyze accessLog) {
		accessLogService.addAnaylze(accessLog);
	}

	@Override
	public List<SYS_AccessLog> getAccessLogByTime(Date date) {
		return accessLogService.getAccessLogByTime(date);
	}

	@Override
	public List<SYS_AccessLog> getAccessLogOneDay(Timestamp date) {
		return accessLogService.getAccessLogOneDay(date);
	}

	@Override
	public List<Analyze> getAnalyze() {
		// TODO Auto-generated method stub
		return accessLogService.getAnalyze();
	}

	@Override
	public List<Analyze> getAnalyzeByTime(Date date) {
		return accessLogService.getAnalyzeByTime(date);
	}

	@Override
	public void addAnalyzeTimes(AnalyzeTimes at) {
		accessLogService.addAnalyzeTimes(at);
	}

	@Override
	public Date getOverTime(String email) {
		return accessLogService.getOvertime(email);
	}

	@Override
	public String isPay(String email) {
		return accessLogService.isPay(email);
	}

	@Override
	public void GridStat_1(HttpServletResponse response, String startStr,
			String limitStr, String sortBy, String sortDir, Map map) {
		if(map.get("category")!=null&&!("".equals(map.get("category")))){
			//表内查询1
			List<Map> lstan = new ArrayList<Map>();
			List<Stat_1_new1> lstan1 = new ArrayList<Stat_1_new1>();
			if(map.get("category")=="用户在待续费期间"||"用户在待续费期间".equals(map.get("category"))){
				map.put("cs", "");
				map.put("os", "待续费");
			}else if(map.get("category")=="付费用户在待续费期间"||"付费用户在待续费期间".equals(map.get("category"))){
				map.put("cs", "已付费");
				map.put("os", "待续费");
			}else if(map.get("category")=="用户付费期间"||"用户付费期间".equals(map.get("category"))){
				map.put("cs", "已付费");
				map.put("os", "");
			}else if(map.get("category")=="待续费用户在付费期间"||"待续费用户在付费期间".equals(map.get("category"))){
				map.put("cs", "待续费");
				map.put("os", "已付费");
			}else if(map.get("category")=="付费用户和待续费用户在付费之前"||"付费用户和待续费用户在付费之前".equals(map.get("category"))){
				map.put("cs", "05");
				map.put("os", "未付费");
			}else if(map.get("category")=="未付费用户"||"未付费用户".equals(map.get("category"))){
				map.put("cs", "未付费");
				map.put("os", "未付费");
			}else if(map.get("category")=="游客"||"游客".equals(map.get("category"))){
				map.put("cs", "游客");
				map.put("os", "游客");
				map.put("yk", "游客");
			}else if(map.get("category")=="注册客户在注册之前"||"注册客户在注册之前".equals(map.get("category"))){
				map.put("cs", "08");
				map.put("os", "游客");
			}
			lstan = accessLogService.stat_1_headcount_new1(map);
			String str = "";
			for(int i=0;i<lstan.size();i++){
				if(!str.contains((String) lstan.get(i).get("LOGINNAME"))){
					Stat_1_new1 s = new Stat_1_new1();
					s.setCurrentuserstate((String) lstan.get(i).get("CURRENTUSERSTATE"));
					s.setDeviceserial((String) lstan.get(i).get("DEVICESERIAL"));
					s.setLoginname((String) lstan.get(i).get("LOGINNAME"));
					lstan1.add(s);
				}
				if((String) lstan.get(i).get("LOGINNAME")!=" "&&!(" ".equals((String) lstan.get(i).get("LOGINNAME")))){
					str = str+(String) lstan.get(i).get("LOGINNAME");
				}
			}
			GridDataModel<Stat_1_new1> model = new GridDataModel<Stat_1_new1>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_1(response, startStr, limitStr, lstan1, model,sortBy,sortDir);
		}else if(map.get("loginname")!=null&&!("".equals(map.get("loginname")))){
			//表内查询2
			if(map.get("loginname")==" "||" ".equals(map.get("loginname"))){
				map.put("loginname", "snake");
			}
			Long t1 = accessLogService.stat_1_durationcount(map);//总使用时长
			Long t2 = accessLogService.stat_1_timescount(map);
			Long t3 = accessLogService.stat_1_usecount(map);
			Stat_1 stat_1 = new Stat_1();
			stat_1.setDurationcount(new Long(t1).intValue());
			stat_1.setTimescount(new Long(t2).intValue());
			stat_1.setUsecount(new Long(t3).intValue());
			List<Stat_1> lstan = new ArrayList<Stat_1>();
			lstan.add(stat_1);
			GridDataModel<Stat_1> model = new GridDataModel<Stat_1>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_1(response, startStr, limitStr, lstan, model,sortBy,sortDir);
		
		}else{
			List<Stat_1> lstan = new ArrayList<Stat_1>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = null;
			Date date2 = null;
			if(map.get("sd")!=null&&map.get("ed")!=null){
				try {
					date1 = sdf.parse((String) map.get("sd"));
					date2 = sdf.parse((String) map.get("ed"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Map map1 = new HashMap();
			    map1.put("cs", "");
			    map1.put("os", "待续费");
				map1.put("sd", date1);
				map1.put("ed", date2);
				map1.put("zt", (String) map.get("zt"));
			Map map2 = new HashMap();
				map2.put("cs", "已付费");
				map2.put("os", "待续费");
				map2.put("sd", date1);
				map2.put("ed", date2);
				map2.put("zt", (String) map.get("zt"));
			Map map3 = new HashMap();
				map3.put("cs", "已付费");
				map3.put("os", "");
				map3.put("sd", date1);
				map3.put("ed", date2);
				map3.put("zt", (String) map.get("zt"));
			Map map4 = new HashMap();
				map4.put("cs", "待续费");
				map4.put("os", "已付费");
				map4.put("sd", date1);
				map4.put("ed", date2);
				map4.put("zt", (String) map.get("zt"));
			Map map5 = new HashMap();
				map5.put("cs", "05");
				map5.put("os", "未付费");
				map5.put("sd", date1);
				map5.put("ed", date2);
				map5.put("zt", (String) map.get("zt"));
			Map map6 = new HashMap();
				map6.put("cs", "未付费");
				map6.put("os", "未付费");
				map6.put("sd", date1);
				map6.put("ed", date2);
				map6.put("zt", (String) map.get("zt"));
			Map map7 = new HashMap();
				map7.put("cs", "游客");
				map7.put("os", "游客");
				map7.put("yk", "游客");
				map7.put("sd", date1);
				map7.put("ed", date2);
				map7.put("zt", (String) map.get("zt"));
			Map map8 = new HashMap();
				map8.put("cs", "08");
				map8.put("os", "游客");
				map8.put("sd", date1);
				map8.put("ed", date2);
				map8.put("zt", (String) map.get("zt"));
			
			Stat_1 s1 = new Stat_1();//第一个实体
			Long t11 = accessLogService.stat_1_headcount(map1);
			Long t12 = accessLogService.stat_1_durationcount(map1);
			Long t13 = accessLogService.stat_1_timescount(map1);
			s1.setHeadcount(new Long(t11).intValue());
			if(t11!=0){
				s1.setDurationcount(new Long(t12).intValue());
				s1.setAvgduration(new Long(t12).intValue()/new Long(t11).intValue());
				s1.setTimescount(new Long(t13).intValue());
				s1.setAvgtimes(new Long(t13).intValue()/new Long(t11).intValue());
			}else{
				s1.setDurationcount(0);
				s1.setAvgduration(0);
				s1.setTimescount(0);
				s1.setAvgtimes(0);
			}
			//5个值取来仨了 剩下两个算出来 放实体里在放list里显示出来
			s1.setCategory("用户在待续费期间");
			
			Stat_1 s2 = new Stat_1();//第2个实体
			Long t21 = accessLogService.stat_1_headcount(map2);
			Long t22 = accessLogService.stat_1_durationcount(map2);
			Long t23 = accessLogService.stat_1_timescount(map2);
			
			s2.setCategory("付费用户在待续费期间");
			s2.setHeadcount(new Long(t21).intValue());
			if(t21!=0){
				s2.setDurationcount(new Long(t22).intValue());
				s2.setAvgduration(new Long(t22).intValue()/new Long(t21).intValue());
				s2.setTimescount(new Long(t23).intValue());
				s2.setAvgtimes(new Long(t23).intValue()/new Long(t21).intValue());
			}else{
				s2.setDurationcount(0);
				s2.setAvgduration(0);
				s2.setTimescount(0);
				s2.setAvgtimes(0);
			}
			
			Stat_1 s3 = new Stat_1();//第3个实体
			Long t31 = accessLogService.stat_1_headcount(map3);
			Long t32 = accessLogService.stat_1_durationcount(map3);
			Long t33 = accessLogService.stat_1_timescount(map3);
			
			s3.setCategory("用户付费期间");
			s3.setHeadcount(new Long(t31).intValue());
			if(t31!=0){
				s3.setDurationcount(new Long(t32).intValue());
				s3.setAvgduration(new Long(t32).intValue()/new Long(t31).intValue());
				s3.setTimescount(new Long(t33).intValue());
				s3.setAvgtimes(new Long(t33).intValue()/new Long(t31).intValue());
			}else{
				s3.setDurationcount(0);
				s3.setAvgduration(0);
				s3.setTimescount(0);
				s3.setAvgtimes(0);
			}
			
			Stat_1 s4 = new Stat_1();//第4个实体
			Long t41 = accessLogService.stat_1_headcount(map4);
			Long t42 = accessLogService.stat_1_durationcount(map4);
			Long t43 = accessLogService.stat_1_timescount(map4);
			
			s4.setCategory("待续费用户在付费期间");
			s4.setHeadcount(new Long(t41).intValue());
			if(t41!=0){
				s4.setDurationcount(new Long(t42).intValue());
				s4.setAvgduration(new Long(t42).intValue()/new Long(t41).intValue());
				s4.setTimescount(new Long(t43).intValue());
				s4.setAvgtimes(new Long(t43).intValue()/new Long(t41).intValue());
			}else{
				s4.setDurationcount(0);
				s4.setAvgduration(0);
				s4.setTimescount(0);
				s4.setAvgtimes(0);
			}
			
			Stat_1 s5 = new Stat_1();//第5个实体
			Long t51 = accessLogService.stat_1_headcount(map5);
			Long t52 = accessLogService.stat_1_durationcount(map5);
			Long t53 = accessLogService.stat_1_timescount(map5);
			
			s5.setCategory("付费用户和待续费用户在付费之前");
			s5.setHeadcount(new Long(t51).intValue());
			if(t51!=0){
				s5.setDurationcount(new Long(t52).intValue());
				s5.setAvgduration(new Long(t52).intValue()/new Long(t51).intValue());
				s5.setTimescount(new Long(t53).intValue());
				s5.setAvgtimes(new Long(t53).intValue()/new Long(t51).intValue());
			}else{
				s5.setDurationcount(0);
				s5.setAvgduration(0);
				s5.setTimescount(0);
				s5.setAvgtimes(0);
			}
			
			Stat_1 s6 = new Stat_1();//第6个实体
			Long t61 = accessLogService.stat_1_headcount(map6);
			Long t62 = accessLogService.stat_1_durationcount(map6);
			Long t63 = accessLogService.stat_1_timescount(map6);
			
			s6.setCategory("未付费用户");
			s6.setHeadcount(new Long(t61).intValue());
			if(t61!=0){
				s6.setDurationcount(new Long(t62).intValue());
				s6.setAvgduration(new Long(t62).intValue()/new Long(t61).intValue());
				s6.setTimescount(new Long(t63).intValue());
				s6.setAvgtimes(new Long(t63).intValue()/new Long(t61).intValue());
			}else{
				s6.setDurationcount(0);
				s6.setAvgduration(0);
				s6.setTimescount(0);
				s6.setAvgtimes(0);
			}
			
			Stat_1 s7 = new Stat_1();//第7个实体
			Long t71 = accessLogService.stat_1_headcount(map7);
			Long t72 = accessLogService.stat_1_durationcount(map7);
			Long t73 = accessLogService.stat_1_timescount(map7);
			
			s7.setCategory("游客");
			s7.setHeadcount(new Long(t71).intValue());
			if(t71!=0){
				s7.setDurationcount(new Long(t72).intValue());
				s7.setAvgduration(new Long(t72).intValue()/new Long(t71).intValue());
				s7.setTimescount(new Long(t73).intValue());
				s7.setAvgtimes(new Long(t73).intValue()/new Long(t71).intValue());
			}else{
				s7.setDurationcount(0);
				s7.setAvgduration(0);
				s7.setTimescount(0);
				s7.setAvgtimes(0);
			}
			
			Stat_1 s8 = new Stat_1();//第8个实体
			Long t81 = accessLogService.stat_1_headcount(map8);
			Long t82 = accessLogService.stat_1_durationcount(map8);
			Long t83 = accessLogService.stat_1_timescount(map8);
			
			s8.setCategory("注册客户在注册之前");
			s8.setHeadcount(new Long(t81).intValue());
			if(t81!=0){
				s8.setDurationcount(new Long(t82).intValue());
				s8.setAvgduration(new Long(t82).intValue()/new Long(t81).intValue());
				s8.setTimescount(new Long(t83).intValue());
				s8.setAvgtimes(new Long(t83).intValue()/new Long(t81).intValue());
			}else{
				s8.setDurationcount(0);
				s8.setAvgduration(0);
				s8.setTimescount(0);
				s8.setAvgtimes(0);
			}
			
			//总使用次数(usecount)和次平均操作次数(avguse)
			Long t14 = accessLogService.stat_1_usecount(map1);
			s1.setUsecount(new Long(t14).intValue());
			if(t11!=0){
				s1.setAvguse(s1.getTimescount()/s1.getUsecount());
				s1.setAvgusetime(s1.getDurationcount()/s1.getUsecount());
			}else{
				s1.setAvguse(0);
				s1.setAvgusetime(0);
			}
			
			Long t24 = accessLogService.stat_1_usecount(map2);
			s2.setUsecount(new Long(t24).intValue());
			
			if(t21!=0){
				s2.setAvguse(s2.getTimescount()/s2.getUsecount());
				s2.setAvgusetime(s2.getDurationcount()/s2.getUsecount());
			}else{
				s2.setAvguse(0);
				s2.setAvgusetime(0);
			}
			
			Long t34 = accessLogService.stat_1_usecount(map3);
			s3.setUsecount(new Long(t34).intValue());
			
			if(t31!=0){
				s3.setAvguse(s3.getTimescount()/s3.getUsecount());
				s3.setAvgusetime(s3.getDurationcount()/s3.getUsecount());
			}else{
				s3.setAvguse(0);
				s3.setAvgusetime(0);
			}
			
			Long t44 = accessLogService.stat_1_usecount(map4);
			s4.setUsecount(new Long(t44).intValue());
			
			if(t41!=0){
				s4.setAvguse(s4.getTimescount()/s4.getUsecount());
				s4.setAvgusetime(s4.getDurationcount()/s4.getUsecount());
			}else{
				s4.setAvguse(0);
				s4.setAvgusetime(0);
			}
			
			Long t54 = accessLogService.stat_1_usecount(map5);
			s5.setUsecount(new Long(t54).intValue());
			
			if(t51!=0){
				s5.setAvguse(s5.getTimescount()/s5.getUsecount());
				s5.setAvgusetime(s5.getDurationcount()/s5.getUsecount());
			}else{
				s5.setAvguse(0);
				s5.setAvgusetime(0);
			}
			
			Long t64 = accessLogService.stat_1_usecount(map6);
			s6.setUsecount(new Long(t64).intValue());
			
			if(t61!=0){
				s6.setAvguse(s6.getTimescount()/s6.getUsecount());
				s6.setAvgusetime(s6.getDurationcount()/s6.getUsecount());
			}else{
				s6.setAvguse(0);
				s6.setAvgusetime(0);
			}
			
			Long t74 = accessLogService.stat_1_usecount(map7);
			s7.setUsecount(new Long(t74).intValue());
			
			if(t71!=0){
				s7.setAvguse(s7.getTimescount()/s7.getUsecount());
				s7.setAvgusetime(s7.getDurationcount()/s7.getUsecount());
			}else{
				s7.setAvguse(0);
				s7.setAvgusetime(0);
			}
			
			Long t84 = accessLogService.stat_1_usecount(map8);
			s8.setUsecount(new Long(t84).intValue());
			
			if(t81!=0){
				s8.setAvguse(s8.getTimescount()/s8.getUsecount());
				s8.setAvgusetime(s8.getDurationcount()/s8.getUsecount());
			}else{
				s8.setAvguse(0);
				s8.setAvgusetime(0);
			}
			
			//次平均使用时长
			
			
			lstan.add(s1);
			lstan.add(s2);
			lstan.add(s3);
			lstan.add(s4);
			lstan.add(s5);
			lstan.add(s6);
			lstan.add(s7);
			lstan.add(s8);
			
			
			GridDataModel<Analyze> model = new GridDataModel<Analyze>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_1(response, startStr, limitStr, lstan, model,sortBy,sortDir);
			
		}
		
	}

	@Override
	public void GridStat_2(HttpServletResponse response, String startStr,
			String limitStr, String sortBy, String sortDir, Map map) {
		if(map.get("type")!=null&&!("".equals(map.get("type")))){
			String str = (String) map.get("type");
			String name = (String) map.get("name");
			
			if(name=="col1"||"col1".equals(name)){
				map.put("cs", "");
				map.put("os", "待续费");
				map.put("type", str);
			}else if(name=="col3"||"col3".equals(name)){
				map.put("cs", "已付费");
				map.put("os", "待续费");
				map.put("type", str);
			}else if(name=="col5"||"col5".equals(name)){
				map.put("cs", "已付费");
				map.put("os", "");
				map.put("type", str);
			}else if(name=="col7"||"col7".equals(name)){
				map.put("cs", "待续费");
				map.put("os", "已付费");
				map.put("type", str);
			}else if(name=="col9"||"col9".equals(name)){
				map.put("cs", "05");
				map.put("os", "未付费");
				map.put("type", str);
			}else if(name=="col11"||"col11".equals(name)){
				map.put("cs", "未付费");
				map.put("os", "未付费");
				map.put("type", str);
			}else if(name=="col13"||"col13".equals(name)){
				map.put("cs", "游客");
				map.put("os", "游客");
				map.put("yk", "游客");
				map.put("type", str);
			}else if(name=="col15"||"col15".equals(name)){
				map.put("cs", "08");
				map.put("os", "游客");
				map.put("type", str);
			}
			List<Map> lstan = new ArrayList<Map>();
			lstan = accessLogService.stat_1_headcount_new1(map);
			List<Stat_1_new1> lstan1 = new ArrayList<Stat_1_new1>();
			String str1 = "";
			for(int i=0;i<lstan.size();i++){
				if(!str1.contains((String) lstan.get(i).get("LOGINNAME"))){
					Stat_1_new1 s = new Stat_1_new1();
					s.setCurrentuserstate((String) lstan.get(i).get("CURRENTUSERSTATE"));
					s.setDeviceserial((String) lstan.get(i).get("DEVICESERIAL"));
					s.setLoginname((String) lstan.get(i).get("LOGINNAME"));
					lstan1.add(s);
				}
				if((String) lstan.get(i).get("LOGINNAME")!=" "&&!(" ".equals((String) lstan.get(i).get("LOGINNAME")))){
					str1 = str1+(String) lstan.get(i).get("LOGINNAME");
				}
			}
			GridDataModel<Stat_1_new1> model = new GridDataModel<Stat_1_new1>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_1(response, startStr, limitStr, lstan1, model,sortBy,sortDir);
			
			
			
		}else{
			List<Stat_2> lstan = new ArrayList<Stat_2>();
			
			//将取到的日期转化成Date类型
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = null;
			Date date2 = null;
			if(map.get("sd")!=null&&map.get("ed")!=null){
				try {
					date1 = sdf.parse((String) map.get("sd"));
					date2 = sdf.parse((String) map.get("ed"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			List ot = new ArrayList();
			ot.add(0, "应用");
			ot.add(1, "账户");
			ot.add(2, "咨询");
			ot.add(3, "工具");
			ot.add(4, "搜索");
			ot.add(5, "阅读");
			ot.add(6, "广告");
			ot.add(7, "其他");
			
			
			for(int i = 0;i<8;i++){
				Map map1 = new HashMap();
				map1.put("cs", "");
				map1.put("os", "待续费");
				map1.put("ot", (String)ot.get(i));
				map1.put("sd", date1);
				map1.put("ed", date2);
				map1.put("zt", (String) map.get("zt"));
				Map map2 = new HashMap();
				map2.put("cs", "已付费");
				map2.put("os", "待续费");
				map2.put("ot", (String)ot.get(i));
				map2.put("sd", date1);
				map2.put("ed", date2);
				map2.put("zt", (String) map.get("zt"));
				Map map3 = new HashMap();
				map3.put("cs", "已付费");
				map3.put("os", "");
				map3.put("ot", (String)ot.get(i));
				map3.put("sd", date1);
				map3.put("ed", date2);
				map3.put("zt", (String) map.get("zt"));
				Map map4 = new HashMap();
				map4.put("cs", "待续费");
				map4.put("os", "已付费");
				map4.put("ot", (String)ot.get(i));
				map4.put("sd", date1);
				map4.put("ed", date2);
				map4.put("zt", (String) map.get("zt"));
				Map map5 = new HashMap();
				map5.put("cs", "05");
				map5.put("os", "未付费");
				map5.put("ot", (String)ot.get(i));
				map5.put("sd", date1);
				map5.put("ed", date2);
				map5.put("zt", (String) map.get("zt"));
				Map map6 = new HashMap();
				map6.put("cs", "未付费");
				map6.put("os", "未付费");
				map6.put("ot", (String)ot.get(i));
				map6.put("sd", date1);
				map6.put("ed", date2);
				map6.put("zt", (String) map.get("zt"));
				Map map7 = new HashMap();
				map7.put("cs", "游客");
				map7.put("os", "游客");
				map7.put("yk", "游客");
				map7.put("ot", (String)ot.get(i));
				map7.put("sd", date1);
				map7.put("ed", date2);
				map7.put("zt", (String) map.get("zt"));
				Map map8 = new HashMap();
				map8.put("cs", "08");
				map8.put("os", "游客");
				map8.put("ot", (String)ot.get(i));
				map8.put("sd", date1);
				map8.put("ed", date2);
				map8.put("zt", (String) map.get("zt"));
				
				Stat_2 stat = new Stat_2();
				stat.setCategory((String) ot.get(i));
				
				Long t11 = accessLogService.stat_1_headcount(map1);
				Long t12 = accessLogService.stat_1_timescount(map1);
				Long t21 = accessLogService.stat_1_headcount(map2);
				Long t22 = accessLogService.stat_1_timescount(map2);
				Long t31 = accessLogService.stat_1_headcount(map3);
				Long t32 = accessLogService.stat_1_timescount(map3);
				Long t41 = accessLogService.stat_1_headcount(map4);
				Long t42 = accessLogService.stat_1_timescount(map4);
				Long t51 = accessLogService.stat_1_headcount(map5);
				Long t52 = accessLogService.stat_1_timescount(map5);
				Long t61 = accessLogService.stat_1_headcount(map6);
				Long t62 = accessLogService.stat_1_timescount(map6);
				Long t71 = accessLogService.stat_1_headcount(map7);
				Long t72 = accessLogService.stat_1_timescount(map7);
				Long t81 = accessLogService.stat_1_headcount(map8);
				Long t82 = accessLogService.stat_1_timescount(map8);
				
				stat.setHeadcount1(new Long(t11).intValue());
				stat.setHeadcount2(new Long(t21).intValue());
				stat.setHeadcount3(new Long(t31).intValue());
				stat.setHeadcount4(new Long(t41).intValue());
				stat.setHeadcount5(new Long(t51).intValue());
				stat.setHeadcount6(new Long(t61).intValue());
				stat.setHeadcount7(new Long(t71).intValue());
				stat.setHeadcount8(new Long(t81).intValue());
				stat.setTimescount1(new Long(t12).intValue());
				stat.setTimescount2(new Long(t22).intValue());
				stat.setTimescount3(new Long(t32).intValue());
				stat.setTimescount4(new Long(t42).intValue());
				stat.setTimescount5(new Long(t52).intValue());
				stat.setTimescount6(new Long(t62).intValue());
				stat.setTimescount7(new Long(t72).intValue());
				stat.setTimescount8(new Long(t82).intValue());
				
				lstan.add(stat);
			}
			
			GridDataModel<Analyze> model = new GridDataModel<Analyze>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_2(response, startStr, limitStr, lstan, model,sortBy,sortDir);
			
		}
		
	}

	@Override
	public void GridStat_3(HttpServletResponse response, String startStr,
			String limitStr, String sortBy, String sortDir, Map map) {
		if(map.get("category")!=null&&!("".equals(map.get("category")))){
			List<Stat_1_new1> lstat = new ArrayList<Stat_1_new1>();
			
			
			
			GridDataModel<Stat_1_new1> model = new GridDataModel<Stat_1_new1>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_3(response, startStr, limitStr, lstat, model,sortBy,sortDir);
		}else if(map.get("loginname")!=null&&!("".equals(map.get("loginname")))){
			
			
		}else if(map.get("learn")!=null&&!("".equals(map.get("learn")))){
			//表内查询3-1 learn:学习内容 name:用户类别
			String str = (String) map.get("learn");
			String name = (String) map.get("name");
			if(name=="col4"||"col4".equals(name)){
				map.put("cs", "");
				map.put("os", "待续费");
				map.put("oa", str);
			}else if(name=="col7"||"col7".equals(name)){
				map.put("cs", "已付费");
				map.put("os", "待续费");
				map.put("oa", str);
			}else if(name=="col10"||"col10".equals(name)){
				map.put("cs", "已付费");
				map.put("os", "");
				map.put("oa", str);
			}else if(name=="col13"||"col13".equals(name)){
				map.put("cs", "待续费");
				map.put("os", "已付费");
				map.put("oa", str);
			}else if(name=="col16"||"col16".equals(name)){
				map.put("cs", "05");
				map.put("os", "未付费");
				map.put("oa", str);
			}else if(name=="col19"||"col19".equals(name)){
				map.put("cs", "未付费");
				map.put("os", "未付费");
				map.put("oa", str);
			}else if(name=="col22"||"col22".equals(name)){
				map.put("cs", "游客");
				map.put("os", "游客");
				map.put("yk", "游客");
				map.put("oa", str);
			}else if(name=="col25"||"col25".equals(name)){
				map.put("cs", "08");
				map.put("os", "游客");
				map.put("oa", str);
			}
			List<Map> lstan = new ArrayList<Map>();
			lstan = accessLogService.stat_1_headcount_new1(map);
			List<Stat_1_new1> lstan1 = new ArrayList<Stat_1_new1>();
			String str1 = "";
			for(int i=0;i<lstan.size();i++){
				if(!str1.contains((String) lstan.get(i).get("LOGINNAME"))){
					Stat_1_new1 s = new Stat_1_new1();
					s.setCurrentuserstate((String) lstan.get(i).get("CURRENTUSERSTATE"));
					s.setDeviceserial((String) lstan.get(i).get("DEVICESERIAL"));
					s.setLoginname((String) lstan.get(i).get("LOGINNAME"));
					lstan1.add(s);
				}
				if((String) lstan.get(i).get("LOGINNAME")!=" "&&!(" ".equals((String) lstan.get(i).get("LOGINNAME")))){
					str1 = str1+(String) lstan.get(i).get("LOGINNAME");
				}
			}
			GridDataModel<Stat_1_new1> model = new GridDataModel<Stat_1_new1>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_1(response, startStr, limitStr, lstan1, model,sortBy,sortDir);
			
		}else{
			//将取到的日期转化成Date类型
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = null;
			Date date2 = null;
			if(map.get("sd")!=null&&map.get("ed")!=null){
				try {
					date1 = sdf.parse((String) map.get("sd"));
					date2 = sdf.parse((String) map.get("ed"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			List<String> list = accessLogService.getLearningContent();
			List<Stat_3> lstat = new ArrayList<Stat_3>();
			
			String str = null;
			for(int i=0;i<list.size();i++){
				
				Stat_3 stat = new Stat_3();
				str = list.get(i);
				
				String a[] = str.split("\\\\");
				
				if(a.length==2){
					stat.setLearningContent(a[1]);
					
				}else if(a.length==3){
					stat.setLearningContent(a[2]);
					stat.setLevel2(a[1]);
				}else{
					stat.setLearningContent(a[3]);
					stat.setLevel2(a[1]);
					stat.setLevel3(a[2]);
				}
				stat.setLevel1(a[0]);
				
				

				Map map1 = new HashMap();
			    map1.put("cs", "");
				map1.put("os", "待续费");
				map1.put("oa", str);
				map1.put("sd", date1);
				map1.put("ed", date2);
				map1.put("zt", (String) map.get("zt"));
				Map map2 = new HashMap();
				map2.put("cs", "已付费");
				map2.put("os", "待续费");
				map2.put("oa", str);
				map2.put("sd", date1);
				map2.put("ed", date2);
				map2.put("zt", (String) map.get("zt"));
				Map map3 = new HashMap();
				map3.put("cs", "已付费");
				map3.put("os", "");
				map3.put("oa", str);
				map3.put("sd", date1);
				map3.put("ed", date2);
				map3.put("zt", (String) map.get("zt"));
				Map map4 = new HashMap();
				map4.put("cs", "待续费");
				map4.put("os", "已付费");
				map4.put("oa", str);
				map4.put("sd", date1);
				map4.put("ed", date2);
				map4.put("zt", (String) map.get("zt"));
				Map map5 = new HashMap();
				map5.put("cs", "05");
				map5.put("os", "未付费");
				map5.put("oa", str);
				map5.put("sd", date1);
				map5.put("ed", date2);
				map5.put("zt", (String) map.get("zt"));
				Map map6 = new HashMap();
				map6.put("cs", "未付费");
				map6.put("os", "未付费");
				map6.put("oa", str);
				map6.put("sd", date1);
				map6.put("ed", date2);
				map6.put("zt", (String) map.get("zt"));
				Map map7 = new HashMap();
				map7.put("cs", "游客");
				map7.put("os", "游客");
				map7.put("yk", "游客");
				map7.put("oa", str);
				map7.put("sd", date1);
				map7.put("ed", date2);
				map7.put("zt", (String) map.get("zt"));
				Map map8 = new HashMap();
				map8.put("cs", "08");
				map8.put("os", "游客");
				map8.put("oa", str);
				map8.put("sd", date1);
				map8.put("ed", date2);
				map8.put("zt", (String) map.get("zt"));
				
				Long t11 = accessLogService.stat_1_headcount(map1);
				Long t12 = accessLogService.stat_1_timescount(map1);
				Long t21 = accessLogService.stat_1_headcount(map2);
				Long t22 = accessLogService.stat_1_timescount(map2);
				Long t31 = accessLogService.stat_1_headcount(map3);
				Long t32 = accessLogService.stat_1_timescount(map3);
				Long t41 = accessLogService.stat_1_headcount(map4);
				Long t42 = accessLogService.stat_1_timescount(map4);
				Long t51 = accessLogService.stat_1_headcount(map5);
				Long t52 = accessLogService.stat_1_timescount(map5);
				Long t61 = accessLogService.stat_1_headcount(map6);
				Long t62 = accessLogService.stat_1_timescount(map6);
				Long t71 = accessLogService.stat_1_headcount(map7);
				Long t72 = accessLogService.stat_1_timescount(map7);
				Long t81 = accessLogService.stat_1_headcount(map8);
				Long t82 = accessLogService.stat_1_timescount(map8);
				Long t13 = accessLogService.getTimeByLearning(map1);
				Long t23 = accessLogService.getTimeByLearning(map2);
				Long t33 = accessLogService.getTimeByLearning(map3);
				Long t43 = accessLogService.getTimeByLearning(map4);
				Long t53 = accessLogService.getTimeByLearning(map5);
				Long t63 = accessLogService.getTimeByLearning(map6);
				Long t73 = accessLogService.getTimeByLearning(map7);
				Long t83 = accessLogService.getTimeByLearning(map8);
				if(t13!=null){
					stat.setLearningTime1(new Long(t13).intValue());
				}else{
					stat.setLearningTime1(0);
				}
				if(t23!=null){
					stat.setLearningTime2(new Long(t23).intValue());
				}else{
					stat.setLearningTime2(0);
				}
				if(t33!=null){
					stat.setLearningTime3(new Long(t33).intValue());
				}else{
					stat.setLearningTime3(0);
				}
				if(t43!=null){
					stat.setLearningTime4(new Long(t43).intValue());
				}else{
					stat.setLearningTime4(0);
				}
				if(t53!=null){
					stat.setLearningTime5(new Long(t53).intValue());
				}else{
					stat.setLearningTime5(0);
				}
				if(t63!=null){
					stat.setLearningTime6(new Long(t63).intValue());
				}else{
					stat.setLearningTime6(0);
				}
				if(t73!=null){
					stat.setLearningTime7(new Long(t73).intValue());
				}else{
					stat.setLearningTime7(0);
				}
				if(t83!=null){
					stat.setLearningTime8(new Long(t83).intValue());
				}else{
					stat.setLearningTime8(0);
				}
				
				
				stat.setHeadcount1(new Long(t11).intValue());
				stat.setHeadcount2(new Long(t21).intValue());
				stat.setHeadcount3(new Long(t31).intValue());
				stat.setHeadcount4(new Long(t41).intValue());
				stat.setHeadcount5(new Long(t51).intValue());
				stat.setHeadcount6(new Long(t61).intValue());
				stat.setHeadcount7(new Long(t71).intValue());
				stat.setHeadcount8(new Long(t81).intValue());
				stat.setTimescount1(new Long(t12).intValue());
				stat.setTimescount2(new Long(t22).intValue());
				stat.setTimescount3(new Long(t32).intValue());
				stat.setTimescount4(new Long(t42).intValue());
				stat.setTimescount5(new Long(t52).intValue());
				stat.setTimescount6(new Long(t62).intValue());
				stat.setTimescount7(new Long(t72).intValue());
				stat.setTimescount8(new Long(t82).intValue());
				
				lstat.add(stat);
				
			}
			
			GridDataModel<Analyze> model = new GridDataModel<Analyze>();
			//TODO 这里有个替换,因为日期格式,暂用
			JsonUtil.GenerateGridsfDate_Stat_3(response, startStr, limitStr, lstat, model,sortBy,sortDir);
		}
		
	}

	@Override
	public List<String> getLoginnameAnalyze() {
		return accessLogService.getLoginnameAnalyze();
	}

	@Override
	public void userState(Map map) {
		accessLogService.userState(map);
	}

	@Override
	public List<String> isLoginNull(String deviceSerial) {
		return accessLogService.isLoginNull(deviceSerial);
	}

	@Override
	public void changeLogin(Map map) {
		accessLogService.changeLogin(map);
	}

	

	

}
