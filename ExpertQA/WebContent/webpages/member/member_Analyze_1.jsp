<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/date.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/query.datepickercn.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jquery.validate.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jquery.ui-1.8.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css"/>
<title>专家在线问答_会员中心</title>
</head>


<script type="text/javascript">
$(document).ready(function() {

$('#payGrid').omGrid({
    title : '统计用户每次使用的时长和操作次数',
    limit : 40,
    width : 870,
    heiht : 500,
    autoFit : true,
    colModel : [{header : "用户账户",name : "loginname", width : "140", align : "center",sort:'serverSide'},
                {header : "用户状态",name : "status", width : "50", align : "center",sort:'serverSide'},
                {header : "设备编号",name : "dev", width : "130", align : "center",sort:'serverSide'},
                {header : "使用时间",name : "createtime", width : "130", align : "center",sort:'serverSide'},
                {header : "使用时长(分钟)",name : "time", width : "130", align : "center",sort:'serverSide'},
                {header : "点击次数",name : "sum", width : "130", align : "center",sort:'serverSide'}],
    dataSource : 'setHome!ajxAnalyze_1.action',
    onSuccess:function(data, testStatus, XMLHttpRequest, event){
    	alert(data.oid);
    },
    onRowClick:function(rowIndex,rowData,event){
    	$('#grid').omGrid({
    	    title : '表内查询',
    	    limit : 40,
    	    width : 700,
    	    height : 400,
    	    autoFit : true,
    	    colModel : [{header : "用户状态",name : "currentuserstate", width : "50", align : "center",sort:'serverSide'},
    	                {header : "操作状态",name : "operatuserstate", width : "50", align : "center",sort:'serverSide'},
    	                {header : "用户帐户",name : "loginname", width : "135", align : "center",sort:'serverSide'},
    	                {header : "设备编号",name : "deviceserial", width : "130", align : "center",sort:'serverSide'},
    	                {header : "点击区域",name : "operationtype", width : "50", align : "center",sort:'serverSide'},
    	                {header : "点击点",name : "operationarea", width : "80", align : "center",sort:'serverSide'},
    	                {header : "操作时间",name : "createtime", width : "120", align : "center",sort:'serverSide'},
    	                {header : "操作时长",name : "time", width : "45", align : "center",sort:'serverSide'},
    	                {header : "客户端类型",name : "projectname", width : "60", align : "center",sort:'serverSide'}],
    	    dataSource : 'setHome!ajxAnalyze.action?oid='+rowData.oid,
    	});
    	document.getElementById("div3").style.display='block';
    	document.getElementById("div4").style.display='block';
    }
});

$("#startdate").datepicker({dateFormat: 'yy-mm-dd'});


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
function snake_2(){
	 a = document.getElementById("div");
	 if(a.style.display=='none'){
		 a.style.display='block';
	 }else{
		 a.style.display='none';
	 }
}
function addNode(){
	document.getElementById("div3").innerHTML='';
	var obj = document.createElement('table');
	obj.id = 'grid';
	var div4 = document.createElement('div');
	div4.id='div4';
	div4.style.position='absolute';
	div4.style.top='2px';
	div4.style.right='2px';
	div4.style.display='none';
	var bt = document.createElement('button');
	bt.onclick=addNode;//方法不加引号,直接写
	bt.innerHTML='关闭';
	div4.appendChild(bt);
	var div3 = document.getElementById("div3");
	div3.appendChild(obj);
	div3.appendChild(div4);
}
</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="PayHistory" name="currOpt"/>
</jsp:include>
	<div class="wbgRight_user">
    <div class="lesson_tit">统计分析</div>
    <div style="position:relative;"><table id="payGrid"></table>
    	<div style="position:absolute;top:20px;left:50px;" id="div3">
			<table id="grid"></table><div id="div4" style="position:absolute;top:2px;right:2px;display:none;"><button onclick="addNode()">关闭</button></div>
		</div>
    </div>
    <br/><br/>
    <input type="button" value="用户在待续费期间的每次使用信息" onclick="snake('01');setBg()">
	<input type="button" value="付费用户在待续费期间的每次使用信息" onclick="snake('02');setBg()">
	<input type="button" value="用户付费期间的每次使用信息" onclick="snake('03');setBg()">
	<input type="button" value="待续费用户在付费期间的每次使用信息" onclick="snake('04');setBg()">
	<input type="button" value="付费用户和待续费用户在付费之前的每次使用信息" onclick="snake('05');setBg()">
	<input type="button" value="未付费用户的每次使用信息" onclick="snake('06');setBg()">
	<input type="button" value="游客的每次使用信息" onclick="snake('07');setBg()">
	<input type="button" value="注册客户在注册之前的每次使用信息" onclick="snake('08');setBg()">
	<br/><br/>
    <form action="setHome!ajxAnalyze_1.action" name="f1" target="_blank">
<table width="100%" border="0" cellpadding="2" cellspacing="0" id="t1">
<tr> 
	<td width="300">账户状态状态</td>
	<td><font size="-1"> 
		<select name="zt" id="zt"><option value="01" selected="selected"></option><option value="02">测试账户</option><option value="03">正常用户</option></select>
	</font></td>
</tr>
<tr> 
	<td width="300">用户账户</td>
	<td><input type="text" id="loginname" size="35" name="loginname" maxlength="100"></td>
</tr>


<tr>
	<td>设备编号</td>
	<td><input size="35" id="ds" maxlength="100"></td>
</tr>
<tr> 
	<td>使用时长</td>
    <td>
    <select id="time1">
    	<option value="30" selected="selected"></option>
		<option value="31">&gt;</option>
		<option value="32">&gt;=</option>
		<option value="33">=</option>
		<option value="34">&lt;</option>
		<option value="35">&lt;=</option>
    </select>
    <input type="text" id="time2"/>
    </td>
</tr>
<tr> 
	<td width="300">用户状态</td>
	<td><font size="-1"> 
		<select name="cs" id="cs"><option value="20" selected="selected"></option><option value="21">未付费</option><option value="22">已付费</option><option value="23">待续费</option><option value="24">游客</option></select>
	</font>
	<input value="开始查询" type="button" onclick="snake();setBg();"></td>
</tr>
</table>
</form>
</div>
<button onclick="snake_2()">查看用户类型定义</button>
	<br><br>
	<div id="div" style="display:none">
	<table width="650" align="left">
		<tr>
			<th align="left">用户类型定义:</th>
		</tr>
		<tr>
			<td align="left" style="font-size:12px;color:red;">1.用户在待续费期间（用户（操作时）状态=待续费）</td>
		</tr>
		<tr>
			<td align="left" style="font-size:12px;color:red;">2.付费用户在待续费期间（用户（操作时）状态待续费 and 用户（当前）状态=已付费）</td>
		</tr>
		<tr>
			<td align="left" style="font-size:12px;color:red;">3.用户付费期间（用户操作状态=已付费）</td>
		</tr>
		<tr>
			<td align="left" style="font-size:12px;color:red;">4.待续费用户在付费期间（用户（操作时）状态=已付费 and 用户（当前）状态=待续费）</td>
		</tr>
		<tr>
			<td align="left" style="font-size:12px;color:red;">5.付费用户和待续费用户在付费之前（用户（操作时）状态=未付费 and 用户（当前）状态=已付费 or 待续费）</td>
		</tr>
		<tr>
			<td align="left" style="font-size:12px;color:red;">6.未付费用户（用户（操作）状态=未付费 and 用户（当前）状态=未付费）</td>
		</tr>
		<tr>
			<td align="left" style="font-size:12px;color:red;">7.游客（用户（操作）状态=游客 and 用户（当前）状态=游客）</td>
		</tr>
		<tr>
			<td style="font-size:12px;color:red;">8.注册客户在注册之前（用户（操作）状态=游客 and 用户（当前）状态!=游客）

			</td>
		</tr>
	</table>
	<br><br>	
	</div>

<script type="text/javascript">
function snake(obj){
	
	var Sys = {};

    var ua = navigator.userAgent.toLowerCase();

    var s;

    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :

    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :

    (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :

    (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :

    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
	
	/* var cs = document.getElementById("cs").options[document.getElementById("cs").selectedIndex].text; */
	var zt = document.getElementById("zt").options[document.getElementById("zt").selectedIndex].value;
	var os = document.getElementById("cs").options[document.getElementById("cs").selectedIndex].text;
	var ln = document.getElementById("loginname").value;
	var ds = document.getElementById("ds").value;
	var t1 = document.getElementById("time1").options[document.getElementById("time1").selectedIndex].text;
	var t2 = document.getElementById("time2").value;
	
	$('#payGrid').omGrid({
	    title : '统计用户每次使用的时长和操作次数',
	    limit : 40,
	    width : 870,
	    heiht : 500,
	    autoFit : true,
	    colModel : [{header : "用户账户",name : "loginname", width : "140", align : "center",sort:'serverSide'},
	                {header : "用户状态",name : "status", width : "50", align : "center",sort:'serverSide'},
	                {header : "设备编号",name : "dev", width : "130", align : "center",sort:'serverSide'},
	                {header : "使用时间",name : "createtime", width : "130", align : "center",sort:'serverSide'},
	                {header : "使用时长(分钟)",name : "time", width : "130", align : "center",sort:'serverSide'},
	                {header : "点击次数",name : "sum", width : "130", align : "center",sort:'serverSide'}],
	    dataSource : 'setHome!ajxAnalyze_1.action?os='+os+'&ln='+ln+'&ds='+ds+'&t1='+t1+'&t2='+t2+'&sys='+s+'&obj='+obj+'&zt='+zt
	});
}
</script>	
<SCRIPT LANGUAGE="JavaScript">
function setBg() {

for (var i=0;i<document.all.tags("input").length;i++) 
document.all.tags("input")[i].style.background='white'
event.srcElement.tagName=="INPUT"?event.srcElement.style.background='orange':"";
}
</SCRIPT>	
</div>
</body>
</html>