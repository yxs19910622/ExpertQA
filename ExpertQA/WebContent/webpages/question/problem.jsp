<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import = "org.izhong.expert.util.CookieUtil" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#uuid=&amp;style=999&amp;img=http%3A%2F%2Fstatic.bshare.cn%2Fimages%2Fbuttons%2Fbox-shareTo-zh.gif&amp;w=147&amp;h=21"></script>
<link href="<%=contextPath%>/interface/resource/css/niutuku.css" type="text/css" rel="stylesheet">
<SCRIPT src="<%=contextPath%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="<%=contextPath%>/interface/javascript/niutuku.js" type=text/javascript></SCRIPT>
<script type='text/javascript' src='<%=contextPath%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/interface/questionAbs.js'></script> 
<!--弹框-->
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/tangkuang.js" ></script>
<!-- 一键分享 -->
<script type="text/javascript">
var passit_title = "";//自定义分享标题，删除和留空表示使用默认
var passit_url = "";//自定义分享网址，删除和留空表示使用默认
var passit_content= "";
</script>
<%-- <script type="text/javascript">
bookmark_service="qqkj,sinaweibo,qqweibo";</script>
<script type="text/javascript" src="http://www.passit.cn/js/passit_bar_big_new.js?pub=0&simple=1" charset="UTF-8"></script> --%>



<!-- 百度分享 -->
<script type="text/javascript">



var isTemp = '';
var questionId = '${questionId}';
var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
	init();
    });
function init(){
  //alert(questionId);	
   showQuestionContent();
   showReplysContent();
   initActiveExpert();
   initAnnouncement();
}

