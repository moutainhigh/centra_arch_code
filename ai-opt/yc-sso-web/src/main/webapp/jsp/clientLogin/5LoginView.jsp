<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta property="wb:webmaster" content="d8bcb31352dcbeda"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>login</title>
    <%
        //获取service
        String service = request.getParameter("service");
//        System.out.println("service:"+service);
        int index = service==null?0:service.indexOf("ttype");
//        System.out.println("index:"+index);
        if(index > 0){
            //获取ttype
            String ttype = service.substring(index+6);
//            System.out.println("ttype:"+ttype);
            request.setAttribute("ttype",ttype);
        }
    %>
</head>
<body>
<%--<c:set var="reqTtype" value="${ttype}"/>--%>
<c:set var="clientUrl" value=""/>
<c:choose>
    <c:when test='${ttype == "bd"}'>
        <c:set var="clientUrl" value="${BaiduClientUrl}"/>
    </c:when>
    <c:when test='${ttype == "qq"}'>
        <c:set var="clientUrl" value="${QQClientUrl}"/>
    </c:when>
    <c:when test='${ttype == "wb"}'>
        <c:set var="clientUrl" value="${SinaWeiboClientUrl}"/>
    </c:when>
    <c:otherwise>
        <c:out value="错误的地址"/>
    </c:otherwise>
</c:choose>

    <script type="text/javascript">
        window.onload = function () {
            if(window.console){
                console.log("reqTtype:${ttype},clientUrl:${clientUrl}")
            }
            <c:if test="${clientUrl != ''}">
                window.location.href ="${clientUrl}";
            </c:if>
        }
    </script>

</body>
</html>
