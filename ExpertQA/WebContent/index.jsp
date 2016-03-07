<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common_web.jsp"/>
<title>最大、最专业的企业劳动法专家问答平台-浩富</title>
<meta name="keywords" content="易中，企业劳动法，最新劳动法案例大全，劳动法书籍手册，劳动法综合解决方案，劳动法专家问答平台，招聘，劳动合同，员工管理、培训 、考核与处罚，工时、休假、报酬、福利，经济补偿、赔偿，向员工索赔，劳动纠纷、争议及调节、劳动仲裁与申诉，工伤，养老、医疗、失 业和生育保险，女工、未成年工保护"/> 
<meta name="description" content="易中企业劳动法专家问答平台为中小型企业的HR、中高层管理者提供最新劳动法综合解决方案。解决企业在招聘，劳动合同，员工管理、培训 、考核与处罚，工时、休假、报酬、福利，经济补偿、赔偿，向员工索赔，劳动纠纷、争议及调节、劳动仲裁与申诉，工伤，养老、医疗、失 业和生育保险，女工、未成年工保护等各种问题" />
<link rel="shortcut icon" href="/favicon.ico" />
<SCRIPT src="<%=request.getContextPath()%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/questionAbs.js'></script> 
<script type='text/javascript' src="<%=request.getContextPath()%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<style type="text/css"> /*登录框样式*/
/*全局样式*/
body{margin: 0;padding: 0;}
img,body,html{border:0;}
address,caption,cite,code,dfn,em,strong,th,var{font-style:normal;font-weight:normal;}
ol,ul{list-style:none;}
caption,th{text-align:left;}
h1,h2,h3,h4,h5,h6{font-size:100%;}
/*边角样式(圆角)*/
.x-box-tl{background:transparent url(images/corners.gif) no-repeat 0 0;zoom:1;}
.x-box-tc{height:8px;background:transparent url(images/tb.gif) repeat-x 0 0;overflow:hidden;}
.x-box-tr{background:transparent url(images/corners.gif) no-repeat right -8px;}
.x-box-ml{background:transparent url(images/l.gif) repeat-y 0;padding-left:4px;overflow:hidden;zoom:1;}
.x-box-mc{background:#eee url(images/tb.gif) repeat-x 0 -16px;padding:4px 10px;font-family:"Myriad Pro","MyriadWeb","Tahoma","Helvetica","Arial",sans-serif;color:#393939;font-size:12px;}
.x-box-mc h3{font-size:14px;font-weight:bold;margin:0 0 4px 0;zoom:1;}
.x-box-mr{background:transparent url(images/r.gif) repeat-y right;padding-right:4px;overflow:hidden;}
.x-box-bl{background:transparent url(images/corners.gif) no-repeat 0 -16px;zoom:1;}
.x-box-bc{background:transparent url(images/tb.gif) repeat-x 0 -8px;height:8px;overflow:hidden;}
.x-box-br{background:transparent url(images/corners.gif) no-repeat right -24px;}
.x-box-tl,.x-box-bl{padding-left:8px;overflow:hidden;}
.x-box-tr,.x-box-br{padding-right:8px;overflow:hidden;}
/*表单样式*/
.loginPanel {
	margin: -140px auto auto -180px;
	position: absolute;
	top: 50%;
	left: 50%;
	height: 400px;
	width:347px
}
.x-form-text {
	height:16px;
	line-height:16px;
	vertical-align:middle;
}
.x-form-text, textarea.x-form-field {
	background:#FFFFFF url(images/text-bg.gif) repeat-x scroll 0pt;
	border:1px solid #B5B8C8;
	padding:1px 1px;
}
}
</style>
<style type="text/css">
body {
 margin: 0px;padding:0
}
/* #div1 {
 display: none;
 position: absolute;
 z-index: 1000;
 height: 100%;
 width: 100%;
 background: #000000;
 filter:Alpha(opacity=30);
} */ 
#div2 {
 display:none ;
 position: absolute;
 height: 350px;
 width: 200px;
/*  padding-top: 40%; */
 z-index: 100;
