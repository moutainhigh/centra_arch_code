package com.ifudata.ums.system.common;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class AllRight {
	private static Set allMenu;
	private static Set allDataRight;

	public static synchronized void init() {
		allMenu = new HashSet();
		allDataRight = new HashSet();
//		loadData();
	}

//	private static void loadData() {
//		CommonDao dao = (CommonDao) BeanFactory.getBean("commonDao");
//		allMenu = dao.getAllMenu();
//		allDataRight = dao.getAllDataRight();
//	}

	public static synchronized void reloadData() {
		allMenu.clear();
		allDataRight.clear();
//		loadData();
	}

	public static boolean isMenuControl(String url) {
		return allMenu.contains(url);
	}

	public static boolean isDataRightControl(String dataCode) {
		return allDataRight.contains(dataCode);
	}

}
