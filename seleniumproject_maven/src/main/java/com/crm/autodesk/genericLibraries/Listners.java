package com.crm.autodesk.genericLibraries;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listners implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS , result.getMethod().getMethodName() +"is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is Failed");
		
		BaseClass baseclass=new BaseClass();
		try {
			String path = baseclass.getScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
			   
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+ "skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
	ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("usr.dir")+ "/ExtentReportSDET21/ExtentReports1.html");
	reporter.config().setDocumentTitle("SDET21");
	reports=new ExtentReports();
	reports.attachReporter(reporter);
	reports.setSystemInfo("BuildNo", "5.1");
	reports.setSystemInfo("Env", "pre-prod");
	
	reports.setSystemInfo("platform", "Windows");
	reports.setSystemInfo("Browser Version", "Chrome-93");
	
	
	
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

	
	}


