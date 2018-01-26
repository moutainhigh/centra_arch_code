package com.ai.slp.user.api.seq.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.user.api.seq.param.PhoneMsgSeqResponse;

@Path("/createSeqservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ICreateSeqSV {
	/**
	 * 获取短信信息seq
	 * @return PhoneMsgSeqResponse
	 * @author zhangyuehong
     * @ApiDocMethod
     * @ApiCode UAC_0011
     * @RestRelativeURL createSeqservice/createPhoneMsgSeq
	 */
    @POST
    @Path("/createPhoneMsgSeq")
	PhoneMsgSeqResponse createPhoneMsgSeq() throws BusinessException,SystemException;
}
