<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
$(document).ready(function() {
	$('#addPlacard').omButton({});
});
$("#placardForm").validate({
	rules : {
		value : "required"
		},
    messages : {
    	value : {required : "请输入公告内容"}
            },
		submitHandler : function(){
	        $("#placardForm").omAjaxSubmit();
	        $('#placardGrid').omGrid('reload');//刷新表格
	        return false;
	      }
        });
$('#placardGrid').omGrid({
    title : '公告列表',
    limit : 50,
    width : 725,
    heiht : 500,
    colModel : [{header : "公告内容", name : "content", width : "450", align : "center",sort:'clientSide'},
                {header : "显示状态", name : "status", width : "50", align : "center",sort:'clientSide',renderer:genderStatus},
                {header : "操作", name : "operation", width: "140", align:"center", renderer:function(colValue, rowData, rowIndex){
               	 return '<button onClick="modRowdata('+rowIndex+',1)">显示</button>|<button onClick="modRowdata('+rowIndex+',0)">不显示</button>|<button onClick="delRowdata('+rowIndex+',event)">删除</button>';
                }}],
    dataSource : 'setHome!ajxPlacardGrid.action'
});
function genderStatus(value)
{
	if(value==1){return "<span style='color:blue'>已显示</span>";}
	else if(value==0){return "<span style='color:red'>未显示</span>";}
}
function delRowdata(index, e){
	var data = $("#placardGrid").omGrid("getData").rows[index];
	window.location.href="setHome.action?aid=placard&type=del&tid="+data.tid;
}
function modRowdata(index, value){
	var data = $("#placardGrid").omGrid("getData").rows[index];
	window.location.href="setHome.action?aid=placard&type=status&tid="+data.tid+"&value="+value;
}
</script>
<html>
<body>
	<form action="setHome.action" id="placardForm">
		<table>
			<tr>
				<td>公告内容：<input type="text" name="value" style="width: 350px;"/></td>
				<!-- <td>公告内容:<textarea rows="3" cols="30" name="value"></textarea> </td> -->
				<td><input id="addPlacard" type="submit" value="新增公告"/></td>
			</tr>
		</table>
		<input type="hidden" name="type" value="add"/>
		<input type="hidden" name="aid" value="placard"/>
	</form>
	<table id="placardGrid"></table>
</body>
</html>
