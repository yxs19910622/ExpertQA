<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
$('#payGrid').omGrid({
    title : '付款记录列表',
    limit : 50,
    width : 750,
    heiht : 500,
    autoFit : true,
    colModel : [{header : "支付交易号码",name : "transactionNo", width : "130", align : "center",sort:'clientSide'},
                {header : "订单号",name : "orderMasterNo", width : "60", align : "center",sort:'clientSide'},
                {header : "明细号",name : "orderDetailNo", width : "60", align : "center",sort:'clientSide'},
                {header : "商品名称",name : "productName", width : "140", align : "center",sort:'clientSide'},
                {header : "购买数量",name : "orderAmount", width : "45", align : "center",sort:'clientSide'},
                {header : "商品单价",name : "actualPrice", width : "45", align : "center",sort:'clientSide'},
                {header : "单据总额",name : "totalPayMoney", width : "45", align : "center",sort:'clientSide'},
                {header : "客户邮箱",name : "email", width : "160", align : "center",sort:'clientSide'},
                {header : "用户名称",name : "username", width : "60", align : "center",sort:'clientSide'},
                {header : "支付时间",name : "createtime", width : "100", align : "center",sort:'clientSide'},
                {header : "支付方式",name : "paytype", width : "50", align : "center",sort:'clientSide'},
                {header : "银行名称",name : "paybank", width : "100", align : "center",sort:'clientSide'},
                {header : "省",name : "province", width : "100", align : "center",sort:'clientSide'},
                {header : "市",name : "prefecturelevelcity", width : "100", align : "center",sort:'clientSide'},
                {header : "区",name : "area", width : "100", align : "center",sort:'clientSide'},
                {header : "街道",name : "street", width : "100", align : "center",sort:'clientSide'},
                {header : "电话",name : "mobile", width : "100", align : "center",sort:'clientSide'},
                {header : "发票类型",name : "titletype", width : "100", align : "center",sort:'clientSide'},
                {header : "发票抬头",name : "invoicetitle", width : "100", align : "center",sort:'clientSide'}
                
                ],
    dataSource : 'setHome!ajxPayHistory.action',
});
});
</script>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="PayHistory" name="currOpt"/>
</jsp:include>
	<div class="wbgRight_user">
    <div class="lesson_tit">付款记录</div>
    <table id="payGrid"></table>
	</div>
</div>
</body>
</html>