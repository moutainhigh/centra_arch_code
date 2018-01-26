<%@ page import="com.ai.opt.sdk.components.ccs.CCSClientFactory" %>
<%@ page import="com.ai.opt.sso.util.CacheUtils" %>
<%@ page import="com.ai.yc.common.api.cache.param.AdvertCache" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ai.opt.sdk.components.idps.IDPSClientFactory" %>
<%@ page import="com.ai.paas.ipaas.image.IImageClient" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta property="wb:webmaster" content="d8bcb31352dcbeda"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>login</title>
    <%@ include file="/inc/inc.jsp" %>
    <script type="text/javascript" src="${_baasBase }/js/datacheck.js"></script>

    <%
        String default_editpassword_url = CCSClientFactory.getDefaultConfigClient().get("/default_editpassword_url");
        String default_register_url = CCSClientFactory.getDefaultConfigClient().get("/default_register_url");
        String errorNumCCS = CCSClientFactory.getDefaultConfigClient().get("/errorNum");
        String errorNumTimeOutCCS = CCSClientFactory.getDefaultConfigClient().get("/errorNumTimeOut");
        request.setAttribute("default_editpassword_url", default_editpassword_url);
        request.setAttribute("default_register_url", default_register_url);
        request.setAttribute("errorNumCCS", errorNumCCS);
        request.setAttribute("errorNumTimeOutCCS", errorNumTimeOutCCS);
        String loginType =  request.getParameter("loginType");
        System.out.println("loginType="+loginType);
        request.setAttribute("loginType", loginType);
    %>
</head>
<body class="login-body">

