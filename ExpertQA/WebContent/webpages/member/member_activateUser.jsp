<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<jsp:param value="ActivateUser" name="currOpt"/>
</jsp:include>
<script type="text/javascript">
$(document).ready(function() {
	$("#activateForm").validate({
        errorLabelContainer : "#errorMessages",
        rules : {activateCode:{required:true}},
        messages : {activateCode:{required : "请输入激活码！"}},
        submitHandler : function(){
            $("#activateForm").omAjaxSubmit({
                url :'activateUserSave.action',
                success:function(responseText,statusText, xhr, $form){
                	$('#errorMessages').html(responseText).show();
                }
            });
            return false;
          }
        });
});
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
<div class="wbgRight_user">
    <div class="lesson_tit">帐号激活</div>
    <form action="#" method="post" id="activateForm">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" class="Ltd" style="padding-top: 15px;">
        <tr>
          	<td width="20%" align="right"><font color="red">*</font>&nbsp;激活码：</td>
            <td width="45%"><input type="text" id="activateCode" name="activateCode" style="height: 25px;"/></td>
           	<td align="left"><input type="submit" class="botn_gary" value="激 活" title="激 活"/></td>
        </tr>
        <tr><td colspan="2" align="center"><div align="center" id="errorMessages"></div></td></tr>
	</table>
	</form>
    <div class="user_divPub">                
   	<div class="card_list">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<th width="5%">序号</th>
			<th width="20%">产品名称</th>
			<th width="20%">激活码</th>
			<th width="15%">服务开始日期</th>
			<th width="15%">服务结束日期</th>
		</tr>
		<s:if test="lstup!=null">
			<s:iterator value="lstup" status="up">
				<tr>
					<td style="border-left:none"><s:property value="#up.index+1"/></td>
					<td style="text-align: left;"><s:property value="productName"/>&nbsp;</td>
					<td style="text-align: left;"><s:property value='activeCode'/></td>
					<s:if test="serviceStartDate==null">
						<td colspan="2">激活码未使用</td>
					</s:if>
					<s:else>
						<td><s:date name="serviceStartDate" format="yyyy-MM-dd HH:mm"/></td>
						<td><s:date name="serviceEndDate" format="yyyy-MM-dd HH:mm"/></td>
					</s:else>
				</tr>
			</s:iterator>
		</s:if>
   </table>
   </div>
   </div>
</div>
</div>
</body>
</html>