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
<jsp:param value="auditReply" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
	<div class="lesson_tit">审核回答</div>
    <div class="user_divPub">                
        <div class="card_list">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
					<th width="5%">序号</th>
                    <th width="50%">回答内容</th>
                    <th width="7%">投票次数</th>
                    <th width="15%">回答时间</th>
					<th width="23%">管理</th>
                </tr>
                <s:if test="lstReplys!=null">
                	<s:iterator value="lstReplys" status="replys">
                		<tr>
						<td style="border-left:none"><s:property value="#replys.index+1"/></td>
                    	<s:if test="replyContent.length()>30">
						<td style="text-align: left;" title="<s:property value='replyContent'/>"><s:property value="replyContent.substring(0,30)"/>&nbsp;</td>
						</s:if>
						<s:else>
						<td style="text-align: left;" title="<s:property value='replyContent'/>"><s:property value="replyContent"/>&nbsp;</td>
						</s:else>
						<td><s:property value="pollCount"/></td>
                    	<td><s:date name="replyTime" format="yyyy-MM-dd HH:mm"/></td>
                    	<td><a href="auditReply.action?type=1&replyId=<s:property value='replyID'/>&questionId=<s:property value='questionID'/>" class="a1">[通过]</a>
                    		|<a href="auditReply.action?type=2&replyId=<s:property value='replyID'/>" class="al">[删除]</a>
                    		  |<a target="_blank" href="<%=request.getContextPath()%>/checkQuestionReply?replyid=<s:property value='replyID'/>" class="a1">[查看详情]</a></td>
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