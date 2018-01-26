package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import com.ai.slp.user.dao.mapper.bo.UcUserSafariHis;
import com.ai.slp.user.dao.mapper.bo.UcUserSafariHisCriteria;

public interface IUserSafariHisAtomSV {

    int insert(UcUserSafariHis record);

    List<UcUserSafariHis> selectByExample(UcUserSafariHisCriteria example);

    int deleteByExample(UcUserSafariHisCriteria example);

}
