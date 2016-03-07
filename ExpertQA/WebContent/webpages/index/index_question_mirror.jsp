<%@ page language="java" pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();
%>
<div class="mulu_right">
    <div id="type" style="display:none;"  class="mulu_type">
       	<b>所选分类:招聘</b>
    </div>
	<div class="mulu_wenti">
	<b>热门问题</b>
	<hr class = "hrs"/>
		<div class="mulu_title">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
            	<tr>
                	<td width="10" align="center"></td><td width="35" align="center">问题</td><td width="230">&nbsp;</td><td>回答</td><td width="35" align="left">时间</td><td align="center">提问者</td>
                </tr>
           	</table>
       </div>
	<div id="questionList" class="mulu_nav">
	                      
                             <div style="width:100%;height:100%;text-align:center;vertical-align:middle;"><img src="<%=contextPath%>/interface/resource/images/rotation.gif"/></div>
                        </div>
                    </div>
                    <div class="mulu_wenti" style="margin-top:15px;">
                    	<b>待回答问题</b>
                    	<hr class = "hrs"/>
                        <div class="mulu_title">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="10" align="center"></td><td width="35" align="center">问题</td><td width="230">&nbsp;</td><td>回答</td><td width="35" align="left">时间</td><td align="center">提问者</td>
                          </tr>
                        </table>
                        </div>
                        <div id="questionList2" class="mulu_nav">
                       
                             <div style="width:100%;height:100%;text-align:center;vertical-align:middle;"><img src="<%=contextPath%>/interface/resource/images/rotation.gif"/></div>
                        </div>
                    </div>
                    <br>
                    <a href="#" onclick="questionButton(1);" style="font-family: '宋体';color: #005891;;font-size: 14px;margin: 6px 16px;"><b>我要提问</b></a>
                </div>