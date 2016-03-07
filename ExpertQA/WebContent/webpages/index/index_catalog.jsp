<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/interface/resource/css/niutuku.css"/>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/app-js-combind.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/niutuku.js"></script>
<div id="main_nav">
		<!--这个div 是随屏幕滚动-->
		<div class="mulu_left" id="MainMenu">
			<b style="margin-top:8px">问答分类</b>
			<hr class = "hrs"/>
			<!--导航开始-->
			<div class="box">
				<DIV class=allsort>
					<DIV class=mc>
						<s:if test="lstTypeParent!=null">
							<s:iterator value="lstTypeParent" var="parent">
								<DIV>
								<SPAN><b><A href="javascript:(void);" onclick="getQaTypeId('<s:property value="qaTypeID"/>','<s:property value="qaTypeName"/>');"><s:property value="qaTypeName"/></A></b></SPAN>
								<s:if test="lstTypeChild!=null && #parent.hasChild==1">
									<DIV style="padding:0px 0 10px 20px;">
										<DIV>
										<DL>
										<DD>
										<s:iterator value="lstTypeChild" status="child">
											<s:if test="parentTypeID.equals(#parent.qaTypeID)">
												<a href="javascript:(void);" style="line-height:13pt;" onclick="getChildQaTypeId('<s:property value="qaTypeID"/>','<s:property value="#parent.qaTypeName"/>','<s:property value="qaTypeName"/>');"><s:property value="qaTypeName"/></a>&nbsp;
											</s:if>
										</s:iterator>
										</DD>
										</DL>
										</DIV>
									</DIV>
								</s:if>
								</DIV>
							</s:iterator>
						</s:if>
					</DIV>
				</DIV>
			</div>
			<!--导航end--> 
		</div>
		
	</div>
<!--屏幕滚动 end-->