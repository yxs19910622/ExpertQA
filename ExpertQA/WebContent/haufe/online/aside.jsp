<%@page import="java.net.URLDecoder"%>
<%@page import="org.izhong.expert.util.CookieUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();
Cookie euserId = CookieUtil.getCookieByName(request, "EUserID");
Cookie eshowName = CookieUtil.getCookieByName(request, "EUserName");
String userId = null;
String name = "";
if(eshowName==null)
{
	eshowName = CookieUtil.getCookieByName(request, "Eemail");
}
if(euserId!=null && eshowName!=null){
	userId = euserId.getValue();
	name = eshowName.getValue();
}
%>
<script type="text/javascript">
<%-- function checklogin()
{
	var eUserID = <%=userId%>
	if(eUserID==null||eUserID==""||eUserID=="null")
	{
		alert("您好，请登录浩富在线问答!");
		window.location.href='login?onlinepay';/* http://zhuanjia.haufe.cn/ */
	}
} --%>
</script>
<body onload="checklogin()">
<div class="aside">
	<div class="cart">
    	<div class="title">用户信息</div>
        <div class="info">
           	<div class="user-info clearfix">
               	<!-- <img src="<%=contextPath%>/haufe/images/demo/9.jpg"/><p class="name">-->您好！<%=URLDecoder.decode(name,"utf-8")%></p>
			</div>
            <p><a href="<%=contextPath%>/addCart.action">我的购物车</a></p>
            <p><a href="<%=contextPath%>/orderList">我的订单</a></p>
		</div>
	</div>
	<div class="recommen">
		<div class="title">推荐产品</div>
		<ul>
			<li class="clearfix">
				<div class="left"><a href="http://www.haufe.cn/product/ldf02/index.html" target="_blank">
				<img src="<%=contextPath%>/haufe/images/demo/3.jpg" style="height: 55px;"/></a></div>
				<div class="right"><a href="http://www.haufe.cn/product/ldf02/index.html" target="_blank">浩富管理者<br/>劳动法实务手册</a></div>
			</li>
			<li class="clearfix">
				<div class="left"><a href="http://www.haufe.cn/product/ldf01/index.html" target="_blank">
				<img src="<%=contextPath%>/haufe/images/demo/2.jpg" style="height: 55px;"/></a></div>
				<div class="right"><a href="http://www.haufe.cn/product/ldf01/index.html" target="_blank">浩富劳动法<br/>顾问软件</a></div>
			</li>
			<li class="clearfix">
				<div class="left"><a href="http://www.haufe.cn/product/ldf03/index.html" target="_blank">
				<img src="<%=contextPath%>/haufe/images/demo/4.jpg" style="height: 55px;"/></a></div>
				<div class="right"><a href="http://www.haufe.cn/product/ldf03/index.html" target="_blank">浩富劳动法<br/>专家咨询</a></div>
			</li>
		</ul>
	</div>
</div>
</body>
