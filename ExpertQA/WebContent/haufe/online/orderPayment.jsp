<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String ctx = request.getContextPath();%>
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