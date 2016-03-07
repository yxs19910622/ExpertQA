<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>
<div class="day_zhuanjia">
	<h2>推荐专家</h2>
	<dl class="day_dla">
		<dt>
			<s:if test="totalUser.company.logoPicture!=null">
				<img src="<%=contextPath%><s:property value='totalUser.company.logoPicture'/>"/>
			</s:if>
			<s:else>
				<img src="<%=contextPath%>/upload/pic/qiye.jpg" alt="" />		
			</s:else>
		</dt>
		<dd>
			<b>专家所属单位：</b>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="totalUser.company.companyName"/></p>
		</dd>
		<div class="clear"></div>
	</dl>
	<dl class="day_dlb">
		<dt>
			<img style="width:86px;height:100px;" width="86" height="100" src="<%=contextPath%><s:property value='totalUser.userPicture'/>" alt="" />
		</dt>
		<dd>
			<b><s:property value="totalUser.aliasName"/></b>
			<p>&nbsp;专家擅长领域：<s:property value="totalUser.extend.simpleExpertArea"/></p>
			<ul>
				<li>浩富推荐次数<span><s:property value="totalUser.report.recommendNumber"/></span></li>
				<li class="day_shu"></li>
				<li>回答总次数<span><s:property value="totalUser.report.answerNumber"/></span></li>
				<li class="day_shu"></li>
				<li>企业采纳为最佳答案<span><s:property value="totalUser.report.bestAnswerNumber"/></span></li>
				<li class="day_shu"></li>
				<li>网友赞同次数<span><s:property value="totalUser.report.approvalNumber"/></span></li>
			</ul>
		</dd>
		<div class="clear"></div>
	</dl>
	<div class="zhuanjia_about">
		<h4>专家简介：</h4>
		<s:property value="totalUser.extend.summary"/>
	</div>
</div>