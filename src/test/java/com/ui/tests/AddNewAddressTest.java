package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setUp() {
		myAccountPage=homePage.goToLogInPage().doLoginWith("pononic790@mucate.com", "password");
		address=FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description="logged in user navigates to add new address")
	public void addNewAddress() {
		String addressHeading=myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(addressHeading, address.getAliasName().toUpperCase());
	}
	
}
