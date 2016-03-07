<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String ctx = request.getContextPath();
%>
<html>
<head>
	<link rel="shortcut icon" href="<%=ctx%>/favicon.ico" />
	<script src="<%=ctx%>/interface/javascript/jquery.slideshow-1.0.js" type="text/javascript"></script>
	<script src="<%=ctx%>/interface/javascript/jquery.jnotify.js" type="text/javascript"></script>
	<script src="<%=ctx%>/interface/javascript/jquery.cookie.js" type="text/javascript"></script>
	<script src="<%=ctx%>/interface/javascript/jquery.form.js" type="text/javascript"></script>
	<script src="<%=ctx%>/interface/javascript/jquery.ui-1.8.js" type="text/javascript"></script>
	
	<SCRIPT src="<%=ctx%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
	<SCRIPT src="<%=ctx%>/interface/javascript/jquery.validate.js" type=text/javascript></SCRIPT>
	<SCRIPT src="<%=ctx%>/interface/javascript/ec_popups.js" type=text/javascript></SCRIPT>
	
	<link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/common.css">
	<link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/shoppingcart.css">
	  
<title>企业培训教程 在线支付</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
#payForm label.error {
		margin-left: 10px;
		width: auto;
		display: inline;
		color:red;
	}
	
	.button2 {
	  background-image: url("<%=ctx %>/interface/resource/images/button2-bg.jpg");
    background-repeat: repeat-x;
    border: 1px solid #DE4A04;
    color: #FFFFFF;
    cursor: pointer;
    font-family: "宋体";
    font-size: 14px;
    font-weight: bold;
    height: 28px;
    line-height: 28px;
    margin: 0;
    padding: 0;
    text-align: center;
    width: 120px;
	}
