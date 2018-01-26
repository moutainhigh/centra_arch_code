<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
//锁定一次订购
long myOID =System.currentTimeMillis();
request.setAttribute("myOID", myOID);
%>
<%--基于jquery的 浮动提示信息 --%>
<script type="text/javascript" src="${_base}/js/jquery/validate/commonPrompt.js"></script>
<script  type="text/javascript" src="${_base}/js/checkUtil.js"></script>
<script type="text/javascript" src="${_base}/js/jquery/validate/card.js"></script>
<script type="text/javascript">
	var pageManager2;
	//var jyFlag =false;
	$(document).ready(function() {
		pageManager2 = new $.PageManager2();
		$(".yuan").each(function(i,d){
			$(d).text(fenToYuan($(d).text()));
		});
	});
	(function(){
		$.PageManager2 = function(){
			this.settings = $.extend(true,{},$.PageManager2.defaults);
			this.init();
		};
		$.extend($.PageManager2,{
			defaults:{
				FORM_ID : "#myForm"
			},
			prototype:{
				init:function(){
					var _this = this;
					_this.bindEvents();
					//_this.addValidRules();
					
				},
				bindEvents : function(){
					var _this = this;
					//给号码字段a标签绑定事件
					//选择号码事件
					$("#queryNumbers").bind("click",function(){
							$("#custInfoDisplay").hide();
							busiInit(1,"${myOID}");
							$("#infoShow").hide();
							if($.trim($("#xy_input").val())==""){
								showPromptDivByEleId("请输入查询号码", "xy_input","top",180,30);
								return false;
							}
							if($("#zjType").val()=="num"){
								var serNum =$("#xy_input").val();
							    if(serNum!='' && checkPhone(serNum)==false){
									showPromptDivByEleId("请输入正确的服务号码", "xy_input","top",180,30);
									return false;
							    }
							} 
							if($("#zjType").val()=="01"){
								var certNum =$("#xy_input").val();
							    if(certNum!='' &&  idCardNoUtil.checkIdCardNo(certNum)==false){
									showPromptDivByEleId("请输入正确的身份证号码", "xy_input","top",180,30);
									return false;
							    }
							}
							if($("#zjType").val() !="num" && $("#zjType").val() !="01"){
								var certNum = $('#xy_input').val();
								var reg1 =/^[A-Za-z0-9]{0,19}$/;
								if(validLength($("#xy_input").val(),[32])){
									showPromptDivByEleId("长度不能大于16个汉字或32个字母（数字）", "xy_input","top",180,30);
									return false;
								}
							}
							changeDisplay(2);
							
							var zjType =$("#zjType").val();
							var zjNum =$("#xy_input").val();
							
							if(zjType !="num"){
								$("#queryIdDisplay").show();
								certQueryInfo(zjType,zjNum);
								busiInit(1,"${myOID}");
								$("#custInfoDisplay").hide();
							}
							if(zjType =="num"){
								$("#serviceNum").val(zjNum);
								groupNumQueryInfo(zjType,zjNum);
								return false;
							}
							return false;
							
						
						
					});
					//确认选择事件
					
					
					
				}
			}
			 
			
		});
	})(jQuery);
	
	
	
	function certQueryInfo(type,number){
		$("#faildInfo").text("");
		var nurl ="${_base}/busichg/common/queryGroupByZj";
		//location.href =nurl;
		var param ={
				zjType:type,
				zjNum :number
		}
		 $.ajax({
			async : false,
			type : "POST",
			url : nurl,
			modal : true,
			showBusi : false,
			data : param,
			success: function (data) {
				$("#queryIdDisplay").empty();
				$("#queryIdDisplay").html(data);
				
				$("input.selected").bind("click",function(){
					var aa = $("input[name='radio']:checked").val();
					$("#radioSelected").val(aa);
					
				})
				$("#comfirmSelected").bind("click",function(){
					var val=$("input[name='radio']:checked").val();
					if(val==null){
						//$.dialog.alert("请先选中一个服务号码");
						$("#infoShow").show();
					 	$("#faildInfo").text("请先选中一个服务号码");
						return false;
					}
					changeDisplay(0);
					var number =$("#radioSelected").val();
					$("#numSelected").text("已选定号码："+number+"  ");
					$("#selectedDisplay").show();
					$("#serviceNum").val(number);
					groupNumQueryInfo("num",number);
				});
				//return false;
		    },
			 error:function (data){
				 changeDisplay(2);
				 $("#custInfoDisplay").hide();
				 busiInit(1,"${myOID}");
				 //alert(222);
				 $("#infoShow").show();
				 $("#faildInfo").text("该证件号码对应的用户信息不存在");
			 } 

		}); 
		
	}
	 
	function groupNumQueryInfo(serType,serNum){
		$("#faildInfo").text("");
		var serPwd = $("#xy_password").val();
		var busiCode = $("#busiCode").val();
		var isValidate =$("#isValidate").val();
		var url ="${_base}/busichg/common/queryGroupInfoByGroupId?myOID=${myOID}";
		var param={
				serNum :serNum,
				serPwd :serPwd,
				busiCode :busiCode,
				isValidate :isValidate
		}
		$.ajax({
			async : false,
			type : "POST",
			url : url,
			modal : true,
			showBusi : false,
			data : param,
			success: function (data) {
				try{
				var $json=$.parseJSON(data);
				var jsonObject = $json.RES_DATA;
				if($json.RES_RESULT=="SUCCESS"){
					var productName = jsonObject.product.substring(0,15);
					var invoiceName = jsonObject.invoiceName.substring(0,15);
					if(invoiceName.length > 15){
						$("#invoiceName").text(invoiceName+"...");
					}else{
						$("#invoiceName").text(jsonObject.invoiceName);
					}
					if(productName.length > 15){
						$("#product").text(productName+"...");
					}else{
						$("#product").text(jsonObject.product);
					}
					$("#invoiceName").attr("title",jsonObject.invoiceName);
					$("#product").attr("title",jsonObject.product);
					
					$("#custInfoDisplay").show();
					$("#name").text(jsonObject.name);
					$("#certType").text(jsonObject.certType);
					$("#certNum").text(jsonObject.certNum);
					$("#groupId").text(jsonObject.groupId);
					$("#groupAddr").text(jsonObject.groupAddr);
					$("#mainNum").text(jsonObject.mainNum);
					$("#maxMember").text(jsonObject.maxMember);
					$("#owingFee").text(liToYuan(jsonObject.owingFee));
					$("#createDate").text(jsonObject.enterTime);
					$("#currentFee").text(liToYuan(jsonObject.currentFee));
					
					$("#payType").text(jsonObject.payType);
					$("#nowMember").text(jsonObject.nowMember);
					$("#postType").text(jsonObject.postType);
					$("#callLevel").text(jsonObject.callLevel);
					$("#roamStatus").text(jsonObject.roamLevel);
					busiInit(0,"${myOID}");
					$("#infoShow").hide();
					//调用服务查询旧卡信息---此处不属于公共部分，各位根据业务需要填充。
					
					
					return false;
				}else{
					$("#custInfoDisplay").hide();
					busiInit(1,"${myOID}");
					$("#infoShow").show();
					$("#faildInfo").text($json.RES_MSG);
					return false;
				}
				
				}catch(e){
					$("#errorDivFormSysFrame").empty();
					$("#errorDivFormSysFrame").html(data);
					return false;
				}
		    }

		}); 
		
	}
	//分转换成元
	 function fenToYuan(fen){
	 	var quyu=(parseInt(fen)%100);
	 	if(quyu<10){
	 		return (parseInt(parseInt(fen)/100))+".0"+(parseInt(fen)%100);
	 	}else if(quyu==0){
	 		return (parseInt(parseInt(fen)/100))+".00";
	 	}else{
	 		return (parseInt(parseInt(fen)/100))+"."+(parseInt(fen)%100);
	 	}
	 	
	 }
	//厘转换成元
	/* function liToYuan(li){
		var quyu=(parseInt(li)%1000);
	 	if(quyu<10){
	 		return (parseInt(parseInt(li)/1000))+".0"+(parseInt(li)%1000);
	 	}else if(quyu==0){
	 		return (parseInt(parseInt(li)/1000))+".00";
	 	}else{
	 		return (parseInt(parseInt(li)/1000))+"."+(parseInt(li)%1000);
	 	}
		
	} */
	
	function liToYuan(li){
		return (li/1000).toFixed(2);
	}
	
	function hidePass(){
		$("#selectedDisplay").hide();
		$("#infoShow").hide();
		var zjType = $("#zjType").val();
		if(zjType !="num"){
			$("#aaa").hide();
			$("#bbb").hide();
		}else{
			$("#aaa").show();
			$("#bbb").show();
		}
		
	}
	
	function changeDisplay(value){
		if(value =="0"){
			$("#queryIdDisplay").hide();
			$("#selectedDisplay").show();
			
		}
		if(value =="1"){
			$("#queryIdDisplay").show();
			$("#selectedDisplay").hide();
			
		}
		if(value =="2"){
			$("#queryIdDisplay").hide();
			$("#selectedDisplay").hide();
			
		}
		
	}
	
	 function checkPhone(phoneNum){
    	 var isMobile = /^0?[1][34578]\d{9}$/;
    	 //var isPhone=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
    	  alert(phoneNum);
    	 if(!isMobile.test(phoneNum)){
    		
             return false;
         }
    	 return true;
    };
    
    function trim(str){   
	     return str.replace(/^(\s|\u00A0)+/,'').replace(/(\s|\u00A0)+$/,'');   
	 }
   function validLength(value,options) {
		var val = trim(value);
	   	var real = options[0];
	   	return realLength(val)>real;
	}

	function realLength(str) {
	    ///<summary>获得字符串实际长度，中文2，英文1</summary>
	    ///<param name="str">要获得长度的字符串</param>
	    var realLength = 0, len = str.length, charCode = -1;
	    for (var i = 0; i < len; i++) {
	        charCode = str.charCodeAt(i);
	        if (charCode >= 0 && charCode <= 128) realLength += 1;
	        else realLength += 2;
	    }
	    return realLength;
	};
