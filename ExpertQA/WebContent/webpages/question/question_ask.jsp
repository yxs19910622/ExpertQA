<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String contextPath = request.getContextPath();%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=contextPath%>/interface/resource/css/style.css" />
<jsp:include page="/common/operamasks.jsp"/>
<script type="text/javascript" src="<%=contextPath%>/interface/compontents/operamasks-ui/editor/omeditor.js"></script>
<title>浩富问答-我要提问</title>
</head>
<body>
<jsp:include page="/common/head.jsp">
<jsp:param name="indexPage" value="index" />
</jsp:include>
<script>
var test = window.location.search;
var flag = test.replace("?","");
if(flag.length>15){
	window.location.href = "init_qustion.action?"+flag;
}


$(function(){
	var config = {
		toolbar_MyToolbar:[
			{ name: 'document', items : [ 'Preview' ] },
			{ name: 'styles', items : [ 'Styles','Format','Font','FontSize','TextColor'] },
			{ name: 'basicstyles', items : [ 'Bold','Italic','Strike','-','RemoveFormat' ] }
		],
		toolbar:'MyToolbar'};
		$('#questionContent').omEditor(config,{resizable:false});
}); 
function addOneQuestion(status){
	var lei = document.getElementById("select_a").value;
	if(lei == ''){
        showWindow('','提示信息','请输入选择一个问题分类','',''); 
        document.getElementById("select_a").focus();
        return;
	}
	var title = document.getElementById("title").value;
	if(title == ''){
        showWindow('','提示信息','请输入问题的标题','',''); 
        document.getElementById("title").focus();
        return;
	}
	var questionContent = $('#questionContent').omEditor('getData');
	if(questionContent=='' || questionContent<=0)
	{
		showWindow('','提示信息','请输入问题的内容','','');
		return;
	}
	var select = document.getElementById('select_a').value;
	document.getElementById('qaTypeID').value = select;
	document.getElementById("status").value=status;
	addQuestionForm.submit();
}

//验证是否存在敏感词汇
function checking(){
	var title = document.getElementById("title").value;
	var questionContent = $('#questionContent').omEditor('getData');
	var flag = true;
	$.ajax({
		url:'setHome!wordsCheck.action',
		type:'post',
		data:'',
		dataType:'json',
		success:function(data){
			for (var i=0;i<data.length;i++) {
				if(data[i]!=null&&data[i]!=""){
					if ((title.indexOf(data[i])!=-1)||(questionContent.indexOf(data[i])!=-1)){
						alert("您的发言不符合国家互联网法律,请检查后再提交!");
						flag=false;
					}
				}
			}
			if(flag){
				addOneQuestion('4');
			}
		}
	});
}
	
</script>
<div class="margin">
<jsp:include page="/webpages/question/question_ask_ad.jsp"/>
	<div class="index_left fl">
		<div class="question_left">
			<form action="addQuestion.action" id="addQuestionForm" method="post">
			<div class="question_body">
				<h4>选择问题分类&nbsp;</h4>
            	<select id="select_a" style="width: 360px;">
            	<option value="">--请选择问题分类--</option>
            	<s:if test="lstTypeParent!=null">
            		<s:iterator value="lstTypeParent" id="parent">
            			<option value="<s:property value='qaTypeID'/>"><s:property value="qaTypeName"/></option>
            			<s:iterator value="lstTypeChild" id="child">
            				<s:if test="#parent.qaTypeID==#child.parentTypeID">
            					<option value="<s:property value='qaTypeID'/>">┣<s:property value="qaTypeName"/></option>
            				</s:if>
            			</s:iterator>
            		</s:iterator>
            	</s:if>
            	</select>
                <h4>问题标题</h4>
                <input id="title" type="text" value="" name="question.captionText" class="input_06" />
                <h4>问题详细描述</h4>
				<textarea id="questionContent" name="question.questionContent"></textarea>
				<input type="button" value="" class="input_07" onclick="checking();" /><!-- addOneQuestion('1') -->
                <input id="saveButton" type="button" class="input_saveQuestion" onclick="addOneQuestion('2');" />
			</div>
			<input type="hidden" id="qaTypeID" name="question.qaTypeID"/>
			<input type="hidden" id="status" name="question.isAlreadyChecked"/>
			</form>
		</div>
	</div>
	<div class="index_right fr">
		<jsp:include page="/common/userinfo.jsp"/>
		<jsp:include page="/webpages/index/index_announcement.jsp"/>
		<jsp:include page="/webpages/index/index_ad.jsp"/>
		<jsp:include page="/webpages/index/index_weibo.jsp"/>
		<jsp:include page="/webpages/index/index_expert.jsp"/>
		<jsp:include page="/common/static/activeUser_static.jsp"/>
	</div>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>