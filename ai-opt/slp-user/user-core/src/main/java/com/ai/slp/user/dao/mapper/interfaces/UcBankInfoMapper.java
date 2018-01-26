package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcBankInfo;
import com.ai.slp.user.dao.mapper.bo.UcBankInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcBankInfoMapper {
    int countByExample(UcBankInfoCriteria example);

    int deleteByExample(UcBankInfoCriteria example);

    int deleteByPrimaryKey(String bankSeqId);

    int insert(UcBankInfo record);

    int insertSelective(UcBankInfo record);

    List<UcBankInfo> selectByExample(UcBankInfoCriteria example);

    UcBankInfo selectByPrimaryKey(String bankSeqId);

    int updateByExampleSelective(@Param("record") UcBankInfo record, @Param("example") UcBankInfoCriteria example);

    int updateByExample(@Param("record") UcBankInfo record, @Param("example") UcBankInfoCriteria example);

    int updateByPrimaryKeySelective(UcBankInfo record);

    int updateByPrimaryKey(UcBankInfo record);
}