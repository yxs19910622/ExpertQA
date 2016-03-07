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
$(document).ready(function(){
$('#bnt').omButton({
        width : 60,
        onClick : function(event){
            var qatype = $("#type").val();
            var questionID = $("#questionID").val();
            if(qatype==null || qatype=='')
            {
            	alert('请选择类型!');
            	return;
            }
          	window.location.href="auditQuestion.action?type=1&questionID="+questionID+"&qatype="+qatype;
            $("#dialog").omDialog('close');
        }
});
$("#tree").omTree({
    dataSource : [<s:property value="jsonAuditQAType"/>],
    simpleDataModel: true,
    onSelect: function(nodedata){
    	   var ndata = nodedata, text = ndata.text;
    	   $("#position").val(text);
    	   $("#type").val(ndata.id);
    	   hideDropList();
    }
 });
//点击下拉按钮显示下拉列表
$("#choose").click(function(){
	showDropList();
});
//点击输入框显示下拉列表
$("#position").val("").click(function(){
	showDropList();
});
function showDropList(){
	var cityInput = $("#position");
	var cityOffset = cityInput.offset();
	var topnum = cityOffset.top+cityInput.outerHeight();
	if($.browser.msie&&($.browser.version == "6.0"||$.browser.version == "7.0")){
		topnum = topnum + 2;
	}
	$("#droplist").css({left: cityOffset.left + "px",top: topnum +"px"})
	              .show();
	//body绑定mousedown事件，当事件对象非下拉框、下拉按钮等下拉列表隐藏。
	$("body").bind("mousedown", onBodyDown);
}
function hideDropList() {
	$("#droplist").hide();
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "choose" || event.target.id == "droplist" || $(event.target).parents("#droplist").length>0)) {
		hideDropList();
	}
}
});
$(function() {
	$( "#dialog").omDialog({
		autoOpen: false,
		height: 400,
		width: 500,
		modal: true
	});
});
function showModelDialog(questionID,qaTypeName,qaTypeID){
	$("#questionID").val(questionID);
	$("#position").val(qaTypeName);
	$("#type").val(qaTypeID);
	$("#dialog").omDialog('open');
}
</script>
<style type="text/css">
#droplist {
	display: none;
	position: absolute;
	width: 158px;
	/* 兼容IE6,7 */
	*width: 154px;
	/* 兼容IE8 */
	width: 250px\0;
	height: 500px;
	border: 1px solid;
	overflow: auto;
	text-align: left;
}
body {
	height: 500px;
}
</style>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="auditQuestion" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
	<div class="lesson_tit">审核提问</div>
    <div class="user_divPub">                
        <div class="card_list">
            <table id="auditTable" border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
					<th width="5%">序号</th>
                    <th width="12%">发表人</th>
                    <th width="15%">问题类型</th>
					<th width="25%">标题</th>
                    <th width="15%">设置类型</th>
					<th width="30%">管理</th>
                </tr>
                <s:if test="lstQuestions!=null">
                	<s:iterator value="lstQuestions" status="question">
                		<tr>
						<td style="border-left:none"><s:property value="#question.index+1"/></td>
                    	<td><s:property value="author"/></td>
						<td style="text-align: left;"><s:property value="typeName"/>&nbsp;</td>
						<td style="text-align: left;"><s:property value="captionText"/></td>
                    	<td><s:date name="createTime" format="yyyy-MM-dd HH:mm"/></td>
                    	<td><a href="#" onclick="javascript:showModelDialog('<s:property value='questionID'/>','<s:property value="typeName"/>','<s:property value="qaTypeID"/>')" class="a1">[通过]</a>
                    		|<a href="delQuestion.action?questionId=<s:property value='questionID'/>" class="al">[删除]</a>
                    		|<a target="_blank" href="<%=request.getContextPath()%>/checkQuestion?questionid=<s:property value='questionID'/>" class="a1">[查看详情]</a></td>
                		</tr>
                	</s:iterator>
                </s:if>
            </table>
        </div>
    </div>
    </div>
</div>
<div id="dialog" title="请选择类型">
选择类型：<!--<span class="om-combo om-widget om-state-default">-->
			<input type="text" id="position" readonly="readonly" style="width: 300px;">
			<input type="hidden" id="type"/>
			<input type="hidden" id="questionID"/>
			<span id="choose" class="om-combo-trigger"></span>
			<input id="bnt" type="button" value="保存类型"/>
		<!--</span>-->
	<ul id="tree"></ul>
</div>
</body>
</html>