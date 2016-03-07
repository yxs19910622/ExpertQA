<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String ctx = request.getContextPath();
  String contextPath = request.getContextPath();
%>
<style type="text/css">
 body {
 margin: 0px auto;padding:0
} 
/* #div1 {
 display: none;
 position: absolute;
 z-index: 1000;
 height: 100%;
 width: 100%;
 background: #000000;
 filter:Alpha(opacity=30);
} */
#div2 {
 display:none;
 position: absolute;
 height: 50%;
 width: 100%;
 padding-top: 20%;
 z-index: 100;
 left: 100px;
 top: 500px;
}

.input {
   height: 16px;
   width: 80px;
   readOnly:true;
   border:0px;
   background-color: transparent;
}
</style>

<!--收货人地址开始-->
<div id="part_consignee"> 
	<div class="o_write" id="contactInfoEditDiv"  style="display: block;">
	<h1><span style="margin-right: 600px;">收货人信息&nbsp;</span></h1><%-- <a onclick="openme();" color="blue">[修改信息]</a></span></h1> --%>
	<div class="middle">
	<div id="consignee_addr">
		<table border="0" cellspacing="0" width="100%">
			<tbody>
			<tr>
				<td align="right" valign="middle" width="85" >收货人姓名：</td>
				<td align="left" valign="middle" ><input class="input" id="name11111" style="width: 100px;" value="<s:property value="sysuser.userName"/>" /></td>
			</tr>
			<tr>
				<td align="right" valign="middle">地　　址：</td>
				<td align="left" valign="middle">
				<input class="input" id="province11111" value="<s:property value="labuser.company.province"/>" />
				<input class="input" id="prefecturelevelCity11111" value="<s:property value="labuser.company.prefecturelevelCity"/>" />
				<input class="input" id="area11111" value="<s:property value="labuser.company.area"/>"/>
				<input class="input" id="street11111" value="<s:property value="labuser.company.street"/>" style="width: 300px;"/>
				</td>
			</tr>
			<tr>
				<td align="right" valign="middle">电子邮箱：</td>
				<td align="left" valign="middle"><input class="input" id="email11111"  style="width: 300px;" value="<s:property value="sysuser.email"/>"/>
				</td>
			</tr>
			<tr>
				<td align="right" valign="middle">联系电话：</td>
				<td align="left" valign="middle">
				<input class="input" id="mobile11111" value="<s:property value="sysuser.mobile"/>" style="width: 90px;"/>
					&nbsp;
					<s:property value="labuser.company.telephone"/>&nbsp;&nbsp;&nbsp;
					<font color="#ff0000" ><b>用于送货前确认<!-- (想修改发货地址请联系客服：010-82251266) --></b></font>
				</td>
			</tr>
			</tbody>
		</table>
		</div>
		</div>
	</div>
</div>

<div id="div1"></div>
<div id="div2">
<table width="80%" border="0" cellpadding="3" cellspacing="1" style="background: #75B6DE; position:static;filter:progid:DXImageTransform.Microsoft.DropShadow(color=#666666,offX=4,offY=4,positives=true)" align="center">
  <tr id="m_tr">
    <td><font color="#FFFFFF">个人信息：</font></td>
    <td align="right">
 <input type="button" value="ｘ" onClick="closeme()" style="cursor: hand;">
 </td>
  </tr>
  <tr>
<form id="UserM" action="order_userM.action" method="post">
    <td colspan="2" width="100%" bgcolor="#FFFFFF" height="150">
    <font color='red'><div align="center" id="errorMessages"></div></font>
    <font color="red">请补全您的个人信息:</font>
  <br>姓 名 :  <input type="text"  id="userName1" name="sysuser.userName"  size="20" value="<s:property value="sysuser.userName"/>"/>
  <br>电 话 :  <input type="text" id="mobile1" name="sysuser.mobile" size="20" value="<s:property value="sysuser.mobile"/>"/>
  <br>地 址： 
              <select style="width:95px"  id="cmbProvince" name="labuser.company.province">
              </select> 省 
              <select style="width:95px"  id="cmbCity" name="labuser.company.prefecturelevelCity">
              </select> 市 
              <select style="width:95px" id="cmbArea" name="labuser.company.area">
              </select> 区 
              <input type="text" id="street11" style="width:188px;white-space:nowarp;"  name="labuser.company.street" value="<s:property value='labuser.company.street'/>"/> 街道
          

  
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button"  value="保存" onclick="saveUserM();"> 
         <input type="button"  value="取消" onclick="closeme();"> 
 </td>
</form>
  </tr>
</table>
</div>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jsAddress.js"></script>
<%-- <script type="text/javascript">
var province = document.getElementById("province").value;
var city = document.getElementById("city").value;
var area = document.getElementById("area").value;
addressInit('cmbProvince', 'cmbCity', 'cmbArea',province,city,area);

function openme(){
	document.getElementById('div1').style.display='block';
	document.getElementById('div2').style.display='block';
	}
function closeme(){
	document.getElementById('div1').style.display='none';
	document.getElementById('div2').style.display='none';
	}



function saveUserM(){
	
	var userName = $("#userName1").val();
	var mobile = $("#mobile1").val();
	var cmbProvince = $("#cmbProvince").val();
	var cmbCity = $("#cmbCity").val();
	var cmbArea = $("#cmbArea").val();
	var street = $("#street11").val();

	$.ajax({
		url:'setHome!order_userM.action',
		type:'post',
		data:'userName='+userName+'&mobile='+mobile+'&cmbProvince='+
				cmbProvince+'&cmbCity='+cmbCity+'&cmbArea='+cmbArea+'&street='+street,
		dataType:'text',
		success:function(b){
			if(b=='true'){
				document.getElementById("name11111").value = userName;
				document.getElementById("mobile11111").value = mobile;
				document.getElementById("province11111").value = cmbProvince;
				document.getElementById("prefecturelevelCity11111").value = cmbCity;
				document.getElementById("area11111").value = cmbArea;
				document.getElementById("street11111").value = street;
				closeme();
			}else if(b=='userName'){
				$('#errorMessages').html("姓名不能为空!").show();
			}else if(b=='mobile'){
				$('#errorMessages').html("电话不能为空!").show();
			}else if(b=='cmbProvince'){
				$('#errorMessages').html("请完整填写地址信息!").show();
			}else if(b=='cmbCity'){
				$('#errorMessages').html("请完整填写地址信息!").show();
			}else if(b=='cmbArea'){
				$('#errorMessages').html("请完整填写地址信息!").show();
			}else if(b=='street'){
				$('#errorMessages').html("请完整填写地址信息!").show();
			}
		},
		error:{}
	});
}
</script> --%>
<!--收货人地址结束-->