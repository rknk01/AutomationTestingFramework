package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class DeliveryAddressPage extends BrowserUtility{

	private static final By COMMENTS=By.xpath("//textarea[@name='message']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON=By.xpath("//button/span[contains(text(),'Proceed to checkout')]");
	public DeliveryAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public DeliveryAddressPage enterComment(String comment) {
		enterText(COMMENTS, comment);
		return new DeliveryAddressPage(getDriver());
		
	}
	
	public ShippingPage proceedToCheckoutDeliveryAddress() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		return new ShippingPage(getDriver());
	}

}
