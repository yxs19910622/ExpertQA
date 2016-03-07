<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();
%>
<head>
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<title>专家在线问答_用户登录</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<script type="text/javascript">
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
          email : {required:true,email:true},
          loginPass : "required",
          validatecode : "required"
        },
        messages : {
          email : {required : "请输入邮箱地址！",email : "请输入正确的email格式！"},
          loginPass : {required : "请输入密码！"},
          validatecode : {required : "请输入验证码！"}
        },
        submitHandler : function(){
            $("#loginForm").omAjaxSubmit({
                url :'userLogin!SignIn.action',
                success:function(responseText,statusText, xhr, $form){
                    if(responseText=='true'){
                        self.location.href='index';
                    }else if(responseText == 'onlinepay'){
                    	self.location.href='onlinepay';
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
    var src = imgSrc.attr("src");
    imgSrc.attr("src",'userLogin!validateImage.action?'+new Date().getTime());
}
</script>
<style type="text/css">
#errorMessages {
	margin-left: 20px;
	border: 1px solid #FF8080;
	padding-left: 20px;
	height: 18px;
	line-height: 18px;
	display: none;
}
</style>
<div class="wbgAboutwarp">
	<div class="wbgPublicDiv_lx">
    	<div class="wbgPublicTitle_lx"><h2 style="color:#ff7700">用户登录</h2>
			<div class="divRight"></div>
		</div>
        <div class="wbgPublicListTit_lx" style="padding-top:18px;height:228px">
        	<div align="center" id="errorMessages"></div>
        	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" class="Ltd">
            	<tr>
                	<td width="100%" valign="top">
                		<form action="#" method="post" id="loginForm">
                    	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
                        	<tr>
                            	<td style="height:43px" width="25%" align="right">邮箱地址：</td>
                                <td><input type="text" name="email" maxlength="50"/></td>
                            </tr>
                            <tr>
                            	<td style="height:43px" align="right">密 码：</td>
                                <td><input type="password" name="loginPass" maxlength="18"/></td>
                            </tr>
                            <tr>
                            	<td style="height:43px" align="right">验证码：</td>
                                <td style="width:200px;"><input type="text" name="validatecode" style="width:76px"/>&nbsp;
                                <img id="image" src="userLogin!validateImage.action" title="点击刷新验证码"/></td>
                                <td>看不清？<a href="javascript:loadimage();">换一张</a>
                                </td>
                          	</tr>
                            <tr>
                            	<td style="height:68px" align="right"></td>
                            	
                                <td>
                                <input type="hidden" name="flag" value="${flag}">
                                <input type="submit" class="botn_gary" value="登 录" title="登 录" />
                                <span class="fPwd"><!-- <a href="#">忘记密码？</a> --></span></td>
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