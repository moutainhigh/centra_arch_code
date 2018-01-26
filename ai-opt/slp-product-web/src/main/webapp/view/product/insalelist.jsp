<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>运营管理</title>
	<%@ include file="/inc/inc.jsp" %>
</head>

<body>
<div class="content-wrapper-iframe"><!--右侧灰色背景-->
	<div class="row"><!--外围框架-->
		<div class="col-lg-12"><!--删格化-->
			<div class="row"><!--内侧框架-->
				<div class="col-lg-12"><!--删格化-->
					<div class="main-box clearfix"><!--白色背景-->
						<!-- 查询条件 -->
						<div class="form-label">

							<ul>
								<li class="col-md-12">
									<p class="word">商品名称</p>
									<p><input id="productName" type="text" class="int-text int-medium"></p>
									<p class="sos"><a href="javascript:void(0);">高级搜索<i class="fa fa-caret-down"></i></a>
									</p>
								</li>
							</ul>
							<!--点击展开-->
							<div id="selectDiv" class="open" style="display:none;">
								<ul>
									<li class="col-md-6">
										<p class="word">商品ID</p>
										<p><input id="standedProdId" type="text" class="int-text int-medium"></p>
									</li>
									<li class="col-md-6">
										<p class="word">商品类型</p>
										<p>
											<select id="productType" class="select select-medium">
												<option value="">全部</option>
												<option value="1">实物</option>
												<option value="2">虚拟</option>
											</select>
										</p>
									</li>
								</ul>
								<ul>
									<li class="col-md-6">
										<p class="word">上架开始时间</p>
										<p><input type="text" class="int-text int-medium" id="upStartTime"
												  readonly="true" onfocus="WdatePicker({readOnly:true});">
											<span class="time"> <i class="fa  fa-calendar" ></i></span></p>
									</li>
									<li class="col-md-6">
										<p class="word">上架结束时间</p>
										<p><input type="text" class="int-text int-medium" id="upEndTime"
												  readonly="true" onfocus="WdatePicker({readOnly:true})">
											<span class="time"> <i class="fa  fa-calendar" ></i></span>
										</p>
									</li>
								</ul>
								<%-- 类目 --%>
								<ul id="data1ProdCat">
									<li class="col-md-12">
										<p class="word">商品类目</p>
										<p id="productCat0">
											<select id="catFirst" class="select select-small" onChange="pager._selectChange(this);">
												<option value="">全部</option>
												<c:forEach var="info" items="${catInfoList}">
													<option value="${info.productCatId}">${info.productCatName}</option>
												</c:forEach>
											</select>
										</p>
										<script id="prodCatTemple" type="text/template">
											<p id="productCat{{:level}}">
												<select class="select select-small" onChange="pager._selectChange(this);">
													{{for prodCatList}}
													<option value="{{:productCatId}}">{{:productCatName}}</option>
													{{/for}}
												</select>
											</p>
										</script>
									</li>
								</ul>
							</div>
								<ul>
									<li class="width-xlag">
										<p class="word">&nbsp;</p>
										<p><input type="button" class="biu-btn  btn-primary btn-blue btn-medium ml-10"
												  id="selectProductList" value="查  询"></p>
									</li>
								</ul>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row"><!--外围框架-->
		<div class="col-lg-12"><!--删格化-->
			<div class="row"><!--内侧框架-->
				<div class="col-lg-12"><!--删格化-->
					<div class="main-box clearfix"><!--白色背景-->
						<!--标题-->
						<header class="main-box-header clearfix">
							<h2 class="pull-left">在售商品列表</h2>
						</header>
						<!--标题结束-->
						<div class="main-box-body clearfix">
							<!--table表格-->
							<div class="table-responsive clearfix">
								<table class="table table-hover table-border table-bordered">
									<thead>
									<tr>
										<th>商品ID</th>
										<th>所属类目</th>
										<th>商品类型</th>
										<th>预览图</th>
										<th>商品名称</th>
										<th>商品状态</th>
										<th>上架时间</th>
										<th>操作</th>
									</tr>
									</thead>
									<tbody id="searchNormProductData">
									</tbody>

								</table>
								<div id="showMessageDiv"></div>
								<script id="searchNormProductTemple" type="text/template">
									<tr>
											<td>{{:standedProdId}}</td>
											<td>
												<div class="hind1 text-l pl-15">
												<div class="center-hind" >{{:productCatName}}</div>
                                          		<div class="showbj showbj1"><i class="fa fa-posi fa-caret-up"></i>{{:productCatName}}</div>
												</div>
											</td>
											<td>{{:productTypeName}}</td>
											{{if picUrl==null || picUrl==""}}
											<td><img src="${_slpres}/images/sp-03-a.png"></td>
											{{else}}
											<td><img src="{{:picUrl}}"></td>
											{{/if}}
											<td>
												<div class="hind1 text-l pl-15">
												<div class="center-hind" >{{:prodName}}</div>
                                          		<div class="showbj showbj1"><i class="fa fa-posi fa-caret-up"></i>{{:prodName}}</div>
												</div>
											</td>
											<td>{{:stateName}}</td>
											<td>{{:~timesToFmatter(upTime)}}</td>
											<td>
												<div>
													<!-- <p><a href="${_base}/prodedit/{{:prodId}}" class="blue-border">编辑商品</a></p> -->
													<p><a href="${_base}/prodedit/{{:prodId}}" class="blue-border">编辑商品</a></p>
													<p><a name="downsaleBtnView" prodId="{{:prodId}}" href="#" class="blue-border">下架商品</a></p> 
												</div>
											</td>
										</tr>
								</script>
							</div>
							<!--分页-->
							<div class="paging">
								<ul id="pagination-ul">
								</ul>
							</div>
							<!--分页结束-->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	var pager;
	var count = '${count}';
	var prodInfoList = '${prodInfoList}';
	var productEditInfo = '${productEditInfo}';
	(function () {
		<%-- 展示日历 --%>
		$('#selectDiv').delegate('.fa.fa-calendar','click',function(){
			var calInput = $(this).parent().prev().focus();
		});
		<%-- 高级区域 --%>
		$(".form-label ul li .sos a").click(function () {
			$(".open ").slideToggle(100);
			$(".nav-form ").toggleClass("reorder remove");
		});
		<%-- 商品下架弹框 --%>
		$('#searchNormProductData').delegate("a[name='downsaleBtnView']", 'click', function () {
			var productId = $(this).attr('prodId');
			if (window.console) {
				console.log("编辑链接:" + productId);
			}
            pager._showDownSale(productId);
        });
		
		seajs.use(['app/jsp/product/insalelist','app/util/center-hind'], function(insalelist,centerHind) {
			pager = new insalelist({element : document.body});
			pager.render();
			new centerHind({element : document.body}).render();
		});
	})();
</script>
</html>