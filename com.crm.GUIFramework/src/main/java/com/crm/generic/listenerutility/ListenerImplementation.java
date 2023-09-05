package com.crm.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.basetest.BaseTest;

public class ListenerImplementation implements ITestListener,ISuiteListener  {
	public ExtentReports report;
	public static ExtentTest test ;
	
	public void onStart(ISuite suite) {
		Date date=new Date();
		String cdate = date.toString().replace(" ", "_").replace(":", "_");
		
		//create report path
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentsReport/"+cdate+".html");
		//confif report
		spark.config().setDocumentTitle("advance report");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.DARK);
		//add environment details
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS 11");
		report.setSystemInfo("Browser", "Chrome");
	}

	public void onFinish(ISuite suite) {
		report.flush();
	}

	public void onTestStart(ITestResult result) 
	    {
		 test = report.createTest(result.getMethod().getMethodName());
		}

	public void onTestSuccess(ITestResult result) {
		ListenerImplementation.test.log(Status.PASS,result.getMethod().getMethodName()+"...SUCCESS...");
	}

	public void onTestFailure(ITestResult result) {
		Date date=new Date();
		String cdate = date.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
//		File dest=new File("./Screenshots/"+result.getMethod().getMethodName()+cdate+".png"); 
//		try {
//			FileHandler.copy(temp, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ListenerImplementation.test.addScreenCaptureFromBase64String(temp);
		ListenerImplementation.test.log(Status.FAIL,result.getMethod().getMethodName()+"...FAILED...");
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	

}