function showQuestionContent(){
	
	
	
	
	questionAbs.getOneQuestion(questionId,function(question){
		//DWREngine.setAsync(false); 
		passit_title = question.CAPTIONTEXT;//分享的问题的标题
		bShare.addEntry({title: question.CAPTIONTEXT});
		/* document.getElementById("qatypename").innerHTML = question.QATYPENAME;//专家在线问答>>问题分类>>劳动合同 */
        var html = '<dl>';
            html += '<dt>';
            //alert(question.USERPICTURE);
            if(question.USERPICTURE != undefined){
            html += '<b href="javascript:(void);"><img src="<%=contextPath%>/'+question.USERPICTURE+'.jpg" alt="" />';
            }else{
            html += '<b href="javascript:(void)"><img src="<%=contextPath%>/upload/pic/iface.jpg" alt="" />';
            } 
            if(question.PROVINCE != undefined){
            	if(question.CITY != undefined){
	            	html += '<span>'+question.ALIASNAME+'<br>'+question.PROVINCE+question.CITY+'</span>';
            	}else{
	            	html += '<span>'+question.ALIASNAME+'<br>'+question.PROVINCE+'</span>';
            	}
            }else{
            	html += '<span>'+question.ALIASNAME+'</span>';
            }
            /* html += '</a>'; */
            html += '</dt>';
            html += '<dd>';
            html += '<h3>'+question.CAPTIONTEXT+'</h3>';
            html += '<span>提问时间：'+dateFormat(question.CREATETIME)+'　　点击次数：'+question.CLICKNUMBER+'次　　回答：'+question.REPLYCOUNT+'</span>';
            html += '<p>'+question.QUESTIONCONTENT+'</p>';
            /* html += '<a id="favorites" href="javascript:(void);" class="shoucang" onclick="onFavorite(\''+question.QUESTIONID+'\',\''+question.QATYPEID+'\');">收藏&nbsp;'+question.favoriteCount+'</a>'; */
            if(question.ISALREADYCLOSED == '0'){//0未关闭 1关闭
               if(containsTxt(oper,'expertAnswerButton')){
                html += '<a href="javascript:void(0);" class="zhuanjia_da" onclick="showReplyArea(\''+question.QUESTIONID+'\');">专家回答</a>';

               }    
            }
            html += '</dd>';
            html += '</dl>';

            document.getElementById("problem_wen").innerHTML = html;
            //DWREngine.setAsync(true); 
	});
	
	
	
}
function showReplysContent(){
	var map = {
             'userId':'<%=userId%>',
             'questionId':questionId
			};
	questionAbs.getAllReplysByQuestionId(map,function(list){
        var okhtml = '<div class="problem_hui"><h3>专家确认回答</h3>';
        var otherhtml = '<div class="other_da"><h4>其他回答</h4>';
         for(var i = 0;i < list.length; i++){
             if(list[i].ISTOP == '1'){//expert ok answer
            	 okhtml += '<dl>';
            	 okhtml += '<dt>';
            	 if(list[i].USERPICTURE != undefined){
            	 okhtml += '<a target="_blank" href="expert/'+list[i].USERID+'"><img src="http://zhuanjia.haufe.cn'+list[i].USERPICTURE+'" alt="" />';
                 }else{
                 okhtml += '<a target="_blank" href="expert/<s:property value='labuser.userID'/>"><img src="<%=contextPath%>/upload/pic/iface.jpg" alt="" />';
                 }
            	 <%-- //okhtml += '<a href="#"><img src="<%=contextPath%>/interface/resource/images/iface.jpg" alt="" />'; --%>
            	 okhtml += '<span>专家<br />'+list[i].ALIASNAME+'</span>';
            	 okhtml += '</a>';
            	 okhtml += '</dt>';
            	 okhtml += '<dd>';
                 okhtml += '<span>';
                 okhtml += '浩富推荐次数：'+(list[i].RECOMMENDNUMBER==undefined?0:list[i].RECOMMENDNUMBER)+'&nbsp;&nbsp;&nbsp;回答总次数：'+(list[i].ANSWERNUMBER==undefined?0:list[i].ANSWERNUMBER)+'&nbsp;&nbsp;&nbsp;企业采纳为最佳答案数：'+(list[i].BESTANSWERNUMBER==undefined?0:list[i].BESTANSWERNUMBER)+'<br />';
                 okhtml += '网友赞同次数：'+(list[i].APPROVALNUMBER==undefined?0:list[i].APPROVALNUMBER)+'&nbsp;&nbsp;&nbsp;所属单位/律师事务所：'+list[i].COMPANYNAME+'&nbsp;&nbsp;&nbsp;回复时间：'+dateFormat(list[i].REPLYTIME);
                 okhtml += '</span>';
                 okhtml += '<p>'+list[i].REPLYCONTENT+'</p>';
                 okhtml += '<a href="javascript:(void);" id="'+list[i].REPLYID+'" onclick="onPoll(\''+list[i].REPLYID+'\');" class="zantong">赞同&nbsp;'+list[i].POLLCOUNT+'</a>';
                 //onMouseMove = "getShareReplyContent(\''+list[i].REPLYCONTENT+'\')"
                 //okhtml += '<a href="javascript:void(0);" onMouseOver="show(\'light'+i+'\')" onmouseout="hide(\'light'+i+'\')" class="fenx">分享给朋友知道...</a>';
                 okhtml += '<a class="bshareDiv" href="http://www.bshare.cn/share"></a>';
                 okhtml += '<div id="light'+i+'" class="white_contentb">';
                 okhtml += '<div class="con"> '; 
                 okhtml += '<div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare" onMouseOver="show(\'light'+i+'\')" onmouseout="hide(\'light'+i+'\')">';
                 //okhtml += '<a class="bds_qzone"></a>';
                 //okhtml += '<a class="bds_tsina"></a>';
                 //okhtml += '<a class="bds_tqq"></a>';
                 okhtml += document.getElementById('share').innerHTML;
                 //okhtml += '<div class="passit_barDiv"><a class="passit_default" href="http://www.passit.cn/bookmark.html" target="_blank"></a></div>';
                 
                 okhtml += '</div>';

                 okhtml += '</div> ';
                 okhtml += '</div>';
                 okhtml += '<div id="fade" class="black_overlay"></div>';
                 okhtml += '</dd>';
                 okhtml += '<div class="clear"></div>';
            	 okhtml += '</dl>';
             }else{
            	 otherhtml += '<dl>';
            	 otherhtml += '<dt>';
            	 if(list[i].USERPICTURE != undefined){
            	 otherhtml += '<a target="_blank" href="expert/'+list[i].USERID+'"><img src="http://zhuanjia.haufe.cn'+list[i].USERPICTURE+'" alt="" />';
                 }else{
                 otherhtml += '<a href="javascript:(void);"><img src="<%=contextPath%>/upload/pic/iface.jpg" alt="" />';
                 }
            	 //otherhtml += '<a href="#"><img src="<%=contextPath%>/interface/resource/images/iface.jpg" alt="" />';
            	 otherhtml += '<span>专家<br />'+list[i].ALIASNAME+'</span>';
            	 otherhtml += '</a>';
            	 otherhtml += '</dt>';
            	 otherhtml += '<dd>';
            	 otherhtml += '<span>';
            	 if(list[i].ISALREADYCHECKED == '2'||list[i].ISALREADYCHECKED == '0'||list[i].ISALREADYCHECKED == '3'){
                 var sta = ''
                 if(list[i].ISALREADYCHECKED == '2'){
                    sta = '已保存';
                 }else if(list[i].ISALREADYCHECKED == '0'){
                    sta = '未审核';
                  }else{
                	sta = '未通过';
                  }
            	 otherhtml += '浩富推荐次数：'+(list[i].RECOMMENDNUMBER==undefined?0:list[i].RECOMMENDNUMBER)+'&nbsp;&nbsp;&nbsp;回答总次数：'+(list[i].ANSWERNUMBER==undefined?0:list[i].ANSWERNUMBER)+'&nbsp;&nbsp;&nbsp;企业采纳为最佳答案数：'+(list[i].BESTANSWERNUMBER==undefined?0:list[i].BESTANSWERNUMBER)+'&nbsp;<b>状态：'+sta+'</b><br />';
            	 }else{
            	 otherhtml += '浩富推荐次数：'+(list[i].RECOMMENDNUMBER==undefined?0:list[i].RECOMMENDNUMBER)+'&nbsp;&nbsp;&nbsp;回答总次数：'+(list[i].ANSWERNUMBER==undefined?0:list[i].ANSWERNUMBER)+'&nbsp;&nbsp;&nbsp;企业采纳为最佳答案数：'+(list[i].BESTANSWERNUMBER==undefined?0:list[i].BESTANSWERNUMBER)+'<br />';
                 } 
             	 otherhtml += '网友赞同次数：'+(list[i].APPROVALNUMBER==undefined?0:list[i].APPROVALNUMBER)+'&nbsp;&nbsp;&nbsp;所属单位/律师事务所：'+list[i].COMPANYNAME+'&nbsp;&nbsp;&nbsp;回复时间：'+dateFormat(list[i].REPLYTIME);
                 otherhtml += '</span>';
            	 otherhtml += '<p>'+list[i].REPLYCONTENT+'</p>';
            	 otherhtml += '<a href="javascript:(void);" id="'+list[i].REPLYID+'" onclick="onPoll(\''+list[i].REPLYID+'\');" class="zantong">赞同&nbsp;'+list[i].POLLCOUNT+'</a>';
            	 //onMouseMove = "getShareReplyContent(\''+list[i].REPLYCONTENT+'\')"
            	 //otherhtml += '<a href="javascript:void(0);" onMouseOver="show(\'light'+i+'\')" onmouseout="hide(\'light'+i+'\')" class="fenx">分享给朋友知道...</a>';
            	 otherhtml += '<a class="bshareDiv" href="http://www.bshare.cn/share"></a>';
            	 otherhtml += '<div id="light'+i+'" class="white_contentb">';
            	 otherhtml += '<div class="con" style="background:red;">';
            	 otherhtml += '<div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare" onMouseOver="show(\'light'+i+'\')" onmouseout="hide(\'light'+i+'\')">';
            	 //otherhtml += '<a class="bds_qzone"></a>';
            	 //otherhtml += '<a class="bds_tsina"></a>';
            	 //otherhtml += '<a class="bds_tqq"></a>';
            	 otherhtml += document.getElementById('share').innerHTML;
            	 //okhtml += '<div class="passit_barDiv"><a class="passit_default" href="http://www.passit.cn/bookmark.html" target="_blank"></a></div>';
            	 otherhtml += '</div>';
            	 otherhtml += '</div> ';
            	 otherhtml += '</div>';
            	 otherhtml += '<div id="fade" class="black_overlay"></div>';
            	 otherhtml += '</dd>';
            	 otherhtml += '<div class="clear"></div>';
            	 otherhtml += '</dl>';
             }
         }
            document.getElementById("okAnswer").innerHTML = okhtml+"</div>";
            document.getElementById("otherAnswer").innerHTML = otherhtml+"</div>";
            if(list.length == 0){
            	document.getElementById("okAnswer").innerHTML = '';
                document.getElementById("otherAnswer").innerHTML = '';
            }
		});
}
function getShareReplyContent(con){
	passit_content = con;
	//alert(title);
}
function onPoll(replyId){
	questionAbs.updatePollCount(replyId,function(flag){
            if(flag){
                  var val = document.getElementById(replyId).innerHTML;
                  var num = parseInt(val.split('&nbsp;')[1])+1;
                  document.getElementById(replyId).innerHTML = '赞同&nbsp;'+num;
                }
		});
}
function onFavorite(questionId,qaTypeId){
    var map = {
              'questionId':questionId,
              'qaTypeId':'1',             //1.在线问答   2.工具库   3.电子周刊
              'userId':'<%=userId%>'
    	    };
    questionAbs.addFavorite(map,function(flag){
           if(flag){
        	   showQuestionContent();
            }
        });
}
function showReplyArea(questinId){
  //根据userid和questionid获取临时保存的回复
  var map = {
            'userId':'<%=userId%>',
            'questionId':questionId
		  };
  //alert(map.userId+'---'+map.questionId);
  questionAbs.getReplyContentByUserIdAndQuestionId(map,function(reply){
	 // alert(reply);
       if(reply != null){
    	   document.getElementById("replyid").value = reply.REPLYID;
    	   $('#content').omEditor('setData',reply.REPLYCONTENT);
    	   //document.getElementById("content").value = reply.REPLYCONTENT;
    	   isTemp = 'yes';
           }
	  });
  document.getElementById('questionReply').style.display = '';
	
}
function submitReply(status){
 //var replyContext = document.getElementById("content").value;
 var replyContext = $('#content').omEditor('getData');
 if(replyContext == '' || replyContext.lenth<=0){
	   showWindow('','提示信息','请输入内容','','');
	   return;
	 }
 var map = {
         'questionId':questionId,
         'userId':'<%=userId%>',
         'replyContent':replyContext,
         'isAlreadyChecked':4
		 };
 questionAbs.addReplyContent(map,function(flag){
         if(flag){
             if(status == '0'){
        	 document.getElementById('questionReply').style.display = 'none';
        	 //alert("提交答复");
        	     showWindow('','提示信息','提交回复成功','','');
        	     document.getElementById("replyid").value = '';
          	     //document.getElementById("content").value = '';
        	     $('#content').omEditor('setData','');
        	     window.top.location.reload();
        	// window.location.href="auditReply.action?questionId="+questionId;
             }else{
            	 showWindow('','提示信息','保存操作成功','','');
             }
         }
	 });

}
function replyContent(status){
	if(isTemp == ''){
		//alert('submitReply');
		submitReply(status);
	}else{
		//alert('updateReply');
		updateReply(status);
	}
}
function checking(status){
	var replyContext = $('#content').omEditor('getData');
	var flag = true;
	$.ajax({
		url:'setHome!wordsCheck.action',
		type:'post',
		data:'',
		dataType:'json',
		success:function(data){
			for (var i=0;i<data.length;i++) {
				if(data[i]!=null&&data[i]!=""){
					if (replyContext.indexOf(data[i])!=-1){
						alert("敏感词汇:"+data[i]);
						flag=false;
					}
				}
			}
			if(flag){
				replyContent(status);
			}
		}
	});
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
	        	     document.getElementById("replyid").value = '';
	          	     //document.getElementById("content").value = '';
	        	     $('#content').omEditor('setData','');
	             }else{
	            	 //alert("保存成功");
	            	 showWindow('','提示信息','保存成功','','');
	             }
	         }
		 });

	}
	
