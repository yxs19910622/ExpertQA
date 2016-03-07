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




var questionId = '${questionId}';
var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
	init();
    });
function init(){
   showQuestionContent();
   initActiveExpert();
   initAnnouncement();
  
}
function showQuestionContent(){
	questionAbs.getOneQuestion(questionId,function(question){
		//DWREngine.setAsync(false); 
		document.getElementById("qatypename").innerHTML = (question.QATYPENAME==undefined)?"":question.QATYPENAME;//专家在线问答>>问题分类>>劳动合同
		document.getElementById("title").value = question.CAPTIONTEXT;
		$('#content').omEditor('setData',question.QUESTIONCONTENT);
		//document.getElementById("content").value = question.QUESTIONCONTENT;
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
            if(question.ISALREADYCHECKED == '2'){
            html += '<span id="statusHtml" class="showstatus" ><b>状态:保存</b></span>';
            }else{
            html += '<span id="statusHtml" class="showstatus" ><b>状态:已提交</b></span>';
            document.getElementById('saveButton').style.display = 'none';
            document.getElementById('submitButton').style.display = 'none';
            document.getElementById('questionReply').style.display = 'none';
            }
            //html += '<a href="javascript:void(0);" class="zhuanjia_da" onclick="showReplyArea();">编辑</a>';
            html += '</dd>';
            html += '</dl>';

            document.getElementById("problem_wen").innerHTML = html;
            //DWREngine.setAsync(true); 
            var typeid = (question.QATYPEID==undefined)?"":question.QATYPEID;
            //alert(typeid);
            inits(typeid);
	});
	
}




function showReplyArea(){
  document.getElementById('questionReply').style.display = '';
	
}
//进入修改页 修改问题
function updateQuestion(status){
	var select_a = document.getElementById("select_a").value;
	 if(select_a == '11000'){
		   //alert('请选择分类');
		   showWindow('','提示信息','请选择分类','','');
		   return;
		 }
	var title = document.getElementById("title").value;
	 if(title == ''){
		    //alert('请输入内容');
		    showWindow('','提示信息','请输入内容','','');
			return;
		 }
	 //var questionContext = document.getElementById("content").value;
	 var questionContext = $('#content').omEditor('getData');
	 if(questionContext == ''){
		   //alert('请输入内容');
		   showWindow('','提示信息','请输入内容','','');
		   return;
		 }
	 //alert(status);
	 var map = {
	         'questionId':questionId,
	         'captionText':title,
	         'questionContent':questionContext,
	         'isAlreadyChecked':status,
	         'qaTypeId':select_a
			 };
	 //alert(map.questionId+'--'+map.captionText+'---'+map.questionContent+'----'+map.isAlreadyChecked);
	 questionAbs.upateQuestion(map,function(flag){
	         if(flag){
	        	 //document.getElementById('questionReply').style.display = 'none';
	        	 //alert("提交答复");
	        	 if(status == '0'){
	        		 //alert('提交成功');
	        		 showWindow('','提示信息','提交成功','','');
	        	     document.getElementById('statusHtml').innerHTML = '<b>状态:已提交</b>';
	        	     document.getElementById('saveButton').style.display = 'none';
	                 document.getElementById('submitButton').style.display = 'none';
	                 document.getElementById('questionReply').style.display = 'none';
	        	 }else{
	        		 //alert('保存成功');
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

function inits(qaTypeId){
	var objectSelect = document.getElementById('select_a');
	var objectOption=document.createElement("option");
    objectSelect.options.add(objectOption);
    objectOption.innerHTML='请选择问题分类';
    objectOption.value='';
	questionAbs.getQaTypeParent(function(parent){
		questionAbs.getQaTypeChild(function(child){
              for(var i = 0;i < parent.length; i++){
                   //html += '<option value="'+parent[i].QATYPEID+'">'+parent[i].QATYPENAME+'</option>'; 
                   var objectOption=document.createElement("option");
                   objectSelect.options.add(objectOption);
                   objectOption.innerHTML=parent[i].QATYPENAME;
                   objectOption.value=parent[i].QATYPEID;
                   if(parent[i].QATYPEID == qaTypeId) objectOption.selected = true;
                   
                   for(var j = 0;j < child.length; j++){
                          if(parent[i].QATYPEID == child[j].PARENTTYPEID){
                        	 // html += '<option value="'+child[j].QATYPEID+'">&nbsp;┣'+child[j].QATYPENAME+'</option>';
                        	  var objectOption=document.createElement("option");
                              objectSelect.options.add(objectOption);
                              objectOption.innerHTML='&nbsp;┣'+child[j].QATYPENAME;
                              objectOption.value=child[j].QATYPEID;
                              if(child[j].QATYPEID == qaTypeId) objectOption.selected  = true;
                              }
                       }
                  }
              //document.getElementById('select_a').innerHTML = html;
			});
		}); 
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
            	<div id="problem_wen" class="problem_wen">
            	   
                </div>
                <div id="questionReply">
                    <h4  class="answer_h4">选择问题分类&nbsp;</h4>
            	    <select id="select_a" name="select" class="select_area">
                                   
	                </select>
                    <h4 class="answer_h4">问题标题</h4>
                    <input id="title" type="text"  class="input_check" />
                    <h4  class="answer_h4">问题详细描述</h4>
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
                    <input id="submitButton" type="button" class="input_07" onclick="updateQuestion('0');" />
                    <input id="saveButton" type="button" class="input_saveQuestion" onclick="updateQuestion('2');" />
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
