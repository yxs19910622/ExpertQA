<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String ctx = request.getContextPath();%>
<!--发票信息开始-->
<div id="part_invoice">
	<div class="o_show" id='invoiceInfoShowDiv' >
		<h1>发票信息&nbsp;<a href="javascript:void(0)" onclick="invoince_setPttt(1);">[修改]</a></h1>
		<div class="middle">						
			<table style="width: 100%;">
				<tbody id="invoinceInfoF"></tbody>
				<tbody id="invoinceInfo">
				<tr>
					<td style="text-align: right; width: 82px;">发票类型：</td>
					<td>普通发票</td>
				</tr>
				<tr>
					<td style="text-align: right;">发票抬头：</td>
					<td id="inType">个人 </td>
				</tr>
				<tr>
				   <td style="text-align: right;">发票内容：</td>
				   <td><div><span>商品明细</span></div></td>
				</tr>
				</tbody>
			</table>
			<table style="width: 100%;">
				<tbody>
				<tr>
					<td style="text-align: left; padding-left: 22px;" id="provinceInfo"></td>
				</tr>
				</tbody>
			</table>
		</div>
		<div></div>
	</div>
	<div class="o_write" id='invoiceInfoEditDiv' style="display: none;">
		<h1>发票信息  <a href="javascript:void(0)" onclick="$('#invoiceInfoShowDiv').show();$('#invoiceInfoEditDiv').hide();">[关闭]</a></h1>
		<div id="invoicePutTypePanel" class="middle" style="padding: 10px 0pt 10px 20px;">
			<table class="txt_12" style="" border="0" cellpadding="0" cellspacing="0" width="100%">
				<tbody id="invoice_titleTr" style="">
			    <tr>
					<td colspan="2" align="left" valign="top"><span style="margin-right: 8px;">是否开发票：</span>
						<input name="isNeedInvoice" onclick="invoince_setPttt(2);" checked="checked" value="2" type="radio">
						<label for="invoince_pttt1">否</label>
						<input name="isNeedInvoice" onclick="invoince_setPttt(3);" value="3" type="radio">
						<label for="invoince_pttt2">是</label>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left" valign="top">
						<div id="invoiceDetailInfoShowDiv"  style="display: none;">
						<table class="txt_12" style="" border="0" cellpadding="0" cellspacing="0" width="100%">
							<tbody id="invoice_titleTr" style="">
							<tr>
								<td  class="txt_color_hui" colspan="2">发票类型：普通发票</td>
							</tr>
							<tr>
								<td colspan="2" align="left" valign="top"><span style="margin-right: 8px;">发票抬头：</span>
									<input name="titleType" id="invoince_pttt4" onclick="invoince_setPttt(4);" checked="checked" value="4" type="radio">
									<label for="invoince_pttt4">个人 </label>
									<input name="titleType" id="invoince_pttt5" onclick="invoince_setPttt(5);" value="5" type="radio">
									<label for="invoince_pttt5">单位</label>
								</td>
							</tr>
							<tr class="txt_color_hui" id="invoice_unitNameTr">
								 <td align="left" valign="top" width="70">单位名称：</td>
								 <td align="left" valign="top">
									<input id="invoice_Unit_TitName" name="invoiceTitle" class="txt" style="width: 260px;" maxlength="20" type="text" value="个人">
									<span class="red2">*</span><br>
									<span class="gray">温馨提示：您填写的所有内容都将被系统自动打印到发票上，所以请千万别填写和发票抬头无关的信息。</span>
								 </td>
							</tr>
							<tr>
								<td class="txt_color_hui"  colspan="2">发票内容：商品明细 </td>
							</tr>
							</tbody>
						</table>
					</div>
					</tr>
					</tbody>
				</table>
			</div>
		<div>
			<input id="invoinceBtn" class="btn" value="保存发票信息" onclick="isInvoince();" type="button">
		</div>
	</div>
</div>
<!--发票信息结束-->