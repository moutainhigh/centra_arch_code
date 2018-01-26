package com.ifudata.smsrest.manager.impl;

import com.ifudata.smsrest.db.mapper.bo.SgipTemplate;
import com.ifudata.smsrest.db.mapper.bo.SgipTemplateCriteria;
import com.ifudata.smsrest.manager.ISgipTemplate;
import com.ifudata.smsrest.db.interfaces.SgipTemplateMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lvsj on 2015/9/27.
 */
public class SgipTemplateService implements ISgipTemplate {
	private static Log log = LogFactory.getLog(SgipTemplateService.class);
	@Autowired
	private SgipTemplateMapper sgipTemplateMapper;
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, timeout = 20)
	public SgipTemplate getSgipTemplate(long id) {
		// List<SgipTemplate> records = new ArrayList<>();
		SgipTemplateCriteria example = new SgipTemplateCriteria();
		example.clear();
		example.createCriteria().andTemplateIdEqualTo(id);
		List<SgipTemplate> records = sgipTemplateMapper.selectByExample(example);
		if ((records == null) || (records.isEmpty())) {
			log.debug("SgipTemplate records.isEmpty");
			return null;
		}
		return records.get(0);
	}

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.sqlSessionTemplate = session;
	}
}
