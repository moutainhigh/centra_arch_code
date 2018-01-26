//扩展下拉函数
// var defaultHost = 'https://beta.yeekit.com/';
var defaultHost = '/';
$.fn.selectList = function (e, t, n) {
	if (this.data("select"))return !1;
	var r = this.find(".select").length > 0 ? this.find(".select") : this.find(".item-value"), i = this.find(".dropdown");
	return this.on("click", function (t) {
		var n = !0;
		"function" == typeof e && (n = e(this) !== !1), n && (i.slideToggle(90), $(this).toggleClass("active"))
	}), i.on("click", "li", function (e) {
		e.stopPropagation();
		var o = $(this), a = o.attr("value"), s = o.text();
		r.data("value", a).text(s), i.hide(), "function" == typeof t && t(this, a, n)
	}).on("hover", function (e) {
		$(this).closest("")
	}), this.data("select", 1)

}
//点击事件
var clickEvent = function () {
	$(".login-title").on("click", function () {
		var index = $(this).data("id");
		$(this).addClass("active").siblings(".login-title").removeClass("active");
		if (index < 2) {
			// $("#login-" + index).removeClass("hide").siblings(".login-right").addClass("hide");
			var typeId = $(this).data('id');
			$("input[name='typeId']").val(typeId);
		}
		if (index > 1) {
			var typeId = $(this).data('id');
			var typeArr = [2, 3];
			$('#type').val(typeId - 1);
			var otherId = typeId == typeArr[0] ? typeArr[1] : typeArr[0];
			$(".form [data-id=" + typeId + "]").removeClass("hide");
			$(".form [data-id=" + otherId + "]").addClass("hide");
		}
	});
	$("input").on("input", function () {
		$(this).removeClass("red").siblings("p.err").fadeOut();
	});
	$("input").on("blur", function () {
		if ($(this).attr("type") !== "checkbox" && !$(this).val().trim()) {
			$(this).addClass("red").siblings("p").fadeIn();
			return;
		}
	});
	$("input[type=checkbox]").on("change", function () {
		if ($(this).prop("checked")) {
			$(this).siblings("p").fadeOut();
		} else {
			$(this).siblings("p").fadeIn();
		}
	});

}
// 用户名输入框失去焦点 登录时检查用户名
function checkName(obj) {
	var name = $(obj).val();
	name = $.trim(name);
	// 检查是否为空
	if (0 == name.length) {
		$(obj).addClass("red").siblings("p").fadeIn().text(nameISNull);
		return false;
	}

	// 检查长度是否符合,20170614不检查最小长度
	if (1 > name.length || 32 < name.length) {
		$(obj).addClass("red").siblings("p").fadeIn().text(nameLengthError);
		return false;
	}
	return true;
}
function loginRole(){
	if(!checkName(document.getElementById('username'))){
		return false;
	}
	if(!checkPassWord(document.getElementById('password'))){
		return false;
	}
	var roleId=$("input[name='typeId']").val();
	setCookie('t',roleId,'168');
	return true;
}
function setCookie(cookiename, cookievalue, hours)
{
	var date = new Date();
	date.setTime(date.getTime() + Number(hours) * 3600 * 1000);
	document.cookie = cookiename + "=" + cookievalue + "; path=/;expires = " + date.toGMTString();
}
// 检查密码
function checkPassWord(obj) {
	var passWord = $(obj).val();
	passWord = $.trim(passWord);
	// 验证是否为空
	if (0 == passWord.length) {
		$(obj).addClass("red").siblings("p").fadeIn().text(passWordISNull);
		return false;
	}

	// 验证密码长度
	if (6 > passWord.length || 32 < passWord.length) {
		$(obj).addClass("red").siblings("p").fadeIn().text(passWordLengthError);
		return false;
	}

	var rege = /\D/g;
	// 验证密码格式
	if (!passWord.match(rege)) {
		// $(obj).addClass("red").siblings("p").fadeIn().text(passWordError);
		// return false; 为兼容老用户,去除不能纯数字的限制

	}

	// 如果正确，隐藏错误提示
	$(obj).removeClass("red").siblings("p").fadeOut();
	return true;
}

// 确认密码验证
function checkConfirmPassWord(obj) {
	var confirmPassWord = $(obj).val();
	confirmPassWord = $.trim(confirmPassWord);
	// 验证是否为空
	if (0 == confirmPassWord.length) {
		console.log(confirmPassWord.length)
		$(obj).addClass("red").siblings("p").fadeIn();
		return false;
	}

	var passWord = $(".password").val();
	$(".confirmPassWord").val();
	// 验证两次密码是否一致
	if (confirmPassWord != passWord) {
		console.log(11)
		$(obj).addClass("red").siblings("p").fadeIn().text(passWordConfirmation);
		return false;
	}

	// 如果正确，隐藏错误提示
	$(obj).removeClass("red").siblings("p").fadeOut();
	return true;
}
function init() {
	clickEvent();
	$('.item-select').selectList();
	var id=document.cookie.indexOf("t=1;")>0?1:0;
	$('.login-title[data-id='+id+']').click();
}
init();
