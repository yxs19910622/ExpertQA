<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/interface/resource/css/niutuku.css"/>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/app-js-combind.js"></script>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/niutuku.js"></script>

			<!--导航开始-->
			<div class="box">
				<DIV class=allsort>
					<DIV class=mc>
						<s:if test="lstTypeParent!=null">
							<s:iterator value="lstTypeParent" var="parent">
								<DIV class="item">
								<SPAN><H3><A href="#"  onclick="getQaTypeId('<s:property value="qaTypeID"/>','<s:property value="qaTypeName"/>');"><s:property value="qaTypeName"/></A></H3></SPAN>
								<s:if test="lstTypeChild!=null && #parent.hasChild==1">
									<DIV class=i-mc>
										<DIV class=subitem>
										<DL class=fore>
										<DD>
										<s:iterator value="lstTypeChild" status="child">
											<s:if test="parentTypeID.equals(#parent.qaTypeID)">
												<EM><A href="#" onclick="getQaTypeId('<s:property value="qaTypeID"/>','<s:property value="qaTypeName"/>');"><s:property value="qaTypeName"/></A></EM><br>
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
