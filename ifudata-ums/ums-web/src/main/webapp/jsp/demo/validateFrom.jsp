<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String bp = request.getContextPath();
	request.setAttribute("_base", bp);
	
	response.setHeader("Cache-Control","no-cache");   
	response.setDateHeader("Expires",0);   
	response.setHeader("Pragma","No-cache");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Test for jQuery validate() plugin</title>

<link rel="stylesheet" media="screen" href="${_base}/js/jquery/validate/css/validate.css" />
<link href="${_base}/ui/css/css.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${_base}/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${_base}/js/jquery/validate/jquery.validate.min.js" ></script>
<script type="text/javascript" src="${_base}/js/jquery/validate/additional-methods.js" ></script>
<script type="text/javascript" src="${_base}/js/jquery/validate/localization/messages_zh.js"></script>
<script type="text/javascript" src="${_base}/js/jquery/validate/commonPrompt.js"></script>

<script type="text/javascript">
$.validator.setDefaults({
	submitHandler: function() { 
		//submitHandler: function() { alert("submitted!"); }
	}
});

$(document).ready(function() {
	//$("#form")._validate();
	 $("#form1").validate({
		onfocusout : function(element) {//element表示当前html标签，获取当前标签的值：$(element).val()
			$(element).valid();
		},
		onfocusin : function(element) {
			//控件获得焦点后 隐藏信息提示DIV
			hideForFloatDiv(element);
		},
		rules: {
			username:{
				required: true,
				minlength: 2
			},
			phone:{
				required: true,
				minlength: 11,
				maxlength:11
			}
		},
		//错误信息位置
		errorPlacement:  function(error,element) {
			//alert("error:"+$(error).text()+",elementval:"+$(element).val());
			//错误信息以浮动DIV提示
			handleErrorForFloatDiv(error, element,'top',200,30);
		},
		success:function(error, element){
			//成功时 移除信息提示DIV
			handleSuccessForFloatDiv(element);
		},
		messages: {
			username: {
				required: "请输入用户名as大夫撒旦!!!",
				minlength: "用户名至少2个字符"
			},
			phone: {
				required: "请输入手机!!!",
				minlength: "手机11个字符"
			}
		}
	});
	 
	 $("#btn").click(function(){
		 showPromptDivByEleId("asdfghjkg", "btn","right",180,40);
	 });
});
</script>


</head>
<body>

<h1 id="banner"><a href="http://bassistance.de/jquery-plugins/jquery-plugin-validation/">jQuery Validation Plugin</a> Demo</h1>
<div id="main">

<p>form验证</p>


<form class="cmxform" id="form1" method="get" action="">
<table>
	<tr><td>用户名:</td><td><input type="text" id="username" name="username"/></td></tr>
</table>
	
	
	<input class="submit" type="submit" value="Submit"/>
</form>
</div>

<button id="btn">CLICK</button>


</body>
</html>
