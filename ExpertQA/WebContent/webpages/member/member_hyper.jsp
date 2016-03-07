<%@ page language="java" pageEncoding="UTF-8"%>
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
$('#hyperGrid').omGrid({
    title : '新闻速递列表<input type="button" value="新增" style="width:80px;float: right;" onclick="javascript:addHyper()"/>',
    limit : 50,
    width : 750,
    heiht : 500,
    autoFit : true,
    colModel : [{header : "新闻标题",name : "viewText", width : "400", align : "center",sort:'clientSide'},
                {header : "是否需要登录", name : "mustLogin", width : "80", align : "center",sort:'clientSide',renderer:genderLogin},
                {header : "操作", name : "operation", width: "150", align:"center", renderer:function(colValue, rowData, rowIndex){
               	 	return '<input type="button" value="修改" onclick="javascript:modHyper('+rowIndex+')"/><input type="button" value="删除" onclick="javascript:delHyper('+rowIndex+')"/><input type="button" value="查看" onClick="showDetail('+rowIndex+')"/>';
                }}],
    dataSource : 'setHome!ajxHyperGrid.action',
    rowDetailsProvider:function(rowData,rowIndex){
        return '链接地址：<font color="red">'+rowData.extendAddress+'</font>';
    }
});
});
$(function() {
	$( "#dialog-hyper").omDialog({
		autoOpen: false,
		height: 200,
		width: 530,
		modal: true,
		buttons : {
	        "提交" : function(){
	        	submitDialog();
	            return false; //阻止form的默认提交动作
	        },
	        "取消" : function() {
	            $("#dialog-hyper").omDialog("close");//关闭dialog
	        }
	    }
	});
});
var submitDialog = function(){
	var title = $('#title');
	var address = $('#address');
	if(title.val()=='' || title.val()==null)
	{alert('请填写新闻标题!');title.focus();}
	else if(address.val()=='' || address.val()==null)
	{alert('请填写链接地址!');address.focus();}
	else{
		$('#hyperForm').submit();
		$("#dialog-hyper").omDialog("close");
	}
};
//显示dialog并初始化里面的输入框的数据
var showDialog = function(title,type,rowData){
	$('#hyperForm').resetForm();
	if(rowData!=null)
	{
		$('#tid').val(rowData.tid);
		$('#title').val(rowData.viewText);
		$('#address').val(rowData.extendAddress);
		if(rowData.mustLogin == 'TRUE')
		{
			$('#mustLogin').attr("checked",true);
		}else{
			$('#mustLogin').attr("checked",false);
		}
	}
	$('#type').val(type);
	$("#dialog-hyper").omDialog("option", "title", title);
	$("#dialog-hyper").omDialog('open');
};
function genderLogin(value)
{
	if(value=='FALSE'){return "<span style='color:blue'>否</span>";}
	else if(value=='TRUE'){return "<span style='color:red'>是</span>";}
}
function addHyper()
{
	showDialog('新增','add');
}
function modHyper(index)
{
	var data = $("#hyperGrid").omGrid("getData").rows[index];
	showDialog('修改','mod',data);
}
function showDetail(index){
	var data = $("#hyperGrid").omGrid("getData").rows[index];
	window.open(data.extendAddress);
}
function delHyper(index)
{
	$.omMessageBox.confirm({
		title : '确认删除',
		content : '你确定要这样做吗？',
		onClose : function(v) {
			if(v)
			{
				var data = $("#hyperGrid").omGrid("getData").rows[index];
				$('#tid').val(data.tid);
				$('#type').val("del");
				$('#hyperForm').submit();
			}
		}
	});
}
</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="hyper" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
    <div class="lesson_tit">新闻速递</div>
    	<table id="hyperGrid"></table>
	</div>
</div>
<div id="dialog-hyper">
	<form action="hyper" id="hyperForm" method="post">
		<table>
	        <tr>
	        	<td>新闻标题：</td>
	            <td><input type="text" id="title" name="hle.viewText" style="width: 380px;"/></td>
	        </tr>
	        <tr>
	        	<td>链接地址：</td>
	            <td><input type="text" id="address" name="hle.extendAddress" style="width: 380px;"/></td>
	        </tr>
	        <tr>
	        	<td>是否需要登录：</td>
	            <td><input type="checkbox" id="mustLogin" name="hle.mustLogin"/></td>
	        </tr>
		</table>
		<input type="hidden" id="type" name="type"/>
		<input type="hidden" id="tid" name="hle.tid"/>
	</form>
</div>
</body>
</html>