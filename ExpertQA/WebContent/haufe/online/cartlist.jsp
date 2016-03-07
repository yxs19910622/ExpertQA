<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="org.izhong.expert.util.CookieUtil"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();
Cookie euserId = CookieUtil.getCookieByName(request, "EUserID");
Cookie eshowName = CookieUtil.getCookieByName(request, "EUserName");
String userId = null;
String name = "";
if(eshowName==null)
{
	eshowName = CookieUtil.getCookieByName(request, "Eemail");
}
if(euserId!=null && eshowName!=null){
	userId = euserId.getValue();
	name = eshowName.getValue();
}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=contextPath%>/haufe/css/haufe.css" rel="stylesheet" type="text/css"/>
<script src="<%=contextPath%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/haufe/js/script.js" type="text/javascript"></script>


<title>浩富-我的购物车</title>
</head>
<body onload="totalMoney();">
<jsp:include page="/haufe/common/head.jsp"/>
<script language="javascript" type="text/javascript" src="http://pv.sohu.com/cityjson?ie=utf-8">  
</script> 
<style type="text/css"> /*登录框样式*/
/*全局样式*/
body{margin: 0;padding: 0;}
img,body,html{border:0;}
address,caption,cite,code,dfn,em,strong,th,var{font-style:normal;font-weight:normal;}
ol,ul{list-style:none;}
caption,th{text-align:left;}
h1,h2,h3,h4,h5,h6{font-size:100%;}
/*边角样式(圆角)*/
.x-box-tl{background:transparent url(images/corners.gif) no-repeat 0 0;zoom:1;}
.x-box-tc{height:8px;background:transparent url(images/tb.gif) repeat-x 0 0;overflow:hidden;}
.x-box-tr{background:transparent url(images/corners.gif) no-repeat right -8px;}
.x-box-ml{background:transparent url(images/l.gif) repeat-y 0;padding-left:4px;overflow:hidden;zoom:1;}
.x-box-mc{background:#eee url(images/tb.gif) repeat-x 0 -16px;padding:4px 10px;font-family:"Myriad Pro","MyriadWeb","Tahoma","Helvetica","Arial",sans-serif;color:#393939;font-size:12px;}
.x-box-mc h3{font-size:14px;font-weight:bold;margin:0 0 4px 0;zoom:1;}
.x-box-mr{background:transparent url(images/r.gif) repeat-y right;padding-right:4px;overflow:hidden;}
.x-box-bl{background:transparent url(images/corners.gif) no-repeat 0 -16px;zoom:1;}
.x-box-bc{background:transparent url(images/tb.gif) repeat-x 0 -8px;height:8px;overflow:hidden;}
.x-box-br{background:transparent url(images/corners.gif) no-repeat right -24px;}
.x-box-tl,.x-box-bl{padding-left:8px;overflow:hidden;}
.x-box-tr,.x-box-br{padding-right:8px;overflow:hidden;}
/*表单样式*/
.loginPanel {
	margin: -140px auto auto -180px;
	position: absolute;
	top: 50%;
	left: 50%;
	height: 400px;
	width:347px
}
.x-form-text {
	height:16px;
	line-height:16px;
	vertical-align:middle;
}
.x-form-text, textarea.x-form-field {
	background:#FFFFFF url(images/text-bg.gif) repeat-x scroll 0pt;
	border:1px solid #B5B8C8;
	padding:1px 1px;
}
}
</style>
<script type="text/javascript">


var ip = returnCitySN.cip;

$(document).ready(function() {
	//点击刷新验证码功能
    $('#loginForm img').click(function(){
        //因为浏览器默认会缓存图片，所以只要改变url就可以跳过缓存
        //每次在url后面添加随机数就可以保证url不重复
        this.src='userLogin!validateImage.action?num='+Math.random();
    });
    $(".loginimg").unbind("click").removeAttr("onclick");
   
});

function myLogin(){
	var email = $("#email").val();
	var password = $("#loginPass").val();
	var validatecode = $("#validatecode").val();
	$.ajax({
		url:'userLogin!myLogin.action',
		type:'post',
		data:'email='+email+'&password='+password+'&validatecode='+validatecode,
		dataType:'text',
		success:function(b){
			if(b=='true'){
				closeme();
			}else if(b=='code'){
				$('#errorMessages').html("验证码错误!").show();
			}else{
				$('#errorMessages').html("帐号或密码错误!").show();
			}
		},
		error:{}
	});
}

