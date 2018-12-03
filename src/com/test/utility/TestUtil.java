package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> mydata = new ArrayList<Object[]>(); // generic type only object type data is available

		try {

			reader = new Xls_Reader("E:\\myselenium\\TestNGBasicsRevision\\src\\com\\testdata\\halfebaytestdata.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rownum = 2; rownum <= reader.getRowCount("RegTestData"); rownum++) {

			String firstname = reader.getCellData("RegTestData", "firstname", rownum);
			String lastname = reader.getCellData("RegTestData", "lastname", rownum);
			//String emailaddress = reader.getCellData("RegTestData", "emailaddress", rownum);
			String password = reader.getCellData("RegTestData", "password", rownum);

			Object obj[] = { firstname, lastname, password };
			mydata.add(obj);

		}

		return mydata;
	}

}