/*  left: 500px;
 top: -100px; */
}

</style>
<script type="text/javascript">
    /* function sc1() { 
    	//var Div = $(DivId); 
    	$("#div2").style.top = (document.documentElement.scrollTop + (document.documentElement.clientHeight - $("#div2").offsetHeight) / 2) + "px"; 
    	$("#div2").style.left = (document.documentElement.scrollLeft + (document.documentElement.clientWidth - $("#div2").offsetWidth) / 2) + "px"; 
    	//alert($(DivId).style.top); 
    	
    	}  */
    
   	function sc1(){ 
   		document.getElementById("div2").style.top=(document.documentElement.scrollTop+(document.documentElement.clientHeight-document.getElementById("div2").offsetHeight)/2)-100+"px"; 
   		document.getElementById("div2").style.left=(document.documentElement.scrollLeft+(document.documentElement.clientWidth-document.getElementById("div2").offsetWidth)/2)-50+"px"; 
   	} 	
/*     	
    function scall() { 
    	sc1("#div2"); 
    } 
   	
   	window.onresize = scall(); 
   	window.onload = scall(); 
   	window.onMeasure=scall();  */
</script>
<script type="text/javascript">
var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
	init();
    });
    
$(document).ready(function() {
	//点击刷新验证码功能
    $('#loginForm img').click(function(){
        //因为浏览器默认会缓存图片，所以只要改变url就可以跳过缓存
        //每次在url后面添加随机数就可以保证url不重复
        this.src='userLogin!validateImage.action?num='+Math.random();
    });
    $(".loginimg").unbind("click").removeAttr("onclick");
    
   
});
function init(){
	DWREngine.setAsync(true); 
	getQuestionList('');
	//initActiveExpert();
	//initAnnouncement(); /by whz
	//DWREngine.setAsync(true); 
}
function getQuestionList(typeId){
	questionAbs.getQuestionListByTypeId(typeId,function(list){
		var html = '<ul>';
         for(var i = 0;i < list.length; i++){
           var name = list[i].ALIASNAME;
             
      	     if(name.length > 5){
                name = name.substr(0,4)+'..';
         	  }
           html += '<li><span style="width:195px;"><em>'+list[i].REPLYCOUNT+'</em><i>'+dateFormat(list[i].CREATETIME)+'</i>'+name+'</span>';
          
           var text = list[i].CAPTIONTEXT;
               if(text.length > 20){
                  text = text.substr(0,18)+'...';
                  html += '&nbsp;&nbsp;<a style="cursor:pointer;" onclick="viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\',event)" title="'+list[i].CAPTIONTEXT+'">'+text+'</a></li>';
               }else{
                  html += '&nbsp;&nbsp;<a style="cursor:pointer;" onclick="viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\',event)">'+text+'</a></li>';
               }
         }
           html += '<li><span style="width:50px;color:#000;cursor:pointer;"><a onclick="moreSearch();">更多...</a></span>';
           html += '</ul>';
     	   document.getElementById('questionList').innerHTML = html;
		});

	questionAbs.getQuestionListByTypeIdCopy(typeId,function(list){
		var html2 = '<ul>';
         for(var i = 0;i < list.length; i++){
           var name = list[i].ALIASNAME;
      	     if(name.length > 5){
                name = name.substr(0,4)+'..';
         	  }
        	  html2 += '<li><span style="width:195px;"><em>'+list[i].REPLYCOUNT+'</em><i>'+dateFormat(list[i].CREATETIME)+'</i>'+name+'</span>';
              var text = list[i].CAPTIONTEXT;
                  if(text.length > 20){
                     text = text.substr(0,18)+'...';
                     html2 += '&nbsp;&nbsp;<a style="cursor:pointer;" onclick="viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\',event)">'+text+'</a></li>';
                  }else{
                     html2 += '&nbsp;&nbsp;<a style="cursor:pointer;" onclick="viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\',event)">'+text+'</a></li>';
                  }  
         }
           html2 += '<li><span style="width:50px;color:#000;cursor:pointer;"><a onclick="expertAnswerButton();">更多...</a></span>';//expertAnswerButton();
           html2 += '</ul>';
     	   document.getElementById('questionList2').innerHTML = html2;
		});
	
}
function viewAnswerHref(href,event){
	if(user != 'null'){
	if(containsTxt(oper,'viewAnswer')){
	       window.open(href,'_self');
	}else{
       // alert('权限不够,请申请试用');
		showWindow('','提示信息','很遗憾您的7天试用期已过,<br>要想继续获得权威劳动法专家的咨询答疑,<br>请<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/addCart.action?productNo=P0002">付费购买</a>劳动法顾问软件专业版','','');
	}
}else{
    //alert('你还没有登录');    
    // showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','','');  
	openme(event);
}
}
//选择分类目录
function getQaTypeId(typeId,typeName){
	//alert(typeId);
	var type = document.getElementById("type");
	type.style.display = "";
	type.innerHTML = '<span><b style="display:inline;">所选分类:&nbsp;</b><font style="color:#000;">'+typeName+'</font></span>';
	getQuestionList(typeId);
}
function getChildQaTypeId(typeId,parentName,typeName){
	//alert(typeId);
	var type = document.getElementById("type");
	type.style.display = "";
	type.innerHTML = '<b style="display:inline;">所选分类:&nbsp;</b><font style="color:#000;">'+parentName+'&nbsp;>&nbsp;'+typeName+'</font>';
	getQuestionList(typeId);
}

 function dateFormat(UTCDate){

	return UTCDate.format('yyyy-MM-dd');
   /**
	var dateStr = UTCDate.toLocaleString().replace(/[年]|[月]/g, "-").replace(/[日]/g, "");
	var dateArray = dateStr.split("-"); 
	var month, day;

	if (dateArray[1].length < 2) { 
		month = "0" + dateArray[1]; 
	} else { 
		month = dateArray[1];
	}	
	if (dateArray[2].length < 11) { 
		day = "0" + dateArray[2].split(" ")[0]; 
	} else { 
		day = dateArray[2].split(" ")[0];
	}
	//return dateArray[0] + "-" + month + "-" + day.split("星")[0];//+" "+dateArray[2].split(" ")[1];
	return month + "-" + day.split("星")[0];
	**/
}
Date.prototype.format = function(format)
{
    var o =
    {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(),    //day
        "h+" : this.getHours(),   //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
        "S" : this.getMilliseconds() //millisecond
    };
    if(/(y+)/.test(format))
    format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
    if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
};
function loadimage() {
	var imgSrc = $("#image");   
    imgSrc.attr("src",'userLogin!validateImage.action?num='+Math.random());
}
function openme(event){
	sc1();
	$('#errorMessages').html("");
	document.getElementById('div1').style.display='block';
	document.getElementById('div2').style.display='block';
}
function closeme(){
	//$('#errorMessages').html("");
	document.getElementById('div1').style.display='none';
	document.getElementById('div2').style.display='none';
	//document.getElementById("errorMessages").html("");
}

