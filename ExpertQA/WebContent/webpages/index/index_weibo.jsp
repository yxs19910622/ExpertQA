<%@ page language="java" pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();%>
<!--微博切换-->
<div class="tabContainer">
	<ul class="tabHead" id="tabCot_product-li-currentBtn-">
    	<li class="currentBtn"><a href="javascript:void(0)" title=""><img src="<%=contextPath%>/interface/resource/images/tengxun.png" alt="" /></a></li>
        <li><a href="javascript:void(0)" title=""><img src="<%=contextPath%>/interface/resource/images/xinlang.png" alt="" /></a></li>
	</ul>
</div>
<div id="tabCot_product_1" style="display: none;">
	<iframe frameborder="0" scrolling="no" 
	src="http://show.v.t.qq.com/index.php?c=show&a=index&n=Laodongfasc&w=230&h=402&fl=2&l=6&o=31&co=0" width="230" height="412"></iframe>
</div>
<div id="tabCot_product_2">
<iframe width="100%" height="550" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?language=&width=0&height=550&fansRow=2&ptype=1&speed=0&skin=1&isTitle=1&noborder=1&isWeibo=1&isFans=1&uid=2658358015&verifier=d9a2eba8&dpc=1"></iframe>	
</div>
<script type="text/javascript" src="<%=contextPath%>/interface/javascript/blog.js"></script>
<!--微博切换 end-->