<div class="login-big">
    <form:form method="post" id="fm1" name="fm1" commandName="${commandName}" htmlEscape="true">
        <div class="login-headr">
            <p><a href="${default_index_url}"><img src="${_baasBase}/images/login-logo.png"/></a></p>
                <%--账号登录--%>
            <p class="word"><spring:message code="dom.lables.accountlongin"/></p></div>
        <div class="login-wrapper">
            <div class="login-left">
                <%
                    List<AdvertCache> advertCacheList = CacheUtils.getAdvert(_locale.getLanguage(),"2");
                    if(advertCacheList.size()>0){
                        IImageClient im = IDPSClientFactory.getImageClient(Constants.DEFAULT_IDPS_NAMESPACE);
                %>
                <ul class="slider-pic" id="slider">
                    <% for (AdvertCache advertCache:advertCacheList){%>
                    <li style="background-image:url(<%=im.getImageUrl(advertCache.getThumbnailId(),".png")%>);"><a
                            href="<%=advertCache.getUrl()%>"></a></li>
                    <%
                        }
                    %>
                </ul>
                <ol class="slider-num" id="sliderNum">
                </ol>
                <%
                    }
                %>
            </div>
            <div class="login-right radius">
                    <%--登录--%>
                <div class="login-title"><spring:message code="dom.lables.signin"/></div>
                <div class="login-form-title">
                    <ul>
                        <label id="errorMsg">
                         <c:if test="${loginType == '0'||loginType == '1' }">
                        <form:errors path="*" id="msg" cssClass="errors" element="label" htmlEscape="false"/>
                        </c:if>
                        </label>
                             <%--手机快速登录--%>
                        <p class="right" id="change-login"><i class="icon iconfont">&#xe613;</i><span><spring:message
                                code="dom.lables.mpql"/></span></p>
                    </ul>
                </div>
                <div class="login-form-wrap" login-form-wrap>
                    <div class="login-form" login-form>
                        <ul>
                            <li class="int-border radius">
                                <p class="int-icon"><i class="icon iconfont">&#xe60c;</i></p>
                                <p>
                                    <spring:message code="placeholder.username.tip" var="usernametip"/>
                                    <%-- <form:input cssClass="int-text logon-int" cssErrorClass="error" id="username"
                                                accesskey="${userNameAccessKey}" path="username"
                                                autocomplete="off" htmlEscape="true" placeholder="${usernametip}"/> --%>
                                    <input cssClass="int-text logon-int" cssErrorClass="error" id="username"
                                                accesskey="${userNameAccessKey}" path="username"
                                                autocomplete="off" htmlEscape="true" placeholder="${usernametip}"
                                           style="height: 42px;width: 280px;"/>
                                </p>
                            </li>
                            <li class="int-border radius">
                                <p class="int-icon"><i class="icon iconfont">&#xe609;</i></p>
                                <p>
                                    <spring:message code="placeholder.password.tip" var="passwordtip"/>
                                    <%-- <form:password cssClass="int-text logon-int" cssErrorClass="error" id="password"
                                                   size="25"  path="password"
                                                   accesskey="${passwordAccessKey}"
                                                   htmlEscape="true" autocomplete="off"
                                                   placeholder="${passwordtip}" onkeydown="encryptPwd(event)"/> --%>
                                                   
                                    <input  cssClass="int-text logon-int" cssErrorClass="error" id="password"
                                                   size="25"  path="password" type="password"
                                                   accesskey="${passwordAccessKey}"
                                                   htmlEscape="true" autocomplete="off"
                                                   placeholder="${passwordtip}" onkeydown="encryptPwd(event)"
                                            style="height: 42px;width: 280px;"/>
                                                   
                                </p>
                            </li>
                            <input type="hidden" id="errorNumTimeOutCCS" name="errorNumTimeOutCCS"
                                   value="${errorNumTimeOutCCS}"/>
                            <input type="hidden" id="errorNumCCS" name="errorNumCCS" value="${errorNumCCS}"/>
                            <c:if test="${errorNum>=errorNumCCS}">
                                <li>

                                    <p>
                                        <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                        <input type="text" class="int-text logon-yz-int radius" id="captchaCode"
                                               name="captchaCode" path="captchaCode"
                                               onkeydown="encryptCaptcha(event)"
                                               placeholder="${verifycodetip}" style="width:225px">
                                    </p>
                                    <p>
                                        <spring:message code="dom.lables.codeagain" var="dom.lables.codeagain"/>
                                        <img title="${dom.lables.codeagain}" src="${_base}/captcha/getImageVerifyCode"
                                             id="pictureVitenfy"
                                             onclick="reloadImage('${_base}/captcha/getImageVerifyCode');"
                                             style="margin-left:2px">
                                    </p>
                                </li>
                            </c:if>
                            <li>
                                    <%--注册--%>
                                <p><a href="${default_register_url}"><spring:message code="dom.lables.register"/></a>
                                </p>
                                    <%--忘记密码--%>
                                <p class="right"><a href="${default_editpassword_url}"><spring:message
                                        code="dom.lables.forget"/></a></p>
                            </li>
                            <li>
                                <input type="button" class="btn btn-blue login-btn radius20"
                                       value="<spring:message code="dom.lables.signin"/>"
                                       onclick="javascript:dologin();">
                            </li>
                            <li>
                                    <%--合作账号登录--%>
                                <p><spring:message code="dom.lables.cooperative"/></p>
                                <p class="line"></p>
                            </li>
                            <li>
                                <p><a href="#" class="share share1" other-account></a></p>
                                <p><a href="${BaiduClientUrl}" class="share share2"></a></p>
                                <p><a href="${QQClientUrl}" class="share share3"></a></p>
                                <p><a href="${SinaWeiboClientUrl}" class="share share4"></a></p>
                                <p><a href="${WeiXinClientUrl}" class="share share5"></a></p>
                                <p><a href="${YcTwitterClientUrl}" class="share share6"></a></p>
                                <p><a href="${YcFaceBookClientUrl}" class="share share7 none-ma"></a></p>
                            </li>
                        </ul>
                        <ul>
                            <li class="int-border radius posr">
                                <p class="int-icon"><i class="icon iconfont">&#xe657;</i></p>
                                <select name="selectcountry" id="selectcountry" class="select num-select">
                                    <!-- <option value="">中国 　　　　　　　　　 +86</option>
                                    <option value="">中国 　　　　　　　　　 +86</option> -->
                                </select>
                            </li>
                            <li class="int-border radius">
                                <!--  <p class="int-icon"><i class="icon iconfont">&#xe63c;</i></p>
                                 <p><input type="text" class="int-text logon-int" placeholder="请输入手机号"></p> -->

                                <p class="int-icon"><i class="icon iconfont">&#xe63c;</i></p>
                                <p>
                                    <spring:message code="dom.lables.userphone" var="mobiletip"/>
                                    <form:input cssClass="int-text logon-int" cssErrorClass="error" id="mobile"
                                                accesskey="${mobileAccessKey}" path="mobile"
                                                autocomplete="off" htmlEscape="true" placeholder="${mobiletip}"/>
                                </p>

                            </li>
                            <li>
                                <!-- <p><input type="text" class="int-text logon-yz-int radius" placeholder="请输入验证码"></p>
                                <p><img src="../images/yzm.jpg"></p> -->

                                <p>
                                    <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                    <input type="text" class="int-text logon-yz-int radius" id="mobilecaptchaCode"
                                           name="captchaCode" path="captchaCode"
                                           onkeydown="encryptCaptcha(event)"
                                           placeholder="${verifycodetip}" style="width:225px">
                                </p>
                                <p>
                                    <spring:message code="dom.lables.codeagain" var="dom.lables.codeagain"/>
                                    <img title="${dom.lables.codeagain}" src="${_base}/captcha/getImageVerifyCode"
                                         id="pictureVitenfy"
                                         onclick="reloadImage('${_base}/captcha/getImageVerifyCode');"
                                         style="margin-left:2px">
                                </p>
                            </li>
                            <li>
                                <!-- <p><input type="text" class="int-text logon-yz-int radius" id="mobilepassword" placeholder="请输入验证码"></p>
 -->
                                <p>
                                    <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                    <input type="text" class="int-text logon-yz-int radius" id="mobilepassword"
                                           name="captchaCode" path="captchaCode"
                                           onkeydown="encryptCaptcha(event)"
                                           placeholder="${verifycodetip}" style="width:210px">
                                </p>
                                    <%--                                 <p>
                                                                        <button id="getmobilepassword" onclick="reloadImage('${_base}/captcha/getImageVerifyCode');" class="btn-green btn btn-getcode">获取动态码</button>
                                                                    </p> --%>

                                <p>
                                    <input id="getmobilepassword" type="button" class="btn btn-green btn-280 radius ml-20" value="<spring:message code="dom.lables.getcode"/>">
