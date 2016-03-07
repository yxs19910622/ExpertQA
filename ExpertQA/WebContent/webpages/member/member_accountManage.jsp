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
$('#resetPass').omButton({
	onClick : function(event){
		var selections=$('#accountGrid').omGrid('getSelections',true);
        if (selections.length == 0) {
        	showAlert('请至少选择一条记录');
        	return false;
        }else
        {
        	$.omMessageBox.prompt({
                title:'重置['+selections[0].aliasName+']的密码',
                content:'请输入要重置的密码',
                onClose:function(value){
                    if(value===false){ //按了取消或ESC
                        return;
                    }
                    if(value==''){
                    	showAlert('密码不能为空');
                        return false; //不关闭弹出窗口
                    }
                    else{
                    	window.location.href="accountManageSave.action?type=resetPassword&resetPass="+value+"&userId="+selections[0].userID;
                    }
                }
            });	
        }
	}
});
$('#updateUserTime').omButton({
	onClick : function(event){
		var selections = $('#accountGrid').omGrid('getSelections',true);
		if(selections.length == 0){
			showAlert('请至少选择一条记录');
			return false;
		}else{
			showDialog(selections[0]);
		}
	}
});
$('#query').omButton({
	onClick : function(event){
		var email = $('#customer_email').val();
		var role = $('#customer_role').val();
		var id = $('#customer_id').val();
		var alias = $('#customer_alias').val();
		$('#accountGrid').omGrid("setData", 'setHome!ajxAccountManage.action?email='+email+'&role='+role+'&id='+id+'&alias='+alias);
	}
});
$('#tryStart').omCalendar({showTime:true,editable:true,dateFormat:"yy-mm-dd H:i"});
$('#tryEnd').omCalendar({showTime:true,editable:true,dateFormat:"yy-mm-dd H:i"});
$('#serviceStart').omCalendar({showTime:true,editable:true,dateFormat:"yy-mm-dd H:i"});
$('#serviceEnd').omCalendar({showTime:true,editable:true,dateFormat:"yy-mm-dd H:i"});
$("#search-panel").omPanel({
	title : "高级查询",
	collapsible:true,
	collapsed:false,
	width : 750
});
$("#tools-panel").omPanel({
	title : "辅助工具",
	collapsible:true,
	collapsed:true,
	width : 750
});
$("#customer_role").omCombo({
	width : 138,
	editable : false,
	dataSource : [<s:property value="jsonRoleList"/>]
	
});
$('#accountGrid').omGrid({
    title : '帐号管理列表',
    limit : 50,
    width : 750,
    heiht : 500,
    autoFit : true,
    colModel : [{header : "邮箱地址",name : "email", width: "150", align : "left",sort:'clientSide'},
                {header : "真实姓名",name : "userName", width : "100", align : "center",sort:'clientSide'},
                {header : "所属角色",name : "roleName", width : "100", align : "center",sort:'clientSide'},
                {header : "昵称",name : "aliasName", width : "100", align : "center",sort:'clientSide'},
                {header : "客户号码",name : "customerID", width : "50", align : "center",sort:'clientSide'},
                {header : "帐号状态",name : "activeStatus", width : "50", align : "center",sort:'clientSide',renderer:genderStatus},
                {header : "试用开始日期",name : "tryStartDate", width : "150",align : "center",sort:'clientSide'},
                {header : "试用结束日期",name : "tryEndDate", width : "150",align : "center",sort:'clientSide'},
                {header : "服务开始日期",name : "serviceStartDate", width : "150",align : "center",sort:'clientSide'},
                {header : "服务结束日期",name : "serviceEndDate", width : "150",align : "center",sort:'clientSide'},
                {header : "注册日期",name : "registerDate", width : "150",align : "center",sort:'clientSide'}
                ],
    dataSource : 'setHome!ajxAccountManage.action'
});
});
function showAlert(info){
    $.omMessageBox.alert({content:info});
}
function genderStatus(value)
{
	if(value=='1'){return "<span style='color:blue'>有效</span>";}
	else if(value=='0'){return "<span style='color:red'>无效</span>";}
}
$(function() {
	$( "#dialog-userTime").omDialog({
		autoOpen: false,
		height: 200,
		width: 600,
		modal: true,
		buttons : {
	        "提交" : function(){
	        	submitDialog();
	            return false; //阻止form的默认提交动作
	        },
	        "取消" : function() {
	            $("#dialog-userTime").omDialog("close");//关闭dialog
	        }
	    }
	});
});
var submitDialog = function(){
	$('#userTimeForm').submit();
	$("#dialog-hyper").omDialog("close");
};
//显示dialog并初始化里面的输入框的数据
var showDialog = function(rowData){
	$('#userTimeForm').resetForm();
	if(rowData!=null)
	{
		$('#userTime_email').val(rowData.email);
		$('#userTime_customerId').val(rowData.customerID);
		$('#userTime_userId').val(rowData.userID);
		$('#tryStart').val(rowData.tryStartDate);
		$('#tryEnd').val(rowData.tryEndDate);
		$('#serviceStart').val(rowData.serviceStartDate);
		$('#serviceEnd').val(rowData.serviceEndDate);
	}
	$("#dialog-userTime").omDialog("option", "title", "修改用户服务日期");
	$("#dialog-userTime").omDialog('open');
};
</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="accountManage" name="currOpt"/>
</jsp:include>
	<div class="wbgRight_user">
    <div class="lesson_tit">帐号管理</div>
    <div id="tools-panel">
    <input type="button" id="resetPass" value="重置密码">
    <input type="button" id="updateUserTime" value="设置用户服务日期">
    </div>
    <div id="search-panel">
   	客户昵称：<input id="customer_alias" type="text"/>
	客户角色：<input id="customer_role"/><br /><br />
	客户号码：<input id="customer_id" type="text"/>
	客户邮箱：<input id="customer_email" type="text" style="width: 138px"/><br /><br />
    		 <input type="button" id="query" value="查  询"/>
    		 <!-- [<s:property value="jsonRoleList"/>] -->
    </div>
    <div id="accountButton"></div>
    <table id="accountGrid"></table>
	</div>
</div>
<div id="dialog-userTime">
	<form action="updateUserTime.action" id="userTimeForm" method="post">
		<table>
			<tr>
				<td width="20%">客户邮箱： </td>
				<td width="80%" colspan="3"><input type="text" id="userTime_email" readonly="readonly" style="width: 435px;"/></td>
			</tr>
			<tr>
				<td>客户号码： </td>
				<td colspan="3"><input type="text" id="userTime_customerId" readonly="readonly" style="width: 435px;"/></td>
			</tr>
	        <tr>
	        	<td>试用开始日期：</td>
	            <td width="150px;"><input id="tryStart" name="tryStart" style="width: 150px;"/></td>
	            <td>试用结束日期</td>
	            <td width="150px;"><input id="tryEnd" name="tryEnd" style="width: 150px;"/></td>
	        </tr>
	        <tr>
	        	<td>服务开始日期：</td>
	            <td width="150px;"><input id="serviceStart" name="serviceStart" style="width: 150px;"/></td>
	            <td>服务结束日期: </td>
	            <td width="150px;"><input id="serviceEnd" name="serviceEnd" style="width: 150px;"/></td>
	        </tr>
		</table>
		<input type="hidden" id="userTime_userId" name="userTime_userId"/>
	</form>
</div>
</body>
</html>