</script>
<style type="text/css">
body {
 margin: 0px;padding:0
}
/* #div1 {
 display: none;
 position: absolute;
 z-index: 1000;
 height: 100%;
 width: 100%;
 background: #000000;
 filter:Alpha(opacity=30);
} */ 
#div2 {
 display:none ;
 position: absolute;
 height: 100%;
 width: 100%;
 padding-top: 40%;
 z-index: 100;
 left: 500px;
 top: -100px;
}
</style>

<div class="content">
	<div class="content-head">在线购买</div>
    <div class="shopping clearfix">
    <jsp:include page="aside.jsp"/>
    	<div class="main right mycart">
    	现在<button type="button" onclick="denglu();">登录</button>
        <p class="step"><img src="<%=contextPath%>/haufe/images/step1.jpg"/></p>
        <p class="title-cart">我的购物车</p>
        <form action="<%=contextPath%>/submitCart.action" method="post" id="cartForm">
        <input type="hidden" name="finalPrice" value=""/>
        <input type="hidden" name="totalPrice" value=""/>
        <input type="hidden" name="coupon" value=""/>
        <input type="hidden" name="preferPrice" value=""/>
            <table class="ctable">
				<th>商 品</th>
                <th>市场价</th>
                <th>商品数量</th>
                <th>操 作</th>
			<s:iterator value="lstop" var="product" status="pro">
				<tr id="tr<s:property value="#pro.index+1"/>" class="align_Center">
					<td style="text-align: left;">
						<span class="p-img"><a href="#none">
							<img src="<%=contextPath%>/haufe/images/product/<s:property value="producTimagePath"/>" width="50" height="50"></a>
						</span>
						<a href="#none" ><s:property value="productName"/><s:property value="productType"/></a>
					</td>
					<td><span id="totalPri<s:property value="#pro.index+1"/>">￥<s:property value="productPrice"/></span></td>
					<td style="display: none"><strong class="red"><span class="price">￥</span><span class="price" id="preferPri<s:property value="#pro.index+1"/>"><s:property value="actualPrice"/></strong></span></td>
					<td>
						<a href="#none" title="减一" onclick="changeBar('-','<s:property value="#pro.index+1"/>');" style="margin-right: 2px;">
							<img style="display: inline;" src="<%=contextPath %>/interface/resource/images/shoppingcart/bag_close.gif" border="none">
						</a>
						<input id="orderQuantity_<s:property value="#pro.index+1"/>" name="orderQuantity_<s:property value="#pro.index+1"/>" maxlength="4" style="width: 30px;" 
							onkeydown="if(event.keyCode == 13) event.returnValue = false" value="1"
							onblur="changeProductCount('<s:property value="#pro.index+1"/>');" type="text">
						<input id="hidChange_<s:property value="#pro.index+1"/>" value="1" type="hidden">
						<a href="#none" title="加一" onclick="changeBar('+','<s:property value="#pro.index+1"/>');" style="margin-left: 2px;" >
							<img style="display: inline;" src="<%=contextPath %>/interface/resource/images/shoppingcart/bag_open.gif" border="none">
						</a>
					</td>
					<td><a href="#none" id="btn_del_<s:property value="#pro.index+1"/>" onclick="removeProductOnShoppingCart('<s:property value="#pro.index+1"/>','<s:property value="productNo"/>')">删除</a></td>
				</tr>
				</s:iterator>
				<tr class="bg">
					<td colspan="5" rowspan="1" style="*border-left:1px solid #56a6db;_border-left:1px solid #56a6db;padding-right: 5px">
						<span class="left"><br>请输入优惠码：<input type="text" id="youhui"/></span>
						<span class="left"><br><input type="button" onclick="test('<s:property value="productNo"/>')" value="确定" /></span><br>
						<span class="right">总金额：￥<span id="totalPrice"></span>元</span><br>
						<span class="right"><strong>优惠：</strong><strong class="red">￥-<span id="preferPrice"></span>元</strong></span><br>
						<span class="right">优惠券：<strong class="red">￥<span id="coupon"></span>元</strong></span><br>	
						<span class="right">应收总计：￥<span id="finalPrice"></span>元</span><br>				
					</td>
				</tr>
				<tr class="bg">
					<td colspan="5" align="left" style="text-align: right;padding-right: 5px">
						<a href="<%=contextPath%>/BuyOnline"><img alt="" src="<%=contextPath%>/haufe/images/rebuy.png"/></a>
						<a href="javascript:void(0);" onclick="cartSave1()"><img alt="" src="<%=contextPath%>/haufe/images/calculate.png"/></a>
					</td>	
				</tr>
            </table>
            </form>
        </div>
    </div>
    
    
	<div id="div1"></div>
	<div id="div2" style="position:absolute;left:50px;top:0px;">
    <form action="#" method="post"  id="loginForm">
	<div class="loginPanel">
		<div class="x-box-tl">
			<div class="x-box-tr">
				<div class="x-box-tc">
				</div>
			</div>
		</div>

		<div class="x-box-ml">
			<div class="x-box-mr">
				<div class="x-box-mc" style="height: 173px;">
				<img class="loginimg" id="j_id2:j_id4" src="images/register.png"/>
				
					<table id="j_id2:j_id5" cellspacing="3px" style="width:100%">
						<tr>
						<td align="right" colspan="1" rowspan="1" style="padding-right: 3px;">
							<label >用户名：</label>
						</td>
						<td colspan="2">
							<label><input name="email" id="email" type="text" style="width: 212px;" class="x-form-text"/></label>
						</td>
						<tr>

						<tr>
						<td align="right" colspan="1" rowspan="1" style="padding-right: 3px;">
							<label >密码：</label>
						</td>
						<td colspan="2">
							<label><input name="loginPass" id="loginPass" type="password" style="width: 212px;" class="x-form-text"/></label>
						</td>
						<tr>

						<tr>
						<td align="right"  style="padding-right: 3px;">
							<label>验证码：</label>
						</td>
						<td>
							<label><input name="validatecode" id="validatecode" type="text" style="width: 125px;" class="x-form-text"/></label>
						</td>
						<td  style="padding-right: 20px;">
							<label><img id="image" style=" padding-top:6px;" src="userLogin!validateImage.action" title="点击刷新验证码"/></label>
						</td>
						<tr>

						<tr>
						<td align="center" colspan="2">
							&nbsp; &nbsp; &nbsp; &nbsp; 
							<!-- <label><img class="loginimg" src="images/ZR05.gif" style="padding-left:42px;"/><img class="loginimg" src="images/ZR04.gif" style="padding-left:12px;"/></label> -->
							<input type="button" name="logoin" value="登陆" onClick="myLogin()">&nbsp; &nbsp; &nbsp; &nbsp; 
					        <input type="button" name="exit" value="取消" onClick="closeme()">&nbsp; &nbsp; &nbsp; &nbsp; 
					        <a href="http://zhuanjia.haufe.cn/register"><font color='blue'>注册</font></a>						
						</td>
						<td style="padding-right: 20px;">
							<label id="errorMessages" style="color:red"></label>
						</td>
						<tr>
					</table>
				</div>
			</div>
		</div>

		<div class="x-box-bl">
			<div class="x-box-br">
				<div class="x-box-bc">
				</div>
			</div>
		</div>

	</div>
