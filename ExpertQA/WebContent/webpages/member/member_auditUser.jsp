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
<jsp:param value="auditUser" name="currOpt"/>
</jsp:include>
<div class="wbgRight_user">
	<div class="lesson_tit">审核用户</div>
    <div class="user_divPub">                
        <div class="card_list">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
					<th width="5%">序号</th>
                    <th width="15%">用户姓名</th>
                    <th width="30%">企业名称</th>
					<th width="15%">联系方式</th>
                    <th width="15%">注册时间</th>
					<th width="10%">管理</th>
                </tr>
                <s:if test="lstLabUser!=null">
                	<s:iterator value="lstLabUser" status="labuser">
                		<tr>
						<td style="border-left:none"><s:property value="#labuser.index+1"/></td>
                    	<td><s:property value="userName"/></td>
						<td style="text-align: left;"><s:property value="company.companyName"/></td>
						<td><s:property value="company.telephone"/></td>
                    	<td><s:date name="registerDate" format="yyyy-MM-dd HH:mm"/></td>
                    	<td><a href="auditUserSave.action?userId=<s:property value='userID'/>" class="a1">[通过]</a>
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