<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
$('#accountGrid').omGrid({
    title : '问答管理列表',
    limit : 50,
    width : 750,
    heiht : 500,
    autoFit : true,
    colModel : [{header : "标题",name : "captionText", width : "400", align : "center",sort:'clientSide'},
                {header : "回答数量",name : "replyCount", width : "45", align : "center",sort:'clientSide'},
                {header : "问题状态",name : "createTime", width : "50", align : "center",sort:'clientSide',renderer:function(colValue, rowData, rowIndex){
                	if(rowData.isAlreadyClosed==1)
                	{
                		return "<span style='color:blue'>已关闭</span>";
                	}
                	if(rowData.isAlreadyChecked==0)
                	{
                		return "<span style='color:red'>未审核</span>"
                	}else{
                		return "<span style='color:green'>已审核</span>"
                	}
                }},
                {header : "发表日期",name : "createTime", width : "110", align : "center",sort:'clientSide'},
                {header : "管理",name : "manage", width : "110", align : "center",renderer:function(colValue, rowData, rowIndex){
                	var result="";
                	if(rowData.isAlreadyClosed==0 && (rowData.isAlreadyChecked==1||rowData.isAlreadyChecked==4))
                	{
                		result+='<input type="button" onclick="showReply(\''+rowData.questionID+'\')" value="设置答案"/>';
                	}else{
                		result+='<input type="button" onclick="showQuestion(\''+rowData.questionID+'\')" value="查看问题">';
                	}
                	if(rowData.isAlreadyDeleted==0)
                	{
                		result+='<input type="button" onclick="delQuestion(\''+rowData.questionID+'\',\''+rowData.replyCount+'\')" value="删除">';
                	}
                	return result;
                }
                },
                ],
    dataSource : 'setHome!ajxQAManage.action'
});
});
function showReply(questionId){
	window.location.href="showReply.action?questionId="+questionId;
}
function showQuestion(questionId){
	window.open('<%=request.getContextPath()%>/answerQuestion?questionid='+questionId);
}
function delQuestion(questionId,count){
	var info = (count==0)?'您确定要删除吗？':'该提问有'+count+'个回答，您确定要删除吗？';
	info +='<font color="red">(删除后不可恢复!)</font>';
	$.omMessageBox.confirm({
		title : '删除提示',
		content : info,
		onClose : function(v) {
			if(v)
			{
				window.location.href="delQuestion.action?questionId="+questionId;
			}
		}
	});
}
</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="QAManage" name="currOpt"/>
</jsp:include>
	<div class="wbgRight_user">
    <div class="lesson_tit">问答管理</div>
    <table id="accountGrid"></table>
	</div>
</div>
</body>
</html>