function myLogin(){
	var email = $("#email").val();
	var password = $("#loginPass").val();
	var validatecode = $("#validatecode").val();
	$.ajax({
		url:'userLogin!myLogin.action',
		type:'post',
		data:'email='+email+'&password='+password+'&validatecode='+validatecode,
		dataType:'text',
		success:function(b){
			if(b=='true'){
				location.reload();
			}else if(b=='code'){
				$('#errorMessages').html("验证码错误!").show();
			}else{
				$('#errorMessages').html("帐号或密码错误!").show();
			}
		},
		error:{}
	});
}
function getwidthheight(){
	var div2 = document.getElementById("div2");
    var windowwidth = document.documentElement.clientWidth;
    var windowheight = document.documentElement.clientHeight;
    var divwidth = div1.clientWidth;
    var divheight = div1.clientHeight;
    div2.style.left = (windowwidth - divwidth) / 2 + "px";
    div2.style.top = (windowheight - divheight) / 2 + "px";
}
</script>
</head>
<body>
<jsp:include page="/common/head.jsp"><jsp:param name="indexPage" value="index" />
</jsp:include>
<div class="margin">
<div class="index_left fl">
	<jsp:include page="/webpages/index/index_statis.jsp"/>
	<%-- <jsp:include page="/webpages/index/index_hotAdvisory.jsp"/> --%>
	<div class="zhuanjia_mulu">
	<%-- <jsp:include page="/webpages/index/t_index_catalog.jsp"/> --%>
	<jsp:include page="/webpages/index/index_question.jsp"/>
	</div>
