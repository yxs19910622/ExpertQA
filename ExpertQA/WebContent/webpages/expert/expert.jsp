<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最大、最专业的企业劳动法专家问答平台-浩富</title>
<jsp:include page="/common/common_web.jsp"/>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="margin">
<jsp:include page="expert_ad.jsp"/>
<div class="index_left fl">
<jsp:include page="expert_company.jsp"/>        
</div>
<div class="index_right fr">
	<jsp:include page="/common/userinfo.jsp"/>
	<%-- <jsp:include page="expert_join.jsp"/> --%>
	<jsp:include page="/webpages/index/index_ad.jsp"/>
	<jsp:include page="/webpages/index/index_announcement.jsp"/>
	<jsp:include page="/webpages/index/index_weibo.jsp"/>
</div>
</div>
<div class="clear"></div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>