package com.ifudata.dvp.pay.api.tradequery.param;

import com.ifudata.dvp.base.vo.BaseInfo;

/**
 * 批次号
 *
 * Date: 2015年11月9日 <br>
 */
public class BatchNoParam extends BaseInfo {

    private static final long serialVersionUID = 1590969004232850594L;
    
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 第三方支付平台交易流水号
     */
    private String payOrgSerial;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getPayOrgSerial() {
        return payOrgSerial;
    }

    public void setPayOrgSerial(String payOrgSerial) {
        this.payOrgSerial = payOrgSerial;
    }
    
}
