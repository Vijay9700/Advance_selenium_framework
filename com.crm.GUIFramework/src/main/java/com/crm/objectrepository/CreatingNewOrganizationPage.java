package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement organizationNameTextfield;

	public WebElement getOrganizationNameTextfield() {
		return organizationNameTextfield;
	}
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}
	
	@FindBy(id = "phone")
	private WebElement phoneTextfield;

	public WebElement getPhoneTextfield() {
		return phoneTextfield;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	

}
