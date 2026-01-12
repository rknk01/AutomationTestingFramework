package com.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LogInPage extends BrowserUtility{
	Logger logger=LogManager.getLogger(this.getClass());
	static final By EMAIL_TEXT_BOX_LOCATOR=By.id("email");
	static final By PASSWORD_TEXT_BOX_LOCATOR=By.id("passwd");
	static final By SIGN_IN_BUTTON_LOCATOR=By.xpath("//button[@id='SubmitLogin']/span");
	static final By INVLALID_SIGNIN_MSG=By.xpath("//div[contains(@class,'alert-danger')]/ol/li");
	
	public LogInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyAccountPage doLoginWith(String email, String password) {
		logger.info("Entering the user details to login");
		enterText(EMAIL_TEXT_BOX_LOCATOR, email);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage=new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	public LogInPage doLoginWithInvalidCredentials(String email, String password) {
		logger.info("Entering the incorrect user details to login");
		enterText(EMAIL_TEXT_BOX_LOCATOR, email);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);

		LogInPage logInPage=new LogInPage(getDriver());
		return logInPage;
	}
	
	public String getValidationMessage() {
		return getVisibleText(INVLALID_SIGNIN_MSG);
	}
	
	

	
}
