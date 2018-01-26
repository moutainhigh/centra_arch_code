package com.ai.slp.user.api.ucLoginLog.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class UcLoginLogQueryResponse extends BaseResponse{

        private static final long serialVersionUID = 1L;

        PageInfo<UcLoginLogResponse> pageInfo;

        public PageInfo<UcLoginLogResponse> getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfo<UcLoginLogResponse> pageInfo) {
            this.pageInfo = pageInfo;
        }

}
