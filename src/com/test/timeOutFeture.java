package com.test;

import org.testng.annotations.Test;

public class timeOutFeture {
	
	@Test(timeOut=2)
	public void timeOut() {
		
	
	int i=1;
	while(i==1) {
		
		System.out.println("Both are equal:"+i);
	}
	
	}
}
