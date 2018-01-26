package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfo;
import com.ai.slp.user.dao.mapper.bo.UcGroupKeyInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcGroupKeyInfoMapper {
    int countByExample(UcGroupKeyInfoCriteria example);

    int deleteByExample(UcGroupKeyInfoCriteria example);

    int insert(UcGroupKeyInfo record);

    int insertSelective(UcGroupKeyInfo record);

    List<UcGroupKeyInfo> selectByExample(UcGroupKeyInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcGroupKeyInfo record, @Param("example") UcGroupKeyInfoCriteria example);

    int updateByExample(@Param("record") UcGroupKeyInfo record, @Param("example") UcGroupKeyInfoCriteria example);
}