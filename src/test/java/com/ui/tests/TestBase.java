package com.ui.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {
	HomePage homePage;
	Logger logger=LogManager.getLogger(this.getClass());
	private boolean isLamdaTest;
	
	
	@Parameters({"browser","isLamdaTest","isHeadless"})
	@BeforeMethod(description="Load the homepage of the website")
	public void setUp(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLamdaTest, 
			@Optional("true")boolean isHeadless,ITestResult result) {
		WebDriver lambdaDriver;
		this.isLamdaTest=isLamdaTest;
		if(isLamdaTest) {
			lambdaDriver=LambdaTestUtility.initiateLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage=new HomePage(lambdaDriver);
		}
		else {
		homePage=new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown() {
		if(isLamdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
			homePage.quit();
		}
	}
	
}
