<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.lang.Exception,java.io.*,java.util.*" %>
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
					           <td height="43" valign="bottom" style=" border-bottom:1px dotted #0b5fb4;"><h4>抱歉，您访问的页面出错了...</h4></td>
					      </tr>
					      <tr>
					           <td height="29" class="font3">出错的原因可能有以下几种： </td>
					      </tr>
					      <tr>
					        <td valign="top">
						        <table width="100%" border="0" cellspacing="0" cellpadding="0">
						          <tr>
						            <td><p>您输入的地址有误 </p></td>
						            <td><p>该链接地址不存在 </p></td>
						          </tr>
						          <tr>
						            <td><p>该链接已经更换成新的网址 </p></td>
						            <td>&nbsp;</td>
						          </tr>
						        </table>         
					         </td>
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
   <div style="display:none;">  
		<h2><font color=#DB1260>Error Page</font></h2>
		<p>An exception was thrown: <%=exception.getClass()%>:<%=exception.getMessage()%></p> 
		<p>Request URI:<%=request.getAttribute("javax.servlet.forward.request_uri") %></p> 
		<p>Request Attribute:</p>    
		<pre>
        <%
            Enumeration<String> e = request.getAttributeNames(); 
            String key; 
			while(e.hasMoreElements()){   
			  key = e.nextElement();   
			  out.println("                "+key+"="+request.getAttribute(key));   
			}   
		%>
		</pre>
		<p>Request Parameter:</p>
		<pre>
		<%	  
			e = request.getParameterNames();   
			while(e.hasMoreElements()){   
			  key = e.nextElement();   
			  out.println(key+"="+request.getParameter(key));   
			}
		%>
		</pre>
		<p>With the following stack trace:</p>    
		<pre>   
			<%
		      exception.printStackTrace();  
		      ByteArrayOutputStream ostr = new ByteArrayOutputStream();   
		      exception.printStackTrace(new PrintStream(ostr));   
		      out.print(ostr);  
		    %>   
		</pre>   
   </div>
</body>
</html>
<%response.setStatus(HttpServletResponse.SC_OK);%>
