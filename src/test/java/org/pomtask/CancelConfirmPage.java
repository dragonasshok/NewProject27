package org.pomtask;

import org.login.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelConfirmPage extends BaseClass {

	public CancelConfirmPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_id_text")
	private WebElement getCancelId;

	@FindBy(id = "search_hotel_id")
	private WebElement searchGo;
	
	@FindBy(id="check_all")
	private WebElement allChecking;
	
	@FindBy(name="cancelall")
	private WebElement allCancel;
	
	public WebElement getAllChecking() {
		return allChecking;
	}

	public WebElement getAllCancel() {
		return allCancel;
	}

	public WebElement getGetCancelId() {
		return getCancelId;
	}

	public WebElement getSearchGo() {
		return searchGo;
	}

	public void cancel(String CancelId) {
		type(getGetCancelId(), CancelId);
		clickButton(getSearchGo());
		clickButton(getAllChecking());
		clickButton(getAllCancel());
		okAlerts();
		
		
		
		
	}

}
