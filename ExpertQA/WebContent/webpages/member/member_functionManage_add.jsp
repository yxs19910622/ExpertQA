<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="functionManage" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
    <div class="lesson_tit">功能管理</div>
    	<div class="user_divPub">                
        	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
        	<tr>
            	<td style="height:43px" width="20%" align="right">功能编码：</td>
                <td width="45%"><input type="text" /><font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
			<tr>
                <td style="height:43px" width="20%" align="right">功能名称：</td>
                <td width="45%"><input type="text" /><font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
			<tr>
                <td style="height:43px" width="20%" align="right">功能描述：</td>
                <td width="45%"><input type="text" /><font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
            <tr>
                <td style="height:43px" width="20%" align="right">功能地址：</td>
                <td width="45%"><input type="text" /><font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
            <tr>
                <td style="height:43px" width="20%" align="right">是否为功能组：</td>
                <td width="45%">
                	是<input type="radio" name="isGroup"/>|
                	否<input type="radio" name="isGroup" checked="checked"/>
                	<font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
            <tr>
                <td style="height:43px" width="20%" align="right">所属功能组：</td>
                <td width="45%">
                <select></select>
                <font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
			<tr>
			<td align="center" colspan="3"><input type="button" value="保存" style="width:80px; height:30px;"/></td>
			</tr>
		</table>
    	</div>
   </div>
</div>
</body>
</html>