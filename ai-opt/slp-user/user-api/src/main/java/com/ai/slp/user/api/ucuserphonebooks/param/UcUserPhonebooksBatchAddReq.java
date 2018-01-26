package com.ai.slp.user.api.ucuserphonebooks.param;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class UcUserPhonebooksBatchAddReq extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 要导入或新增的数据
     */
    private List<UcUserPhonebooksBatchData> datas;

    public List<UcUserPhonebooksBatchData> getDatas() {
        return datas;
    }

    public void setDatas(List<UcUserPhonebooksBatchData> datas) {
        this.datas = datas;
    }

}
