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
<script type="text/javascript">
var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
	init();
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
                  html += '&nbsp;&nbsp;<a href="javascript:viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\')" onclick="" title="'+list[i].CAPTIONTEXT+'">'+text+'</a></li>';
               }else{
                  html += '&nbsp;&nbsp;<a href="javascript:viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\')" onclick="">'+text+'</a></li>';
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
                     html2 += '&nbsp;&nbsp;<a href="javascript:viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\')" onclick=""  title="'+list[i].CAPTIONTEXT+'">'+text+'</a></li>';
                  }else{
                     html2 += '&nbsp;&nbsp;<a href="javascript:viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\')" onclick="">'+text+'</a></li>';
                  }  
         }
           html2 += '<li><span style="width:50px;color:#000;cursor:pointer;"><a onclick="expertAnswerButton();">更多...</a></span>';//expertAnswerButton();
           html2 += '</ul>';
     	   document.getElementById('questionList2').innerHTML = html2;
		});
	
}
function viewAnswerHref(href){
	if(user != 'null'){
	if(containsTxt(oper,'viewAnswer')){
	       window.open(href,'_self');
	}else{
       // alert('权限不够,请申请试用');
		showWindow('','提示信息','很遗憾您的7天试用期已过,<br>要想继续获得权威劳动法专家的咨询答疑,<br>请<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/addCart.action?productNo=P0002">付费购买</a>劳动法顾问软件专业版','','');
	}
}else{
    //alert('你还没有登录');    
    showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','','');  
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
    }
    if(/(y+)/.test(format))
    format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
    if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
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
<jsp:include page="/common/footer.jsp"/>

</body>
</html>