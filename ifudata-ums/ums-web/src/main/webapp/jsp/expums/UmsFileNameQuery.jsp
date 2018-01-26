<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/jsp/common/common.jsp"%>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title>短信状态查询</title>
<link href="${_base}/ui/css/css.css" rel="stylesheet" type="text/css" />
<script src="${_base}/ui/js/nav.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${_base}/js/jquery/validate/jquery.form.js"></script>
<script type="text/javascript" src="${_base}/js/jquery.pagController.js"></script>
<script type="text/javascript" src="${_base}/js/json2.js"></script>
<link rel="stylesheet" href="${_base}/js/jquery/jPages/css/jPages.css">
<script type="text/javascript"
	src="${_base}/js/jquery/jPages/js/jPages.min.js">
</script>
<style type="text/css">
.mask {
	background: #000;
	filter: alpha(opacity = 50); /* IE的透明度 */
	opacity: 0.5; /* 透明度 */
	-moz-opacity: 0.5;
	display: none;
	position: absolute;
	top: 0px;
	left: 0px;
	z-index: 100; /* 此处的图层要大于页面 */
}
</style>

<script type="text/javascript" charset="utf-8">
	var controller;
	$(document).ready(function() {
		controller = new $.FileNameQueryController();
	});
	//提交按钮事件
	(function() {
		$.FileNameQueryController = function() {
			this.settings = $.extend(true, {}, $.FileNameQueryController.defaults);
			this.init();
		};
		
		$.extend($.FileNameQueryController, {
			defaults : { 
				FILENAME_QUERY_DIV : "#fileNameQueryDiv",
				fILENAME_QUERY_LIST : "#fileNameQueryList",// 查询
				QRY_BTN : "#qryBtn",//查询按钮 
				FILE_NAME : "#fileName" ,//文件名
				//PHONE_NUM : "#phoneNum",
			},
			prototype : {
				init : function() {
					var _this = this;
					_this.bindEvents();
				},
				bindEvents : function() {
					var _this = this;
					/* 查询按钮 */
					$(_this.settings.QRY_BTN).bind("click", function() {
						_this.FileNameQuery(1);
					});
				},

				// 查询 ums_send_status
				FileNameQuery : function(pageNo, fileName_paramJ) {
					debugger;
					if (isNull("fileName")) {
						$.dialog.alert("文件名不可以为空！");
						return false;
					}
					var _this = this;
					var fileName = $(_this.settings.FILE_NAME).val(); 
				
					/* 如果传来 查询关键字记录， 说明只是分页，仍按照 旧关键字进行查询 */
					if (typeof (fileName_paramJ) != "undefined") {
						fileName = fileName_paramJ;
					}
				/*	var phoneNum = $(_this.settings.PHONE_NUM).val();
				    if (typeof (phoneNum_paramJ) != "undefined") {
						phoneNum = phoneNum_paramJ;
					}
					if(isNaN(phoneNum)) {
						$(_this.settings.PHONE_NUM).val("电话号码ID要求为数字");
						return;// 校验不通过，则停止
					}*/ 
					
					var tips = null;
					if ($.dialog) 
					{
						tips = $.dialog.tips('正在查询文件列表...', 6, 'loading.gif');
					} 
					var param = {};
					param.fileName = fileName; 
					//param.phoneNum = phoneNum; 
					if (pageNo) 
					{
						param.pageNo = pageNo;
					} 
					else 
					{
						param.pageNo = 1;
					} 
					var content_url = "${_base}/expums/umsQueryInfoList";// 查询列表 
					$.ajax({
						async : true,
						type : "POST",
						url : content_url,
						modal : true,
						showBusi : false,
						data : param, 
						success : function(data) { 
							$(_this.settings.FILENAME_QUERY_DIV).show();  
							$("#fileNameQueryList").show();
							$("#fileNameQueryList").empty();
							$("#fileNameQueryList").html(data);
							
							//关闭提示  
							if (tips) 
							{
								tips.close();
							}
						},
						error : function(data) {
							$.dialog.alert("数据请求失败！");
							//关闭提示 
							if (tips) {
								tips.close();
							}
						}
					});
				}  //查询END
			}
		});
	})(jQuery)

	/** 清空并隐藏 div内容 */
	function clearDiv(divId) {
		$("#" + divId).empty();
		$("#" + divId).hide();
	}
	
	
	/* 判断文本框是否为空， 空返回true， 非空返回false */
	function isNull(theId) {
		var keyVal= $.trim($("#"+theId).val());  
		if(keyVal.length==0){
			return true;
		} 
		return false;
	}
	 
	/* 替换字符串中的 < > ' " 四种符号  */
	function htmlSpecialChars(string) {
		string = string.toString();
		string = string.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/'/g, '&#039;').replace(/"/g, '&quot;');
		return string;
	}
  
</script>
</head>
<body>

	<div class="big_main">
		<!--外围边框DIV-->
		<div class="big_title">
			<p>短信状态查询:</p>
		</div>
		<!-------查询列表区-------->
		<div class="number">
			<ul>
			<!--<li class="xz_zi">电话号码：</li>
				 <li><input type="text" id="phoneNum"
					class="query_fuw" value="" maxlength="11" onclick="value=''"
					onkeyup="if(isNaN(value)||(value.trim()==''))execCommand('undo');"
					onafterpaste="if(isNaN(value)||(value.trim()==''))execCommand('undo');"/>
				</li>  -->
			
				<li class="xz_zi">文件名：</li>
				<li>
				<input type="text" id="fileName" class="query_input"
					value="" maxlength="50" />  
				</li>
				
				
				<li class="query_zhij"><a href="javascript:void(0);"
					id="qryBtn">查询</a>
			</ul>
		</div>
	</div>
 
	<div class="big_main" id="fileNameQueryDiv" style="display: none;"> 
	<!--外围边框DIV--> 
	<div id="fileNameQueryList"  style="display: none;"></div>
	</div>
 
</body>
</html>