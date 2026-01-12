package com.ui.tests;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojos.User;

@Listeners({com.ui.listeners.MyTestListeners.class})
public class LoginTest extends TestBase {
	
	private static final String USERNAME="abcd@gmail.com";
	private static final String PASSWORD="pass1234";
	
	
	@Test(description="Verifies that the valid user is able to login to application", groups= {"e2e","Sanity"}, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LoginDataProvider")
	public void logInTest(User user) {
		String userName=homePage.goToLogInPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
		assertEquals(userName, "James Bond");
		
		
	}
	
	@Test(description="Verifies that the invvalid user is not able to login to application",groups= {"e2e","sanity","smoke"})
	public void invalidLoginTest(User user) {
		assertEquals(homePage.goToLogInPage().doLoginWithInvalidCredentials(USERNAME, PASSWORD).getValidationMessage(),"Authentication failed.");
	}
	
	
	/*
	 * @Test(
	 * description="Verifies that the valid user is able to login to application reading CSV files"
	 * , groups= {"e2e","Sanity"}, dataProviderClass =
	 * com.ui.dataProvider.LoginDataProvider.class, dataProvider =
	 * "LoginTestCSVDataProvider") public void logInCSVTest(User user) {
	 * 
	 * String userName=homePage.goToLogInPage().doLoginWith(user.getEmailAddress(),
	 * user.getPassword()).getUserName(); assertEquals(userName, "James Bond");
	 * 
	 * }
	 * 
	 * 
	 * @Test(
	 * description="Verifies that the valid user is able to login to application reading Excel files"
	 * , groups= {"e2e","Sanity"}, dataProviderClass =
	 * com.ui.dataProvider.LoginDataProvider.class, dataProvider =
	 * "LoginTestExcelDataProvider", retryAnalyzer =
	 * com.ui.listeners.MyRetryAnalyzer.class) public void logInExcelTest(User user)
	 * { String
	 * userName=homePage.goToLogInPage().doLoginWith(user.getEmailAddress(),
	 * user.getPassword()).getUserName(); assertEquals(userName, "James Bond1");
	 * 
	 * }
	 */

}
