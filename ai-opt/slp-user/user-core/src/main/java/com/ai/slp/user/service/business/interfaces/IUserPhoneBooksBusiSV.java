package com.ai.slp.user.service.business.interfaces;

import java.util.List;
import java.util.Map;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroup;
import com.ai.slp.user.api.ucuserphonebooks.param.UcTelGroupMantainReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksBatchData;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksModifyReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UcUserPhonebooksQueryReq;
import com.ai.slp.user.api.ucuserphonebooks.param.UserPhonebook;

public interface IUserPhoneBooksBusiSV {

	void addUcTelGroup(UcTelGroupMantainReq req);

	void modifyUcTelGroup(UcTelGroupMantainReq req);

	void deleteUcTelGroup(UcTelGroupMantainReq req);

	List<UcTelGroup> getUcTelGroups(String userId);

	void batchDeleteUserPhonebooks(List<String> recordIds);

	List<String> batchAddUserPhonebooks(Map<String, UcUserPhonebooksBatchData> dataMap);

	void modifyUserPhonebook(UcUserPhonebooksModifyReq req);

	PageInfo<UserPhonebook> queryUserPhonebooks(UcUserPhonebooksQueryReq req);
	
	Integer queryGroupPhonebooksCount(String telGroupId);

}
