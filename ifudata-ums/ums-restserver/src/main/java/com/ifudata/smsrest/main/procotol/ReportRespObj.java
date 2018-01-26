package com.ifudata.smsrest.main.procotol;

public class ReportRespObj {
	private String msg_id;
	private String Seq;
	private String err;
	private String fail_desc;
	private String report_time;
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getSeq() {
		return Seq;
	}
	public void setSeq(String seq) {
		Seq = seq;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public String getFail_desc() {
		return fail_desc;
	}
	public void setFail_desc(String fail_desc) {
		this.fail_desc = fail_desc;
	}
	public String getReport_time() {
		return report_time;
	}
	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}
	@Override
	public String toString() {
		return "ReportRespObj [msg_id=" + msg_id + ", Seq=" + Seq + ", err=" + err + ", fail_desc=" + fail_desc
				+ ", report_time=" + report_time + "]";
	}
}
