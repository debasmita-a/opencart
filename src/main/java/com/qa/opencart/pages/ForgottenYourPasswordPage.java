package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class ForgottenYourPasswordPage {

	private WebDriver driver;
	private ElementUtils util;

	public ForgottenYourPasswordPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}

	// private By locators
	private By email = By.id("input-email");
	private By backBtnLink = By.linkText("Back");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	private By message = By.xpath("//div[contains(@class,'alert-dismissible')]");
	private By forgotPasswordLink = By.linkText("Forgotten Password");

	// page actions
	public String getForgotPasswordPageTitle() {
		return util.getPageTitle();
	}

	public String getForgotPasswordPageUrl() {
        return util.getPageUrl();
	}
	
	public String enterIncorrectEmail(String emailAddress) {
		util.doSendKeys(email, emailAddress);
		util.doClick(continueBtn);
		return util.doGetTextWithInnerText(message);
	}
	
	public String enterEmailToResetPassword(String emailAddress) {
		util.doSendKeys(email, emailAddress);
		util.doClick(continueBtn);
		String successMsg = util.doGetTextWithInnerText(message);
		util.doClick(forgotPasswordLink);
		return successMsg;
	}
}
