<%@page import="java.net.URLDecoder"%>
<%@page import="org.izhong.expert.util.CookieUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
Cookie euserId = CookieUtil.getCookieByName(request, "EUserID");
Cookie eshowName = CookieUtil.getCookieByName(request, "EUserName");
if(eshowName==null)
{
	eshowName = CookieUtil.getCookieByName(request, "ELoginName");
}
%>
<script type="text/javascript">
function addFavorite() {
	var aUrls = document.URL;//.split("/");
	var vDomainName = aUrls;//"http://"+aUrls[2]+"/";
	var description = document.title;
	try {//IE
		window.external.AddFavorite(vDomainName, description);
	} catch (e) {//Firefox
		window.sidebar.addPanel(description, vDomainName, "");
	} 
}
</script>
<div class="wbgTop">
    <div class="wbgTopMiddle">
        <ul>
            <li><a target="_blank" href="#" title="常见问题">常见问题</a></li><li class="wbglines"></li> 
            <li><a target="_blank" href="#" title="关于易中">关于易中</a></li><li class="wbglines"></li>
            <li><a target="_blank" onclick="addFavorite();" title="收藏本站">收藏本站</a></li><li class="wbglines"></li> 
        </ul>
        <span class="wbgTopLeft">
        <%
        if(euserId!=null)
        {
        	%>
            <span>您好，<%=URLDecoder.decode(eshowName.getValue(),"utf-8")%></span>&nbsp;&nbsp;
            <a target='_blank' href='member'>会员中心</a>&nbsp;<a href='logout.action'>退出</a>
            <%
        }else{
        	%>
        	<span>您好，欢迎来到易中在线问答系统！&nbsp;&nbsp;&nbsp;</span><a target='_blank' href='login' title='请登录'>请登录</a><a target='_blank' href='userRegister' title='免费注册'>免费注册</a>        	
        <%
        }
        %>
        </span>
    </div>
</div>