<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="w" uri="/WEB-INF/tag/page.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/jsp/common/common.jsp"%>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<title>DataTables example</title>

	<style type="text/css">		
			.loading{
				position: absolute;
				width: 300px;
				top: 0px;
				left: 50%;
				margin-left: -150px;
				text-align: center;
				padding: 7px 0 0 0;
				font: bold 11px Arial, Helvetica, sans-serif;
			}
		</style>
	</head>
	<body id="dt_example">
		<div id="container">
			<h1>Page example</h1>
			
			<div class="demo_jui">
			<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
				<thead>
					<tr>
						<th style="width: 100px;">编码</th>
						<th style="width: 100px;">名称</th>
						<th style="width: 100px;">邮箱</th>
					</tr>
					<c:forEach items="${pageInfo.result }" var="demo">
						 <tr>
							<th>${demo.id }</th>
							<th>${ demo.name}</th>
							<th>${demo.email }</th>
						</tr>				
					</c:forEach>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div style="margin-top: 20px;">
				<w:pager pageSize="${ pageInfo.pageSize}" pageNo="${pageInfo.pageNo }" url="${_base}/demo/pageList" recordCount="${pageInfo.count }"/>
			</div>
		</div>
		</div>
		
	</body>
</html>