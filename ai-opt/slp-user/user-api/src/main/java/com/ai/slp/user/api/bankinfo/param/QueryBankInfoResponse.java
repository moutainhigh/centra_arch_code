package com.ai.slp.user.api.bankinfo.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 查询用户银行信息出参 Date: 2016年4月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class QueryBankInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    private PageInfo<UcBankInfoParams> pageInfo;

    public PageInfo<UcBankInfoParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UcBankInfoParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
