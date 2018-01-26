package com.ifudata.ums.dao.interfaces;

import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchDetail;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchDetailCriteria;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchDetailWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdApplyBatchDetailMapper {
    int countByExample(OrdApplyBatchDetailCriteria example);

    int deleteByExample(OrdApplyBatchDetailCriteria example);

    int deleteByPrimaryKey(Long detailId);

    int insert(OrdApplyBatchDetailWithBLOBs record);

    int insertSelective(OrdApplyBatchDetailWithBLOBs record);

    List<OrdApplyBatchDetailWithBLOBs> selectByExampleWithBLOBs(OrdApplyBatchDetailCriteria example);

    List<OrdApplyBatchDetail> selectByExample(OrdApplyBatchDetailCriteria example);

    OrdApplyBatchDetailWithBLOBs selectByPrimaryKey(Long detailId);

    int updateByExampleSelective(@Param("record") OrdApplyBatchDetailWithBLOBs record, @Param("example") OrdApplyBatchDetailCriteria example);

    int updateByExampleWithBLOBs(@Param("record") OrdApplyBatchDetailWithBLOBs record, @Param("example") OrdApplyBatchDetailCriteria example);

    int updateByExample(@Param("record") OrdApplyBatchDetail record, @Param("example") OrdApplyBatchDetailCriteria example);

    int updateByPrimaryKeySelective(OrdApplyBatchDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrdApplyBatchDetailWithBLOBs record);

    int updateByPrimaryKey(OrdApplyBatchDetail record);
}