<%--                                     <input id="getmobilepassword" type="button" class="btn-green btn btn-getcode" value="<spring:message code="dom.lables.getcode"/>"> --%>
                                </p>
                            </li>
                            <li>
                                    <%--注册--%>
                                <p><a href="${default_register_url}"><spring:message code="dom.lables.register"/></a>
                                </p>
                                    <%--忘记密码--%>
                                <p class="right"><a href="${default_editpassword_url}"><spring:message
                                        code="dom.lables.forget"/></a></p>
                            </li>
                            <li>
                                <input type="button" class="btn btn-blue login-btn radius20" onclick="javascript:mobiledologin();" value="<spring:message code="dom.lables.signin"/>">
                                <p class="notice">验证成功则登录，未注册将自动创建译云帐号 </p>
                            </li>
                            <li>
                                    <%--合作账号登录--%>
                                <p><spring:message code="dom.lables.cooperative"/></p>
                                <p class="line"></p>
                            </li>
                            <li>
                                <p><a href="javascript:;" class="share share1" other-account></a></p>
                                <p><a href="${BaiduClientUrl}" class="share share2"></a></p>
                                <p><a href="${QQClientUrl}" class="share share3"></a></p>
                                <p><a href="${SinaWeiboClientUrl}" class="share share4"></a></p>
                                <p><a href="${WeiXinClientUrl}" class="share share5"></a></p>
                                <p><a href="${YcTwitterClientUrl}" class="share share6"></a></p>
                                <p><a href="${YcFaceBookClientUrl}" class="share share7 none-ma"></a></p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </form:form>

    <form:form method="post" id="fm2" name="fm1" commandName="${commandName}" htmlEscape="true">
        <input type="hidden" id="fmUsername" name="username">
        <input type="hidden" id="fmUserpass" name="password">
        <input type="hidden" id="fmCaptchaCode" name="captchaCode">
        <!-- <input type="hidden" name="systemId" "/> -->
        <%--         <input type="hidden" name="systemId" value="<%= request.getParameter("systemId")%>"/> --%>
        <%--* 登录方式--%>
        <%--* 0：普通登录--%>
        <%--* 1：手机快速登录--%>
        <%--* 2：金山登录--%>
        <input type="hidden" id="loginType" name="loginType" value="${loginType}">
        <input type="hidden" id="errorNumTimeOutCCS" name="errorNumTimeOutCCS"
               value="${errorNumTimeOutCCS}"/>
        <input type="hidden" id="errorNumCCS" name="errorNumCCS" value="${errorNumCCS}"/>
        <input type="hidden" id="errorNum" name="errorNum" value="${errorNum}">
        <input type="hidden" name="lt" value="${loginTicket}"/>
        <input type="hidden" name="execution" value="${flowExecutionKey}"/>
        <input type="hidden" name="_eventId" value="submit"/>
        <input type="hidden" name="sessionId" value="<%=request.getSession().getId()%>"/>
    </form:form>
    <!-- 金山账户登录弹窗 -->
    <div class="mask undis" mask></div>
    <div class="account-dialog undis" account-dialog>
        <div class="dialog-content">
            <!-- <p class="tit">金山账号登录</p> -->
            <div class="tit"><spring:message code="dom.lables.kingsoftsignin"/></div>
            <form:form method="post" id="fm3" name="fm1" commandName="${commandName}" htmlEscape="true">
            <div class="login-form-wrap">
                <p class="error" >
                    <c:if test="${loginType == '2' }">
                    <form:errors path="*" id="msg" cssClass="errors" element="label" htmlEscape="false"/>
                    </c:if>
                </p>
                <!-- <p class="error">密码输入错误，请重新输入</p> -->
                <p id="kingsoftLoginValidate" class="error btn" ></p>
                <div class="login-form">
                        <ul>
                            <li class="int-border radius">
                                <p class="int-icon"><i class="icon iconfont">&#xe60c;</i></p>
                                <!--<p><input id="kingsoftusername" type="text" class="int-text logon-int" placeholder="请输入用户名" clearValidate/></p> -->

                                <p>
                                    <spring:message code="placeholder.username.tip" var="usernametip"/>
                                    <%-- <form:input cssClass="int-text logon-int" cssErrorClass="error" id="kingsoftusername"
                                                accesskey="${userNameAccessKey}" path="username"
                                                autocomplete="off" htmlEscape="true" placeholder="${usernametip}"/> --%>
                                     <input cssClass="int-text logon-int" cssErrorClass="error" id="kingsoftusername"
                                                accesskey="${userNameAccessKey}" path="username0"
                                                autocomplete="off" htmlEscape="true" placeholder="${usernametip}" style="height: 42px;width: 280px;"/>
                                </p>
                            </li>
                            <li class="int-border radius">
                                <p class="int-icon"><i class="icon iconfont">&#xe609;</i></p>
                                <p>
                                    <spring:message code="placeholder.password.tip" var="passwordtip"/>
                                    <%-- <form:password cssClass="int-text logon-int" cssErrorClass="error" id="kingsoftpassword"
                                                   size="25"  path="password"
                                                   accesskey="${passwordAccessKey}"
                                                   htmlEscape="true" autocomplete="off"
                                                   placeholder="${passwordtip}" onkeydown="encryptPwd(event)"/> --%>
                                    <input cssClass="int-text logon-int" cssErrorClass="error" id="kingsoftpassword"
                                                   size="25" type="password"
                                                   accesskey="${passwordAccessKey}"
                                                   htmlEscape="true" autocomplete="off"
                                                   placeholder="${passwordtip}" onkeydown="encryptPwd(event)" style="height: 42px;width: 280px;"/>
                                </p>
                            </li>
                            <li>
                            <li>
                                <p>
                                    <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                    <input type="text" class="int-text logon-yz-int radius" id="kingsoftVerifyCode"
                                           name="captchaCode" path="captchaCode"
                                           onkeydown="encryptCaptcha(event)"
                                           placeholder="${verifycodetip}" style="width:225px">
                                </p>
                                <p>
                                    <spring:message code="dom.lables.codeagain" var="dom.lables.codeagain"/>
                                    <img title="${dom.lables.codeagain}" src="${_base}/captcha/getImageVerifyCode"
                                         id="kingsoftpictureVitenfy"
                                         onclick="kingsoftreloadImage('${_base}/captcha/getImageVerifyCode');"
                                         style="margin-left:2px">
                                </p>
                            </li>
                            </li>

                            <li>
                                <input  type="button" class="btn btn-yellow login-btn radius20" onclick="javascript:kinfsoftdologin();" value="<spring:message code="dom.lables.signin"/>">
                                <!--                     <input id="kingsoftLogin" type="button" class="btn btn-yellow login-btn radius20" value="登 录"> -->
                            </li>
                        </ul>

                </div>
            </div>
            </form:form>
            <span class="account-close" account-close></span>
        </div>
    </div>
    <!-- 金山账户登录弹窗结束 -->

