<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/common.jsp"/>
<jsp:include page="/common/common_web.jsp"/>
<jsp:include page="/common/operamasks.jsp"/>
<title>专家在线问答_会员中心</title>
</head>
<body>
<jsp:include page="/common/head.jsp"/>
<div class="warp960">
<jsp:include page="member_left.jsp">
<jsp:param value="userProficients" name="currOpt"/>
</jsp:include>
<script type="text/javascript" >
$(document).ready(function() {
    $('#itemselector').omItemSelector({
    	availableTitle : '选择你擅长的领域',
        selectedTitle : '已选择的领域',
        onItemSelect:function(itemDatas,event){
        	$.each(itemDatas,function(index,data){
                window.location.href="addUserProfiType.action?typeId="+data.value;
                return true;
            });
        	
       	},
       	onItemDeselect :function(itemDatas,event){
       		$.each(itemDatas,function(index,data){
                window.location.href="delUserProfiType.action?typeId="+data.value;
                return true;
            });
       	},
        dataSource:[<s:property value="jsonQATypes"/>],
        value:[<s:property value="jsonUserQATyps"/>],
        width:650,
        height:400
    });
    
});
</script>
<div class="wbgRight_user">
    <div class="lesson_tit">设置擅长领域</div><br>
    	<div id="itemselector"></div>
	</div>
</div>
</body>
</html>