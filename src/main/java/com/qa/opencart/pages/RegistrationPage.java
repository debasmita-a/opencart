package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By pwdConfirm = By.id("input-confirm");
	private By newsletterRadioBtn = By.xpath("//label//input[@value = 0]");
	private By privacyPolicyCheck = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit']");
	
	//registration shouldn't be completed if Privacy policy is not checked.
	//"Your Account has been created" success message
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	public AccountCreatedPage doRegistration(String fName, String lName, String emailID, String tele, String pass, String passConfirm) {
		util.doSendKeys(firstName, fName);
		util.doSendKeys(lastName, lName);
		util.doSendKeys(email, emailID);
		util.doSendKeys(telephone, tele);
		util.doSendKeys(password, pass);
		util.doSendKeys(pwdConfirm, pass);
		//util.doGetAttributeValue(newsletterRadioBtn, "value");
		util.doClick(privacyPolicyCheck);
		util.doClick(continueBtn);
		
		return 	new AccountCreatedPage(driver);
	}
	
	public boolean isPrivacyPolicyChecked() {
		return util.doIsEnabled(privacyPolicyCheck);
	}
	
	public String isNewsletterSelectedNo() {
		return util.doGetAttributeValue(newsletterRadioBtn,"value");
	}
	
	public String getRegistrationPageTitle() {
		return util.waitForTitleContains("Register", 200);
	}
	
	public String getRegistrationPageURL() {
		return util.waitForURLContains("route=account/register", 100);
	}
}
