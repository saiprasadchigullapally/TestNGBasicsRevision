package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//@Before Suite:Setup System property for ChromeBrowser
//@BeforeTest:Launch ChromeBrowser
//@BeforeClass:login to website/application
//@BeforeMethod:Enter URL
//@Test:Google title test
//@AfterMethod:logout from website/application
//@AfterTest:Delete all cookies
//PASSED: googleTitleTest


/*
 * @BeforeMethod
 * @Test1
 * @AfterMethod
 * 
 * @BeforeMethod
 * @Test2
 * @AfterMethod
 * 
 * 
 * 
 * 
 * 
 */







public class TestNgBasics {
	
	// pre conditions annotations ---- starts with @Before
	@BeforeSuite // 1
	public void setUP() {
		
		System.out.println("@Before Suite:Setup System property for ChromeBrowser");
	}
	
	@BeforeTest // 2
	public void launchBrowser() {
		
		System.out.println("@BeforeTest:Launch ChromeBrowser");
	}
	@BeforeClass // 3
	public void login() {
	
		System.out.println("@BeforeClass:login to website/application");
	
	}
	
	
	@BeforeMethod // 4
	public void enterURL() {
		System.out.println("@BeforeMethod:Enter URL");
	}
	
	
	
	// Test Case ---- Starting with @Test
	
	

	@Test   // 5
	public void googleTitleTest() {
	 
		System.out.println("@Test:Google title test");
	}
	
	
	@Test
	public void searchTest() {
		System.out.println("@Test:SearchTest");
	}
	
	
	
	
	
	// post condition --- starting with @After
	
	
	
	@AfterMethod  // 6
	public void logout() {
		System.out.println("@AfterMethod:logout from website/application");
	}
	
	
	@AfterClass // 7
	public void closeBrowser() {
		
		System.out.println("@AfterClass:Close Browser");
	}
	
	@AfterTest //8
	public void delateAllCokies() {
		System.out.println("@AfterTest:Delete all cookies");
	
	
	}
}