</div>
</body>
<script language="javascript" src="${_base}/resources/spm_modules/app/login/messenger.js"></script>
<script language="javascript" src="${_base}/resources/spm_modules/app/login/casLoginView.js"></script>
<script language="javascript" src="${_base}/resources/spm_modules/app/login/mobileLogin.js"></script>
<script type="text/javascript" src="${_base}/theme/yc/scripts/modular/jquery.cycleSlider.js"></script>
<script type="text/javascript" src="${_base}/theme/yc/scripts/modular/login.js"></script>
<script type="text/javascript">
var sendMsg = {
		"resend" : '<spring:message code="sendMsg.resend" />',
		"getcode" : '<spring:message code="dom.lables.getcode" />',
		"sendsuccess":'<spring:message code="sendMsg.success"/>'
	};
    $(function () {
        //初始化登录方式
        showLoginView("${loginType}")
        // 切换登录方式
        $(document).on('click', '#change-login', function () {
            // 手机登录或者普通登录
            if ($(this).hasClass('phone')) {
                showLoginView("1");
            } else {
                showLoginView("0");
            }
        });
        //点击显示金山账号弹窗
        $(document).on('click', '[other-account]', function () {
            showLoginView("2");
        });
        //点击金山账号弹窗关闭按钮
        $(document).on('click', '[account-close]', function () {
            $('[mask]').addClass('undis');
            $('[account-dialog]').addClass('undis');
            //location.reload(_base+'/captcha/getImageVerifyCode4kingsoftLogin');
            $("#loginType").val("0");
        });
        //刷新验证码
        $(document).on('click', '#refreshVerificationCode', function () {
            var _img = $("#refreshVerificationCode");
            var url = _img.attr("src");
            var versionStr = "?version=";
            var index = url.indexOf(versionStr);
            if (index > 0) {
                url = url.substring(0, index);
            }
            url = url + versionStr + new Date().getTime();
            _img.attr("src", url);
        });
        $(document).on('focus', '[clearValidate]', function () {
            $("#kingsoftLoginValidate").html("");
        });
        window.onload = loadCountry;
//        window.onload = loadKingsoft;
    });
    function loadKingsoft() {
        var phone_container = $("#loginType");
        var loginType = document.getElementById('loginType').value
        if (loginType == '2') {
            $('[mask]').removeClass('undis');
            $('[account-dialog]').removeClass('undis');
            $("#loginType").val("2");
        }
    }
    function showLoginView(loginType) {
        // 手机登录或者普通登录
        if ("1" == loginType) {
            $('[login-form]').css({
                'transform': 'translateX(-400px)'
            });
            $('[login-form-wrap]').height('492');
//                普通登录
            $("#change-login").addClass('phone').find('span').text('<spring:message code="dom.lables.clogin"/>');
            $("#change-login").find('.icon').html('&#xe64c;');
            $("#loginType").val("0");
        } else if ("2" == loginType) {
            $('[mask]').removeClass('undis');
            $('[account-dialog]').removeClass('undis');
            $("#loginType").val("2");
        }//普通登录
        else {
            $('[login-form]').css({
                'transform': 'translateX(0)'
            });
            $('[login-form-wrap]').height('388');
//                手机快速登录
            $("#change-login").removeClass('phone').find('span').text('<spring:message code="dom.lables.mpql"/>');
            $("#change-login").find('.icon').html('&#xe613;');
            $("#loginType").val("1");
        }
    }
    //当前语言
    var currentLan = "<%=response.getLocale()%>";
    
    var currentLan = _language;
