package com.ui.pojos;

public class Environment {
	private String url;
	private int MAX_NO_OF_ATTEMPS;
	public int getMAX_NO_OF_ATTEMPS() {
		return MAX_NO_OF_ATTEMPS;
	}

	public void setMAX_NO_OF_ATTEMPS(int mAX_NO_OF_ATTEMPS) {
		MAX_NO_OF_ATTEMPS = mAX_NO_OF_ATTEMPS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
