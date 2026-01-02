package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.ExtentReporterUtility;

public class MyTestListeners implements ITestListener{
	
	Logger logger=LogManager.getLogger(this.getClass());

	ExtentSparkReporter extentSpartReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+" "+"PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" "+"PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getDescription());
	}
	
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName()+" "+"FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+"FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		Object testClass=result.getInstance();
		String path=((TestBase)testClass).getInstance().takeScreenshot(result.getMethod().getMethodName());
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(path);
	}
	
	public void onStart(ITestContext context) {
		logger.info("Test suite started successfully");
		ExtentReporterUtility.setUpSparkReporter("report.html");
	}
	
	
	public void onFinish(ITestContext context) {
		logger.info("Test suite completed successfully");
		ExtentReporterUtility.flushReport();
	}
}
