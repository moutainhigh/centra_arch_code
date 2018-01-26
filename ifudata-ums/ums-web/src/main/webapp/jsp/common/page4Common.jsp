<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	var commPageManager;
	var commPageNo ="${commPager.pageNo}";
	var commPageCount = "${commPager.pageCount}";
	(function() {
		$.commPageManager = function() {
			this.settings = $.extend(true, {}, $.commPageManager.defaults);
			this.init();
		};
		$.extend($.commPageManager, {
			defaults : {
				currentPage : commPageNo,
				totalPage : commPageCount
			},
			prototype : {
				init : function() {
					var _this = this;
					_this.initpage();
					_this.bindEvents();
				},
				initpage : function() {
					var _this = this;
					var currentPage=commPageNo;
					var totalPage=commPageCount;
					var tag = "";
					var cc=9;//显示几个数呀
					if (totalPage <= cc) {
						for (var i = 1; i <= totalPage; i++) {
							tag += "<li><a href='javascript:void(0);' id='comm_page_" + i +"'>" + i+ "</a></li>";
						}
					} else {
						if (currentPage <= parseInt(cc/2)+1) {
							for (var i = 1; i <= cc; i++) {
								tag += "<li><a href='javascript:void(0);'  id='comm_page_"+ i +"'>" + i+ "</a></li>";
							}
						} else if (currentPage > (totalPage - parseInt(cc/2))) {
							var start = totalPage - (cc-1);
							for (var i = start; i <= totalPage; i++) {
								tag += "<li><a href='javascript:void(0);' id='comm_page_"+i+"'>" + i+ "</a></li>";
							}
						} else {
							var start = currentPage - parseInt(cc/2);
							var end = parseInt(currentPage) + parseInt(cc/2);
							if (totalPage < end) {
								end = totalPage;
							}
							for (var i = start; i <= end; i++) {
								tag += "<li><a href='javascript:void(0);' id='comm_page_"+i+"'>" + i+ "</a></li>";
							}
						}
					}
					$("#comm_pageIndex_div").append($(tag));
					$("#comm_pi_last").before($(tag));
					//当前页样式
					$("#comm_page_" + currentPage).css("background-color","#4171B8");
					$("#comm_page_" + currentPage).css("color","#fff");
					if(currentPage==1){
						if(currentPage==totalPage){
							
						}else{
							$("#comm_pi_first").after($("<li><a href='javascript:void(0);' id='comm_pi_pre'>上一页</a></li>"));
							$("#comm_pi_last").before($("<li><a href='javascript:void(0);' id='comm_pi_next'>下一页</a></li>"));
						}
					}else{
						$("#comm_pi_first").after($("<li><a href='javascript:void(0);' id='comm_pi_pre'>上一页</a></li>"));
						$("#comm_pi_last").before($("<li><a href='javascript:void(0);' id='comm_pi_next'>下一页</a></li>"));
					}
				},
				bindEvents : function() {
					var _this = this;
					var currentPage=commPageNo;
					var totalPage=commPageCount;
					//
					$("#comm_pi_first").bind("click", function() {
						if (currentPage == 1) {
							return;
						}
						commonSearch(1);
					});
					$("#comm_pi_last").bind("click", function() {
						if (currentPage == totalPage) {
							return;
						}
						commonSearch(totalPage);
					});
					$("#comm_pi_pre").bind("click", function() {
						if (currentPage <=1) {
							return;
						}
						commonSearch(parseInt(currentPage)-1);
					});
					$("#comm_pi_next").bind("click", function() {
						if (currentPage == totalPage) {
							return;
						}
						commonSearch(parseInt(currentPage)+1);
					});
					$("#comm_page_index").bind("keyup", function() {
						var value=$("#comm_page_index").val().replace(/[^\d]/g,'');
						if(value==0){
							$("#comm_page_index").val('');
						}else if(parseInt(value) > totalPage){
							$("#comm_page_index").val('');
						}else{
							$("#comm_page_index").val(value);
						}
					});
					$("#comm_jump").bind("click", function() {
						var index=$("#comm_page_index").val();
						if(index.length>0 && index>0){
							commonSearch(parseInt(index));
						}
					});					
					var pages = $("a[id^='comm_page_']");
					if (null != pages && pages != "") {
						var length = pages.length;
						for (var i = 0; i < length; i++) {
							$(pages[i]).click(
									function() {
										var id = $(this).attr("id");
										var pageIndex = id.substring(id
												.lastIndexOf("_") + 1,
												id.length);
										commonSearch(pageIndex);
									});
						}
					}
				}
			}
		});
	})(jQuery);
	$(document).ready(function() {
		commPageManager = new $.commPageManager();
	});
</script>
<style>
</style>
<!--分页class="disabled"  -->
<div class="main_C_fenye">
		<c:choose>
			<c:when test="${commPager.count<=0 }">
				 <ul><li align="center">未找到相关记录</li></ul>
			</c:when>
			<c:otherwise>
				<ul style="width: 700px;">
					<li><a id="comm_pi_first" style="cursor: pointer;display: none;">首页 </a></li>
					<li><a style="cursor: pointer;margin-left:10px;display: none;" id="comm_pi_last">尾页</a></li>
					<li>共${commPager.pageCount }页</li>		
          			<li>&nbsp;&nbsp;第<input name="comm_page_index" type="text" id="comm_page_index" class="x_f_input" oncontextmenu="window.event.returnValue=false"/>页</li>
          			<li class="x_tzh"><A href="javascript:void(0)" id="comm_jump">跳转</A></li>
				</ul>
			</c:otherwise>
		</c:choose>
</div>
<!--分页结束 -->