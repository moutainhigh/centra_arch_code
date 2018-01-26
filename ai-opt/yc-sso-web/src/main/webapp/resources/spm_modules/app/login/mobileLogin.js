//查询国家
function loadCountry(){
			$.ajax({
				type: "post",
				processing: true,
	    		url: _base + "/mobileLogin/loadCountry",
	    		
	    		success: function(data) {
	    			if(data.statusCode == '1'){
	    				var html = [];
						for (var i = 0; i < data.data.length; i++) {
							var t = data.data[i];
							var _code = t.countryCode;
							var name = t.countryNameCn;
							if ("zh_CN" != currentLan) {
								name = t.countryNameEn;
							}
							
							/*<option value="">中国 　　　　　　　　　 +86</option>*/
							
							html.push('<option country_value="'+t.countryValue+'" reg="'
									+ t.regularExpression
									+ '" value="' + _code
									+ '" >' + name + '+'
									+ _code + '</option>');
						}
						$("#selectcountry").html(html.join(""));
	    			}
	    		}
	    	});
        			
        		
    }

function mobiledologin() {
	  if(mobilevalidate()){ 
		  
		 // var mobilereg = $("#selectcountry").find("option:selected").attr("reg");
		  var username = $.trim(document.getElementById("mobile").value);
		  var inputPassword = document.getElementById("mobilepassword").value;
		  var mobilecaptchaCode = document.getElementById("mobilecaptchaCode").value;
		  
          $("#fmUsername").val(username);
          $("#fmUserpass").val(inputPassword);
          $("#fmCaptchaCode").val(mobilecaptchaCode);
          $("#loginType").val("1");
		  //提交表单
		  document.getElementById('fm2').submit();
		  return true;
	  }
	  else{
		  return false;
	  } 
	  
}//end of dologin



function mobilevalidate() {

	var mobilereg = $("#selectcountry").find("option:selected").attr("reg");
	var countrycode = $("#selectcountry").find("option:selected").attr("value");
	var mobile=$("#mobile").val();
	var mobilepassword=$("#mobilepassword").val();
	var mobilecaptchaCode = document.getElementById("mobilecaptchaCode").value;
	var mobilecode = countrycode+mobile;
	var re = new RegExp(mobilereg);
    if(mobile=="Username/Mobile/Email"){
    	mobile="";
		$("#mobile").val("");
    }
    if(mobilepassword=="Password"){
    	mobilepassword="";
		$("#mobilepassword").val("");
    }
	try {
		if (isNull(mobile)) {			
			showErrMsg($.i18n.prop('authenticationFailure.UserphoneIsNullException'));
			return false;
		}else{
			resetErrMsg();
		}
		if (isNull(mobilepassword)) {
			showErrMsg($.i18n.prop('authenticationFailure.MobilepasswordIsNullException'));
			return false;
		}else{
			resetErrMsg();
		}
		
		if(!re.test(mobilecode)){  
			showErrMsg($.i18n.prop('authenticationFailure.UserphoneIsErrorException')); 
//			showErrMsg("请输入正确手机号"); 
           return false; 
	     }else{
				resetErrMsg();
		}
		
		if(errorNum>=errorNumCCS){
			//var captcha=$("#mobilecaptchaCode").val();	
			if(mobilecaptchaCode=="Verification code"){
				mobilecaptchaCode="";
				$("#mobilecaptchaCode").val("");
		    }
			if (isNull(mobilecaptchaCode)) {
				showErrMsg($.i18n.prop('authenticationFailure.CaptchaIsNullException'));
				return false;
			}else{
				resetErrMsg();
			}
		}
		
		
		return true;
	} catch (ex) {
		return false;
	} 			
}//end of validate


//发送手机验证码
$(document).on('click', '#getmobilepassword', function () {
	
	sendSmsCode();

    });


var smsObj; // timer变量，控制时间
var count; // 间隔函数
var curCount;// 当前剩余秒数


function sendSmsCode() {
	count = 120; 
	curCount = count;
	if(getpassvalidate()){
		var mobile=$("#mobile").val();
		var type = "3";
		var btn = $("#getmobilepassword");
		var countryValue = $("#selectcountry").find("option:selected").attr("value");
		$.ajax({
			type: "post",
			processing: true,
			data:{"mobile":mobile,"type":type,"countryValue":countryValue},
			url: _base + "/mobileLogin/sendMobileSmsCode",
			
			success : function(json) {
				$("#errorMsg").html(sendMsg.sendsuccess);
				btn.val(curCount+"S "+sendMsg.resend)
/*				btn.val(curCount+"S "+"后重发")
*/				.removeClass("btn-green")
				.addClass("biu-btn")
				.attr("style","color:#fff;");
				smsObj = setInterval(
				"startSmsTime();",
				1000); // 启动计时器，1秒执行一次
			}
		});
	}
	
}

function startSmsTime() {
	if (curCount == 1) {
		window.clearInterval(smsObj);// 停止计时器
		$("#getmobilepassword").val(
				sendMsg.getcode).removeClass(
				"biu-btn").addClass("btn-green");
	} else {
		curCount = curCount - 1;
		$("#getmobilepassword").val(curCount+"S "+sendMsg.resend);
	}
}



function getpassvalidate() {

	var mobilereg = $("#selectcountry").find("option:selected").attr("reg");
	var countrycode = $("#selectcountry").find("option:selected").attr("value");
	var mobile=$("#mobile").val();
	var mobilecaptchaCode = document.getElementById("mobilecaptchaCode").value;
	var mobilecode = countrycode+mobile;
	var re = new RegExp(mobilereg);
    if(mobile=="Username/Mobile/Email"){
    	mobile="";
		$("#mobile").val("");
    }
	try {
		if (isNull(mobile)) {			
			showErrMsg($.i18n.prop('authenticationFailure.UsernameIsNullException'));
			return false;
		}else{
			resetErrMsg();
		}
		if (isNull(mobilecaptchaCode)) {
			showErrMsg("请输入验证码");
			return false;
		}else{
			resetErrMsg();
		}
		if(!re.test(mobilecode)){  
		   showErrMsg("请输入正确手机号"); 
           return false; 
	     }else{
				resetErrMsg();
		}
		
		if(errorNum>=errorNumCCS){
			//var captcha=$("#mobilecaptchaCode").val();	
			if(mobilecaptchaCode=="Verification code"){
				mobilecaptchaCode="";
				$("#mobilecaptchaCode").val("");
		    }
			if (isNull(mobilecaptchaCode)) {
				showErrMsg($.i18n.prop('authenticationFailure.CaptchaIsNullException'));
				return false;
			}else{
				resetErrMsg();
			}
		}
		
		
		return true;
	} catch (ex) {
		return false;
	} 			
}//end of validate

//手机框失焦校验
function mobileBlurValidate(){
	var mobilereg = $("#selectcountry").find("option:selected").attr("reg");
	var countrycode = $("#selectcountry").find("option:selected").attr("value");
	var mobile=$("#mobile").val();
	var mobilecode = countrycode+mobile;
	var re = new RegExp(mobilereg);
	if (isNull(mobile)) {			
		showErrMsg($.i18n.prop('authenticationFailure.UserphoneIsNullException'));
		return false;
	}else{
		resetErrMsg();
	}
	if(!re.test(mobilecode)){  
		showErrMsg($.i18n.prop('authenticationFailure.UserphoneIsErrorException')); 
//		showErrMsg("请输入正确手机号"); 
       return false; 
     }else{
			resetErrMsg();
	}
}

