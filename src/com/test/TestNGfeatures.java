package com.test;

import org.testng.annotations.Test;

public class TestNGfeatures {

	@Test
	public void loginTest() {
		System.out.println("login test");
		int i=9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePageTest() {
		
		System.out.println("Homepage test");
	}
	
	
	
	
}