-->
</style><style>
.bg{ width:845px; height:1069px; background-image:url(<%=ctx %>/interface/resource/images/onlinepay/zf_bg.jpg); background-repeat:no-repeat; padding:0 15px 0 15px; margin:0 auto; text-align:center; margin-top:50px;}
.bg1{ width:845px; height:1142px; background-image:url(<%=ctx %>/interface/resource/images/onlinepay/zf_bg1.jpg); background-repeat:no-repeat; padding:0 15px 0 15px; margin:0 auto; text-align:center; margin-top:50px;}
.lb{  height:35px; font-size:12px; color:#000; padding-left:20px; text-align:left;}
.input1{ width:315px; height:22px; border:1px solid #afafaf; font-size:12px; color:#868686; line-height:22px;}
.input2{ width:60px; height:22px; border:1px solid #afafaf; font-size:12px; color:#868686; line-height:22px;}
.input3{ width:220px; height:22px; border:1px solid #afafaf; font-size:12px; color:#868686; line-height:22px;}

.textarea1{width:315px; height:50px; border:1px solid #afafaf; font-size:12px; color:#868686; line-height:22px;}
.tiyu{ font-size:12px; color:#e24100}
a.oo { color:#2457da; font-size:12px}
a:hover.oo { color:#2457da;font-size:12px; text-decoration:underline;}


//支付宝css
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
<script language="javascript" type="text/javascript"> 

    function SelectAll(obj) 
    { 
        var tables = obj.parentElement.parentElement.parentElement; 
        for(i=2;i<tables.rows.length;i++) 
        { 
            var items = tables.rows.cells[0].getElementsByTagName("input"); 
            if(obj.checked) 
            { 
                items[0].checked=true; 
            } 
            else 
            { 
                items[0].checked=false; 
            } 
        } 
    } 
    
    function ReSelect(obj) 
    { 
        var tables = obj.parentElement.parentElement.parentElement; 
        var selectAll=tables.rows[0].cells[0].getElementsByTagName("input"); 
        for(i=2;i<tables.rows.length;i++) 
        { 
            var items = tables.rows.cells[0].getElementsByTagName("input"); 
            if(items[0].checked==false) 
            { 
                selectAll[0].checked=false; 
                return; 
            } 
        } 
        selectAll[0].checked=true; 
    } 
    var currentColor; 
    function Light(obj,eventName) 
    { 
        if(eventName=="onMouseOver") 
        { 
            currentColor=obj.style.backgroundColor; 
            obj.style.backgroundColor="#fff9e5"; 
            obj.style.cursor="hand"; 
        } 
        else 
        { 
            obj.style.backgroundColor=currentColor; 
        } 
    } 

</script> 

</head>
<body>

<form id="payForm" name="payForm" action="<%=ctx %>/saveonlinepay" method="post">
<input type="hidden" name="visitorIp" id="visitorIp" value="<%=request.getRemoteAddr() %>">
<input type="hidden" name="isInvoiceHidden" value="0">
<input type="hidden" name="payType" id="payType" value="100">
<input type="hidden" name="defaultbank" id="defaultbank" value="100">

<table id="topTable" class="bg" width="845"  valign="top" border="0" cellpadding="0" cellspacing="0">
 
  <tbody>
  
  	<tr>
    	<td valign="top" height="50">&nbsp;</td>
  	</tr>
  	<tr>
  	
    	<td valign="top">
    	<table style="border-bottom: 1px dotted rgb(202, 202, 202);" width="100%" border="0" cellpadding="0" cellspacing="0">
    	<tbody>
  			<tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
	       		<td height="35">
	       		<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">

    <tr><td width="18%" align="right" height="41" valign="top" style="padding-top:5px;" >选择支付方式<font color="red">(必填)</font>：</td>
        <td class="wbgfont14">
             <input type="radio" checked id="RadioFather" name="RadioFather" value="1000"/> 网上银行（点击“选择其他”可以选择更多银行）
             <p>支持国内二十多家主流银行与机构的储值卡、信用卡的网上付款请选择银行，完成付款</p>
             <div class="wbgPubDiv" style="height:96px">
                <ul>
                    <li><input type="radio" id="RadioSon1" name="RadioSon" value="ICBCB2C" onclick="cancelOther();"/><img src="<%=ctx %>/interface/resource/images/alipay/gs.jpg" alt="" /></li>
                    <li><input type="radio" id="RadioSon1" name="RadioSon" value="CCB" onclick="cancelOther();"/><img src="<%=ctx %>/interface/resource/images/alipay/js.jpg" alt="" /></li>
                    <li><input type="radio" id="RadioSon1" name="RadioSon" value="ABC" onclick="cancelOther();"/><img src="<%=ctx %>/interface/resource/images/alipay/ny.jpg" alt="" /></li>
                    <li><input type="radio" id="RadioSon1" name="RadioSon" value="CMB" onclick="cancelOther();"/><img src="<%=ctx %>/interface/resource/images/alipay/zs.jpg" alt="" /></li>
                    <li><input type="radio" id="RadioSon1" name="RadioSon" value="COMM" onclick="cancelOther();"/><img src="<%=ctx %>/interface/resource/images/alipay/jt.jpg" alt="" /></li>
                    <li><a href="javascript:;" class="btn" onclick = "ecPopup.popupShow();cancelIt();"><input type="radio" name="other" /> </a><span id="bankUnSelecte" style="">选择其他</span>
                    <span id="bankSelecte" style="display:none">已选择:<img id="bank"  width="95px" src="<%=ctx %>/interface/resource/images/alipay/jt.jpg" alt="" /></span></li>
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
             <span ><input class="button2" type="button" value="确定" id="popup_close"  name="确定" /></span>
        </div>
</div>
<!--//弹出层-->
        </td>
    </tr>

    <tr><td width="18%" align="right" height="41"><font color="red"></font></td>
        <td class="wbgfont14 wbgimg">
             <input type="radio" id="RadioFather" name="RadioFather" value="101"/> <img src="<%=ctx %>/interface/resource/images/alipay/kuaijie.jpg" alt="" /><span>&nbsp;&nbsp;支付宝快捷支付：免开通，有卡就能付</span>
        </td>
    </tr>

    <tr><td width="18%" align="right" height="41"><font color="red"></font></td>
        <td class="wbgfont14 wbgimg">
             <input type="radio" id="RadioFather" name="RadioFather" value="100"/> <img src="<%=ctx %>/interface/resource/images/alipay/zhifubao.jpg" alt="" /><span>&nbsp;&nbsp;支付宝即时到账：支付宝余额支付专用通道</span>
        </td>
    </tr>

				</table>
		       </td>
		     </tr>
    		<tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        		<td height="35">
        		<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
			  		<tbody>
				  		<tr>
				    		<td width="18%" align="right" height="35">姓名<font color="red">(必填)</font>：</td>
						    <td width="82%" align="left"><input id="name" name="name" maxlength="20" class="input1" type="text"></td>
				    	</tr>
					</tbody>
				</table>
       </td>
     </tr>
     <tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        <td height="35">
	        <table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
	  			<tbody>
	  				<tr>
					    <td width="18%" align="right" height="35">客户号：</td>
					    <td width="55%"><input name="customerCode" maxlength="10" class="input1" type="text" value="${userId}" readonly></td>
					    <td width="27%"></td>
				    </tr>
				</tbody>
			</table>
        </td>
      </tr>
      <tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        <td height="35">
	        <table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
	 			<tbody>
	 				<tr>
					    <td width="18%" align="right" height="35">职位：</td>
					    <td width="82%"><input name="position" maxlength="100" class="input1" type="text"></td>
					</tr>
				</tbody>
			</table>
        </td>
      </tr>
      <tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        <td height="35">
        	<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
  				<tbody>
  					<tr>
					    <td width="18%" align="right" height="35">座机<font color="red">(必填)</font>：</td>
					    <td width="82%"><input class="input1" name="phone" id="phone" maxlength="19" type="text"></td>
					</tr>
					<tr>
  						 <td width="18%" align="right" height="20">&nbsp;</td>
					    <td width="82%" height="20">电话格式010-58758888-879     或    010-58758888</td>
					</tr>
				</tbody>
			</table>
        </td>
      </tr>
      <tr style="" onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        <td height="35">
        	<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
  				<tbody>
  					<tr>
					    <td width="18%" align="right" height="35">传真：</td>
					    <td width="82%"><input class="input1" name="faxes" id="faxes" maxlength="19" type="text"></td>
					</tr>
				</tbody>
			</table>
        </td>
      </tr>
      <tr style="" onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        <td height="35">
        	<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
  				<tbody>
  					<tr>
					    <td width="18%" align="right" height="35">手机<font color="red">(必填)</font>：</td>
					    <td width="57%"><input name="mobilePhone" id="mobilePhone" class="input1" maxlength="11" ></td>
					    <td class="tiyu" width="25%"><span></span></td>
					</tr>
				</tbody>
			</table>
        </td>
      </tr>
      <tr style="" onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        <td height="35">
        	<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
				<tbody>
				  	<tr>
					    <td width="18%" align="right" height="35">单位名称<font color="red">(必填)</font>：</td>
					    <td width="82%" align="left"><input class="input1" name="companyName" id="companyName" size="20" maxlength="38" type="text"></td>
				    </tr>
				</tbody>
			</table>
        </td>
      </tr>
      <tr style="" onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        <td height="35">
        	<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
  				<tbody>
  					<tr>
					    <td width="18%" align="right" height="35">地址：</td>
					    <td width="82%"><input class="input1" name="streetAddress" id="streetAddress" maxlength="1000" type="text"></td>
					</tr>
				</tbody>
			</table>
        </td>
      </tr>
    </tbody>
</table>
<div style="text-align: right; padding-top: 5px;">
 	<a href="javascript:(void);" onclick="$('#topTable').attr('class','bg1');$('#isInvoice').show();$('input[name=invoince_pttt][value=4]').attr('checked',true);$('#invoice_Unit_TitName').val('个人');$('#invoice_Unit_TitName').attr('disabled','disabled');$('#isInvoiceHidden').val('1');" class="oo">如果您需要发票请点击这里</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
    	<table id="isInvoice" style="display: none; border-bottom: 1px dotted rgb(202, 202,202);" id="iDBody1" width="100%" border="0" cellpadding="0" cellspacing="0">
      		<tbody>
      			<tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
        			<td height="35">
        				<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
				          	<tbody>
				          		<tr>
				          			<td width="18%" align="right" height="25">发票类型：</td>
		          					<td width="82%"><input name="invoiceTitleType" id="invoince_pttt4" onclick="invoince_setPttt(1)" checked="checked" value="1" type="radio">个人
									&nbsp;&nbsp;&nbsp;&nbsp;<input name="invoiceTitleType" id="invoince_pttt5" onclick="invoince_setPttt(2)" value="2" type="radio">单位</td>
									
				          		</tr>
					          	<tr>
						            <td width="18%" align="right" height="35">发票抬头：</td>
						            <td width="82%"><input id="invoice_Unit_TitName" name="invoiceTitle" size="50" maxlength="50" class="input1" type="text"></td>
						           
					          	</tr>
				        	</tbody>
		        		</table>
			        </td>
			    </tr>
		    </tbody>
		</table>
         
         <table style="border-bottom: 1px dotted rgb(202, 202, 202);" width="100%" border="0" cellpadding="0" cellspacing="0">
      		<tbody>
      			<tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
			        <td height="35">
				        <table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
	  						<tbody>
								<tr>
									<td width="12%" align="right" height="20">你购买的商品：</td>
								    <td colspan="3" align="left" height="20">
								      <div id="part_cart">
								      <table class="Table">
								        <tr class="align_Center Thead"><td width="40%">名称</td><td width="20%" >价格</td><td width="20%">套数</td></tr>
								        <s:iterator value="list" var="lst">
								           <tr class="align_Center">
								              <td><s:property value="name"/></td><td><s:property value="price"/></td><td><s:property value="number"/>套</td>
								           </tr>
								        </s:iterator>
								      </table>
								      </div>
								    </td>
								</tr>
								<tr>
								    <td width="18%" align="right" height="35">支付总金额：</td>
								    <td width="82%"><font style="font-size:15px;color:red;">￥${totalPrice}<font></td>
								</tr>
							</tbody>
						</table>
		    	    </td>
      			</tr>
     			<tr onmouseover="Light(this,'onMouseOver')" onmouseout="Light(this,'onMouseOut')"> 
			        <td height="35">
			        	<table class="lb" width="100%" border="0" cellpadding="0" cellspacing="0">
			  				<tbody>
			  					<tr>
								    <td width="18%" align="right" height="35">付款备注<font color="red">(必填)</font>：</td>
								    <td width="82%"><textarea name="remark" cols="45" rows="5" class="textarea1" id="pro3"></textarea></td>
							    </tr>
							    <tr>
							    	<td width="12%" align="right" height="20">&nbsp;</td>
								    <td colspan="3" align="left" height="20">请在付款备注中注明购买的产品或其他需求</td>
							    </tr>
							</tbody>
						</table>
        			</td>
      			</tr>
		    </tbody>
		</table>
		<div style="text-align: right; padding-top: 0px;">
			<a href="<%=ctx %>/onlinepayhelp" target="_blank">
				<font color="#990000">在线支付帮助&gt;&gt;</font>
			</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	        <table width="100%" border="0" cellpadding="0" cellspacing="0" height="36">
	           <tbody>
					<tr>
		             <td><a href="#"><img src="<%=ctx %>/interface/resource/images/onlinepay/qrgm.jpg" 
		             onclick="submitform();" width="127" border="0" height="36"></a></td>
		           	</tr>
	         	</tbody>
	         </table>
         </td>
	</tr>
</tbody>
</table>
</form>
<script type="text/javascript" src="<%=ctx%>/interface/javascript/ec_popups.js"></script>
<script type="text/javascript">

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
function invoince_setPttt(ptValue){
	switch(parseInt(ptValue)){
		case 1:
			$("#invoice_Unit_TitName").val('个人');
			$("#invoice_Unit_TitName").attr("disabled","disabled");
			break;
		case 2:
			$("#invoice_Unit_TitName").val('');
			$("#invoice_Unit_TitName").removeAttr("disabled");
			break;
		} 
}
function submitform()
{
	if($("#payForm").valid()){
	
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
					 $("#payForm").submit();
				}
				else{
					alert("您选择了支付宝网银支付，请您继续选择要使用的银行");
				    return false;
					}
				}
		//不是网银直连直接提交
			else{
				 $("#payForm").submit();
			}
			});	
	}
}

$.validator.addMethod("isMobile", function(value, element) {      
	var length = value.length;  
	var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;  
	return this.optional(element) || (length == 11 && mobile.test(value));      
}, "请正确填写您的手机号码");

//电话号码验证      
jQuery.validator.addMethod("isPhone", function(value, element) {      
var tel = /^\d{3,4}-?\d{6,9}-?\d{1,}$/;    //电话号码格式010-12345678-3  
return this.optional(element) || (tel.test(value));
}, "请正确填写您的电话号码");

//传真验证      
jQuery.validator.addMethod("isFax", function(value, element) {      
var tel = /^\d{3,4}-?\d{6,9}-?\d{1,}$/;    //传真号码格式010-12345678-3  
return this.optional(element) || (tel.test(value));
}, "请正确填写您的传真号码");

//用户名字符验证
$.validator.addMethod("userName", function(value, element) {      
return this.optional(element) || /^[^u4E00-u9FA5]{2,5}$/.test(value);      
}, "请正确填写中文全名"); 

// 字符验证      
jQuery.validator.addMethod("stringCheck", function(value, element) {      
return this.optional(element) || /^[a-zA-Z0-9_\u4e00-\u9fa5\s]+$/.test(value);      
}, "只能包括中文字、英文字母、数字、空格和下划线"); 

$(function(){
	//点击弹出层确定后，改变其他的内容板块
$("#popup_close").click(function(){
	checkOther();

});
	
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

	
	$("#payForm").validate({
		rules: {
			payType: {
				required: true
			},
			name: {
				required: true,
				userName: true,
				maxlength: 20
			},
			customerCode: {
				digits: true,
				maxlength: 10
			},
			position: {
				stringCheck: true,
				maxlength: 100
			},
			phone: {
				required: true,
				isPhone: true
			},
			faxes: {
				isFax: true
			},
			mobilePhone: {
				required: true,
				isMobile: true
			},
			companyName: {
				required: true,
				stringCheck: true
			},
			streetAddress: {
				stringCheck: true
			},
			remark: {
				required: true,
				stringCheck: true
			}
		},
		messages: {
			payType: {
				required: "请选择在线支付方式"
			},
			name: {
				required: "请输入用户姓名",
				maxlength: "用户姓名长度不能大于20位字符"
			},
			customerCode: {
				digits: "客户号只能是数字",
				maxlength: "客户号长度不能大于10位数字"
			},
			position: {
				maxlength: "职位长度不能大于100字符"
			},
			phone: {
				required: "请输入电话号码"
			},
			mobilePhone: {
				required: "请输入手机号码"
			},
			companyName: {
				required: "请输入公司名称"
			},
			remark: {
				required: "请输入支付备注（此次支付原因）"
			}
		}
	});

});
</script>
<div style="position: absolute; display: none; z-index: 9999;" id="livemargins_control"><img src="<%=ctx %>/interface/resource/images/onlinepay/monitor-background-horizontal.png" 
style="position: absolute; left: -77px; top: -5px;" width="77" height="5">
<img src="<%=ctx %>/interface/resource/images/onlinepay/monitor-background-vertical.png" 
style="position: absolute; left: 0pt; top: -5px;">
<img id="monitor-play-button" src="<%=ctx %>/interface/resource/images/onlinepay/monitor-play-button.png"
 onmouseover="this.style.opacity=1" onmouseout="this.style.opacity=0.5" 
style="position: absolute; left: 1px; top: 0pt; opacity: 0.5; cursor: pointer;"></div></body></html>