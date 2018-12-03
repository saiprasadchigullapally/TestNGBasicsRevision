package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class HalfEbayTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium softwares\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		Dimension d = new Dimension(1500, 1200);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://scgi.half.ebay.com/we/eBayISAPI.dll?RegisterEnterInfo&usage-2943&ru=");

	}

	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		
		
		ArrayList<Object[]> testdata=TestUtil.getDataFromExcel();
		Iterator<Object[]> i=testdata.iterator();
		return i;
		
		
	}
	
	
	
	
	
	@Test(dataProvider="getTestData",priority=1)
	public void halfebayregpage(String firstname, String lastname, String password) {


		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstname);

		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastname);

		
		driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys(password);
		
		
		
		
		
		
		
//		driver.findElement(By.id("img_firstname")).clear();
//		driver.findElement(By.id("img_firstname")).sendKeys(firstname);
//
//		driver.findElement(By.id("lastname")).clear();
//		driver.findElement(By.id("lastname")).sendKeys(lastname);
//
//		driver.findElement(By.id("address1")).clear();
//		driver.findElement(By.id("address1")).sendKeys(address1);
//
//		driver.findElement(By.id("address2")).clear();
//		driver.findElement(By.id("address2")).sendKeys(address2);
//
//		driver.findElement(By.id("city")).clear();
//		driver.findElement(By.id("city")).sendKeys(city);
//
//		Select s = new Select(driver.findElement(By.id(state)));
//		s.selectByVisibleText("");
//
//		driver.findElement(By.xpath("//*[@id='zip']")).clear();
//		driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);
//
//		driver.findElement(By.xpath("//*[@id='email']")).clear();
//		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailaddress);
//
//		driver.findElement(By.xpath("//*[@id='retype_email']")).clear();
//		driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailaddress);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}

































