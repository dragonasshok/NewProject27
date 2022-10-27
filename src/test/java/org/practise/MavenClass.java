package org.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenClass {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("welcome speech");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='btnK'])[1]")).click();
		
		WebElement findElement = driver.findElement(By.xpath("//img[@alt='Google']"));
		String attribute = findElement.getAttribute("alt");
		System.out.println(attribute);
		
	}

}
