<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addAccountSave.action" method="post" id="expertForm">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr>
			<td style="height:30px" width="20%" align="right">角色：</td>
			<td width="45%">
			<select style="330px;" name="roleID">
            	<option>-请选择-</option>
            	<s:if test="lstRoles!=null">
            		<s:iterator value="lstRoles">
            			<option value="<s:property value='roleID'/>"><s:property value="roleName"/></option>
            		</s:iterator>
            	</s:if>
            </select>
			</td>
			<td width="35%" class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" width="20%" align="right">昵称：</td>
			<td width="45%"><input type="text" name="labuser.aliasName"/>
			<font color="red">*</font></td>
			<td width="35%" class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" width="20%" align="right">姓名：</td>
			<td width="45%"><input type="text" name="sysuser.userName"/>
			<font color="red">*</font></td>
			<td width="35%" class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" width="20%" align="right">邮箱地址：</td>
			<td width="45%"><input type="text" name="sysuser.email"/>
			<font color="red">*</font></td>
			<td width="35%" class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" width="20%" align="right">登录密码：</td>
			<td width="45%"><input type="password" name="sysuser.password"/>
			<font color="red">*</font></td>
			<td width="35%" class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" align="right">手机：</td>
			<td><input type="text" name="sysuser.mobile"/>
			<font color="red">*</font>
			</td><td class="w_wrong"></td>
		</tr>
		<!-- 
		<tr>
			<td style="height:30px" align="right">个人电话：</td>
			<td><input type="text" name="labuser.telephone"/>
			</td><td class="w_wrong"></td>
		</tr>
		 -->
		<tr>
			<td style="height:30px" align="right">公司电话：</td>
			<td><input type="text" name="labuser.company.telephone"/><font color="red">*</font></td>
			<td class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" align="right">公司职位：</td>
			<td><input type="text" name="labuser.position"/><font color="red">*</font></td>
			<td class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" align="right">公司名称：</td>
			<td><input type="text" name="labuser.company.companyName"/><font color="red">*</font></td>
			<td class="w_wrong"></td>
		</tr>
		<!-- 
		<tr>
			<td style="height:30px;" align="right">法人代表</td>
			<td><input type="text" name="labuser.company.incorporator"></td>
			<td class="w_wrong"></td>
		</tr>
		 -->
		<tr>
			<td style="height:30px" align="right">公司地址：</td>
			<td colspan="2">
				<select style="width:98px" onchange="setCity(this.value);setvaluep(this)" id="province">
				<option>-请选择-</option></select> 省 
				<select style="width:98px" onchange="setCounty(this.value);setvaluec(this);" id="city">
				<option>-请选择-</option></select> 市 
                <select style="width:98px" onchange="setvalues(this);" id="county">
				<option>-请选择-</option></select> 区 
				<input type="text" style="width:188px" name="labuser.company.street"/> 街道<font color="red">*</font></td>
		</tr>
		<tr>
			<td style="height:30px" align="right">公司邮编：</td>
			<td><input type="text" name="labuser.company.postcode"/><font color="red">*</font></td>
			<td class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:30px" align="right">公司传真：</td>
			<td><input type="text" name="labuser.company.fax"/></td>
			<td class="w_wrong"></td>
		</tr>
		<tr>
			<td style="height:50px" align="right"></td>
			<td><input type="submit" class="botn_gary" value="保 存" title="保 存" /></td>
			<td></td>
		</tr>
	</table>
	<input type="hidden" id="provinces" name="labuser.company.province"/>
	<input type="hidden" id="citys" name="labuser.company.prefecturelevelCity"/>
	<input type="hidden" id="sections" name="labuser.company.area"/>
</form>
<script type="text/javascript" src="<%=request.getContextPath()%>/interface/javascript/address.js"></script>
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
</body>
</html>