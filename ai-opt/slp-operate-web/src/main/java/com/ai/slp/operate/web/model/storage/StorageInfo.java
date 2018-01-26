package com.ai.slp.operate.web.model.storage;

import com.ai.opt.base.vo.BaseResponse;

import java.sql.Timestamp;

/**
 * 虚拟库存信息扩展<br>
 *
 */
public class StorageInfo extends BaseResponse {
    private static final long serialVersionUID = 1L;
    /**
     * 确定ID用数字
     */
    private int number;
	/**
     * 库存标识
     */
    private String storageId;
    /**
     * 商品标识
     */
    private String prodId;
    /**
     * 库存组id
     */
    private String storageGroupId;
    /**
     * 库存名称
     */
    private String storageName;
    /**
     * 库存量
     */
    private Long totalNum;
    /**
     * 预警库存量
     */
    private Long warnNum;
    /**
     * 优先级
     */
    private Short priorityNumber;
    /**
     * 销售价
     */
    private Long salePrice;
    /**
     * 库存状态
     */
    private String state;
    /**
     * 状态名称
     */
    private String stateName;
    /**
     * 生效时间
     */
    private Timestamp activeTime;
    /**
     * 失效时间
     */
    private Timestamp inactiveTime;

    /**
     * 操作人ID
     */
    private Long operId;
    /**
     * 操作时间
     */
    private Timestamp operTime;

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getStorageGroupId() {
        return storageGroupId;
    }

    public void setStorageGroupId(String storageGroupId) {
        this.storageGroupId = storageGroupId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Long getWarnNum() {
        return warnNum;
    }

    public void setWarnNum(Long warnNum) {
        this.warnNum = warnNum;
    }

    public Short getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(Short priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    public Timestamp getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public Timestamp getOperTime() {
        return operTime;
    }

    public void setOperTime(Timestamp operTime) {
        this.operTime = operTime;
    }

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
