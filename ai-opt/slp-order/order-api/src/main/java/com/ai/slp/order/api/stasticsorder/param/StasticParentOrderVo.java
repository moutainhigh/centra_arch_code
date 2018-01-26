package com.ai.slp.order.api.stasticsorder.param;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class StasticParentOrderVo extends BaseInfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 订单来源
	 */
	private String chlId;
	/**
	 * 商户ID
	 */
	private String supplierId;
	/**
	 * 商户名称
	 */
	private String supplierName;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 收货人手机号
	 */
	private String contactTel;
	/**
	 * 是否需要物流
	 */
	private String deliveryFlag;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 绑定手机号
	 */
	private String userTel;
	/**
	 * 页面展示状态
	 */
	private String stateName;
	/**
	 * 总商品数量
	 */
	private int prodTotal;
	/**
	 * 子订单信息
	 */
	private List<StasticOrderVo> childOrderList;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getDeliveryFlag() {
		return deliveryFlag;
	}

	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<StasticOrderVo> getChildOrderList() {
		return childOrderList;
	}

	public void setChildOrderList(List<StasticOrderVo> childOrderList) {
		this.childOrderList = childOrderList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getProdTotal() {
		return prodTotal;
	}

	public void setProdTotal(int prodTotal) {
		this.prodTotal = prodTotal;
	}

}
