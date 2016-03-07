<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String ctx = request.getContextPath();
%>
<html>
<head>
	<title>订单信息确认</title>
	<SCRIPT src="<%=ctx%>/interface/javascript/jquery-1.5.2.min.js" type=text/javascript></SCRIPT>
	<script src="<%=ctx%>/interface/javascript/encrypt.js" type="text/javascript"></script>
	<script src="<%=ctx%>/interface/javascript/jquery.validate.js" type="text/javascript"></script>
	
	<script src="<%=ctx%>/interface/javascript/jquery.ui-1.8.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=ctx%>/interface/javascript/addresslinkage/addressShowList.js"></script>
	
	<SCRIPT src="<%=ctx%>/interface/javascript/ec_popups.js" type=text/javascript></SCRIPT>
	<link href="<%=ctx%>/interface/resource/css/jqueryui/jquery.ui-1.8.css" rel="stylesheet" type="text/css" />
	<link href="<%=ctx%>/interface/resource/css/jnotify/jquery.jnotify.css" rel="stylesheet" type="text/css" />
	
    <link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/common.css">
	<link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/shoppingcart.css">
	<link href="<%=ctx%>/interface/resource/css/order/orderInfo.css" rel="stylesheet" type="text/css">
	
	<style type="text/css">
	#orderForm label.error {
		margin-left: 10px;
		width: auto;
		display: inline;
		color:red;
	}