</script>
</html>











<%-- <%@page import="com.ai.opt.sdk.components.ccs.CCSClientFactory" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta property="wb:webmaster" content="d8bcb31352dcbeda"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>login</title>
    <%@ include file="/inc/inc.jsp" %>
    <script type="text/javascript" src="${_baasBase }/js/datacheck.js"></script>

    <script language="javascript"
            src="${pageContext.request.contextPath}/resources/spm_modules/app/login/messenger.js"></script>
    <script language="javascript"
            src="${pageContext.request.contextPath}/resources/spm_modules/app/login/casLoginView.js"></script>
    <script language="javascript"
            src="${pageContext.request.contextPath}/resources/spm_modules/app/login/mobileLogin.js"></script>
    <%
        String default_editpassword_url = CCSClientFactory.getDefaultConfigClient().get("/default_editpassword_url");
        String default_register_url = CCSClientFactory.getDefaultConfigClient().get("/default_register_url");
        String errorNumCCS = CCSClientFactory.getDefaultConfigClient().get("/errorNum");
        String errorNumTimeOutCCS = CCSClientFactory.getDefaultConfigClient().get("/errorNumTimeOut");
        request.setAttribute("default_editpassword_url", default_editpassword_url);
        request.setAttribute("default_register_url", default_register_url);
        request.setAttribute("errorNumCCS", errorNumCCS);
        request.setAttribute("errorNumTimeOutCCS", errorNumTimeOutCCS);
   
        String loginType =  request.getParameter("loginType");
        request.setAttribute("loginType", loginType);
        System.out.println(loginType);
    
        String systemSource =  request.getParameter("systemSource");
        request.setAttribute("systemSource", systemSource);
        System.out.println(systemSource);
    %>
</head>
<body class="login-body">