function dateFormat(UTCDate){
	return UTCDate.format('yyyy-MM-dd');
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
	return dateArray[0] + "-" + month + "-" + day.split("星")[0];//+" "+dateArray[2].split(" ")[1];
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
    	<jsp:include page="/webpages/question/question_ask_ad.jsp"/>
    	<div class="index_left fl">
            <div class="problem_left">
            	<!-- <div class="problem_title">专家在线问答&nbsp;&gt;&nbsp;<b href="javascript:(void);"> onclick="javascript:history.back(-1);"问题分类</b>&nbsp;&gt;&nbsp;<b id = "qatypename" href="#">劳动合同</b></div> -->
            	<div id="problem_wen" class="problem_wen">
            	   
                </div>
                <form action="#" method="post">
                <div id="questionReply" style="display:none;">
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
                <p style="text-align:right;">
                <input type="button" class="input_pinglun" onclick="checking('0');" /><!-- replyContent('0') -->
                <input type="button" class="input_reply" onclick="replyContent('2');" />
                </p>
                </div>  
                <div id="okAnswer" > 
                <div class="problem_hui">
                	<h3>专家确认回答</h3>
                	<div style="width:100%;height:100%;text-align:center;vertical-align:middle;"><img src="<%=contextPath%>/interface/resource/images/rotation.gif"/></div>
                </div>
                </div>
                <div  id="otherAnswer" >
                <div class="other_da">
                	<h4>其他回答</h4>
			        <div style="width:100%;height:100%;text-align:center;vertical-align:middle;"><img src="<%=contextPath%>/interface/resource/images/rotation.gif"/></div> 
                </form>   
                </div>
                </div>
		  </div>
    	</div>
        <div class="index_right fr">
        	<jsp:include page="/common/userinfo.jsp"/>
        	<%-- <jsp:include page="/webpages/index/index_ad.jsp"/> --%>
            <jsp:include page="/webpages/index/index_announcement.jsp"/>
            <div class="wtiwen"><a href="#"><img src="<%=contextPath%>/interface/resource/images/wtiwen.png" alt="" onclick="window.open('question');" /></a></div>
            <jsp:include page="/webpages/index/index_weibo.jsp"/>
            <jsp:include page="/webpages/index/index_expert.jsp"/>
            <jsp:include page="/common/static/activeUser_static.jsp"/>
        </div>
    </div>
    <div class="clear"></div>
     <jsp:include page="/common/footer.jsp"/><!--footer end-->
    
    <div id="share" style="display:none;">
      <div class="passit_barDiv"><a class="passit_default" href="http://www.passit.cn/bookmark.html" target="_blank"></a></div>
     </div>
<SCRIPT type=text/javascript> 
$(".allsort").hoverForIE6({current:"allsorthover",delay:200});
$(".allsort .item").hoverForIE6({delay:150});
function myfunction(){
	if(user == 'null'){
		showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','','');
		window.location.href = "http://zhuanjia.haufe.cn/login";
	}
}
</SCRIPT>


<body onload="myfunction()">
</body>
<script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#uuid=&amp;style=999&amp;img=http%3A%2F%2Fstatic.bshare.cn%2Fimages%2Fbuttons%2Fbox-shareTo-zh.gif&amp;w=147&amp;h=21"></script>
</html>
