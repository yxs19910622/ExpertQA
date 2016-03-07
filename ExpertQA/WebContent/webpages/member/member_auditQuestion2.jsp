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
$('#grid').omGrid({
    title : '审核提问123列表',
    limit : 10,
    width : 750,
    heiht : 500,
    autoFit : true,
    colModel : [{header : "发表人",name : "author", width : "50", align : "center",sort:'clientSide'},
                {header : "问题类型", name : "typeName", width : "150", align : "center",sort:'clientSide',wrap:true},
                {header : "标题", name : "captionText", width : "300", align : "center",sort:'clientSide',wrap:true},
                {header : "操作", name : "operation", width: "150", align:"center", renderer:function(colValue, rowData, rowIndex){
               	 	return '<button onClick="showRowdata('+rowIndex+',event)">通过审核</button><button onClick="showDetail('+rowIndex+',event)">查看详情</button>';
                }}],
                //rowDetailsProvider:function(rowData,rowIndex){
                //	return '<div style="width:750px"><font color="#CCCCCC">标题：</font>'+rowData.captionText+'</br><font color="#CCCCCC">内容：</font>'+rowData.questionContent+'</div>';
                //},
    dataSource : 'setHome!ajxAuditQuestion.action'
    
});
//$(window).scroll(function (){
//	$("#grid").omGrid('resize');
//});
$('.selector').omGrid({loadingMsg : '正在加载数据...'});
});
function showRowdata(index, e){
	var data = $("#grid").omGrid("getData").rows[index];
	window.location.href='auditQuestion.action?questionID='+data.questionID;
}
function showDetail(index, e){
	var data = $("#grid").omGrid("getData").rows[index];
	window.location.href="#";
}
</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="auditQuestion" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
    <div class="lesson_tit">新增优惠码</div>
	<table id="grid"></table>
	</div>
</div>
</body>
</html>