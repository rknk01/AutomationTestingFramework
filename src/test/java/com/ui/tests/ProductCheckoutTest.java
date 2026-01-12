package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{

	private static final String SEARCH_TERM="Printed Summer Dress";
	private static final String SIZE_VALUE="3";
	private static final String COMMENT_TEXT="Automation Testing using selenium";
	private static final String ORDER_CONFIRMATION_MESSAGE="Your order on My Shop is complete.";
	
	private SearchResultPage searchResultPage;
	@BeforeMethod(description="User logs into the application and search the product")
	public void setUp() {
		searchResultPage=homePage.goToLogInPage().doLoginWith("pononic790@mucate.com", "password").searchForAProduct(SEARCH_TERM);	
	}
	
	@Test(description="Logged in user will add the product to cart and perform checkout process")
	public void checkoutProduct() {
		String result=searchResultPage.clickOnTheProductAt(2).changeSize(SIZE_VALUE).addToCart().proceedToCheckout().proceedToCheckoutShoppingCart()
				.enterComment(COMMENT_TEXT).proceedToCheckoutDeliveryAddress().proceedToCheckoutShippingPage()
		.selectPaymentOptin().clickOnConfirmOrder().getOrderConfirmationMsg();
		Assert.assertEquals(result, ORDER_CONFIRMATION_MESSAGE);
		
	}
}
