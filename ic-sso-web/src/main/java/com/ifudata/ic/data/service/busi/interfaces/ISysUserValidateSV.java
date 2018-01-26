package com.ifudata.ic.data.service.busi.interfaces;


import com.ifudata.centra.base.exception.BusinessException;

public interface ISysUserValidateSV {

	void checkUserId(String accountId) throws BusinessException;

	void checkUserName(String userName) throws BusinessException;

}
