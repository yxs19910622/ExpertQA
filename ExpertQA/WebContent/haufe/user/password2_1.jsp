<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String contextPath = request.getContextPath();
    String str = (String)request.getAttribute("email");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重置密码_用户中心_浩富中国</title>
<meta name="keywords" content="重置密码,找回密码,用户中心,浩富中国" />
<meta name="description" content="密码忘记了？别慌！浩富中国用户中心为您提供找回密码服务。" />
<link rel="stylesheet" href="http://img.my.iciba.com/css/login.css" type="text/css" />
<link rel="shortcut icon" href="/favicon.ico" type="/image/x-icon" />
<script type="text/javascript" src="http://img.my.iciba.com/js/png.js"></script>
<script type="text/javascript" src="http://img.my.iciba.com/js/jquery-1.7.2.min.js"></script>
<!--右侧浮动在线反馈开始-->
<style type="text/css">
.online_fb {
    display: block;
    height: 100px;
    position: fixed;
    _position:absolute;
    right: 1px;
    top: 178px;
    width: 22px;
    z-index: 4000;
}
.online_fb {
    background-image: url("/static/images/img_page2.gif");
    background-repeat: no-repeat;
}
</style>
<a class="online_fb" title="在线反馈" href="http://support.iciba.com/feedback/write.php?id=5" target="_blank"></a>
<!--右侧浮动在线反馈结束-->
<script type="text/javascript">
var resetpwd_url = 'http://my.iciba.com/?c=password&m=reset';
</script>
</head>

<body>
<!--header_logo start-->
<div id="header_logo"><a href="http://my.iciba.com/"><img src="<%=contextPath%>/haufe/images/logo.jpg"" alt="浩富 用户中心" /></a></div>
<!--header_logo end-->
<!--retrieve password start-->
<div class="ctr_box02" id="main">
   <div class="scs_top_bg"></div>
   <div class="scs_ctr_bg">
     <div class="retrieve_password">
       <div class="top_title">重置密码</div>
       <div class="top_x_title">您好！请重新设置您的登录密码。</div>
       <div class="ctr_inpbox">
         <dl style="padding-top:40px;padding-bottom:10px;">
            <dd>新密码： </dd>
            <dt><input class="inp" style="width:390px;" type="password" id="password" name="password" onfocus='if (this.value == "") this.value = "";this.className = "inp";' onKeyUp="pwStrength(this.value);" onBlur="pwStrength(this.value);" size="20" maxlength="16" /></dt>
            <dt id="tips_pwd"><span>6～16个字符，可使用数字、字母（区分大小写）和特殊符号。</span></dt>
         </dl>
         <dl>
            <dd>确认密码： </dd>
            <dt><input class="inp" style="width:390px;" type="password" id="password1" name="password" onfocus='if (this.value == "") this.value = "";this.className = "inp";' size="20" maxlength="16" /></dt>
            <dt id="tips_pwd1"><span>请再次输入密码。</span></dt>
         </dl>
         <dl>
           <dt><input type="button" onclick="alert_psw();" title="确认修改" value="" class="btn-modify" tabindex="9" /></dt>
         </dl>
       </div>
     </div>
   </div>
   <div class="scs_btm_bg"></div>
</div>

<script language="javascript" type="text/javascript"> 

function alert_psw(){
	var pwd = $('#password').val();
	var flag = pwConfirm();
	var flag1 = pwStrength(pwd);
	if(flag==true&&flag1==true){
		//访问带参action改密码
		window.location.href = "<%=contextPath%>/password_alert.action?pwd="+pwd+"&email=<%=str%>";
	}
}

</script> 
<style type="text/css">
<!--
.hp_footer{color:#999!important;}#foot a:link,#foot a:visited{color:#999}#foot .text_blue:link,#foot .text_blue:visited{color:#4372b6}#pull_down li.bg_blue{background-color:#4372b6;color:#fff}#foot a:hover,#spdc a:hover,#spdc .font_black:hover,#foot span a:hover{text-decoration:underline;color:#4372b6}
-->
</style>


<div style="display:none">
	<script>var _kds2_p = 2115;</script>
	<script src="http://goto.www.iciba.com/kds2/kds2_record.js" type="text/javascript" charset="utf-8"></script>
	<noscript><img width="0" height="0" src="http://counter.kds.iciba.com/ds2rd.php?p=2115" style="border:none"></noscript>
	<script src="http://click.iciba.com/h.js?515a9b7b3272c00505e4553a1b306c10"></script>
</div>

<script type="text/javascript" src="http://img.my.iciba.com/js/global.js"></script>
<script type="text/javascript" src="http://img.my.iciba.com/js/setpwd.js"></script>
</body>
</html>