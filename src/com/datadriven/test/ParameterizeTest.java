package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {
	
	
	// reader.getCellData(),getRowCount(),setCellData(),reader.addsheet(),getRowCount(),getcellRowNum()....

	public static void main(String args[]) throws InterruptedException {

		// get test data from excel : Data Driven approach (parameterization) --- used to create data driven framework : driving the test data from excel file

		Xls_Reader reader = new Xls_Reader(
				"E:\\myselenium\\TestNGBasicsRevision\\src\\com\\testdata\\halfebaytestdata.xlsx");
		int rowcount = reader.getRowCount("RegTestData");
		
		reader.addColumn("RegTestData", "status"); // To add column into the excel sheet

		// WebDriver code:
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Parameterization:
		for (int rownum = 2; rownum <= rowcount; rownum++) {

			System.out.println("_______________");

			String firstname = reader.getCellData("RegTestData", "firstname", rownum);
			System.out.println(firstname);

			String lastname = reader.getCellData("RegTestData", "lastname", rownum);
			System.out.println(lastname);

			String address1 = reader.getCellData("RegTestData", "address1", rownum);
			System.out.println(address1);

			String address2 = reader.getCellData("RegTestData", "address2", rownum);
			System.out.println(address2);

			String city = reader.getCellData("RegTestData", "city", rownum);
			System.out.println(city);

			String state = reader.getCellData("RegTestData", "state", rownum);
			System.out.println(state);

			String zipcode = reader.getCellData("RegTestData", "zipcode", rownum);
			System.out.println(zipcode);

			String emailaddress = reader.getCellData("RegTestData", "emailaddress", rownum);
			System.out.println(emailaddress);
			
			String password=reader.getCellData("RegTestData", "password", rownum);
			System.out.println(password);

			// enter data from excel to webpage:

			driver.manage().deleteAllCookies();
			Dimension d = new Dimension(1500, 1200);
			driver.manage().window().setSize(d);
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

			driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstname);

			driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastname);
			
			Thread.sleep(6000);

//			driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
//
//			driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
//
//			driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
//
//			Select s = new Select(driver.findElement(By.xpath("//*[@id='state']")));
//
//			s.selectByVisibleText(state);
//
//			driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);

//			driver.findElement(By.xpath("//*[@id='email_r']")).sendKeys(emailaddress);
//			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys(password);
			
			reader.setCellData("RegTestData", "status", rownum, "pass"); // write the data into a cell

		}

	}

}
