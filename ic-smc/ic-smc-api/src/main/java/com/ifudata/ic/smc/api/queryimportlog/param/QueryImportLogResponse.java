package com.ifudata.ic.smc.api.queryimportlog.param;

import com.ifudata.dvp.base.vo.BaseResponse;
import com.ifudata.dvp.base.vo.PageInfo;

public class QueryImportLogResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 数据导入日志表查询
     */
    private PageInfo<ImportLogVo> pageInfo;

    public PageInfo<ImportLogVo> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<ImportLogVo> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
