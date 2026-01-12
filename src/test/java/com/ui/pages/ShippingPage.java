package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	private static final By PROCEED_TO_CHECKOUT_BUTTON_SHIPPING_LOCATOR=By.xpath("//button[@name='processCarrier']");
	private static final By TERMS_AND_CONDITION_CHECKBOX=By.xpath("//div[@id='uniform-cgv']");
	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PaymentPage proceedToCheckoutShippingPage() {
		clickOn(TERMS_AND_CONDITION_CHECKBOX);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_SHIPPING_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
