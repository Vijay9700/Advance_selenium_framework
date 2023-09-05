package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement header;

	public WebElement getHeader() {
		return header;
	}
	
	public String headerText()
	{
		return getHeader().getText();
	}
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement organizationnameText;

	public WebElement getOrganizationnameText() {
		return organizationnameText;
	}
	
	@FindBy(xpath = "//img[@src=\\\"themes/softed/images/user.PNG\\\"]")
	private WebElement administratorIcon;

	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}
	
	public void moveOnAdministratorIcon()
	{
		Actions action=new Actions(driver);
		action.moveToElement(administratorIcon).perform();
	}
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	public WebElement getSignoutLink() {
		return signoutLink;
	}

}
