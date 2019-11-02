package org.bhn.training.web.models;

public class Customer {
	private String user;
	private LastProduct latestProduct;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LastProduct getLatestProduct() {
		return latestProduct;
	}

	public void setLatestProduct(LastProduct latestProduct) {
		this.latestProduct = latestProduct;
	}
}
