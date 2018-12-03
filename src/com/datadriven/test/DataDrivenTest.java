package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {
	
	// reader.getCellData(),getRowCount(),setCellData(),reader.addsheet(),getRowCount(),getcellRowNum()....

	public static void main(String args[]) {

		// test data from excel sheet

		Xls_Reader reader = new Xls_Reader(
				"E:\\myselenium\\TestNGBasicsRevision\\src\\com\\testdata\\halfebaytestdata.xlsx ");

		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);

		String lastname = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);

		String address1 = reader.getCellData("RegTestData", "address1", 2);
		System.out.println(address1);

		String address2 = reader.getCellData("RegTestData", "address2", 2);
		System.out.println(address2);

		String city = reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);

		String state = reader.getCellData("RegTestData", "state", 2);
		System.out.println(state);

		String zipcode = reader.getCellData("RegTestData", "zipcode", 2);
		System.out.println(zipcode);

		String emailaddress = reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailaddress);

		// WebDriver code

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		Dimension d = new Dimension(1500, 1200);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://scgi.half.ebay.com/we/eBayISAPI.dll?RegisterEnterInfo&usage-2943&ru=");

		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstname);

		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastname);

		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);

		driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);

		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);

		Select s = new Select(driver.findElement(By.xpath("//*[@id='state']")));

		s.selectByVisibleText(state);

		driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);

		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailaddress);

	}

}
