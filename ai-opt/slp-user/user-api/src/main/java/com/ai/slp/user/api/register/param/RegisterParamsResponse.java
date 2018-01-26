package com.ai.slp.user.api.register.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

/**
 * 注册用户信息参数 <br>
 * Date: 2016年4月18日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhaogw
 */
public class RegisterParamsResponse extends BaseResponse {
    
    private static final long serialVersionUID = 1L;
    private PageInfo<UcUserParams> pageInfo ;

    public PageInfo<UcUserParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<UcUserParams> pageInfo) {
        this.pageInfo = pageInfo;
    } 
    

}
