<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page import="org.izhong.expert.util.CookieUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String contextPath = request.getContextPath();
HttpSession sess = request.getSession();
String idx = request.getParameter("indexPage");
Cookie operate = CookieUtil.getCookieByName(request, "operate");
Cookie euserId = CookieUtil.getCookieByName(request, "EUserID");
String oper = operate != null?operate.getValue():"";
%>

<html>
  <head>
  <jsp:include page="/common/common_web.jsp"/>
  <title>浩富-在线工具</title>
    <base href="<%=basePath%>">
	<script type='text/javascript' src='<%=request.getContextPath()%>/interface/javascript/popWin.js'></script>
    <SCRIPT src="<%=request.getContextPath()%>/interface/javascript/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/questionAbs.js'></script> 
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body
	{
	 margin-top: 0px;
	 text-align: center;
	 
	}
	.dive_one
	{
		width: 750px;
		height: 125px;
		margin:0 auto;
	}
	.div_three
	{
	height: 30px;
	width:890px;
	text-align: left;
	font-size:18px;
	margin:0 auto;
	}
	.div_three_one
	{
	float:left;
	height:30px;
	}
	.div_three_two
	{
	float:right;
	height:30px;
	}
	
	.span_one
	{
	 width: 330px;
	 height: 105px;
	 float:left;
	 margin-top:5px;
	
	}
	.span_two
	{
	 width: 330px;
	 height: 105px;
	 margin-top:5px;
	 float:right;
	 margin-left:55px;
	}
	.span_three
	{
		font-size: 18px;
	}
	.span_ten
	{
		width: 330px;
	 	height: 105px;
	 	margin-top:10px;
	 	margin-left:55px;
	}
	table
	{
		border: 0px;
		margin: 0px;
	}
	.table_one 
	{
		width: 328px;
		height: 105px;
		border-style:dashed; 
		border-width:1px; 
		border-color:#CCCCCC;
	}
	.table_one th
	{
		width: 328px;
		height: 25px;
		font-size: 15px;
	}
	.table_one td
	{	
		width: 328px;
		height: 80px;
		top:1px;
		font-size: 12px;
		text-align: left;
	}
	
	a
	{
		color: #185B8D;
		text-decoration: none;
	}
	a:hover{
 	text-decoration:underline;  /*鼠标放上去有下划线*/
	}
	hr
	{
	border: 1px dashed gray; 
	height: 0px;"
	}
	
	</style>

<script type="text/javascript">
var oper = '<%=oper%>';
var user = '<%=euserId%>';
var path = '<%=contextPath%>';

$(document).ready(function() {
	//点击刷新验证码功能
    $('#loginForm img').click(function(){
        //因为浏览器默认会缓存图片，所以只要改变url就可以跳过缓存
        //每次在url后面添加随机数就可以保证url不重复
        this.src='userLogin!validateImage.action?num='+Math.random();
    });
    $(".loginimg").unbind("click").removeAttr("onclick");
   
});

function viewToolHref(href,event){
	/* if(user != 'null'){
	if(containsTxt(oper,'viewAnswer')){ */
	       window.open(href,'_self');
	<%-- }else{
       // alert('权限不够,请申请试用');
		showWindow('','提示信息','很遗憾您的7天试用期已过,<br>要想继续获得权威劳动法专家的咨询答疑,<br>请<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/addCart.action?productNo=P0002">付费购买</a>劳动法顾问软件专业版','','');
	}
}else{
    //alert('你还没有登录');    
    //showWindow('','提示信息','请先<a style="font-size:16px;color:blue;" href="<%=request.getContextPath()%>/login">登录</a>','','');  
	openme(event);
	} --%>
}

function containsTxt(oper,txt){
	if(oper != 'null'){
     var arr = oper.split('#');
     for(var i = 0;i < arr.length; i++){
         if(arr[i] == txt){
          return true;
          }
      }
	}else{
     return false;
	}
}	


</script>
	
	

  </head>
  
  <body >
 <jsp:include page="/common/head.jsp"><jsp:param name="indexPage" value="index" />
