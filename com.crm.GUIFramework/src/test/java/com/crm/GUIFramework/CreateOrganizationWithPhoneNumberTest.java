package com.crm.GUIFramework;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.basetest.BaseTest;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.WebDriverUtility;
import com.crm.objectrepository.CreatingNewOrganizationPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganizationInformationPage;
import com.crm.objectrepository.OrganizationsPage;

import junit.framework.Assert;

public class CreateOrganizationWithPhoneNumberTest extends BaseTest {
	
	@Test
	public void createOrganizationWithPhoneNumberTest() throws IOException, InterruptedException {
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		FileUtility f=new FileUtility();
//		driver.get(f.getDataFromPropertiesFile("url"));
//		WebDriverUtility wutility=new WebDriverUtility();
//		wutility.waitUntilPageLoaded(driver);
//		//login
//		LoginPage login=new LoginPage(driver);
//		login.loginVtiger();
		
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
		
		//give phone number
		String phoneNumber = excel.getDataFromExcelFile("Organization", 7, 3);
		create.getPhoneTextfield().sendKeys(phoneNumber);
		create.getSaveButton().click();
		
		//validate
				Thread.sleep(5000);
				OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
				String headerText = orgInfo.headerText();
				//String actualOrgNameText=orgInfo.getOrganizationnameText().getText();
//				if(headerText.contains(OrganizationName))
//				{
//					System.out.println("Organization name validated...matched...pass");
//				}
//				else
//				{
//					System.out.println("Organization name validated...not matched...fail");
//				}
				try {
					Assert.assertEquals(headerText.contains(OrganizationName), true);
				} catch (AssertionError e) {
					Assert.fail();
				}
				
				
//				//signout
//				Actions action=new Actions(driver);
//				action.moveToElement(home.getAdministratorIcon()).perform();;
//				home.getSignoutLink().click();
//				
//				driver.quit();
	}

}
