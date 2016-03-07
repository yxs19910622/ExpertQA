<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="setHome" name="currOpt"/>
</jsp:include>
<style type="text/css">
label.error{
	background: #fff6bf center no-repeat;
	background-position: 5px 50%;
	text-align: left;
	padding: 2px 20px 2px 25px;
	border: 1px solid #ffd324;
	display: none;
	width: 200px;
	margin-left: 10px;
}
</style>
<script type="text/javascript" >
$(document).ready(function() {
    $('#make-tab').omTabs({});
});
</script>
<div class="wbgRight_user">
	<div class="lesson_tit">首页设置</div>
		<div id="make-tab">
				<ul>
					<li><a href="#tab1">公告管理</a></li>
					<li><a href="#tab2">热门关键词</a></li>
				</ul>
				<div id="tab1"><jsp:include page="member_home_placard.jsp"/></div>
				<div id="tab2"><jsp:include page="member_home_keyword.jsp"/></div>
			</div>
		</div>
	</div>
</body>
</html>