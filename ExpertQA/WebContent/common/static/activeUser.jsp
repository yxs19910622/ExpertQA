<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="yonghu_ph" >
	<b>活跃企1111业用户</b> 
	<ul id="activeUser">
		<s:if test="lstActiveUser.size>0">
			<s:iterator value="lstActiveUser" status="active">
				<s:if test="#active.index<=2">
				<li><span class="shuzi"><s:property value="#active.index+1"/></span><s:property value="aliasName"/></li>
				</s:if>
				<s:else>
				<li><span><s:property value="#active.index+1"/></span><s:property value="aliasName"/></li>
				</s:else>
			</s:iterator>
		</s:if>
	</ul>
</div>