package com.ai.slp.user.api.contactsinfo.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 获取用户联系人出参 Date: 2016年4月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class QueryContactsInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    PageInfo<UcContactsInfoParams> pageInfo;

    public PageInfo<UcContactsInfoParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UcContactsInfoParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
