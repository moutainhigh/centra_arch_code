<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/jsp/common/common.jsp" %>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
$(document).ready(function() {
	$("#commentForm").validate();
});
</script>

<!-- <style type="text/css">
#commentForm { width: 500px; }
#commentForm label { width: 250px; }
#commentForm label.error, #commentForm input.submit { margin-left: 253px; }
</style> -->

</head>
<body>

<form class="cmxform" id="commentForm" method="post" action="">
	<fieldset>
		<legend>Please provide your name, email address (won't be published) and a comment</legend>
		<p>
			<label for="cname">Name (required, at least 2 characters)</label>
			<input id="cname" name="name" class="required" minlength="2" />
		</p>
		<p>
			<label for="cemail">E-Mail (required)</label>
			<input id="cemail" name="email" class="required email" />
		</p>
		<p>
			<label for="curl">URL (optional)</label>
			<input id="curl" name="url" class="url" value="" />
		</p>
		<p>
			<label for="ccomment">Your comment (required)</label>
			<textarea id="ccomment" name="comment" class="required"></textarea>
		</p>
		
		<p>
			<label for="date">date</label>
			<input id="date" name="date" class="required"/>
							<img
								onclick="WdatePicker({el:'date',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								src="../../ui/images/icons/dateOld.gif">
		</p>
		<p>
			<input class="submit" type="submit" value="Submit"/>
		</p>
	</fieldset>
</form>

</body>
</html>