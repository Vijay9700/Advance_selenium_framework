package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;

	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
//	public void logout() {
//		Actions action=new Actions(driver);
//		action.moveToElement(administratorIcon).perform();
//		getSignoutLink().click();
//	}

}