.wbgfont14{font-size:14px; font-weight:700;}
        .wbgfont14 p,span{font-size:12px; color:#666; font-weight:200; text-indent:2em; margin:0; padding:0; line-height:28px}
        .wbgPubDiv{border:4px solid #E6EFFA; margin-left:24px; overflow:hidden; padding:8px}
        .wbgPubDiv ul{padding:0; margin:0; list-style:none}
        .wbgPubDiv ul li{padding:0; margin:0; list-style:none; width:180px; float:left; height:48px; line-height:48px}
        .wbgPubDiv ul li img{ border:1px solid #cdcdcd; vertical-align:middle; margin-left:3px}
        .wbgimg{ height:68px}
        .wbgimg img{ vertical-align:middle}
        
        
        .popup_box{ width:800px; padding:15px; background:#fff; border:5px solid #444; font-family:Arial,'\5b8b\4f53',sans-serif; -moz-border-radius:10px; -webkit-border-radius:10px; border-radius:10px; -moz-box-shadow:0 0 5px #ccc; -webkit-box-shadow:0 0 5px #ccc; box-shadow:0 0 5px #ccc;}
        .popup_box .close{}
        .popup_box_head{ height:18px;}
        .popup_box_head .h_tl{ font:18px/1 Microsoft Yahei,'\5b8b\4f53',sans-serif; }
        .popup_box_head .close{font-style:normal; font:bold 14px/1 Tahoma,'\5b8b\4f53',sans-serif; color:#666; text-decoration:none;}
        .popup_box_head .close:hover{ color:#333;}
        .popup_box_content{ padding-top:10px; line-height:1.5; font-size:12px; color:#666;}
	</style>
</head>

<body>
<br />
<div class="Wrap_cart">
<div class="List_cart">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="31%"><img src="<%=ctx %>/interface/resource/images/shoppingcart/logo-buy.jpg" width="274" height="52" onclick="location.href='<%=ctx %>/'" style="cursor: pointer;"/></td>
      <td width="69%">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="warebuy2">
        <tr>
          <td width="116" align="center" class="warebuy"><a href="<%=ctx %>/myshoppingcart">1.核对订单信息</a></td>
          <td width="164" align="center">2.确认订单支付</td>
          <td width="158" align="center">3.支付操作完成</td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
</div>

<br />
<div class="Wrap_cart">

	<div class="List_cart marginb10">
	<h2><strong>填写核对订单信息</strong></h2>
	<div class="cart_table">
	    <!--收货人地址开始-->
	    <form id="orderForm" action="<%=ctx %>/saveonlinepay" method="post">
	    <input type="hidden" name="pIdPostagetype" id="pIdPostagetype">
	    <input type="hidden" name="token" id="token" value=""/>
	    <input type="hidden"  name="orderMasterNo" value="${orderMasterNo}"/>
		<input type="hidden"  name="orderDetailNo" value="${orderDetailNo}"/>
        <div id="part_consignee"> 
		    
			
            <div class="o_write" id="contactInfoEditDiv"  style="display: block;">
				<h1><span style="margin-right: 600px;">收货人信息&nbsp;
				</span></h1>
				<div class="middle">
				
					<div id="consignee_addr">
								<input type="hidden" name="customerContactId" value="1">
								<input type="hidden" id="shoppingCartParams" name="shoppingCartParams" value="${shoppingCartParams}">
								<table border="0" cellspacing="0" width="100%">
								<tbody>
									<tr>
										<td align="right" valign="middle" width="85">收货人姓名：</td>
										<td align="left" valign="middle">
											${contact.linkName}
										</td>
									</tr>
									<!--
									<tr>
										<td align="right" valign="middle"><font color="red">*</font>省　　份：</td>
										<td align="left" valign="middle">
											<span id="consignee_arae">
												<select style="width: 20%;margin-right:6px;height:20px;" name="province" id="province" onChange="setCity(this.value);setvaluep(this);postage_setPros();" ></select>
												<select style="width: 20%;margin-right:6px;height:20px;" id="city" onchange="setCounty(this.value);setvaluec(this);" name="city" ></select>
												<select style="width: 20%;margin-right:6px;height:20px;" onchange="setvalues(this);" id="county" name="county" name="county" ></select>
											</span>
										</td>
									</tr>
									  -->
									<tr>
										<td align="right" valign="middle">地　　址：</td>
										<td align="left" valign="middle">
											${contact.fullAddress}
										</td>
									</tr>
									<tr>
										<td align="right" valign="middle">邮政编码：</td>
										<td align="left" valign="middle">
											 ${contact.postCode}
										 </td>
									</tr>
									<tr>
										<td align="right" valign="middle">手机号码：</td>
										<td align="left" valign="middle">
											${contact.mobile}&nbsp;
										</td>
									</tr>
									<tr>
										<td align="right" valign="middle">固定电话：</td>
										<td align="left" valign="middle">
											${contact.telephone}&nbsp;&nbsp;&nbsp;<font color="#ff0000" ><b>用于送货前确认(想修改发货地址请联系客服：010-82251266)</b></font>
										</td>
									</tr>
								</tbody>
							</table>
						
					</div>
				</div>

			</div>
		</div>
        <!--收货人地址结束-->

		<!--支付方式及配送方式开始-->
		<div style="margin-right:10px;">
			<table width="100%" cellspacing="0" cellpadding="0" border="0" style="border-bottom: 2px dotted rgb(202, 202, 202);margin:10px;">
    	<tbody>
  			<tr> 
	       		<td height="35">
	       		<table width="100%" cellspacing="0" cellpadding="0" border="0" class="lb">

    <tbody><tr><td width="18%" valign="top" height="41" align="right" style="padding-top:5px;">选择支付方式<font color="red">(必填)</font>：</td>
        <td class="wbgfont14">
             <input type="radio" value="1000" name="RadioFather" id="RadioFather" checked=""> 网上银行（点击“选择其他”可以选择更多银行）
             <p>支持国内二十多家主流银行与机构的储值卡、信用卡的网上付款请选择银行，完成付款</p>
             <div style="height:96px" class="wbgPubDiv">
                <ul>
                    <li><input type="radio" onclick="cancelOther();" value="ICBCB2C" name="RadioSon" id="RadioSon1"><img alt="" src="<%=ctx %>/interface/resource/images/alipay/gs.jpg"></li>
                    <li><input type="radio" onclick="cancelOther();" value="CCB" name="RadioSon" id="RadioSon1"><img alt="" src="<%=ctx %>/interface/resource/images/alipay/js.jpg"></li>
                    <li><input type="radio" onclick="cancelOther();" value="ABC" name="RadioSon" id="RadioSon1"><img alt="" src="<%=ctx %>/interface/resource/images/alipay/ny.jpg"></li>
                    <li><input type="radio" onclick="cancelOther();" value="CMB" name="RadioSon" id="RadioSon1"><img alt="" src="<%=ctx %>/interface/resource/images/alipay/zs.jpg"></li>
                    <li><input type="radio" onclick="cancelOther();" value="COMM" name="RadioSon" id="RadioSon1"><img alt="" src="<%=ctx %>/interface/resource/images/alipay/jt.jpg"></li>
                    <li><a onclick="ecPopup.popupShow();cancelIt();" class="btn" href="javascript:;"><input type="radio" name="other"> </a><span style="" id="bankUnSelecte">选择其他</span>
                    <span style="display:none" id="bankSelecte">已选择:<img width="95px" alt="" src="<%=ctx %>/interface/resource/images/alipay/jt.jpg" id="bank"></span></li>
                </ul>
             </div>
             
<!-- 弹出层 -->
<div class="popup_box" style="display:none;" id="popup_box">
	<div class="popup_box_head">
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr><td width="50%"><span class="h_tl">请您选择要支付的银行</span></td><td width="50%" style="text-align:right"></td></tr>
        </table>
	</div>
	<div class="popup_box_content">
		<div class="wbgPubDiv" style="border:none">
            <ul>
                <li><input type="radio" id="RadioSon" name="RadioSon" value="ICBCB2C"/><img src="<%=ctx %>/interface/resource/images/alipay/gs.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon" value="CCB"/><img src="<%=ctx %>/interface/resource/images/alipay/js.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon" value="ABC"/><img src="<%=ctx %>/interface/resource/images/alipay/ny.jpg" alt="" /></li>                   
                <li><input type="radio" id="RadioSon" name="RadioSon" value="POSTGC"/><img src="<%=ctx %>/interface/resource/images/alipay/yz.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon" value="COMM"/><img src="<%=ctx %>/interface/resource/images/alipay/jt.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon" value="CMB"/><img src="<%=ctx %>/interface/resource/images/alipay/zs.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon" value="BOCB2C"/><img src="<%=ctx %>/interface/resource/images/alipay/zg.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="CEBBANK"/><img src="<%=ctx %>/interface/resource/images/alipay/gd.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="CITIC"/><img src="<%=ctx %>/interface/resource/images/alipay/zx.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="SDB"/><img src="<%=ctx %>/interface/resource/images/alipay/sz.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="SPDB"/><img src="<%=ctx %>/interface/resource/images/alipay/pf.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="CMBC"/><img src="<%=ctx %>/interface/resource/images/alipay/ms.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="CIB"/><img src="<%=ctx %>/interface/resource/images/alipay/xy.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="GDB"/><img src="<%=ctx %>/interface/resource/images/alipay/gf.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="SPABANK"/><img src="<%=ctx %>/interface/resource/images/alipay/pa.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="SHRCB"/><img src="<%=ctx %>/interface/resource/images/alipay/shns.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="SHBANK"/><img src="<%=ctx %>/interface/resource/images/alipay/sh.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="NBBANK"/><img src="<%=ctx %>/interface/resource/images/alipay/nb.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="HZCBB2C"/><img src="<%=ctx %>/interface/resource/images/alipay/hj.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="BJBANK"/><img src="<%=ctx %>/interface/resource/images/alipay/bj.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="BJRCB"/><img src="<%=ctx %>/interface/resource/images/alipay/bjnc.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="FDB"/><img src="<%=ctx %>/interface/resource/images/alipay/fz.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="WZCBB2C-DEBIT"/><img src="<%=ctx %>/interface/resource/images/alipay/wz.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="ICBCBTB"/><img src="<%=ctx %>/interface/resource/images/alipay/gsqy.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="CCBBTB"/><img src="<%=ctx %>/interface/resource/images/alipay/jsqy.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="ABCBTB"/><img src="<%=ctx %>/interface/resource/images/alipay/nyqy.jpg" alt="" /></li><!--
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="FDB"/><img src="<%=ctx %>/interface/resource/images/alipay/zsqy.jpg" alt="" /></li>
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="FDB"/><img src="<%=ctx %>/interface/resource/images/alipay/zgqy.jpg" alt="" /></li>-->
                <li><input type="radio" id="RadioSon" name="RadioSon"  value="SPDBB2B"/><img src="<%=ctx %>/interface/resource/images/alipay/pfqy.jpg" alt="" /></li>
              </ul>
        </div>
	</div>
        <div align="center"> 
             <span ><input style="background-image: url('<%=ctx %>/interface/resource/images/button2-bg.jpg');background-repeat: repeat-x;border: 1px solid #DE4A04;color: #FFFFFF;cursor: pointer;font-family: '宋体';font-size: 14px;font-weight: bold;height: 28px;line-height: 28px;margin: 0;padding: 0;text-align: center;width: 120px;"  type="button" value="确定" id="popup_close"  name="确定" /></span>
        </div>
</div>
<!--//弹出层-->
        </td>
    </tr>
    <tr><td width="18%" height="41" align="right"><font color="red"></font></td>
        <td class="wbgfont14 wbgimg">
             <input type="radio" value="100" name="RadioFather" id="RadioFather"> <img alt="" src="<%=ctx %>/interface/resource/images/alipay/kuaijie.jpg"><span>&nbsp;&nbsp;支付宝快捷支付：免开通，有卡就能付</span>
        </td>
    </tr>
    <tr><td width="18%" height="41" align="right"><font color="red"></font></td>
        <td class="wbgfont14 wbgimg">
             <input type="radio" value="100" name="RadioFather" id="RadioFather"> <img alt="" src="<%=ctx %>/interface/resource/images/alipay/zhifubao.jpg"><span>&nbsp;&nbsp;支付宝即时到账：支付宝余额支付专用通道</span>
        </td>
    </tr>
   </tbody>
   </table>
  </td>
 </tr>
</tbody>
</table>
		</div>
		<!--支付方式及配送方式结束-->


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
							   <td>
									 <div><span>商品明细</span></div>
							   </td>
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
									<input name="invoinceYesorno" onclick="invoince_setPttt(2);" checked="checked" value="2" type="radio">
									<label for="invoince_pttt1">否</label>
									<input name="invoinceYesorno" onclick="invoince_setPttt(3);" value="3" type="radio">
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
													<input name="invoincePttt" id="invoince_pttt4" onclick="invoince_setPttt(4);" checked="checked" value="4" type="radio">
													<label for="invoince_pttt4">个人 </label>
													<input name="invoincePttt" id="invoince_pttt5" onclick="invoince_setPttt(5);" value="5" type="radio">
													<label for="invoince_pttt5">单位</label>
												</td>
											</tr>
											 <tr class="txt_color_hui" id="invoice_unitNameTr">
												 <td align="left" valign="top" width="70">单位名称：</td>
												 <td align="left" valign="top">
													<input id="invoice_Unit_TitName" name="invoiceUnitTitName" class="txt" style="width: 260px;" maxlength="20" type="text" value="个人"><span class="red2">*</span><br><span class="gray">温馨提示：您填写的所有内容都将被系统自动打印到发票上，所以请千万别填写和发票抬头无关的信息。</span>
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
					<input type="text" maxlength="200" class="txt" style="width: 300px;" id="orderRemark" name="orderRemark"><font color="#cccccc">限200个字</font>
				</div>
				<div>
					<input type="button" onclick="savePartRemark()" value="保存订单备注" class="btn">
				</div>
			</div>
		</div>
         <!--备注信息结束-->
                
			<input type="hidden" name="radPostage" value="">
			<input type="hidden" name="areaPostage" value="">
			<input type="hidden" id="change_postage" name="change_postage" size="100"/>
			<input type="hidden" name="payType" id="payType" value="100">
            <input type="hidden" name="defaultbank" id="defaultbank" value="100">
			
        <!--信息开始-->
            <div id="CartMessagePanel" style="text-align: right; color: red; padding: 3px;"></div>
                <div id="part_cart">
					<div class="o_show">
					   <!-- 
					   <h1><span style="margin-right: 700px;">商品清单</span><a id="backToCartBtn" href="javascript:(void)" onclick="javascript:history.back(-1);" style="color: rgb(0, 112, 215);">返回修改购物车</a></h1>
					    -->
					   <div class="middle">
						   <table class="Table" cellpadding="0" cellspacing="0" width="100%">
								 <tbody>
									 <tr class="align_Center Thead">
										<td width="10%">商品编号</td>
										<td width="22%">商品名称</td>
										<td width="15%">市场价</td>
										<td width="15%">优惠价</td>
										<td width="30%">邮寄费用</td>
										<td width="8%">商品数量</td>
									 </tr>
									 <s:iterator value="list" var="lst">
										<tr class="align_Center">
										   <td style="padding: 12px 0px;"><s:property value="type"/></td>
										   <td><a target="_blank" href="<%=ctx%>/product/1"><s:property value="name"/></a></td>
										   <td><span style="background-image: url(<%=ctx %>/interface/resource/images/shoppingcart/price-strike.gif);height:16px;line-height:16px;background-repeat: x-repeat;">￥<s:property value="oldPrice"/></span></td>
										   <td><span style="color:#f00;font-family:verdana;font-weight:bold;">￥<s:property value="price"/></span></td>
										   <td class="align_Left" style="padding: 0px 0px 0px 110px;">
										   <label id="area_postage_1" for="invoince_pttt4">￥<s:property value="fare"/>/套</label>			
										   <br/>
										   </td>
										   <td><s:property value="number"/>套</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
					   </div>
					</div>
				</div>

                <!--Cart信息开始-->                 
				<div id="ware_info">
                    <div style="background: none repeat scroll 0% 0% rgb(255, 255, 255); font-size: 14px; font-weight: bold; padding-left: 2px;">结算信息</div>
						<h1></h1>
						<div class="middle">
						    <!--订单信息-->
							<ul id="part_info">
								<li class="info1" style="padding-bottom: 5px;">
								商品金额：${productPrice}元 + 运费：<span id="postageVal">${farePrice}</span>元 <br>
								</li>

								<li class="info2" style="width: 100%; overflow: hidden;">
									 <table style="width: 100%;" cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
											  <td style="text-align: right; font-size: 15px;"><b>应付总额：<font color="red">￥<span id="prepostPrice"><font color="red">${totalPrice}</font></span></font> 元</b></td>
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
				</form>
				</div>
				<div class="round"><div class="lround"></div><div class="rround"></div></div>
		</div>
</div>
</body>
<script type="text/javascript">
var prePrice='22';	//产品优惠价格总和
var contactIdforP=$("input[name=isDefault][value=2]").attr("id");	//取得联系方式ID切换邮费用
var pIdPostagetype="";

var ecPopup = new ec_popups("#popup_box", { withBg: true, closeBtn: "#popup_close", moveArea: "#popup_box" });
ecPopup.init();

function checkOther(){
	var flagBank = false;
	var src="";
	$(":radio[id='RadioSon']").each(function () {		
		if($(this).attr("checked")==true)
	    {
		    src= $(this).parent().children('img').attr('src');
			flagBank = true;//用来判断是否有选中项目
	    }else{}		
	});
	if(flagBank==true){
		
		 $("img[id='bank']").attr('src',src);
	     $("#bankSelecte").show();
		 $("#bankUnSelecte").hide();
	}
	else{
		 $("#bankUnSelecte").show();
		 $("#bankSelecte").hide();
	}
	}

	function cancelIt(){
		$(":radio[id='RadioSon1']").attr("checked",false);
	}

	function  cancelOther(){
		$(":radio[name='other']").attr("checked",false);
		$(":radio[id='RadioSon']").attr("checked",false);
		checkOther();
	}
$(function(){
	//点击弹出层确定后，改变其他的内容板块
$("#popup_close").click(function(){
	checkOther();

});
});

$(function(){
	$("input[name=isDefault][value=2]").attr("checked", true);
	//$("input[name=isDefault][value=3]").attr("checked", true);	//为选zhuang
	//$("#inType").text($("#invoice_Unit_TitName").val());	//设置首次加载发票部分展示
	$("#invoinceInfo").hide();
	
	$("#invoinceInfoF").text("不索要发票");	//设置首次加载发票部分展示
});

function invoince_setPttt(ptValue){
	switch(parseInt(ptValue)){
		case 1:
			$('#invoiceInfoEditDiv').show();
			$('#invoiceInfoShowDiv').hide();
			break;
		case 2:
			$('#invoiceDetailInfoShowDiv').hide();
			$("#invoice_Unit_TitName").val('');
			$("#invoinceInfoF").text("不索要发票");
			break;
		case 3:
			$('#invoiceDetailInfoShowDiv').show();
			$("#invoice_Unit_TitName").val('个人');
			$("#invoice_unitNameTr").hide();
			$("#invoinceInfoF").text("索要发票");
			break;
		case 4:
			$("#invoice_Unit_TitName").val('个人');
			$("#invoice_unitNameTr").hide();
			$("#invoice_titleTr").show();
			break;
		case 5:
			$("#invoice_Unit_TitName").val('');
			$("#invoice_unitNameTr").show();
			break;
		} 
}

function isInvoince(){
    var inyn="2";
	var els=$('input[name=invoince_yesorno]');
	for(var i=0;i<els.length;i++){
		if(els[i].value==3&& $(els[i]).attr("checked")){
			inyn="3";
		}
	}
	if(inyn=="2")
	{
		$("#invoinceInfo").hide();
		$("#invoinceInfoF").show();
		//$("#invoinceInfoF").text("不索要发票");	//设置首次加载发票部分展示
		$('#invoiceInfoEditDiv').hide();
		$('#invoiceInfoShowDiv').show();
	}
	else if(inyn=="3") 
	{
		if($("#invoice_Unit_TitName").val() == '')
		{
			alert("请输入单位名称！");
			return false;
		}
		else 
		{
			switch(parseInt($("input[name=invoince_pttt][@checked]").val())){
				case 3:
					$("#inType").text("个人");
					break;
				case 4:
					$("#inType").text($("#invoice_Unit_TitName").val());
			}
			$('#invoiceInfoEditDiv').hide();
			$('#invoiceInfoShowDiv').show();
			$("#invoinceInfo").show();
			$("#invoinceInfoF").hide();
		}
	}
}

function savePayTypeAndShipType(){
	$('#payInfoEditDiv').hide();
	$('#payInfoShowDiv').show();
}


//选择非网银直连，网银不选中，选中取消
$("input[type='radio'][name='RadioFather']").each(function()
	{
	 $(this).click(function(){
	 if( $(this).val()!="1000")
	 { 
		 $("input[type='radio'][name='RadioSon']").attr("checked",false);
		 $(":radio[name='other']").attr("checked",false);
	 }
	 });
	});

//选择网银直连莫银行，网银选中，非网银选中取消
$("input[type='radio'][name='RadioSon']").each(function()
	{
	 $(this).click(function(){
		 $("input[type='radio'][name='RadioFather'][value='1000']").attr("checked",true);
	 });
	});



function savePartRemark() {
	var remarkStr=$("#orderRemark").val()==""?"暂无备注":$("#orderRemark").val();
	$("#orderRemarkInfo").html(remarkStr);
	$('#remarkInfoShowDiv').show();
	$('#remarkInfoEditDiv').hide();
}

function doSaveShoppingCart() {
	if($("#orderForm").valid()){
		$(":radio[name='RadioFather']:checked").each(function () {		
			   $("#payType").val($(this).val());
			$(":radio[name='RadioSon']:checked").each(function () {
				   $("#defaultbank").val($(this).val());
				});
		//网银直连需要选择银行否则无法提交
			if($("#payType").val()=="1000"){
				var flag = false;
				$(":radio[name='RadioSon']").each(function () {		
					if($(this).attr("checked")==true)
				    {
					 flag = true;//用来判断是否有选中项目
				    }else{}		
				});
				if(flag==true){
					$("#pIdPostagetype").val($("#change_postage").val());
					$("#orderForm").submit();
				}
				else{
					alert("您选择了支付宝网银支付，请您继续选择要使用的银行");
				    return false;
					}
				}
		//不是网银直连直接提交
			else{
				$("#pIdPostagetype").val($("#change_postage").val());
				$("#orderForm").submit();
			}
			});	
		
	}
}
$("#orderForm").validate({
	rules: {
		payType: {
			required: true
		}
	},
	messages: {
		payType: {
			required: "请选择在线支付方式"
		}
	}
});

</script>
</html>
