package com.qa.Students;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qa.resources.ExtentReportListener;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class UserInfo extends ExtentReportListener {
	String url="https://jsonplaceholder.typicode.com/";
	String endpoint="posts"; 
	
	String URL;
	Response response;

	@Test
	public void getrequest() {

		logger=reports.startTest("Get response from given url ");	
		 URL=url+endpoint;
		RestAssured.baseURI=URL; 
		RestAssured.defaultParser = Parser.JSON;
	

   response= RestAssured. given().when().contentType("application/json").get();
   System.out.println(response.asString());
   logger.log(LogStatus.INFO,"Get data form  given post");

	}  
	@Test
	public void validateResponseStatus() {
		logger=reports.startTest("validate Response Status");
		 URL=url+endpoint;
			RestAssured.baseURI=URL; 
		
	int statuscode = RestAssured.given().when().contentType("application/json")
		 
		        .get().getStatusCode();
		     
		assertTrue(String.valueOf(statuscode).equals("200"));
		System.out.println("Status code is  "+statuscode);
		 logger.log(LogStatus.INFO,"Validate status code is 200");
		}

		@Test
		public void parseJson() {
			logger=reports.startTest("parse Json");
			 URL=url+endpoint;
				RestAssured.baseURI=URL; 
				RestAssured.defaultParser = Parser.JSON;
				System.out.println(response.jsonPath().getList("id"));
				//System.out.println(response.jsonPath().getList("userId"));
				System.out.println(response.jsonPath().getString("title[5]"));
				System.out.println(response.jsonPath().getString("body[35]"));
				System.out.println(response.jsonPath().getString("userId[60]"));
				 logger.log(LogStatus.INFO,"Parse data from json file");
				
			}
				
				@Test
		public void validateUserId() {
					logger=reports.startTest("validate uerId ");
			 URL=url+endpoint;
				RestAssured.baseURI=URL; 
				  response= RestAssured. given().pathParam("userId",7).when().contentType("application/json").get("https://jsonplaceholder.typicode.com/posts/{userId}");
				 response.prettyPrint();
				   System.out.println("response for user id 7 : " +response.prettyPrint());
		   
//		   for (int i = 0; i <userID.size(); i++) {
//		    	int a=7;
//		    	String str1 = Integer.toString(a);
//		    	if  ( userID.equals("7")) {
//		    		System.out.println(userID.get(i));
//		    }
//		    	System.out.println(userID.size());
		    		
		    		logger.log(LogStatus.INFO,"Validate userid7 from json file");
			
		    	
		    		 
		    	 }
}
//}
	     
			
		
	
	


