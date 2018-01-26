package com.ai.slp.order.api.warmorder.param;

import java.sql.Timestamp;
import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class OrderWarmVo extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单来源
	 */
	private String chlId;
	/**
	 * 父订单号
	 */
	private Long parentOrderId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 收货人手机
	 */
	private String contactTel;
	/**
	 * 用户手机（长虹提供）
	 */
	private String userTel;

	/**
	 * 是否预警订单
	 */
	private String ifWarning;
	/**
	 * 预警类型
	 */
	private String warningType;
	/**
	 * 是否需要物流
	 */
	private String deliveryFlag;
	/**
	 * 商品信息
	 */
	private List<ProductInfo> prodInfo;
	/**
	 * 订单状态
	 */
	private String state;
	/**
	 * 总优惠金额
	 */
	private Long discountFee;
	/**
	 * 总实收费用
	 */
	private Long paidFee;
	/**
	 * 业务订单ID
	 */
	private Long orderId;

	/**
	 * 下单时间
	 */
	private Timestamp orderTime;
	/**
	 * 收货地址
	 */
	private String address;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * ip信息
	 */
	private String ipAddress;
	/**
	 * 配送方式
	 */
	private String logisticsType;
	/**
	 * 收件人姓名
	 */
	private String contactName;
	/**
	 * 买家留言
	 */
	private String remark;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public Long getParentOrderId() {
		return parentOrderId;
	}

	public void setParentOrderId(Long parentOrderId) {
		this.parentOrderId = parentOrderId;
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

	public String getIfWarning() {
		return ifWarning;
	}

	public void setIfWarning(String ifWarning) {
		this.ifWarning = ifWarning;
	}

	public String getWarningType() {
		return warningType;
	}

	public void setWarningType(String warningType) {
		this.warningType = warningType;
	}

	public String getDeliveryFlag() {
		return deliveryFlag;
	}

	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}

	public List<ProductInfo> getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(List<ProductInfo> prodInfo) {
		this.prodInfo = prodInfo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(Long discountFee) {
		this.discountFee = discountFee;
	}

	public Long getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(Long paidFee) {
		this.paidFee = paidFee;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getLogisticsType() {
		return logisticsType;
	}

	public void setLogisticsType(String logisticsType) {
		this.logisticsType = logisticsType;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
