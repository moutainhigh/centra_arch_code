package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcStateChgCriteria;

public interface IUcStateChgAtomSV {

    public int insertUcStateChgBusiInfo(UcStateChg ucStateChgParam);

    public int updateUcStateChgBusiInfo(@Param("record") UcStateChg record,
            @Param("example") UcStateChgCriteria example);

    List<UcStateChg> selectByExample(UcStateChgCriteria example);

}
