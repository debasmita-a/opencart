package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.FrameworkConstants;
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
	private By accountAlreadyExistsText = By.xpath("//div//h1//following-sibling::p");
	//private By accountAlreadyExistsLoginLink = By.xpath("//div//h1//following-sibling::p/a");
	
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
		util.doSendKeys(pwdConfirm, passConfirm);
		//util.doGetAttributeValue(newsletterRadioBtn, "value");
		util.doClick(privacyPolicyCheck);
		util.doClick(continueBtn);
		
		return 	new AccountCreatedPage(driver);
	}
	
	public boolean isPrivacyPolicyChecked() {
		return util.doIsEnabled(privacyPolicyCheck);
	}
	
	public boolean isNewsletterSelectedNo() {
		System.out.println("Innertext of Radio button selected : "+util.doGetText(newsletterRadioBtn));
		return util.doGetAttributeValue(newsletterRadioBtn,"value").equalsIgnoreCase(FrameworkConstants.REGISTRATION_PAGE_NEWSLETTER_RADIO_VALUE);
	}
	
	public String getRegistrationPageTitle() {
		return util.waitForTitleContains(FrameworkConstants.REGISTRATION_PAGE_TITLE_VALUE, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}
	
	public String getRegistrationPageURL() {
		return util.waitForURLContains("route=account/register", FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}
	
	public String msgUserAccountAlreadyExists() {
		return util.doGetInnerText(accountAlreadyExistsText);
	}
}
