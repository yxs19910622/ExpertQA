<%@page import="java.net.URLDecoder"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="org.izhong.expert.util.CookieUtil"%>
<%
String contextPath = request.getContextPath();
Cookie euserId = CookieUtil.getCookieByName(request, "EUserID");
Cookie eshowName = CookieUtil.getCookieByName(request, "EUserName");
if(eshowName==null)
{
	eshowName = CookieUtil.getCookieByName(request, "Eemail");
}
%>
<%
	if(euserId!=null)
	{
%>
	<div class="yonghu">
	<b><%=URLDecoder.decode(eshowName.getValue(),"utf-8")%></b>
	<ul>
		<li><a target="_blank" href="http://zhuanjia.haufe.cn/member">个人中心</a></li>
		<li>&nbsp;</li>
		<li><a target="_blank" href="http://zhuanjia.haufe.cn/member/question">我的提问</a></li> 
		<li><a href="logout.action" class="tuichu" style="top:50px;">退出</a></li>
	</ul>
	</div>
<%		
	}else{
%>
	<div class="weibo">
	<div class="tengxun"><a href="login">
	<img src="<%=contextPath%>/interface/resource/images/denglu_01.png" alt="易中企业劳动法专家问答平台"/></a></div>
    <div class="xinlang"><a href="http://zhuanjia.haufe.cn/register">
    <img src="<%=contextPath%>/interface/resource/images/denglu_02.png" alt="易中企业劳动法专家问答平台"/></a></div>
	</div>
<%		
	}
%>
