<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String ctx = request.getContextPath();

String online = "";
if(request.getParameter("online")!=null){
	online = request.getParameter("online");
}
%>
<html>
<head>
	<SCRIPT src="<%=ctx%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
	<link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/common.css">
	  
<title>客户号输入</title>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script language="javascript" type="text/javascript"> 
//检测输入是否为数字
function checknumber(String){
    if(trimTxt(String)=="")
    {
       return false;
    }
    var Letters = "1234567890"; 
    var i; 
    var c; 
    for( i = 0; i < String.length; i ++ ) { 
        c = String.charAt( i ); 
        if (Letters.indexOf( c ) ==-1) { 
           return false; 
        } 
    } 
    return true; 
}
//空格替换
function trimTxt(txt)
{
   return txt.replace(/(^\s*)|(\s*$)/g, "");
}
function submitCustomerId(){
	var cid = $('#customerId').val();
	if(checknumber(cid)){
		$('#payForm').submit();
	}else{
		alert('请输入正确的客户号');
		$('#customerId').focus();
		return;
	}
	
}
function init(){
	if('<%=online%>' != ''){
		$('#message').css('display','block');
		setTimeout(function(){
			$('#message').css('display','none');
            },5000);
    }
}

</script> 
</head>
<body onload="init();">

<form id="payForm" name="payForm" action="<%=ctx %>/onlinepay" method="post">

<table style="margin:38px auto 0;" width="350"  align="center" border="0" cellpadding="0" cellspacing="0">
  	<tr>
  	    <td colspan="3"><div id="message" style="display:none;"><font color="#ff0000" ><b>您输入的客户号有误  请重新输入正确的客户号</b></font></div></td> 
  	</tr>
  	<tr>
    	<td>请输入客户号:</td><td><input id="customerId"  name="customerId" type="text"/></td><td><input type="button" value="确定" onclick="submitCustomerId();"/></td>
  	</tr>
  	<tr>
  	    <td colspan="3">&nbsp;&nbsp;</td>
  	</tr>
  	<tr>
  	    <td colspan="3"><font color="#ff0000" ><b>(如果没有客户号请联系客服电话：010-58856886)</b></font></td> 
  	</tr>
</table>
</form>

</body>
</html>