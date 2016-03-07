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
<style type="text/css">
	div.snake {text-decoration:underline}
</style>
</head>


<script type="text/javascript">

//多表头以行进行分类，在写colModel时，每个数组代表一行标题
var colModel = 
    [
     	//第一行
     	[/**
     	 *  "公司 "是有业务意义的，异步取数回来就有关于"公司"的信息，所以要加上"name"属性。
     	 *  此外，"公司"占了两行，所以要加上 rowspan:2。
     	 */
     	 {header:"学习内容" , name:"learningContent" , rowspan:2 , width:150,align : "center",sort:'serverSide'}, 
     	 {header:"一级目录" , name:"level1" , rowspan:2 , width:50,align : "center",sort:'serverSide'}, 
     	 {header:"二级目录" , name:"level2" , rowspan:2 , width:50,align : "center",sort:'serverSide'}, 
     	 {header:"三级目录" , name:"level3" , rowspan:2 , width:50,align : "center",sort:'serverSide'}, 
     	 /**
     	 *   "联系方式"是没有实际业务意义的，它只是作为"地址"、"联系方式"、"公司主页"这三列的统称，所以这里一定不要加上 "name"属性，切记！
     	 *   另外，由于"联系方式"实际上占了三列，所以要加上 colspan:3，不然会得不到正确的视图。
     	 */
     	 {header:"用户在待续费期间" , colspan:3},
    	 {header:"付费用户在待续费期" , colspan:3},
    	 {header:"用户付费期间" , colspan:3},
    	 {header:"待续费用户在付费期" , colspan:3},
    	 {header:"付费和待续费用户在付费之前" , colspan:3},
    	 {header:"未付费用户" , colspan:3},
    	 {header:"游客" , colspan:3},
    	 {header:"注册客户在注册之前" , colspan:3}],
     	
     	//第二行
     	//"公司"和"主打产品"要定义在第一行，而不是第二行。
     	[
     	 {header:"总人数" , name:"headcount1" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount1" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime1" , width:50,align : "center",sort:'serverSide'},
     	
     	 {header:"总人数" , name:"headcount2" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount2" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime2" , width:50,align : "center",sort:'serverSide'},
     	
     	 {header:"总人数" , name:"headcount3" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount3" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime3" , width:50,align : "center",sort:'serverSide'},
     	
     	 {header:"总人数" , name:"headcount4" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount4" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime4" , width:50,align : "center",sort:'serverSide'},
     	
     	 {header:"总人数" , name:"headcount5" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount5" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime5" , width:50,align : "center",sort:'serverSide'},
     
     	 {header:"总人数" , name:"headcount6" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount6" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime6" , width:50,align : "center",sort:'serverSide'},
     
     	 {header:"总人数" , name:"headcount7" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount7" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime7" , width:50,align : "center",sort:'serverSide'},
     
     	 {header:"总人数" , name:"headcount8" , width:50,align : "center",sort:'serverSide'},
     	 {header:"总次数" , name:"timescount8" , width:50,align : "center",sort:'serverSide'},
     	 {header:"学习时长" , name:"learningTime8" , width:50,align : "center",sort:'serverSide'}]
   
     ];


