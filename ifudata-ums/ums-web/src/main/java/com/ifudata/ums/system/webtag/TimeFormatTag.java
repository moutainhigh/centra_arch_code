package com.ifudata.ums.system.webtag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TimeFormatTag extends BodyTagSupport {
	/**
	 * @author yangzh
	 * 对jsp中long类型的时间进行格式化，输出结果为*时*分*秒
	 */
	private static final long serialVersionUID = 8533694302558799757L;

	private Long value;

	public TimeFormatTag() {

	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		StringBuffer displayText = new StringBuffer();
		try {
			if (value != null) {
				long time = value;
				String timeStr = null;
				long hour = 0;
				long minute = 0;
				long second = 0;
				if (time <= 60) {
					displayText.append(time + "秒");
				} else {
					minute = time / 60;
					if (minute < 60) {
						second = time % 60;
						timeStr = Long.toString(minute) + "分"
								+ Long.toString(second) + "秒";
					} else {
						hour = minute / 60;
						minute = minute % 60;
						second = time - hour * 3600 - minute * 60;
						timeStr = Long.toString(hour) + "时"
								+ Long.toString(minute) + "分"
								+ Long.toString(second) + "秒";
					}
					displayText.append(timeStr);
				}
				out.print(displayText);

			} else {
				displayText.append(value);
				out.print(displayText);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
}
