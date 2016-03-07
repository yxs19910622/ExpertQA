<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="dangriz" style="height:auto;">
	<b>推荐专家</b>
	<dl>
    	<dt><a target="_blank" href="expert/<s:property value='labuser.userID'/>">
    	<img src="<%=request.getContextPath()%><s:property value='labuser.userPicture'/>"  width="86" height="100"/></a></dt>
		<dd><strong>专家</strong><br /><s:property value="labuser.aliasName"/></dd>
	</dl>
	<div class="clear"></div>
    <div class="dangriz_body">
                所属单位：<s:property value="labuser.company.companyName"/><br />
                擅长领域：<s:property value="labuser.extend.simpleExpertArea"/><br />
                成功咨询案例： <s:property value="labuser.extend.simpleSuccessCase"/>
    </div>
</div>