</script>
       <!--客户信息-->
   <div id="errorDivFormSysFrame" style="display:none;">
		</div>
          <!--查询区域-->
 <div class="big_main" >
         <div class="big_title">
	     <p>业务受理查询区</p>
	   	</div>
	      <input type ="text" id ="radioSelected"  style="display:none" /> 
	     <input type ="text" id ="cartTypeId"  style="display:none" />  
	     <input type ="text" id ="myOID" name ="myOID" value="${myOID}" style="display:none" /> 
	     <input type="text" id="serviceNum" name ="serviceNum" style="display:none"> 
	     <input type="text" id="busiCode" name ="busiCode" style="display:none" value="${busiCode}"> 
	     <input type="text" id="isValidate" name ="isValidate" style="display:none" value="${ISVALIDATE}">   
     <div class="">
 		<div class="fuw_query">
        <ul>
          <li>
              <c:if test="${queryType eq 0}">
              	<p>
		        <ifudata:select dictId="QUERY_SUB_USERS.USERS_SERVICE_01" name="zjType" id="zjType" styleClass="query_xia2"  filters="num"  defaultValue ="01" ></ifudata:select>
		        </p>
		        <p>
              	<input name="xy_input" type="text" id="xy_input" class="query_input" maxlength="20" />
           	 	</p>
		      </c:if>
		      <c:if test="${queryType eq 1}">
              	<p>
		        <ifudata:select dictId="QUERY_SUB_USERS.USERS_SERVICE_01" name="zjType" id="zjType" styleClass="query_xia2"    defaultValue ="num" ></ifudata:select>
		        </p>
		        <p>
              	<input name="xy_input" type="text" id="xy_input" class="query_input"  maxlength="20"/>
           	 	</p>
		      </c:if> 
		      <c:if test="${queryType eq 2}">
              	<p>
		        <ifudata:select dictId="QUERY_SUB_USERS.USERS_SERVICE_01" name="zjType" id="zjType" styleClass="query_xia2"  filters="06,09"  defaultValue ="num" onchange="hidePass()"></ifudata:select>
		        </p>
		        <p>
              	<input name="xy_input" type="text" id="xy_input" class="query_input" />
           	 	</p>
           	 	<p id="aaa" >
					  <span sytle="width:100px">服务密码：</span>
				</p>
				<p id="bbb" >
					  <input name="password" type="password" class="query_input" id="xy_password"  />
				</p>
		      </c:if>  
            
            
            	<p class="query_zhij"><a href="javascript:void(0);" id="queryNumbers">查询</a></p>
            	
             	<p class="ry_banli" style="display:none" id="selectedDisplay"><span id ="numSelected"></span> <a href="javascript:changeDisplay(1);">&nbsp;&nbsp; 重新选择</a></p>
            
          </li>
        </ul>
      </div>
      <!--隐藏区域-->
    <div  id="queryIdDisplay" >
      
	</div>
	</div>
	<input id ="queryType" type ="text" style="display:none" value ="${queryType}"/>
