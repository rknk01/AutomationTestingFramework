package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojos.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY=By.id("company");
	private static final By ADRESS_LOCATOR=By.id("address1");
	private static final By ADDRESS2_LOCATOR=By.id("address2");
	private static final By CITY_LOCATOR=By.id("city");
	private static final By STATE_DROPDOWN_LOCATOR=By.id("id_state");
	private static final By POSTAL_CODE_LOCATOR=By.id("postcode");
	private static final By HOME_PHONE_LOCATOR=By.id("phone");
	private static final By MOBILE_PHONE_LOCATOR=By.id("phone_mobile");
	private static final By OTHERS_LOCATOR=By.id("other");
	private static final By SAVE_BUTTON_LOCATOR=By.xpath("//button[@id='submitAddress']/span");
	private static final By ALIAS_LOCATOR=By.id("alias");
	private static final By ADDRESS_HEADING_LOCATOR=By.xpath("//h3");
	
	public AddressPage(WebDriver driver) {
		super(driver);
	}
	
	public String saveAddress(AddressPOJO address) {
		enterText(COMPANY, address.getCity());
		enterText(ADRESS_LOCATOR, address.getAddressLine1());
		enterText(ADDRESS2_LOCATOR, address.getAddressLine2());
		enterText(CITY_LOCATOR, address.getCity());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, address.getState());
		enterText(HOME_PHONE_LOCATOR, address.getHomePhone());
		enterText(MOBILE_PHONE_LOCATOR, address.getMobilePhone());
		enterText(POSTAL_CODE_LOCATOR, address.getPostCode());
		enterText(OTHERS_LOCATOR, address.getAdditionalInfo());
		clearText(ALIAS_LOCATOR);
		enterText(ALIAS_LOCATOR, address.getAliasName());
		clickOn(SAVE_BUTTON_LOCATOR);
		String addressHeading=getVisibleText(ADDRESS_HEADING_LOCATOR);
		return addressHeading;
		
		
	}
}
