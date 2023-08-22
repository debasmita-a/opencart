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
	private By newsletterRadioBtn = By.name("newsletter");
	private By privacyPolicyCheck = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit']");
	
	//registration shouldn't be completed if Privacy policy is not checked.
	//"Your Account has been created" success message
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public AccountCreatedPage doRegistration(String fName, String lName, String emailID, String tele, String pass, String passConfirm) {
		util.doSendKeys(firstName, fName);
		util.doSendKeys(lastName, lName);
		util.doSendKeys(email, emailID);
		util.doSendKeys(telephone, tele);
		util.doSendKeys(password, pass);
		util.doSendKeys(pwdConfirm, pass);
		driver.findElement(newsletterRadioBtn).getAttribute("checked");
		util.doClick(privacyPolicyCheck);
		util.doClick(continueBtn);
		
		return 	new AccountCreatedPage(driver);
	}
	
	public boolean isPrivacyPolicyChecked() {
		return util.doIsEnabled(privacyPolicyCheck);
	}
	
	public String isNewsletterSelectedNo() {
		return util.doGetInnerText(newsletterRadioBtn);
	}
	
	public String getRegistrationPageTitle() {
		return util.waitForTitleContains(FrameworkConstants.REGISTRATION_PAGE_TITLE_VALUE, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}
	
	public String getRegistrationPageURL() {
		return util.waitForURLContains("route=account/register", FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}
}
