package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestClass {
	
	WebDriver driver;
	
	
	
	
	@Test
	@Parameters({"env","browser","url","emailid"})
	public void yahooLoginTest(String env ,String browser,String url,String emailid) throws InterruptedException {
		
		if(browser.equals("chrome")) {
			
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium softwares\\chromedriver.exe" );
		driver=new ChromeDriver();
		
		}
		else if(browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver","C:\\Users\\SAI\\Desktop\\mindq practice\\webdriverbrowsers\\geckodriver.exe" );
			driver=new FirefoxDriver();

			
		}
		
		Dimension dim=new Dimension(1400, 1200);
		driver.manage().window().setSize(dim);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(url);
	
		driver.findElement(By.xpath("//a[@id='uh-signin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='login-username']")).clear();
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailid,Keys.ENTER); //enter username
		
		driver.quit();
		
	}

}
