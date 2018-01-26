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
<title>DataTables example</title>
<link type="text/css" href="${_base}/js/jquery/DataTables-1.9.4/css/demo_page.css" rel="stylesheet"/>
<link type="text/css" href="${_base}/js/jquery/DataTables-1.9.4/css/demo_table_jui.css" rel="stylesheet"/>
<link type="text/css" href="${_base}/js/jquery/DataTables-1.9.4/examples_support/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>

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
		
		<script type="text/javascript" language="javascript" src="<%=bp%>/js/jquery/DataTables-1.9.4/js/jquery.dataTables.js?132"></script>
		<script type="text/javascript" charset="utf-8">
			var columId ;
			var controller;
			var nTds;
			var checkboxId;
			//oTable = $('#example').dataTable( );
			$(document).ready(function(){
				controller = new $.commonQueryFrameController();
			});
			/*定义页面管理类*/
			(function(){
				$.commonQueryFrameController  = function(){ 
					this.settings = $.extend(true,{},$.commonQueryFrameController.defaults); 
					this.init();
				};
				$.extend($.commonQueryFrameController,{
					defaults : {
						ADD_BUTTON : "#add",
						DELETE_BUTTON : "#delete",
						QUERY_BUTTON : "#query",
						RESET_BUTTON : "#reset",
						UPDATE_BUTTON : '#update',
						EXAMPLE_TABLE : '#example',
						EXAMPLE_TBODY_TR : "#example tbody tr",
						EXAMPLE_TR_TD : "#example tr td"
					},
					prototype : {
						
						init : function(){
							var _this = this;
							//oTable = $('#example').dataTable( );
							//页面等待loading。。。。。。
							$.dialog({
							  	id :'loading',
							 	title:'数据加载中，请稍后',
							  	min:false,
							  	max:false
							}).hide();
							_this.createDataTable();
							_this.bindEvents();
						},
						createDataTable:function(){
							var _this=this;
							$(_this.settings.EXAMPLE_TABLE).dataTable({
								 "oLanguage": {
							            "sUrl": "<%=bp%>/js/jquery/DataTables-1.9.4/de_CE.txt"
							        },

								//是否使用jquery ui themeroller的风格,默认是false
								"bJQueryUI": true,
								//用于指定分页器风格
								"sPaginationType": "full_numbers",
								//以指定当正在处理数据的时候，是否显示"正在处理",默认是true
								//"bProcessing": false,
								//配置数据表使用服务器端处理,与sAjaxSource同用
							    "bServerSide": true,
							    "bAutoWidth": false,
							    "bSort": false,
							    "bFilter": false,
							    //数据源页面
							    "sAjaxSource": "${_base}/demo/listpaging",
							    //数据准备方法
								"fnServerData" :function(sSource, aoData, fnCallback) {
								aoData.push({"name":"param", "value": $('form').serialize()});
								//发送ajax请求
								$.ajax({
									dataType : 'json',
									type : "POST",
									 url : sSource,
								    data : aoData,
									success : function(data){
										var tag = data.RES_MSG;
										if (tag == "success"){
											//调用datatabls的钩子函数填充表格数据
											fnCallback(data.RES_DATA);
											//表单重构后重新加载方法
											$(_this.settings.EXAMPLE_TBODY_TR).bind("click",function(){
												_this.initSelectRow(this);
											});
											$(_this.settings.EXAMPLE_TR_TD).each(function(){
												_this.displayRequiredText(this);
											});
										}else{
											$.dialog.alert(data.RES_MSG);
										}
									}
									});
								},
								//指定显示的字段
								"aoColumns" : [
								    {
								    	"mData" : "id",
								    	"mRender": function ( data, type, full ) {
									        return '<input type="checkbox" name="objectId" value="'+data+'" />';
									    }
								    },
									{"mData" : "name"}, 
									{"mData" : "code"}, 
									{"mData" : "city"}, 
									{"mData" : "email"} 
								]
							});
						},
						bindEvents : function(){
							var _this = this;
							
							//给新增按钮绑定事件
							$(_this.settings.ADD_BUTTON).bind("click",function(){
								_this.toAdd();
							});
							//给删除按钮绑定事件
							$(_this.settings.DELETE_BUTTON).bind("click",function(){
								_this.deleteData();
							});
							//给查询按钮绑定事件
							$(_this.settings.QUERY_BUTTON).bind("click",function(){
								_this.queryfresh();
							});
							//给重置按钮绑定事件
							$(_this.settings.RESET_BUTTON).bind("click",function(){
								_this.reset();
							});
							$(_this.settings.UPDATE_BUTTON).bind("click",function(){
								_this.update();
							});
							
							 
						},//删除数据
						deleteData : function() {
							
							/* var oTable = $(_this.settings.EXAMPLE).dataTable( );
							var anSelected = _this.fnGetSelected( oTable );
							var  deletedId =anSelected[0]._DT_RowIndex; */
							var columId =checkboxId;
							/* $("input:checkbox[name=objectId]:checked").each(function(){
								var result = $(this).val();
								columId = columId + result + ":";
							}); */
							
							/* $("input:checkbox[name =objectId]:checked").each(function(){
								alert(0);
								var result = $(this).val();
								
							}) */
							if ( columId != null ) {
								$.ajax({
									async : false,
									type : "POST",
									url : "${_base}/demo/remove?deletedId=" + columId,
									modal : true,
									showBusi : false,
									success : function(data) {
										var $json=$.parseJSON(data);
										if($json.RES_RESULT=="SUCCESS"){
											$.dialog.alert($json.RES_MSG,function(){
												location.reload();
											});
										}else{
											$.dialog.alert($json.RES_MSG,function(){
												location.reload();
											});
										}
									}
								});
								
							} else {
								$.dialog.alert("请先选中一条记录");
							}
							
						},//查询数据
						queryfresh : function(){
							var _this = this;
							var oTable = $(_this.settings.EXAMPLE_TABLE).dataTable();
							oTable.fnDraw();
						},
						reset : function(){
							$("#queryDiv :input").each(function () {
						        $(this).val("");
							});
						},
						update : function() {
							//alert("delete start````");
							var selectLength = $("input:checkbox[name=objectId]:checked").length;
							if(selectLength<1){
								$.dialog.alert("请先选中一条记录");
							}else if(selectLength>1){
								$.dialog.alert("请选中一条记录进行修改");
							}else{
								var  id = $("input:checkbox[name=objectId]:checked").val();
								$.dialog({
									id:'toUpdate_page',
								    content: 'url:${_base}/demo/toUpdate?id='+id,
								    ok: function(){
								    	var content = this.content;
								    	return content.updateManager.update();
								    },
								    okVal:'修改',
								    width:600,
								    height:400,
								    cancelVal: '关闭',
								    cancel: true /*为true等价于function(){}*/
								});
							}
						},
						initSelectRow : function( e ) {
							var _this = this;
							var oTable = _this.getTableObj();
							if ($(e).hasClass('row_selected')) {
								$(e).removeClass('row_selected');
							} else {
								oTable.$('tr.row_selected').removeClass('row_selected');
								$(e).addClass('row_selected');
							}
							//选中该行时默认选中checkbox  addby zhanglei11
							$(e).children().eq(0).children().eq(0).attr("checked","true");
							//获取选中的行的业务数据
							 if($(e).children().eq(0).children().eq(0).attr("checked")){
								alert(4444);
								 checkboxId =$(e).children().eq(0).children().eq(0).val();
								 nTds = $('td', e);
								//columId = $(nTds[1]).text();
								/* var param ={
										selectedId :id,
										selectobj : nTds
								} */
							}
							//return param; 
							
						},
						fnGetSelected : function ( oTableLocal ){
							//alert("2222");
							return oTableLocal.$('tr.row_selected');
						},
						
						toAdd : function (){
							$.dialog({
								id:'toAdd_page',
							    content: 'url:${_base}/demo/toAdd',
							    ok: function(){
							    	//loading();
							    	return this.content.addManager.add();
							    },
							    okVal:'保存',
							    width:600,
							    height:400,
							    cancelVal: '关闭',
							    cancel: true /*为true等价于function(){}*/
							});
						},
						getTableObj : function(){
							var _this = this;
							var oTable = $(_this.settings.EXAMPLE_TABLE).dataTable( );
							return oTable;
						},
						
						  displayRequiredText : function(i){
							//获取td当前对象的文本,如果长度大于15;  
					         if($(i).text().length>15){  
					               //给td设置title属性,并且设置td的完整值.给title属性.  
					    		$(i).attr("title",$(i).text());  
					                //获取td的值,进行截取。赋值给text变量保存.  
					    		var text=$(i).text().substring(0,15)+".....";  
					                //重新为td赋值;  
					            $(i).text(text);  
					         }  
						}
					}
				});
			})(jQuery)	 
					
			
			
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<!-- 查询区 -->
			<h1>Live example</h1>
			<form class="full_width big" id ="queryDiv" onsubmit="return false;">
				<table  width="100%" border="0" cellspacing="0" cellpadding="0" height="80" style="margin-left:10px;">
					<tr>
						<td align="left">
							<span style="margin-left:1px;">姓名：</span>
						</td>
						<td width="31%">
							<input style="width:200px;"  name="NAME" id="NAME" />
						</td>
						<td align="left">
							<span style="margin-left:4px;">编码：</span>
						</td>
						<td width="40%">
							<input name="CODE" id ="CODE" style="width:200px;" />
						</td>
					</tr>
					<tr>
						<td align="left"  nowrap="nowrap">
							<button onclick="" id ="query">查询</button>
							<button onclick="" id ="reset">重置</button>
						</td>
					</tr>
					
				</table>
			</form>
			
			<!-- 结果区 -->
			
			<div class="demo_jui">
			<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
				<thead>
					<tr>
					    <th width="5%"></th>
						<th>名称</th>
						<th>编码</th>
						<th>地市</th>
						<th>邮箱</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
			<div id ="operate" class="full_width big">
				<button id ="delete">删除</button>
				<button id ="add">新增</button>
				<button id ="update">修改</button>
			</div>
		</div>
		
	</body>
</html>