<div class="login-big">
    <form:form method="post" id="fm1" name="fm1" commandName="${commandName}" htmlEscape="true">
        <div class="login-headr">
            <p><a href="${default_index_url}"><img src="${_baasBase}/images/login-logo.png"/></a></p>
                账号登录
            <p class="word"><spring:message code="dom.lables.accountlongin"/></p></div>
        <div class="login-wrapper">
            <div class="login-left"><img src="${_baasBase }/images/login-bj.png"></div>
            <div class="login-right radius">
                    登录
                <div class="login-title"><spring:message code="dom.lables.signin"/></div>
                <div class="login-form-title">
                    <ul>
                        <label id="errorMsg"><form:errors path="*" id="msg" cssClass="errors" element="label"
                                                          htmlEscape="false"/></label>
                            手机快速登录
                        <p class="right" id="change-login"><i class="icon iconfont">&#xe613;</i><span><spring:message
                                code="dom.lables.mpql"/></span></p>
                    </ul>
                </div>
                <div class="login-form-wrap" login-form-wrap>
                    <div class="login-form" login-form>
                        <ul>
                            <li class="int-border radius">
                                <p class="int-icon"><i class="icon iconfont">&#xe60c;</i></p>
                                <p>
                                    <spring:message code="placeholder.username.tip" var="usernametip"/>
                                    <form:input cssClass="int-text logon-int" cssErrorClass="error" id="username"
                                                 accesskey="${userNameAccessKey}" path="username"
                                                autocomplete="off" htmlEscape="true" placeholder="${usernametip}"/>
                                </p>
                            </li>
                            <li class="int-border radius">
                                <p class="int-icon"><i class="icon iconfont">&#xe609;</i></p>
                                <p>
                                    <spring:message code="placeholder.password.tip" var="passwordtip"/>
                                    <form:password cssClass="int-text logon-int" cssErrorClass="error" id="password"
                                                   size="25"  path="password"
                                                   accesskey="${passwordAccessKey}"
                                                   htmlEscape="true" autocomplete="off"
                                                   placeholder="${passwordtip}" onkeydown="encryptPwd(event)"/>
                                </p>
                            </li>
                            <input type="hidden" id="errorNumTimeOutCCS" name="errorNumTimeOutCCS"
                                   value="${errorNumTimeOutCCS}"/>
                            <input type="hidden" id="errorNumCCS" name="errorNumCCS" value="${errorNumCCS}"/>
                            <c:if test="${errorNum>=errorNumCCS}">
                                <li>

                                    <p>
                                        <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                        <input type="text" class="int-text logon-yz-int radius" id="captchaCode"
                                                name="captchaCode" path="captchaCode"
                                               onkeydown="encryptCaptcha(event)"
                                               placeholder="${verifycodetip}" style="width:225px">
                                    </p>
                                    <p>
                                        <spring:message code="dom.lables.codeagain" var="dom.lables.codeagain"/>
                                        <img title="${dom.lables.codeagain}" src="${_base}/captcha/getImageVerifyCode"
                                             id="pictureVitenfy"
                                             onclick="reloadImage('${_base}/captcha/getImageVerifyCode');"
                                             style="margin-left:2px">
                                    </p>
                                </li>
                            </c:if>
                            <li>
                                    注册
                                <p><a href="${default_register_url}"><spring:message code="dom.lables.register"/></a>
                                </p>
                                    忘记密码
                                <p class="right"><a href="${default_editpassword_url}"><spring:message
                                        code="dom.lables.forget"/></a></p>
                            </li>
                            <li>
                                <input type="button" class="btn btn-blue login-btn radius20"
                                       value="<spring:message code="dom.lables.signin"/>"
                                       onclick="javascript:dologin();">
                            </li>
                            <li>
                                    合作账号登录
                                <p><spring:message code="dom.lables.cooperative"/></p>
                                <p class="line"></p>
                            </li>
                            <li>
                                <p><a href="#" class="share share1" other-account></a></p>
                                <p><a href="${BaiduClientUrl}" class="share share2"></a></p>
                                <p><a href="${QQClientUrl}" class="share share3"></a></p>
                                <p><a href="${SinaWeiboClientUrl}" class="share share4"></a></p>
                                <p><a href="${WeiXinClientUrl}" class="share share5"></a></p>
                                <p><a href="${YcTwitterClientUrl}" class="share share6"></a></p>
                                <p><a href="${YcFaceBookClientUrl}" class="share share7 none-ma"></a></p>
                            </li>
                        </ul>
                        <ul>
                            <li class="int-border radius posr">
                                <p class="int-icon"><i class="icon iconfont">&#xe657;</i></p>
                                <select name="selectcountry" id="selectcountry" class="select num-select">
                                    <!-- <option value="">中国 　　　　　　　　　 +86</option>
                                    <option value="">中国 　　　　　　　　　 +86</option> -->
                                </select>
                            </li>
                            <li class="int-border radius">
                                <!--  <p class="int-icon"><i class="icon iconfont">&#xe63c;</i></p>
                                 <p><input type="text" class="int-text logon-int" placeholder="请输入手机号"></p> -->

                                <p class="int-icon"><i class="icon iconfont">&#xe63c;</i></p>
                                <p>
                                    <spring:message code="dom.lables.userphone" var="mobiletip"/>
                                    <form:input cssClass="int-text logon-int" cssErrorClass="error" id="mobile"
                                                accesskey="${mobileAccessKey}" path="mobile"
                                                autocomplete="off" htmlEscape="true" placeholder="${mobiletip}"/>
                                </p>

                            </li>
                            <li>
                                <!-- <p><input type="text" class="int-text logon-yz-int radius" placeholder="请输入验证码"></p>
                                <p><img src="../images/yzm.jpg"></p> -->

                                <p>
                                    <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                    <input type="text" class="int-text logon-yz-int radius" id="mobilecaptchaCode"
                                            name="captchaCode" path="captchaCode"
                                           onkeydown="encryptCaptcha(event)"
                                           placeholder="${verifycodetip}" style="width:225px">
                                </p>
                                <p>
                                    <spring:message code="dom.lables.codeagain" var="dom.lables.codeagain"/>
                                    <img title="${dom.lables.codeagain}" src="${_base}/captcha/getImageVerifyCode"
                                         id="pictureVitenfy"
                                         onclick="reloadImage('${_base}/captcha/getImageVerifyCode');"
                                         style="margin-left:2px">
                                </p>
                            </li>
                            <li>
                                <!-- <p><input type="text" class="int-text logon-yz-int radius" id="mobilepassword" placeholder="请输入验证码"></p>
 -->
 								<p>
                                    <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                    <input type="text" class="int-text logon-yz-int radius" id="mobilepassword"
                                            name="captchaCode" path="captchaCode"
                                           onkeydown="encryptCaptcha(event)"
                                           placeholder="${verifycodetip}" style="width:210px">
                                </p>
                                <p>
                                    <button id="getmobilepassword" onclick="reloadImage('${_base}/captcha/getImageVerifyCode');" class="btn-green btn btn-getcode">获取动态码</button>
                                </p>
                            
                                <p>
                                	<input id="getmobilepassword" type="button" class="btn-green btn btn-getcode" value="<spring:message code="dom.lables.signin"/>">
                                </p>
                            </li>
                            <li>
                                    注册
                                <p><a href="${default_register_url}"><spring:message code="dom.lables.register"/></a>
                                </p>
                                    忘记密码
                                <p class="right"><a href="${default_editpassword_url}"><spring:message
                                        code="dom.lables.forget"/></a></p>
                            </li>
                            <li>
                                <input type="button" class="btn btn-blue login-btn radius20" onclick="javascript:mobiledologin();" value="<spring:message code="dom.lables.signin"/>">
                                <p class="notice">验证成功则登录，未注册将自动创建译云帐号 </p>
                            </li>
                            <li>
                                    合作账号登录
                                <p><spring:message code="dom.lables.cooperative"/></p>
                                <p class="line"></p>
                            </li>
                            <li>
                                <p><a href="javascript:;" class="share share1" other-account></a></p>
                                <p><a href="${BaiduClientUrl}" class="share share2"></a></p>
                                <p><a href="${QQClientUrl}" class="share share3"></a></p>
                                <p><a href="${SinaWeiboClientUrl}" class="share share4"></a></p>
                                <p><a href="${WeiXinClientUrl}" class="share share5"></a></p>
                                <p><a href="${YcTwitterClientUrl}" class="share share6"></a></p>
                                <p><a href="${YcFaceBookClientUrl}" class="share share7 none-ma"></a></p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </form:form>

    <form:form method="post" id="fm2" name="fm1" commandName="${commandName}" htmlEscape="true">
        <input type="hidden" id="fmUsername" name="username">
        <input type="hidden" id="fmUserpass" name="password">
        <input type="hidden" id="fmCaptchaCode" name="captchaCode">
       <!--  <input type="hidden" id="fmSystemSource" name="systemSource"> -->
        * 登录方式
        * 0：普通登录
        * 1：手机快速登录
        * 2：金山登录
        <input type="hidden" id="systemId" name="systemId" value="<%=request.getParameter("systemId") %>">
        <input type="hidden" id="loginType" name="loginType" value="${loginType}">
        <input type="hidden" id="errorNumTimeOutCCS" name="errorNumTimeOutCCS"
               value="${errorNumTimeOutCCS}"/>
        <input type="hidden" id="errorNumCCS" name="errorNumCCS" value="${errorNumCCS}"/>
        <input type="hidden" id="errorNum" name="errorNum" value="${errorNum}">
        <input type="hidden" name="lt" value="${loginTicket}"/>
        <input type="hidden" name="execution" value="${flowExecutionKey}"/>
        <input type="hidden" name="_eventId" value="submit"/>
        <input type="hidden" name="sessionId" value="<%=request.getSession().getId()%>"/>
        <input type="hidden" id="errorNumTimeOutCCS" name="errorNumTimeOutCCS"
               value="${errorNumTimeOutCCS}"/>
    </form:form>
    <!-- 金山账户登录弹窗 -->
    <div class="mask undis" mask></div>
    <div class="account-dialog undis" account-dialog>
        <div class="dialog-content">
            <!-- <p class="tit">金山账号登录</p> -->
            <div class="tit"><spring:message code="dom.lables.kingsoftsignin"/></div>
            <div class="login-title"><spring:message code="dom.lables.kingsoftsignin"/></div>
            <div class="login-form-wrap">
                <p class="error btn" >
                    <label id="kingsofterrorMsg"><form:errors path="*" id="msg" cssClass="errors" element="label"
                                                              htmlEscape="false"/>
                </p>
                <!-- <p class="error">密码输入错误，请重新输入</p> -->
                <p id="kingsoftLoginValidate" class="error btn" ></p>
                <div class="login-form">
                    <form:form method="post" id="fm3" name="fm1" commandName="${commandName}" htmlEscape="true">
                    <ul>
                        <li class="int-border radius">
                            <p class="int-icon"><i class="icon iconfont">&#xe60c;</i></p>
                            <!--                     <p><input id="kingsoftusername" type="text" class="int-text logon-int" placeholder="请输入用户名" clearValidate/></p> -->

                            <p>
                                <spring:message code="placeholder.username.tip" var="usernametip"/>
                                <form:input cssClass="int-text logon-int" cssErrorClass="error" id="kingsoftusername"
                                             accesskey="${userNameAccessKey}" path="username"
                                            autocomplete="off" htmlEscape="true" placeholder="${usernametip}"/>
                            </p>
                        </li>
                        <li class="int-border radius">
                            <p class="int-icon"><i class="icon iconfont">&#xe609;</i></p>
                            <p>
                                <spring:message code="placeholder.password.tip" var="passwordtip"/>
                                <form:password cssClass="int-text logon-int" cssErrorClass="error" id="kingsoftpassword"
                                               size="25"  path="password"
                                               accesskey="${passwordAccessKey}"
                                               htmlEscape="true" autocomplete="off"
                                               placeholder="${passwordtip}" onkeydown="encryptPwd(event)"/>
                            </p>
                        </li>
                        <li>
                        <li>
                            <p>
                                <spring:message code="placeholder.verifycode.tip" var="verifycodetip"/>
                                <input type="text" class="int-text logon-yz-int radius" id="kingsoftVerifyCode"
                                        name="captchaCode" path="captchaCode"
                                       onkeydown="encryptCaptcha(event)"
                                       placeholder="${verifycodetip}" style="width:225px">
                            </p>
                            <p>
                                <spring:message code="dom.lables.codeagain" var="dom.lables.codeagain"/>
                                <img title="${dom.lables.codeagain}" src="${_base}/captcha/getImageVerifyCode"
                                     id="kingsoftpictureVitenfy"
                                     onclick="kingsoftreloadImage('${_base}/captcha/getImageVerifyCode');"
                                     style="margin-left:2px">
                            </p>
                        </li>
                        </li>

                        <li>
                            <input  type="button" class="btn btn-yellow login-btn radius20" onclick="javascript:kinfsoftdologin();" value="<spring:message code="dom.lables.signin"/>">
                            <!--                     <input id="kingsoftLogin" type="button" class="btn btn-yellow login-btn radius20" value="登 录"> -->
                        </li>
                    </ul>
                    </form:form>
                </div>
            </div>
            <span class="account-close" account-close></span>
        </div>
    </div>
    <!-- 金山账户登录弹窗结束 -->

