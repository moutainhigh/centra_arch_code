<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String _base = request.getContextPath();
	request.setAttribute("_base", _base);
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "No-cache");

	String _baasBase = _base + "/theme/yeekit";
	request.setAttribute("_baasBase", _baasBase);
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="icon" type="image/x-icon" href="/favicon.ico">
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
	<title>YeeKit</title>
	<link rel="stylesheet" type="text/css" href="${_baasBase}/css/login.min.css">
	<style type="text/css">
		.login-wrapper .form-container .login-left .login-title {
			width: 100%;
		}
		.login-wrapper .form-container .login-left .login-title .icon-tri {
			left: 47%;
		}
	</style>
	<script type="text/javascript" src="https://at.alicdn.com/t/font_joxqevkvh01qncdi.js" async></script>
</head>
<body>
<div class="login-wrapper">
	<div class="part-top">
		<div class="logo-container">
			<a href="https://beta.yeekit.com" title="CAT"><img class="top-logo" src="${_baasBase}/images/yeekit.png" alt=""></a>
			<div class="top-slogan">更快捷，更简单，更智能</div>
		</div>
	</div>
	<div class="padBottom">
		<div class="form-container clearfix">
			<div class="login-left">
				<div class="login-form">
					<%--<form method="post" id="loginForm">--%>
					<form:form method="post" id="fm1" name="fm1" commandName="${commandName}" htmlEscape="true">
						<%--<div id="msg" class="meg_errors color">用户名或密码错误，请核对</div>--%>
						<div id="msg" class="meg_errors color"><form:errors path="*" id="msg" cssClass="errors"
																			element="label" htmlEscape="false"/></div>
						<div class="login-total">
							<div class="login-title active" data-id="1">用户登录
								<i class="icon-tri"></i>
							</div>
							<!-- <div class="login-title" data-id="0"><spring:message code="10010" />
							<i class="icon-tri"></i>
						</div> -->
						</div>
						<div>
							<div class="input-wrap">
								<svg class="icon input-icon" aria-hidden="true">
									<use xlink:href="#icon-denglu_yonghu"></use>
								</svg>
								<input type="text" id="username" name="username" onblur="checkName(this);"
									   placeholder="用户名">
								<p class="err">
									<svg class="icon" aria-hidden="true">
										<use xlink:href="#icon-cuowu"></use>
									</svg>
									用户名长度为6~12位
								</p>
							</div>
							<div class="input-wrap">
								<svg class="icon input-icon" aria-hidden="true">
									<use xlink:href="#icon-denglu_mima"></use>
								</svg>
								<input type="password" id="password" name="password" placeholder="密码">
								<p class="err">
									<svg class="icon" aria-hidden="true">
										<use xlink:href="#icon-cuowu"></use>
									</svg>
									请输入密码
								</p>
							</div>
							<p><a id="forgetUrl" href="https://dev.yeekit.com/ucenter/forget?locale=zh">忘记密码</a></p>
							<input class="button login-btn login-func" type="submit" name="submit" value="登录"/>
							<div class="form-bottom">还没有Yeekit账号？
								<a id="registUrl" href="https://dev.yeekit.com/ucenter/regist">立即注册</a>
								<svg class="icon next" aria-hidden="true">
									<use xlink:href="#icon-shangyibu"></use>
								</svg>
							</div>
						</div>
						<input type="hidden" name="loginType" value="0">
						<input type="hidden" name="errorNumTimeOutCCS"/>
						<input type="hidden" id="errorNumCCS" name="errorNumCCS" value="100"/>
						<input type="hidden" id="errorNum" name="errorNum" value="0">
						<input type="hidden" name="lt" value="${loginTicket}"/>
						<input type="hidden" name="execution" value="${flowExecutionKey}"/>
						<input type="hidden" name="_eventId" value="submit"/>
						<input type="hidden" name="sessionId" value="<%=session.getId()%>"/>
					</form:form>
					<%--</form>--%>
				</div>
			</div>
			<div class="line-box">
				<p class="line"></p>
				<p class="or">or</p>
				<p class="line"></p>
			</div>
			<div class="login-right" id="login-0">
				<div class="login-right-img">
				</div>
				<ul class="yeekit-tips">
					<li>快速创建项目实施项目进度跟踪</li>
					<li class="nodis">团队即时沟通管理协同方便快捷</li>
					<li class="nodis">语料沉淀、导出共享事半功倍</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="part-bottom">
		<div class="entry-item" >
			<div class="entry-icon" style="background: url(${_baasBase}/images/icon-align.png) no-repeat transparent;"></div>
		  	<div class="entry-des">平行语料对齐</div>
		</div>
		<div class="entry-item" >
			<div class="entry-icon" style="background: url(${_baasBase}/images/icon-library.png) no-repeat transparent;"></div>
			<div class="entry-des">个人预料管理中心</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${_baasBase}/js/jquery.min.js"></script>
<script type="text/javascript" src="${_baasBase}/js/login.js"></script>
<script type="text/javascript">
    var locale = "${param.locale}";
    var registUrl = $("#registUrl").attr("href");
    var forgetUrl = $("#forgetUrl").attr("href");
    if(locale){
        registUrl = registUrl+"?locale="+locale;
        forgetUrl = forgetUrl+"?locale="+locale;
        $('#registUrl').attr('href',registUrl);
        $('#forgetUrl').attr('href',forgetUrl);
    }
    (function(){
        var bgCounter=0,
            backgrounds=[
                "${_baasBase}/images/prlogin1.png",
                "${_baasBase}/images/prlogin2.png",
                "${_baasBase}/images/prlogin3.png"
            ];
        for(var i=0;i<backgrounds.length;i++){
            var img=new Image();
            img.src=backgrounds[i];
        }
        function changeBackground(){
            bgCounter=(bgCounter+1)%backgrounds.length;
            $('.login-right-img').css('background','#fff url('+backgrounds[bgCounter]+') no-repeat');
            $('.yeekit-tips li').eq(bgCounter).show().siblings('li').hide();
            setTimeout(changeBackground, 3000);
        }
        changeBackground();
    })();
</script>
</body>
</html>
