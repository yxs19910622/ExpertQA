<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=contextPath%>/haufe/css/haufe.css" rel="stylesheet" type="text/css"/>
<script src="<%=contextPath%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/haufe/js/script.js" type="text/javascript"></script>
<jsp:include page="/common/operamasks.jsp"/>
<title>浩富-用户登录</title>
</head>
<body>
<jsp:include page="/haufe/common/head.jsp"/>
<script language="javascript" type="text/javascript" src="http://pv.sohu.com/cityjson?ie=utf-8">  
</script>    
 <script>
 var ip = returnCitySN.cip;
</script>  
<script type="text/javascript" >
var test = window.location.search;
var flag = test.replace("?","");
if(flag.length>15){
	window.location.href = "init_login.action?"+flag;
}

$(document).ready(function() {
	//点击刷新验证码功能
    $('#loginForm img').click(function(){
        //因为浏览器默认会缓存图片，所以只要改变url就可以跳过缓存
        //每次在url后面添加随机数就可以保证url不重复
        this.src='userLogin!validateImage.action?num='+Math.random();
    });
	$("#loginForm").validate({
        errorLabelContainer : "#errorMessages",
        rules : {
          email : {required:true},
          loginPass : "required",
          validatecode : "required"
        },
        messages : {
          email : {required : "请输入登录帐号！"},
          loginPass : {required : "请输入登录密码！"},
          validatecode : {required : "请输入验证码！"}
        },
        submitHandler : function(){
            $("#loginForm").omAjaxSubmit({
                url :'userLogin!SignIn.action?ip='+ip+'&flag='+flag,
                success:function(responseText,statusText, xhr, $form){
                	if(flag == 'onlinepay'){
                    	self.location.href='BuyOnline?kehu';
                	}else if(flag =='cartList'){
                        self.location.href='cartList';
                	}else if(responseText=='true'){
                        self.location.href='index';
                    }else{
                        $('#errorMessages').html(responseText).show();
                    }
                }
            });
            return false;
          }
        });
});
function loadimage() {
	var imgSrc = $("#image");   
    imgSrc.attr("src",'userLogin!validateImage.action?num='+Math.random());
}
</script>
<style type="text/css">
#errorMessages {
	margin-left: 20px;
	background-color: #fff6bf;
	border: 1px solid #FF8080;
	padding-left: 20px;
	height: 18px;
	line-height: 18px;
	display: none;
}
</style>
<div class="content">
    <div class="content-head">浩富通行证</div>
    <div class="passport clearfix">
        <div class="left">
            <h3>登陆浩富通行证</h3>
            <p class="to-reg">享受浩富提供的更多应用和服务，请在右侧登录或<a href="register">免费注册</a></p>
        </div>
        <div class="right">
            <div class="lg-nav clearfix">
                <a href="login" class="lg">登 录</a>
                <a href="register" class="rg">注 册</a>
            </div>
            <div class="fields" style="margin-top: 20px">
                <form action="#" method="post" id="loginForm">
                	<dl style="height: 25px;line-height: 25px;">
                	<div align="center" id="errorMessages"></div></dl>
                    <dl><dt>邮箱/手机号：</dt><dd><input type="text" name="email" id="email" class="input"/></dd></dl>
                    <dl><dt>登录密码：</dt><dd><input type="password" name="loginPass" id="loginPass" class="input"/>
                    	<a href="<%=contextPath%>/resetpwd" class="forget">忘记密码</a></dd></dl>
                    <dl><dt>验证码：</dt><dd><input type="text" class="input" style="float:left; width: 80px;" name="validatecode" id="validatecode"/></dd>
                    <img id="image" style=" float:left; padding-top:6px;" src="userLogin!validateImage.action" title="点击刷新验证码"/>
                    <a href="javascript:loadimage();" class="forget" style="float:left; font-size: 12px;">看不清，换一个</a>
                    </dl>
                    <dl><dt style="height: 40px;"></dt><dd><input type="submit" value="登录" class="btnSave"/></dd></dl>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/haufe/common/foot.jsp"/>
</body>
</html>