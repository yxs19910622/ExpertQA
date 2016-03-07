<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面访问出错了 </title>
<link href="<%=request.getContextPath()%>/interface/resource/css/base.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/interface/javascript/jquery-1.5.1.js" type="text/javascript"></script>
<script type="text/javascript">
	//function isIframeSelf(){try{if(window.top ==window){return false;}else{return true;}}catch(e){return true;}}
	//function toHome(){ if(!isIframeSelf()){ window.location.href="<%=request.getContextPath()%>";}}
	//window.setTimeout("toHome()",5000);
</script>
</head>

<body>
<table width="700" border="0" cellpadding="0" cellspacing="0" style="margin-left:200px;margin-top:100px;" >
	<tr>
	    <td height="60" align="left" valign="top"><img src="<%=request.getContextPath()%>/interface/resource/images/logob.png" width="310" height="43" /></td>
    </tr>
	<tr>
	    <td align="center" valign="top">
		    <table width="700" border="0" cellpadding="0" cellspacing="0" >
				<tr>
				    <td width="122" rowspan="3" align="center" valign="top"><img src="<%=request.getContextPath()%>/interface/resource/images/error.gif" width="91" height="124" /></td>
				</tr>
			    <tr>
				    <td colspan="2" align="left" valign="top" class="font1">
					    <table width="100%" border="0" cellspacing="0" cellpadding="0">
					      <tr>
					           <td height="43" valign="bottom" style=" border-bottom:1px dotted #0b5fb4;"><h4>抱歉，您请求的资源需要相应的权限! </h4></td>
					      </tr>
					      <tr>
					           <td height="30" class="list-link"> <a href="<%=request.getContextPath()%>/" >返回网站首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);" >退回前一个页面</a></td>
					      </tr>
					    </table>
				    </td>
			     </tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>

<%response.setStatus(HttpServletResponse.SC_OK);%>
