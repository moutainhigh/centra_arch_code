package com.ai.slp.user.api.ucuserphonebooks.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class UcUserPhonebooksBatchAddResp extends BaseResponse {

	private static final long serialVersionUID = 1L;

	/**
	 * 结果汇总
	 */
	private String result;
	
	/**
	 * 总条数
	 */
	private Integer totalCount;
	
	/**
	 * 成功条数
	 */
	private Integer successCount;

	/**
	 * 失败条数
	 */
	private Integer failCount;
	
	/**
	 * 异常明细
	 */
	private List<String> errors;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

}
