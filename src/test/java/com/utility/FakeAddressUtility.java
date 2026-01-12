package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPOJO;

public class FakeAddressUtility {

	public static AddressPOJO getFakeAddress() {
		
		Faker faker=new Faker(Locale.US);
		AddressPOJO addressPojo=new AddressPOJO(faker.company().name(), faker.address().buildingNumber(), faker.address().streetName(), faker.address().city(), "5", faker.numerify("#####"),faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other information", "TestNewAddress");
		return addressPojo;
	}
}
