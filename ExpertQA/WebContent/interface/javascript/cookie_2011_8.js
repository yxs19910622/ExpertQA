/*为不影响旧版本使用，新创建一个cookie.js*/
/*by whz*/
var eUser = null;
var XUsers={isLogind:false,eUserID:"",euserEmail:"",euserName:"",
		LoginHtml:function(user){//用户登录HTML
	return "<span>您好，欢迎来到易中在线问答系统！&nbsp;&nbsp;&nbsp;</span><a target='_blank' href='login' title='请登录'>请登录</a><a target='_blank' href='userRegister' title='免费注册'>免费注册</a>";  
},
LoginedHtml:function(user){
	this.isLogind = true;
	this.eUserID = Cookies.Get("EUserID");
	//this.euserName = Cookies.Get("EUserName");
	this.euserName = Cookies.Decode(Cookies.Get("EUserName"));
	this.euserEmail = Cookies.Get("ELoginName");		
	return "<span>您好，"+user+"</span>&nbsp;&nbsp;<a target='_blank' href='member'>会员中心</a>&nbsp;<a href='logout.action'>退出</a>";
},
Start:function(){
	if(Cookies.Get("EUserID") != "" && Cookies.Get("ELoginName") != null){
		if(Cookies.Get("EUserName") != "" ){
			if(Cookies.Get("EUserName") != "null" && Cookies.Get("EUserName") != null ){
				//document.write(this.LoginedHtml(Cookies.Decode(Cookies.Get("EUserName"))));
				document.write(this.LoginedHtml(Cookies.Get("EUserName")));
			}else{
				document.write(this.LoginedHtml(cutEmail(Cookies.Get("ELoginName"))));
			}				
		}else{
			document.write(this.LoginedHtml(cutEmail(Cookies.Get("ELoginName"))));
		}
	}else{
		document.write(this.LoginHtml(eUser));
	}
}
}

function cutEmail(email){
	var rtn = email;
	var cutPoint = email.indexOf("@");
	if(cutPoint > 0 ){
		rtn = email.substring(0,cutPoint);
	}
	return rtn;
}

var Cookies={
		Decode:function(str){
	var strArr; var strRtn=""; 
	if(str != null){
		if(str.indexOf("a")>1){
			strArr=str.split("a"); 
			for (var i=strArr.length-1;i>=0;i--){strRtn+=String.fromCharCode(eval(strArr[i]));}
		}else{strRtn = String.fromCharCode(str);}
	}else{strRtn = null;}
	return strRtn;
} ,
Code:function(str){
	var strRtn="";
	for (var i=str.length-1;i>=0;i--){
		strRtn+=str.charCodeAt(i);
		if (i) strRtn+="a";
	}
	return strRtn;
},
Get:function(name){   
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg)){return unescape(arr[2]);
	}else{return null;}
},
Set:function(name, value){
	var expdate=new Date();
	var argv=Cookies.Set.arguments;
	var argc=Cookies.Set.arguments.length;
	var expires=(argc>2)?argv[2]:null;
	var path=(argc>3)?argv[3]:null;
	var domain=(argc>4)?argv[4]:null;
	var secure=(argc>5)?argv[5]:false;
	if(expires!=null){ 
		expdate.setTime(expdate.getTime()+(expires*24*3600000));
	}
	document.cookie=name+"="+escape(value)+((expires==null)?"":(";expires="+ expdate.toGMTString()))+((path == null) ? "" : ("; path=" + path)) +((domain == null) ? "" : ("; domain=" + domain))+((secure==true)?";secure":"");
},
Del:function(cookiesname){   
	var exp = new Date();
	exp.setTime(exp.getTime()-1);
	var cval=this.Get(cookiesname);
	if(cval!=null) document.cookie=cookiesname+"="+cval+";expires="+exp.toGMTString();
}  
}