</jsp:include>
<div class="margin">
<div class="index_left fl">
	<jsp:include page="/webpages/index/index_statis.jsp"/>
</div>
<div class="index_right fr">
	<jsp:include page="/common/userinfo.jsp"/>
</div>
</div>
  <div class="div_three">
  	<div class="div_three_one" style="width: 40px" >工伤</div><div class="div_three_two" style="width: 850px;" ><hr></div>
  </div>
  
  <div class="dive_one" >
  	<span class="span_one">
  		<table class="table_one" >
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/MyWebApp/V_MyWebApp.html',event)"  >工伤待遇企业支付计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定企业应向工伤职工支付的工伤待遇种类及数额的工具。可依据工伤职工的伤残状态、伤残等级、工伤前的实际工资标准、工伤治疗情况，以及当地最低工资标准等，计算单位应该支付的工伤待遇种类及各种类的金额。</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_two">
  	  	<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/socialSecurityCalculator/V_socialSecurityCalculator.html',event)"  >工伤待遇社保支付计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定社保应向参保工伤职工支付的工伤待遇种类及数额的工具。可依据工伤职工的伤残状态、伤残等级、工伤保险缴费基数、工伤治疗情况，以及当地最低工资标准等，计算社保基金应该向参保工伤职工支付的工伤待遇种类及各种类的金额。</td>
  		</tr>
  		</table>
  	</span>
  </div>
   
  <div class="dive_one" >
  
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/LabourCompensateCalculator/V_labourCompensateCalculator.html',event)"  >工亡赔偿计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定应向工亡职工近亲属支付的工亡待遇种类及数额的工具。可依据工亡职工的工伤保险缴费基数、上年度全国城镇居民人均可支配收入、上年度当地月平均工资，以及需供养无生活来源且无劳动能力亲属状况等，计算应该支付的工亡待遇种类及各种类的金额。</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_ten">
  	</span>
  </div>	
  
  <div class="div_three">
  	<div class="div_three_one" style="width: 220px" >工时、请休假、薪酬与福利</div><div class="div_three_two" style="width: 670px;" ><hr></div>
  </div>
  
  
  <div class="dive_one" >
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/k/V_OvertimeCalculator.html',event)"  >加班费计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定加班费金额的工具。可依据实际月工资标准和加班情况，确定不同情形下加班费的金额和各种情形加班费总额。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_two">
  	  	<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/a/V_dailyHourCalculator.html',event)"  >日工资、小时工资计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定日工资和小时工资标准的工具。可依据实际月工资标准，确定日工资和小时工资的数额。<br/>&nbsp;<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  </div>
  
  
  <div class="dive_one" >
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/f/V_SickPayCalculator.html',event)"  >病假工资计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定法定的最低病假工资数额的工具。可依据当地最低工资标准和病假天数，计算最低应该支付的病假日工资数额和病假期间工资总额。当地和企业规定的病假工资标准高于该结果的，应以相应标准核算员工的病假工资。</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_two">
  	  	<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/e/V_MaternitySalaryCalculator.html',event)"  >产假工资计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定产假期间工资或生育津贴数额的工具。可依据工资标准和生育津贴标准、产假天数等，确定产假期间工资或生育津贴，以及当生育津贴低于工资标准时单位应补足的差额等。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  </div>
  
  <div class="dive_one" >
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/j/V_AnnualLeaveCalculator.html',event)"  >年休假计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定年休假天数的工具。可依据职工工作年限及请假状况，确定是否有资格享受年休假以及可以享受的年休假总天数和剩余天数。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_two">
  	  	<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/h/V_MaternityLeaveCalculator.html',event)"  >产假计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定产假天数和日期的工具。可依据当地晚婚晚育奖励假规定等，确定员工可享受的产假总天数、产假最早可以开始休息日期、产假结束日期。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  </div>
  
    <div class="dive_one" >
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/i/V_AbortionFalseCalculator.html',event)"  >流产假计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定流产假天数和日期的工具。可依据具体流产所属情况，确定员工可享受的流产假天数和结束日期。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_two">
  	  	<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/g/V_PersonalInjuryCalculator.html',event)"  >因私伤病医疗期计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定因私伤病医疗期期限的工具。可依据员工本人实际参加工作年限和在本单位工作年限，确定在一定期限内（与医疗期期限相对应）最多可休病假的累计时间。</td>
  		</tr>
  		</table>
  	</span>
  </div>

  <div class="div_three">
  	<div class="div_three_one" style="width: 290px" >经济补偿、赔偿、违约金与员工赔偿</div><div class="div_three_two" style="width: 600px;" ><hr></div>
  </div>
  
      <div class="dive_one" >
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/d/V_terminateContractCalculator.html',event)"  >解除劳动合同经济补偿金计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定解除劳动合同经济补偿金数额的工具。可依据员工前12个月的实际总收入和本单位工作年限，计算应该支付的经济补偿金额。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_two">
  	  	<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/c/V_removeContractcalculator.html',event)"  >违法解除劳动合同赔偿金计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定违法解除劳动合同赔偿金数额的工具。可依据员工前12个月的实际总收入和本单位工作年限。计算应该支付的赔偿金额。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  </div>
  
     
  <div class="dive_one" >
  
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/b/V_outstandingServiceCalculator.html',event)"  >未完成服务期赔偿金计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定未完成服务期赔偿金额的工具。可依据培训员工所支付的各项费用、约定的服务期期限和未完成的期限，计算员工应该向单位支付的未完成服务期赔偿金额。</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_ten">
  	</span>
  </div>
  
  <div class="div_three">
  	<div class="div_three_one" style="width: 165px" >劳动合同与用工形式</div><div class="div_three_two" style="width: 725px;" ><hr></div>
  </div>
  
  
   <div class="dive_one" >
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/n/V_TwoSalaryCalculator.html',event)"  >未签订书面劳动合同双倍工资差额赔偿计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于核算法定的未签订书面劳动合同二倍工资赔偿数额的工具。可依据实际签订书面劳动合同时间、入职时间等，计算需要赔偿的“二倍工资”差额。<br/>&nbsp;</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_two">
  	  	<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/snake/MyGWT.html',event)"  >解除劳动合同合规诊断器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本诊断器是用于检核解除劳动合同是否合规及是否存在法律风险的工具。请据实、逐一回答本诊断器中提出的问题，诊断器会自动给出诊断报告，告知您解除劳动合同是否合规、是否存在法律风险等。</td>
  		</tr>
  		</table>
  	</span>
  </div>
  
  <div class="div_three">
  	<div class="div_three_one" style="width: 95px" >招聘与试用</div><div class="div_three_two" style="width: 795px;" ><hr></div>
  </div>
  
    <div class="dive_one" >
  
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/m/V_NewStaffCalculator.html',event)"  >新员工试用期计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于确定合法的最长试用期期限的工具。可作为约定实际试用期期限的参照，避免试用期约定违法及相应的法律风险。</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_ten">
  	</span>
  </div>
  
  <div class="div_three">
  	<div class="div_three_one" style="width: 130px" >保密与竞业限制</div><div class="div_three_two" style="width: 760px;" ><hr></div>
  </div>
    
  
    <div class="dive_one" >
  
  	<span class="span_one">
  		<table class="table_one">
  		<tr>
  			<th><a  style="cursor:pointer;" onclick="viewToolHref('/tools/l/V_CompetitionCalculator.html',event)"  >竞业限制补偿计算器</a></th>
  		</tr>
  		<tr>
  			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;说明：本计算器是用于计算竞业限制补偿金额的工具。可依据是否约定补偿标准、实际已履行的竞业限制时间等，确定应该支付的竞业限制补偿金额。</td>
  		</tr>
  		</table>
  	</span>
  
  	<span class="span_ten">
  	</span>
  </div>
  

 <script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fa09e65c0298d6436d463ed33dd67ba1c' type='text/javascript'%3E%3C/script%3E"));
</script> 
  </body>
</html>
