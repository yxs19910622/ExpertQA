package org.izhong.expert.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.Cookie;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.izhong.expert.abs.MemberAbs;
import org.izhong.expert.abs.UserRegisterAbs;
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
import org.izhong.expert.util.AnalyzeUtil;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.ComparatoAccessLog;
import org.izhong.expert.util.ComparatoAnalyze;
import org.izhong.expert.util.Constant;
import org.izhong.expert.util.CookieUtil;
import org.izhong.expert.util.StringUtil;
import org.izhong.expert.util.WordsCheck;

public class MemberAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberAbs memberAbs;
	private UserRegisterAbs userRegisterAbs;
	private List<Operations> lstOperations;
	private List<Roles> lstRoles;
	private List<LabUsers> lstLabUser;
	private List<QueryHotWords> lstqhw;
	private List<Questions> lstQuestions;
	private List<Replys> lstReplys;
	private List<OrderOnlinePayRecord> lstOnlinepayment; 
	private List<UserProducts> lstup;
	private Roles roles;
	private String initMenu;
	private LabUsers labuser;
	private SysUsers sysuser;
	private Questions questions;
	private Replys reply;
	private HypertextLinkExtends hle;
	private String error = null;
	private String jsonQATypes;
	private String jsonUserQATyps;
	private String jsonKeyword;
	private String jsonAuditQAType;
	private String jsonRoleList;
	private String jsonCode;
	private String attestStatus;
	
	private String online;
	private Long tel;
	
	private String fileName;
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public InputStream download(){
		return ServletActionContext.getServletContext().getResourceAsStream("/xls/" + "a.xls");
	}
	/**
	 * 根据订单号查询详细信息
	 * 
	 * @author yxs
	 */
	public void orderM(){
		String ordermasterno = getParameter("ordermasterno");
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getName(){
		String userName = getUserName();
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(userName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void order_userM(){
		String userName = getParameter("userName");
		String mobile = getParameter("mobile");
		String cmbProvince = getParameter("cmbProvince");
		String cmbCity = getParameter("cmbCity");
		String cmbArea = getParameter("cmbArea");
		String street = getParameter("street");
		String flag="true";
		if(userName==""||userName==null){
			flag="userName";
		}else if(mobile==""||mobile==null){
			flag="mobile";
		}else if(cmbProvince==""||cmbProvince==null){
			flag="cmbProvince";
		}else if(cmbCity==""||cmbCity==null){
			flag="cmbCity";
		}else if(cmbArea==""||cmbArea==null){
			flag="cmbArea";
		}else if(street==""||street==null){
			flag="street";
		}
		
		SysUsers sysuser = new SysUsers();
		sysuser.setUserID(getUserID());
		sysuser.setUserName(userName);
		sysuser.setMobile(mobile);
		memberAbs.updateSysUserName(sysuser);
		LabUsers labUsers = memberAbs.findLabUserInfo(getUserID());
		Companys company = labUsers.getCompany();
		if(company.getCompanyName()==null){
			company.setCompanyName("");
		}
		if(company.getFax()==null){
			company.setFax("");
		}
		if(company.getPostcode()==null){
			company.setPostcode("");
		}
		if(company.getTelephone()==null){
			company.setTelephone("");
		}
		company.setProvince(cmbProvince);
		company.setPrefecturelevelCity(cmbCity);
		company.setArea(cmbArea);
		company.setStreet(street);
		memberAbs.updateCompany(labUsers.getCompany());
		
		
		
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加一个问题
	 * 
	 * @author yxs
	 */
	public void survey_addQuestion(){
		Object obj = getParameter("data");
		JSONArray array = JSONArray.fromObject(obj);
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 异步加载敏感词
	 * 
	 * @author yxs
	 */
	public void wordsCheck()
	{
		List<String> words = WordsCheck.getWords();
		JSONArray array = JSONArray.fromObject(words);
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 验证code是否已存在
	 * 
	 * @author yxs
	 */
	public void verifiCode()
	{
		String preferentialno = getParameter("preferentialno");
		memberAbs.verifiCode(getResponse(),preferentialno);
	}
	
	/**
	 * 异步加载code
	 * 
	 * @author yxs
	 */
	public void code()
	{
		List<Code> allCode = memberAbs.allCode();
		/*for(int x=0;x<allCode.size();x++){
			System.out.println(allCode.get(x).getStartdate().toLocaleString());
		}*/
		JSONArray array = JSONArray.fromObject(allCode);
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 新增优惠码
	 * @return
	 * @author yxs
	 * @throws ParseException 
	 */
	
	public String addCode() //throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Code code = new Code();
		String preferentialno = getParameter("preferentialno");
		int discountmoney = Integer.parseInt(getParameter("discountmoney"));
		String[] list = getParameterValues("applicableproduct");
		String applicableproduct = "";
		for(int x=0;x<list.length;x++){
			if(x==0){
				applicableproduct+=list[x];
			}else{
				applicableproduct=applicableproduct+","+list[x];
			}
		}
		/*String applicableproduct1 = getParameter("applicableproduct1");
		String applicableproduct2 = getParameter("applicableproduct2");
		String applicableproduct3 = getParameter("applicableproduct3");
		String applicableproduct4 = getParameter("applicableproduct4");
		String applicableproduct = applicableproduct1+applicableproduct2+applicableproduct3+applicableproduct4;*/
		String createTime1 = getParameter("startdate");
		Date startdate;
		try {
			startdate = sdf.parse(createTime1);
			code.setStartdate(startdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String enddate1 = getParameter("enddate");
		Date enddate;
		try {
			enddate = sdf.parse(enddate1);
			code.setEnddate(enddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		code.setPreferentialno(preferentialno);
		code.setDiscountmoney(discountmoney);
		code.setApplicableproduct(applicableproduct);
		
		
		memberAbs.addCode(code);
		return SUCCESS;
	}
	
	public String toAddCode(){
		return SUCCESS;
	}
	
	public String survey(){
		return SUCCESS;
	}
	
	
	/**
	 * 初始化修改个人资料
	 * @return
	 * @author whz
	 */
	public String init_userEdit()
	{
		String userId = getUserID();
		labuser = memberAbs.findLabUserInfo(userId);
		sysuser = memberAbs.findSysUserInfo(userId);
			
		return SUCCESS;
	}
	
	/**
	 * 初始化修改密码
	 * @return
	 * @author whz
	 */
	public String init_userPass()
	{
		error = null;
		return SUCCESS;
	}
	
	/**
	 * 初始化提问列表
	 * @return
	 * @author whz
	 */
	public String init_question()
	{
		String userId = getUserID();
		if(BaseUtil.isNotEmpty(userId))
		{
			lstQuestions = memberAbs.findQuestionByUserId(userId);
		}
		return SUCCESS;
	}
	
	/**
	 * 初始化消息列表
	 * @return
	 * @author whz
	 */
	public String init_news()
	{
		return SUCCESS;
	}
	
	/**
	 * 初始化收藏列表
	 * @return
	 * @author whz
	 */
	public String init_favorites()
	{
		String userId = getUserID();
		if(BaseUtil.isNotEmpty(userId))
		{
			lstQuestions = memberAbs.findUserFavorite(userId);
		}
		return SUCCESS;
	}
	
	/**
	 * 初始化交易记录列表
	 * @return
	 * @author whz
	 */
	public String init_onlinePaymentRecords()
	{
		HashMap map = new HashMap();
		this.lstOnlinepayment = this.memberAbs.selectOrderOnlinePayRecord(map);
		return SUCCESS;
	}
	
	/**
	 * 初始化回复列表
	 * @return
	 * @author whz
	 */
	public String init_reply()
	{
		String userId = getUserID();
		if(BaseUtil.isNotEmpty(userId))
		{
			lstReplys = memberAbs.findReplysByUserId(userId);
		}
		return SUCCESS;
	}
	
	/**
	 * 初始专家擅长领域
	 * @return
	 * @author whz
	 */
	public String init_userProficients()
	{
		jsonQATypes = memberAbs.initJSONType();
		jsonUserQATyps = memberAbs.findUserProfiByUserID(getUserID());
		return SUCCESS;
	}
	
	/**
	 * 初始化审核用户列表
	 * @return
	 * @author whz
	 */
	public String init_auditUser()
	{
		lstLabUser = memberAbs.findLabUserList(2);
		return SUCCESS;
	}
	
	/**
	 * 初始化审核提问列表
	 * @return
	 * @author whz
	 */
	public String init_auditQuestion()
	{
		String questionId = getParameter("questionID");
		String type = getParameter("type");
		if(BaseUtil.isNotEmpty(questionId))
		{
			if("1".equals(type))
			{
				String qatype = getParameter("qatype");
				if(BaseUtil.isNotEmpty(qatype))
				{
					memberAbs.updateQuestionType(qatype, questionId);
					memberAbs.auditQuestion(1, questionId);
				}
			}else if("2".equals(type))
			{
				memberAbs.auditQuestion(3, questionId);
			}
		}
		lstQuestions = memberAbs.findQuestionUnaudited();
		jsonAuditQAType = memberAbs.initAjxQAType();
		return SUCCESS;
	}
	
	/**
	 * 初始化审核回复列表
	 * @return
	 * @author whz
	 */
	public String init_auditReply()
	{
		String replyId = getParameter("replyId");
		String type = getParameter("type");
		if(BaseUtil.isNotEmpty(replyId))
		{
			String questionId = getParameter("questionId");
			if("1".equals(type) && BaseUtil.isNotEmpty(questionId))//通过审核
			{
				memberAbs.auditReply(1, replyId);
				memberAbs.updateReplyCount(questionId);
			}else if("2".equals(type))//未通过审核
			{
				memberAbs.auditReply(3, replyId);
			}
		}
		
		lstReplys = memberAbs.findReplysUnaudited();
		String questionId = getParameter("questionId");
		if(questionId!=null){
			memberAbs.updateReplyCount(questionId);
		}
		return SUCCESS;
	}
	
	/**
	 * 初始化问题管理列表
	 * @return
	 * @author whz
	 */
	public String init_QAManage()
	{
		lstQuestions = memberAbs.findQuestionPending();
		return SUCCESS;
	}
	
	/**
	 * 初始化编辑问答
	 * @return
	 * @author whz
	 */
	public String init_QAEdit()
	{
		return SUCCESS;
	}
	
	/**
	 * 初始化新增编辑
	 * @return
	 * @author whz
	 */
	public String init_addEditor()
	{
		return SUCCESS;
	}

	/**
	 * 初始化新增专家
	 * @return
	 * @author whz
	 */
	public String init_addExpert()
	{
		return SUCCESS;
	}
	
	/**
	 * 初始化账户管理
	 * @return
	 * @author whz
	 */
	public String init_accountManage()
	{
		
		//lstRoles = memberAbs.findRoleAllValid();
		//lstLabUser = memberAbs.findLabUsersAll();	//2012.08.30 更改为异步取数据，暂时屏蔽 whz 
		jsonRoleList = memberAbs.initJSONRole();
		return SUCCESS;
	}
 
	/**
	 * 初始化功能管理
	 * @return
	 * @author whz
	 */
	public String init_functionManage()
	{
		lstOperations = memberAbs.findOperationAll();
		return SUCCESS;
	}
	
	/**
	 * 初始化角色管理
	 * @return
	 * @author whz
	 */
	public String init_roleManage()
	{
		lstRoles = memberAbs.findRoleAll();
		return SUCCESS;
	}
	
	/**
	 * 初始化新增角色
	 * @return
	 * @author whz
	 */
	public String init_roleAdd()
	{
		lstOperations = memberAbs.findOperationValid();
		return SUCCESS;
	}
	
	/**
	 * 初始化关键字
	 * @return
	 * @author whz
	 */
	public String init_keyword()
	{
		return SUCCESS;
	}
	
	/**
	 * 初始化首页设置
	 * @return
	 * @author whz
	 * @throws IOException 
	 */
	public String init_setHome() throws IOException
	{
		String aid = getParameter("aid");
		if("keyword".equals(aid))
		{
			String keyword = StringUtil.UnicodeToUTF8(getParameter("keyword"));
			String type = getParameter("type");
			memberAbs.updateQueryHotWord(keyword, type);
		}
		if("placard".equals(aid))
		{
			String value = StringUtil.UnicodeToUTF8(getParameter("value"));
			String type = getParameter("type");
			String tid = getParameter("tid");
			memberAbs.updatePlacard(type, value, tid);
		}
		return SUCCESS;
	}
	
	/**
	 * 新增帐号
	 * @return
	 * @author whz
	 */
	public String init_addAccount()
	{
		sysuser = new SysUsers();//防止取到当前用户的数据
		labuser = new LabUsers();
		lstRoles = memberAbs.findRoleAllValid();
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String init_attestAccount()
	{
		attestStatus = memberAbs.findAttestStatus(getUserID());
		sysuser = memberAbs.findSysUserInfo(getUserID());
		online = this.getParameter("online");
		return SUCCESS;
	}
	
	/**
	 * 初始化新闻速递
	 * @return
	 * @author whz
	 */
	public String init_hyper()
	{
		String type = getParameter("type");
		memberAbs.updateHyper(type, hle);
		return SUCCESS;
	}
	
	public String init_PayHistory()
	{
		return SUCCESS;
	} 
	
	public String init_Analyze()
	{
		return SUCCESS;
	}
	
	public String init_Analyze_1()
	{
		return SUCCESS;
	}
	
	public String init_Stat_1()
	{
		return SUCCESS;
	}
	public String init_Stat_2()
	{
		return SUCCESS;
	}
	public String init_Stat_3()
	{
		return SUCCESS;
	}
	
	public String init_ActivateUser()
	{
		String userId = getUserID();
		if(BaseUtil.isNotEmpty(userId))
		{
			lstup = memberAbs.getUserProductByUserId(userId);
		}
		return SUCCESS;
	}
	
	/**
	 * 异步加载关键词表格
	 * @author whz
	 */
	public void ajxKeyWordGrid()
	{
		String startStr = getParameter("start");
	    String limitStr = getParameter("limit");
	    memberAbs.GridHotWord(getResponse(), startStr, limitStr);
	}
	
	/**
	 * 异步加载公告列表
	 * @author whz
	 */
	public void ajxPlacardGrid()
	{
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		memberAbs.GridPlacard(getResponse(), startStr, limitStr);
	}
	
	/**
	 * 异步加载新闻速递列表
	 * @author whz
	 */
	public void ajxHyperGrid()
	{
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		memberAbs.GridHyper(getResponse(), startStr, limitStr);
	}
	
	/**
	 * 异步加载审核提问表格
	 * @author whz
	 */
	public void ajxAuditQuestion()
	{
		String startStr = getParameter("start");
	    String limitStr = getParameter("limit");
	    memberAbs.GridAuditQuestion(getResponse(), startStr, limitStr);
	}
	
	/**
	 * 异步加载帐号管理列表
	 * @author whz
	 */
	public void ajxAccountManage()
	{
		String customer_alias = getParameter("alias");
		String customer_role = getParameter("role");
		String customer_id = getParameter("id");
		String customer_email = getParameter("email");
		
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("alias", customer_alias);
		paramMap.put("role", customer_role);
		paramMap.put("id", customer_id);
		paramMap.put("email", customer_email);
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		memberAbs.GridAccountManage(getResponse(), startStr, limitStr,paramMap);
	}
	
	/**
	 * 异步加载问答管理列表
	 * @author whz
	 */
	public void ajxQAManage()
	{
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		memberAbs.GridQAManage(getResponse(), startStr, limitStr);
	}
	
	/**
	 * 异步加载付款记录
	 * @author whz
	 */
	public void ajxPayHistory()
	{
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		memberAbs.GridPayHistory(getResponse(), startStr, limitStr);
	}
	/**
	 * 
	 * 异步加载统计分析
	 * @author yxs
	 */
	public void ajxAnalyze_1()
	{
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		String sortBy = getParameter("sortBy");
		String sortDir = getParameter("sortDir");
		String obj = getParameter("obj");
		String zt = getParameter("zt");
		String sys = getParameter("sys");
		String code = null;
		if(sys!=null){
			if(sys.contains("msie")){
				code = "GBK";
			}else{
				code = "UTF-8";
			}
		}
		
		/*String cs = null;
		if(getParameter("cs")!=null){
			try {
				cs = new String(getParameter("cs").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		String os = null;
		if(getParameter("os")!=null){
			try {
				os = new String(getParameter("os").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String ln = getParameter("ln");
		String ds = getParameter("ds");
		String t1 = getParameter("t1");
		String t2 = getParameter("t2");
		if(ln!=null){
			ln = "%"+ln+"%";
		}
		if(ds!=null){
			ds = "%"+ds+"%";
		}
		if(t1!=null){
			if(t1==">"||">".equals(t1)){
				t1="day";
			}else if(t1==">="||">=".equals(t1)){
				t1="dad";
			}else if(t1=="="||"=".equals(t1)){
				t1="dey";
			}else if(t1=="<"||"<".equals(t1)){
				t1="xay";
			}else if(t1=="<="||"<=".equals(t1)){
				t1="xad";
			}
		}
		Map map = new HashMap();
//		map.put("cs", cs);
		map.put("os", os);
		map.put("ln", ln);
		map.put("ds", ds);
		map.put("t1", t1);
		map.put("obj", obj);
		map.put("zt", zt);
		if(t2!=null&&!("".equals(t2))){
			map.put("t2", Integer.parseInt(t2));
			
		}else{
			map.put("t2", t2);
		}
		memberAbs.GridAnalyze_1(getResponse(), startStr, limitStr,sortBy,sortDir,map);
	}
	/**
	 * 另存为excel功能
	 * @author yxs
	 */
	public void excel(){
		String path = getRequest().getRealPath("/");
		String url = "http://zhuanjia.haufe.cn/xls/"+memberAbs.excel(path);
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * 异步加载操作分析
	 * @author yxs
	 */
	public void ajxAnalyze()
	{
//		ajxAnalyze_3();
//		ajxAnalyze_2();
//		userState();
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		String sortBy = getParameter("sortBy");
		String sortDir = getParameter("sortDir");
		String ln = getParameter("ln");
		String ds = getParameter("ds");
		String t1 = getParameter("t1");
		String t2 = getParameter("t2");
		String da = getParameter("da");
		String ed = getParameter("ed");
		
		String sys = getParameter("sys");
		String obj = getParameter("obj");
		String zt = getParameter("zt");
		String oid = getParameter("oid");
		String code = null;
		if(sys!=null){
			if(sys.contains("msie")){
				code = "GBK";
			}else{
				code = "UTF-8";
			}
		}
		String cs = null;
		if(getParameter("cs")!=null){
			try {
				cs = new String(getParameter("cs").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String ot = null;
		if(getParameter("ot")!=null){
			try {
				ot = new String(getParameter("ot").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String os = null;
		if(getParameter("os")!=null){
			try {
				os = new String(getParameter("os").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String oa = null;
		if(getParameter("oa")!=null){
			try {
				oa = new String(getParameter("oa").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ln!=null){
			ln = "%"+ln+"%";
		}
		if(ds!=null){
			ds = "%"+ds+"%";
		}
		if(oa!=null){
			oa = "%"+oa+"%";
		}
		if(da!=null&&!("".equals(da))){
			da = da+" 00:00:00";
		}
		if(ed!=null&&!("".equals(ed))){
			ed = ed+" 23:59:59";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = null;
		Date date2 = null;
		if(da!=null&&ed!=null){
			try {
				date1 = sdf.parse(da);
				date2 = sdf.parse(ed);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map map = new HashMap();
		map.put("cs", cs);
		map.put("os", os);
		map.put("ln", ln);
		map.put("ds", ds);
		map.put("ot", ot);
		map.put("oa", oa);
		map.put("t1", t1);
		map.put("t2", t2);
		map.put("sd", date1);
		map.put("ed", date2);
		map.put("zt", zt);
		map.put("obj", obj);
		map.put("excel", obj);
		map.put("oid", oid);
		if(obj=="yes"||"yes".equals(obj)){
			JSONArray array = JSONArray.fromObject("123");
			PrintWriter out;
			try {
				out = getResponse().getWriter();
				out.print(array);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			memberAbs.GridAnalyze(getResponse(), startStr, limitStr,sortBy,sortDir,map);
		}
	}
	
	/**
	 * 
	 * 异步加载统计表1
	 * @author yxs
	 */
	public void ajaxStat_1(){
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		String sortBy = getParameter("sortBy");
		String sortDir = getParameter("sortDir");
		String sd = getParameter("sd");
		String ed = getParameter("ed");
		String zt = getParameter("zt");
		String sys = getParameter("sys");
		String loginname = getParameter("loginname");
		String deviceserial = getParameter("deviceserial");
		String code = null;
		if(sys!=null){
			if(sys.contains("msie")){
				code = "GBK";
			}else{
				code = "UTF-8";
			}
		}
		String category = null;
		if(getParameter("category")!=null&&!("".equals(getParameter("category")))){
			try {
				category = new String(getParameter("category").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map map = new HashMap();
		if(sd!=null&&!("".equals(sd))){
			sd = sd+" 00:00:00";
		}
		if(ed!=null&&!("".equals(ed))){
			ed = ed+" 23:59:59";
		}
		map.put("sd", sd);
		map.put("ed", ed);
		map.put("zt", zt);
		map.put("category", category);
		map.put("loginname", loginname);
		map.put("deviceserial", deviceserial);
		memberAbs.GridStat_1(getResponse(), startStr, limitStr,sortBy,sortDir,map);
	}
	
	/**
	 * 
	 * 异步加载统计表2
	 * @author yxs
	 */
	
	public void ajaxStat_2(){
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		String sortBy = getParameter("sortBy");
		String sortDir = getParameter("sortDir");
		String sd = getParameter("sd");
		String ed = getParameter("ed");
		String zt = getParameter("zt");
		String sys = getParameter("sys");
		String loginname = getParameter("loginname");
		String deviceserial = getParameter("deviceserial");
		String name = getParameter("name");
		String code = null;
		if(sys!=null){
			if(sys.contains("msie")){
				code = "GBK";
			}else{
				code = "UTF-8";
			}
		}
		String type = null;
		if(getParameter("type")!=null&&!("".equals(getParameter("type")))){
			try {
				type = new String(getParameter("type").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String category = null;
		if(getParameter("category")!=null&&!("".equals(getParameter("category")))){
			try {
				category = new String(getParameter("category").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map map = new HashMap();
		if(sd!=null&&!("".equals(sd))){
			sd = sd+" 00:00:00";
		}
		if(ed!=null&&!("".equals(ed))){
			ed = ed+" 23:59:59";
		}
		map.put("category", category);
		map.put("loginname", loginname);
		map.put("deviceserial", deviceserial);
		map.put("sd", sd);
		map.put("ed", ed);
		map.put("zt", zt);
		map.put("type", type);
		map.put("name", name);
		memberAbs.GridStat_2(getResponse(), startStr, limitStr,sortBy,sortDir,map);
	}
	
	/**
	 * 
	 * 异步加载统计表3
	 * @author yxs
	 */
	public void ajaxStat_3(){
		String startStr = getParameter("start");
		String limitStr = getParameter("limit");
		String sortBy = getParameter("sortBy");
		String sortDir = getParameter("sortDir");
		String sd = getParameter("sd");
		String ed = getParameter("ed");
		String zt = getParameter("zt");
		String sys = getParameter("sys");
		String loginname = getParameter("loginname");
		String deviceserial = getParameter("deviceserial");
		String name = getParameter("name");
		String code = null;
		if(sys!=null){
			if(sys.contains("msie")){
				code = "GBK";
			}else{
				code = "UTF-8";
			}
		}
		String learn = null;
		if(getParameter("learn")!=null&&!("".equals(getParameter("learn")))){
			try {
				learn = new String(getParameter("learn").getBytes("ISO-8859-1"),code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Map map = new HashMap();
		if(sd!=null&&!("".equals(sd))){
			sd = sd+" 00:00:00";
		}
		if(ed!=null&&!("".equals(ed))){
			ed = ed+" 23:59:59";
		}
		map.put("learn", learn);
		map.put("loginname", loginname);
		map.put("deviceserial", deviceserial);
		map.put("sd", sd);
		map.put("ed", ed);
		map.put("zt", zt);
		map.put("name", name);
		memberAbs.GridStat_3(getResponse(), startStr, limitStr,sortBy,sortDir,map);
	}
	
	
	/**
	 * 开启定时器
	 * @author yxs
	 */
	public String ajxAnalyzeTimer(){
        
		System.out.println("分析完成");
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//取到明天
		calendar.set(Calendar.HOUR_OF_DAY, 4); // 控制时
		calendar.set(Calendar.MINUTE, 0);       // 控制分
		calendar.set(Calendar.SECOND, 0);       // 控制秒

        Date time = calendar.getTime();         // 得出执行任务的时间
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
            	ajxAnalyze_3();
                ajxAnalyze_2();
                userState();
                System.out.println("已执行");
            }
        }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
  	return SUCCESS;
	}
	
	
	
	/**
	 * 取值分析功能
	 * @author yxs
	 */
	@SuppressWarnings("unchecked")
	public void ajxAnalyze_3()
	{
		//TODO 分析数据功能
		SYS_AccessLog acc = null;
		SYS_AccessLog acc_1 = null;
		Analyze ana = new Analyze();
		
		String str1 = null;//存上一条记录的当前状态
		String str2 = null;//存上一条记录的操作状态
		
		//获取当前日期的前一天
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);    //得到前一天
/*		calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
		calendar.set(Calendar.MINUTE, 0);       // 控制分
		calendar.set(Calendar.SECOND, 0);       // 控制秒
*/		Date date = calendar.getTime();
		//String str = sdf.format(date);
	    
	   // Timestamp ts = new Timestamp(date.getTime());
	    
//	    List<SYS_AccessLog> accessLogList = memberAbs.getAccessLog();
		List<SYS_AccessLog> accessLogList = memberAbs.getAccessLogByTime(date);
//		String loginName =null;
		String d = null;
		//对取到的list进行排序,登录名>时间,以后根据数据再行添加排序
		ComparatoAccessLog comparator=new ComparatoAccessLog();
		Collections.sort(accessLogList, comparator);
		
		
		//生成操作序号
		tel = System.currentTimeMillis();
//		Date d = new Date();
		for(int i=0;i<accessLogList.size();i++){
			ana.setTime(0);
			acc = accessLogList.get(i);
			ana = AnalyzeUtil.copy(acc, ana);
			Date overtime = memberAbs.getOverTime(acc.getLoginName());
			
			int x = Integer.parseInt(memberAbs.isPay(acc.getLoginName()));
			
			
			if(acc.getLoginName()==" "||" ".equals(acc.getLoginName())){//看用户名是否为空
				ana.setCurrentuserstate("游客");
				ana.setOperatuserstate("游客");
			}else{
				//先判断是否有缴费记录
				if(x!=0){//如果有缴费记录
					
					if(overtime.after(acc.getOperationDate())){//如果未过期
						ana.setCurrentuserstate("已付费");
						ana.setOperatuserstate("已付费");
					}else{//如果已过期
						ana.setCurrentuserstate("待续费");
						ana.setOperatuserstate("待续费");
					}
					
				}else{//如果没有缴费记录
					ana.setCurrentuserstate("未付费");
					ana.setOperatuserstate("未付费");
				}
			}
			
			//取到设备号,查询是否存在用户名为空的记录(tid),若存在,将当前设备号下的loginname和当前状态赋予空记录
			List<String> list = memberAbs.isLoginNull(acc.getDeviceSerial());
			for(int n = 0;n<list.size();n++){
				Map map = new HashMap();
				map.put("tid", list.get(n));
				map.put("state", acc.getCurrentUserState());
				map.put("name", acc.getLoginName());
				//是否测试账户
				if(isTest(acc.getLoginName())){
					map.put("istest", "1");
				}else{
					map.put("istest", "0");
				}
				memberAbs.changeLogin(map);
			}
			
//			ana.setWritetime(d);
			if(i!=0){
				acc_1 = accessLogList.get(i-1);
				if(acc.getOperationArea()=="启动"||"启动".equals(acc.getOperationArea())){
					ana.setOid(Long.toString(++tel));
				}else{
					ana.setOid(Long.toString(tel));
				}
				
				if((acc.getOperationArea()=="启动"||"启动".equals(acc.getOperationArea()))&&(acc_1.getOperationArea()!="关闭"&&!("关闭".equals(acc_1.getOperationArea())))){
						
					
						//异常退出的情况,插入一条异常退出的操作记录
						Analyze err = new Analyze();
						err.setCurrentuserstate(str1);
						err.setOperatuserstate(str2);
						err.setOid(Long.toString(tel-1));
						err.setOperationtype("应用");
						err.setOperationarea("异常退出");
						err.setLoginname(acc_1.getLoginName());
						err.setDeviceserial(acc_1.getDeviceSerial());
						err.setWritetime(acc_1.getCreateTime());
						err.setCreatetime(acc_1.getOperationDate());
						err.setProjectname(acc_1.getProjectName());
						Date date1 = accessLogList.get(i-1).getOperationDate();
						Date date2 = new Date(date1.getTime()+15*60*1000);
						err.setCreatetime(date2);
						err.setTid(System.currentTimeMillis());
						//是否测试账户
						if(isTest(err.getLoginname())){
							err.setIstest("1");
						}else{
							err.setIstest("0");
						}
						memberAbs.addAnaylze(err);
				}
				
				
				//添加操作时长的判断
				if(AnalyzeUtil.isNeed(acc.getOperationType())){
					int s ;
					if(i==accessLogList.size()-1){
						s=15;
					}else{
						long mtime = accessLogList.get(i+1).getOperationDate().getTime() - acc.getOperationDate().getTime();
						long time = mtime/(1000*60);
						if(time==0){
							s=1;
						}else if(time>15){
							s=15;
						}else{
							s= (int) time;
						}
					}
					ana.setTime(s);
				}
				
				
			}else{
				ana.setOid(Long.toString(tel));//第一条记录的oid
			}
			
			str1 = ana.getCurrentuserstate();
			str2 = ana.getOperatuserstate();
			
			//是否测试账户
			if(isTest(ana.getLoginname())){
				ana.setIstest("1");
			}else{
				ana.setIstest("0");
			}
			//写入数据库
			memberAbs.addAnaylze(ana);
//			loginName = acc.getLoginName();
			d = acc.getDeviceSerial();
		}
	}
	
	/**
	 * 显示用户操作次数的表
	 * @author yxs
	 */
	@SuppressWarnings("unchecked")
	public void ajxAnalyze_2(){
		//获取当前日期的前一天
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);    //得到前一天
		/*calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
		calendar.set(Calendar.MINUTE, 0);       // 控制分
		calendar.set(Calendar.SECOND, 0);       // 控制秒
*/		Date date = calendar.getTime();
		List<Analyze> list =  memberAbs.getAnalyzeByTime(date);
		
		//对取到的list进行排序,oid>时间
		ComparatoAnalyze comparator=new ComparatoAnalyze();
		Collections.sort(list, comparator);
		
		Analyze ana = null;
		Analyze ana_1 = null;
		
		//储存上一个启动的时间
		Date d1 = null;
		
		String name = null;//登录名
		int t ;//本次操作的时间
		String status = null;//用户状态
		String dev = null;//设备编号
		
		//本次操作点击的次数
		int sum = 0;
		String oid = null;
		String test = null;
		Long tid = null;
		/*for(int i=0;i<list.size();i++){
			ana = list.get(i);
			ana_1 = list.get(i-1);
			if(i!=0){
				if(ana.getOperationarea()=="启动"||"启动".equals(ana.getOperationarea())){
					
					name = ana_1.getLoginname();
					long mtime = ana.getCreatetime().getTime()-d1.getTime();
					long time = mtime/(1000*60);
					t = Long.toString(time)+"min";
					d1 = ana.getCreatetime();
					
					at.setLoginname(name);
					at.setTid(ana_1.getTid());
					at.setOid(ana_1.getOid());
					at.setTime(t);
					at.setSum(sum+"");
					sum = 0;
				}
				sum++;
			}else{
				d1=ana.getCreatetime();
				sum++;
			}
		}*/
		
		for(int i=0;i<list.size();i++){
			ana = list.get(i);
			
			if(i!=0){
				ana_1 = list.get(i-1);
				if(!(ana.getOid()==oid||oid.equals(ana.getOid()))||(i==list.size()-1)){
					
					AnalyzeTimes at = new AnalyzeTimes();//新的表
					
					long mtime = ana_1.getCreatetime().getTime()-d1.getTime();
					long time = mtime/(1000*60);
					t = (int) time;
					
					if(t==0||t<0){
						t=1;
					}
					
					//写入值
					at.setLoginname(name);
					at.setTid(tid);
					at.setOid(oid);
					at.setTime(t);
					at.setSum(sum+"");
					at.setDev(dev);
					at.setStatus(status);
					at.setCreatetime(d1);
					at.setIstest(test);
					//TODO 新增AnalyzeTimes记录
					memberAbs.addAnalyzeTimes(at);
					sum = 0;
					at = null;
					d1 = ana.getCreatetime();//存入每次序号更换时的第一个操作时间
					
				}
			}else{
				d1 = ana.getCreatetime();//循环的第一次
			}
			sum++;
			oid = ana.getOid();
			tid = ana.getTid();
			test = ana.getIstest();
			status = ana.getOperatuserstate();
			name = ana.getLoginname();
			dev = ana.getDeviceserial();
		}
		
	}
	/**
	 * 对所有用户的当前状态进行判断修改
	 * @return
	 * @author yxs
	 */
	public void userState(){
		List<String> list = memberAbs.getLoginnameAnalyze();
		String name = null;
		
		for(int i = 0;i<list.size();i++){
			name = list.get(i);
			int x = Integer.parseInt(memberAbs.isPay(name));//是否有缴费记录
			if(!(name==" "||" ".equals(name))){//当用户名不为空时
				
				if(x!=0){//只关注有缴费记录的情况
					
					Date overtime = memberAbs.getOverTime(name);//缴费记录的过期时间
					if(overtime.after(new Date())){//如果未过期
						Map map = new HashMap();
						map.put("name", name);
						map.put("state", "已付费");
						
						//更改状态为已付费
						memberAbs.userState(map);
					}else{//如果已过期
						Map map = new HashMap();
						map.put("name", name);
						map.put("state", "待续费");
				
						//更改状态为待续费
						memberAbs.userState(map);
						
					}
				}
			}	
		}
	}
	
	/** 存放测试账户,进行判断
	 * 
	 * @return
	 * @author yxs
	 */
	public boolean isTest(String name){
//		List list = new ArrayList();
//		list.add("testAA@izhong.com");
//		list.add("testBB@izhong.com");
//		list.add("testCC@izhong.com");
//		list.add("testDD@izhong.com");
//		list.add("testTT@izhong.com");
		
		if(name.contains("@izhong.com")||name.contains("@haufe.cn")||name.contains("278891967")||name.contains("grluo")){
			return true;
		}
		
//		return list.contains(name);
		return false;
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String roleAddSave()
	{
		String [] operation = getParameterValues("id");
		memberAbs.addRole(roles, operation);
		return SUCCESS;
	}
	
	/**
	 * 个人中心中信息的修改
	 * @return
	 * @author whz
	 */
	public String userEditSave()
	{
		memberAbs.updateSysUserName(sysuser);
		memberAbs.updateLabUser(labuser);
		memberAbs.updateCompany(labuser.getCompany());
		return SUCCESS;
	}


	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String userPassSave()
	{
		String oldPassword = getParameter("oldPassword");
		String newPassword = getParameter("newPassword");
		error = memberAbs.updatePassword(getUserID(), oldPassword, newPassword);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String password_alert(){
		String email = getParameter("email");
		SysUsers user =  memberAbs.getUserByEmail(email);
		memberAbs.updatePassword2(user.getUserID(), getParameter("pwd"));
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String auditUserSave()
	{
		String userId = getParameter("userId");
		memberAbs.updateAuditUser(userId);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String showUser()
	{
		String userId = getParameter("userId");
		labuser = memberAbs.findLabUserInfo(userId);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String showReply()
	{
		String questionId = getParameter("questionId");
		questions = memberAbs.findQuestionById(questionId);
		lstReplys = memberAbs.findReplysByQuestionId(questionId);
		return SUCCESS;
	}
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String addUserProfiType()
	{
		String typeId = getParameter("typeId");
		memberAbs.addUserProfiType(getUserID(), typeId);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String delUserProfiType()
	{
		String typeId = getParameter("typeId");
		memberAbs.delUserProfiType(getUserID(), typeId);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String addAccountSave()
	{
		long roleId = Long.valueOf(getParameter("roleID"));
		memberAbs.AddUser(sysuser, labuser, roleId);
		return SUCCESS;
	}
	
	/**
	 *  最佳答案
	 * @return
	 * @author whz
	 */
	public String optimalAnswer()
	{
		String replyId = getParameter("replyId");
		String questionId = getParameter("questionId");
		if(BaseUtil.isNotEmpty(replyId) && BaseUtil.isNotEmpty(questionId))
		{
			memberAbs.optimalAnswer(replyId);
			memberAbs.swithQuestion(1, questionId);//有最佳答案之后关闭问题
		}
		return SUCCESS;
	}
	
	/**
	 * 帐号认证
	 * @return
	 * @author whz
	 */
	public String attestAccountSave()
	{
		String customerId = getParameter("customerId");
		boolean flag = userRegisterAbs.attestAccount(getUserID(), customerId);
		if(flag)
		{
			memberAbs.updateUserRole(getUserID());
			if(online != null && online.equals("online")){//验证成功 并且是从支付转过来的请求
				return "online";
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 帐号激活
	 * @return
	 * @author whz
	 */
	public void activateUserSave()
	{
		String activateCode = getParameter("activateCode");
		String userId = getUserID();
		if(BaseUtil.isNotEmpty(userId) && BaseUtil.isNotEmpty(activateCode))
		{
			memberAbs.updateActivateUser(getResponse(), userId, activateCode);
			CookieUtil.removeCookie(getRequest(), getResponse());
		}
	}
	
	/**
	 * 帐号管理操作保存
	 * @return
	 * @author whz
	 */
	public String accountManageSave()
	{
		String type = getParameter("type");
		String userId = getParameter("userId");
		if("resetPassword".equals(type))
		{
			String resetPass = getParameter("resetPass");
			memberAbs.resetUserPassword(getUserID(), userId, resetPass,getRequest().getRemoteAddr());
		}
		return SUCCESS;
	}
	
	/**
	 * 修改用户服务日期
	 * @return
	 * @author whz
	 */
	public String updateUserTime()
	{
		String userTimeId = getParameter("userTime_userId");
		String tryStart = getParameter("tryStart");
		String tryEnd = getParameter("tryEnd");
		String serviceStart = getParameter("serviceStart");
		String serviceEnd = getParameter("serviceEnd");
		memberAbs.updateUserTime(getUserID(), getRemoteAddr(), userTimeId, tryStart, tryEnd, serviceStart, serviceEnd);
		return SUCCESS;
	}
	
	/**
	 * 删除问题
	 * @return
	 * @author whz
	 */
	public String delQuestion()
	{
		String questionId = getParameter("questionId");
		memberAbs.delQuestion(questionId);
		return SUCCESS;
	}
	
	/**
	 * 修改回答
	 * @return
	 * @author whz
	 */
	public String editReply()
	{
		String questionId = getParameter("questionId");
		lstReplys = memberAbs.getReplysAll(questionId);
		return SUCCESS;
	}
	
	/**
	 * 回答保存
	 * @return
	 * @author whz
	 */
	public String editReplySave()
	{
		if(BaseUtil.isNotEmpty(reply.getQuestionID()) && BaseUtil.isNotEmpty(reply.getReplyID()) && BaseUtil.isNotEmpty(reply.getReplyContent()))
		{
			memberAbs.updateReplyForContent(reply);
			lstReplys = memberAbs.getReplysAll(reply.getQuestionID());
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @author whz
	 */
	private void init_menu()
	{
		String userId = getUserID();
		String path = getRequest().getContextPath();
		
//		initMenu = memberAbs.initMenu(path, userId);
		Cookie cmenu = CookieUtil.getCookieByName(getRequest(), "EMenu");
		if(userId!=null && cmenu==null)
		{	
			initMenu = memberAbs.initMenu(path,userId);
			try {
				CookieUtil.addCookie(getResponse(), "EMenu", URLEncoder.encode(initMenu,"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			initMenu = cmenu.getValue();
		}
	}

	public List<Operations> getLstOperations() {
		return lstOperations;
	}

	public void setLstOperations(List<Operations> lstOperations) {
		this.lstOperations = lstOperations;
	}

	public List<Roles> getLstRoles() {
		return lstRoles;
	}

	public void setLstRoles(List<Roles> lstRoles) {
		this.lstRoles = lstRoles;
	}

	public void setMemberAbs(MemberAbs memberAbs) {
		this.memberAbs = memberAbs;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String getInitMenu() {
		init_menu();
		return initMenu;
	}

	public void setInitMenu(String initMenu) {
		this.initMenu = initMenu;
	}

	public LabUsers getLabuser() {
		return labuser;
	}

	public void setLabuser(LabUsers labuser) {
		this.labuser = labuser;
	}

	public SysUsers getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUsers sysuser) {
		this.sysuser = sysuser;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<LabUsers> getLstLabUser() {
		return lstLabUser;
	}

	public void setLstLabUser(List<LabUsers> lstLabUser) {
		this.lstLabUser = lstLabUser;
	}

	public String getJsonQATypes() {
		return jsonQATypes;
	}

	public void setJsonQATypes(String jsonQATypes) {
		this.jsonQATypes = jsonQATypes;
	}

	public String getJsonUserQATyps() {
		return jsonUserQATyps;
	}

	public void setJsonUserQATyps(String jsonUserQATyps) {
		this.jsonUserQATyps = jsonUserQATyps;
	}

	public String getJsonKeyword() {
		return jsonKeyword;
	}

	public void setJsonKeyword(String jsonKeyword) {
		this.jsonKeyword = jsonKeyword;
	}

	public List<QueryHotWords> getLstqhw() {
		if(lstqhw==null)
		{
			lstqhw = memberAbs.findHotWordsAll();
		}
		return lstqhw;
	}

	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}

	public List<Questions> getLstQuestions() {
		return lstQuestions;
	}

	public void setLstQuestions(List<Questions> lstQuestions) {
		this.lstQuestions = lstQuestions;
	}

	public List<Replys> getLstReplys() {
		return lstReplys;
	}

	public void setLstReplys(List<Replys> lstReplys) {
		this.lstReplys = lstReplys;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public String getAttestStatus() {
		return attestStatus;
	}

	public void setAttestStatus(String attestStatus) {
		this.attestStatus = attestStatus;
	}

	public String getJsonAuditQAType() {
		return jsonAuditQAType;
	}

	public void setJsonAuditQAType(String jsonAuditQAType) {
		this.jsonAuditQAType = jsonAuditQAType;
	}

	public void setUserRegisterAbs(UserRegisterAbs userRegisterAbs) {
		this.userRegisterAbs = userRegisterAbs;
	}

	public void setHle(HypertextLinkExtends hle) {
		this.hle = hle;
	}

	public HypertextLinkExtends getHle() {
		return hle;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public List getLstOnlinepayment() {
		return lstOnlinepayment;
	}

	public void setLstOnlinepayment(List lstOnlinepayment) {
		this.lstOnlinepayment = lstOnlinepayment;
	}
	
	public String getJsonRoleList() {
		return jsonRoleList;
	}

	public void setJsonRoleList(String jsonRoleList) {
		this.jsonRoleList = jsonRoleList;
	}

	public Replys getReply() {
		return reply;
	}

	public void setReply(Replys reply) {
		this.reply = reply;
	}

	public List<UserProducts> getLstup() {
		return lstup;
	}

	public void setLstup(List<UserProducts> lstup) {
		this.lstup = lstup;
	}
	public String getJsonCode() {
		return jsonCode;
	}
	public void setJsonCode(String jsonCode) {
		this.jsonCode = jsonCode;
	}
}