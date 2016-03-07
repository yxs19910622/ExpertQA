<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="userEdit" name="currOpt"/>
</jsp:include>



<div class="wbgRight_user">
<!-- <div class="new_user">
  会员中心新功能： <a href="#">会员中心全新上线，快去看看有什么新功能吧！</a>
</div> -->
<div class="lesson_tit">个人信息</div>
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" class="Ltd">
    	<tr>
        	<td width="100%" valign="top">
        		<form action="userEditSave.action" method="post" id="snake" name="snake">
            	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
                    <tr>
                        <td style="height:30px" width="20%" align="right">昵称：</td>
                        <td width="45%">
                        <input type="text" name="labuser.aliasName" value="<s:property value='sysuser.aliasName'/>"/>
                        <input style="display:none;" type="text" name="labuser.userID" value="<s:property value='labuser.userID'/>"/>
                        <input style="display:none;" type="text" name="sysuser.userID" value="<s:property value='sysuser.userID'/>"/>
                        </td>
                        <td width="35%" class="w_wrong"></td>
                    </tr>
					<tr>
                        <td style="height:30px" width="20%" align="right">姓名：</td>
                        <td width="45%">
                        <input type="text" name="sysuser.userName" value="<s:property value='sysuser.userName'/>"/>
                        </td>
                        <td width="35%" class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">手机：</td>
                        <td>
                        	<input type="text" name="sysuser.mobile" value="<s:property value='sysuser.mobile'/>"/>
                        	
                        </td>
                        <td class="w_wrong"></td>
                    </tr>
                    
                    <tr>
                        <td style="height:30px" align="right">个人电话：</td>
                        <td>
                        	<input type="text" name="labuser.telephone" value="<s:property value='labuser.telephone'/>"/>
                        </td>
                        <td class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">公司电话：</td>
                        <td><input type="text" name="labuser.company.telephone" value="<s:property value='labuser.company.telephone'/>"/></td>
                        <td class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">公司职位：</td>
                        <td><input type="text" name="labuser.position" value="<s:property value='labuser.position'/>"/></td>
                        <td class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">公司名称：</td>
                        <td><input type="text" name="labuser.company.companyName" value="<s:property value='labuser.company.companyName'/>"/></td>
                        <td class="w_wrong"></td>
                    </tr>
                    <!-- 
                    <tr>
                    	<td style="height:30px;" align="right">法人代表</td>
                    	<td><input type="text" name="labuser.company.incorporator" value="<s:property value='labuser.company.incorporator'/>"></td>
                    	<td class="w_wrong"></td>
                    </tr>
                     -->
                    <tr>
                        <td style="height:30px" align="right">公司地址：</td>
                        <td colspan="2">
	                        <select style="width:95px" onclick="setvaluep(this);" id="province">
	                        </select> 省 
	                        <select style="width:95px" onclick="setvaluec(this);" id="city">
	                        </select> 市 
	                        <select style="width:95px" onclick="setvalues(this);" id="county">
	                        </select> 区 
	                        <input type="text" style="width:188px;white-space:nowarp;" name="labuser.company.street" value="<s:property value='labuser.company.street'/>"/> 街道
	                        <a style="color:red;">地址（省、市）信息对于我们为您提供符合当地规定的答案非常重要，请提供准确信息</a>
                        </td>
						
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">公司邮编：</td>
                        <td><input type="text" name="labuser.company.postcode" value="<s:property value='labuser.company.postcode'/>" /></td>
                        <td class="w_wrong"></td>
                    </tr>
                    <tr>
                        <td style="height:30px" align="right">公司传真：</td>
                        <td><input type="text" name="labuser.company.fax" value="<s:property value='labuser.company.fax'/>"/></td>
                        <td class="w_wrong"></td>
                    </tr>
                     <tr>
                        <td style="height:50px" align="right"></td>
                        <td><input type="submit" class="botn_gary" value="保 存" title="保 存" onclick='alert("保存成功");'/></td>
                    	<td></td>
                	</tr>
            	</table>
            	<input type="hidden" id="sheng" name="labuser.province" value="${labuser.province}"/>
            	<input type="hidden" id="shi" name="labuser.prefecturelevelCity" value="${labuser.prefecturelevelCity}"/>
            	<input type="hidden" id="qu" name="labuser.area" value="${labuser.area}">
            	<input type="hidden" id="provinces" name="labuser.company.province" value="${labuser.company.province}"/>
				<input type="hidden" id="citys" name="labuser.company.prefecturelevelCity" value="${labuser.company.prefecturelevelCity}"/>
				<input type="hidden" id="sections" name="labuser.company.area" value="${labuser.company.area}"/>
            	</form>
        	</td>
		</tr>
	</table>
</div>
</div>






</body>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/jsAddress1.js"></script>
<script type="text/javascript">

var provinces = document.getElementById('provinces').value;
var citys = document.getElementById('citys').value;
var sections = document.getElementById('sections').value;

addressInit('province', 'city', 'county',provinces,citys,sections);



/* var provinces = document.getElementById('provinces').value;
var citys = document.getElementById('citys').value;
var sections = document.getElementById('sections').value; */
/* fillShowCity(provinces);//回显调用
setShowCity(provinceCodes,citys);
setShowCounty(cityCodes,sections); */
function setvaluep(obj){
	saveMMM();
	 /* document.getElementById("provinces").value=obj.options[obj.selectedIndex].text; */
}
function setvaluec(obj){
	saveMMM();
}
function setvalues(obj){
	saveMMM();
}

function saveMMM(){
	document.getElementById("provinces").value=document.getElementById("province").value
	document.getElementById("citys").value=document.getElementById("city").value
	document.getElementById("sections").value=document.getElementById("county").value
}

</script>
</html>