$(document).ready(function(){
	$(document).on('click','[name="chk-cell"]',function(){
		var len2 = $('.msg-position').parents('tr').length;
		var len1 = $('.msg-position.active').parents('tr').length + 1;
		if(!$(this).hasClass('active')){
			$(this).addClass('active');
		}else{
			$(this).removeClass('active');
		}
		if(len1 == len2){
			$('[name="chk-all"]').children('.msg-select-check').addClass('active');
		}else{
			$('[name="chk-all"]').children('.msg-select-check').removeClass('active');
		}
    });

	//È«Ñ¡¿ØÖÆ
	$(document).on('click','[name="chk-all"]',function(){
		if(!$(this).children('.msg-select-check').hasClass('active')){
			$(this).children('.msg-select-check').addClass('active');
			$('[name="chk-cell"]').addClass('active');
		}else{
			$(this).children('.msg-select-check').removeClass('active');
			$('[name="chk-cell"]').removeClass('active');
		}
	});

	$('#delAll').on('click',function(){
		$("[name='chk-cell']").each(function(){
			if ($(this).hasClass('active')) {
				$(this).parents('tr').remove();
			}
		})
	});

	$("#readMore").bind("click",function(){
		$("#newMsg").attr('src',"images/message-read.png");
		if($("#detail").css("display") == "none"){
			$("#detail").removeClass("msg-detail");
		}else{
			$("#detail").addClass("msg-detail");
		}
	})
});
  	