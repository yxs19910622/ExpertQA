<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = request.getContextPath();
%>
<html>
<head>
<title>在线支付帮助</title>
<style type="text/css">
<!--
.style1 {font-size: 14px}
.tablecss,.tablecss_a{margin-top:5px;}
.tablecss,.tablecss th,.tablecss td,.tablecss_a,.tablecss_a th,.tablecss_a td{border-collapse:collapse;border-spacing:0;font-size:14px;border:1px solid #aacded; line-height:150%}
.tablecss th,.tablecss_a th{ background:#deedf9}
.tablecss td{padding:4px}
.tablecss_a td{padding:5px}
.style2 {
	font-size: 18px;
	font-weight: bold;
}
.title1{
 background:#deedf9; border-collapse:collapse;border-spacing:0;font-size:14px;border:1px solid #aacded; line-height:130%; color:#4e7ea5; font-weight:bold}
-->
</style>
</head>
<body>
<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center bgColor=#ffffff 
border=0>
  <TBODY>
  <TR>
    <TD class=style2 align=middle height=80>在线支付使用帮助</TD></TR></TBODY></TABLE>
<TABLE class=tablecss cellSpacing=0 cellPadding=0 width="90%" align=center 
border=0>
  <TBODY>
  <TR>
    <TD class=title1 align=middle height=30>在线支付流程图</TD></TR>
  <TR>
    <TD align=middle><IMG height=376 src="<%=ctx%>/interface/resource/images/onlinepay/help0009.jpg" 
    width=915></TD>
  </TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>（一）选择支付方式并填写个人信息页面<SPAN style="COLOR: #ff0000"> 
      http://www.izhong.com/pay</SPAN></TH></TR>
  <TR>
    <TD width=265>
      <P>1. 选择支付方式<BR>2. 填写付款人信息<BR>3. 填写支付金额<BR>4. 
      付款备注中注明购买产品及其他要求<BR>5. 如需发票，请点击提示并填写发票信息<BR>6. 确认信息无误，请点击"确认付款"</P></TD>
    <TD width=816><IMG height=1076 src="<%=ctx%>/interface/resource/images/onlinepay/aa2.jpg" 
  width=858></TD>
  </TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>（二）进入支付宝页面</TH></TR>
  <TR>
    <TD width=265>
      <P>A. 用支付宝账户付款 <BR>B. 没有支付宝账户进行付款</P></TD>
    <TD width=816><IMG height=396 src="<%=ctx%>/interface/resource/images/onlinepay/help03.jpg" width=753> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>A.使用支付宝账户</TH></TR>
  <TR>
    <TD width=265>
      <P>正确填写支付宝账户及支付密码</P><BR><BR><BR><BR><BR><BR><BR><BR><BR>
      <P>核对金额，确认付款<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>付款成功</P></TD>
    <TD width=816><IMG height=311 src="<%=ctx%>/interface/resource/images/onlinepay/help04.jpg" 
      width=488><BR><IMG height=289 src="<%=ctx%>/interface/resource/images/onlinepay/help10.jpg" 
      width=427><BR><IMG height=222 src="<%=ctx%>/interface/resource/images/onlinepay/aa5.jpg" 
  width=715></TD>
  </TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>B.没有支付宝账户</TH></TR>
  <TR>
    <TD width=265>
      <P><BR><BR><BR><BR><BR><BR><BR><BR><BR>选择卡种 
      选择银行<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>登录所选择银行的网上银行</P></TD>
    <TD width=816><IMG height=316 src="<%=ctx%>/interface/resource/images/onlinepay/help05.jpg" 
      width=484><BR><IMG height=401 src="<%=ctx%>/interface/resource/images/onlinepay/help07.jpg" 
      width=753><BR><IMG height=300 src="<%=ctx%>/interface/resource/images/onlinepay/help08.jpg" 
  width=753></TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>进入银行页面</TH></TR>
  <TR>
    <TD width=265>
      <P>根据银行提示网上支付<BR>（示例为浦发银行）</P></TD>
    <TD width=816><IMG height=537 src="<%=ctx%>/interface/resource/images/onlinepay/help09.jpg" width=753> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>进入付款页面</TH></TR>
  <TR>
    <TD width=265></TD>
    <TD width=816><IMG height=334 src="<%=ctx%>/interface/resource/images/onlinepay/help4.gif" width=600> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>进入付款成功页面</TH></TR>
  <TR>
    <TD width=265>付款成功 </TD>
    <TD width=816><IMG height=270 src="<%=ctx%>/interface/resource/images/onlinepay/help13.jpg" width=533> 
  </TD></TR></TBODY></TABLE>
  <TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>（二）网银直连</TH>
  </TR>
  <TR>
    <TD width=265>选择银联在线支付<BR>填写付款人信息</TD>
    <TD width=816><IMG height=1076 src="<%=ctx%>/interface/resource/images/onlinepay/aa1.jpg" width=858>  </TD>
  </TR></TBODY></TABLE>
  <TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>进入银行页面</TH>
  </TR>
  <TR>
    <TD width=265>
      <P>根据银行提示网上支付<BR>（示例为招商银行）</P></TD>
    <TD width=816><IMG src="<%=ctx%>/interface/resource/images/onlinepay/aa6.jpg" alt="" 
  width=763 height=544><BR>
      <BR></TD>
  </TR></TBODY></TABLE>
  <TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>确认付款</TH>
  </TR>
  <TR>
    <TD width=265 valign="middle">
      <P>&nbsp;</P>
      
      <P>付款成功</P></TD>
    <TD width=816 valign="top"><BR>
      <BR>
      <IMG height=222 src="<%=ctx%>/interface/resource/images/onlinepay/aa5.jpg" 
  width=715></TD>
  </TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
</TABLE><TABLE class=tablecss width="90%" align=center>
  </TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>（三）银联在线支付</TH></TR>
  <TR>
    <TD width=265>选择银联在线支付<BR>填写付款人信息</TD>
    <TD width=816><IMG height=1076 src="<%=ctx%>/interface/resource/images/onlinepay/aa3.jpg" width=858>  </TD>
  </TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>选择支付银行页面</TH></TR>
  <TR>
    <TD width=265>选择支付银行<BR>（示例为建设银行）</TD>
    <TD width=816><IMG height=750 src="<%=ctx%>/interface/resource/images/onlinepay/help15.jpg" width=600> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>确认所选银行页面</TH></TR>
  <TR>
    <TD width=265>确认所选银行</TD>
    <TD width=816><IMG height=411 src="<%=ctx%>/interface/resource/images/onlinepay/help16.jpg" width=600> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>填写银行卡信息页面</TH></TR>
  <TR>
    <TD width=265>填写银行卡信息页面</TD>
    <TD width=816><IMG height=562 src="<%=ctx%>/interface/resource/images/onlinepay/help18.jpg" width=600> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>确认支付页面</TH></TR>
  <TR>
    <TD width=265>确认支付</TD>
    <TD width=816><IMG height=402 src="<%=ctx%>/interface/resource/images/onlinepay/help19.jpg" width=600> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>支付成功页面</TH></TR>
  <TR>
    <TD width=265>支付成功</TD>
    <TD width=816><IMG height=365 src="<%=ctx%>/interface/resource/images/onlinepay/help20.jpg" width=600> 
      <IMG height=392 src="<%=ctx%>/interface/resource/images/onlinepay/help21.jpg" width=650> 
</TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>无卡（认证）支付</TH></TR>
  <TR>
    <TD width=265>选择无网银专用通道</TD>
    <TD width=816><IMG height=1076 src="<%=ctx%>/interface/resource/images/onlinepay/aa4.jpg" width=858>  </TD>
  </TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>免费开通银联认证支付</TH></TR>
  <TR>
    <TD width=265>如果您是第一次使用您的银行卡进行认证支付，点击"免费开通银联认证支付"。例如使用信用卡支付的输入页面： </TD>
    <TD width=816><IMG height=249 src="<%=ctx%>/interface/resource/images/onlinepay/help24.jpg" width=506> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>开通认证支付</TH></TR>
  <TR>
    <TD 
      width=265>如果使用的是招商银行信用卡，您必须填写有效期。其他银行信用卡可以选择填写。填入您银行卡绑定的手机号、获取并填写短信验证码、校验码、阅读并同意服务开通协议，点击"开通"。 
    </TD>
    <TD width=816><IMG height=439 src="<%=ctx%>/interface/resource/images/onlinepay/help25.jpg" width=494> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>进入付款页面</TH></TR>
  <TR>
    <TD width=265>认证支付的支付流程如下：<BR>① 在商户选择银联在线支付<BR>② 
      在支付页面选择"认证支付"，选择您的银行卡类型（借记卡或信用卡）并根据页面输入信息要求输入银行卡号。<BR>③ 
      按页面提示，输入有效期、CVN2、短信验证码、校验码，点击"确定支付"。若页面显示的手机号码有误，可以点击"手机号变更"。 </TD>
    <TD width=816><IMG height=449 src="<%=ctx%>/interface/resource/images/onlinepay/help23.jpg" width=723> 
  </TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TH colSpan=2 height=30>进入付款成功页面</TH></TR>
  <TR>
    <TD width=265>支付成功 </TD>
    <TD width=816><IMG height=138 src="<%=ctx%>/interface/resource/images/onlinepay/help26.jpg" 
  width=280></TD></TR></TBODY></TABLE>
<TABLE class=tablecss width="90%" align=center>
  <TBODY>
  <TR>
    <TD style="COLOR: #ff0000" 
      width="90%">注意：无卡（认证）支付可在IE、Firefox8.0（不包含Firefox8.0）以下版本和Chrome浏览器下使用，需安装安全控件，安装方法请参见<A 
      href="http://www.izhong.com/webpage/onlinepay/securityControlsHelp.jsp" 
      target=_blank>如何安装安全控件？</A><BR>若有问题请联系易中在线客服：&nbsp;&nbsp;010-58856886 
  </TD></TR></TBODY></TABLE></BODY></HTML>
