<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ifudata" uri="/WEB-INF/tag/ifudata-tags.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%
	String bp = request.getContextPath();
	request.setAttribute("_base", bp);
	
	response.setHeader("Cache-Control","no-cache");   
	response.setDateHeader("Expires",0);   
	response.setHeader("Pragma","No-cache");
	
%>
     
	<div  id="queryIdDisplay" >
	 <div class="query_table" >
                <table width="100%" border="0" cellspacing="1">
                  <tr align="center" valign="middle" bgcolor="#e3f0f6" style=" border-top:1px solid #d1d3d5;">
                    <td height="35"><span class="STYLE4">选择</span></td>
                    <td height="35"><span class="STYLE4">服务号码</span></td>
                    <td height="35"><span class="STYLE4">用户状态</span></td>
                    <td>入网时间</td>
                  </tr>
                  <c:forEach items="${userInfo}" var="users" varStatus="idxStatus" >
		            <tr align="center"  class="x_bjs">
					    <td><span class="STYLE1">
					      <label>
					        <input type="radio" name="radio" class="selected" value="${users.serviceNum}" />
					        </label>
					    </span></td>
					    <td><span class="STYLE1">${users.serviceNum}</span></td>
					    <td height="30"><span class="STYLE1"><ifudata:write dictId="SUBS_USER.SERVICE_STATUS" name="status" scope="value" code="${users.serviceStatus}"></ifudata:write></span></td>
					    <td colspan="2"><span class="STYLE1"><fmt:formatDate value="${users.joinTime }" pattern="yyyy-MM-dd"/></span></td>
				  	</tr>	 
				</c:forEach> 
                </table>
              </div>
		      <div class="jiaofei_button">
			    <ul>
			    <li class="query_zhij"><A href="javascript:void(0);" id="comfirmSelected">确定选择</A></li>
			    </ul>
		
		     </div>
		  </div>
