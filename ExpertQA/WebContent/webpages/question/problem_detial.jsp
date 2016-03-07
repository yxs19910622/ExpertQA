<%@ page language="java" pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();
 String wd = (request.getAttribute("kwd") == null)?"":request.getAttribute("kwd")+"";
 //System.out.println(wd+"####");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=contextPath%>/interface/resource/css/style.css" />
<title>浩富问答-搜索答案</title>
<!--导航-->
<link href="<%=contextPath%>/interface/resource/css/niutuku.css" type="text/css" rel="stylesheet">
<SCRIPT src="<%=contextPath%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="<%=contextPath%>/interface/javascript/niutuku.js" type=text/javascript></SCRIPT>
<script type='text/javascript' src='<%=contextPath%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/interface/questionAbs.js'></script> 

<!-- 一键分享 -->
<script type="text/javascript">
var passit_title = "";//自定义分享标题，删除和留空表示使用默认
var passit_url = "";//自定义分享网址，删除和留空表示使用默认
var passit_content= "";
</script>
<script type="text/javascript">
bookmark_service="qqkj,sinaweibo,qqweibo";
</script>
<!-- <script type="text/javascript" src="http://www.passit.cn/js/passit_bar_big_new.js?pub=0&simple=1" charset="UTF-8"></script> -->

<!--弹框-->
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/tangkuang.js" ></script>
<!--百度分享-->
<script type="text/javascript" id="bdshare_js" data="type=tools" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + new Date().getHours();
var isClosed = '${isClosed}';
var questionTitle = '<%=wd%>';
var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
    //DWREngine.setAsync(false);
    //alert('ff');
    initPage(isClosed);
    });

