package com.ui.tests;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojos.User;

@Listeners(com.ui.listeners.MyTestListeners.class)
public class InvalidCredentialsLoginTest extends TestBase {
	
	private static final String USERNAME="abcd@gmail.com";
	private static final String PASSWORD="pass1234";
	
	

	
	
	@Test(description="Verifies that the invvalid user is not able to login to application",groups= {"e2e","sanity","smoke"})
	public void invalidLoginTest() {
		assertEquals(homePage.goToLogInPage().doLoginWithInvalidCredentials(USERNAME, PASSWORD).getValidationMessage(),"Authentication failed.");
	}
	
	

}
