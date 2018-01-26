<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String bp = request.getContextPath();
	request.setAttribute("_base", bp);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>UMS登录界面</title>
<link href="${_base}/ui/css/login.css" rel="stylesheet" type="text/css" />
<%--jquery --%>
<script type="text/javascript" src="<%=bp%>/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=bp%>/js/jquery/jquery-migrate-1.1.0.js"></script>
<%--基于jquery的弹窗 --%>
<script type="text/javascript" src="<%=bp%>/js/jquery/lhgdialog/lhgdialog.min.js?self=true&skin=chrome"></script>
<%--基于jquery的表单校验 --%>
<script type="text/javascript" src="<%=bp%>/js/jquery/validate/jquery.validate.min.js" ></script>
<script type="text/javascript" src="<%=bp%>/js/jquery/validate/jquery.form.js" ></script>
<script type="text/javascript" src="<%=bp%>/js/jquery/validate/additional-methods.js" ></script>
<script type="text/javascript" src="<%=bp%>/js/jquery/validate/localization/messages_zh.js" ></script>
</head>
<body>
<div class="loginBox">
<form id = "form">
  <div class="logo"><span class="left">UMS登录界面</span></div>
  <div class="clear"></div>
  <div class="loginCon">
    <div class="loginCon_left"><img src="${_base}/ui/images/login-pic1.png" width="497" height="392" /></div>
    <div class="loginCon_right">   
      <div class="loginTitle">欢迎用户登录</div>
      <div class="loginFrom">
        <div class="fm-item">
            <label class="fm-label" for="userCode">
                 帐号：
            </label>
            <input id="userCode" name="userCode" value="" class="userName" tabindex="1" type="text" />
        </div>
        <div class="clear"></div>
        <div class="fm-item">
            <label class="fm-label" desc="密码">
                密码：
            </label>
            <span class="alieditContainer">
            <input id="password" name="password" value="" class="password" tabindex="1"
                             type="password" placeholder="" />
            </span>
            </div>
            <div class="clear"></div>
        <div class="fm-item">
            <label class="fm-label" for="veryCode">
                 验证码：
            </label>
            <span class="seccode">
            <input id="veryCode" name="veryCode" type="text" size="10" class="fm-input" />
            <img src="${_base}/verifyCode/getImage" height="35" hspace="8" align="absmiddle" id="imgObj"/>
            </span>
        </div>
      <div class="automatic">
            <label><input type="checkbox"/><var>记住密码</var></label>
            <a href="###">忘记密码?</a>
        </div>
	  <div class="loginBut">
			<input type="button" class="formSubmit" id="logon" value="登录"/>
		</div>
      </div>
    </div>
  </div>
 </form>
</div>
</body>
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
				PASSWORD : "#password"
			},
			prototype : {
				init:function(){
					var _this = this;
					_this.bindEvents();
					$(_this.settings.SUCCESS_ID).hide();
					$(_this.settings.FAILURE_ID).hide();
					_this.changeImg();
					_this.addRults();
					_this.setValue();
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
						//_this.isRightCode();
					});
				},
				logon:function(){
					var _this = this;
					var url="${_base}/login/logon?timestamp="+timestamp;
					var param=$(_this.settings.FORM_ID).serialize();
					if ($(_this.settings.FORM_ID).valid()) {
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
									window.location.href = "${_base}/frame.jsp";
								}else{
									var status = $json.status;
									//alert("登录失败错误代码："+status);
									window.location.href = "${_base}/frame.jsp";
								}
							}
						});
					}
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
						Onubmit:function(element){
							$(element).valid();
						},
						rules:{
							userCode : {
								required : true
							},
							password : {
								required : true
							}
						},
						messages:{
							userCode : {
								required : "用户名不能为空！"
							},
							password : {
								required : "密码不能为空！"
							}
						}
					});
				},
				setValue:function(){
					var _this = this;
					$(_this.settings.USER_CODE).val("admin");
					$(_this.settings.PASSWORD).val("aaaaaa");
				}
			}
		});
	})(jQuery);
</script>
</html>