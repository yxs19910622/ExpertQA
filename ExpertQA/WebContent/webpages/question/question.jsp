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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=contextPath%>/interface/resource/css/style.css" />
<title>浩富问答-点击我要提问</title>
<script type='text/javascript' src='<%=contextPath%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/interface/questionAbs.js'></script> 

<link href="<%=contextPath%>/interface/resource/css/niutuku.css" type="text/css" rel="stylesheet">
<SCRIPT src="<%=contextPath%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="<%=contextPath%>/interface/javascript/niutuku.js" type=text/javascript></SCRIPT>
<script type="text/javascript"><!--
var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
	inits();
    });
function addOneQuestion(status){
	var title = document.getElementById("title").value;
	if(title == ''){
        //alert('您还没有输入问题标题!');
        showWindow('','提示信息','请输入问题的标题','',''); 
        document.getElementById("title").focus();
        return;
	}
	//var content = document.getElementById("content").value;
	var content = $('#content').omEditor('getData');
	if(content == ''){
        //alert('您还没有输入问题内容!');
        showWindow('','提示信息','请输入问题内容','',''); 
        //document.getElementById("content").focus();
        return;
	}
	//alert(title+'----'+content+'----'+'<%=userId%>');
	var qaTypeId = document.getElementById('select_a').value;
	//if(qaTypeId == '11000'){
        //alert('您还没有选择问题分类!');
     //   showWindow('','提示信息','请选择问题分类','',''); 
     //   return;
	//}
	
	var map = {
              'captionText':title,
              'questionContent':content,
              'userID':'<%=userId%>',
              'qaTypeID':qaTypeId,
              'isAlreadyChecked':status
			};
	questionAbs.addQuestion(map,function(flag){
       if(flag){
           if(status == '1'){
           //alert('提问成功,等待审核');
           showWindow('','提示信息','提问成功，等待审核','',''); 
           setTimeout(function(){
        	   document.location.href="<%=contextPath%>"+"/index.action";
               },5000);
           }else{
        	   //alert('保存成功');
        	   showWindow('','提示信息','保存成功','',''); 
        	   setTimeout(function(){
            	   document.location.href="<%=contextPath%>"+"/index.action";
                   },5000);
               }
       }   
	});
}

//function getQaTypeId(val,name){
// qaTypeId = val;
 //document.getElementById("qaName").innerHTML = name;
//}
function inits(){
	initActiveExpert();
	initAnnouncement();
	//var html = '<option value="11000">请选择问题分类</option>';
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
                   
                   for(var j = 0;j < child.length; j++){
                          if(parent[i].QATYPEID == child[j].PARENTTYPEID){
                        	 // html += '<option value="'+child[j].QATYPEID+'">&nbsp;┣'+child[j].QATYPENAME+'</option>';
                        	  var objectOption=document.createElement("option");
                              objectSelect.options.add(objectOption);
                              objectOption.innerHTML='&nbsp;┣'+child[j].QATYPENAME;
                              objectOption.value=child[j].QATYPEID;
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
        	<div class="question_left">
            	<div class="question_body">
            	     <h4>选择问题分类&nbsp;</h4>
            	     <select id="select_a" name="select" class="select_area">
                                   
	                  </select>
                	<h4>问题标题</h4>
                    <input id="title" type="text" value="" class="input_06" />
                    <h4>问题详细描述</h4>
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
                    <textarea id="content" cols="" rows="" class="textarea01" ></textarea>
                    <input type="submit" value="" class="input_07" onclick="addOneQuestion('1');" />
                    <input id="saveButton" type="button" class="input_saveQuestion" onclick="addOneQuestion('2');" />
                </div>
            </div>
        </div>
        <div class="index_right fr">
            <jsp:include page="/common/userinfo.jsp"/>
            <jsp:include page="/webpages/index/index_announcement.jsp"/>
            <jsp:include page="/webpages/index/index_ad.jsp"/>
            
			<!--微博切换-->
            <jsp:include page="/webpages/index/index_weibo.jsp"/>
            <jsp:include page="/webpages/index/index_expert.jsp"/>
	        <jsp:include page="/webpages/index/index_activeUser.jsp"/>
        </div>
    </div><!--main end-->
    <jsp:include page="/common/footer.jsp"/><!--footer end-->
    <SCRIPT type=text/javascript> 

$(".allsort").hoverForIE6({current:"allsorthover",delay:200});
$(".allsort .item").hoverForIE6({delay:150});
</SCRIPT>
</body>
</html>
