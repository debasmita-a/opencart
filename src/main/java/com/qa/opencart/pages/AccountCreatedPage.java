package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountCreatedPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By successMsg = By.xpath("//div[@id = 'content']/p[1]");
	private By continueBtn = By.linkText("Continue");
	private By editAccountLink = By.linkText("Edit Account");
	
	public AccountCreatedPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	public String isAccountCreated() {
		return util.doGetText(successMsg);
	}
	
	public boolean doesEditAccountLinkExist() {
		return util.doIsDisplayed(editAccountLink);
	}
	
	public String getAccountCreatedPageTitle() {
		return util.waitForTitleContains(FrameworkConstants.ACCOUNT_CREATED_PAGE_TITLE_VALUE, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}
	
	public String getAccountCreatedPageURL() {
		return util.waitForURLContains(FrameworkConstants.ACCOUNT_CREATED_URL, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}

	public AccountsPage doContinue() {
		util.doClick(continueBtn);
		return new AccountsPage(driver);
	}
	
}
