package org.login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pomtask.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitTask {

	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();

	}
	@AfterClass
	public static void afterClass() {
		driver.quit();

	}


	
	@Test
	public void browserLaunch(String string,String intcell,String i) {
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
