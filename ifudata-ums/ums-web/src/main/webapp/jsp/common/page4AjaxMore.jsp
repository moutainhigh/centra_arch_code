<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	var piMoreManager;
	var pageNo ="${pageInfoMore.pageNo}";
	var pageCount = "${pageInfoMore.pageCount}";
	(function() {
		$.piMoreManager = function() {
			this.settings = $.extend(true, {}, $.piMoreManager.defaults);
			this.init();
		};
		$.extend($.piMoreManager, {
			defaults : {
				currentPage : pageNo,
				totalPage : pageCount
			},
			prototype : {
				init : function() {
					var _this = this;
					_this.initpage();
					_this.bindEvents();
				},
				initpage : function() {
					var _this = this;
					var currentPage=pageNo;
					var totalPage="${pageInfoMore.pageCount}";
					var tag = "";
					var cc=9;//显示几个数呀
					if (totalPage <= cc) {
						for (var i = 1; i <= totalPage; i++) {
							tag += "<li><a href='javascript:void(0);' id='page_more_" + i +"'>" + i+ "</a></li>";
						}
					} else {
						if (currentPage <= parseInt(cc/2)+1) {
							for (var i = 1; i <= cc; i++) {
								tag += "<li><a href='javascript:void(0);'  id='page_more_"+ i +"'>" + i+ "</a></li>";
							}
						} else if (currentPage > (totalPage - parseInt(cc/2))) {
							var start = totalPage - (cc-1);
							for (var i = start; i <= totalPage; i++) {
								tag += "<li><a href='javascript:void(0);' id='page_more_"+i+"'>" + i+ "</a></li>";
							}
						} else {
							var start = currentPage - parseInt(cc/2);
							var end = parseInt(currentPage) + parseInt(cc/2);
							if (totalPage < end) {
								end = totalPage;
							}
							for (var i = start; i <= end; i++) {
								tag += "<li><a href='javascript:void(0);' id='page_more_"+i+"'>" + i+ "</a></li>";
							}
						}
					}
					$("#pageIndex_div").append($(tag));
					$("#pi_last_more").before($(tag));
					//当前页样式
					$("#page_more_" + currentPage).css("background-color","#4171B8");
					$("#page_more_" + currentPage).css("color","#fff");
					if(currentPage==1){
						if(currentPage==totalPage){
							
						}else{
							$("#pi_first_more").after($("<li><a href='javascript:void(0);' id='pi_pre_more'>上一页</a></li>"));
							$("#pi_last_more").before($("<li><a href='javascript:void(0);' id='pi_next_more'>下一页</a></li>"));
						}
					}else{
						$("#pi_first_more").after($("<li><a href='javascript:void(0);' id='pi_pre_more'>上一页</a></li>"));
						$("#pi_last_more").before($("<li><a href='javascript:void(0);' id='pi_next_more'>下一页</a></li>"));
					}
				},
				bindEvents : function() {
					var _this = this;
					var currentPage=pageNo;
					var totalPage=pageCount;
					//
					$("#pi_first_more").bind("click", function() {
						if (currentPage == 1) {
							return;
						}
						searchMore(1);
					});
					$("#pi_last_more").bind("click", function() {
						if (currentPage == totalPage) {
							return;
						}
						searchMore(totalPage);
					});
					$("#pi_pre_more").bind("click", function() {
						if (currentPage <=1) {
							return;
						}
						searchMore(parseInt(currentPage)-1);
					});
					$("#pi_next_more").bind("click", function() {
						if (currentPage == "${pageInfoMore.pageCount}") {
							return;
						}
						searchMore(parseInt(currentPage)+1);
					});
					$("#page_index_more").bind("keyup", function() {
						var value=$("#page_index_more").val().replace(/[^\d]/g,'');
						if(value==0){
							$("#page_index_more").val('');
						}else if(parseInt(value) > totalPage){
							$("#page_index_more").val('');
						}else{
							$("#page_index_more").val(value);
						}
					});
					$("#jump_more").bind("click", function() {
						var index=$("#page_index_more").val();
						if(index.length>0 && index>0){
							searchMore(parseInt(index));
						}
					});					
					var pages = $("a[id^='page_more_']");
					if (null != pages && pages != "") {
						var length = pages.length;
						for (var i = 0; i < length; i++) {
							$(pages[i]).click(
									function() {
										var id = $(this).attr("id");
										var pageIndex = id.substring(id
												.lastIndexOf("_") + 1,
												id.length);
										searchMore(pageIndex);
									});
						}
					}
				}
			}
		});
	})(jQuery);
	$(document).ready(function() {
		piMoreManager = new $.piMoreManager();
	});
</script>
<style>
</style>
<!--分页class="disabled"  -->
<div class="main_C_fenye">
		<c:choose>
			<c:when test="${pageInfoMore.count<=0 }">
<!-- 				<div style="text-align: center;"> -->
<!-- 					<span> 未找到相关记录</span> -->
<!-- 				</div> -->
			</c:when>
			<c:otherwise>
				<ul style="width: 700px;">
					<li><a id="pi_first_more" style="cursor: pointer;display: none;">首页 </a></li>
					<li><a style="cursor: pointer;margin-left:10px;display: none;" id="pi_last_more">尾页</a></li>
					<li>共${pageInfoMore.pageCount }页</li>		
          			<li>&nbsp;&nbsp;第<input name="x_f_input" type="text" id="page_index_more" class="x_f_input" oncontextmenu="window.event.returnValue=false"/>页</li>
          			<li class="x_tzh"><A href="javascript:void(0)" id="jump_more">跳转</A></li>
				</ul>
			</c:otherwise>
		</c:choose>
</div>
<!--分页结束 -->