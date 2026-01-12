package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility{

	private static final By SIZE_DROPDOWN_LOCATOR=By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_PRODUCT_DETAILS_LOCATOR=By.xpath("//p[@id='add_to_cart']/button");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//a[@title='Proceed to checkout']/span");
	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ProductDetailsPage changeSize(String value) {
		selectFromDropDown(SIZE_DROPDOWN_LOCATOR, value);
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage addToCart() {
		clickOn(ADD_TO_CART_BUTTON_PRODUCT_DETAILS_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}
	
	public ShoppingCartSummaryPage proceedToCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingCartSummaryPage shoppingCartPage=new ShoppingCartSummaryPage(getDriver());
		return shoppingCartPage;
	}

	

}
