<%@page import="java.net.URLDecoder"%>
<%@page import="org.izhong.expert.util.CookieUtil"%>
<%@page import="org.izhong.expert.util.Constant"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
Cookie euserId = CookieUtil.getCookieByName(request, "EUserID");
Cookie eshowName = CookieUtil.getCookieByName(request, "EUserName");
if(eshowName==null)
{
	eshowName = CookieUtil.getCookieByName(request, "Eemail");
}
%>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<div class="header">
	<div class="nav clearfix">
    	<div class="logo"><a href="<%=Constant.WBE_ROOT%>/index.html" target="_blank"><img src="<%=contextPath%>/haufe/images/logo.jpg" alt="浩富"></a></div>
		<ul class="menu clearfix">
        	<li><a href="<%=Constant.WBE_ROOT%>/hyxw/pages/1.html" target="_blank">新闻</a></li>
            <li><a href="<%=Constant.WBE_ROOT%>/product/ldf01/index.html" target="_blank">产品</a></li>
            <li><a href="http://zhuanjia.haufe.cn" target="_blank">专家在线</a></li>
            <li><a href="http://www.haufe.cn/trydown/index.html">试用下载</a></li>
            <li><a href="<%=contextPath%>/BuyOnline">在线购买</a></li>
		</ul>
        <div class="client">
        	<%if(euserId!=null){%>
        	<p>你好! <%=URLDecoder.decode(eshowName.getValue(),"utf-8")%>&nbsp;[<a href="member">个人中心</a>]&nbsp;[<a href="logout.action">退出</a>]</p>
        	<%}else{%>
        	<p><a href="login">登录</a><span>|</span><a href="register">注册</a></p>
        	<%}%>
            <p>订购热线：010-82251266</p>
        </div>
	</div>
	<div class="turn-box">
    	<div class="pics" id="pics-container">
        	<ul class="clearfix">
            	<li><a href="<%=Constant.WBE_ROOT%>/product/ldf01/index.html" target="_blank">
                    <img src="<%=contextPath%>/haufe/images/ad/ad3.jpg"/></a>
                </li>
                <li><a href="<%=Constant.WBE_ROOT%>/lp/P01/index.html">
                	<img src="<%=contextPath%>/haufe/images/ad/ad1.jpg"/></a></li>
			</ul>
		</div>
        <div class="bg"></div>
        <a href="#" class="prev"></a>
        <div class="buttons" id="pics-btns">
        	<a class="btn selected" href="#">1</a>
            <a class="btn" href="#">2</a>
		</div>
        <a href="#" class="next"></a>
	</div>
</div>