</div>
<div class="index_right fr">
	<jsp:include page="/common/userinfo.jsp"/>
	<%-- <jsp:include page="/webpages/index/index_ad.jsp"/> --%>
	<jsp:include page="/webpages/index/index_announcement.jsp"/>
	<jsp:include page="/webpages/index/index_weibo.jsp"/>
	<jsp:include page="/webpages/index/index_expert.jsp"/>
</div>
</div>
<div class="clear"></div>
	<div id="div1"></div> 
	<div id="div2" style="position:absolute;left:50px;top:0px;">
    <form action="#" method="post"  id="loginForm">
	<div class="loginPanel">
		<div class="x-box-tl">
			<div class="x-box-tr">
				<div class="x-box-tc">
				</div>
			</div>
		</div>

		<div class="x-box-ml">
			<div class="x-box-mr">
				<div class="x-box-mc" style="height: 173px;">
				<img class="loginimg" id="j_id2:j_id4" src="images/register.png"/>
				
					<table id="j_id2:j_id5" cellspacing="3px" style="width:100%">
						<tr>
						<td align="right" colspan="1" rowspan="1" style="width: 50px;padding-right: 3px;">
							<label >用户名：</label>
						</td>
						<td colspan="2">
							<label><input name="email" id="email" type="text" style="width: 212px;" class="x-form-text"/></label>
						</td>
						<tr>

						<tr>
						<td align="right" colspan="1" rowspan="1" style="padding-right: 3px;">
							<label >密码：</label>
						</td>
						<td colspan="2">
							<label><input name="loginPass" id="loginPass" type="password" style="width: 212px;" class="x-form-text"/></label>
						</td>

						<tr>
						<td align="right"  style="padding-right: 3px;">
							<label>验证码：</label>
						</td>
						<td>
							<label><input name="validatecode" id="validatecode" type="text" style="width: 125px;" class="x-form-text"/></label>
						</td>
						<td  style="padding-right: 20px;">
							<label><img id="image" style=" padding-top:6px;" src="userLogin!validateImage.action" on title="点击刷新验证码"/></label>
						</td>
						<tr>

						<tr>
						<td align="center" colspan="2">
							&nbsp; &nbsp; &nbsp;
							<!-- <label><img class="loginimg" src="images/ZR05.gif" style="padding-left:42px;"/><img class="loginimg" src="images/ZR04.gif" style="padding-left:12px;"/></label> -->
							<input type="button" name="logoin" value="登陆" onClick="myLogin()">&nbsp; &nbsp; &nbsp; &nbsp; 
					        <input type="button" name="exit" value="取消" onClick="closeme()">&nbsp; &nbsp; &nbsp; &nbsp; 
					        <a href="http://zhuanjia.haufe.cn/register"><font color='blue'>注册</font></a>						
						</td>
						<td style="padding-right: 20px;">
							<label ><div id="errorMessages" style="color:red"></div></label>
						</td>
						<tr>
					</table>
				</div>
			</div>
		</div>

		<div class="x-box-bl">
			<div class="x-box-br">
				<div class="x-box-bc">
				</div>
			</div>
		</div>

	</div>
</form>
    
</div>
<jsp:include page="/common/footer.jsp"/>
<div id="left_layer" style="position:fixed; top:136px; left:0px;max-width:220px;max-height:240px; ">
  <img src="http://www.haufe.cn/images/ad/weixin.jpg"><br>
  <a href="javascript:;" onclick="javascript:document.getElementById('left_layer').style.display='none';">关闭</a>
</div>
</body>
</html>