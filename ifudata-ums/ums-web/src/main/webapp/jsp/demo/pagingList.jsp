<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<%@ include file="/jsp/common/common.jsp" %>
		<title>DataTables example</title>
		<style type="text/css" title="currentStyle">
			@import "<%=bp%>/js/jquery/DataTables-1.9.4/css/demo_page.css";
			@import "<%=bp%>/js/jquery/DataTables-1.9.4/css/demo_table_jui.css";
			@import "<%=bp%>/js/jquery/DataTables-1.9.4/examples_support/jquery-ui-1.8.4.custom.css";
			
			#loading{
				position:absolute;
				width:300px;
				top:0px;
				left:50%;
				margin-left:-150px;
				text-align:center;
				padding:7px 0 0 0;
				font:bold 11px Arial, Helvetica, sans-serif;
			}
		</style>
		
		<script type="text/javascript" language="javascript" src="<%=bp%>/js/jquery/DataTables-1.9.4/js/jquery.dataTables.js?132"></script>
		<script type="text/javascript" charset="utf-8">
		
		
		 //load.hide();
			$(document).ready(function() {
				$('#example').dataTable({
					 "oLanguage": {
				            "sUrl": "<%=bp%>/js/jquery/DataTables-1.9.4/de_CE.txt"
				      },
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"bProcessing": true,
				    "bServerSide": true,
				    "sAjaxSource": "<%=bp%>/demo/paging/data",
				    "fnServerData": function (sSource, aoData, fnCallback, oSettings ) {
				      oSettings.jqXHR = $.ajax( {
				        "dataType": 'json',
				        "type": "POST",
				        "url": sSource,
				        "data": aoData,
				        "success": fnCallback
				      });
				    },
				    "aoColumns": [
				                  { "mData": "name" },
				                  { "mData": "city" },
				                  { "mData": "code" },
				                  { "mData": "email" }
				              ]
				});
			} );
		
	</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<!-- 结果区 -->
			<h1>Live example</h1>
			<div class="demo_jui">
						<div id="dynamic">
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th width="20%">Rendering engine</th>
			<th width="25%">Browser</th>
			<th width="25%">Platform(s)</th>
			<th width="15%">Engine version</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
	<tfoot>
		<tr>
			<th>Rendering engine</th>
			<th>Browser</th>
			<th>Platform(s)</th>
			<th>Engine version</th>
		</tr>
	</tfoot>
</table>
			</div>

			<div id ="operate" class="full_width big">
				<button onclick="" id ="delete">删除</button>
				<button onclick="toAdd()" id ="add">新增</button>
				<button onclick="update" id ="update">修改</button>
			</div>
		</div>
		
	</body>
</html>