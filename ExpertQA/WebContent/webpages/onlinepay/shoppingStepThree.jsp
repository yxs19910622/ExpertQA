<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = request.getContextPath();
%>
<html>
<head>
	<title>订单支付成功</title>
	<script src="<%=ctx%>/interface/javascript/encrypt.js" type="text/javascript"></script>
	
	
	<link href="<%=ctx%>/interface/resource/css/public.css" rel="stylesheet" type="text/css" />
	<link href="<%=ctx%>/interface/resource/css/box.css" rel="stylesheet" type="text/css" />
	<link href="<%=ctx%>/interface/resource/css/jqueryui/jquery.ui-1.8.css" rel="stylesheet" type="text/css" />
	<link href="<%=ctx%>/interface/resource/css/jnotify/jquery.jnotify.css" rel="stylesheet" type="text/css" />
	
    <link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/common.css">
	<link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/shoppingcart.css">
	<link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/ForShoppingCart.js">
	<link href="<%=ctx%>/interface/resource/css/freeorder/orderInfo.css" rel="stylesheet" type="text/css">
	<style type="text/css">
	
	
	</style>
   <script type="text/javascript">
    function init(){
    	setTimeout(function(){
     	   document.location.href="<%=ctx%>"+"/index.action";
            },3000);
    }
   </script>
	
</head>

<body onload="init();">
<br />
<div class="Wrap_cart">
<div class="List_cart">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="31%"><img src="<%=ctx %>/interface/resource/images/shoppingcart/logo-buy.jpg" width="274" height="52" onclick="location.href='<%=ctx %>/'" style="cursor: pointer;"/></td>
      <td width="69%">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="warebuy3">
        <tr>
          <td width="116" align="center" class="warebuy">1.核对订单信息</td>
          <td width="164" align="center">2.确认订单支付</td>
          <td width="158" align="center">3.支付操作完成</td>
        </tr>
      </table>
      </td>
    </tr>
  </table>
</div>
</div>
<div style="margin:50px auto;width:930px;position:relative;">
  <table width="700" border="0" cellpadding="0" cellspacing="0" >
	<tr>
	    <td width="122" rowspan="3" align="center" valign="top"><img src="<%=ctx%>/interface/resource/images/error.gif" width="91" height="124" /></td>
	</tr>
    <tr>
	    <td colspan="2" align="left" valign="top" class="font1">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		           <td height="43" valign="bottom" style="border-bottom:1px dotted #0b5fb4;"><h4>支付成功</h4></td>
		      </tr>
		      <tr>
		           <td height="30" class="list-link"> <a href="http://www.haufe.cn" >返回网站首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://zhuanjia.haufe.cn" >专家在线问答</a></td>
		      </tr>
		    </table>
	    </td>
     </tr>
  </table>
</div>
</body>

</html>