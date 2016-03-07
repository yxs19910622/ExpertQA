<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp" />
<jsp:include page="/common/common_web.jsp" />
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp" />
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="onlinePaymentRecords" name="currOpt" />
</jsp:include>
<div class="wbgRight_user">
<div class="lesson_tit">同步数据记录日志</div>
<div class="user_divPub">
<div class="card_list">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<th width="20%">订单编号</th>
		<th width="15%">处理状态</th>
		<th width="15%">处理信息</th>
		<th width="20%">创建时间</th>
		<th width="15%">交易号</th>
		<th width="15%">操作方式</th>
	</tr>
	<s:if test="lstOnlinepayment!=null">
		<s:iterator value="lstOnlinepayment" status="online">
			<tr>
				<td style="border-left: none"><s:property value="orderMasterno" /></td>
				<s:if test="exceptionInfo == null">
					<td style="text-align: left;">同步数据成功&nbsp;</td>
				</s:if>
				<s:else>
					<td style="text-align: left;">同步数据失败&nbsp;</td>
				</s:else>

				<s:if test="exceptionInfo == null">
					<td style="text-align: left;"
						title='<s:property value="submitData"/>'><s:property
						value="submitData.substring(0,10)" />...&nbsp;</td>
				</s:if>
				<s:else>
					<td style="text-align: left;" title=""><s:property
						value="exceptionInfo.substring(0,10)" />...&nbsp;</td>
				</s:else>
				<td style="text-align: left;"><s:property value="createTime" /></td>
				<td style="text-align: left;"><s:property value="transactionNo" /></td>
				<td>自动同步</td>
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