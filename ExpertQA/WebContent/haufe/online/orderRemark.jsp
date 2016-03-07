<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String ctx = request.getContextPath();%>
<!--备注信息开始-->
<div id="part_remark">
	<div class="o_show" id='remarkInfoShowDiv' >
	<h1>订单备注&nbsp;<a href="javascript:void(0)" onclick="$('#remarkInfoEditDiv').show();$('#remarkInfoShowDiv').hide();">[修改]</a></h1>
		<div class="middle">
			<table style="width: 100%;">
			<tbody>
			<tr>
			<td style="text-align: left; padding-left: 20px;" id="orderRemarkInfo">暂无备注</td>
			</tr>
			</tbody>
			</table>
		</div>
	</div>
	<div class="o_write" id='remarkInfoEditDiv' style="display: none;">
		<h1>订单备注 <a onclick="$('#remarkInfoShowDiv').show();$('#remarkInfoEditDiv').hide();" href="javascript:void(0)">[关闭]</a> 
			<span class="f12 fw100">声明：备注中有关收货人信息、支付方式、配送方式、发票信息等购买要求一律以上面的选择为准，备注无效。</span>
		</h1>
		<div class="middle"> 
			<input type="text" maxlength="200" class="txt" style="width: 300px;" id="orderRemark" name="notes"><font color="#cccccc">限200个字</font>
		</div>
		<div>
			<input type="button" onclick="savePartRemark()" value="保存订单备注" class="btn">
		</div>
	</div>
</div>
<!--备注信息结束-->