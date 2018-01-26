package com.ifudata.ic.smc.api.billdetail.param;

import com.ifudata.dvp.base.vo.BaseResponse;
import com.ifudata.dvp.base.vo.HBasePager;

public class CheckResultDiffDetailQueryResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;

    private HBasePager<DiffDetailDataInfo> pager;

    public HBasePager<DiffDetailDataInfo> getPager() {
        return pager;
    }

    public void setPager(HBasePager<DiffDetailDataInfo> pager) {
        this.pager = pager;
    }

}
