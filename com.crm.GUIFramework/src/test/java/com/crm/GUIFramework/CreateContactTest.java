package com.crm.GUIFramework;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.basetest.BaseTest;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.objectrepository.ContactInformationPage;
import com.crm.objectrepository.ContactsPage;
import com.crm.objectrepository.CreateNewContactsPage;
import com.crm.objectrepository.HomePage;
@Listeners(com.crm.generic.listenerutility.ListenerImplementation.class)
public class CreateContactTest extends BaseTest {
	
	@Test(groups = "smoke")
	public void createContactTest() throws EncryptedDocumentException, IOException  {
		//click on contact link
		HomePage home=new HomePage(driver);
		home.getContactsLink().click();
		
		//click on contact page icon
		ContactsPage contact=new ContactsPage(driver);
		contact.getCreateContactsIcon().click();
		
		//create contact with last name
		CreateNewContactsPage newcontact=new CreateNewContactsPage(driver);
		ExcelUtility excel=new ExcelUtility();
		Random random=new Random();
		int randomnum = random.nextInt(5000);
		String lastname = excel.getDataFromExcelFile("Contact", 7, 2)+randomnum;
		newcontact.getLastnameTextfield().sendKeys(lastname);
		
		//click on save button
		newcontact.getSaveButton().click();
		ContactInformationPage cInfo=new ContactInformationPage(driver);
		try {
			Assert.assertEquals(cInfo.contactHeaderText().contains(lastname), true);
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

}
