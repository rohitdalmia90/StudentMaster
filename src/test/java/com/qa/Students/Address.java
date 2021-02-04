package com.qa.Students;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	private Object adresss;
	@JsonProperty
	private String state;
	@JsonProperty
	private String city;

	public Object getadresss() {
		return adresss;
	}

	public void setadresss(Object adresss) {
		this.adresss = adresss;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
