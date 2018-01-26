package com.ai.slp.user.api.keyinfo.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UpdateCustFileExtRequest implements Serializable{

    private static final long serialVersionUID = 1L;
    List<CmCustFileExtVo> list = new ArrayList<CmCustFileExtVo>();

    public List<CmCustFileExtVo> getList() {
        return list;
    }

    public void setList(List<CmCustFileExtVo> list) {
        this.list = list;
    }

}
