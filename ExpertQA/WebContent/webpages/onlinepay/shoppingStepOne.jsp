<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String ctx = request.getContextPath();

%>
<html>
<head>
	<title>订单信息确认</title>
	<script src="<%=ctx%>/interface/javascript/encrypt.js" type="text/javascript"></script>

	<SCRIPT src="<%=ctx%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
	<link href="<%=ctx%>/interface/resource/css/jqueryui/jquery.ui-1.8.css" rel="stylesheet" type="text/css" />
	<link href="<%=ctx%>/interface/resource/css/jnotify/jquery.jnotify.css" rel="stylesheet" type="text/css" />
	<link href="<%=ctx%>/interface/resource/css/tooltips/tip-yellowsimple.css" rel="stylesheet" type="text/css" />
	
    <link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/common.css">
	<link type="text/css" rel="stylesheet" href="<%=ctx%>/interface/resource/css/order/shoppingcart.css">
	<style type="text/css">
	#contactAddForm label.error {
		margin-left: 10px;
		width: auto;
		display: inline;
		color:red;
	}

	</style>
</head>

<body>
	<br />
	<div class="Wrap_cart">
		<div class="List_cart">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="31%"><img src="<%=ctx %>/interface/resource/images/shoppingcart/logo-buy.jpg" width="274" height="52" onclick="location.href='<%=ctx %>/'" style="cursor: pointer;"/></td>
					<td width="69%">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" id="warebuy1">
							<tr>
								<td width="116" align="center" >1.核对订单信息</td>
								<td width="164" align="center" id="current1">2.确认订单支付</td>
								<td width="158" align="center" id="current1">3.支付操作完成 </td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<br />
	<div class="Wrap_cart">
	    <div class = "List_cart2">
	       <h2>易中企业劳动法综合解决方案组件</h2>
	       <hr style="color:#fff;"/>
	       <table class="Table" width="100%" cellspacing="0" cellpadding="14" bordercolor="#AACDED" border="" class="table_02">
                  <tr>
                  	<th height="36" bgcolor="#AACDED" align="left"><em>产品标号</em></th><th bgcolor="#AACDED" align="left"><em>产品名称</em></th>
                  	<th bgcolor="#AACDED" align="left"><em>产品与服务/版本类型</em></th>
                  	<th bgcolor="#AACDED" align="left"><em>产品与服务更新服务</em></th>
                  	<th bgcolor="#AACDED" align="left"><em>市场价格</em></th>
                  	<th bgcolor="#AACDED" align="left"><em>优惠价格</em></th>
                  	<th bgcolor="#AACDED" align="left"><em>订购</em></th>
                  </tr>
                  <s:iterator value="tmp_pro" var="product">
                     <tr id="str<s:property value="index"/>" style="display:">
                    <td width="90" valign="middle"><s:property value="productNo"/></td>
                    <td width="224" valign="middle">
                    	
                            <span style="float:left;"><img alt="" src="<%=ctx %>/interface/resource/images/<s:property value="productImagePath"/>"></span>
                            <span style="text-align:left;"><p>
                            <s:set name="aName" value='productName.split(" ")'></s:set>
                              <b><s:property value="#aName[0]"/></b><br><s:property value="#aName[1]"/></p>
							</span>
                          
                    </td>
                    <td width="220" valign="middle">
                    	<ul>
                    	    <s:set name="aVersion" value='productVersion.split(" ")'></s:set>
                        	<li><img alt="" src="<%=ctx %>/interface/resource/images/q_01.png"><s:property value="#aVersion[0]"/></li>
                            <li><img alt="" src="<%=ctx %>/interface/resource/images/q_02.png"><s:property value="#aVersion[1]"/></li>
                            <s:if test="#aVersion[2] != ''">
                             <li><img alt="" src="<%=ctx %>/interface/resource/images/q_03.png"><s:property value="#aVersion[2]"/></li>
                            <li><img alt="" src="<%=ctx %>/interface/resource/images/q_04.png"><s:property value="#aVersion[3]"/></li>
                            </s:if>
                        </ul>
                    </td>
                    <td valign="middle">
                   	  <div class="sqmfeitd">
                      <em>
                      	<s:set name="aService" value='productService.split(" ")'></s:set>
                      	   <s:property value="#aService[0]"/><br>
                      	   <s:property value="#aService[1]"/><br>
                      	   <s:if test="#aService[2] != ''">
                      	   <s:property value="#aService[2]"/><br>
                      	   <s:property value="#aService[3]"/>
                      	   </s:if>
                      </em>
                      </div>
                    </td>
                    <td><s:property value="payPrice"/></td>
                    <td><s:property value="actualPrice"/></td>
                    <td><a  href="javascript:addProduct('<s:property value="index"/>');">订购</a></td>
                  </tr>
                  </s:iterator>
              
                </table>
	    </div>
	</div>
	<br />
	<div class="Wrap_cart">
		<div class="List_cart">
			<h2><strong>我要购买的商品</strong></h2>
			<div class="cart_table">
			
				<!--商品列表开始-->
				<div id="productList">
					<form id="shoppingCartForm" action="<%=ctx %>/initOnline" method="post">
					<input type="hidden" id="shoppingCartParams" name="shoppingCartParams" value="">
					<input type="hidden" id="postagePrice" name="postagePrice" value="">
					<input type="hidden"  name="orderMasterNo" value="${orderMasterNo}">
					<input type="hidden"  name="orderDetailNo" value="${orderDetailNo}">
					<input type="hidden"  name="linkId" value="${linkId}">
					<table class="Table" id="CartTb" cellpadding="0" cellspacing="0" width="100%">
						<tbody>
							<tr class="align_Center Thead">
								<td style="height: 30px;" width="40%">商品名称</td>
								<td width="15%">市场价</td>
								<td width="15%">优惠价</td>
								<td width="15%">商品数量</td>
								<td width="15%">删除商品</td>
							</tr>
                            <s:iterator value="tmp_pro" var="product">
							
							    <tr id="tr<s:property value="index"/>" class="align_Center" style="background-color: rgb(255, 236, 236);display:;">
									<td class="align_Left" style="padding: 5px 0pt;">
										<span class="p-img"><a href="#none">
											<img src="<%=ctx%>/interface/resource/images/<s:property value="productImagePath"/>" width="50" height="50"></a>
										</span>
										<a href="#none" ><s:property value="productName"/></a>
									</td>
									<td><span style="background-image: url(<%=ctx %>/interface/resource/images/shoppingcart/price-strike.gif);height:16px;line-height:16px;background-repeat: x-repeat;" id="totalPri<s:property value="index"/>">￥<s:property value="payPrice"/></span></td>
									<td><span class="price">￥</span><span class="price" id="preferPri<s:property value="index"/>"><s:property value="actualPrice"/></span></td>
									<td>
										<a href="#none" title="减一" onclick="changeBar('-','<s:property value="index"/>','LDPUTZ');" style="margin-right: 2px;">
											<img style="display: inline;" src="<%=ctx %>/interface/resource/images/shoppingcart/bag_close.gif" border="none">
										</a>
										<input id="orderQuantity_<s:property value="index"/>" name="orderQuantity_<s:property value="index"/>" maxlength="4" style="width: 30px;" 
										onkeydown="if(event.keyCode == 13) event.returnValue = false" value="1"
										onblur="changeProductCount('<s:property value="index"/>',this.value,'LDPUTZ');" type="text">
										<input id="hidChange_<s:property value="index"/>" value="1" type="hidden">
										<a href="#none" title="加一" onclick="changeBar('+','<s:property value="index"/>','LDPUTZ');" style="margin-left: 2px;" >
											<img style="display: inline;" src="<%=ctx %>/interface/resource/images/shoppingcart/bag_open.gif" border="none">
										</a>
									</td>
									<td><a href="#none" id="btn_del_<s:property value="index"/>" onclick="removeProductOnShoppingCart('<s:property value="index"/>')">删除</a></td>
								</tr>
							    </s:iterator>

							<tr id="countPrice">
								<td class="align_Right Tfoot" colspan="7" style="height: 30px;">原始金额：￥<span id="totalPrice">1998</span>元 <br><span style="font-size: 14px;"><b>商品总金额(不含运费)：<span class="price" id="cartBottom_price">￥<span id="preferPrice">1998</span></span>元</b></span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
				
			<!--商品列表结束-->
			<ul class="cart_op" style="margin-bottom: 0px;">
				<li>
					<div id="submit_info"></div>
					<div id="submit_btn" style="float: right;">
						<a id="gotoOrderInfo" href="#none" onclick="submitOrder();"><img style="height:40px;width:100px;" src="<%=ctx %>/interface/resource/images/shoppingcart/submit.jpg"/></a>
					</div>
					<div style="padding-right: 9px; text-align: right; border: 1px solid rgb(255, 255, 255);" id="submit_error">
						<input id="BtnRunOrder_server" style="display: none;" value="提交" type="button">
					</div>
				</li>
			</ul>
		</div>
		<div class="round"><div class="lround"></div><div class="rround"></div></div>
		</div>
	</div>
