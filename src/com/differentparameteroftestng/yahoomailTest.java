package com.differentparameteroftestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class yahoomailTest {
	
	
	@BeforeClass
	public void launchBrowser() {
		
		System.out.println("Lanuch FireFoxBrowser");
	}

	
	@BeforeMethod
	public void login() {
		
		System.out.println("login to app");
	}
	
	
	
	@Test(priority=1,groups="email")
	public void composemailTest() {
		
		System.out.println("composemailtest");
		//int i=9/0;
	}
	
	@Test(priority=3,groups="email")
	public void deleteMailTest() {
		
		System.out.println("Deletemailtest");
	}
	
	@Test(priority=2,enabled=false,groups="enabled")
	public void searchmailTest() {
		System.out.println("searchmailtest");
	}
	
	@Test(priority=4,dependsOnMethods="composemailTest",groups="enabled")
	public void sentItemmailTest() {
		
		System.out.println("sentItemmailTest");
	}
	
	
	@AfterMethod
	public void logout() {
		
		System.out.println("logout from application");
	}
	
	
	
	@AfterClass
	public void quitBrowser() {
		
		System.out.println("Quit Browser");
	}
}
