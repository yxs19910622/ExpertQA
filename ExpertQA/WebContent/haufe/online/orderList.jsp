<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>
<div id="CartMessagePanel" style="text-align: right; color: red; padding: 3px;"></div>
<div id="part_cart">
<div class="o_show">
<div class="middle">
<table class="Table" cellpadding="0" cellspacing="0" width="100%" border="0">
	<tbody>
		<tr class="align_Center Thead">
			<td width="30%">商品名称</td>
			<td width="15%">市场价</td>
			<td width="30%">邮寄费用</td>
			<td width="15%">商品数量</td>
		</tr>
		<s:iterator value="lstod" status="od">
		<tr class="align_Center">
			<td>
			<span class="p-img"><a href="#none">
				<img src="<%=contextPath%>/haufe/images/product/<s:property value="productUrl"/>" style="width:50;height:50; overflow: hidden;"></a>
			</span>
			<div id="productName"><s:property value="productName"/></div></td>
			<td><span>￥<s:property value="productPrice"/></span></td>
			<td class="align_Center">￥0/套</td>
			<td><s:property value="orderAmount"/>&nbsp;套</td>
		</tr>
		</s:iterator>
	</tbody>
	</table>
</div>
</div>
</div>
