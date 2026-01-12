package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pages.SearchResultPage;

@Listeners({com.ui.listeners.MyTestListeners.class})
public class SearchProductTest extends TestBase{

	private MyAccountPage myAccountPage;
	private SearchResultPage searchResultPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setUp() {
		myAccountPage=homePage.goToLogInPage().doLoginWith("pononic790@mucate.com", "password");
	}
	
	
	@Test(description="Verify if the logged in user is able to search for a product and correct results are displayed", 
			groups= {"e2e","smoke","sanity"})
	public void verifyProductSearchTest() {
		boolean searchResult=myAccountPage.searchForAProduct("Summer Printed Dress").isSearchTermPresentInProductList(SEARCH_TERM);
		assertEquals(searchResult, true);
		
	}
	
	
}
