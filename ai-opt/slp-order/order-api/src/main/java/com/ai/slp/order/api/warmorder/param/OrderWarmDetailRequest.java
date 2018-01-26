package com.ai.slp.order.api.warmorder.param;

import com.ai.opt.base.vo.BaseInfo;

public class OrderWarmDetailRequest extends BaseInfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单号
	 */
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
