package com.ifudata.ums.dao.interfaces;

import com.ifudata.ums.dao.mapper.bo.UmsSendStatus;
import com.ifudata.ums.dao.mapper.bo.UmsSendStatusCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsSendStatusMapper {
    int countByExample(UmsSendStatusCriteria example);

    int deleteByExample(UmsSendStatusCriteria example);

    int deleteByPrimaryKey(Long resSeq);

    int insert(UmsSendStatus record);

    int insertSelective(UmsSendStatus record);

    List<UmsSendStatus> selectByExample(UmsSendStatusCriteria example);

    UmsSendStatus selectByPrimaryKey(Long resSeq);

    int updateByExampleSelective(@Param("record") UmsSendStatus record, @Param("example") UmsSendStatusCriteria example);

    int updateByExample(@Param("record") UmsSendStatus record, @Param("example") UmsSendStatusCriteria example);

    int updateByPrimaryKeySelective(UmsSendStatus record);

    int updateByPrimaryKey(UmsSendStatus record);
}