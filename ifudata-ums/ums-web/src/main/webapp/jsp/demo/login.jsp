<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="/jsp/common/common.jsp"%>
<title>登录</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
<meta http-equiv="description" content="This is my page"/>
<script type="text/javascript">
	var timestamp;
	var loginManager;
	$(document).ready(function(){
		loginManager = new $.LoginManager();
	});
	(function(){
		$.LoginManager = function(){
			this.settings = $.extend(true,{},$.LoginManager.defaults);
			this.init();
		};
		$.extend($.LoginManager,{
			defaults:{
				USER_CODE : "#userCode",
				LOGIN_BUTTON : "#logon",
				VERYCODE_INPUT : "#veryCode",
				IMAGE_ID : "#imgObj",
				SWITCH_ID : "#switchImage",
				FORM_ID : "#form",
				SUCCESS_ID : "#success",
				FAILURE_ID : "#failure"
			},
			prototype : {
				init:function(){
					var _this = this;
					_this.bindEvents();
					$(_this.settings.SUCCESS_ID).hide();
					$(_this.settings.FAILURE_ID).hide();
					_this.changeImg();
					_this.addRults();
				},
				bindEvents:function(){
					var _this = this;
					$(_this.settings.LOGIN_BUTTON).bind("click",function(){
						_this.logon();
					});
					$(_this.settings.SWITCH_ID).bind("click",function(){
						_this.changeImg();
					});
					$(_this.settings.IMAGE_ID).bind("click",function(){
						_this.changeImg();
					});
					$(_this.settings.VERYCODE_INPUT).bind("blur",function(){
						_this.isRightCode();
					});
				},
				logon:function(){
					var _this = this;
					var url="${_base}/login/logon?timestamp="+timestamp;
					var param=$(_this.settings.FORM_ID).serialize();
					$.ajax({
						async: false,
						type:"POST", 
						url:url,
						modal: true,
						showBusi:false, 
						data:param,
						success:function(data){
							//$.dialog({title:'数据加载中，请稍后'});
							 var $json=$.parseJSON(data);
							if($json.result=="success"){
								//$("#success").show();
								//$("#failure").hide();
								window.location.href = "${_base}/";
							}else{
								$("#success").hide();
								$("#failure").show();
								var status = $json.status;
								$("#failure").html("登录失败错误代码："+status);
							}
						}
					});
					return false;
				},
				changeImg:function (){  
					var _this = this;
				    var imgSrc = $(_this.settings.IMAGE_ID);     
				    var src = imgSrc.attr("src"); 
				    imgSrc.attr("src",_this.chgUrl(src));
				},
				//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
				chgUrl:function(url){     
				    timestamp = (new Date()).valueOf(); 
				    var urlurl = url.substring(0, url.indexOf("getImage")) + "getImage";
				    urlurl = urlurl + "?timestamp=" + timestamp;     
				    return urlurl;     
				},
				isRightCode:function(){     
					var _this = this;
				    var code = $(_this.settings.VERYCODE_INPUT).val(); 
				    var url = "${_base}/login/validateCode";
				    $.ajax({     
				        type:"POST",     
				        url:url,     
				        data:{"veryCode":code,"timestamp":timestamp},     
				        success:function(data){
				        	var json =$.parseJSON(data);
				        	var status = json.status;
				        	if(status == "0"){
				        		$("#info").html("验证码正确");
				        	}else if(status == '1'){
				        		$("#info").html("验证码为空");
				        	}else if(status == "2"){
				        		$("#info").html("验证码错误");
				        	}
				        }     
				    });     
				},
				addRults:function(){
					var _this = this;
					$(_this.settings.FORM_ID).validate({
						onfocusout:function(element){
							$(element).valid();
						},
						rules:{
							userCode : {
								required : true,
								remote : {
									url : "${_base}/login/validateUserCode",
									data:{
										userCode : function(){
											return $(_this.settings.USER_CODE).val();
										}
									}
								}
							},
							password : {
								required : true
							},
							veryCode : {
								required : true
							}
						},
						messages:{
							userCode : {
								required : "用户名不能为空！"
							},
							password : {
								required : "密码不能为空！"
							},
							veryCode : {
								required : "验证码不能为空！"
							}
						}
					});
				}
			}
		});
	})(jQuery);
</script>
</head>
<body>
	<div style="background-color:#777777;position:relative;left: 200px;top: 200px;width: 400px;height: 250px;">
	<form id = "form" style = "margin-left: 20px;margin-top: 30px;">
		<div >
			<span>用&nbsp;&nbsp;&nbsp;户:</span>
			<span><input type="text" id="userCode" name="userCode" style="width:250px"/></span>
		</div>
		<div>
			<span>密&nbsp;&nbsp;&nbsp;码:</span>
			<span><input type="password" id="password" name="password" style="width:250px"/></span>
		</div>
		<div>
			<span>验证码:</span>
			<span><input id="veryCode" name="veryCode" type="text"/></span>
	        <img id="imgObj"  alt="" src="${_base}/verifyCode/getImage"/>       
	        <a href="#" id ="switchImage">换一张</a>       
	        <div id="info"></div>
		</div>
		
	</form>
		<div style = "margin-top: 10px" align="center">
			<button id="logon" style="margin-right: 40px">登录</button>
			<button id="cancle" style="margin-left: 40px">取消</button>
		</div>
		<div style = "margin-left: 20px;">
			<span id="success">登录成功！</span>
			<span id="failure">登录失败！</span>
		</div>
	</div>
</body>
</html>