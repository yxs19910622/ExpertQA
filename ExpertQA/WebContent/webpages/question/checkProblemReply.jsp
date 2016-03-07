<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import = "org.izhong.expert.util.CookieUtil" %>
<%
String contextPath = request.getContextPath();
Cookie cookie = CookieUtil.getCookieByName(request,"EUserID");
String userId = null;
if(cookie != null){
	userId = cookie.getValue();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=contextPath%>/interface/resource/css/style.css" />
<title>最大、最专业的企业劳动法专家问答平台-浩富</title>
<!--导航-->
<link href="<%=contextPath%>/interface/resource/css/niutuku.css" type="text/css" rel="stylesheet">
<SCRIPT src="<%=contextPath%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="<%=contextPath%>/interface/javascript/niutuku.js" type=text/javascript></SCRIPT>
<script type='text/javascript' src='<%=contextPath%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/interface/questionAbs.js'></script> 
<!--弹框-->
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/tangkuang.js" ></script>

<!--百度分享-->
<script type="text/javascript" id="bdshare_js" data="type=tools" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + new Date().getHours();

var replyId = '${replyId}';
var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
	init();
    });
function init(){
   showReplyContent();
   initActiveExpert();
   initAnnouncement();
}
function showReplyContent(){
	questionAbs.getOneReply(replyId,function(question){
		//DWREngine.setAsync(false); 
		document.getElementById("qatypename").innerHTML = question.QATYPENAME;//专家在线问答>>问题分类>>劳动合同
        var html = '<dl>';
            html += '<dt>';
            //alert(question.USERPICTURE);
            if(question.USERPICTURE != undefined){
            html += '<a href="#"><img src="<%=contextPath%>/'+question.USERPICTURE+'.jpg" alt="" />';
            }else{
            html += '<a href="#"><img src="<%=contextPath%>/upload/pic/iface.jpg" alt="" />';
            } 
            html += '<span>'+question.ALIASNAME+'</span>';
            html += '</a>';
            html += '</dt>';
            html += '<dd>';
            html += '<h3>'+question.CAPTIONTEXT+'</h3>';
            html += '<span>提问时间：'+dateFormat(question.CREATETIME)+'　　点击次数：'+question.CLICKNUMBER+'次　　回答：'+question.REPLYCOUNT+'</span>';
            html += '<p>'+question.QUESTIONCONTENT+'</p>';
            //html += '<a id="favorites" href="#" class="shoucang" onclick="onFavorite(\''+question.QUESTIONID+'\',\''+question.QATYPEID+'\');">收藏&nbsp;'+question.favoriteCount+'</a>';
            //if(question.ISALREADYCLOSED == '0'){//0未关闭 1关闭
            //    html += '<a href="javascript:void(0);" class="zhuanjia_da" onclick="showReplyArea();">专家回答</a>';
            //}
            html += '</dd>';
            html += '</dl>';

            document.getElementById("problem_wen").innerHTML = html;
            
            //填充回复内容
            //document.getElementById("content").value = question.REPLYCONTENT;
            $('#content').omEditor('setData',question.REPLYCONTENT);
            document.getElementById("replyid").value = question.REPLYID;
            //alert(question.ISALREADYCHECKED);
            if(question.ISALREADYCHECKED == '0' || question.ISALREADYCHECKED == '3' || question.ISALREADYCHECKED == '1'){
            	 //document.getElementById('content').readOnly = true;
            	 $('#content').omEditor('setReadOnly', true);
            	 document.getElementById('buttons').style.display = 'none';
             }
            
	});
	
}



function showReplyArea(){
  document.getElementById('questionReply').style.display = '';
	
}
function updateReply(status){
 //var replyContext = document.getElementById("content").value;
 var replyContext = $('#content').omEditor('getData');
 if(replyContext == ''){
	   //alert('请输入内容');
	   showWindow('','提示信息','请输入内容','',''); 
	   return;
	 }
 var map = {
         'replyId':document.getElementById("replyid").value,
         'replyContent':replyContext,
         'isAlreadyChecked':status
		 };
 questionAbs.updateReply(map,function(flag){
         if(flag){
             if(status == '0'){
        	     document.getElementById('questionReply').style.display = 'none';
        	     //alert("提交答复");
        	    
        	     showWindow('','提示信息','提交答复','','');
             }else{
            	 //alert("保存成功");
            	 showWindow('','提示信息','保存成功','','');
             }
         }
	 });

}
function dateFormat(UTCDate){
	return UTCDate.format('yyyy-MM-dd');
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
            <div class="problem_left">
            	<div class="problem_title">专家在线问答&nbsp;&gt;&nbsp;<a href="#">问题分类</a>&nbsp;&gt;&nbsp;<a id = "qatypename" href="#">劳动合同</a></div>
            	<div id="problem_wen" class="problem_wen"></div>
                <div id="questionReply">
                <h4 class="answer_h4">问题答复</h4>
                <input id="replyid" type="hidden"/>
                <jsp:include page="/common/operamasks.jsp"/>
				<script type="text/javascript" src="<%=contextPath%>/interface/compontents/operamasks-ui/editor/omeditor.js"></script>
                <script>
				$(function(){
					var config = {
						toolbar_MyToolbar:[
							{ name: 'document', items : [ 'Preview' ] },
							{ name: 'styles', items : [ 'Styles','Format','Font','FontSize','TextColor'] },
							{ name: 'basicstyles', items : [ 'Bold','Italic','Strike','-','RemoveFormat' ] }
						],
						toolbar:'MyToolbar'};
					$('#content').omEditor(config,{resizable:false});
				});
				</script>
				<textarea id="content" cols="" rows="" class="answer_textarea"></textarea>
                <div id="buttons" style="text-align:right;">
                <input type="button" class="input_pinglun" onclick="updateReply('0');" />
                <input type="button" class="input_reply" onclick="updateReply('2');" />
                </div>
                 </div>  

		  </div>
    	</div>
        <div class="index_right fr">
        	<jsp:include page="/common/userinfo.jsp"/>
        	<jsp:include page="/webpages/index/index_ad.jsp"/>
            <jsp:include page="/webpages/index/index_announcement.jsp"/>
            
            <div class="wtiwen">
            	<a href="#"><img src="<%=contextPath%>/interface/resource/images/wtiwen.png" alt="" onclick="window.open('question');" /></a>
            </div>
            <jsp:include page="/webpages/index/index_weibo.jsp"/>
            <jsp:include page="/webpages/index/index_expert.jsp"/>
	        <jsp:include page="/common/static/activeUser_static.jsp"/>
        </div>
    </div>
    <div class="clear"></div>
     <jsp:include page="/common/footer.jsp"/><!--footer end-->
    
<SCRIPT type=text/javascript> 
$(".allsort").hoverForIE6({current:"allsorthover",delay:200});
$(".allsort .item").hoverForIE6({delay:150});
</SCRIPT>

</body>
</html>