$(document).ready(function() {
	
$('#payGrid').omGrid({
    title : '学习时长统计',
    limit : 40,
    width : 870,
    heiht : 500,
    autoFit : false,
    colModel : colModel,
    dataSource : 'setHome!ajaxStat_3.action',
    onSuccess:function(data,testStatus,XMLHttpRequest,event){
    	setTimeout('snake_1()',1000);
    	setTimeout('snake_3()',1000);
    	
    }
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
function snake_2(){
	 a = document.getElementById("div");
	 if(a.style.display=='none'){
		 a.style.display='block';
	 }else{
		 a.style.display='none';
	 }
}
function addNode(){
	
	var div3 = document.getElementById("div3");
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
	div3.appendChild(obj);
	div3.appendChild(div4);
	
	addNode_1();
}
function addNode_1(){
	document.getElementById("div3_1").style.display='none';
	document.getElementById("div4_1").style.display='none';
}


</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="PayHistory" name="currOpt"/>
</jsp:include>
	<div class="wbgRight_user">
    <div class="lesson_tit">学习时长统计</div>
    <tr> 
	<td width="300">账户状态状态</td>
	<td><font size="-1"> 
		<select name="zt" id="zt"><option value="01" selected="selected"></option><option value="02">测试账户</option><option value="03">正常用户</option></select>
	</font></td>
	</tr>
    <tr> 
	<td>统计时间范围</td>
    <td>
    <input type="text" id="startdate"/>
    <input type="text" id="enddate"/>
    <input value="开始查询" type="button" onclick="snake()">
    </td>
</tr>
    <div style="position:relative;"><table id="payGrid"></table>
    	<div style="position:absolute;top:20px;left:60px;" id="div3">
			<table id="grid"></table><div id="div4" style="position:absolute;top:2px;right:2px;display:none;"><button onclick="addNode()">关闭</button></div>
			
		</div>
		<div style="position:absolute;top:40px;left:500px;" id="div3_1">
				<table id="grid1"></table><div id="div4_1" style="position:absolute;top:2px;right:2px;display:none;"><button onclick="addNode_1()">关闭</button></div>
		</div>
    </div>
    <br/><br/>
    <form action="setHome!ajxStat_1.action" name="f1" target="_blank">
<table width="100%" border="0" cellpadding="2" cellspacing="0" id="t1">

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
	<div id="div1" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">用户在待续费期间（用户（操作时）状态=待续费）</div>
	<div id="div2" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">付费用户在待续费期间（用户（操作时）状态待续费 and 用户（当前）状态=已付费）</div>
	<div id="div3" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">用户付费期间（用户操作状态=已付费)</div>
	<div id="div4" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">待续费用户在付费期间（用户（操作时）状态=已付费 and 用户（当前）状态=待续费）</div>
	<div id="div5" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">付费用户和待续费用户在付费之前（用户（操作时）状态=未付费 and 用户（当前）状态=已付费 or 待续费）</div>
	<div id="div6" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">未付费用户（用户（操作）状态=未付费 and 用户（当前）状态=未付费）</div>
	<div id="div7" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">游客（用户（操作）状态=游客 and 用户（当前）状态=游客）</div>
	<div id="div8" style="color:red;position:absolute;display:none;border:1px solid silver;background:silver;">注册客户在注册之前（用户（操作）状态=游客 and 用户（当前）状态!=游客）</div>
<script type="text/javascript">
function snake(){
	var sd = document.getElementById("startdate").value;
	var ed = document.getElementById("enddate").value;
	var zt = document.getElementById("zt").options[document.getElementById("zt").selectedIndex].value;
	var colModel = 
	    [
	     	//第一行
	     	[/**
	     	 *  "公司 "是有业务意义的，异步取数回来就有关于"公司"的信息，所以要加上"name"属性。
	     	 *  此外，"公司"占了两行，所以要加上 rowspan:2。
	     	 */
	     	 {header:"学习内容" , name:"learningContent" , rowspan:2 , width:150,align : "center",sort:'serverSide'}, 
	     	 {header:"一级目录" , name:"level1" , rowspan:2 , width:50,align : "center",sort:'serverSide'}, 
	     	 {header:"二级目录" , name:"level2" , rowspan:2 , width:50,align : "center",sort:'serverSide'}, 
	     	 {header:"三级目录" , name:"level3" , rowspan:2 , width:50,align : "center",sort:'serverSide'}, 
	     	 /**
	     	 *   "联系方式"是没有实际业务意义的，它只是作为"地址"、"联系方式"、"公司主页"这三列的统称，所以这里一定不要加上 "name"属性，切记！
	     	 *   另外，由于"联系方式"实际上占了三列，所以要加上 colspan:3，不然会得不到正确的视图。
	     	 */
	     	{header:"用户在待续费期间" , colspan:3},
	    	 {header:"付费用户在待续费期" , colspan:3},
	    	 {header:"用户付费期间" , colspan:3},
	    	 {header:"待续费用户在付费期" , colspan:3},
	    	 {header:"付费和待续费用户在付费之前" , colspan:3},
	    	 {header:"未付费用户" , colspan:3},
	    	 {header:"游客" , colspan:3},
	    	 {header:"注册客户在注册之前" , colspan:3}],
	     	
	     	//第二行
	     	//"公司"和"主打产品"要定义在第一行，而不是第二行。
	     	[
	     	 {header:"总人数" , name:"headcount1" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount1" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime1" , width:50,align : "center",sort:'serverSide'},
	     	
	     	 {header:"总人数" , name:"headcount2" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount2" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime2" , width:50,align : "center",sort:'serverSide'},
	     	
	     	 {header:"总人数" , name:"headcount3" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount3" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime3" , width:50,align : "center",sort:'serverSide'},
	     	
	     	 {header:"总人数" , name:"headcount4" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount4" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime4" , width:50,align : "center",sort:'serverSide'},
	     	
	     	 {header:"总人数" , name:"headcount5" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount5" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime5" , width:50,align : "center",sort:'serverSide'},
	     
	     	 {header:"总人数" , name:"headcount6" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount6" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime6" , width:50,align : "center",sort:'serverSide'},
	     
	     	 {header:"总人数" , name:"headcount7" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount7" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime7" , width:50,align : "center",sort:'serverSide'},
	     
	     	 {header:"总人数" , name:"headcount8" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"总次数" , name:"timescount8" , width:50,align : "center",sort:'serverSide'},
	     	 {header:"学习时长" , name:"learningTime8" , width:50,align : "center",sort:'serverSide'}]
	   
	     ];
	
	$('#payGrid').omGrid({
		title : '学习时长统计',
	    limit : 40,
	    width : 870,
	    heiht : 500,
	    autoFit : false,
	    colModel : colModel,
	    dataSource : 'setHome!ajaxStat_3.action?sd='+sd+'&ed='+ed+'&zt='+zt
	});
}
function snake_3(){
	var obj = document.getElementsByTagName("div");//先得到所有的div标记
	for(var i=0;i<obj.length;i++)
	{
		if(obj[i].className == 'innerCol ')//找出div标记中class=innerCol 的那个标记
		{
			var getObj = obj[i];
			
			var name = getObj.parentNode.className;
			if(name == 'col4'||name == 'col7'||name == 'col10'||name == 'col13'||name == 'col16'||name == 'col19'||name == 'col22'||name == 'col25'){
				if(getObj.innerHTML!='0'){
					getObj.style.color='blue';
				}
			}
			
			getObj.onmouseover=function(){
				var event = window.event.srcElement;
				var name = window.event.srcElement.parentNode.className;
				if(name == 'col4'||name == 'col7'||name == 'col10'||name == 'col13'||name == 'col16'||name == 'col19'||name == 'col22'||name == 'col25'){
					if(event.innerHTML!='0'){
						event.className="snake";
						event.style.cursor='pointer';
					}
				}
			};
			
			
			getObj.onmouseout=function(){
				var event = window.event.srcElement;
				var name = window.event.srcElement.parentNode.className;
				if(name == 'col4'||name == 'col7'||name == 'col10'||name == 'col13'||name == 'col16'||name == 'col19'||name == 'col22'||name == 'col25'){
					if(event.innerHTML!='0'){
						event.className="";
						event.style.cursor='none';
					}
				}
			};
			
			
			getObj.onclick=function(){
				var p = window.event.srcElement.parentNode;
				var name = window.event.srcElement.parentNode.className;
				if(name == 'col4'||name == 'col7'||name == 'col10'||name == 'col13'||name == 'col16'||name == 'col19'||name == 'col22'||name == 'col25'){
					if(event.innerHTML!='0'){
						var c = p.parentNode.childNodes;
						for(var x=0;x<c.length;x++){
							if(c[x].className=='col0'){
								var data = c[x].childNodes[0].innerHTML;
								showDIV(data,name);
								document.getElementById("div4").style.display='block';
							}
						}
					}
				}
			};
				
		}
	}
}
function snake_1(){
	var obj = document.getElementsByTagName("div");//先得到所有的div标记
	for(var i=0;i<obj.length;i++)
	{
		if(obj[i].className == '')//找出div标记中class=innerCo1 的那个标记
		{
			var getObj = obj[i];
			value = getObj.innerHTML;//获得他的innerHTML
			if(value=='用户在待续费期间'){
				getObj.onmouseover=function(){
					show("div1");
				};
				getObj.onmouseout=function(){
					hide("div1");
				};
			}else if(value=='付费用户在待续费期'){
				getObj.onmouseover=function(){
					show("div2");
				};
				getObj.onmouseout=function(){
					hide("div2");
				};
			}else if(value=='用户付费期间'){
				getObj.onmouseover=function(){
					show("div3");
				};
				getObj.onmouseout=function(){
					hide("div3");
				};
			}else if(value=='待续费用户在付费期'){
				getObj.onmouseover=function(){
					show("div4");
				};
				getObj.onmouseout=function(){
					hide("div4");
				};
			}else if(value=='付费和待续费用户在付费之前'){
				getObj.onmouseover=function(){
					show("div5");
				};
				getObj.onmouseout=function(){
					hide("div5");
				};
			}else if(value=='未付费用户'){
				getObj.onmouseover=function(){
					show("div6");
				};
				getObj.onmouseout=function(){
					hide("div6");
				};
			}else if(value=='游客'){
				getObj.onmouseover=function(){
					show("div7");
				};
				getObj.onmouseout=function(){
					hide("div7");
				};
			}else if(value=='注册客户在注册之前'){
				getObj.onmouseover=function(){
					show("div8");
				};
				getObj.onmouseout=function(){
					hide("div8");
				};
			}
		}
	}
}
function show(id) {    

    var objDiv = $("#"+id+"");

    $(objDiv).css("display","block");

    $(objDiv).css("left", event.clientX);

    $(objDiv).css("top", event.clientY+50);  

}

function hide(id) {

    var objDiv = $("#"+id+"");

    $(objDiv).css("display", "none");

} 
function showDIV(data,name){
	var Sys = {};

    var ua = navigator.userAgent.toLowerCase();

    var s;

    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :

    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :

    (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :

    (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :

    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
	$('#grid').omGrid({
	    title : '表内查询',
	    limit : 40,
	    width : 450,
	    height : 400,
	    autoFit : true,
	    colModel : [{header : "用户状态",name : "currentuserstate", width : "100", align : "center",sort:'serverSide'},
	                {header : "用户帐户",name : "loginname", width : "135", align : "center",sort:'serverSide'},
	                {header : "设备编号",name : "deviceserial", width : "130", align : "center",sort:'serverSide'}],
	    dataSource : 'setHome!ajaxStat_3.action?learn='+data+'&name='+name+'&sys='+s,
	    onRowClick:function(rowIndex,rowData,event){
	    	$('#grid1').omGrid({
	    	    title : '表内查询',
	    	    limit : 40,
	    	    width : 400,
	    	    height : 200,
	    	    autoFit : true,
	    	    colModel : [{header : "总使用时长",name : "durationcount", width : "80", align : "center",sort:'serverSide'},
	    	                {header : "总操作次数",name : "timescount", width : "135", align : "center",sort:'serverSide'},
	    	                {header : "总使用次数",name : "usecount", width : "110", align : "center",sort:'serverSide'}],
	    	    dataSource : 'setHome!ajaxStat_1.action?loginname='+rowData.loginname+'&deviceserial='+rowData.deviceserial,
	    	    		
	    	});
	    	document.getElementById("div3_1").style.display='block';
	    	document.getElementById("div4_1").style.display='block';
	    	
	    }		
	});
	//document.getElementById("div3").style.display='block';
	document.getElementById("div4").style.display='block';
}
</script>	
	
</div>
</body>
</html>