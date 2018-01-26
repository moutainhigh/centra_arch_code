<%@page import="com.ai.opt.sdk.components.ccs.CCSClientFactory" %>
<%@page import="com.ai.opt.uac.web.constants.Constants" %>
<%@page import="com.ai.opt.sdk.components.mcs.MCSClientFactory" %>
<%@page import="java.util.Locale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
    String _base = request.getContextPath();
    request.setAttribute("_base", _base);
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setHeader("Pragma", "No-cache");

    String _baasBase = _base + "/theme/yc";
    request.setAttribute("_baasBase", _baasBase);

    String default_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.DEFAULT_INDEX_URL_KEY);
    request.setAttribute("default_index_url", default_index_url);
/* String citic_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.CITIC_INDEX_URL_KEY);
request.setAttribute("citic_index_url",citic_index_url );


//System.out.println("[baas_pt_index_url]="+baas_pt_index_url);
String citic_yun_mall_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.CITIC_YUN_MALL_INDEX_URL_KEY);
request.setAttribute("citic_yun_mall_index_url",citic_yun_mall_index_url );
String citic_help_index_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.CITIC_HELP_INDEX_URL_KEY);
request.setAttribute("citic_help_index_url",citic_help_index_url ); */
%>

<!-- UED style begin -->
<link href="${_base}/theme/yc/css/bootstrap/font-awesome.css" rel="stylesheet" type="text/css">
<link href="${_base}/theme/yc/css/iconfont.css" rel="stylesheet" type="text/css">
<link href="${_base}/theme/yc/css/modular/global.css" rel="stylesheet" type="text/css"/>
<link href="${_base}/theme/yc/css/modular/login-regsiter.css" rel="stylesheet" type="text/css"/>
<!-- UED style end -->
<!-- opt-uac -->
<%-- <link href="${_base}/theme/baas/css/opt-uac.css" rel="stylesheet" type="text/css"> --%>
<%-- <script src="${_base}/theme/yc/scripts/modular/jquery-1.10.2.js"></script> --%>
<script src="${_base}/resources/spm_modules/jquery/1.9.1/jquery.min.js"></script>
<%-- <script src="${_base}/resources/spm_modules/bootstrap/dist/js/bootstrap.js"></script>
<script src="${_base}/resources/spm_modules/seajs/2.3.0/dist/sea.js"></script>
<script src="${_base}/resources/spm_modules/seajs/seajs-css.js"></script>
<script src="${_base}/resources/spm_modules/app/core/config.js"></script> --%>
<c:set var="i18nRes" value="${_base}/resources/i18n/"/>

<script type="text/javascript" src="${_base}/theme/yc/js/placeholder.min.js"></script>
<script src="${_base}/resources/spm_modules/jquery-i18n/1.2.2/jquery.i18n.properties.js"></script>
<script>

    <%
    Locale _locale = (Locale)request.getAttribute("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
	if(_locale==null){
		//zh_CN
		_locale=Locale.SIMPLIFIED_CHINESE;
	}
    %>
    var _language = "<%=_locale%>";
    var _base = "${_base}";
    var _i18n_res = "${i18nRes}";
    var currentLan = "<%=response.getLocale()%>";

    $(document).ready(function () {
        $("input").placeholder();
    });
</script>
