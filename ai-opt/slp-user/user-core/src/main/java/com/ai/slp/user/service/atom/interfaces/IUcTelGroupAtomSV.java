package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import com.ai.slp.user.dao.mapper.bo.UcTelGroup;
import com.ai.slp.user.dao.mapper.bo.UcTelGroupCriteria;

public interface IUcTelGroupAtomSV {
    
    public void insertUcTelGroupInfo(UcTelGroup contactsGroup);
    
    public List<UcTelGroup> selectUcTelGroupInfo(UcTelGroupCriteria ucTelGroupCriteria);
    
    public void updateUcTelGroupInfo(UcTelGroup contactsGroup,UcTelGroupCriteria example);
    
    public int countUcTelGroupInfo(UcTelGroupCriteria example);
    
    public void deleteUcTelGroupInfo(UcTelGroupCriteria example);
    
}
