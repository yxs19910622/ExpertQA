<%@ page language="java" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/struts-tags" prefix="s"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/date.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jquery.validate.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/query.datepickercn.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jquery.ui-1.8.js"></script>
<link href="<%=contextPath%>/interface/resource/css/datePicker.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="javascript">
        $(document).ready(function () {
            $("#startdate").datepicker({dateFormat: 'yy-mm-dd'});
            $("#endDate").datepicker({dateFormat: 'yy-mm-dd'});
        });
        
        //插件的中文显示
        jQuery(function($){   
            $.datepicker.regional['zh-CN'] = {   
               clearText: '清除',   
               clearStatus: '清除已选日期',   
               closeText: '关闭',   
               closeStatus: '不改变当前选择',   
               prevText: '<上月',   
               prevStatus: '显示上月',   
               prevBigText: '<<',   
               prevBigStatus: '显示上一年',   
               nextText: '下月>',   
               nextStatus: '显示下月',   
               nextBigText: '>>',   
               nextBigStatus: '显示下一年',   
               currentText: '今天',   
               currentStatus: '显示本月',   
               monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],   
               monthNamesShort: ['一','二','三','四','五','六', '七','八','九','十','十一','十二'],   
               monthStatus: '选择月份',   
               yearStatus: '选择年份',   
               weekHeader: '周',   
               weekStatus: '年内周次',   
               dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],   
               dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],   
               dayNamesMin: ['日','一','二','三','四','五','六'],   
               dayStatus: '设置 DD 为一周起始',   
               dateStatus: '选择 m月 d日, DD',   
               dateFormat: 'yy-mm-dd',   
               firstDay: 1,   
               initStatus: '请选择日期',   
               isRTL: false};   
               $.datepicker.setDefaults($.datepicker.regional['zh-CN']);   
           });  
 </script>
<title>专家在线问答_会员中心</title>
</head>
<%-- <script type="text/javascript">
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

</script> --%>
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
<style type="text/css">
label.error {
	background: #fff6bf url('<%=contextPath%>/interface/resource/images/error.png') center no-repeat;
	background-position: 5px 50%;
	text-align: left;
	padding: 1px 10px 2px 20px;
	border: 1px solid #ffd324;
	display: none;
	width: 200px;
	margin-left: 10px;
	font-size: 12px;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$("#addCodeForm").validate({
        rules : {
        	preferentialno : {required:true,remote:'setHome!verifiCode.action?num='+Math.random()},
        	discountmoney : {required:true,digits:true},
        	startdate : {required:true},
        	enddate : {required:true},
        },
        messages : {
        	preferentialno : {required :"请输入优惠码",remote:'此优惠码已存在'},
        	discountmoney : {required :"请输入优惠金额",digits:'请输入正整数'},
        	startdate : {required :"请输入优惠开始日期"},
        	enddate : {required :"请输入优惠结束日期"},
       }
	});
});
</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="addCode" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
	<div class="lesson_tit">新增优惠码</div>
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" class="Ltd">
    	<tr>
        	<td width="100%" valign="top">
        		<form action="addCode.action" method="post" id="addCodeForm">
            	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
                   
					<tr>
                        <td style="height:30px" width="20%" align="right">优惠码：</td>
                        <td width="45%">
                        <input type="text" name="preferentialno" id="preferentialno"/>
                        <font color="red">*</font></td>
                        <td width="35%" class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">优惠金额：</td>
                        <td>
                        	<input type="text" name="discountmoney" id="discountmoney"/>
                        	<font color="red">*</font>
                        </td>
                        <td class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">优惠开始日期：</td>
                        <td><input type="text" id="startdate" name="startdate"/>
                        <font color="red">*</font></td>
                        <td class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">优惠结束日期：</td>
                        <td><input type="text" id="endDate" name="enddate"/>
                        <font color="red">*</font></td>
                        <td class="w_wrong"></td>
                    </tr>
<!--                      <tr>
                        <td style="height:30px" width="20%" align="right">用户编号：</td>
                        <td width="45%">
                        <input type="text" name="userID"/>
                        <a style="color:red;">可以为空<a/>
                        <td width="35%" class="w_wrong">
                        
                        </td> 
                    </tr>-->
						<tr>
                        <td >适用产品：
                        	<!-- <input type="text" name="applicableproduct"/> -->
                        	<td >
								<input type="checkbox" name="applicableproduct" value="P0003">劳动法顾问软件(标准版)<br>
	                        	<input type="checkbox" name="applicableproduct" value="P0001">劳动法实务手册(标准版)<br>
								<input type="checkbox" name="applicableproduct" value="P0002">劳动法顾问软件(专业版)<br>
								<input type="checkbox" name="applicableproduct" value="P0004">劳动法专家咨询(标准版)<br>
							</td>
                        		
                    </tr>
                     <tr>
                        <td style="height:50px" align="right"></td>
                        <td><input type="submit" class="botn_gary" value="保 存" title="保 存" /></td>
                    	<td></td>
                	</tr>
            	</table>
            	</form>
        	</td>
		</tr>
	</table>
	</div>
</div>

</body>

</html>