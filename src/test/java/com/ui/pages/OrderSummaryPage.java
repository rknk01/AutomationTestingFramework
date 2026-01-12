package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utility.BrowserUtility;

public class OrderSummaryPage extends BrowserUtility{

	private static final By CONFIRM_ORDER_BUTTON_lOCATOR=By.xpath("//button/span[text()='I confirm my order']");
	private static final By ORDER_CONFIRMATION_MSG_LOCATOR=By.xpath("//p[@class='alert alert-success']");
	public OrderSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public OrderSummaryPage clickOnConfirmOrder() {
		clickOn(CONFIRM_ORDER_BUTTON_lOCATOR);
		return new OrderSummaryPage(getDriver());
	}
	
	public String getOrderConfirmationMsg() {
		String result=getVisibleText(ORDER_CONFIRMATION_MSG_LOCATOR);
		
		return result;
	}

}
