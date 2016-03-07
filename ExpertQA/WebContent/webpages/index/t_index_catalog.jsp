<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>

<script type='text/javascript' src='<%=contextPath%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/interface/questionAbs.js'></script> 

<style>

a{text-align:left;font-size:9pt}
a{text-decoration:none}

</style>
<script type="text/javascript">

var j$ = jQuery.noConflict(); 
j$(document).ready(function(){
	treeMulu();
    });

function treeMulu(){
	 questionAbs.getQaTypeParent(function(parent){
			questionAbs.getQaTypeChild(function(child){
				var html = '<div style="margin:10px 0 10px 10px;line-height:20px;">';
	              for(var i = 0;i < parent.length; i++){
	                 html += '<div><span style="padding-button:10px;"><a href="javascript:getQaTypeId(\''+parent[i].QATYPEID+'\',\''+parent[i].QATYPENAME+'\')">'+parent[i].QATYPENAME+'</a></span></div>';
	                 html += '<div id="'+parent[i].QATYPEID+'" ><span><div>';//style="display:none"
	                   for(var j = 0;j < child.length; j++){
	                          if(parent[i].QATYPEID == child[j].PARENTTYPEID){
	                        	
                               html += '<div>';
                               html += '<span><img src="<%=contextPath%>/interface/resource/images/leaf.gif" WIDTH="16" HEIGHT="16"><a href="javascript:getChildQaTypeId(\''+child[j].QATYPEID+'\',\''+parent[i].QATYPENAME+'\',\''+child[j].QATYPENAME+'\');" onclick="">'+child[j].QATYPENAME+'</a></span>';
                               html +=	'</div>';
	                        	
	                            }
	                       }
	                   html += '</div></span></div>';
	                  }
                 html += '<div>';
	              document.getElementById('tree').innerHTML = html;
				});
			}); 
}
 
  

</script>
<div id="main_nav">
		<!--这个div 是随屏幕滚动-->
		<div class="mulu_left" id="MainMenu">
			<b style="margin-top:8px">问答分类</b>
			<hr class = "hrs"/>
			<div id="tree"></div>
		</div>
	</div>
<!--屏幕滚动 end-->