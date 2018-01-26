package com.ai.slp.user.api.message.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 获取消息列表出参 Date: 2016年4月27日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangqiang7
 */
public class QueryMessageResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回信息
     */
    PageInfo<UserMessageParams> pageInfo;

    public PageInfo<UserMessageParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UserMessageParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