function initPage(val){
	isClosed = val;
	getShareList(1,0);
	initActiveExpert();//加载活跃专家
	initAnnouncement();
	document.getElementById('keyword').value = questionTitle;
}
function getShareList(num,scount){
	var map={
		sum:scount,
		p:num,
		'isAlreadyClosed':isClosed,
		'captionText':questionTitle
	};
	questionAbs.getQuestionsList(map,getQuestionsListBack);
}
function getQuestionsListBack(list){
	document.getElementById("pagebreak").innerHTML=list[list.length-1].pagebreak;
	//alert(list[list.length-1].hitCount+'###');//查询的记录数
	
	if(isClosed == "1"){
		if(list.length-1 == 0){
			//initPage(0);
			//return;
			}
	    document.getElementById('wenda1').className='no';
	    document.getElementById('wenda2').className='';
	    document.getElementById("problem1").innerHTML = '热门问题<span style="font-size:12px;color:#CC0000;">(共'+list[list.length-1].hitCount+'条)</span>';
	    document.getElementById("problem0").innerHTML = '待回答问题<span style="font-size:12px;color:#CC0000;">(共'+list[list.length-1].count+'条)</span>';
	}else{
		//if(list.length-1 == 0){
			//initPage(1);
			//return;
		//	}
		document.getElementById('wenda1').className='';
		document.getElementById('wenda2').className='no';
		document.getElementById("problem1").innerHTML = '热门问题<span style="font-size:12px;color:#CC0000;">(共'+list[list.length-1].count+'条)</span>';
		document.getElementById("problem0").innerHTML = '待回答问题<span style="font-size:12px;color:#CC0000;">(共'+list[list.length-1].hitCount+'条)</span>';
	}
	var html = '';
	for(var i=0;i<list.length-1;i++){  
     html += '<dl>';		
     html += '<dt><a href="javascript:(void);" onclick="viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\')">'+list[i].CAPTIONTEXT+'</a></dt>';
     html += '<dd>';
     html += '<p>'+list[i].QUESTIONCONTENT+'</p>';
     html += '<span>分类标签：'+list[i].QATYPENAME+'<br />回答者：'+list[i].ANSWER+'  提问者：'+list[i].ALIASNAME+' 回答时间：'+dateFormat(list[i].CREATETIME)+'</span>';
     //onMouseMove = "getTitle(\''+list[i].caption+'\',\''+list[i].QUESTIONCONTENT+'\')"
     //html += '<a href="javascript:void(0)"  onMouseout="hide(\'light'+i+'\')" class="fenx">分享给朋友知道...</a>';
     html += '<div id="light'+i+'" class="white_contentd">'+
              '<div class="con" style="background:red;">'+  
              '<div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare"  onMouseOver="show(\'light'+i+'\')" onMouseout="hide(\'light'+i+'\')">';
     html += '</div>';
     html += '</div>';
	 html += '</div>';
     
     html += '<div id="fade" class="black_overlay"></div>';
     if(list[i].ISALREADYCLOSED == "0"){
        // alert(oper);
    	 if(containsTxt(oper,'expertAnswerButton')){
         html += '<a href="javascript:(void);" class="zhuanjia_deng" onclick="viewAnswerHref(\'answerQuestion?questionid='+list[i].QUESTIONID+'\')">专家回答</a>';
         //html += '<a href="#" class="zhuanjia_deng" onclick="window.open(\'./webpages/question/problem.jsp?questionid='+list[i].QUESTIONID+'\')">专家回答</a>';
    	 }
     }
     html += '</dd>';
     html += '</dl>';
	}
	
	document.getElementById("wendam1").innerHTML = html;
}
function getTitle(title,con){
	passit_title = title;
	passit_content = con;
	//alert(title);
}
//
function viewAnswerHref(href){
	if(user != 'null'){
	if(containsTxt(oper,'viewAnswer')){
	       window.open(href,'_self');
	}else{ 
        //alert('权限不够,请申请试用');
		showWindow('','提示信息','很遗憾您的7天试用期已过,<br>要想继续获得权威劳动法专家的咨询答疑,<br>请<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/addCart.action?productNo=P0002">付费购买</a>劳动法顾问软件专业版','','');
	}
	}else{
        //alert('你还没有登录');  
		showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','','');
	}
}
function dateFormat(UTCDate){

	return UTCDate.format('yyyy-MM-dd hh:mm:ss');
	/**
	var dateStr = UTCDate.toLocaleString().replace(/[年]|[月]/g, "-").replace(/[日]/g, "");
	//alert(dateStr);
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
	//alert(day);
	return dateArray[0] + "-" + month + "-" + day.split("星")[0]+" "+dateArray[2].split(" ")[1];
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
    	<div class="weekly_img">
        	<div id="picBox">
            <ul id="show_pic" style="left:0;">
                <li><a href="http://www.haufe.cn/trydown/index.html"><img src="<%=contextPath%>/interface/resource/images/daily1.jpg" width="950" height="147" alt="" title="" /></a></li>
                <li><a href="#"><img src="<%=contextPath%>/interface/resource/images/daily2.jpg" width="950" height="147" alt="" title="" /></a></li>
                <li><a href="#"><img src="<%=contextPath%>/interface/resource/images/daily3.jpg" width="950" height="147" alt="" title="" /></a></li>
            </ul>
            <ul id="icon_num">
                <LI>1</LI>
                <LI>2</LI>
                <LI>3</LI>
            </ul>
        	</div>
            <script type="text/javascript" src="<%=contextPath%>/interface/javascript/qiehuan.js"></script>
            <script type="text/javascript" >
			glide.layerGlide(true,'icon_num','show_pic',950,2,0.1,'left');
			</script>
        </div>
        
    	<div class="index_left fl">
        	<div class="wenda">
            	<!--切换-->
            	<ul class="wenda_li">
                <li id="wenda1" class="no" onclick="initPage('1');"><a id="problem1" href="#">热门问题</a></li>
                <li id="wenda2"><a  id="problem0" href="#" onclick="initPage('0');">待回答问题</a></li>
                <li id="hitCount"></li>
                </ul>
                <div class="wenda_mo">
                <div id="wendam1">
                  <div style="width:100%;height:100%;text-align:center;vertical-align:middle;"><img src="<%=contextPath%>/interface/resource/images/rotation.gif"/></div>
                </div>
                 <!-- 
                <div id="wendam2" style="display:none;"></div>
                 -->
                    
                 <p id="pagebreak" class="page"></p>
                </div>
            </div>
    	</div>
        <div class="index_right fr">
        	<jsp:include page="/common/userinfo.jsp"/>
        	<jsp:include page="/webpages/index/index_ad.jsp"/>
            <jsp:include page="/webpages/index/index_announcement.jsp"/>
            
            <div class="wtiwen">
            	<a href="javascript:(void);"><img src="<%=contextPath%>/interface/resource/images/wtiwen.png" alt="" onclick="window.open('question');"/></a>
            </div>
            <jsp:include page="/webpages/index/index_weibo.jsp"/>
            <jsp:include page="/webpages/index/index_expert.jsp"/>
	        <jsp:include page="/common/static/activeUser_static.jsp"/>
        </div>
    </div>
 
    <div class="clear"></div>
     <jsp:include page="/common/footer.jsp"/><!--footer end-->
     
     <div id="share" style="display:none;">
      <!-- <div class="passit_barDiv"><a class="passit_default" href="http://www.passit.cn/bookmark.html" target="_blank"></a></div> -->
     </div>
<SCRIPT type=text/javascript> 
$(".allsort").hoverForIE6({current:"allsorthover",delay:200});
$(".allsort .item").hoverForIE6({delay:150});
</SCRIPT>

</body>
</html>
