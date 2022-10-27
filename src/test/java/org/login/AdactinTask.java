package org.login;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebElement;

public class AdactinTask {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	

	BaseClass baseClass=new BaseClass();
	
	baseClass.getDriver("chrome"); 
	
	baseClass.loadUrl("https://adactinhotelapp.com/");
	//baseClass.implicityWaits(Duration.ofSeconds(20)); 
	
	baseClass.maximizeWindow();
	
	WebElement txtname = baseClass.locatorId("username");
	String data = baseClass.getData("as", 1, 0);
	baseClass.type(txtname, data);
	
	WebElement txtpass = baseClass.locatorId("password");
	String data2 = baseClass.getData("as", 1, 1);
	baseClass.type(txtpass, data2);
	
	WebElement log = baseClass.locatorId("login");
	baseClass.clickButton(log);
	
	WebElement location = baseClass.locatorId("location");
	String data3 = baseClass.getData("as", 1, 2);
	baseClass.type(location, data3);
	
	WebElement selhotel = baseClass.locatorId("hotels");
	String data4 = baseClass.getData("as", 1, 3);
	baseClass.type(selhotel, data4);
	
	WebElement hoteltype = baseClass.locatorId("room_type");
	String data5 = baseClass.getData("as", 1, 4);
	baseClass.type(hoteltype, data5);
	
	WebElement roomnos = baseClass.locatorId("room_nos"); 
	String data6 = baseClass.getData("as", 1, 5);
	baseClass.type(roomnos, data6);
	
	WebElement adultroom = baseClass.locatorId("adult_room");
	String data7 = baseClass.getData("as", 1, 6);
	baseClass.type(adultroom, data7);
	
	WebElement childroom = baseClass.locatorId("child_room");
	String data8 = baseClass.getData("as", 1, 7);
	baseClass.type(childroom, data8);
	
	WebElement searchbtn = baseClass.locatorId("Submit");
	baseClass.clickButton(searchbtn);
	
	WebElement sel = baseClass.locatorId("radiobutton_0");
	baseClass.clickButton(sel);
	
	WebElement selcon = baseClass.locatorId("continue");
	baseClass.clickButton(selcon);
	
	WebElement firstname = baseClass.locatorId("first_name");
	String data9 = baseClass.getData("as", 1, 8);
	baseClass.type(firstname, data9);
	
	WebElement lastname = baseClass.locatorId("last_name");
	String data10 = baseClass.getData("as", 1, 9);
	baseClass.type(lastname, data10);
	
	WebElement add = baseClass.locatorId("address");
	String data11 = baseClass.getData("as", 1, 10);
	baseClass.type(add, data11);
	
	WebElement value = baseClass.locatorId("cc_num");
	String data12 = baseClass.getData("as", 1, 11);
	baseClass.type(value, data12);
	
	WebElement cardtype = baseClass.locatorId("cc_type");
	String data13 = baseClass.getData("as", 1, 12);
	baseClass.type(cardtype, data13);
	
	WebElement selmonth = baseClass.locatorId("cc_exp_month");
	String data14 = baseClass.getData("as", 1, 13);
	baseClass.type(selmonth, data14);
	
	WebElement selyear = baseClass.locatorId("cc_exp_year");
	String data15 = baseClass.getData("as", 1, 14);
	baseClass.type(selyear, data15);
	
	WebElement selnum = baseClass.locatorId("cc_cvv");
	String data16 = baseClass.getData("as", 1, 15);
	baseClass.type(selnum, data16);
	
	WebElement clickk = baseClass.locatorId("book_now");
	baseClass.clickButton(clickk);
	baseClass.thread(4000);
	
	WebElement orderid = baseClass.locatorId("order_no");
	baseClass.getAttribute(orderid);
	
	
	
    
	
	
	
	
	
	
	
	
	
	
}
}