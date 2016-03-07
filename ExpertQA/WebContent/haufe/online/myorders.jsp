<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=contextPath%>/haufe/css/haufe.css" rel="stylesheet" type="text/css"/>
<script src="<%=contextPath%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/haufe/js/script.js" type="text/javascript"></script>
<title>浩富-我的订单</title>
</head>
<body onload="totalMoney();">
<jsp:include page="/haufe/common/head.jsp"/>
<div class="content">
	<div class="content-head">我的订单</div>
    <div class="shopping clearfix">
    <jsp:include page="aside.jsp"/>
    	<div class="main right mycart">
        <p class="title-cart">我的订单</p>
        <form action="<%=contextPath%>/submitCart.action" method="post" id="cartForm">
            <table class="ctable">
				<th>订单编号</th>
                <th>订单总额</th>
                <th>优惠价</th>
                <th>订单日期</th>
                <th>付款状态</th>
                <th>操作</th>
			<s:iterator value="lstOrder" status="pro">
				<tr class="align_Center">
					<td width="15%"><s:property value="orderMasterNo"/></td>
					<td>￥<s:property value="productMoney"/></td>
					<td><strong class="red"><span class="price">￥</span><s:property value="actualMoney"/></strong></td>
					<td><s:property value="createTime"/></td>
					<s:if test='payStatus.equals("2")'>
					<td style="color: greed">已付款</td>
					</s:if>
					<s:else>
					<td style="color: red">未付款</td>
					</s:else>
					<s:if test='!payStatus.equals("2")'>
						<td><input type="button" class="btnSave" value="去付款" onclick="javascirpt:payment('<s:property value="orderMasterNo"/>');"/></td>
					</s:if>
				</tr>
				</s:iterator>
            </table>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
function payment(orderMasterNo){
	window.location.href='orderListPayment.action?orderMasterNo='+orderMasterNo;
};
</script>
<jsp:include page="/haufe/common/foot.jsp"/>
</body>
</html>