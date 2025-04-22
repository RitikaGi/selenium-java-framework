package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;


public class ExtendReporterNG {
	
	public static ExtentReports getReportObject() {

	String path = System.getProperty("user.dir") + "//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	// Correct configuration access
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");

	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ritika Singh");

	// Optional test creation
	extent.createTest(path);
	return extent;

}}
