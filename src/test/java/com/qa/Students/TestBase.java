package com.qa.Students;

import com.qa.resources.ExtentReportListener;

import io.restassured.response.Response;

public class TestBase extends ExtentReportListener {

	public  void setUp() {
		String url="https://jsonplaceholder.typicode.com/";
		String endpoint="posts";
		

	}

}
