package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooks;
import com.ai.slp.user.dao.mapper.bo.UcUserPhonebooksCriteria;

public interface IUcUserPhoneBooksAtomSV {

    public void insertUserPhoneBooksInfo(UcUserPhonebooks record);
    
    public void updateUserPhoneBooksInfo(UcUserPhonebooks record,UcUserPhonebooksCriteria example);
    
    public void deleteUserPhoneBooksInfo(UcUserPhonebooksCriteria example);
    
    public List<UcUserPhonebooks> selectUcTelGroupInfo(UcUserPhonebooksCriteria example);
    
    public int countUcTelGroupInfo(UcUserPhonebooksCriteria example);
    
}
