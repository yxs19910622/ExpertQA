<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>
<script type="text/javascript">
function doSubmit(productNo,productName)
{
	var patn_email = /^(([_a-zA-Z0-9\-]+(\.[_a-zA-Z0-9\-]*)*@[a-zA-Z0-9\-]+([\.][a-zA-Z0-9\-]+)+))$/;
	var consigneeName = document.getElementById("consigneeName");
	var province = document.getElementById("province");
	var city = document.getElementById("city");
	var county = document.getElementById("county");
	var street = document.getElementById("street");
	var postCode = document.getElementById("postCode");
	var mobile = document.getElementById("mobile");
	var email = document.getElementById("email");
	if(consigneeName.value==null || consigneeName.value=='')
	{alert('请输入收货人姓名');consigneeName.focus();
	}else if(province.value==null || province.value=='')
	{alert('请选择省份');province.focus();
	}else if(city.value==null || city.value=='')
	{alert('请选择城市');city.focus();
	}else if(county.value==null || county.value=='')
	{alert('请选择区域');county.focus();
	}else if(street.value==null || street.value=='')
	{alert('请输入街道');street.focus();
	}else if(postCode.value==null || postCode.value=='')
	{alert('请输入邮编');postCode.focus();
	}else if(mobile.value==null || mobile.value=='')
	{alert('请输入手机号码');mobile.focus();
	}else if(email.value==null || email.value=='')
	{alert('请输入邮箱地址');email.focus();}
	else if(!patn_email.test(email.value))
	{alert('请输入正确的邮箱地址');email.focus();
	}else{
		freeOrderForm.action="freeOrderSave.action?info.tryProductNo="+productNo+"&info.tryProductName="+productName;
		freeOrderForm.submit();
	}
}
</script>
<form action="#" id="freeOrderForm" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-bottom: 1px dotted #cdcdcd;" class="teble_02">
	<tr>
		<td height="25"></td>
	</tr>
	<tr>
		<td height="30" align="left" valign="middle"><b>收款人信息</b></td>
	</tr>
	<tr>
		<td width="85" height="30" align="right" valign="middle"><span>*</span>收货人姓名：</td>
		<td width="5" valign="middle">&nbsp;</td>
		<td width="205" valign="middle"><input type="text" id="consigneeName" name="info.consigneeName" value="<s:property value='info.consigneeName'/>"/></td>
		<td valign="middle">&nbsp;</td>
	</tr>
	<tr>
		<td height="30" align="right" valign="middle"><span>*</span></td>
		<td valign="middle">&nbsp;</td>
		<td colspan="2" valign="middle">
		<select style="width:95px" onchange="setCity(this.value);setvaluep(this)" id="province">
        	<option>-请选择-</option></select> 省
        <select style="width:95px" onchange="setCounty(this.value);setvaluec(this);" id="city">
        	<option>-请选择-</option></select> 市 
        <select style="width:95px" onchange="setvalues(this);" id="county">
        	<option>-请选择-</option></select> 区
		</td>
	</tr>
	<input type="hidden" id="provinces" name="info.province" value="<s:property value='info.province'/>"/>
	<input type="hidden" id="citys" name="info.prefectureLevelCity" value="<s:property value='info.prefectureLevelCity'/>"/>
	<input type="hidden" id="sections" name="info.area" value="<s:property value='info.area'/>"/>
	<tr>
		<td height="30" align="right" valign="middle"><span>*</span>地 址：</td>
		<td valign="middle">&nbsp;</td>
		<td valign="middle"><input type="text" id="street" name="info.street" value="<s:property value='info.street'/>"/></td>
		<td valign="middle">&nbsp;</td>
	</tr>
	<tr>
		<td height="30" align="right" valign="middle"><span>*</span>邮政编码：</td>
		<td valign="middle">&nbsp;</td>
		<td valign="middle"><input type="text" id="postCode" name="info.postCode" value="<s:property value='info.postCode'/>"/></td>
		<td valign="middle">&nbsp;</td>
	</tr>
	<tr>
		<td height="30" align="right" valign="middle"><span>*</span>手机号码：</td>
		<td valign="middle">&nbsp;</td>
		<td valign="middle"><input type="text" id="mobile" name="info.mobile" value="<s:property value='info.mobile'/>"/></td>
		<td valign="middle">用于接收发货通知短信及送货前确认</td>
	</tr>
	<tr>
		<td height="30" align="right" valign="middle">固定电话：</td>
		<td valign="middle">&nbsp;</td>
		<td valign="middle"><input type="text" id="telephone" name="info.telephone" value="<s:property value='info.telephone'/>"/></td>
		<td valign="middle">用于送货前确认(格式：区号-电话号码 或 区号-电话号码-分机号)</td>
	</tr>
	<tr>
		<td height="30" align="right" valign="middle"><span>*</span>EMAIL：</td>
		<td valign="middle">&nbsp;</td>
		<td valign="middle"><input type="text" id="email" name="info.email" value="<s:property value='info.email'/>"/></td>
		<td valign="middle"></td>
	</tr>
	<tr>
		<td height="30" align="right" valign="middle">备注：</td>
		<td valign="middle">&nbsp;</td>
		<td valign="middle"><input type="text" id="notes" name="info.notes"/></td>
		<td valign="middle"></td>
	</tr>
	<tr>
		<td height="25">&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td valign="middle">&nbsp;</td>
	</tr>
