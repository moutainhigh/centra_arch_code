package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcCustKeyInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcCustKeyInfoMapper {
    int countByExample(UcCustKeyInfoCriteria example);

    int deleteByExample(UcCustKeyInfoCriteria example);

    int insert(UcCustKeyInfo record);

    int insertSelective(UcCustKeyInfo record);

    List<UcCustKeyInfo> selectByExample(UcCustKeyInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcCustKeyInfo record, @Param("example") UcCustKeyInfoCriteria example);

    int updateByExample(@Param("record") UcCustKeyInfo record, @Param("example") UcCustKeyInfoCriteria example);
}