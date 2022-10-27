package org.login;

import java.io.IOException;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class LaunchAdactin extends BaseClass{

	@BeforeClass
	public static void beforeClass() {
		
		
		getDriver("chrome");
	//	implicityWaits(Duration.ofSeconds(20));
		loadUrl("https://adactinhotelapp.com/");
		maximizeWindow();
	
		
	
	}
	@AfterClass
	public static void afterClass() {
		closeWindows();
		

	}
	@Test
	public void bookingHotel() throws IOException, InterruptedException {
		WebElement txtusername = locatorId("username");
		String data = getData("as", 1, 0);
		type(txtusername, data);
		
		WebElement txtpass = locatorId("password");
		String data2 = getData("as", 1, 1);
		type(txtpass, data2);
		
		WebElement btnlogin = locatorId("login");
		btnlogin.click();
		
		WebElement txtname = locatorId("username_show");
		String getname = getAttribute(txtname);
		
		Assert.assertEquals("verify name", "Hello Ashokjjjj!",getname );
		
		
		WebElement txthotel = locatorClassName("login_title");
	    String getsearchhotel  = txthotel.getText();
	    System.out.println(getsearchhotel);
		
		Assert.assertEquals("verify Search Hotel (Fields marked with Red asterix (*) are mandatory)", "Search Hotel (Fields marked with Red asterix (*) are mandatory)", getsearchhotel);
		
		WebElement location = locatorId("location");
		String data3 = getData("as", 1, 2);
		type(location, data3);
		
		WebElement selhotel = locatorId("hotels");
		String data4 =getData("as", 1, 3);
		type(selhotel, data4);
		
		WebElement hoteltype =locatorId("room_type");
		String data5 =getData("as", 1, 4);
		type(hoteltype, data5);
		
		WebElement roomnos =locatorId("room_nos"); 
		String data6 =getData("as", 1, 5);
		type(roomnos, data6);
		
		WebElement adultroom =locatorId("adult_room");
		String data7 =getData("as", 1, 6);
		type(adultroom, data7);
		
		WebElement childroom =locatorId("child_room");
		String data8 =getData("as", 1, 7);
		type(childroom, data8);
		
		WebElement searchbtn =locatorId("Submit");
		clickButton(searchbtn);
		
		WebElement txthotelname = locatorClassName("login_title");
		String text = txthotelname.getText();
		System.out.println(text);
		
		WebElement sel = locatorId("radiobutton_0");
		clickButton(sel);

		WebElement selcon =locatorId("continue");
		clickButton(selcon);
		

		WebElement txtbook = locatorXpath("//td[text()='Book A Hotel ']");
	    String getbook  = txtbook.getText();
	    System.out.println(getbook);
	    
	    Assert.assertEquals("verify select book", "Book A Hotel", getbook);
		
	    WebElement firstname =locatorId("first_name");
		String data9 =getData("as", 1, 8);
		type(firstname, data9);
		
		WebElement lastname =locatorId("last_name");
		String data10 =getData("as", 1, 9);
		type(lastname, data10);
		
		WebElement add =locatorId("address");
		String data11 =getData("as", 1, 10);
		type(add, data11);
		
		WebElement value =locatorId("cc_num");
		String data12 =getData("as", 1, 11);
		type(value, data12);
		
		WebElement cardtype =locatorId("cc_type");
		String data13 =getData("as", 1, 12);
		type(cardtype, data13);
		
		WebElement selmonth =locatorId("cc_exp_month");
		String data14 =getData("as", 1, 13);
		type(selmonth, data14);
		
		WebElement selyear =locatorId("cc_exp_year");
		String data15 = getData("as", 1, 14);
		type(selyear, data15);
		   
		WebElement selnum =locatorId("cc_cvv");
		String data16 = getData("as", 1, 15);
		type(selnum, data16);
		
		WebElement clickk = locatorId("book_now");
		clickButton(clickk);
		
		WebElement orderNum = locatorId("order_no");	
		String orderId = getAttribute(orderNum);
		System.out.println(orderId);
		
		
		writedata("as", 4, 0, orderId);
		
		WebElement txtbooking = locatorXpath("//td[text()='Booking Confirmation ']");
	    String bookingcon=txtbooking.getText();
	    System.out.println(bookingcon);
	    
	    
	    
	    Assert.assertEquals("Confirm details", "Booking Confirmation", bookingcon);
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
}
