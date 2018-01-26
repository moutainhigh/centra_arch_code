package com.ai.opt.data.api.user.param;

import com.ai.opt.base.vo.BaseResponse;

public class ContinueLoginLogResponse extends BaseResponse{

	private static final long serialVersionUID = -4599442881830181172L;

	private String id;

    private Integer uid;

    private Integer continueDays;

    private Integer lastDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getContinueDays() {
		return continueDays;
	}

	public void setContinueDays(Integer continueDays) {
		this.continueDays = continueDays;
	}

	public Integer getLastDate() {
		return lastDate;
	}

	public void setLastDate(Integer lastDate) {
		this.lastDate = lastDate;
	}
    
}
