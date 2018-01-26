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
<title>批量短信监控</title>
<link href="${_base}/ui/css/css.css" rel="stylesheet" type="text/css" />
<script src="${_base}/ui/js/nav.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${_base}/js/jquery/validate/jquery.form.js"></script>
<script type="text/javascript" src="${_base}/js/jquery.pagController.js"></script>
<script type="text/javascript" src="${_base}/js/json2.js"></script>
<link rel="stylesheet" href="${_base}/js/jquery/jPages/css/jPages.css">
<script type="text/javascript"
	src="${_base}/js/jquery/jPages/js/jPages.min.js"></script>
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

table { 
table-layout: fixed; 
word-wrap:break-word;
border-collapse:collapse; 
border:0;
cellspacing:1; 
}
 
.td_overflow { 
overflow: hidden;
white-space: nowrap; /*规定段落中的文本不进行换行*/
text-overflow: ellipsis; /*溢出的文字显示为省略号*/
word-break: keep-all;
overflow:hidden; /*关闭滚动条*/
align:center; 
}

</style>
<script>
	//ord_apply_batch_detail 表  
	var pageManager;
	$(function() {
		pageManager = new $.PageManager();
	});
	//提交按钮事件
	(function() {
		$.PageManager = function() {
			this.settings = $.extend(true, {}, $.PageManager.defaults);
			this.init();
		};
		$.extend($.PageManager,{
			defaults : {
				FORM_ID : "#upload",
				DOWN_TEMPLATE : "#downTemplate",
				DOWN_FAILED : "#downloadFailed",
				FILE_NAME : "#fileName",
				FILE_IMPORT : "#fileImport",
				SUBMIT_BATCH : "#submitBatchBtn",
			},
			prototype : {
				init : function() {
					var _this = this;
					_this.bindEvents();
					_this.initValidate();
				},
				//校验
				initValidate : function() {
					var _this = this;
					$(_this.settings.FORM_ID).validate(
					{
						rules : {fileName : "required"},
						//错误信息位置
						errorPlacement : function(error, element) {
						//错误信息以浮动DIV提示
						handleErrorForFloatDiv(error,element,'top', 200,30);
						},
					  success : function(error, element) {
						//成功时 移除信息提示DIV
					  handleSuccessForFloatDiv(element);
						},
					  messages : {fileName : "请选择需要导入的excel文件！"}
					});
				},
				bindEvents : function() {
					_this = this;
					$(_this.settings.FILE_IMPORT).bind("click",
						function() {
							commit();
						});
					$(_this.settings.DOWN_TEMPLATE).bind("click",function() {
						location.href = "${_base}/expums/downTemplateFile";
						});
					$(_this.settings.DOWN_FAILED).bind("click",function() {
						var failFileName = $("#fileId").val();
						if (failFileName != null && failFileName != '') {
							location.href = "${_base}/expums/downloadFailedFile?failFileName="+ failFileName+ "&timestamp="+ new Date().getTime();
						}
					});

					$(_this.settings.FILE_NAME).bind("change",function() { 
								var importFile = $("#fileName").val();  
							//	var reg = /\w*.xlsx/;  var reg2 = /\w*.xls/; 
							//   var reg = /[\w\u4E00-\u9FA5\uF900-\uFA2D]*.xlsx/;
						   //    var reg2 = /[\w\u4E00-\u9FA5\uF900-\uFA2D]*.xls/; 
						   
								var reg = /[\w\u4e00-\u9fa5\-\_\(\)\[\] ][\s\w\u4e00-\u9fa5\-\_\(\)\[\] ]*[\w\u4e00-\u9fa5\-\_\(\)\[\] ]*.xlsx/;
								var reg2 = /[\w\u4e00-\u9fa5\-\_\(\)\[\] ][\s\w\u4e00-\u9fa5\-\_\(\)\[\] ]*[\w\u4e00-\u9fa5\-\_\(\)\[\] ]*.xls/; //字母数字中文下划线中划线()空格
								var result = reg.exec(importFile);
								var result2 = reg2.exec(importFile); 
							//	 alert(' 导入的文件importFile：' + importFile);
							//	 alert('fileName导入的文件result：' + result);
							//	 alert('fileName导入的文件result2：' + result2);
								  
						 	if ( result != null) 
								{ 
									$("#fileNameParam").val(result); 
								} 
								else if ( result2 != null)
								{
									$("#fileNameParam").val(result2); 
								}  
								if (result == null) {
									if (result2 == null) {
										$.dialog.alert("上传附件格式不正确或文件名包含特殊字符(只支持*.xlsx、*.xls格式文件)");
										$(_this.settings.FILE_NAME).val("");
										return;
									}
								}
								
							});
					//提交
					$(_this.settings.SUBMIT_BATCH).bind("click",function() { 
							var contentDes = $("#contentDes").val();
							var PlanTimeStr = $("#PlanTime").val();
							var times = $("#times").val();
							var PlanTime = DateToStr(PlanTimeStr); /*时间转换成字符*/ 
							var fileNameParam   = $("#fileNameParam").val();
						//	alert('fileName导入的文件fileNameParam2fileNameParam2：' + fileNameParam); 
							//提交批量赠款
							if ($("#movies tr").length > 0) {
								//提交前将错误文件删除
								var failFileName = "";
								if ($("#downloadFailed").text() != "") {
									failFileName = $("#fileId").val();
									$("#downloadFailed").hide();
								}
								var datas = $("#datas").val();
								$.ajax({
											type : "post",
											url : "${_base}/expums/submitBatch",
											data : {
												grantsRecords : datas,
												failFileName : failFileName,
												contentDes : contentDes,
												PlanTime : PlanTime,
												times : times, 
												fileNameParam : fileNameParam, 
											},
											success : function(data) {
												var $json = $.parseJSON(data);
												if ($json.RES_RESULT == "SUCCESS") {
													var batchId = $json.RES_DATA.batchId;
													var batchDesc = $json.RES_DATA.batchDesc;

													$("#seriesNo").text(batchId);
													$("#batchDesc").text(batchDesc);
													openDialog();
												} else {
													$.dialog.alert($json.RES_MSG);
												}
											}
										});

							} else {
								$.dialog.alert("请先上传有效的批量信息！");
							}
						});
				}
			}
						});
	})(jQuery);

	//导入
	function commit() {
		debugger;
		if (!checkText()) { //校验文本框
			return;
		} else {
			if ($("#upload").valid()) {
				formPag.goAjax({
					type : "POST",
					url : "${_base}/expums/uploadBatchGrants",
					modal : true,
					postselectors : [ "#upload" ],
					success : function(data) {
					//成功后的操作：1.询问是否下载失败信息，2.删除临时文件
					var $json = data;
					if ($json.RES_RESULT == "SUCCESS") {
						$("#data_area").show();
						var trS = "<tr align='center' valign='middle' bgcolor=''#e3f0f6' style='border-top: 1px solid #d1d3d5;'>";
						var trE = "</tr>";
						var tdS = "<td  class ='td_overflow' style='white-space:nowrap;height:35px;'>"; 
						var tdE = "</td>";
						var tbodyHtml = "";

						var array = $json.RES_DATA.array;
						$("#datas").val(JSON.stringify(array));
						if (array.length > 0) {
							for (var i = 0; i < array.length; i++) {
								var d = array[i];
								tbodyHtml += trS;
								tbodyHtml += tdS + d.seriesNo + tdE;
								tbodyHtml += tdS + d.phone + tdE;
								tbodyHtml += tdS + d.content + tdE;
							<!--	tbodyHtml += tdS + checkNull(d.effectDate) + tdE; 推送时间-->
								tbodyHtml += tdS + d.chiId + tdE;
								tbodyHtml += tdS + d.groupNum + tdE;
								tbodyHtml += tdS + d.provinceCode + tdE;
								tbodyHtml += tdS + d.cityCode + tdE;
								tbodyHtml += trE;
							}
							$("#movies").html(tbodyHtml);
						//	$("#table_list_show").show();
							$("#pageInfo_div").show();
							$(_this.settings.SUBMIT_BATCH).show();
							$("#pageInfo_div").jPages({
								containerID : "movies",
								previous : "上一页",
								next : "下一页",
								perPage : 5,
								delay : 20,
								first : "首页",
								last : "最后一页"
							});
						} else {
							tbodyHtml += trS + tdS + tdE + tdS
									+ "没有符合条件的数据" + tdE + tdS + tdE
									+ trE;
							$("#movies").html(tbodyHtml);
							$(_this.settings.SUBMIT_BATCH).hide();
							$("#pageInfo_div").hide();
						}

						//把首页和上一页不可点击样式去除，但按钮点击后依然没有任何处理
						$(".jp-first").removeClass("jp-disabled");
						$(".jp-previous").removeClass("jp-disabled");

						var failSize = $json.RES_DATA.failedSize;
						if (failSize == undefined) {
							failSize = 0;
						}
						$("#totalItem").text($json.RES_DATA.countSize);
						$("#errorItem").text(failSize);
						if ($json.RES_DATA.fileId != undefined && $json.RES_DATA.fileId != "") {
							$("#fileId").val($json.RES_DATA.fileId);
							$("#downloadFailed").show();
						} else {
							$("#downloadFailed").hide();
						}

					} else {
						$("#data_area").hide();
						$.dialog.alert($json.RES_MSG, function() {
							return true;
						});
					}

				}
				});
			}
		}
	}

	function objToJson(obj) {
		// 用来保存所有的属性名称和值 
		var props = "{";
		// 开始遍历 
		for ( var p in obj) { // 方法 
			// p 为属性名称，obj[p]为对应属性的值 
			if (typeof (obj[p]) != "function") {
				if (obj[p] != "default") {
					//不等于“defualt”的时候才把条件追加
					props += "\"" + p + "\":\"" + obj[p] + "\",";
				}
			}
		} // 最后显示所有的属性 
		props = props.substring(0, props.length - 1) + "}";
		return props;
	}

	function checkNull(v) {
		if (v == null) {
			v = "";
		}
		return v;
	}

	function openDialog() {
		$(".pop-up").show();
		$("#mask").css("height", $(document).height());
		$("#mask").css("width", $(document).width());
		$("#mask").show();
	}

	function closeDialog() {
		$(".pop-up").hide();
		$("#mask").css("height", 0);
		$("#mask").css("width", 0);
		$("#mask").hide();
		//location.reload(true);
		window.location.href="${_base}/expums/ExpUmsConfig";
	}

	//判断文本框是否为空， 空返回true， 非空返回false  
	function isNull(theId) {
		var keyVal = $.trim($("#" + theId).val());
		if (keyVal.length == 0) {
			return true;
		}
		return false;
	}

	//替换字符串中的 < > ' " 四种符号 
	function htmlSpecialChars(string) {
		string = string.toString();
		string = string.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/'/g, '&#039;').replace(/"/g, '&quot;');
		return string;
	}

	/**
	 * 时间转换成字符串
	 * @param str
	 * @return date
	 */
	function DateToStr(str) {
		var strYear = str.substr(0, 4);
		var strMonth = str.substr(5, 2);
		var strDay = str.substr(8, 2);
		var strHour = str.substr(11, 2);
		var strMinute = str.substr(14, 2);
		var strSecond = str.substr(17, 2);

		var StrDate = strYear + '' + strMonth + '' + strDay + '' + strHour + '' + strMinute + '' + strSecond;
		// alert( "StrDate :" + StrDate); 
		return StrDate;
	}

	//文本框为空判断 
	function checkText() {
		var contentDescVal = $.trim($("#contentDes").val());
		var PlanTimeVal = $.trim($("#PlanTime").val());
		// var PlanTimeLength = document.getElementById("PlanTime").value; 
		var timesVal = $.trim($("#times").val());
		if (isNull("contentDes")) {
			$.dialog.alert("内容描述不能为空");
			return false;
		}
		if (contentDescVal.length > 81) {
			$.dialog.alert("内容描述不可以超过80字.");
			return false;
		}
		/*时间正确性校验*/
		if (isNull("PlanTime") || PlanTimeVal.length == 0) {
			$.dialog.alert("计划执行时间不能为空");
			return false;
		} else {
			var objRegExp = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))(\s(([01]\d{1})|(2[0123])):([0-5]\d):([0-5]\d))?$/;
			// document.write(objRegExp);  
			if (!objRegExp.test(PlanTimeVal)) /*如果判断字符串中是否存在匹配内容，如果存在提示正确信息，否则返回错误 */
			{
				$.dialog.alert("请输入正确的时间[格式: 2008-08-08 20:20:00],请注意年月日!!");
				return false;
			}
		}

		/*if (isNull("times")) {
			$.dialog.alert("重试次数不能为空");
			return false;
		} else {*/
			if (isNaN(timesVal)) {
				$.dialog.alert("重试次数要求为数字");
				return false; // 校验不通过，则停止		
			}
		//}
		/* 把 <script>脚本去掉 */
		$("#contentDesc").val(htmlSpecialChars(contentDescVal));
		$("#PlanTime").val(htmlSpecialChars(PlanTimeVal));
		$("#times").val(htmlSpecialChars(timesVal));
		return true;
	}