</div>
</body>
<script type="text/javascript">
var sendMsg = {
		"resend" : '<spring:message code="sendMsg.resend" />',
		"sendsuccess":'<spring:message code="sendMsg.success"/>'
	};

    $(function () {
        //初始化登录方式
        showLoginView("${loginType}")
        // 切换登录方式
        $(document).on('click', '#change-login', function () {
            // 手机登录或者普通登录
            if ($(this).hasClass('phone')) {
                showLoginView("1");
            } else {
                showLoginView("0");
            }
        });
        //点击显示金山账号弹窗
        $(document).on('click', '[other-account]', function () {
            showLoginView("2");
        });

        //点击金山账号弹窗关闭按钮
        $(document).on('click', '[account-close]', function () {
            $('[mask]').addClass('undis');
            $('[account-dialog]').addClass('undis');
            //location.reload(_base+'/captcha/getImageVerifyCode4kingsoftLogin');
            $("#loginType").val("0");
        });

        //刷新验证码
        $(document).on('click', '#refreshVerificationCode', function () {
            var _img = $("#refreshVerificationCode");
            var url = _img.attr("src");
            var versionStr = "?version=";
            var index = url.indexOf(versionStr);
            if (index > 0) {
                url = url.substring(0, index);
            }
            url = url + versionStr + new Date().getTime();
            _img.attr("src", url);
        });

        $(document).on('focus', '[clearValidate]', function () {
            $("#kingsoftLoginValidate").html("");
        });



        window.onload = loadCountry;
//        window.onload = loadKingsoft;

    });
    function loadKingsoft() {
        var phone_container = $("#loginType");
        var loginType = document.getElementById('loginType').value

        if (loginType == '2') {
            $('[mask]').removeClass('undis');
            $('[account-dialog]').removeClass('undis');
            $("#loginType").val("2");
        }
    }
    function showLoginView(loginType) {
        // 手机登录或者普通登录
        if ("1" == loginType) {
            $('[login-form]').css({
                'transform': 'translateX(-400px)'
            });
            $('[login-form-wrap]').height('492');
//                普通登录
            $("#change-login").addClass('phone').find('span').text('<spring:message code="dom.lables.clogin"/>');
            $("#change-login").find('.icon').html('&#xe64c;');
            $("#loginType").val("0");
        } else if ("2" == loginType) {
            $('[mask]').removeClass('undis');
            $('[account-dialog]').removeClass('undis');
            $("#loginType").val("2");
        }//普通登录
        else {
            $('[login-form]').css({
                'transform': 'translateX(0)'
            });
            $('[login-form-wrap]').height('388');
//                手机快速登录
            $("#change-login").removeClass('phone').find('span').text('<spring:message code="dom.lables.mpql"/>');
            $("#change-login").find('.icon').html('&#xe613;');
            $("#loginType").val("1");
        }
    }

  //当前语言
    var currentLan = "<%=response.getLocale()%>";
    
    var currentLan = _language;
</script>
</html>
 --%>