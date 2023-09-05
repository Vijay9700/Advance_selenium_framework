package dummy;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class UseOfExtentsReport {
	
	@Test
	public void useOfExtendsReport()
	{
		Date date=new Date();
		String cdate = date.toString().replace(" ", "_").replace(":", "_");
		
		//create report path
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentsReport/"+cdate+".html");
		//confif report
		spark.config().setDocumentTitle("advance report");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.DARK);
		//add environment details
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS 11");
		report.setSystemInfo("Browser", "Chrome");
		
		//Script
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("vijayganesan.in@gmail.com");
		//take ss
		TakesScreenshot ts=(TakesScreenshot) driver;
		String ss = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("UseOfExtendsReport");
		test.log(Status.INFO, "pass");
		test.addScreenCaptureFromBase64String(ss);
		
		
		//flush-->store report
		report.flush();
		
	}

}
