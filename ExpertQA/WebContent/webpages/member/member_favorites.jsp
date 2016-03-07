<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="favorites" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
    <div class="lesson_tit">收藏列表</div>
    	<div class="user_divPub">                
   	<div class="card_list">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<th width="5%">序号</th>
			<th width="25%">问题类型</th>
			<th width="60%">问题标题</th>
			<th width="10%">管理</th>
		</tr>
		<s:if test="lstQuestions!=null">
			<s:iterator value="lstQuestions" status="question">
				<tr>
					<td style="border-left:none"><s:property value="#question.index+1"/></td>
					<td style="text-align: left;"><s:property value="typeName"/>&nbsp;</td>
					<td style="text-align: left;" title="<s:property value='captionText'/>"><s:property value="captionText"/></td>
					<td><a href="<%=request.getContextPath()%>/answerQuestion?questionid=<s:property value='questionID'/>" target="_blank">[查看详情]</a></td>
				</tr>
			</s:iterator>
		</s:if>
   </table>
   </div>
   </div>
</div>
</div>
</body>
</html>