package com.ifudata.smsrest.manager;

import com.ifudata.smsrest.db.mapper.bo.SgipTemplate;
import org.mybatis.spring.SqlSessionTemplate;

public interface ISgipTemplate {
    /**
     * 得到短信模板列表
     * @return
     */
    SgipTemplate getSgipTemplate(long id);

    SqlSessionTemplate getSqlSessionTemplate();
    void setSqlSessionTemplate(SqlSessionTemplate session);
}