</body>

<script type="text/javascript">
var indexNo = '${indexNo}';
var productCount = '${productCount}';
var idx = 0;
$(document).ready(function($) {
	var len = '${length}';
	//alert(len);//获取产品表中的数据
    for(var i = 1;i <= parseInt(len); i++){
      if(indexNo.indexOf(i) >= 0){
           $("#str"+i).css("display","none");
           //$("#btn_del_"+i).css("display","none");//所以记录都可以删除
           
           $("#tr"+i).css("display","");
           $("#orderQuantity_"+i).val(productCount.split("#")[idx]);
           idx++;
       }else{
    	   $("#str"+i).css("display","");
    	   
           $("#tr"+i).css("display","none");
           $("#orderQuantity_"+i).removeAttr("name");
       }
    }
    totalMoney();
});
//提交订单
function submitOrder(){
	if(document.getElementById('preferPrice').innerHTML!=''){
		var len = '${length}';
		var cartLenth = 0;
		for(var i = 1;i <= parseInt(len);i++){
			if($("#orderQuantity_"+i).attr("name") != ''){
				cartLenth += parseInt($("#orderQuantity_"+i).val());
			}
		}
		var arr = productCount.split("#");
		var num = 0;
		for(var i = 0;i < arr.length; i++){
           num += parseInt(arr[i]);
		}
		if(cartLenth >= num){
			    $('#shoppingCartForm').submit();
			}else{
				alert('您支付U问易产品的数量不对');
	            return false;
			}
		}else{
			alert('你还没有订购产品！');
			return false;
			}
}
//查看产品详细信息
function showProductDetail(productId) {
	//location.href="<%=ctx%>/product/"+productId;
}
  
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
	var len = '${length}';
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
}
//更改商品数量
function changeProductCount(id,orderQuantity,codeName)
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
function removeProductOnShoppingCart(id)
{
   if(confirm('确定不购买该商品？'))
   {
	$("#tr"+id).css("display","none");
	$("#orderQuantity_"+id).val(1);
	$("#orderQuantity_"+id).removeAttr("name");
	$("#str"+id).css("display","");
	totalMoney();
   }
}
function addProduct(id){
	$("#str"+id).css("display","none");
	
	if($("#tr"+id).css("display") == "none"){
		$("#tr"+id).css("display","");
		$("#orderQuantity_"+id).attr("name","orderQuantity_"+id);
	}
	 totalMoney();
}
</script>
</html>