<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String contextPath = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=contextPath%>/haufe/css/haufe.css" rel="stylesheet" type="text/css"/>
<script src="<%=contextPath%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/haufe/js/script.js" type="text/javascript"></script>
<jsp:include page="/common/operamasks.jsp"/>
<title>浩富-用户注册</title>
</head>
<body>
<jsp:include page="/haufe/common/head.jsp"/>
<script type="text/javascript">
$(document).ready(function() {
	$.validator.addMethod("isMobilPhone", function(value) {
    	var regu =/(^[1][3][0-9]{9}$)|(^[1][5][0-9]{9}$)|(^[1][8][0-9]{9}$)|(^[0][1-9]{1}[0-9]{9}$)/; 
        var reg = new RegExp(regu);
        return reg.test(value);  // 手机验证 13x 15x 18x 以此类推
	}, '不是有效的手机号码');
	$("#registerForm").validate({
        rules : {
        	email : {required:true,email:true,remote:'userRegister!verifiEmail.action?num='+Math.random()},
            mobile : {remote:'userRegister!verifiMobile.action?num='+Math.random()},
        	password : {required:true,minlength:6,maxlength:18},
            valiPass : {required:true,equalTo:"#password"},
            aliasName : {required:true},
        },
        messages : {
            email : {required : "请输入常用的邮箱地址",email : "请输入正确的email格式！",remote:'此邮箱已经被注册'},
            mobile : {remote:'此手机号已经被注册'},
            password : {required : "请输入6-18位字母或数字组合",minlength : "请输入6-18位字母或数字组合",maxlength : "密码长度不能超过18位"},
            valiPass : {required : "请再次输入您设置的密码",equalTo :'两次密码输入的不一致'},
            aliasName : {required : "请输入您的昵称"},
       }
	});
});
</script>
<style type="text/css">
label.error {
	background: #fff6bf url('<%=contextPath%>/interface/resource/images/error.png') center no-repeat;
	background-position: 5px 50%;
	text-align: left;
	padding: 1px 10px 2px 20px;
	border: 1px solid #ffd324;
	display: none;
	width: 200px;
	margin-left: 10px;
	font-size: 12px;
}
</style>
<div class="content">
    <div class="content-head">浩富通行证</div>
    <div class="passport clearfix">
        <div class="left" style="width: 440px;">
            <h3>创建浩富通行证</h3>
            <p class="icon icon-1">一个账号畅游多个服务--感受极致便捷体验。</p>
            <p class="icon icon-2">免费申请试用，享受专业的咨询服务。</p>
            <p class="icon icon-3">享受全方位的快捷服务--应用体验，咨询新服务。</p>
        </div>
        <div class="right" style="width: 520px;">
            <div class="rg-nav clearfix">
                <a href="login" class="lg">登 录</a>
                <a href="register" class="rg">注 册</a>
            </div>
            <div class="fields" style="margin-top:20px;">
					<form action="<%=contextPath%>/userRegister.action" method="post"
						id="registerForm">
						<dl>
							<dt>
								<font color="red">(*)</font>电子邮箱:
							</dt>
							<dd>
								<input type="text" name="email" id="email" class="input"
									maxlength="50" />
							</dd>
						</dl>
						<dl>
							<dt>手机号码:</dt>
							<dd>
								<input type="text" class="input" name="mobile" id="mobile"
									maxlength="20" />*用于提醒专家答案
							</dd>
						</dl>
						<dl>
							<dt>
								<font color="red">(*)</font>登录密码:
							</dt>
							<dd>
								<input type="password" class="input" name="password"
									id="password" maxlength="20" />
							</dd>
						</dl>
						<dl>
							<dt>
								<font color="red">(*)</font>确认密码:
							</dt>
							<dd>
								<input type="password" class="input" name="valiPass"
									id="valiPass" maxlength="20" />
							</dd>
						</dl>
						<dl>
							<dt>
								<font color="red">(*)</font>用户昵称:
							</dt>
							<dd>
								<input type="text" class="input" name="aliasName" id="aliasName"
									maxlength="50" />
							</dd>
						</dl>
						<dl>
							<dt>真实姓名:</dt>
							<dd>
								<input type="text" class="input" name="userName" id="userName"
									maxlength="20" />
							</dd>
						</dl>
						<dl>
							<dt style="height: 40px;"></dt>
							<dd>
								<input type="submit" value="注册" class="btnSave" />
							</dd>
						</dl>
					</form>
				</div>
        </div>
    </div>
</div>
<%-- <jsp:include page="/haufe/common/foot.jsp"/> --%>
</body>
</html>