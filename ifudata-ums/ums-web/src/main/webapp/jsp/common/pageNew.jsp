<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	var piManager;
	var pageNo ="${pageInfo.pageNo}";
	var pageCount = "${pageInfo.pageCount}";
	(function() {
		$.PiManager = function() {
			this.settings = $.extend(true, {}, $.PiManager.defaults);
		};
		$.extend($.PiManager, {
			defaults : {
				currentPage : pageNo,
				totalPage : pageCount
			},
			prototype : {
				init : function(pageNo,pageCount) {
					var _this = this;
					_this.settings.currentPage = pageNo;
					_this.settings.totalPage = pageCount;
					_this.initpage();
					_this.bindEvents();
				},
				initpage : function() {
					var _this = this;
					var currentPage=_this.settings.currentPage;
					var totalPage=_this.settings.totalPage;
					var tag = "";
					var cc=9;//显示几个数呀
					if (totalPage <= cc) {
						for (var i = 1; i <= totalPage; i++) {
							tag += "<li><a href='#' id='page_" + i +"' name='page_number'>" + i+ "</a></li>";
						}
					} else {
						if (currentPage <= parseInt(cc/2)+1) {
							for (var i = 1; i <= cc; i++) {
								tag += "<li><a href='#'  id='page_"+ i +"' name='page_number'>" + i+ "</a></li>";
							}
						} else if (currentPage > (totalPage - parseInt(cc/2))) {
							var start = totalPage - (cc-1);
							for (var i = start; i <= totalPage; i++) {
								tag += "<li><a href='#' id='page_"+i+"' name='page_number'>" + i+ "</a></li>";
							}
						} else {
							var start = currentPage - parseInt(cc/2);
							var end = parseInt(currentPage) + parseInt(cc/2);
							if (totalPage < end) {
								end = totalPage;
							}
							for (var i = start; i <= end; i++) {
								tag += "<li><a href='#' id='page_"+i+"' name='page_number'>" + i+ "</a></li>";
							}
						}
					}
					$("#pi_last").before($(tag));
					//当前页样式
					$("#page_" + currentPage).css("background-color","#4171B8");
					$("#page_" + currentPage).css("color","#fff");
					if(currentPage==1){
						if(currentPage==totalPage){
							
						}else{
							$("#pi_first").after($("<li><a href='#' id='pi_pre'>上一页</a></li>"));
							$("#pi_last").before($("<li><a href='#' id='pi_next'>下一页</a></li>"));
						}
					}else{
						$("#pi_first").after($("<li><a href='#' id='pi_pre'>上一页</a></li>"));
						if(currentPage==totalPage){
							
						}else{
							$("#pi_last").before($("<li><a href='#' id='pi_next'>下一页</a></li>"));
						}
					}
				},
				initPageNum : function(currentPage){
					$("a[name='page_number']").css("background-color","#FFF");
					$("a[name='page_number']").css("color","#474747");
					//当前页样式
					$("#page_" + currentPage).css("background-color","#4171B8");
					$("#page_" + currentPage).css("color","#fff");
				},
				bindEvents : function() {
					var _this = this;
					//
					$("#pi_first").bind("click", function() {
						if (_this.settings.currentPage == 1) {
							return;
						}
						search(1);
						_this.initPageNum(1);
						_this.settings.currentPage = 1;
					});
					$("#pi_last").bind("click", function() {
						if (_this.settings.currentPage == _this.settings.totalPage) {
							return;
						}
						search(_this.settings.totalPage);
						_this.initPageNum(_this.settings.totalPage);
						_this.settings.currentPage = _this.settings.totalPage;
					});
					$("#pi_pre").bind("click", function() {
						if (_this.settings.currentPage <=1) {
							return;
						}
						search(parseInt(_this.settings.currentPage)-1);
						_this.initPageNum(parseInt(_this.settings.currentPage)-1);
						_this.settings.currentPage = parseInt(_this.settings.currentPage)-1;
					});
					$("#pi_next").bind("click", function() {
						if (_this.settings.currentPage == _this.settings.totalPage) {
							return;
						}
						search(parseInt(_this.settings.currentPage)+1);
						_this.initPageNum(parseInt(_this.settings.currentPage)+1);
						_this.settings.currentPage = parseInt(_this.settings.currentPage)+1;
					});
					$("#page_index").bind("keyup", function() {
						var value=$("#page_index").val().replace(/[^\d]/g,'');
						if(value==0){
							$("#page_index").val('');
						}else if(parseInt(value) > _this.settings.totalPage){
							$("#page_index").val('');
						}else{
							$("#page_index").val(value);
						}
					});
					$("#jump").bind("click", function() {
						var index=$("#page_index").val();
						if(index.length>0 && index>0 && index <= _this.settings.totalPage){
							search(parseInt(index));
							_this.initPageNum(parseInt(index));
							_this.settings.currentPage = parseInt(index);
						}
					});					
					var pages = $("a[id^='page_']");
					if (null != pages && pages != "") {
						var length = pages.length;
						for (var i = 0; i < length; i++) {
							$(pages[i]).click(
									function() {
										var id = $(this).attr("id");
										var pageIndex = id.substring(id
												.lastIndexOf("_") + 1,
												id.length);
										search(pageIndex);
										_this.initPageNum(pageIndex);
										_this.settings.currentPage = pageIndex;
									});
						}
					}
				}
			}
		});
	})(jQuery);
	$(document).ready(function() {
		piManager = new $.PiManager();
		piManager.init(pageNo,pageCount);
	});
	
</script>
<!--分页class="disabled"  -->
<div id="pageDiv">
		<c:choose>
			<c:when test="${pageInfo.count<=0 }">
				<div style="text-align: center;">
					<span> 未找到相关记录</span>
				</div>
			</c:when>
			<c:otherwise>
				<ul style="width: 700px;">
					<li><a id="pi_first" style="cursor: pointer;display: none;">首页 </a></li>
					<li><a style="cursor: pointer;margin-left:10px;display: none;" id="pi_last">尾页</a></li>
					<li>共${pageInfo.pageCount }页</li>		
          			<li>&nbsp;&nbsp;第<input name="x_f_input" type="text" id="page_index" class="x_f_input" oncontextmenu="window.event.returnValue=false"/>页</li>
          			<li class="x_tzh"><A href="javascript:void(0)" id="jump">跳转</A></li>
				</ul>
			</c:otherwise>
		</c:choose>
</div>
<!--分页结束 -->