</div>
     <div class="dd_xians" style="display:none" id="infoShow">
	    <ul>
	      <li>
	        <p class="ry_tishi" id="faildInfo"></p>
	      </li>
	    </ul>
	  </div>
     
   		<div class="big_main"  id ="custInfoDisplay" style="display:none">
   			<div class="big_title">
         		<p>业务基本信息</p>
  			</div>
               
                 <div class="query_main_sanlie">
                	<ul>
			           <li>
			             <p class="query_zi">客户名称：</p>
			             <p class="query_zi_right" id ="name"></p>
			           </li>
			           <li>
			             <p class="query_zi">证件类型：</p>
			             <p class="query_zi_right" id ="certType"> </p>
			           </li>
			           <li>
			             <p class="query_zi">证件号码：</p>
			             <p class="query_zi_right" id ="certNum"></p>
			           </li>
			         </ul>
			         <ul>
			           <li>
			             <p class="query_zi">群组标识：</p>
			             <p class="query_zi_right" id="groupId"></p>
			           </li>
			          
			           <li>
			             <p class="query_zi">主号码：</p>
			             <p class="query_zi_right" id="mainNum"></p>
			           </li>
			            <li>
			             <p class="query_zi">群组创建时间：</p>
			             <p class="query_zi_right" id ="createDate"></p>
			             <p class="query_zi_right">&nbsp;</p>
			           </li>
			           
			         </ul>
			         
			          <ul>
			           <li>
			             <p class="query_zi">群组主产品：</p>
			             <p class="query_zi_right" id="product" title =""></p>
			           </li>
			          
			           <li>
			             <p class="query_zi">群组成员上限：</p>
			             <p class="query_zi_right" id ="maxMember"></p>
			             <p class="query_zi_right">&nbsp;</p>
			           </li>
			          <li>
			             <p class="query_zi">当前群组成员数：</p>
			             <p class="query_zi_right" id="nowMember"></p>
			             <p class="query_zi_right">&nbsp;</p>
			           </li>
			         </ul>
			         <ul>
			           <li>
			             <p class="query_zi">账户/发票名称：</p>
			             <p class="query_zi_right" id="invoiceName"></p>
			           </li>
			             <li>
			             <p class="query_zi">可用余额(元)：</p>
			             <p class="query_zi_right" id ="owingFee"></p>
			             <p class="query_zi_right">&nbsp;</p>
			           </li>
			           <li>
			             <p class="query_zi">当月话费(元)：</p>
			              <p class="query_zi_right" id="currentFee"></p>
			             <p class="query_zi_right">&nbsp;</p>
			           </li>
			         </ul>
			         <ul>
			          
			          
			            
			         </ul>
                  </div> 
              
              </div> 
          <!--查询区域-->

