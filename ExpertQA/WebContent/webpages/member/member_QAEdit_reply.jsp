<%@ page language="java" pageEncoding="UTF-8"%>
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
<jsp:param value="QAEdit" name="currOpt"/>
</jsp:include>
	<div class="wbgRight_user">
    <div class="lesson_tit">修改回答</div>
    <div class="user_divPub">                
        	<div class="card_list">
            	<table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
					<th width="8%">序号</th>
					<th width="72%">回答内容</th>
					<th width="10%">状态</th>
					<th width="10%">操作</th>
                </tr>
                <s:if test="lstReplys!=null">
                	<s:iterator value="lstReplys" status="reply">
                	<tr>
						<td style="border-left:none">第<s:property value="#reply.index+1"/>条</td>
						<td style="text-align: left;"><s:property value="replyContent" escape="false"/></td>
						<td>
						<s:if test="isAlreadyDeleted==1">
						<span style='color:blue'>已删除</span>
						</s:if>
						<s:elseif test="isAlreadyChecked==1">
						<span style='color:green'>已审核</span>
						</s:elseif>
						<s:elseif test="isAlreadyChecked==0">
						<span style='color:red'>未审核</span>
						</s:elseif>
						<s:elseif test="isAlreadyChecked==3">
						<span>未通过审核</span>
						</s:elseif>
						</td>
						<td><input type="button" value="修改" onclick="javascript:entryData('<s:property value="@org.izhong.expert.util.StringUtil@replaceBlank(replyContent)"/>','<s:property value="replyID"/>','<s:property value="questionID"/>')"/></td>
                	</tr>
                	</s:iterator>
                </s:if>
            	</table>
           </div>
			<script type="text/javascript" src="<%=contextPath%>/interface/compontents/operamasks-ui/editor/omeditor.js"></script>
			<script type="text/javascript">
			$(function(){
				var config = {
					toolbar_MyToolbar:[
						{ name: 'document', items : [ 'Preview' ] },
						{ name: 'styles', items : [ 'Styles','Format','Font','FontSize','TextColor'] },
						{ name: 'basicstyles', items : [ 'Bold','Italic','Strike','-','RemoveFormat' ] }
						],
						toolbar:'MyToolbar'};
					$('#replyContent').omEditor(config,{resizable:false});
				});
			function entryData(content,replyId,questionId){
				$('#replyId').val(replyId);
				$('#questionId').val(questionId);
				$('#replyContent').omEditor('setData',content);
				$('#replyContent').omEditor('insertHtml',content);
			}
			function saveData()
			{
				var replyId = $('#replyId').val();
				var questionId = $('#questionId').val();
				if(replyId!='' && replyId!=null && questionId!='' && questionId!=null)
				{
					var replyContent = $('#replyContent').omEditor('getData');
					if(replyContent!='' && replyContent!=null)
					{
						$('#editReplyForm').submit();
					}else{
						$.omMessageBox.alert({content:'请输入回答的内容!'});
					}
				}else{
					$.omMessageBox.alert({content:'请选择要修改的回答!'});
				}
			}
			function retList()
			{
				window.location.href="<%=contextPath%>/member/QAEdit";
			}
			</script>
			<form action="editReplySave.action" id="editReplyForm" method="post">
			<input type="hidden" id="replyId" name="reply.replyID"/>
			<input type="hidden" id="questionId" name="reply.questionID"/>
			<textarea id="replyContent" name="reply.replyContent" rows="" cols=""></textarea>
			<div align="center">
			<input type="button" value="返回列表" onclick="retList();" style="width: 80px;height: 30px;">
			<input type="button" value="保存" onclick="saveData();" style="width: 80px;height: 30px;"></div>
			</form>
    	</div>
	</div>
</div>
</body>
</html>