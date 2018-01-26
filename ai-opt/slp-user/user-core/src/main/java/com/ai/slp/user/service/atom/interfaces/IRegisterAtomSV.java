package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import com.ai.slp.user.dao.mapper.bo.UcStateChg;
import com.ai.slp.user.dao.mapper.bo.UcStateChgCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUser;
import com.ai.slp.user.dao.mapper.bo.UcUserAgree;
import com.ai.slp.user.dao.mapper.bo.UcUserAgreeCriteria;
import com.ai.slp.user.dao.mapper.bo.UcUserCriteria;

public interface IRegisterAtomSV {
    // 用户
    public int insertUserInfo(UcUser user);

    public List<UcUser> getUserInfo(UcUserCriteria criteria);

    int updateUserInfo(@Param("record") UcUser record,
            @Param("example") UcUserCriteria example);

    // 企业认证
    public int insertUcGroupKeyInfo(UcGroupKeyInfo ucGroupKey);

    public List<UcGroupKeyInfo> getUcGroupKeyInfo(UcGroupKeyInfoCriteria criteria);
    
    public List<UcCustKeyInfo> getUcCustKeyInfo(UcCustKeyInfoCriteria  criteria);
    
    public List<UcContactsInfo> getUcContactsInfo(UcContactsInfoCriteria  criteria);
    
    int updateGroupKeyInfo(@Param("record") UcGroupKeyInfo record,
            @Param("example") UcGroupKeyInfoCriteria example);


    // 用户联系人
    public int insertUcContactsInfo(UcContactsInfo ucContactsInfo);

    // 用户协议
    public void InsertUcUserAgreeAtomSv(UcUserAgree record);
    
    int updateUserAgree(@Param("record") UcUserAgree record,
            @Param("example") UcUserAgreeCriteria example);


    // 用户状态轨迹
    public int insertUcStateChgBusiInfo(UcStateChg ucStateChgParam);

    public int updateUcStateChgBusiInfo(@Param("record") UcStateChg record,
            @Param("example") UcStateChgCriteria example);

    // 用户银行信息
    public int insertUcBankInfo(UcBankInfo ucBankInfo);

    // 个人客户关系信息
    public int insertUcCustKeyInfo(UcCustKeyInfo ucContactsInfo);
    
    int updateCustKeyInfo(@Param("record") UcCustKeyInfo record,
            @Param("example") UcCustKeyInfoCriteria example);


}
