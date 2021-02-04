package com.qa.Students;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.resources.ExtentReportListener;
import com.relevantcodes.extentreports.LogStatus;

public class Student_Info extends ExtentReportListener {
	private JSONParser jsonp = new JSONParser();
	private FileReader reader;

	private String fileName = "student.json";

	@Test(priority = 1)
	public void User_name() throws Exception {
		logger = reports.startTest("Get username from given jsonfile");
		
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object
		JSONObject jsonobj = (JSONObject) obj;

		String username = (String) jsonobj.get("username");
		System.out.println("Username ----" + username);
		logger.log(LogStatus.INFO, "Get data form  given file");
	}

	@Test(priority = 2)
	public void User_id() throws Exception {
		logger = reports.startTest("Get all sessionid from given jsonfile ");
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object
		JSONObject jsonobj = (JSONObject) obj;
		JSONArray Session_id = (JSONArray) jsonobj.get("sessionid");
		System.out.println("Find all session Id*******************************");
//	 Iterator <JSONObject>  iterator = Session_id.iterator();
//	 
//	 while (iterator.hasNext()) {
//		 System.out.println("Session id =="+iterator.hasNext());
//		 
//	 }
		for (int i = 0; i < Session_id.size(); i++) {

		}
		System.out.println(Session_id);
		logger.log(LogStatus.PASS, "Get all sessionid form  given jsonfile");
	}

	@Test(priority = 3)
	public void User_lastsessionid() throws Exception {
		logger = reports.startTest("Get value of last sessionid from given jsonfile");
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object
		JSONObject jsonobj = (JSONObject) obj;
		JSONArray Session_id = (JSONArray) jsonobj.get("sessionid");
		System.out.println("Value of last session Id**********************");

		for (int i = 0; i < Session_id.size(); i++) {

		}
		System.out.println(Session_id.get(3));
		logger.log(LogStatus.PASS, "Get value of last sessionid form  given response");

	}

	@Test(priority = 4)
	public void User_marks() throws Exception {
		logger = reports.startTest("Get marks of second student from given jsonfile ");
		ObjectMapper mapper = new ObjectMapper();
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object1
		JSONObject jsonobj = (JSONObject) obj;
		JSONArray stu = (JSONArray) jsonobj.get("students");

		System.out.println("Find  mark of second student******************************");
		Student stud = mapper.readValue(stu.get(1).toString(), Student.class);
		System.out.println("Mark of second student " + stud.getMarks().toString());
		logger.log(LogStatus.PASS, "Get marks of second student form  given response");

	}

	@Test(priority = 5)
	public void User_secondcontact() throws Exception {
		logger = reports.startTest("Get second contact of second student from given jsonfile");
		ObjectMapper maper = new ObjectMapper();
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object1
		JSONObject jsonobj = (JSONObject) obj;
		JSONArray stu = (JSONArray) jsonobj.get("students");

		System.out.println("Second contact of second student************************");
		Student stud = maper.readValue(stu.get(1).toString(), Student.class);
		System.out.println("Contact of second student  " + stud.getContact().get(1));
		logger.log(LogStatus.PASS, "Get second contact of second student form  given response");
	}

	@Test(priority = 6)
	public void User_city() throws Exception {
		logger = reports.startTest("Get cities of second student from given jsonfile");
		ObjectMapper maper = new ObjectMapper();
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object1
		JSONObject jsonobj = (JSONObject) obj;
		JSONArray students = (JSONArray) jsonobj.get("students");

		System.out.println("cities of second student are************************");

		if (students != null) {
			Student stud = maper.readValue(students.get(1).toString(), Student.class);
			System.out.println("City of student2 " + ((ArrayList) stud.getadresss()).get(1));

			System.out.println("City of student2  " + ((ArrayList) stud.getadresss()).get(1));
			logger.log(LogStatus.PASS, "get cities of second student form  given response");
		}
	}

	@Test(priority = 7)
	public void User_contact() throws Exception {
		logger = reports.startTest("Get all contacts  from given jsonfile");
		ObjectMapper maper = new ObjectMapper();
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object1
		JSONObject jsonobj = (JSONObject) obj;
		JSONArray student = (JSONArray) jsonobj.get("students");
		System.out.println("All contact of students***************************");
		try {
			if (student != null) {
				Student stud = new Student();

				stud = maper.readValue(student.get(0).toString(), Student.class);
				System.out.println("Contact of student1  " + stud.getContact().toString());
				Student stud1 = maper.readValue(student.get(1).toString(), Student.class);
				System.out.println("Contact of student2  " + stud1.getContact().toString());
			}
		}

		catch (JsonParseException e) {
			e.printStackTrace();
		}
		logger.log(LogStatus.PASS, "Get all contact of student form  given response");
	}

	@Test(priority = 8)
	public void User_firstaddress() throws Exception {
		logger = reports.startTest("Get address of first student from given jsonfile");
		ObjectMapper maper = new ObjectMapper();
		reader = new FileReader(getClass().getClassLoader().getResource(fileName).getFile());

		Object obj = jsonp.parse(reader);

		// convert java object into json object1
		JSONObject jsonobj = (JSONObject) obj;
		JSONArray stu = (JSONArray) jsonobj.get("students");

		System.out.println("Address of first student *******************");
		Student stud = maper.readValue(stu.get(0).toString(), Student.class);
		System.out.println("Address of first student  " + stud.getadresss().toString());
		logger.log(LogStatus.PASS, "Get address of first student form  given response");

	}
}
