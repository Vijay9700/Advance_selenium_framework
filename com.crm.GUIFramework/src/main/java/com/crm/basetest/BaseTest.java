package com.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.listenerutility.ListenerImplementation;
import com.crm.generic.webdriverutility.WebDriverUtility;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;

public class BaseTest {
	public static WebDriver driver=null;
	public WebDriverUtility wutility=null;
	public Actions action=null;
	
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforeSuiteconfiguration()
	{
		//connect database 
		//report configuration
	}
	@AfterSuite(groups = {"smoke","regression"})
	public void afterSuite()
	{
		//close database
		//Report backup
	}
	@BeforeClass(groups = {"smoke","regression"})
	public void launchBrowser()
	{
		//browser launching
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void closeBrowser()
	{
		//close browser
		driver.manage().window().minimize();
		driver.quit();
	}
	@BeforeMethod(groups = {"smoke","regression"})
	public void login() throws IOException {
		FileUtility f=new FileUtility();
		driver.get(f.getDataFromPropertiesFile("url"));
	    wutility=new WebDriverUtility();
		wutility.waitUntilPageLoaded(driver);
		LoginPage login=new LoginPage(driver);
		login.loginVtiger();
	}
	@AfterMethod(groups = {"smoke","regression"})
	public void logout()
	{
		HomePage home =new HomePage(driver);
		action=new Actions(driver);
		action.moveToElement(home.getAdministratorIcon()).perform();;
		home.getSignoutLink().click();
	}


}
