<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
$(document).ready(function() {
	$('#addKeyword').omButton({});
});
$("#keywordForm").validate({
	rules : {
		keyword : "required"
		},
    messages : {
    	keyword : {required : "请输入关键词"}
            },
		submitHandler : function(){
	        $("#keywordForm").omAjaxSubmit();
	        $('#keywordGrid').omGrid('reload');//刷新表格
	        return false;
	      }
        });
$('#keywordGrid').omGrid({
    title : '关键词列表',
    limit : 50,
    width : 450,
    heiht : 500,
    colModel : [{header : "关键词", name : "word", width : "250", align : "center",sort:'clientSide'},
                {header : "操作", name : "operation", width: "100", align:"center", renderer:function(colValue, rowData, rowIndex){
               	 return '<button id="delKeyword" onClick="delRowdata('+rowIndex+',event)">删除</button>';
                }}],
    dataSource : 'setHome!ajxKeyWordGrid.action'
});
function delRowdata(index, e){
	var data = $("#keywordGrid").omGrid("getData").rows[index];
	$("#keywordForm").omAjaxSubmit({
        url :"setHome.action?aid=keyword&type=del&keyword="+data.wordID
    });
	$('#keywordGrid').omGrid('reload');
	return false;
}
</script>
<html>
<body>
	<form action="setHome.action" id="keywordForm">
		<table>
			<tr>
				<td>关键词：<input type="text" name="keyword" style="width:350px;"/></td>
				<td><input id="addKeyword" type="submit" value="新增关键词"/></td>
			</tr>
		</table>
		<input type="hidden" name="type" value="add"/>
		<input type="hidden" name="aid" value="keyword"/>
	</form>
	<table id="keywordGrid"></table>
</body>
</html>
