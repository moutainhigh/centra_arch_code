<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	var piTwoManager;
	var pageNo ="${pageInfoThree.pageNo}";
	var pageCount = "${pageInfoThree.pageCount}";
	var queryFlag= "0";
	(function() {
		$.piTwoManager = function() {
			this.settings = $.extend(true, {}, $.piTwoManager.defaults);
			this.init();
		};
		$.extend($.piTwoManager, {
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
					var totalPage="${pageInfoThree.pageCount}";
					var tag = "";
					var cc=3;//显示几个数呀
					if (totalPage <= cc) {
						for (var i = 1; i <= totalPage; i++) {
							tag += "<li><a href='javascript:void(0);' id='page_three_" + i +"'>" + i+ "</a></li>";
						}
					} else {
						if (currentPage <= parseInt(cc/2)+1) {
							for (var i = 1; i <= cc; i++) {
								tag += "<li><a href='javascript:void(0);'  id='page_three_"+ i +"'>" + i+ "</a></li>";
							}
						} else if (currentPage > (totalPage - parseInt(cc/2))) {
							var start = totalPage - (cc-1);
							for (var i = start; i <= totalPage; i++) {
								tag += "<li><a href='javascript:void(0);' id='page_three_"+i+"'>" + i+ "</a></li>";
							}
						} else {
							var start = currentPage - parseInt(cc/2);
							var end = parseInt(currentPage) + parseInt(cc/2);
							if (totalPage < end) {
								end = totalPage;
							}
							for (var i = start; i <= end; i++) {
								tag += "<li><a href='javascript:void(0);' id='page_three_"+i+"'>" + i+ "</a></li>";
							}
						}
					}
					$("#pageIndex_div").append($(tag));
					$("#pi_last_three").before($(tag));
					//当前页样式
					$("#page_three_" + currentPage).css("background-color","#4171B8");
					$("#page_three_" + currentPage).css("color","#fff");
					if(currentPage==1){
						if(currentPage==totalPage){
							
						}else{
							$("#pi_first_three").after($("<li><a href='javascript:void(0);' id='pi_pre_three'>上一页</a></li>"));
							$("#pi_last_three").before($("<li><a href='javascript:void(0);' id='pi_next_three'>下一页</a></li>"));
						}
					}else{
						$("#pi_first_three").after($("<li><a href='javascript:void(0);' id='pi_pre_three'>上一页</a></li>"));
						$("#pi_last_three").before($("<li><a href='javascript:void(0);' id='pi_next_three'>下一页</a></li>"));
					}
				},
				bindEvents : function() {
					var _this = this;
					var currentPage=pageNo;
					var totalPage=pageCount;
					//
					$("#pi_first_three").bind("click", function() {
						if(queryFlag=="0"){
							if (currentPage == 1) {
								return;
							}
							searchThree(1);
							queryFlag="1";
						}
						
					});
					$("#pi_last_three").bind("click", function() {
						if(queryFlag=="0"){
							if (currentPage == totalPage) {
								return;
							}
							searchThree(totalPage);
							queryFlag="1";
						}
						
					});
					$("#pi_pre_three").bind("click", function() {
						if(queryFlag=="0"){
							if (currentPage <=1) {
								return;
							}
							searchThree(parseInt(currentPage)-1);
							queryFlag="1";
						}
						
					});
					$("#pi_next_three").bind("click", function() {
						if(queryFlag=="0"){
							if (currentPage == totalPage) {
								return;
							}
							searchThree(parseInt(currentPage)+1);
							queryFlag="1";
						}
						
					});
					$("#page_index_three").bind("keyup", function() {
						var value=$("#page_index_three").val().replace(/[^\d]/g,'');
						if(value==0){
							$("#page_index_three").val('');
						}else if(parseInt(value) > totalPage){
							$("#page_index_three").val('');
						}else{
							$("#page_index_three").val(value);
						}
					});
					$("#jump_three").bind("click", function() {
						if(queryFlag=="0"){
							var index=$("#page_index_three").val();
							if(index.length>0 && index>0){
								searchThree(parseInt(index));
								queryFlag="1";
							}
						}
						
					});					
					var pages = $("a[id^='page_three_']");
					if (null != pages && pages != "") {
						var length = pages.length;
						for (var i = 0; i < length; i++) {
							$(pages[i]).click(
									function() {
										if(queryFlag=="0"){
											var id = $(this).attr("id");
											var pageIndex = id.substring(id.lastIndexOf("_") + 1,id.length);
											searchThree(pageIndex);
											queryFlag="1";
										}
									});
						}
					}
				}
			}
		});
	})(jQuery);
	$(document).ready(function() {
		piTwoManager = new $.piTwoManager();
	});
</script>
<style>
</style>
<!--分页class="disabled"  -->
<div class="main_C_fenye">
		<c:choose>
			<c:when test="${pageInfoThree.count<=0 }"></c:when>
			<c:otherwise>
				<ul style="width: 700px;">
					<li><a id="pi_first_three" style="cursor: pointer;display: none;">首页 </a></li>
					<li><a style="cursor: pointer;margin-left:10px;display: none;" id="pi_last_three">尾页</a></li>
					<li>共${pageInfoThree.pageCount }页</li>		
          			<li>&nbsp;&nbsp;第<input name="x_f_input" type="text" id="page_index_three" class="x_f_input" oncontextmenu="window.event.returnValue=false"/>页</li>
          			<li class="x_tzh"><a href="javascript:void(0)" id="jump_three">跳转</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
</div>
<!--分页结束 -->