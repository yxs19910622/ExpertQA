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
<jsp:param value="question" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
	<div class="lesson_tit">我的提问</div>
	<div class="user_divPub">                
   	<div class="card_list">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<th width="5%">序号</th>
			<th width="20%">问题类型</th>
			<th width="36%">问题标题</th>
			<th width="7%">问题状态</th>
			<th width="7%">点击次数</th>
			<th width="15%">提问时间</th>
			<th width="10%">管理</th>
		</tr>
		<s:if test="lstQuestions!=null">
			<s:iterator value="lstQuestions" status="question">
				<tr>
					<td style="border-left:none"><s:property value="#question.index+1"/></td>
					<td style="text-align: left;"><s:property value="typeName"/>&nbsp;</td>
					<td style="text-align: left;" title="<s:property value='captionText'/>"><s:property value="captionText"/></td>
					<s:if test="replysCount>0"><td>已回答</td></s:if>
					<s:elseif test="isAlreadyChecked==0 || isAlreadyChecked==1"><td>已提交</td></s:elseif>
					<s:elseif test="isAlreadyChecked==2"><td>已保存</td></s:elseif>
					<s:elseif test="isAlreadyChecked==3"><td>已退回</td></s:elseif>
					<s:elseif test="replysCount>0"><td>已回答</td></s:elseif>
					<s:else><td>&nbsp;<td></s:else>
					<td><s:property value="clickNumber"/></td>
					<td><s:date name="createTime" format="yyyy-MM-dd HH:mm"/></td>
					
					<s:if test="isAlreadyChecked==1">
					<td><a href="<%=request.getContextPath()%>/answerQuestion?questionid=<s:property value='questionID'/>" target="_blank">[查看详情]</a></td>
					</s:if>
					<s:else>
					<td><a href="<%=request.getContextPath()%>/checkQuestion?questionid=<s:property value='questionID'/>" target="_blank">[查看详情]</a></td>
					</s:else>
					
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