</form>
    
</div>

<!-- <table width="30%" border="0" cellpadding="3" cellspacing="1" style="background: #75B6DE; position:static;filter:progid:DXImageTransform.Microsoft.DropShadow(color=#666666,offX=4,offY=4,positives=true)" align="center">
  <tr id="m_tr">
    <td><font color="#FFFFFF">欢迎登录：</font></td>
    <td align="right">
 <input type="button" value="ｘ" onClick="closeme()" style="cursor: hand;">
 </td>
  </tr>
  <tr>
<form action="#" method="post"  id="loginForm">
    <td colspan="2" width="100%" bgcolor="#FFFFFF" height="150">
    <font color='red'><div align="center" id="errorMessages"></div></font>
       &nbsp;&nbsp;&nbsp;用户名: <input type="text" name="email" id="email" class="input" size="20"/>
  <br>&nbsp;&nbsp;&nbsp;密 码: &nbsp;&nbsp;&nbsp;<input type="password" name="loginPass" id="loginPass" class="input" size="20"/>
  <br>&nbsp;&nbsp;&nbsp;验证码：<input type="text" class="input" style="width: 80px;" name="validatecode" id="validatecode"/>
  <img id="image" style=" padding-top:6px;" src="userLogin!validateImage.action" title="点击刷新验证码"/>
                    <a href="javascript:loadimage();" class="forget" style="font-size: 12px;">看不清，换一个</a>
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="button" name="logoin" value="登陆" onClick="myLogin()"> 

         <input type="button" name="exit" value="取消" onClick="closeme()">
         <a href="http://zhuanjia.haufe.cn/register"><font color='blue'>还没有账号</font></a>
 </td>
</form> 

  </tr>
</table>-->

</div>


<script type="text/javascript">

