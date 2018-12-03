package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=10)
	public void sum() {
		int i=20;
		int j=30;
		int c=i+j;
		System.out.println("sum of the value is:"+c);
	}
	
	
	
	

}
