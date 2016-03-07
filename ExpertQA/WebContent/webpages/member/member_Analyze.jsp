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
<link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css<%-- <%=contextPath%>/interface/resource/css/datePicker.css --%>" rel="stylesheet" type="text/css"/>
<title>专家在线问答_会员中心</title>
</head>
<script type="text/javascript">
$(document).ready(function() {

$('#payGrid').omGrid({
    title : '操作分析列表',
    limit : 40,
    width : 870,
    heiht : 500,
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
    dataSource : 'setHome!ajxAnalyze.action'
});

$("#startdate").datepicker({dateFormat: 'yy-mm-dd'});
$("#enddate").datepicker({dateFormat: 'yy-mm-dd'});

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
   
	function BrowseFolder() {
	    var mypath = window.location.href;
	    alert("当前地址为：" + mypath);
		
	    var saveFolder="";
	    var Message = "请选择保存目录"; 
	    var Shell  = new ActiveXObject("Shell.Application");
	    var Folder = Shell.BrowseForFolder(0,Message,0x0000,0);
	    if(Folder !=null)
	    {
	       if(Folder == "桌面")
	       {
	          saveFolder = new ActiveXObject("wscript.shell").SpecialFolders("Desktop");
	       }
	        else
	       {
	          Folder = Folder?Folder.items().item().Path:'';
	          saveFolder = (/^\w:/.test(Folder))?Folder:'';
	       }
	       saveFolder.replace("%20"," ")//把路径中的20%还原为空格"" 
	       alert("您保存路径为:" + saveFolder);
	    }

    return saveFolder;
 }
	
	function snake_1(){
		var inputObj=document.createElement('input')
        inputObj.setAttribute('id','_ef');
        inputObj.setAttribute('type','file');
        inputObj.setAttribute("style",'visibility:hidden');
        document.body.appendChild(inputObj);
        inputObj.click();
        inputObj.value ;
	}
	function runSave(){    
	      if (imgFrame.location != "about:blank"){
	       window.imgFrame.document.execCommand("SaveAs");
	      } 
	  }    
	  function saveFace(){    
		  window.location.href='http://zhuanjia.haufe.cn/xls/a.xls';
	       //window.location.href='http://down.360safe.com/360safe_cq.exe';
	  } 
	  function snake_2(){
			 a = document.getElementById("div");
			 if(a.style.display=='none'){
				 a.style.display='block';
			 }else{
				 a.style.display='none';
			 }
		}
</script>

<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="PayHistory" name="currOpt"/>
</jsp:include>
	<div class="wbgRight_user">
    <div class="lesson_tit">操作记录列表</div>
	    
    <table id="payGrid"></table>
	<br/><br/>
	<input type="button" value="用户在待续费期间的操作信息" onclick="snake('01');setBg()">
	<input type="button" value="付费用户在待续费期间的操作信息" onclick="snake('02');setBg()">
	<input type="button" value="用户付费期间的操作信息" onclick="snake('03');setBg()">
	<input type="button" value="待续费用户在付费期间的操作信息" onclick="snake('04');setBg()">
	<input type="button" value="付费用户和待续费用户在付费之前的操作信息" onclick="snake('05');setBg()">
	<input type="button" value="未付费用户的操作信息" onclick="snake('06');setBg()">
	<input type="button" value="游客的操作信息" onclick="snake('07');setBg()">
	<input type="button" value="注册客户在注册之前的操作信息" onclick="snake('08');setBg()">
	<br/><br/>
	<form><!-- action="setHome!ajxAnalyze_1.action" name="f1" target="_blank" -->
<table width="100%" border="0" cellpadding="2" cellspacing="0" id="t1">
<tr> 
	<td width="300">账户状态状态</td>
	<td><font size="-1"> 
		<select name="zt" id="zt"><option value="01" selected="selected"></option><option value="02">测试账户</option><option value="03">正常用户</option></select>
	</font></td>
</tr>
<tr> 
	<td width="300">用户当前状态</td>
	<td><font size="-1"> 
		<select name="cs" id="cs"><option value="10" selected="selected"></option><option value="11">未付费</option><option value="12">已付费</option><option value="13">待续费</option><option value="14">游客</option></select>
	</font></td>
</tr>
<tr>
	<td width="300">用户操作时状态</td>
	<td><font size="-1"> 
		<select name="os" id="os"><option value="20" selected="selected"></option><option value="21">未付费</option><option value="22">已付费</option><option value="23">待续费</option><option value="24">游客</option></select>
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
	<td width="300">点击区域</td>
	<td><font size="-1"> 
		<select name="ot" id="ot">
		<option selected="selected"></option>
		<option value="1">应用</option>
		<option value="2">账户</option>
		<option value="3">咨询</option>
		<option value="4">工具</option>
		<option value="5">搜索</option>
		<option value="6">阅读</option>
		<option value="7">广告</option>
		<option value="8">其他</option>
		</select>
	</font></td>
</tr>
<tr> 
	<td>具体点击的地方</td>
	<td><input size="35" id="oa" maxlength="100"></td>
</tr>
<tr> 
	<td>操作时长</td>
    <td>
    <select id="time1">
    	<option selected="selected"></option>
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
	<td>操作的日期</td>
    <td>
    	<input type="text" id="startdate"/>
    	<input type="text" id="enddate"/>
    	<input value="开始查询" type="button" onclick="snake();setBg();">
    	<input value="导出为Excel" type="button" onclick='toExcel();'>
    </td>
</tr>
</table>
</form>
	<div><button onclick="snake_2()">查看用户类型定义</button></div>
	</div>
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
	</div>
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
    
	var zt = document.getElementById("zt").options[document.getElementById("zt").selectedIndex].value;
	var cs = document.getElementById("cs").options[document.getElementById("cs").selectedIndex].text;
	var os = document.getElementById("os").options[document.getElementById("os").selectedIndex].text;
	var ln = document.getElementById("loginname").value;
	var ds = document.getElementById("ds").value;
	var ot = document.getElementById("ot").options[document.getElementById("ot").selectedIndex].text;
	var oa = document.getElementById("oa").value;
	var t1 = document.getElementById("time1").options[document.getElementById("time1").selectedIndex].value;
	var t2 = document.getElementById("time2").value;
	var da = document.getElementById("startdate").value;
	var ed = document.getElementById("enddate").value;
	$('#payGrid').omGrid({
	    title : '操作分析列表',
	    limit : 40,
	    width : 870,
	    heiht : 500,
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
	    dataSource : 'setHome!ajxAnalyze.action?cs='+cs+'&os='+os+'&ln='+ln+'&ds='+ds+'&ot='+ot+'&oa='+oa+'&t1='+t1+'&da='+da+'&t2='+t2+'&sys='+s+'&obj='+obj+'&zt='+zt+'&ed='+ed
	});
}
function toExcel(){
	$.ajax({
		url:'setHome!excel.action',
		type:'post',
		data:'',
		dataType:'text',
		success:function(data){
			//var url = encodeURIComponent("http://zhuanjia.haufe.cn/xls/20140219155527操作记录列表查询游客的查询结果.xls");
			//window.location.href=data;
			downloadFile(data);
			//window.open(url);
		},
		error:function(){
			alert("下载出错!");
		}
	});
}
function downloadFile(url) {  
    try{
         var elemIF = document.createElement("iframe");  

         elemIF.src = url;  

         elemIF.style.display = "none";  

         document.body.appendChild(elemIF);  

     }catch(e){
	
	 }
	
}

</script>	
<SCRIPT LANGUAGE="JavaScript">
function setBg() {

for (var i=0;i<document.all.tags("input").length;i++) 
document.all.tags("input")[i].style.background='white'
event.srcElement.tagName=="INPUT"?event.srcElement.style.background='orange':"";
}
</SCRIPT>	

</body>
</html>