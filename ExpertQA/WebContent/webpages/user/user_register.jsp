<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<title>专家在线问答_用户注册</title>
</head>
<style type="text/css">
label.error {
	background: #fff6bf url('<%=contextPath%>/interface/resource/images/error.png') center no-repeat;
	background-position: 5px 50%;
	text-align: left;
	padding: 2px 20px 2px 25px;
	border: 1px solid #ffd324;
	display: none;
	width: 200px;
	margin-left: 10px;
}
</style>
<script type="text/javascript">
var remote;
$(document).ready(function() {
	remote = $("#registerForm").validate({
        rules : {
          email : {required:true,email:true,remote:'userRegister!verifiEmail.action?num='+Math.random()},
          password : {required : true,minlength : 6,maxlength : 18},
          valiPass : {required : true,equalTo : "#password"},
          aliasName : "required",
          customerId : {required:true,remote:'userRegister!verifiCustomerId.action?num='+Math.random()}
        },
        messages : {
          email : {required : "请输入常用的邮箱地址",email : "请输入正确的email格式！",remote:'此邮箱已经被注册'},
          password : {required : "请输入6-18位字母或数字组合",minlength : "请输入6-18位字母或数字组合",maxlength : "密码长度不能超过18位"},
          valiPass : {required : "请再次输入您设置的密码",equalTo :'两次密码输入的不一致'},
          aliasName : {required : "请输入您的昵称"},
          customerId : {required : "请输入易中客户号，如没有或忘记请联系易中客服010-58856886免费索取",remote:'您输入的客户号码不正确!'}
        }
   });
});
function showCodeError()
{
	remote.showErrors({"customerId": "请输入易中客户号，如没有或忘记请联系易中客服010-58856886免费索取"});
}
</script>
<body onload="showCodeError();">
<jsp:include page="/common/head.jsp"/>
<div class="wbgAboutwarp">
	<div class="wbgPublicDiv_lx">
    	<div class="wbgPublicTitle_lx"><h2 style="color:#ff7700">用户注册</h2>
			<div class="divRight"></div>
		</div>
        <div class="wbgPublicListTit_lx" style="padding-top:18px;">
        	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" class="Ltd">
    	<tr>
        	<td width="100%" valign="top">
        		<form action="userRegister.action" method="post" id="registerForm">
            	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
                    <tr>
                        <td width="20%" align="right"><font color="red">*</font>&nbsp;电子邮箱：</td>
                        <td width="65%"><input type="text" id="email" name="email"/></td>
                    </tr>
                    <tr>
                        <td style="height:30px" width="20%" align="right"><font color="red">*</font>&nbsp;登录密码：</td>
                        <td width="65%"><input type="password" id="password" name="password" maxlength="20"/></td>
                    </tr>
                    <tr>
                        <td style="height:30px" width="20%" align="right"><font color="red">*</font>&nbsp;确认密码：</td>
                        <td width="65%"><input type="password" id="valiPass" name="valiPass" maxlength="20"/></td>
                    </tr>               
                    <tr>
                        <td style="height:30px" width="20%" align="right"><font color="red">*</font>&nbsp;用户昵称：</td>
                        <td width="65%"><input type="text" id="aliasName" name="aliasName"/></td>
                    </tr>
					<tr>
                        <td style="height:30px" width="20%" align="right"><font color="red">*</font>&nbsp;客户号码：</td>
                        <td width="65%" colspan="2"><input type="text" id="customerId" name="customerId"/></td>
                    </tr>
					<tr>
                        <td style="height:30px" width="20%" align="right">真实姓名：</td>
                        <td width="65%"><input type="text" id="userName" name="userName"/></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">手机号码：</td>
                        <td><input type="text" id="mobile" name="mobile"/></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" checked="checked" style="height:auto;width:auto;float:right;background-image:none; border-top:none; border-right:none; border-left:none; border-bottom:none;"/></td>
                        <td>我已经阅读并同意<a target="_blank" href="terms"><font style="font-size: 14px;color: red">《服务条款》</font></a></td>
                        <td class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:50px" align="right"></td>
                        <td><input type="submit" class="botn_gary" value="保 存" title="保 存" /></td>
                    	<td></td>
                	</tr>
            	</table>
            	</form>
        	</td>
		</tr>
	</table>
            </div>
        </div>
	</div>
</body>
</html>