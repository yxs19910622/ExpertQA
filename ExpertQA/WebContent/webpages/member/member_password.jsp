<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="userPass" name="currOpt"/>
</jsp:include>
<style type="text/css">
label.error{
	background: #fff6bf center no-repeat;
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
$(document).ready(function() {
	$("#userPassForm").validate({
		rules : {
				oldPassword : "required",
				newPassword : {required : true,minlength : 5,maxlength : 16},
           		password : {required : true,minlength : 5,maxlength : 16,equalTo : "#newPassword"}
			},
        messages : {
                	oldPassword : {required : "请输入登录密码"},
                    newPassword : {required : "请输入5-16位密码",minlength : "密码长度不够",maxlength : "密码长度不能超过16位"},
                    password : {required : "请输入5-16位密码",minlength : "密码长度不够",maxlength : "密码长度不能超过16位",equalTo:"两次输入的密码不一致"}
                }
            });
	});
</script>
<div class="wbgRight_user">
	<div class="lesson_tit">登录密码修改</div>
		<form action="userPassSave.action" method="post" id="userPassForm">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" class="Ltd">
				<tr>
                	<td style="height:43px" width="20%" align="right"></td>
                    <td width="45%"><font color="red"><s:property value="error"/></font></td>
				</tr>
            	<tr>
                	<td style="height:43px" width="20%" align="right">原密码：</td>
                    <td width="45%"><input type="password" name="oldPassword"/><font color="red">*</font></td>
				</tr>
				<tr>
                	<td style="height:43px" width="20%" align="right">新密码：</td>
                    <td width="45%"><input type="password" id="newPassword" name="newPassword" style="padding-bottom: 0px;padding-left: 0px;padding-right: 0px;padding-top: 0px;"/>
                    <font color="red">*</font></td>
               </tr>
               <tr>
               		<td style="height:15px" align="right">确认密码：</td>
                    <td><input type="password" id="password" name="password" style="padding-bottom: 0px;padding-left: 0px;padding-right: 0px;padding-top: 0px;"/><font color="red">*</font></td>
              </tr>
              <tr>
              		<td style="height:68px" align="right"></td>
              		<td><input type="submit" class="botn_gary" value="保 存" title="保 存" /></td>
                    <td></td>
             </tr>
          </table>
    	</form>
	</div>
</div>
</body>
</html>