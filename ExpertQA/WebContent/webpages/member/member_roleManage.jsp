<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<jsp:param value="roleManage" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
    <div class="lesson_tit">角色管理</div>
    	<div class="user_divPub">                
        	<div class="card_list">
            	<table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
					<th>序号</th>
					<th>角色名称</th>
					<th>角色描述</th>
					<th>状态</th>
					<th>管理</th>
                </tr>
                <s:if test="lstRoles.size()>0">
                	<s:iterator value="lstRoles" status="roles">
                	<tr>
						<td style="border-left:none"><s:property value="#roles.index+1"/></td>
						<td><s:property value="roleName"/></td>
						<td><s:property value="description"/></td>
                    	<td><s:property value="activeStatus==1?'有效':'无效'"/></td>
                    	<td>
                    		<a href="roleAdd" class="a1">[新增]</a> | 
							<a href="#" class="a1">[修改]</a>
						</td>
                	</tr>
                	</s:iterator>
                </s:if>
                <s:else>
                <tr>
					<td style="border-left:none" colspan="5" align="center">没有角色，点击<a href="roleAdd" class="a1">[新增]</a></td>
                </tr>
                </s:else>
            	</table>
        	</div>
    	</div>
	</div>
</div>
</body>
</html>