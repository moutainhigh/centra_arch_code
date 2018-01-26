package com.ifudata.ums.vo;


/**
 * Title: ums-CRM <br>
 * Description: 解析批量参数报文，单个明细信息<br>
 * Date: 2014年5月23日 <br>
 * Copyright (c) 2014 AILK <br>
 * 
 * @author zhaixs
 */
public class ApplyBatchDetailBody {

    /**
     * 用户号码
     */
    private String serviceNum;

    /**
     * 单个交易业务对象
     */
    private AbstractBaseAssembleBusiVo baseBusiVo;

    /**
     * 数据校验信息<br>
     * 因批量特服变更业务校验功能后置，<br>
     * 用户信息等必行校验不通过时不能抛出异常，<br>
     * 故将异常信息存入此字段，<br>
     * 待生成批次详细时判断，<br>
     * 并生成处理失败的批次单，<br>
     * 拱批量业务查询时导出.
     */
    private String validateInfo;

    public String getValidateInfo() {
        return validateInfo;
    }

    public void setValidateInfo(String validateInfo) {
        this.validateInfo = validateInfo;
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }

    public AbstractBaseAssembleBusiVo getBaseBusiVo() {
        return baseBusiVo;
    }

    public void setBaseBusiVo(AbstractBaseAssembleBusiVo baseBusiVo) {
        this.baseBusiVo = baseBusiVo;
    }

}
