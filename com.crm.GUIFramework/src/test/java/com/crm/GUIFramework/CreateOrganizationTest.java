package com.crm.GUIFramework;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.basetest.BaseTest;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.listenerutility.ListenerImplementation;
import com.crm.generic.webdriverutility.WebDriverUtility;
import com.crm.objectrepository.CreatingNewOrganizationPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganizationInformationPage;
import com.crm.objectrepository.OrganizationsPage;

import junit.framework.Assert;
//@Listeners(com.crm.generic.listenerutility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseTest {
	
	@Test(groups = "smoke")
	public void createOrganizationTest() throws IOException, InterruptedException {
		
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		FileUtility f=new FileUtility();
//		driver.get(f.getDataFromPropertiesFile("url"));
		WebDriverUtility wutility=new WebDriverUtility();
//		wutility.waitUntilPageLoaded(driver);
//		//login
//		LoginPage login=new LoginPage(driver);
//		login.loginVtiger();
//		
		//click on org link
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
		//click on create img icon
		OrganizationsPage org=new OrganizationsPage(driver);
		org.getCreateimgIcon().click();
		
		//create org with valid info
		Random random=new Random();
		int randomnumber = random.nextInt(5000);
		ExcelUtility excel=new ExcelUtility();
		String OrganizationName = excel.getDataFromExcelFile("Organization", 1, 2)+randomnumber;
		CreatingNewOrganizationPage create=new CreatingNewOrganizationPage(driver);
		create.getOrganizationNameTextfield().sendKeys(OrganizationName);
		create.getSaveButton().click();
		//wutility.getScreenShot(driver);
		//validate
		Thread.sleep(5000);
		OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
		String headerText = orgInfo.headerText().trim();
		//String actualOrgNameText=orgInfo.getOrganizationnameText().getText();
		//ListenerImplementation l1=new ListenerImplementation();
		try {
			Assert.assertEquals(headerText.contains(OrganizationName), true);
		} catch (AssertionError e) {
			Assert.fail();
		}
//		if(headerText.contains(OrganizationName))
//		{
//			System.out.println("Organization name validated...matched...pass");
//		}
//		else
//		{
//			System.out.println("Organization name validated...not matched...fail");
//		}
		
//		//signout
//		Actions action=new Actions(driver);
//		action.moveToElement(home.getAdministratorIcon()).perform();;
//		home.getSignoutLink().click();
		
//		//close browser
//		driver.quit();
	}

}
