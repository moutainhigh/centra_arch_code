package com.ai.slp.order.vo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class OFCAfterSaleOrderCreateRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单号
	 */
	@JSONField(name="OrderNo")
	private String orderNo;
	
	/**
	 * 外部申请单号
	 */
	@JSONField(name="ExternalApplyNo")
	private String externalApplyNo;
	
	/**
	 * 申请类型
	 */
	@JSONField(name="ApplyType")
	private int applyType;
	
	/**
	 * 申请原因
	 */
	@JSONField(name="ReasonType")
	private int reasonType;
	
	/**
	 * 原因描述
	 */
	@JSONField(name="Description")
	private String description;
	
	/**
	 * 退款金额
	 */
	@JSONField(name="RefundAmount")
	private long refundAmount;
	
	/**
	 * 申请时间
	 */
	@JSONField(name="ApplyTime")
	private String applyTime;
	
	/**
	 * 备注
	 */
	@JSONField(name="Remark")
	private String remark;
	
	/**
	 * 申请单信息
	 */
	//private OrderAfterSaleApplyVo orderAfterSaleApplyVo;
	
	/**
	 * 申请单产品明细
	 */
	@JSONField(name="Items")
	private List<OrderAfterSaleApplyItemsVo> items;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getExternalApplyNo() {
		return externalApplyNo;
	}

	public void setExternalApplyNo(String externalApplyNo) {
		this.externalApplyNo = externalApplyNo;
	}

	public int getApplyType() {
		return applyType;
	}

	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}

	public int getReasonType() {
		return reasonType;
	}

	public void setReasonType(int reasonType) {
		this.reasonType = reasonType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<OrderAfterSaleApplyItemsVo> getItems() {
		return items;
	}

	public void setItems(List<OrderAfterSaleApplyItemsVo> items) {
		this.items = items;
	}
}
