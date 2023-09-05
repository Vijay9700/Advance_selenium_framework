package com.crm.objectrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.fileutility.FileUtility;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameTextfield;

	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}

	@FindBy(name = "user_password")
	private WebElement passwordTextfield;

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}
	
	@FindBy(xpath = "(//input[@value='Login'])[2]")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginVtiger() throws IOException
	{
		FileUtility f=new FileUtility();
		getUsernameTextfield().sendKeys(f.getDataFromPropertiesFile("un"));
		getPasswordTextfield().sendKeys(f.getDataFromPropertiesFile("pwd"));
		getLoginButton().click();
	}

}
