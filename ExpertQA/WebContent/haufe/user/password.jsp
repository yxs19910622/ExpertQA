<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String contextPath = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重置密码_用户中心_浩富</title>
<meta name="keywords" content="重置密码,找回密码,用户中心,浩富" />
<meta name="description" content="密码忘记了？别慌！浩富用户中心为您提供找回密码服务。" />
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
var getpwd_url = 'http://my.iciba.com/?c=register&m=checkEmail';
var setpwd_url = 'http://my.iciba.com/?c=password&m=get';
</script>
</head>

<body>
<!--header_logo start-->
<div id="header_logo"><a href="http://my.iciba.com/"><img src="<%=contextPath%>/haufe/images/logo.jpg" alt="浩富 用户中心" /></a></div>
<!--header_logo end-->
<!--retrieve password start-->
<div class="ctr_box02">
   <div class="scs_top_bg"></div>
   <div class="scs_ctr_bg">
     <div class="retrieve_password">
       <div class="top_title">重置密码</div>
       <div class="ctr_inpbox">
         <dl style="padding-top:40px;">
            <dd>帐号邮箱： </dd>
            <dt><input class="inp" style="width:390px;" type="text" id="email" name="email" onfocus='if (this.value == "") this.value = "";this.className = "inpred";' size="20" maxlength="31" autocomplete="off"  /></dt>
            <dt id="tips_email"><span>只有通过邮箱验证的浩富帐号才能找回密码。</span></dt>
         </dl>
         <%-- <dl>
            <dd>验证码： </dd>
            <dt>
               <div class="validation_inpbox"><input class="inp" style="width:60px;" type="text" id="validation" name="validation" onfocus='if (this.value == "") this.value = "";this.className = "inp";' size="20" maxlength="6" /></div>
               <div class="validation_imgbox">
               	<a id="img" href="javascript:;">
             		<img id="authcode_img" src="http://my.iciba.com/auth.php?rand=0.23405616608643787"/>
             	 </a>
               </div>
            </dt>
            <dt id="tips_authcode"><span>不区分大小写，点击即可更换一个</span></dt>
         </dl> --%>
         <dl>
           <dt><input id="next" type="button"  title="下一步" value="" class="btn-next" tabindex="9" onclick="password();"/>
           <span id="regstat"></span></dt>
         </dl>
       </div>
       <!--<div class="explain">
          <dd>未收到密码找回邮件怎么办？</dd>
         <dt>尝试到垃圾邮件里找找看，gmail请到左侧导航“其他n个标签”查看垃圾邮件；<br />
没有收到密码找回邮件，有可能因为延迟导致的，请稍候查收，也可以<a id="sendAgain" href="javascript:;" onclick="resub();">再次发送</a>。</dt>
       </div>-->
     </div>
   </div>
   <div class="scs_btm_bg"></div>
</div>
<!--retrieve password end-->
<script type="text/javascript" >
function password(){
	
	var email = $('#email').val();
	var emailok = checkEmail(email);
	if(emailok==2){
		location.href = "<%=contextPath%>/password_email.action?email="+email;
	}
}


</script>


<div style="display:none">
	<script>var _kds2_p = 2115;</script>
	<script src="http://goto.www.iciba.com/kds2/kds2_record.js" type="text/javascript" charset="utf-8"></script>
	<noscript><img width="0" height="0" src="http://counter.kds.iciba.com/ds2rd.php?p=2115" style="border:none"></noscript>
	<script src="http://click.iciba.com/h.js?515a9b7b3272c00505e4553a1b306c10"></script>
</div>

<script  type="text/javascript" src="http://img.my.iciba.com/js/jquery.mailAutoComplete-3.1.js"></script>
<script type="text/javascript" src="http://img.my.iciba.com/js/global.js"></script>
<script type="text/javascript" src="http://img.my.iciba.com/js/getpwd.js"></script>
</body>
</html>
