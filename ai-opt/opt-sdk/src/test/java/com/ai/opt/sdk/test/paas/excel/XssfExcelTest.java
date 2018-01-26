package com.ai.opt.sdk.test.paas.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ai.opt.sdk.components.excel.client.AbstractExcelHelper;
import com.ai.opt.sdk.components.excel.client.impl.JxlExcelHelper;
import com.ai.opt.sdk.components.excel.factory.ExcelFactory;

/**
 * Excel工具抽象类
 * 
 * @author gucl
 * @param <T> 操作数据类型
 */
public abstract class XssfExcelTest {
	

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1000, "Jones", 40, "Manager", 2975));
		employees.add(new Employee(1001, "Blake", 40, "Manager", 2850));
		employees.add(new Employee(1002, "Clark", 40, "Manager", 2450));
		employees.add(new Employee(1003, "Scott", 30, "Analyst", 3000));
		employees.add(new Employee(1004, "King", 50, "President", 5000));
		String[] titles = new String[]{"工号", "姓名", "年龄", "职称", "薪资（美元）", "入职时间","出生时间"};
		String[] fieldNames = new String[]{"id", "name", "age", "job",
				"salery", "addtime","birthtime"};
		try {
			
			AbstractExcelHelper eh1 = ExcelFactory.getXssfExcelHelper();
//			File file1 = new File("E:\\JXL2003.xls");
//			eh1.writeExcel(file1,Employee.class, employees);
//			eh1.writeExcel(file1,Employee.class, employees, fieldNames, titles);
//			List<Employee> list1 = eh1.readExcel(file1,Employee.class, fieldNames,
//					true);
			String file1path="E:\\POI2007-test222.xlsx";
			//eh1.writeExcel(file1path,Employee.class, employees);
			eh1.writeExcel(file1path,"员工通讯录"+new Date().getTime(),Employee.class, employees, fieldNames, titles);
			List<Employee> list1 = eh1.readExcel(file1path,Employee.class, fieldNames,
					true);
			System.out.println("-----------------POI2007-test.xlsx-----------------");
			for (Employee user : list1) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
