package com.ifudata.ic.data.service.atom.impl;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ic.data.dao.mapper.factory.MapperFactory;
import com.ifudata.ic.data.service.atom.interfaces.ISysUserAtomSV;
import org.springframework.stereotype.Component;

import com.ifudata.ic.data.dao.mapper.bo.SysUser;
import com.ifudata.ic.data.dao.mapper.interfaces.SysUserMapper;

@Component
public class SysUserAtomSVImpl implements ISysUserAtomSV {

	@Override
	public SysUser queryByUserId(String userId) throws SystemException {
		SysUserMapper sysUserMapper = MapperFactory.getSysUserMapper();
		return sysUserMapper.selectByPrimaryKey(userId);
	}

}
