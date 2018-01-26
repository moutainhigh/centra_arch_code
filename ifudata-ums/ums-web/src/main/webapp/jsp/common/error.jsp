<%@page import="com.ifudata.crm.system.coremodel.SessionInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.log4j.Logger"%>
<%@ page import="java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setStatus(HttpServletResponse.SC_OK);
%>
<%
	String base = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>错误页面</title>
        <link href="<%=base%>/ui/css/css.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<%=base%>/js/jquery/jquery-1.9.1.min.js"></script>
        <script type="text/javascript">
            function showErrorMessage(){
                $("#errorMessage").toggle();
            }
            $(document).ready(function(){
            	window.name=700;
            	showErrorMessage();
            });
        </script>
    </head>
    <body>
    <div class="big_main">ums
	<% 
		Object exceptionObj = request.getAttribute("exception"); 
		if(exceptionObj!=null&&(exceptionObj instanceof com.ifudata.ums.system.exception.BusiException
				||exceptionObj instanceof com.ifudata.ums.system.exception.SystemException)){
	%>
	
		<!--外围边框DIV-->
		<div class="lu_xinx">
			<c:if test="${empty  exception.title}">
				<div class="lu_xinx_A">业务受理失败</div>
			</c:if>
			<c:if test="${!empty  exception.title}">
				<div class="lu_xinx_A">${exception.title}</div>
			</c:if>
		</div>

		<div class="sb_shibai">
			<ul class="sb_icon">
				<li><img src="<%=base%>/ui/images/cr-clew-big.png" width="52" height="46" /></li>
			</ul>
			<ul class="sb_wenz">
				<c:if test="${!empty  exception.code}">
				<li>
						<p class="sb_right">错误代码：</p>
						<p class="sb_xinx">${exception.code}</p>
					
				</li>
				</c:if>
				<li>
					<c:if test="${!empty  exception.message}">
						<p class="sb_right">错误信息：</p>
						<p class="sb_xinx">${exception.message}</p>
					</c:if>
				</li>

				<li>
					<p class="sb_right">详细信息：</p>
					<p class="sb_xinx">
						<span><A href="javascript:showErrorMessage();">（详细信息）</A></span>
					</p>
				</li>
				
				<li class="sb_button" style="display:none"><A href="javascript:void(0)">发送给管理员</A></li>
				<% 
					if(exceptionObj!=null&&exceptionObj instanceof com.ifudata.crm.system.exception.BusiException){
						//处理myOid
						com.ifudata.crm.system.exception.BusiException busi = (com.ifudata.crm.system.exception.BusiException)exceptionObj;
						if(busi.getMyOid()!=null){
							session.removeAttribute(busi.getMyOid());
						}
				%>
				<c:if test="${empty  exception.detail }">
				<li class="sb_xiny" id="errorMessage">
				<%
                    try {
                    	
                        //全部内容先写到内存，然后分别从两个输出流再输出到页面和文件
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        PrintStream printStream = new PrintStream(byteArrayOutputStream);
                        busi.printStackTrace(printStream);
                        printStream.println();

                        out.print(byteArrayOutputStream);    //输出到网页

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                %>
				</li>
				</c:if>
				<c:if test="${!empty  exception.detail }">
				<li class="sb_xiny" id="errorMessage">
					${exception.detail }
				</li>
				</c:if>
				<%
					}else if(exceptionObj!=null&&exceptionObj instanceof com.ifudata.crm.system.exception.SystemException){
						//处理myOid
						com.ifudata.crm.system.exception.SystemException sys = (com.ifudata.crm.system.exception.SystemException)exceptionObj;
								if(sys.getMyOid()!=null){
							session.removeAttribute(sys.getMyOid());
						}
				%>
				<li class="sb_xiny" id="errorMessage">
				<%
                    try {
                    	
                        //全部内容先写到内存，然后分别从两个输出流再输出到页面和文件
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        PrintStream printStream = new PrintStream(byteArrayOutputStream);
                        sys.printStackTrace(printStream);
                        printStream.println();

                        out.print(byteArrayOutputStream);    //输出到网页

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                %>
				</li>
				<%} %>
			</ul>
		</div>
	
	<%}else{ %>
		<div class="lu_xinx">
			<div class="lu_xinx_A">系统异常</div>
		</div>
	<%} %>
	</div>
    </body>
</html>