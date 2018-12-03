package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class GoogleTest {

	WebDriver driver; // initializing the Webdriver object

	@BeforeMethod
	public void setUP() {

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium softwares\\chromedriver.exe");
		driver = new ChromeDriver();// launch chromebrowser

		Dimension dimension = new Dimension(800, 800); // Dimension class in selenium is used to set the size of browser
		driver.manage().window().setSize(dimension);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");

	}

	
	
	
	
	@Test(priority = 1, groups = "Title") // Test case:1
	public void googleTitleTest() {

		String title = driver.getTitle();
		System.out.println("title of the google page is:" + title);
		Assert.assertEquals(title, "Google1","title is not matched");
		
		
		
	}

	@Test(priority = 2, groups = "Logo") // Test case:2
	public void googleLogoTest() {

		boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println("googleLogoTest is:" + b);
		Assert.assertTrue(b);
		Assert.assertEquals(b, true);
		
	}

	@Test(priority = 3, groups = "Link Test") // Test case:3
	public void gmailLinkTest() {

		boolean c = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println("GmailLinkTest is:" + c);
		Assert.assertTrue(c);
		
	}

	@Test(priority = 4, groups = "Test")
	public void test1() {
		System.out.println("test1");
	}

	@Test(priority = 5, groups = "Test")
	public void test2() {
		System.out.println("test1");
	}

	@Test(priority = 6, groups = "Test")
	public void test3() {
		System.out.println("test1");
	}
	
	
	
	
	
	
	

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
