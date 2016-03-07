<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<script type="text/javascript" src="<%=contextPath%>/interface/compontents/dtree/dtree.js"></script>
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="roleManage" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
    <div class="lesson_tit">角色管理</div>
    	<div class="user_divPub">
    		<form action="roleAdd.action" id="roleAddForm" method="post">
        	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
			<tr>
                <td style="height:43px" width="20%" align="right">角色名称：</td>
                <td width="45%"><input type="text" name="roles.roleName"/><font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
			<tr>
                <td style="height:43px" width="20%" align="right">角色描述：</td>
                <td width="45%"><input type="text" name="roles.description"/><font color="red">*</font></td>
                <td width="35%" class="w_wrong"></td>
            </tr>
            <tr>
                <td style="height:43px" width="20%" align="right">该角色拥有的权限：</td>
                <td width="45%"><div class="dtree" style="width:348px;"></div>
                
                <script type="text/javascript">
                d = new dTree('d','interface/compontents/dtree','roleAddForm');
				d.config.useCheckBox = true;
				d.add(0,-1,'');
				<s:iterator value="lstOperations">
					d.add('<s:property value="operationID"/>','<s:property value="operationGroup==null?\'0\':operationGroup"/>','<s:property value="operationName"/>');
				</s:iterator>
				document.write(d);
                </script>
                </td>
                <td width="35%" class="w_wrong"></td>
            </tr>
			<tr>
			<td align="center" colspan="3"><input type="button" value="保存" onclick="submitForm()" style="width:80px; height:30px;"/></td>
			</tr>
		</table>
		</form>
    	</div>
   </div>
</div>
<script type="text/javascript">	
function submitForm() {
	//var ids = "";
	var form = document.getElementById("roleAddForm");
	//for ( var i = 0; i < form.elements.length; i++) {
	//	var element = form.elements[i];
	//	if (element.name == "id" && element.type == 'checkbox') {
	//		if (element.checked == true) {
	//			ids = ids + element.value + ",";
	//		}
	//	}
	//}
	form.submit();
	//document.roleAddForm.submit();
}
</script>
</body>
</html>