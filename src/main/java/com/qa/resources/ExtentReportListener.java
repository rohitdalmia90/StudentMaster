package com.qa.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportListener {

	public ExtentReports reports;
	public ExtentTest logger;

	@BeforeSuite

	// initializing extent report
	public void propertyExtentSetup() {
		// extent report
		String filename = new SimpleDateFormat("'student_'yyyyMMddHHmmSS'.html'").format(new Date());
		String userDirectory = System.getProperty("user.dir");
		String path = userDirectory + "\\StudentsProject-master\\target\\Student_extent\\" + filename;
		reports = new ExtentReports(path);
	}

	@AfterSuite
	public void close() {

		reports.endTest(logger);
		reports.flush();
	}

	// public static void setup() throws IOException {
	// logger=Logger.getLogger("Students");
	// PropertyConfigurator.configure("C:\\Users\\sukhd\\eclipse-workspace\\Students\\log4j.properties");
	// prop = new Properties();

}
