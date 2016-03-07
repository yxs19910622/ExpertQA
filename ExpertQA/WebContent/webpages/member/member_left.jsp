<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/interface/javascript/cookie_2011_8.js"></script>
<script type="text/javascript">
function checklogin()
{
	var eUserID=Cookies.Get("EUserID");
	if(eUserID==null||eUserID==""||eUserID=="null")
	{
		alert("您好，请登录浩富在线问答!");
		window.location.href='http://zhuanjia.haufe.cn/login';
	}
}
</script>
<script type="text/javascript">
$(function(){
    $(function(){
		 $(".wbgUser_menu h3").toggle(function(){
					var $wbgself = $(this);
					$wbgself.next().slideToggle(0,function(){
						  $("span",$wbgself).css("background-position","0 -152px");
					});
					$(this).css("border-bottom","none");
			 },function(){
					var $wbgself = $(this);
					$wbgself.next().slideToggle(0,function(){
						  $("span",$wbgself).css("background-position","0 -110px");
					});
					$(this).css("border-bottom","1px solid #C5DDF6");
		 })
    });
      
    $(".wbgUser_menu ul li").mouseover(function(){
        $(this).addClass("hovered");
    }).mouseleave(function(){
        $(this).removeClass("hovered");
    });
});
</script>
<body onclick="checklogin();">
<div class="wbgLeft_user"><s:property value="initMenu" escape="false"/></div>
</body>
<c:if test="${param.currOpt!=null}">
<script>
document.getElementById('${param.currOpt}').className='menu_nowUser';
</script>
</c:if>