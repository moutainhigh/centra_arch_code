package com.ifudata.ums.manager;

import com.ifudata.ums.exception.DeleteException;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.dao.mapper.bo.SgipSrcGsm;
import org.mybatis.spring.SqlSessionTemplate;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lvsj on 2015/9/24.
 */
public interface ISgipSrcGsm {
    /**
     * 按照serviceTypeList返回指定行数的短信接口内容
     * @param serviceTypeList
     * @param nBatch
     * @return
     */
    List<SgipSrcGsm> getSgipSrc(List<String> serviceTypeList, int nBatch);
    SgipSrcGsm getSgipSrc(BigDecimal id);
    Integer updateSgipSrc(SgipSrcGsm rec) throws UpdateException;
    Integer deleteSgipSrc(SgipSrcGsm rec) throws DeleteException;
    Integer moveSgipSrc(List<SgipSrcGsm> recs) throws InsertException,DeleteException;
    Integer moveSgipSrc(SgipSrcGsm recs) throws InsertException,DeleteException;
    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);
}
