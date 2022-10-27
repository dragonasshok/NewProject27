package org.pomtask;

import java.io.IOException;

import org.login.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPage extends BaseClass {
	
	public BookingConfirmPage() {
		
		PageFactory.initElements(driver, this);
	}
    @FindBy(id="order_no")
    private WebElement orderNumber;
    
    @FindBy(xpath="//a[contains(text(),'Booked Itinerary')]")
	private WebElement clickBooked;
    
    

	public WebElement getClickBooked() {
		return clickBooked;
	} 
	public WebElement getOrderNumber() {
		return orderNumber;
	}
	public void confirmBooking() throws IOException {
		
		String attribute = getAttribute(orderNumber);
        System.out.println(attribute);
        writedata("as", 7, 0, attribute);
        clickButton(getClickBooked());
	
	}

}
