<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String contextPath = request.getContextPath();%>
<html>
<head>
<title>订单信息确认</title>
<link href="<%=contextPath%>/haufe/css/haufe.css" rel="stylesheet" type="text/css"/>
<link href="<%=contextPath%>/haufe/css/common.css" type="text/css" rel="stylesheet">
<link href="<%=contextPath%>/haufe/css/shoppingcart.css" type="text/css" rel="stylesheet">
<link href="<%=contextPath%>/haufe/css/orderInfo.css" type="text/css" rel="stylesheet">
<script src="<%=contextPath%>/haufe/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/haufe/js/script.js" type="text/javascript"></script>
<script src="<%=contextPath%>/interface/javascript/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/interface/javascript/ec_popups.js" type=text/javascript></script>
<script src="<%=contextPath%>/interface/javascript/jquery.validate.js" type="text/javascript"></script>
<script src="<%=contextPath%>/interface/javascript/encrypt.js" type="text/javascript"></script>
<script src="<%=contextPath%>/interface/javascript/jquery.ui-1.8.js" type="text/javascript"></script>
<script src="<%=contextPath%>/interface/javascript/addresslinkage/addressShowList.js" type="text/javascript"></script>

<style type="text/css">
#orderForm label.error {
	margin-left: 10px;
	width: auto;
	display: inline;
	color:red;
}

