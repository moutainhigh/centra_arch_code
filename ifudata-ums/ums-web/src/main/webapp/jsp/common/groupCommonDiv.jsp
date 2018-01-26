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
				    <td width="10%" height="35"><span class="STYLE4">选择</span></td>
				    <td width="13%" height="35"><span class="lan_zi">群组标识</span></td>
				    <td width="18%" height="35">主号码 </td>
				    <td width="15%" height="35">群组主产品</td>
				    <td width="16%">当前群组成员数</td>
				    <td width="9%">群组成员上限</td>
				    <td width="19%">群组创建时间</td>
				  </tr>
                  
                  <c:forEach items="${groupInfo}" var="group" varStatus="idxStatus" >
		            <%-- <tr align="center"  class="x_bjs">
					    <td>
						    <span class="STYLE1">
						      <label>
						        <input type="radio" name="radio" class="selected" value="${users.serviceNum}" />
						        </label>
						    </span>
					    </td>
					    <td><span class="STYLE1">${users.serviceNum}</span></td>
					    <td height="30"><span class="STYLE1"><ifudata:write dictId="SUBS_USER.SERVICE_STATUS" name="status" scope="value" code="${users.serviceStatus}"></ifudata:write></span></td>
					    <td colspan="2"><span class="STYLE1">${users.joinTime }</span></td>
				  	</tr> --%>
				  	<tr>
					    <td height="35" align="center" valign="middle">
					    	<span class="STYLE1">
						      <label>
						        <input type="radio" name="radio" class="selected" value="${group.serviceNum}" />
						       </label>
						    </span>
					    </td>
					    <td height="35" align="center" valign="middle">${group.groupId }</td>
					    <td height="35" align="center" valign="middle">${group.serviceNum }</td>
					    <td height="35" align="center" valign="middle"><ifudata:write code="${group.mainProductId }" dictId="PM_PRODUCT.PRODUCT_ID" scope="value" name="PRODUCT_ID"></ifudata:write></td>
					    <td height="35" align="center" valign="middle">${group.nowMemberNum }</td>
					    <td height="35" align="center" valign="middle">${group.maxMemberNum }</td>
					    <td height="35" align="center" valign="middle"><fmt:formatDate value="${group.createTime }" pattern="yyyy-MM-dd"/></td>
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