</table>
<div class="table_top">
<b>选择四周免费试用的产品或服务</b>易中企业劳动法综合解决方案组件
</div>
<table width="100%" border="1" cellspacing="0" cellpadding="14" bordercolor="#c2922e" class="table_02">
                  <tr>
                  	<th height="36" align="left" bgcolor="#faa900"><em>产品标号</em></th><th align="left" bgcolor="#faa900"><em>产品名称</em></th>
                  	<th align="left" bgcolor="#faa900"><em>产品与服务/版本类型</em></th>
                  	<th align="left" bgcolor="#faa900"><em>产品与服务更新服务</em></th>
                  </tr>
                  <tr>
                    <td width="90" valign="middle">LDPUTZ</td>
                    <td width="224" valign="middle">
                    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_03">
                          <tr>
                            <td width="82" align="center"><img src="<%=contextPath%>/interface/resource/images/iq_22.jpg" alt="" /></td>
                            <td style="padding-top:3px; vertical-align:top;"><p><b>U问易顾问软件</b>专业解决方案</p>
							</td>
                          </tr>
                        </table>
                    </td>
                    <td width="220" valign="middle">
                    	<ul>
                        	<li><img src="<%=contextPath%>/interface/resource/images/q_01.png" alt="" />管理者劳动法实务手册/U盘版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_02.png" alt="" />HR专业工具库/U盘版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_03.png" alt="" />专家在线问答/互联网版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_04.png" alt="" />劳动法观察/电子版</li>
                        </ul>
                    </td>
                    <td valign="middle">
                   	  <div class="sqmfeitd">
                      <em>
                      	一季更新<br />
                    	一季更新<br />
                    	24小时更新<br />
                    	一周更新
                      </em>
                      <a href="#" class="sqmfei" onclick="javascript:doSubmit('LDPUTZ','U问易顾问软件专业版');">申请四周免费试用</a>
                      </div>
                    </td>
                  </tr>
                  
                  <tr>
                    <td width="90" valign="middle">LDSUTZ</td>
                    <td width="224" valign="middle">
                    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_03">
                          <tr>
                            <td width="82" align="center"><img src="<%=contextPath%>/interface/resource/images/iq_22.jpg" alt="" /></td>
                            <td style="padding-top:3px; vertical-align:top;"><p><b>U问易顾问软件</b>标准解决方案</p>
							</td>
                          </tr>
                        </table>
                    </td>
                    <td width="220" valign="middle">
                    	<ul>
                        	<li><img src="<%=contextPath%>/interface/resource/images/q_01.png" alt="" />管理者劳动法实务手册/U盘版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_02.png" alt="" />HR专业工具库/U盘版</li>
                        </ul>
                    </td>
                    <td valign="middle">
                   	  <div class="sqmfeitd">
                      <em>
                      	一季更新<br />
                    	无更新<br />
                      </em>
                      <a href="#" class="sqmfei" onclick="javascript:doSubmit('LDSUTZ','U问易顾问软件标准版');">申请四周免费试用</a>
                      </div>
                    </td>
                  </tr>
                  
                  <tr>
                    <td width="90" valign="middle">LDPBTZ</td>
                    <td valign="middle">
                    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_03">
                          <tr>
                            <td width="82" align="center"><img src="<%=contextPath%>/interface/resource/images/iq_23.jpg" alt="" /></td>
                            <td style="padding-top:3px; vertical-align:top;"><p><b>线下综合解决方案</b>专业解决方案</p></td>
                          </tr>
                        </table>
                    </td>
                    <td valign="middle">
                    	<ul>
                        	<li><img src="<%=contextPath%>/interface/resource/images/q_01.png" alt="" />管理者劳动法实务手册/线装版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_02.png" alt="" />HR专业工具库/DVD版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_03.png" alt="" />专家在线问答/互联网版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_04.png" alt="" />劳动法观察/电子版</li>
                        </ul>
                    </td>
                    <td valign="middle" class="sqmfeitd">
                   	  <div class="sqmfeitd">
                      <em>
                     	 无更新<br />
                        无更新<br />
                        24小时更新<br />
                        一周更新
                      </em>
                      <a href="#" onclick="javacript:doSubmit('LDPBTZ','线下综合解决方案专业版');" class="sqmfei">申请四周免费试用</a>
                      </div>
                    </td>
                  </tr>
                  
                  <tr>
                    <td width="90" valign="middle">LDSBTZ</td>
                    <td valign="middle">
                    	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_03">
                          <tr>
                            <td width="82" align="center"><img src="<%=contextPath%>/interface/resource/images/iq_23.jpg" alt="" /></td>
                            <td style="padding-top:3px; vertical-align:top;"><p><b>线下综合解决方案</b>标准解决方案</p></td>
                          </tr>
                        </table>
                    </td>
                    <td valign="middle">
                    	<ul>
                        	<li><img src="<%=contextPath%>/interface/resource/images/q_01.png" alt="" />管理者劳动法实务手册/线装版</li>
                            <li><img src="<%=contextPath%>/interface/resource/images/q_02.png" alt="" />HR专业工具库/DVD版</li>
                        </ul>
                    </td>
                    <td valign="middle" class="sqmfeitd">
                   	  <div class="sqmfeitd">
                      <em>
                     	 无更新<br />
                        无更新<br />
                      </em>
                      <a href="#" onclick="javacript:doSubmit('LDSBTZ','线下综合解决方案标准版');" class="sqmfei">申请四周免费试用</a>
                      </div>
                    </td>
                  </tr>
                </table>
</form>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/address.js"></script>
<script type="text/javascript">
var provinces = document.getElementById('provinces').value;
var citys = document.getElementById('citys').value;
var sections = document.getElementById('sections').value;
fillShowCity(provinces);//回显调用
setShowCity(provinceCodes,citys);
setShowCounty(cityCodes,sections);
function setvaluep(obj){
	document.getElementById("provinces").value=obj.options[obj.selectedIndex].text;
}
function setvaluec(obj){
	document.getElementById("citys").value=obj.options[obj.selectedIndex].text;
}
function setvalues(obj){
	document.getElementById("sections").value=obj.options[obj.selectedIndex].text;
}
</script>