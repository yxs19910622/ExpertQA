<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String ctx = request.getContextPath();%>
<!--Cart信息开始-->                 
<div id="ware_info">
	<div style="background: none repeat scroll 0% 0% rgb(255, 255, 255); font-size: 14px; font-weight: bold; padding-left: 2px;">结算信息</div>
	<h1></h1>
	<div class="middle">
	<!--订单信息-->
		<ul id="part_info">
			<li class="info2" style="width: 100%; overflow: hidden;">
				<table style="width: 100%;" cellpadding="0" cellspacing="0">
				<tbody>
				<tr>
					<span class="right">原始金额：￥${yuanjia}元</span><br>
					<span class="right"><strong>优惠：</strong><strong class="red">￥-${preferPrice}元</strong></span><br>
					<%-- <span class="right"><strong>优惠：</strong><strong class="red">￥0元</strong></span><br> --%>
					<span class="right">优惠券：<font color="red">￥-${coupon}</font>元</span><br>	
				  <td style="text-align: right; font-size: 15px;"><b>应付总额：<font color="red">￥<span id="prepostPrice"><s:property value="totalPrice"/></span></font> 元</b></td>
				</tr>
				</tbody>
				</table>
			</li>
		</ul>
    <!--订单信息结束-->
   </div>
</div>  

<!--提交-->
<div class="o_show submit"> 
	<div><span id="submitWaitInfo"></span></div>
	<div id="submit_error"></div>
	<div id="submit_btn">
	<span id="ccPanel"></span>
	<input onclick="doSaveShoppingCart();" style="margin-top: 2px; border: medium none; cursor: pointer; width: 95px; height: 37px; background: url(<%=ctx %>/interface/resource/images/shoppingcart/calculate.png) repeat scroll 0% 0% transparent;" type="button"> 
	</div>
</div>
<!--提交结束-->