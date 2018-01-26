package com.ifudata.smsrest.manager;

import com.ifudata.smsrest.db.mapper.bo.SgipSrcGsm;
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
    Integer updateSgipSrc(SgipSrcGsm rec) throws Exception;
    Integer deleteSgipSrc(SgipSrcGsm rec) throws Exception;
    Integer moveSgipSrc(List<SgipSrcGsm> recs) throws Exception;
    Integer moveSgipSrc(SgipSrcGsm recs) throws Exception;
    Integer insertSgipSrc(List<SgipSrcGsm> sctlist) throws Exception;
    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);
}