</script>
</head>

<body>
 	<input type="hidden" id="fileNameParam" name="fileNameParam" />
	<input type="hidden" id="fileId" />

	<div class="big_main">
		<div class="big_title">
			<p>批量短信推广:</p>
			<p>&nbsp;</p>
		</div>
		<form id="contentForm">
			<div class="query_main" id="contentFormDiv">
				<ul>
					<li>
						<p class="query_zi">
							<span class="STYLE1">*</span>内容描述：<br /> <a style="color: red;">(限制80字)</a>
						</p>
						<p>
							<textarea name="contentDes" id="contentDes"
								class="textarea_input" maxlength="81" rows="5" cols="30"
								style="resize: none;"> </textarea>
						</p> <span id="SpancontentDes" style="color: red;"></span>
					</li>
				</ul>
				<ul>
					<li>
						<p class="query_zi"><span class="STYLE1">*</span>计划执行时间：</p>

						<p class="query_tu">
							<span><input id="PlanTime" name="PlanTime" value=""
								type="text" class="query_input1" maxlength="19" /></span> <span
								class="qu_fd"> <a href="javascript:void(0);"> <img
									src="${_base }/ui/images/chax_04.png" width="21" height="21"
									onclick="WdatePicker({el:'PlanTime',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d+1}'});" />
							</a>
							</span> <span id="SpanPlanTime" style="color: red;"></span>
						</p>
					</li>
				</ul>
				<ul>
					<li>
						<p class="query_zi">重试次数：</p>
						<p>
							<input type="text" id="times" name="times" class="query_input"
								value="" maxlength="50"
								onkeyup="if(isNaN(value)||(value.trim()==''))value='';value=this.value.replace(/\D+/g,'')"
								onafterpaste="if(isNaN(value)||(value.trim()==''))execCommand('undo');" />
							<span id="SpanTimes" style="color: red;"></span>
						</p>
					</li>
				</ul>
			</div>
		</form>
		<!--文件导入  S开始-->

		<div class="number">
			<form id="upload" method="post" ENCTYPE="multipart/form-data">
				<ul>
					<li class="xz_zi">文件位置：</li>
					<li><input type="file" id="fileName" name="fileName"
						class="query_input_ry" onkeypress="javascript:return false;" /></li>
					<li class="query_zhij"><A href="javascript:void(0);"
						id="fileImport">导&nbsp;入</A></li>
					<li class="query_zhij"><A href="javascript:void(0);"
						id="downTemplate">下载模板</A></li>
					<li class="query_zhij"><span id="operateTips"
						style="color: red;">&nbsp;&nbsp;&nbsp;</span></li>
				</ul>
			</form>
		</div>
	</div>
	<!--文件导入  E结束-->



	<!--Excel导入明细   S开始-->
	<div class="big_main" style="display: none;" id="data_area">
		<!--外围边框DIV-->

		<!--查询结果table区域-->
		<div class="query_table">
			<table width="100%" border="0" cellspacing="1">
				<tr align="center" valign="middle">
					<td colspan="7">
						<table class="query_table2">
							<tr valign="middle">
								<td height="35" colspan="2" align="left">批量导入文件记录数共计 <span
									id="totalItem" style="color: #f00"></span>笔,失败<span
									id="errorItem" style="color: #f00"></span>笔。 <span
									style="color: #f00; display: none;" id="downloadFailed">请下载
										<a href='javascript:void(0)'>【文件处理结果】</a>，修改后重新导入
								</span>
								</td>
								<td width="52%" height="35">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr align="center"  valign="middle" bgcolor="#e3f0f6" width="100%" >
					<td style="white-space: nowrap; height: 35px; width: 10%;">序号</td>
					<td style="white-space: nowrap; height: 35px; width: 10%;"><span class="STYLE4">服务号码</span></td>
					<td style="white-space: nowrap; height: 35px; width: 40%;"><span class="STYLE4">内容</span></td>
					<!-- <td style="white-space: nowrap; height: 35px; width: 15%;"><span class="STYLE4">推送时间</span></td> -->
					<td style="white-space: nowrap; height: 35px; width: 10%;"><span class="STYLE4">渠道</span></td>
					<td style="white-space: nowrap; height: 35px; width: 10%;"><span class="STYLE4">分组号</span></td>
					<td style="white-space: nowrap; height: 35px; width: 10%;"><span class="STYLE4">省份</span></td>
					<td style="white-space: nowrap; height: 35px; width: 10%;"><span class="STYLE4">地市</span></td>
				</tr>

				<tbody id="movies">

				</tbody>

			</table>
			
			
		<!-- 导入成功数据展示 --> 
		<textarea id="datas" name="userInfos" style="display: none;">
		</textarea> 
		</div>
		<div class="jiaofei_button" >
			<ul>
				<li class="query_zhij"><A href="#" id="submitBatchBtn">提交</A></li>
			</ul>
		</div>
		<div id="pageInfo_div" class="main_C_fenye holder"
			style="width: 100%; display: none; text-align: center; margin-top: 320px;">

		</div>
		

		<!-- 导入批次结果页面 -->
		<div class="pop-up"
			style="position: fixed; top: 150px; left: 300px; display: none; z-index: 200; width: 300px;">
			<div class="pop-up_top">
				<p id="info">提交成功</p>
				<p class="pop_ch">
					<A href="javascript:closeDialog();"><img
						src="${_base }/ui/images/pop-up_top_c.png" width="14" height="14" /></A>
				</p>
			</div>

			<div class="pop-up_main">

				<div class="pop-up_input">
					<ul>
						<li class="pop_dy">批次号：</li>
						<li><p id="seriesNo"></p></li>
					</ul>
					<ul>
						<li class="pop_dy">批次状态：</li>
						<li id="batchDesc" style="width: 200px;"></li>
					</ul>
				</div>

			</div>
			<div class="pop-up_bottom"></div>
		</div>
		<div id="mask" class="mask"></div>
	</div>
	<!--Excel导入明细   E结束-->

</body>
</html>