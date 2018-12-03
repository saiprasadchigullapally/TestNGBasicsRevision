package com.datadriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// *[@id='customers']/tbody/tr[2]/td[1]
		// *[@id='customers']/tbody/tr[3]/td[1]
		// *[@id='customers']/tbody/tr[4]/td[1]
		// *[@id='customers']/tbody/tr[7]/td[1]

		// *[@id='customers']/tbody/tr[2]/td[2]
		// *[@id='customers']/tbody/tr[3]/td[2]

		String beforexpath_company = "//*[@id='customers']/tbody/tr[";
		String afterxpath_company = "]/td[1] ";

		String beforexpath_contact = "//*[@id='customers']/tbody/tr[";
		String afterxpath_contact = "]/td[2]";

		// In a table to get total number of columns
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("total number of row is:" + (row.size() - 1));
		int rowcount = row.size();

		// To read a data from Webpage into excel we use excel
		Xls_Reader reader = new Xls_Reader(
				"E:\\myselenium\\TestNGBasicsRevision\\src\\com\\testdata\\halfebaytestdata.xlsx");

		if (!reader.isSheetExist("TableData1")) { // check the workbook if sheet and columns exist don't enter else enter
													// and create sheet and columns
			reader.addSheet("TableData");
			reader.addColumn("TableData", "companyname");
			reader.addColumn("TableData", "contactname");

		}

		for (int i = 2; i <= rowcount; i++) {

			String actualxpath_company = beforexpath_company + i + afterxpath_company;
			String companyname = driver.findElement(By.xpath(actualxpath_company)).getText();
			System.out.println(companyname);
			reader.setCellData("TableData", "companyname", i, companyname); // excel code to add data

			String actualxpath_contact = beforexpath_contact + i + afterxpath_contact;
			String contactname = driver.findElement(By.xpath(actualxpath_contact)).getText();
			System.out.println(contactname);
			reader.setCellData("TableData", "contactname", i, contactname);// excel code to add data
		}

	}

}
