package org.practise;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		List<WebElement> alllinks  = driver.findElements(By.tagName("a"));
		int size = alllinks.size();
		System.out.println("Total no of links in fb " +size);
		
		int count =0;
		
		for (int i = 0; i < alllinks.size(); i++) {
			  WebElement element = alllinks.get(i);
			  String attribute = element.getAttribute("href");
			  
			  //convert string into URL
			  URL url=new URL(attribute);
			  
			  //to open the URL method of open connection
			  URLConnection connection=url.openConnection();
			  
			  //convert the  URLConnection into https for get response code
			  HttpsURLConnection https=(HttpsURLConnection)connection;
			  
			  int responseCode = https.getResponseCode();
			  
			  if (responseCode !=200) {
				  
				  count++;
				  
				  System.out.println("Broken links name "+attribute);
			}
			
		}
		
		
		
		
		
	}

}
