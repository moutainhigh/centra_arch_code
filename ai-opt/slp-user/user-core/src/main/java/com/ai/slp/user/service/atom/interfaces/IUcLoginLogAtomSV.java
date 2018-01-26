package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import com.ai.slp.user.dao.mapper.bo.UcLoginLog;
import com.ai.slp.user.dao.mapper.bo.UcLoginLogCriteria;

public interface IUcLoginLogAtomSV {
    public void insertUcLoginLogInfo(UcLoginLog ucLoginLog);
    public List<UcLoginLog> selectUcTelGroupInfo(UcLoginLogCriteria example);
    public int countUcTelGroupInfo(UcLoginLogCriteria example);
}
