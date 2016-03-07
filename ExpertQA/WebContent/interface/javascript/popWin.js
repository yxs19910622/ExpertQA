
/**通用删除 修改 等操作提示**/
//判断是否是ie浏览器
var isIE = (navigator.appName.indexOf("Microsoft Internet Explorer")>=0)?true:false;
//funName 反调函数的函数名,prompt 提示,context 內容,parem1 参数1，parem2 参数2 
function showWindow(funName,prompt,context,parem1,parem2){
		var div = dataLoading();
		var opp = createPopWin(funName,prompt,context,parem1,parem2);
		
		document.body.appendChild(div);
		document.body.appendChild(opp);
}
//funName 反调函数的函数名,prompt 提示,context 內容,parem1 参数1 无参数为"",parem2 参数2 无参数为"" 
function createPopWin(funName,prompt,context,parem1,parem2){//
    var openWin = $c("div");
    openWin.style.position = 'fixed';
    openWin.style.top = '50%';
    openWin.style.left = '50%';
    openWin.style.margin = '-140px 0 0 -120px';
    openWin.style.border = '1px solid #cccccc';
    openWin.style.background = '#E6E6E6';
    openWin.style.zIndex = '1001';
    openWin.style.width = '402px';
    openWin.style.height = '152px';
    openWin.id = 'createWindow';
    var html =  '<div style="width:390px;height:140px;border:1px solid #CCCCCC;background-color:#FFFFFF;margin:5px;">'+
     '<div style="background-color:#EEEEEE;width:390px;height:28px;text-align:left;">'+
      '<div style="font-size:16px;color:#000000;padding-top:5px;margin-left:5px;float:left;">'+prompt+'</div><div style="text-align:right;float:right;cursor:pointer;" onclick="closeWin();"><img src="'+path+'/interface/resource/images/pop/del.png"/></div>'+
     '</div>'+
     '<div style="width:390px;height:80px;">'+
      '<div style="float:left;margin-left:25px;margin-top:20px;width:32px;height:32px;background-image:url('+path+'/interface/resource/images/pop/global.png);background-repeat: no-repeat;background-position:-768px -160px;" title="提示:"></div><div style="text-align:center;padding-left:15px;margin-top:28px;font-size:16px;color:red;float:left">'+context+'</div>'+
     '</div>'+
     '<div style="text-align:right;padding-right:20px;">';
      //'<span><input type="button" value="确定" onclick="result(\''+funName+'\',\''+parem1+'\',\''+parem2+'\');"/></span>&nbsp;&nbsp;<span><input type="button" value="取消" onclick="closeWin();"/></span>'+
      if(funName==''){
    	  html += '<span></span>&nbsp;&nbsp;<span onclick="closeWin();"><img src="'+path+'/interface/resource/images/pop/pop_comfirm.gif"/></span>';
      }else{
    	  html += '<span onclick="result(\''+funName+'\',\''+parem1+'\',\''+parem2+'\');"><img src="'+path+'/interface/resource/images/pop/pop_comfirm.gif"/></span>&nbsp;&nbsp;<span onclick="closeWin();"><img src="'+path+'/interface/resource/images/pop/pop_cancel.gif"/></span>';
      }
      html += '</div>';
      html += '</div>';
    openWin.innerHTML =html;
    //document.body.appendChild(openWin);
    //document.body.setChildIndex(openWin,0);
    return openWin;
}
//处理反调函数
function result(funName,parem1,parem2){
 closeWin();
  if(funName != ''){
   if(parem1 == ''&&parem2 == ''){
       eval(funName)();
   }else if(parem1 != ''&&parem2 == ''){
       eval(funName)(parem1);
   }else if(parem1 != ''&&parem2 != ''){
       eval(funName)(parem1,parem2);
   }
  }
}
//关闭窗口
function closeWin(){
    document.body.removeChild($$("divPageMask"));
	document.body.removeChild($$("createWindow"));
}
//创建暗影div
function dataLoading() {
	var h = document.body.scrollHeight;
	var w = document.body.scrollWidth;
	var dv = $c("div");
	dv.id = "divPageMask";
	dv.style.height = h + "px";
	dv.style.width = w + "px";
	dv.style.zIndex = "1000";
	if(isIE){
	  dv.style.filter = "Alpha(Opacity=20)";
	}else{
	  dv.style.opacity = 0.2;
	}
	dv.style.background = "#000000";
	dv.style.top = 0;
	dv.style.left = 0;
	dv.style.position = "absolute";//absolute/relative
	//document.body.appendChild(dv);
	//document.body.setChildIndex(div,3);
	return dv;
}
//简写函数
function $$(id){
 return document.getElementById(id);
}
function $c(elt){
 return document.createElement(elt);
}
//键盘事件
//function   keyDown(){
//alert(event.altKey);
 // if(event.altKey   &&   (event.keyCode   ==   13)){
 //   alert( "成功！ ");
 //  }else{
 //   alert( "失败！ ");
 // }
 //   alert( '实际键为 '   +   event.keyCode);
//}
//document.onkeydown   =   keyDown;