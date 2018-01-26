<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="generator" content="aisso 1.0" />
</head>
<%
session.invalidate();
String contextPath = request.getContextPath();
String url =  contextPath + "/index.jsp";
%>
<script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" >
	function redirect() {
		var url ="<%=url %>"; 
		window.location.href = url;
	}
	$(document).ready(function() {
		setTimeout("redirect()",80);
	})
</script>
