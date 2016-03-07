<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String contextPath = request.getContextPath();
    String str = (String)request.getAttribute("email");
    String a[] = str.split("@");  
    String email = "http://mail."+a[1];
    if(a[1].equals("163.com")){
    	email="http://mail.163.com/";
    }else if(a[1].equals("126.com")){
    	email="http://www.126.com/";
    }else if(a[1].equals("qq.com")||a[1].equals("vip.qq.com")){
    	email="https://mail.qq.com/cgi-bin/loginpage";
    }else if(a[1].equals("gmail.com")){
    	email="https://mail.google.com/";
    }else if(a[1].equals("yahoo.com.cn")||a[1].equals("yahoo.cn")||a[1].equals("yahoo.com")){
    	email="http://cn.mail.yahoo.com/";
    }else if(a[1].equals("sina.com")||a[1].equals("sina.cn")||a[1].equals("2008.sina.com")||a[1].equals("51uc.com")){
    	email="https://mail.sina.com.cn/";
    }else if(a[1].equals("139.com")){
    	email="http://mail.10086.cn/";
    }else if(a[1].equals("189.com")){
    	email="http://webmail3.189.cn/webmail/";
    }else if(a[1].equals("yeah.net")){
    	email="http://www.yeah.net/";
    }else if(a[1].equals("sohu.com")){
    	email="http://mail.sohu.com/";
    }else if(a[1].equals("tom.com")){
    	email="http://web.mail.tom.com/webmail/login/index.action";
    }else if(a[1].equals("foxmail.com")){
    	email="http://mail.qq.com/cgi-bin/loginpage?t=fox_loginpage&sid=,2,zh_CN&r=596fb404e6a70fd45251c5d8f810cb52";
    } 
    
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>浩富</title>
<meta name="keywords" content="浩富" />
<meta name="description" content="浩富" />
<link href="<%=contextPath%>/haufe/css/haufe.css" rel="stylesheet" type="text/css"/>
<script src="<%=contextPath%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/haufe/js/script.js" type="text/javascript"></script>
<link rel="stylesheet" href="http://img.my.iciba.com/css/login.css" type="text/css" />
<link rel="shortcut icon" href="/favicon.ico" type="/image/x-icon" />
<script type="text/javascript" src="http://img.my.iciba.com/js/png.js"></script>
<script type="text/javascript" src="http://img.my.iciba.com/js/jquery-1.7.2.min.js"></script>


</head>

<body>
<!--header_logo start-->
<div id="header_logo"><a href="http://my.iciba.com/"><img src="<%=contextPath%>/haufe/images/logo.jpg" alt="浩富 用户中心" /></a></div>
<!--header_logo end-->
<!--Registration start-->
<div class="ctr_box02">
   <div class="scs_top_bg"></div>
   <div class="scs_ctr_bg">
     <div class="retrieve_password">
       <div class="top_title">找回密码</div>
       <div class="top_x_title"></div>
       <div class="ctr_inpbox">
          <h1>您好！已将重置密码邮件发送到<span><%=str%></span>邮箱中。</h1>
          <h1 style="padding-top:65px"><input type="button"  title="立即查收邮件" value="" class="btn-viewemail" tabindex="9" onclick="window.open('<%=email%>')" /></h1>

       <%-- <div class="explain">
          <dd>没收到密码找回邮件？</dd>
         <dt>尝试到垃圾邮件里找找看或<a href="<%=contextPath%>/email_ag.action?email=<%=str%>">再次发送验证邮件</a>。</dt>
       </div> --%>
     </div>
   </div>
</div>
</div>
<!--Registration end-->

<style type="text/css">
<!--
.hp_footer{color:#999!important;}#foot a:link,#foot a:visited{color:#999}#foot .text_blue:link,#foot .text_blue:visited{color:#4372b6}#pull_down li.bg_blue{background-color:#4372b6;color:#fff}#foot a:hover,#spdc a:hover,#spdc .font_black:hover,#foot span a:hover{text-decoration:underline;color:#4372b6}
-->
</style>
<!--foot start-->

<!--foot end-->
<script type="text/javascript">

<div style="display:none">
	<%-- <script>var _kds2_p = 2115;</script> --%>
	<script src="http://goto.www.iciba.com/kds2/kds2_record.js" type="text/javascript" charset="utf-8"></script>
	<noscript><img width="0" height="0" src="http://counter.kds.iciba.com/ds2rd.php?p=2115" style="border:none"></noscript>
</div>
</body>
</html>