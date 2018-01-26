package com.ifudata.ums.dao.interfaces;

import com.ifudata.ums.dao.mapper.bo.OrdApplyBatch;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdApplyBatchMapper {
    int countByExample(OrdApplyBatchCriteria example);

    int deleteByExample(OrdApplyBatchCriteria example);

    int deleteByPrimaryKey(Long batchId);

    int insert(OrdApplyBatch record);

    int insertSelective(OrdApplyBatch record);

    List<OrdApplyBatch> selectByExample(OrdApplyBatchCriteria example);

    OrdApplyBatch selectByPrimaryKey(Long batchId);

    int updateByExampleSelective(@Param("record") OrdApplyBatch record, @Param("example") OrdApplyBatchCriteria example);

    int updateByExample(@Param("record") OrdApplyBatch record, @Param("example") OrdApplyBatchCriteria example);

    int updateByPrimaryKeySelective(OrdApplyBatch record);

    int updateByPrimaryKey(OrdApplyBatch record);
}