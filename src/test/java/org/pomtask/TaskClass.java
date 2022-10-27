package org.pomtask;

import java.io.IOException;
import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.login.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskClass extends BaseClass {

	

	
	@BeforeClass
	public static void beforeClass() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
       
	}
	@AfterClass
	public static void afterClass() {
		driver.quit();

	}
	
	

	@Test
	public void launching() throws IOException {
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.login(getData("as", 1, 0), getData("as", 1, 1));
	
		SearchHotelPage hotelPage=new SearchHotelPage();
		
		hotelPage.searchHotel
		        (getData("as", 1, 2), 
				getData("as", 1, 3),
				getData("as", 1, 4), 
				getData("as", 1, 5),
				getData("as", 1, 16), 
				getData("as", 1, 17),
				getData("as", 1, 6),
				getData("as", 1, 7));
		
		SelectHotelPage hotelPage2=new SelectHotelPage();
				
		hotelPage2.selectHotel();
				
		BookHotelPage bookHotelPage=new BookHotelPage();
		
		bookHotelPage.bookingHotel
		       (getData("as", 1, 8),
				getData("as", 1, 9),
				getData("as", 1, 10),
				getData("as", 1, 11),
				getData("as", 1, 12),
				getData("as", 1, 13),
				getData("as", 1, 14),
				getData("as", 1, 15));
				
				
				
		BookingConfirmPage confirmPage=new BookingConfirmPage();
		
		confirmPage.confirmBooking();
		
		CancelConfirmPage cancelConfirmPage = new CancelConfirmPage();
		cancelConfirmPage.cancel(getData("as", 7, 0));
		
				
				
				
				
				
				
				
				
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
