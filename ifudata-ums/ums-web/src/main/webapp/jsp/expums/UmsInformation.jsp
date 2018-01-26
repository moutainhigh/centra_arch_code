<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/jsp/common/common.jsp"%>

<link href="${_base}/ui/css/css.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" charset="utf-8">
/* 按页码查询  */
function search(pageNo) { 
	debugger;
	var fileName_paramJ = $("#fileName_paramJ").val(); //把java传来的值赋给一个变量
//	var phoneNum_paramJ = $("#phoneNum_paramJ").val(); 
	
	if($.trim(fileName_paramJ)=='') {
		fileName_paramJ = '';
	}  
	
	/* 调用父页面 UmsFileName.jsp中controller的 FileNameQuery(pageNo, fileName_paramJ); */ 
	controller.FileNameQuery(pageNo, fileName_paramJ);//调用查询函数
}

 
</script>

<!--  列表页面 -->
<div class="query_table">
	<!-- 错误信息提示 -->
	<div style="display: none;"> 
		<input type="hidden" id="fileName_paramJ" value="${fileName_paramJ }" />  
		<!--  <input type="hidden" id="phoneNum_paramJ" value="${phoneNum_paramJ }" />  -->
	</div>
	  <a   style="color:red;font-size:25px;width:6cm" >
	<c:if test="${listSize==0 }">未查询到文件为${fileName_paramJ }的信息，请确认文件名。</c:if> 
	</a> 

	<a style="color:red;font-size:25px;width:6cm" >
	<c:if test="${listSize==1 }">订单未处理完成，请稍后再试。</c:if> 
	</a>
	<div class="big_title">
		<p>查询结果:</p>
	</div>
	<table width="100%" border="0" cellspacing="1">
		<tr align="center" class="bjwu" valign="middle" bgcolor="#e3f0f6"
			style="border-top: 1px solid #d1d3d5; font:bolder">

			<td height="35" width="15%"><span class="STYLE4"><b>批次号</b></span></td>
			<td height="35" width="15%"><span class="STYLE4"><b>电话号码</b></span></td>
			<td height="35" width="25%"><span class="STYLE4"><b>短信内容</b></span></td>
			<td height="35" width="15%"><span class="STYLE4"><b>发送状态</b></span></td>
			<td height="35" width="10%"><span class="STYLE4"><b>回执状态</b></span></td> 
			<td height="35" width="10%"><span class="STYLE4"><b>发送时间</b></span></td>
			<td height="35" width="10%"><span class="STYLE4"><b>回执时间</b></span></td>
		</tr>

		<c:forEach items="${pageInfo.result }" var="data1" varStatus="status1">
			
			<tr>
				<td height="35" align="center" valign="middle">${data1.batchId }</td>
				<td height="35" align="center" valign="middle">${data1.phoneNum }</td>
				<td height="35" align="center" valign="middle">${data1.smsContent }</td> 
				<td height="35" align="center" valign="middle">
				<c:choose> 
				<c:when test="${data1.sendFlag==0 }">未处理</c:when>
				<c:when test="${data1.sendFlag==1 }">发送成功</c:when>
				<c:when test="${data1.sendFlag==2 }">发送失败</c:when>
				<c:when test="${data1.sendFlag==3 }">待重发</c:when>
				<c:when test="${data1.sendFlag==4 }">准备发送</c:when>
				<c:when test="${data1.sendFlag==5 }">准备发送</c:when>
				<c:otherwise>${data1.sendFlag }</c:otherwise>
				</c:choose> 
				</td>  
				<td height="35" align="center" valign="middle"> 
				<c:choose>
				<c:when test="${data1.reportFlag==0 }">待接收 </c:when>
				<c:when test="${data1.reportFlag==1 }">短信发送成功</c:when>
				<c:when test="${data1.reportFlag==2 }">短信发送失败</c:when>
				<c:when test="${data1.reportFlag==3 }">接收回执超时</c:when>
				<c:otherwise>${data1.reportFlag }</c:otherwise>
				</c:choose>
				</td>  
				<td height="35" align="center" valign="middle"><fmt:formatDate   value="${data1.sendTime }"  pattern="yyyy/MM/dd HH:mm:ss" /></td>
				<td height="35" align="center" valign="middle"><fmt:formatDate   value="${data1.reportTime }"  pattern="yyyy/MM/dd HH:mm:ss" /></td> 
			</tr>
		</c:forEach>
	</table>
</div>
<!------分页控件----->
<div class="main_C_fenye">
	<%@ include file="/jsp/common/page.jsp"%>
</div>
