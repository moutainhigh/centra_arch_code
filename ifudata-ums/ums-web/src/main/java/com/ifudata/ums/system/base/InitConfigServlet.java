package com.ifudata.ums.system.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class InitConfigServlet extends HttpServlet {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(InitConfigServlet.class);

	private static final long serialVersionUID = 1654365L;

	public void init() throws ServletException {
		try {
			// 加载Spring管理的bean
			BeanFactory.loadApplicationContext(this.getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
