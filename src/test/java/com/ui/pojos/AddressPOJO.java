package com.ui.pojos;

public class AddressPOJO {
	
	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postCode;
	private String homePhone;
	private String mobilePhone;
	private String additionalInfo;
	private String aliasName;
	
	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String state,
			String postCode, String homePhone, String mobilePhone, String additionalInfo, String aliasName) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.additionalInfo = additionalInfo;
		this.aliasName = aliasName;
	}

	public String getCompany() {
		return company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getAliasName() {
		return aliasName;
	}

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", postCode=" + postCode + ", homePhone=" + homePhone
				+ ", mobilePhone=" + mobilePhone + ", additionalInfo=" + additionalInfo + ", aliasName=" + aliasName
				+ "]";
	}
	
	
	
}