function changeBar(type, id, codeName)
{
    var txtC=$("#orderQuantity_"+id);
    var hidC=$("#hidChange_"+id);
    var change=0;
    if(type=='+')
    {
      change=1;
    } else if(type=='-')
    {
      change=-1;
    } 
    var num=parseInt(txtC.val());
    var totalNum=parseInt(num+change);
    if(totalNum<=0)
    {
       alert('您输入的数字已经超出最小值');
       return;
    }
    if(totalNum>1000){
    	alert('您输入的数字已经超出1000最大值');
        return;
     }
    txtC.val(totalNum);
    hidC.val(totalNum);
    //txtC.attr("disabled","disabled");
    totalMoney();
}
//计算商品的市场价和优惠价
function totalMoney(){
	var len = '${cartSize}';
	var totalMoney = 0;
	var preferMoney = 0;
	for(var i = 1;i <= parseInt(len);i++){
     if($("#tr"+i).css("display") != "none"){
    	totalMoney += parseInt($("#orderQuantity_"+i).val()) * parseInt($("#totalPri"+i).html().replace('￥',''));
    	preferMoney += parseInt($("#orderQuantity_"+i).val()) * parseInt($("#preferPri"+i).html());
      }
	}
	$("#totalPrice").html(totalMoney);
	input=top.document.getElementsByName("totalPrice");    
    input[0].value=totalMoney;
    $("#preferPrice").html(totalMoney-preferMoney);
    input=top.document.getElementsByName("preferPrice");    
    input[0].value=totalMoney-preferMoney;
    $("#finalPrice").html(preferMoney);
    input=top.document.getElementsByName("finalPrice");    
    input[0].value=preferMoney;
    if($("#preferPrice")!=0){
    	$("#coupon").html(0);
    	input=top.document.getElementsByName("coupon");    
	    input[0].value=0;
    }
}
//更改商品数量
function changeProductCount(id,orderQuantity)
{
	var txtC=$("#orderQuantity_"+id);
	var hidC=$("#hidChange_"+id);
	var currVal=$("#orderQuantity_"+id).val();
 
   //检测输入是否为数字
   if(!checknumber(currVal)){
	   alert("您输入的格式不正确！");
	   $("#orderQuantity_"+id).val($("#hidChange_"+id).val());
	   return;
	   }
   
   //判断为0的情况
   if(parseInt(currVal)==0)
   {
	  removeProductOnShoppingCart(id);
      return;
   }
   if(parseInt(currVal)>1000){
	   alert('您输入的数字已经超出1000最大值');
       return;
   }
   hidC.val(currVal);
   totalMoney();
}
//检测输入是否为数字
function checknumber(String) 
{ 
    if(trimTxt(String)=="")
    {
       return false;
    }
    var Letters = "1234567890"; 
    var i; 
    var c; 
    for( i = 0; i < String.length; i ++ ) 
    { 
        c = String.charAt( i ); 
        if (Letters.indexOf( c ) ==-1) 
        { 
           return false; 
        } 
    } 
    return true; 
}
function trimTxt(txt)
{
   return txt.replace(/(^\s*)|(\s*$)/g, "");
}
//删除购物车中商品
function removeProductOnShoppingCart(id,no)
{
   if(confirm('确定不购买该商品？'))
   {
		window.location.href='removeCart.action?productNo='+no;
   }
}
function cartSave()
{
	var eUserID = <%=userId%>
	if(eUserID==null||eUserID==""||eUserID=="null")
	{
		alert(document.getElementById("youhui").value);
		if(document.getElementById("youhui").value!=""){//如果优惠卷有内容则给出提示
			alert("您好，请登录浩富在线问答!并重新使用优惠券");
		}
		openme();//打开登录界面
	}else{
  		cartForm.submit();
	}
}

/* function totalMoney1(){
	var len = '${cartSize}';
	var totalMoney = 0;
	var preferMoney = 0;
	for(var i = 1;i <= parseInt(len);i++){
     if($("#tr"+i).css("display") != "none"){
    	totalMoney += parseInt($("#orderQuantity_"+i).val()) * parseInt($("#totalPri"+i).html().replace('￥',''));
    	preferMoney += parseInt($("#orderQuantity_"+i).val()) * parseInt($("#preferPri"+i).html());
      }
	}
	$("#totalPrice").html(totalMoney);
    $("#preferPrice").html(preferMoney);
    input=top.document.getElementsByName("preferPrice");    
    input[0].value=preferMoney;
} */

