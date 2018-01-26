/**
 @document
 @author:Yujianping
 @tel:13716506521
 @date:2012-4-7
 @param(string) fx 图片切换方法 默认值为fade,共五种特效，分别为fade(渐变),scrollLeft(从右向左),scrollRight(从左向右),
                   scrollUp(从下到上),scrollDown(从上到下)
 @param(int) speed 图片特效时长 默认值为400
 @param(int) timeout 图片切换间隔时长 默认为4000
 @param(bool) pause 鼠标滑动图片时是否暂停 默认为false
 @param(string) pager 动态生成数字的ID 默认值为null
 @param(string) pagerEvent 数字绑定事件方式 默认值为null，一般为mouseover和click
 @example 使用示例
 @        $("#slide").cycleSlider({
 @			  fx:"fade",
 @			  speed:400,
 @			  timeout:4000,
 @			  pause:true,
 @			  pager:"#slideNum",
 @			  pagerEvent:"click"
 @		 });
 **/
;(function($){

	$.fn.cycleSlider = function(options){
		
		// 定义默认参数
		var data = {
			fx:"fade",
			speed:400,
			timeout:4000,
			pause:false,	
			pager:null,
			pagerEvent:null
		}

		// 将传入的参数覆盖默认参数
		$.extend(data,options);
		
		// 取滑动id,fx,speed等参数,并初始化变量
		var fx = data.fx,
			speed = data.speed,
			timeout = data.timeout,
			pause = data.pause,	
			pager = data.pager,
			pagerEvent = data.pagerEvent,
			index = 0,
			numHtml = '',
			cycleTimer = '',
			cycleOverTimer = '',
			_this = this;

		// 获取滚动内容的长度
		var len = $(_this).find("li").length;

		if(len == 1){
			return false;
		}
		
		// 设置滚动数字的html
		if(pager){
			
			// 循环打印数字内容
			for(var i = 1;i <= len;i++){
				numHtml += "<li>" + i + "</li>";
			}

			$(pager).html(numHtml);

			// 鼠标事件滚动
			$(pager).find("li").mouseover(function(){
				if(pause){
					clearInterval(cycleTimer);
				}
			}).mouseout(function(){
				clearTimeout(cycleOverTimer);
				$(_this).trigger("mouseleave");
			}).bind(pagerEvent,function(){
				
				if(!pause){
					clearInterval(cycleTimer);
				}

				var __this = this;

				cycleOverTimer = setTimeout(function(){
					var prev =index;
					index  =  $(pager).find("li").index(__this);

					if(prev != index){
						
						// 执行图片切换效果和数字切换			
						$.fn.cycleSlider.transitions[fx]($(_this).find("li"),prev,index,speed);
						$(pager).find("li").removeClass("active").eq(index).addClass("active");
					}
				},200);

				return false;
			});
		}

		// 初始化当前显示的图片
		switch(fx){
			case "fade":
				$(_this).find("li").css({"opacity":0,"zIndex":"100"});
				$(_this).find("li").eq(index).css({"opacity":1,"zIndex":"109"});
				break;
			case "scrollLeft":
				var wid = $(_this).find("img").width();					
				$(_this).find("li").css({"left":-wid,"display":"none"});
				$(_this).find("li").eq(index).css({"left":0,"display":"block"});
				break;
			case "scrollRight":
				var wid = $(_this).find("img").width();					
				$(_this).find("li").css({"left":wid,"display":"none"});
				$(_this).find("li").eq(index).css({"left":0,"display":"block"});
				break;
			case "scrollUp":
				var hei = $(_this).find("img").height();					
				$(_this).find("li").css({"top":-hei,"display":"none"});
				$(_this).find("li").eq(index).css({"top":0,"display":"block"});
				break;
			case "scrollDown":
				var hei = $(_this).find("img").height();					
				$(_this).find("li").css({"top":hei,"display":"none"});
				$(_this).find("li").eq(index).css({"top":0,"display":"block"});
				break;
		}
		// 初始化当前显示数字效果
		if(pager !== null){
			$(pager).find("li").removeClass("active").eq(index).addClass("active");
		}
		
		// 自动滚动
		if(pause){
			$(_this).mouseover(function(){
				clearInterval(cycleTimer);
			});	
		}

		// 循环滚动
		$(_this).mouseout(function(){
			
			// 指定间隔时间执行切换
			cycleTimer = setInterval(function(){
									
				// 循环递增变量
				var prev =index;
				index++;
				if(index==len){
					index=0;
				}
				
				// 执行图片切换效果
				$.fn.cycleSlider.transitions[fx]($(_this).find("li"),prev,index,speed);

				// pager不为空才执行数字切换
				if(pager !== null){
					$(pager).find("li").removeClass("active").eq(index).addClass("active");
				}
			},timeout);
		}).trigger("mouseleave");
	}

	// 创建过渡对象
	$.fn.cycleSlider.transitions = {
		// 渐变效果
		fade:function($con,prev,index,speed){
			$con.stop(true,true).eq(index).animate({
				"opacity":"1",
				"z-index":"109"
			},speed);
			$con.eq(prev).animate({
				"opacity":"0",
				"z-index":"100"
			},speed);
		}
	}

	// 向左滚动
	$.fn.cycleSlider.transitions.scrollLeft = function($con,prev,index,speed){
		var wid = $con.width();
		
		$con.eq(prev).css({"left":0,"display":"block"});
		$con.eq(index).css({"left":wid,"display":"block"});
		
		$con.stop(true,true).eq(prev).animate({
			"left":-wid
		},speed,function(){
			$con.eq(prev).css("display","none");
		});
		
		$con.eq(index).animate({
			"left":0
		},speed);
	}
	
	// 向右滚动
	$.fn.cycleSlider.transitions.scrollRight = function($con,prev,index,speed){
		var wid = $con.width();
		
		$con.eq(prev).css({"left":0,"display":"block"});
		$con.eq(index).css({"left":-wid,"display":"block"});
		
		$con.stop(true,true).eq(prev).animate({
			"left":wid
		},speed,function(){
			$con.eq(prev).css("display","none");
		});
		
		$con.eq(index).animate({
			"left":0
		},speed);
	}

	// 向上滚动
	$.fn.cycleSlider.transitions.scrollUp = function($con,prev,index,speed){
		var hei = $con.height();
		
		$con.eq(prev).css({"top":0,"display":"block"});
		$con.eq(index).css({"top":hei,"display":"block"});
		
		$con.stop(true,true).eq(prev).animate({
			"top":-hei
		},speed,function(){
			$con.eq(prev).css("display","none");
		});
		
		$con.eq(index).animate({
			"top":0
		},speed);
	}

	// 向下滚动
	$.fn.cycleSlider.transitions.scrollDown = function($con,prev,index,speed){
		var hei = $con.height();
		
		$con.eq(prev).css({"top":0,"display":"block"});
		$con.eq(index).css({"top":-hei,"display":"block"});
		
		$con.stop(true,true).eq(prev).animate({
			"top":hei
		},speed,function(){
			$con.eq(prev).css("display","none");
		});
		
		$con.eq(index).animate({
			"top":0
		},speed);
	}
})(jQuery);