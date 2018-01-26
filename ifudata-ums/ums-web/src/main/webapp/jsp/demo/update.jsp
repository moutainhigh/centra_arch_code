<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
var updateManager;
var api = frameElement.api, W = api.opener;
$(document).ready(function(){
	updateManager=new $.UpdateManager();
});
(function(){
	$.UpdateManager=function(){
		this.settings = $.extend(true,{},$.UpdateManager.defaults);
		this.init();
	};
	$.extend($.UpdateManager,{
		defaults:{
			FORM_ID : "#updateForm",
		 UPDATE_URL :"${_base}/demo/update?id=${demoObject.id}"
		},
		prototype:{
			init:function(){
				var _this=this;
				_this.validate();
			},
			validate:function(){
				var _this=this;
				$(_this.settings.FORM_ID).validate({
					onfocusout : function(element) {
						$(element).valid();
					},
					rules : {
						name : {
							required : true
						},
						code : {
							required : true
						},
						city : {
							required : true
						},
						email : {
							required : true
							,email : true
						}
					},
					messages : {
						name : {
							required : "请输入名称"
						},
						code : {
							required : "请输入编码"
						},
						city : {
							required : "请输入城市"
						},
						email : {
							required : "请输入邮箱"
							,email : "不符合邮箱格式"
						}
					}
				});
			},
			update:function(){
				var _this=this;
				var url=_this.settings.UPDATE_URL;
				var param=$(_this.settings.FORM_ID).serialize();
				if($(_this.settings.FORM_ID).valid()){
					$.ajax({
						async: false,
						type:"POST", 
						url:url,
						modal: true,
						showBusi:false, 
						data:param,
						success:function(data){
							var $json=$.parseJSON(data);
							if($json.RES_RESULT=="SUCCESS"){
								$.dialog.alert($json.RES_MSG,function(){
									W.location.reload();
								});
							}else{
								$.dialog.alert($json.RES_MSG,function(){
									W.location.reload();
								});
							}
						}
					});
				}
				return false;
			}
		}
	});
})(jQuery);


</script>
</head>
<body>
	<div>
	<form id="updateForm">
		<div>
			<span>名称</span>
			<span><input type="text" id="" name="name" value="${demoObject.name }"/></span>
		</div>
		<div>
			<span>编码</span>
			<span><input type="text" id="" name="code"  value="${demoObject.code }"/></span>
		</div>
		<div>
			<span>地市</span>
			<span><input type="text" id="" name="city"  value="${demoObject.city }"/></span>
		</div>
		<div>
			<span>邮箱</span>
			<span><input type="text" id="" name="email"  value="${demoObject.email }"/></span>
		</div>
	</form>
	</div>
</body>
</html>