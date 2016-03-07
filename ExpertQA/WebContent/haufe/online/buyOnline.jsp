<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=contextPath%>/haufe/css/haufe.css" rel="stylesheet" type="text/css"/>
<script src="<%=contextPath%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/haufe/js/script.js" type="text/javascript"></script>
<jsp:include page="/common/operamasks.jsp"/>
<title>浩富-在线购买</title>
</head>
<body>
<jsp:include page="/haufe/common/head.jsp"/>

<script type="text/javascript" >
var test = window.location.search;
var flag = test.replace("?","");
if(flag.length>15){
	window.location.href = "init_buyonline.action?"+flag;
}
</script>
<div class="content">
    <div class="content-head">在线购买</div>
    <div class="shopping clearfix">
    	<jsp:include page="aside.jsp"/>
        <div class="main right">
            <div class="title">浩富产品目录</div>
            <div class="shopping-list clearfix">
            	<div class="shop">
                    <div class="img-con"><img src="<%=contextPath%>/haufe/images/demo/6.jpg"/></div>
                    <div class="btns">
                    	<p>浩富劳动法顾问软件</p>
                        <!-- <p>标准版：<input type="button" class="btnSave" value="我要购买" onclick="addCart('P0003')"/></p> -->
                        <p><!-- 专业版： --><input type="button" class="btnSave" value="我要购买" onclick="addCart('P0002')"/></p>
                    </div>
                    
                </div>
                <div class="shop">
                    <div class="img-con"><img src="<%=contextPath%>/haufe/images/demo/4.jpg"/></div>
                    <div class="btns">
                    	<p>浩富劳动法专家咨询</p>
                        <input type="button" class="btnSave" value="我要购买" onclick="addCart('P0004')"/>
                    </div>
                </div>
               
                <div id="div" style="display:block">
                <div class="shop">
                    <div class="img-con"><img src="<%=contextPath%>/haufe/images/demo/7.jpg"/></div>
                    <div class="btns">
                   		<p>浩富管理者劳动法实务手册</p>
                    	<p><!-- 标准版： --><input type="button" class="btnSave" value="我要购买" onclick="addCart('P0001')"/></p>
                    </div>
                </div>
                 <div class="shop">
                    <div class="img-con"><img src="<%=contextPath%>/haufe/images/demo/41.jpg"/></div>
                    <div class="btns">
                    	<p>咨询付费</p>
                        <input type="button" class="btnSave" value="我要购买" onclick="addCart('P0005')"/>
                    </div>
                </div>
                
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

if(flag=="kehu"){
	document.getElementById("div").style.display="none";
}
function addCart(productNo){
	window.location.href='addCart.action?productNo='+productNo;
};
</script>
<jsp:include page="/haufe/common/foot.jsp"/>
</body>
</html>