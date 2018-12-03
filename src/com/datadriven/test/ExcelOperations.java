package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {
	
	
	// reader.getCellData(),getRowCount(),setCellData(),reader.addsheet(),getRowCount(),getcellRowNum()....,......( method available in Xls_Reader class )

	public static void main(String[] args) {

		// test data from excel sheet

		Xls_Reader reader = new Xls_Reader(
				"E:\\myselenium\\TestNGBasicsRevision\\src\\com\\testdata\\halfebaytestdata.xlsx ");
		
		
		
		if(!reader.isSheetExist("HomePage")) { // check whether sheet exist or not if sheet does not exist add 
			
			reader.addSheet("HomePage");
		}

		int colcount=reader.getRowCount("RegTestData"); // It will give total number of columns available in that sheet
		System.out.println("Total columns available in RegTestData is:"+colcount);
		
		
		int cellrownum=reader.getCellRowNum("RegTestData", "firstname", "chigullapally");
		System.out.println("CellRowNumber is :"+cellrownum);
		
	}

}
