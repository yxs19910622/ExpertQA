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
<jsp:param value="attestAccount" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
	<div class="lesson_tit">帐号认证</div>
		<form action="attestAccountSave.action" method="post" id="attestForm">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" class="Ltd">
            	<tr>
               		<td width="20%" align="right">&nbsp;帐号状态：</td>
                    <td width="45%"><font color="red"><s:property value="attestStatus"/></font></td>
               </tr>
               <s:if test="sysuser.customerID==null || ''.equal(sysuser.customerID)">
               	<tr>
               		<td width="20%" align="right"><font color="red">*</font>&nbsp;客户号码：</td>
                    <td width="45%">
                    <input type="text" name="customerId"/>
                    </td>
                    <tr>
              		<td align="right"><input name="online" type="hidden" value="${online}"/></td>
              		<td><input type="submit" class="botn_gary" value="保 存" title="保 存" /></td>
             	</tr>
               </s:if>
               <s:else>
               	<tr>
               		<td width="20%" align="right">&nbsp;客户号码：</td>
                    <td width="45%"><s:property value='sysuser.customerID'/></td>
               	</tr>
               </s:else>
          </table>
    	</form>
	</div>
</div>
</body>
</html>