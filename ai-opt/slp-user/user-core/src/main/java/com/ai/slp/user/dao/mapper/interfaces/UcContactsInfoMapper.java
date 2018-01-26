package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcContactsInfo;
import com.ai.slp.user.dao.mapper.bo.UcContactsInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcContactsInfoMapper {
    int countByExample(UcContactsInfoCriteria example);

    int deleteByExample(UcContactsInfoCriteria example);

    int insert(UcContactsInfo record);

    int insertSelective(UcContactsInfo record);

    List<UcContactsInfo> selectByExample(UcContactsInfoCriteria example);

    int updateByExampleSelective(@Param("record") UcContactsInfo record, @Param("example") UcContactsInfoCriteria example);

    int updateByExample(@Param("record") UcContactsInfo record, @Param("example") UcContactsInfoCriteria example);
}