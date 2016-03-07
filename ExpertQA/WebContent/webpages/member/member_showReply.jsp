<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>
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
<jsp:param value="QAManage" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
	<div class="lesson_tit">问答管理</div>
		<div class="user_divPub">                
        <div class="card_list">
        	<div>
        	<h3 style="padding-top: 20px;">问题标题：<s:property value="questions.captionText"/><a href="<%=contextPath%>/member/QAManage" style="float: right;color: blue; padding-right: 10px;">返回问答管理列表</a></h3> 
            </div>
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
					<th>序号</th>
					<th>发表日期</th>
                    <th>投票次数</th>
					<th>管理</th>
                </tr>
                <s:if test="lstReplys.size>0">
                	<s:iterator value="lstReplys" status="reply">
                		<tr>
                			<td style="border-left:none"><font color="red"><s:property value="#reply.index+1"/></font></td>
                			<td><s:date name="replyTime" format="yyyy-MM-dd HH:mm:ss"/></td>
                			<td><s:property value="pollCount"/></td>
                			<td><a href="optimalAnswer.action?replyId=<s:property value='replyID'/>&questionId=<s:property value='questionID'/>">[选为最佳答案]</a>
                			<a target="_blank" href="<%=request.getContextPath()%>/answerQuestion?questionid=<s:property value='questionID'/>">[查看详情]</a></td>
                		</tr>
                		<tr>
                			<td>回答内容:</td>
                			<td colspan="3" align="left"><textarea rows="5" cols="80" readonly="readonly" style="text-align: left;"><s:property value="replyContent" escape="false"/></textarea></td>
                		</tr>
                	</s:iterator>
                </s:if>
                <s:else>
                	<tr><td colspan="4" align="center">该问题还没有回答</td></tr>
                </s:else>
            </table>
        </div>
		</div>
	</div>
</div>
</body>
</html>