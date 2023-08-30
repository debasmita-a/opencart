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

	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type = 'radio']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type = 'radio']");
	private By privacyPolicyCheck = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit']");
	private By accountAlreadyExistsText = By.xpath("//div//h1//following-sibling::p");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	private By successMsg = By.xpath("//div[@id = 'content']/p[1]");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	public boolean doRegistration(String firstName, String lastName, String email, 
			String telephone, String password, String subscribe) {
		util.doSendKeys(this.firstName, firstName);
		util.doSendKeys(this.lastName, lastName);
		util.doSendKeys(this.email, email);
		util.doSendKeys(this.telephone, telephone);
		util.doSendKeys(this.password, password);
		util.doSendKeys(pwdConfirm, password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			util.doClick(subscribeYes);
		}else {
			util.doClick(subscribeNo);
		}
		util.doActionsClick(privacyPolicyCheck);
		util.doClick(continueBtn);
		
		String successMessage = util.waitForElementVisible(successMsg, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).getText();
		if(successMessage.equals(FrameworkConstants.ACCOUNT_CREATED_SUCCESS_MSG)) {
			util.doClick(logoutLink);
			util.doClick(registerLink);
			return true;
		}		
		return false;
	}
	
	public boolean isPrivacyPolicyChecked() {
		return util.doIsEnabled(privacyPolicyCheck);
	}
	
	public boolean isNewsletterSelectedNo() {
		System.out.println("Innertext of Radio button selected : "+util.doGetText(subscribeNo));
		return util.doGetAttributeValue(subscribeNo,"value").equalsIgnoreCase(FrameworkConstants.REGISTRATION_PAGE_NEWSLETTER_RADIO_VALUE);
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