function test(no)
{

	var x = document.getElementById("youhui").value;
	var flag=false;
	var money=0;
	var error="错误的优惠码";
	var myDate=new Date();
	var who=0;
	$.ajax({
		url:'setHome!code.action',
		type:'post',
		data:'',
		dataType:'json',
		success:function(data){
			//alert(data);
		    for (var code in data)
		    {
		        for(var key in data[code])
		        {
		        	if(key=="preferentialno"){
		        		if(x==data[code][key]){
		        			flag=true;
		        			money=data[code]["discountmoney"];
		        			var strs= data[code]["applicableproduct"]; 
		        			var str=strs.split(","); //字符分割   
        					flag=false;
        					error="优惠券不能对该商品使用";
		        			/*  for (var i=0;i<str.length ;i++ )    
		        		    {
		        				if(no.indexOf(str[i])>0)
		        				{
		        					flag=true;
		        				}
		        			}   */
		        			for (var i=0;i<str.length ;i++ )    
		        		    {
		        				if(no==str[i]||no.indexOf(str[i])>=0)
		        				{
		        					flag=true;
		        					if(str[i]=="P0001"){
		        						who=500;
		        					}else if(str[i]=="P0002"){
		        						who=400;
		        					}else if(str[i]=="P0003"){
		        						who=300;
		        					}
		        				}
		        			}   
		        			if(myDate.getTime()<data[code]["startdate"].time){
		        				flag=false;
		        				error="优惠码尚未生效";
		        			}
		        			if(myDate.getTime()>data[code]["enddate"].time){
		        				flag=false;
		        				error="优惠码已过期";
		        			}
		        		}
		        	}
		        }
		    }
		    if(flag){
		    	alert("有效的优惠码,优惠金额:"+money+"元");
		    	var len = '${cartSize}';
				var totalMoney = 0;
				var finalPrice = 0;
				var preferMoney = 0;
				for(var i = 1;i <= parseInt(len);i++){
			     if($("#tr"+i).css("display") != "none"){
			    	totalMoney += parseInt($("#orderQuantity_"+i).val()) * parseInt($("#totalPri"+i).html().replace('￥',''));
			    	preferMoney += parseInt($("#orderQuantity_"+i).val()) * parseInt($("#preferPri"+i).html());
			    	finalPrice = totalMoney-money;
			      }
				}
				$("#coupon").html(-money);
				input1=top.document.getElementsByName("coupon");    
			    input1[0].value=money;
			    $("#preferPrice").html(0);
			    input=top.document.getElementsByName("preferPrice");    
			    input[0].value=0;
				$("#totalPrice").html(totalMoney);
				input=top.document.getElementsByName("totalPrice");    
			    input[0].value=totalMoney;
			    $("#finalPrice").html(finalPrice);
			    input=top.document.getElementsByName("finalPrice");    
			    input[0].value=finalPrice;
		    }else{
		    	alert("错误:"+error);
		    }
		    //alert(str);
		},
		error:function(){
			alert('错误!');
		}
	});
}
function snake(){
	var eUserID = <%=userId%>
	if(eUserID==null||eUserID==""||eUserID=="null")
	{
		if(document.getElementById("youhui").value!=""){//如果优惠卷有内容则给出提示
			alert("请在登陆后重新使用优惠券");
		}
		openme();
	}else{
  		alert("您已经登录");
	}
}


function openme(){
document.getElementById('div1').style.display='block';
document.getElementById('div2').style.display='block';
}
function closeme(){
$('#errorMessages').html("");
document.getElementById('div1').style.display='none';
document.getElementById('div2').style.display='none';
}
function logo_in(){

myform.action="userLogin!myLogin.action"; 
myform.submit();

}

function loadimage() {
	var imgSrc = $("#image");   
    imgSrc.attr("src",'userLogin!validateImage.action?num='+Math.random());
}
//用ajax对是否登录进行后台验证
function denglu(){
	$.ajax({
		url:'userLogin!yanzheng.action',
		type:'post',
		data:'',
		dataType:'text',
		success:function(b){
			if(b=='true'){
				alert("您已经登录");
			}else{
				if(document.getElementById("youhui").value!=""){//如果优惠卷有内容则给出提示
					alert("请在登录后重新使用优惠券");
				}
				openme();
			}
		},
		error:{}
	});
}

function cartSave1()
{
	$.ajax({
		url:'userLogin!yanzheng.action',
		type:'post',
		data:'',
		dataType:'text',
		success:function(b){
			if(b=='true'){
				cartForm.submit();
			}else{
				if(document.getElementById("youhui").value!=""){//如果优惠卷有内容则给出提示
					alert("您好，请登录浩富在线问答!并重新使用优惠券");
				}
				openme();
			}
		},
		error:{}
	});
}

</script>
<jsp:include page="/haufe/common/foot.jsp"/>
</body>
</html>
