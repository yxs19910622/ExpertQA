<%@ page language="java" pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();%>
<div class="weekly_img">
	<div id="picBox">
		<ul id="show_pic" style="left: 0;">
			<li><a href="http://www.haufe.cn/trydown/index.html">
			<img src="<%=contextPath%>/interface/resource/images/daily1.jpg" width="950" height="147" alt="" title="" /></a></li>
			<li><a href="#">
			<img src="<%=contextPath%>/interface/resource/images/daily2.jpg" width="950" height="147" alt="" title="" /></a></li>
			<li><a href="#">
			<img src="<%=contextPath%>/interface/resource/images/daily3.jpg" width="950" height="147" alt="" title="" /></a></li>
		</ul>
		<ul id="icon_num">
			<LI>1</LI>
			<LI>2</LI>
			<LI>3</LI>
		</ul>
	</div>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/qiehuan.js"></script>
<script type="text/javascript">
	glide.layerGlide(true,'icon_num','show_pic',950,2,0.1,'left');
</script>
</div>