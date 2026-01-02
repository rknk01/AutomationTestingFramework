package com.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility{

	Logger logger=LogManager.getLogger(this.getClass());
	static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
		maximizeWindow();
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
	}
	
	public void quit() {
		getDriver().quit();
	}
	public LogInPage goToLogInPage() {
		logger.info("Trying to click on sign link to go to login page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LogInPage logInPage=new LogInPage(getDriver());
		return logInPage;
	}
}
