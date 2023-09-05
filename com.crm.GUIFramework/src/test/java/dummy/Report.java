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

public class Report {
	
	@Test
	public void reportGeneration()
	{
		Date date=new Date();
		String cdate = date.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./DummyReport/"+cdate+".html");
		
		//congig report
		spark.config().setDocumentTitle("dummy report");
		spark.config().setReportName("low lwvel report");
		spark.config().setTheme(Theme.DARK);
		//set environment details
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("TESTER", "Vj");
		report.setSystemInfo("OS", "windows 11");
		report.setSystemInfo("IDE", "Ecplise 2023-03");
		
		//script
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("vijayganesan.in@gmail.com");
		
		ExtentTest test = report.createTest("dummy");
		test.log(Status.INFO, "report generated successfully");
		//attach ss
		TakesScreenshot ts=(TakesScreenshot) driver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp);
		driver.findElement(By.id("pass")).sendKeys("vijay@@@");
		String temp1 = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp1);
		driver.quit();
		report.flush();
	}

}
