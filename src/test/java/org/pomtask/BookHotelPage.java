package org.pomtask;

import org.login.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
		
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement hotelAddress;
	
	@FindBy(id="cc_num")
	private WebElement cardNumber;
	
	@FindBy(id="cc_type")
	private WebElement cardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement cardExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement cardExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement bookingNum;
	
	@FindBy(id="book_now")
	private WebElement bookingNow;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getHotelAddress() {
		return hotelAddress;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getCardExpMonth() {
		return cardExpMonth;
	}

	public WebElement getCardExpYear() {
		return cardExpYear;
	}

	public WebElement getBookingNum() {
		return bookingNum;
	}

	public WebElement getBookingNow() {
		return bookingNow;
	}
	public void bookingHotel(String firstName,String lastName,String hotelAddress,String cardNum,
			String cardType,String expMonth,String expYear,String bookingNum) {
		
		type(getFirstName(), firstName);
		type(getLastName(), lastName);
		type(getHotelAddress(), hotelAddress);
		type(getCardNumber(), cardNum);
		selectByVisibleText(getCardType(), cardType);
		selectByVisibleText(getCardExpMonth(), expMonth);
		selectByVisibleText(getCardExpYear(), expYear);
		type(getBookingNum(), bookingNum);
		clickButton(getBookingNow());
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
