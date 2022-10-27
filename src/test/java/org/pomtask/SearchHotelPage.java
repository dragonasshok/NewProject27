package org.pomtask;

import org.login.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement ddLocation;

	@FindBy(id = "hotels")
	private WebElement ddHotels;

	@FindBy(id = "room_type")
	private WebElement ddRoomType;

	@FindBy(id = "room_nos")
	private WebElement ddNoOfRooms;

	@FindBy(id = "datepick_in")
	private WebElement ddCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement ddCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement ddAdultRoom;

	@FindBy(id = "child_room")
	private WebElement ddChildRoom;

	@FindBy(id = "Submit")
	private WebElement ddSubmit;

	public WebElement getDdLocation() {
		return ddLocation;
	}

	public WebElement getDdHotels() {
		return ddHotels;
	}

	public WebElement getDdRoomType() {
		return ddRoomType;
	}

	public WebElement getDdNoOfRooms() {
		return ddNoOfRooms;
	}

	public WebElement getDdCheckInDate() {
		return ddCheckInDate;
	}

	public WebElement getDdCheckOutDate() {
		return ddCheckOutDate;
	}

	public WebElement getDdAdultRoom() {
		return ddAdultRoom;
	}

	public WebElement getDdChildRoom() {
		return ddChildRoom;
	}

	public WebElement getDdSubmit() {
		return ddSubmit;
	}

	public void searchHotel(String Location, String Hotels, String RoomType, String NoOfRooms,
			String CheckInDate,
			String CheckOutDate,
			String AdultPerRoom, String ChildPerRoom) {

		selectByVisibleText(getDdLocation(), Location);
		selectByVisibleText(getDdHotels(), Hotels);
		selectByVisibleText(getDdRoomType(), RoomType);
		selectByVisibleText(getDdNoOfRooms(), NoOfRooms);
		clear(getDdCheckInDate());
		type(getDdCheckInDate(), CheckInDate);
		clear(getDdCheckOutDate());
		type(getDdCheckOutDate(), CheckOutDate);
		selectByVisibleText(getDdAdultRoom(), AdultPerRoom);
		selectByVisibleText(getDdChildRoom(), ChildPerRoom);
		clickButton(getDdSubmit());

	}

}
