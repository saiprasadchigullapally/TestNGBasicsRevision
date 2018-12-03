package com.test;

import org.testng.annotations.Test;

public class ExpectedException {

	
	@Test(expectedExceptions=NumberFormatException.class)
	public void nuberFormatException() {
		
		String s="Sai14433";
		int x=Integer.parseInt(s);
		
		System.out.println("Number Format Exception"+x);
	}
}