.wbgPubDiv{border:4px solid #E6EFFA; margin-left:24px; overflow:hidden; padding:8px}
.wbgPubDiv ul{padding:0; margin:0; list-style:none}
.wbgPubDiv ul li{padding:0; margin:0; list-style:none; width:180px; float:left; height:48px; line-height:48px}
.wbgPubDiv ul li img{ border:1px solid #cdcdcd; vertical-align:middle; margin-left:3px}
.wbgimg{ height:68px}
.wbgimg img{ vertical-align:middle}
.popup_box{ width:800px; padding:15px; background:#fff; border:5px solid #444; font-family:Arial,'\5b8b\4f53',sans-serif; -moz-border-radius:10px; -webkit-border-radius:10px; border-radius:10px; -moz-box-shadow:0 0 5px #ccc; -webkit-box-shadow:0 0 5px #ccc; box-shadow:0 0 5px #ccc;}
.popup_box .close{}
.popup_box_head{ height:18px;}
.popup_box_head .h_tl{ font:18px/1 Microsoft Yahei,'\5b8b\4f53',sans-serif; }
.popup_box_head .close{font-style:normal; font:bold 14px/1 Tahoma,'\5b8b\4f53',sans-serif; color:#666; text-decoration:none;}
.popup_box_head .close:hover{ color:#333;}
.popup_box_content{ padding-top:10px; line-height:1.5; font-size:12px; color:#666;}
</style>
</head>
<body>
<jsp:include page="/haufe/common/head.jsp"/>
<div class="content">
    <div class="content-head">在线购买</div>
    <div class="shopping clearfix">
    	<jsp:include page="aside.jsp"/>
    	<div class="main right mycart">
            <div class="Wrap_cart" style="width: 780px">
			<div class="List_cart marginb10" style="width: 780px">
			<h2><strong>填写核对订单信息</strong></h2>
			<div class="cart_table" style="width:740px">
            <p class="step"><img src="<%=contextPath%>/haufe/images/step2.jpg"/></p>
			<form id="orderForm" action="orderPayment.action" method="post">
			<input type="hidden" name="orderMasterNo" value="${orderMasterNo}"/>
			<input type="hidden" name="payType" id="payType" value="100">
			<input type="hidden" name="payBank" id="defaultbank" value="100">
			<input type="hidden" id="userName" value="<s:property value="sysuser.userName"/>">
			<input type="hidden" id="province" value="<s:property value="labuser.company.province"/>">
			<input type="hidden" id="city" value="<s:property value="labuser.company.prefecturelevelCity"/>">
			<input type="hidden" id="area" value="<s:property value="labuser.company.area"/>">
			<input type="hidden" id="street" value="<s:property value="labuser.company.street"/>">
			<input type="hidden" id="mobile" value="<s:property value="sysuser.mobile"/>">
			<input type="hidden" id="telephone" value="<s:property value="labuser.company.telephone"/>">
			<jsp:include page="orderReceipt.jsp"/>
			<jsp:include page="orderPayment.jsp"/>
			<jsp:include page="orderInvoice.jsp"/>
			<jsp:include page="orderRemark.jsp"/>
			<jsp:include page="orderList.jsp"/>
			<jsp:include page="orderInfo.jsp"/>
			</form>
			</div>
			<div class="round"><div class="lround"></div><div class="rround"></div></div>
			</div>
			</div>
        </div>
    </div>
</div>




<jsp:include page="/haufe/common/foot.jsp"/>
</body>
<script type="text/javascript">
var prePrice='22';	//产品优惠价格总和
var contactIdforP=$("input[name=isDefault][value=2]").attr("id");	//取得联系方式ID切换邮费用
var pIdPostagetype="";

var ecPopup = new ec_popups("#popup_box", { withBg: true, closeBtn: "#popup_close", moveArea: "#popup_box" });
ecPopup.init();

//判断是否检查地址
var snake=false;

function checkOther(){
	var flagBank = false;
	var src="";
	$(":radio[id='RadioSon']").each(function () {		
		if($(this).attr("checked")==true)
	    {
		    src= $(this).parent().children('img').attr('src');
			flagBank = true;//用来判断是否有选中项目
	    }else{}
	});
	if(flagBank==true){
		
		 $("img[id='bank']").attr('src',src);
	     $("#bankSelecte").show();
		 $("#bankUnSelecte").hide();
	}
	else{
		 $("#bankUnSelecte").show();
		 $("#bankSelecte").hide();
	}
}

function cancelIt(){
	$(":radio[id='RadioSon1']").attr("checked",false);
}

function  cancelOther(){
	$(":radio[name='other']").attr("checked",false);
	$(":radio[id='RadioSon']").attr("checked",false);
	checkOther();
}
$(function(){
	//点击弹出层确定后，改变其他的内容板块
$("#popup_close").click(function(){
	checkOther();

});
});

$(function(){
	$("input[name=isDefault][value=2]").attr("checked", true);
	//$("input[name=isDefault][value=3]").attr("checked", true);	//为选zhuang
	//$("#inType").text($("#invoice_Unit_TitName").val());	//设置首次加载发票部分展示
	$("#invoinceInfo").hide();
	
	$("#invoinceInfoF").text("不索要发票");	//设置首次加载发票部分展示
});

function invoince_setPttt(ptValue){
	switch(parseInt(ptValue)){
		case 1:
			$('#invoiceInfoEditDiv').show();
			$('#invoiceInfoShowDiv').hide();
			break;
		case 2:
			$('#invoiceDetailInfoShowDiv').hide();
			$("#invoice_Unit_TitName").val('');
			$("#invoinceInfoF").text("不索要发票");
			break;
		case 3:
			$('#invoiceDetailInfoShowDiv').show();
			$("#invoice_Unit_TitName").val('个人');
			$("#invoice_unitNameTr").hide();
			$("#invoinceInfoF").text("索要发票");
			break;
		case 4:
			$("#invoice_Unit_TitName").val('个人');
			$("#invoice_unitNameTr").hide();
			$("#invoice_titleTr").show();
			break;
		case 5:
			$("#invoice_Unit_TitName").val('');
			$("#invoice_unitNameTr").show();
			break;
		} 
}

function isInvoince(){
    var inyn="2";
	var els=$('input[name=isNeedInvoice]');
	for(var i=0;i<els.length;i++){
		if(els[i].value==3&&els[i].checked){
			/* inyn="3"; */
			//有发票了
			snake=true;
		}
	}
	if(inyn=="2")
	{
		$("#invoinceInfo").hide();
		$("#invoinceInfoF").show();
		//$("#invoinceInfoF").text("不索要发票");	//设置首次加载发票部分展示
		$('#invoiceInfoEditDiv').hide();
		$('#invoiceInfoShowDiv').show();
	}
	else if(inyn=="3") 
	{
		if($("#invoice_Unit_TitName").val() == '')
		{
			alert("请输入单位名称！");
			return false;
		}
		else 
		{
			switch(parseInt($("input[name=invoince_pttt][@checked]").val())){
				case 3:
					$("#inType").text("个人");
					break;
				case 4:
					$("#inType").text($("#invoice_Unit_TitName").val());
			}
			$('#invoiceInfoEditDiv').hide();
			$('#invoiceInfoShowDiv').show();
			$("#invoinceInfo").show();
			$("#invoinceInfoF").hide();
		}
	}
}

function savePayTypeAndShipType(){
	$('#payInfoEditDiv').hide();
	$('#payInfoShowDiv').show();
}


//选择非网银直连，网银不选中，选中取消
$("input[type='radio'][name='RadioFather']").each(function()
	{
	 $(this).click(function(){
	 if( $(this).val()!="1000")
	 { 
		 $("input[type='radio'][name='RadioSon']").attr("checked",false);
		 $(":radio[name='other']").attr("checked",false);
	 }
	 });
	});

//选择网银直连莫银行，网银选中，非网银选中取消
$("input[type='radio'][name='RadioSon']").each(function()
	{
	 $(this).click(function(){
		 $("input[type='radio'][name='RadioFather'][value='1000']").attr("checked",true);
	 });
	});



function savePartRemark() {
	var remarkStr=$("#orderRemark").val()==""?"暂无备注":$("#orderRemark").val();
	$("#orderRemarkInfo").html(remarkStr);
	$('#remarkInfoShowDiv').show();
	$('#remarkInfoEditDiv').hide();
}

function doSaveShoppingCart() {
	if($("#orderForm").valid()){
		$(":radio[name='RadioFather']:checked").each(function () {		
			   $("#payType").val($(this).val());
			$(":radio[name='RadioSon']:checked").each(function () {
				   $("#defaultbank").val($(this).val());
				});
		//网银直连需要选择银行否则无法提交
			//var a = document.getElementById("productName").innerHTML;
			/* if($("#userName").val()==null || $("#userName").val()==""){
				alert("请到个人中心填写您的收件人姓名！");
				return false;
			}
			if($("#province").val()==null || $("#province").val()==""){
				alert("请到个人中心填写您完整收件地址！");
				return false;
			}
			if($("#area").val()==null || $("#area").val()==""){
				alert("请到个人中心填写您完整收件地址！");
				return false;
			}
			if($("#street").val()==null || $("#street").val()==""){
				alert("请到个人中心填写您完整收件地址！");
				return false;
			}
			if(($("#mobile").val()==null || $("#mobile").val()=="") && 
					($("#telephone").val()==null || $("#telephone").val()=="") ){
				alert("请到个人中心填写您的联系方式");
				return false;
			}  */
			var tags=document.getElementsByTagName("div");//获取标签
	        
	        for(var i=0;i < tags.length; i++)
	        {
	            if(tags[i].id == "productName"&&tags[i].innerHTML=="浩富管理者劳动法实务手册")
	            {
	            	snake=true;
	            }
	        }
	        if(snake){
	        	if($("#name11111").val()==null || $("#name11111").val()==""){
					openme();
					return;
				}
				if($("#province11111").val()==null || $("#province11111").val()==""){
					openme();
					return;
				}
				if($("#prefecturelevelCity11111").val()==null || $("#prefecturelevelCity11111").val()==""){
					openme();
					return;
				}
				if($("#area11111").val()==null || $("#area11111").val()==""){
					openme();
					return;
				}
				if($("#street11111").val()==null || $("#street11111").val()==""){
					openme();
					return;
				}
				if($("#mobile11111").val()==null || $("#mobile11111").val()==""){
					openme();
					return;
				}  
	        }
	        
	        
			if($("#payType").val()=="1000"){
				var flag = false;
				$(":radio[name='RadioSon']").each(function () {
					if($(this).attr("checked")==true)
				    {
					 flag = true;//用来判断是否有选中项目
				    }else{}		
				});
				if(flag==true){
					$("#pIdPostagetype").val($("#change_postage").val());
					$("#orderForm").submit();
				}
				else{
					alert("您选择了网银支付，请您继续选择要使用的银行");
				    return false;
					}
				}
		//不是网银直连直接提交
			else{
				$("#pIdPostagetype").val($("#change_postage").val());
				$("#orderForm").submit();
			}
			});	
		
	}
}
$("#orderForm").validate({
	rules: {
		payType: {
			required: true
		}
	},
	messages: {
		payType: {
			required: "请选择在线支付方式"
		}
	}
});

/* **** */

 
 var province = document.getElementById("province").value;
 var city = document.getElementById("city").value;
 var area = document.getElementById("area").value;
 addressInit('cmbProvince', 'cmbCity', 'cmbArea',province,city,area);

 function openme(){
 	document.getElementById('div1').style.display='block';
 	document.getElementById('div2').style.display='block';
 	}
 function closeme(){
 	document.getElementById('div1').style.display='none';
 	document.getElementById('div2').style.display='none';
 	}



 function saveUserM(){
 	
 	var userName = $("#userName1").val();
 	var mobile = $("#mobile1").val();
 	var cmbProvince = $("#cmbProvince").val();
 	var cmbCity = $("#cmbCity").val();
 	var cmbArea = $("#cmbArea").val();
 	var street = $("#street11").val();

 	$.ajax({
 		url:'setHome!order_userM.action',
 		type:'post',
 		data:'userName='+userName+'&mobile='+mobile+'&cmbProvince='+
 				cmbProvince+'&cmbCity='+cmbCity+'&cmbArea='+cmbArea+'&street='+street,
 		dataType:'text',
 		success:function(b){
 			if(b=='true'){
 				document.getElementById("name11111").value = userName;
 				document.getElementById("mobile11111").value = mobile;
 				document.getElementById("province11111").value = cmbProvince;
 				document.getElementById("prefecturelevelCity11111").value = cmbCity;
 				document.getElementById("area11111").value = cmbArea;
 				document.getElementById("street11111").value = street;
 				closeme();
 			}else if(b=='userName'){
 				$('#errorMessages').html("姓名不能为空!").show();
 			}else if(b=='mobile'){
 				$('#errorMessages').html("电话不能为空!").show();
 			}else if(b=='cmbProvince'){
 				$('#errorMessages').html("请完整填写地址信息!").show();
 			}else if(b=='cmbCity'){
 				$('#errorMessages').html("请完整填写地址信息!").show();
 			}else if(b=='cmbArea'){
 				$('#errorMessages').html("请完整填写地址信息!").show();
 			}else if(b=='street'){
 				$('#errorMessages').html("请完整填写地址信息!").show();
 			}
 		},
 		error:{}
 	});
 }
 /* **** */
 
 
</script>
</html>
