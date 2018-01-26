package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcUserSafari;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariCriteria;

public interface IUserSafariAtomSV {

    int insert(UcUserSafari record);

    List<UcUserSafari> selectByExample(UcUserSafariCriteria example);

    int deleteByExample(UcUserSafariCriteria example);

    int countByExample(UcUserSafariCriteria example);

    int updateByExampleSelective(@Param("record") UcUserSafari record,
            @Param("example") UcUserSafariCriteria example);
}
