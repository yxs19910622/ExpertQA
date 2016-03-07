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
       <div class="top_title">重置密码成功</div>
       <div class="top_title">重置密码</div>
       <div class="result_sty01">密码重置成功！</div>
       <div class="result_sty02">本页面将在<span id="sec">5</span>秒后自动跳转，如果没有跳转，请<a href="http://zhuanjia.haufe.cn/">点击此处</a></div>

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
function go(){
	location.href = "http://zhuanjia.haufe.cn/";
}

setTimeout("go()",5000);
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
