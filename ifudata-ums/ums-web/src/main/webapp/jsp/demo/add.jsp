<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ifudata" uri="/WEB-INF/tag/ifudata-tags.tld" %>
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
<script type="text/javascript">
	function testToken(){
		var param ={
	   			groupId: $("#name").val(),
	   			_FORM_TOKEN:$("#toen").val()
		     };
		var url="${_base}/group/wHomeSharedMember/getGroupUsers";
		$.ajax({
			async : false,
			type : "POST",
			url : url,
			modal : true,
			showBusi : false,
			data : param,
			success: function (data) {
				var dateJson = eval("("+data+")");
				if(dateJson.RES_RESULT == 'REPEATFAILED'){
					alert(dateJson.RES_MSG);
				}
			}
		});
	}
</script>
</head>
<body>
	<div>
		<form id="myForm" action="${_base}/group/wHomeSharedMember/getGroupUsers" method="post" class="cmxform">
			<ifudata:formToken id="toen"/>
			<div>
				<span>名称</span> <span><input type="text" id="name" name="name" /></span>
			</div>
			<div>
				<span>编码</span> <span><input type="text" id="code" name="code" /></span>
			</div>
			<div>
				<span>地市</span> <span><input type="text" id="city" name="city" /></span>
			</div>
			<div>
				<span>邮箱</span> <span><input type="text" id="email" name="email" /></span>
			</div>
			<input type="submit" value="submit" />
		</form>
		<a href="javascript:void(0)" onclick="testToken()">提交</a>
	</div>
</body>
</html>