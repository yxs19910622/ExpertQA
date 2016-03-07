<%@ page language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/questionAbs.js'></script> 
</head>
<body>
<div class="yonghu_ph" >
	<b>活跃企业用户</b> 
	<script type="text/javascript">
	 function initActiveExpert(){
		 questionAbs.getActiveUser(function(list){
			 var html = '';
			 for(var i = 0;i < list.length; i++){
                 if(i <= 2){
                  html += '<li><span class="shuzi">'+(i+1)+'</span><a style="text-decoration:none;">'+list[i].ALIASNAME+'</a></li>';
                 }else{
                  html += '<li><span>'+(i+1)+'</span><a style="text-decoration:none;">'+list[i].ALIASNAME+'</a></li>';
                 }    
			 }
			 document.getElementById("activeUser").innerHTML = html;
			 });
		 }
	</script>
	<ul id="activeUser">
	<!--
	<li><span class="shuzi">1</span><a href="#">吃素的狮子</a></li>
		<li><span class="shuzi">2</span><a href="#">cisoo</a></li>
		<li><span class="shuzi">3</span><a href="#">蛋蜀黍</a></li>
		<li><span>4</span><a href="#">dorises</a></li>
		<li><span>5</span><a href="#">jordan23</a></li>
		<li><span>6</span><a href="#">bicever</a></li>
		<li><span>7</span><a href="#">pei3301</a></li>
		<li><span>8</span><a href="#">MistWalke</a></li>
		<li><span>9</span><a href="#">达尔达尼洋</a></li>
		<li><span>10</span><a href="#">KARAS_</a></li>
		  -->
	</ul>
</div>
</body>
</html>