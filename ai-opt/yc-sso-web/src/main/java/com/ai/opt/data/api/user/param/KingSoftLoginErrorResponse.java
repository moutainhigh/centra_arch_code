package com.ai.opt.data.api.user.param;

import java.io.Serializable;

public class KingSoftLoginErrorResponse implements Serializable{

	private static final long serialVersionUID = -2355082364266788934L;
	String error_code;
	String error;
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
