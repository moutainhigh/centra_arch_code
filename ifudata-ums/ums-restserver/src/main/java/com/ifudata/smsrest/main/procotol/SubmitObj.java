package com.ifudata.smsrest.main.procotol;

public class SubmitObj {
	private String cust_code;
	private String sp_code;
	private String msg_id;
	private String mobile;
	private String content;
	private String seq;
	private String sign;
	private String remark;
	
	public String getCust_code() {
		return cust_code;
	}
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}
	public String getSp_code() {
		return sp_code;
	}
	public void setSp_code(String sp_code) {
		this.sp_code = sp_code;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setRemark(String remark) {
		this.remark= remark;
	}
	public String getRemark() {
		return remark;
	}
	@Override
	public String toString() {
		return "SubmitObj [cust_code=" + cust_code + ", sp_code=" + sp_code + ", msg_id=" + msg_id + ", mobile="
				+ mobile + ", content=" + content + ", seq=" + seq + ", sign=" + sign + ", remark=" + remark + "]";
	}
}
