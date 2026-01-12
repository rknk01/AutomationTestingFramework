package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartSummaryPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON_SHOPPING_CART_LOCATOR=By.xpath("//p/a[@title='Proceed to checkout']/span");
	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public DeliveryAddressPage proceedToCheckoutShoppingCart() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_SHOPPING_CART_LOCATOR);
		DeliveryAddressPage deliveryAddressPage=new DeliveryAddressPage(getDriver());
		return deliveryAddressPage;
	}

}
