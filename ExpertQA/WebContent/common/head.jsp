<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page import="org.izhong.expert.util.CookieUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String contextPath = request.getContextPath();
HttpSession sess = request.getSession();
String idx = request.getParameter("indexPage");
Cookie operate = CookieUtil.getCookieByName(request, "operate");
Cookie euserId = CookieUtil.getCookieByName(request, "EUserID");
String oper = operate != null?operate.getValue():"";
%>
<script type="text/javascript">
function showLogin()
{
login.style.display = "block";
}
function showForbid()
{
forbid.style.width = document.body.clientWidth;
forbid.style.height = document.body.clientHeight;
forbid.style.visibility = "visible";
}
</script>
<%-- <style type="text/css">
body {
margin:0; /* 必须 */
border:0;
height:100%; /* 必须 */
overflow-y:auto;/* 必须 */
}
#div2 {
/* IE并不认识fixed，而FF认识 */
display:block; 
bottom:0px; 
left:0px; 
width:300px; 
position:fixed;
}
* html #div2 {
/* 这个只有IE认识 */
position:absolute;
} --%>
</style>
<script type="text/javascript">
<!--
var oper = '<%=oper%>';
var user = '<%=euserId%>';
var path = '<%=contextPath%>';
function linkSearch(val){
	//alert(user);
	if(user != 'null'){
	var keywd = document.getElementById('keyword').value;
	if(val != '')keywd = val;
	if(keywd != '' && keywd.length > 1){
		var k = keywd.replace(/\s+/g,'');
		if(k.length != 0){
		     window.open('<%=contextPath%>/searchAnswer?questionTitle='+encodeURI(keywd),'_self');
		}else{
			 //alert('请输入搜索关键词');
			 showWindow('','提示信息','请输入搜索关键词','','');
	    }
	}else{
        //alert('请输入搜索关键词');
		showWindow('','提示信息','请输入搜索关键词','','');
	}
	}else{
        //alert('你还没有登录');   
		showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','',''); 
	}
}

function moreSearch(){
	//if(user != 'null'){
		window.open('<%=contextPath%>/searchAnswer?flag=1','_self');
	//	}else{
	        //alert('你还没有登录');  
	//		showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login?flag=onlinepay">登录</a>','',''); 
	//	}	
}
function questionButton(str){
	if(user != 'null'){
	    if(containsTxt(oper,'question')){
	        window.open('<%=contextPath%>/question','_self');
	        if(str==1){
	        	window.open('<%=contextPath%>/question_mirror','_self');
	        }
	    }else{
            //alert('权限不够,请申请试用');
	    	showWindow('','提示信息','很遗憾您的7天试用期已过,<br>要想继续获得权威劳动法专家的咨询答疑,<br>请<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/addCart.action?productNo=P0002">付费购买</a>劳动法顾问软件专业版','','');
	    }
	}else{
        //alert('你还没有登录'); 
		showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','','');
	}
}
function expertAnswerButton(){
	//if(user != 'null'){
	   // if(containsTxt(oper,'viewAnswer')){
	        window.open('<%=contextPath%>/expertAnswer','_self');
	   // }else{
            //alert('权限不够,请申请试用');
	   // 	showWindow('','提示信息','很遗憾您的7天试用期已过,<br>要想继续获得权威劳动法专家的咨询答疑,<br>请<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/addCart.action?productNo=P0002">付费购买</a>劳动法顾问软件专业版','','');
		//}
	//}else{
        //alert('你还没有登录');    
		showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','','');
	//}
}
function containsTxt(oper,txt){
	if(oper != 'null'){
     var arr = oper.split('#');
     for(var i = 0;i < arr.length; i++){
         if(arr[i] == txt){
          return true;
          }
      }
	}else{
     return false;
	}
}
//-->

</script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/popWin.js"></script>
<div class="headerb">
	<div class="header_center">
  		<div class="logob"><img src="<%=contextPath%>/interface/resource/images/haufe.png" alt="" /></div>
        <div class="navb">
        	<ul>                
            	<li><a target="_blank" href="http://www.haufe.cn">首&nbsp;&nbsp;页</a></li>
                <!-- <li><a href="#">在线浏览</a></li> -->
                <li><a href="<%=contextPath%>/index" class="zhuanjiaa" id="nav_dang">专家在线问答</a></li>
                <li><a target="_blank" href="http://zhuanjia.haufe.cn/index_tools.action">劳动法工具</a></li>
                <!-- <li><a target="_blank" href="http://www.izhong.com/laodongfa/tools">HR工具库</a></li> -->
                <li><a target="_blank" href="http://www.haufe.cn/hyxw/pages/1.html">HR新闻</a></li>
                <li><a target="_blank" href="<%=contextPath%>/BuyOnline">在线购买</a></li>
            </ul>
        </div>
        
        <div class="sousuo">
        	<div class="sousuo_li">
            	<table width="" border="0" cellspacing="0" cellpadding="0" style="margin-left:9px;">
                  <tr>
                    <td><input id="keyword" type="text" class="input_03" onkeydown="if(event.keyCode==13)linkSearch('');"/></td>
                    <td><input type="button" value="搜索答案" class="input_04" onclick="linkSearch('');"/></td>
                    <td><input type="button" value="我要提问" class="input_04" onclick="questionButton();"/></td>
                    <td><input type="button" value="专家回答" class="input_04" onclick="expertAnswerButton();"/></td>
                    <td valign="middle"></td>
                  </tr>
                </table>
            </div>
        </div>
        <div class="sousuo_footer">
        	<s:if test="lstqhw!=null">
        		<p>热门关键词：
        		<s:iterator value="lstqhw">
        			<a href="#" onclick="linkSearch('<s:property value="word"/>');"><s:property value="word"/></a>
        		</s:iterator>
        		<span style="margin-left:540px;padding:0px;"></span>
        		<%-- <% 
        		if(euserId != null && (idx+"").equals("null")){
        		%>	
        		   <a id="back" href="logout.action" style="font-size:14px;font-weight:bold;height:16px;">退出</a>	
        		<%}%> --%>
        		
        		</p>
        	</s:if>
        	
        </div>
	</div>
</div>


