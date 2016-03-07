<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type='text/javascript' src='<%=basePath%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=basePath%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=basePath%>/dwr/interface/hyper.js'></script> 

<title>超链接内容编辑</title>
<script type="text/javascript">
 var objs = '';
 function init(){
   hyper.getAllHyperRecord(function(list){
   objs = list;
    var html = "<table border = '1' align = 'center'>";
    html += "<tr style='width:810px;'><td style='width:200px;'>显示内容</td><td style='width:200px;'>链接地址</td><td style='width:100px;'>是否需登录</td><td style='width:100px;'>操作</td></tr>";
    for(var i=0;i<list.length;i++){
      html += "<tr style='width:810px;'><input id='idx' type='hidden' value='1'/>";
      html += "<td  style='width:290px;'>"+list[i].VIEWTEXT+"</td>";
      html += "<td style='width:290px;'>"+list[i].EXTENDADDRESS+"</td>";
      html += "<td style='width:100px;'>"+list[i].MUSTLOGIN+"</td>";
      html += "<td style='width:120px;'><a href='#' onclick='updateRecordHtml("+i+")'>修改</a>&nbsp;<a href='#' onclick='deleteRecord("+list[i].TID+")'>删除</a></td>";
      html += "</tr>";
    }
    html += "</table>";
    document.getElementById("oData").innerHTML = html;
   });
 }
 //===================================================添加记录函数===========================================
 function addRecordHtml(){
  var html = "<div style='margin-top:50px;'>添加记录</div>";
  html += "<div style='margin-top:20px;'>";
      html += "<span>显示内容：</span><span><input id='viewText' type='text' size='30'/></span>";
      html += "</div>";
      html += "<div>";
      html += "<span>链接地址：</span><span><input id='hyperLink' type='text' size='30'/></span>";
      html += "</div>";
      html += "<div style='text-align:left;margin-left:98px;'>";
      html += "<span>是否需登录：</span><span><input id='noLogin' type='checkbox'/></span>";
      html += "</div>";
      html += "<div>";
      html += "<span onclick='submitOk();'><input type='button' value='确认'/></span>&nbsp;&nbsp;<span onclick='submitCancel();'><input type='button' value='清空'/></span>&nbsp;&nbsp;<span onclick='cancel();'><input type='button' value='取消'/></span>";
      html += "</div>";
  document.getElementById("layer").innerHTML = html;
 }
 function submitOk(){
   var vText = document.getElementById("viewText").value;
   if(vText == ""){
      alert("显示内容不为空");
      document.getElementById("viewText").focus();
      return;
   }
   var hLink = document.getElementById("hyperLink").value;
   if(hLink == ""){
      alert("链接地址不为空");
      document.getElementById("hyperLink").focus();
      return;
   }
   var nLogin = document.getElementById("noLogin").checked;
   var map = {
    "viewText":vText,
    "extendAddress":hLink,
    "mustLogin":nLogin
   };
   hyper.addHyperRecord(map,function(flag){
      if(flag){
        document.getElementById("viewText").value = "";
        document.getElementById("hyperLink").value = "";
        document.getElementById("noLogin").checked = false;
        init();
      }
   });
 }
 function submitCancel(){
   document.getElementById("viewText").value = "";
   document.getElementById("hyperLink").value = "";
   document.getElementById("noLogin").checked = false;
 }
 function cancel(){
  document.getElementById("layer").innerHTML = "";
 }
 //===================================================删除记录函数===========================================
 function deleteRecord(index){
   hyper.deleteHyperRecord(index,function(flag){
     if(flag){
      init();
     }
   });
 }
 //===================================================修改记录函数===========================================
 function updateRecordHtml(ids){
  var map = objs[ids];
  var html = "<div style='margin-top:50px;'>修改记录</div>";
  html += "<div style='margin-top:20px;'>";
      html += "<span>显示内容：</span><span><input id='viewText' type='text' size='30' value='"+map.VIEWTEXT+"'/></span>";
      html += "</div>";
      html += "<div>";
      html += "<span>链接地址：</span><span><input id='hyperLink' type='text' size='30' value='"+map.EXTENDADDRESS+"'/></span>";
      html += "</div>";
      html += "<div style='text-align:left;margin-left:98px;'>";
      html += "<span>是否需登录：</span><span><input id='noLogin' type='checkbox' checked='"+map.MUSTLOGIN+"'/></span>";
      html += "</div>";
      html += "<div>";
      html += "<span onclick='submitUpdateOk("+map.TID+");'><input type='button' value='确定'/></span>&nbsp;&nbsp;<span onclick='submitCancel();'><input type='button' value='清空'/></span>&nbsp;&nbsp;<span onclick='cancel();'><input type='button' value='取消'/></span>";
      html += "</div>";
  document.getElementById("layer").innerHTML = html;
 }
 function submitUpdateOk(idx){
     var vText = document.getElementById("viewText").value;
   if(vText == ""){
      alert("显示内容不为空");
      document.getElementById("viewText").focus();
      return;
   }
   var hLink = document.getElementById("hyperLink").value;
   if(hLink == ""){
      alert("链接地址不为空");
      document.getElementById("hyperLink").focus();
      return;
   }
   var nLogin = document.getElementById("noLogin").checked;
   var map = {
    "tid":idx,
    "viewText":vText,
    "extendAddress":hLink,
    "mustLong":nLogin
   };
   hyper.updateHyperRecord(map,function(flag){
      if(flag){
        document.getElementById("viewText").value = "";
        document.getElementById("hyperLink").value = "";
        document.getElementById("noLogin").checked = false;
        init();
      }
   });
 }

</script>
</head>
<body onload="init();">
  <div>
    <div style="text-align:center;">超链接内容编辑</div>
    <div style="text-align:right;width:810px;margin-left:250px;"><input type="button" onclick="addRecordHtml();" style="width:80px;height:30px;font-size:18px;" value="添加"/></div>
    <div id="layer" style="text-align:center;width:500px;margin-left:400px;"></div>
    <div id="oData" style="text-align:center;margin-top:10px;"></div>
    
  </div>
</body>
</html>