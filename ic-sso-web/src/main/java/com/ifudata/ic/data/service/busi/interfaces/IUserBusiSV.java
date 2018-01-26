package com.ifudata.ic.data.service.busi.interfaces;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ic.data.dao.mapper.bo.SysUser;

public interface IUserBusiSV {
	
	SysUser queryByUserId(String userId) throws SystemException;
	
}
