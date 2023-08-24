package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By logoutLink = By.linkText("Logout");
	private By searchBox = By.name("search");
	private By accHeaders = By.xpath("//h2");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	public boolean doesLogoutLinkExist() {
		return util.doIsDisplayed(logoutLink);
	}
	
	public boolean doesSearchBoxExist() {
		return util.doIsDisplayed(searchBox);
	}
	
	public String getAccountsPageTitle() {
		return util.waitForTitleIs(FrameworkConstants.ACCOUNT_PAGE_TITLE_VALUE, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}
	
	public String getAccountsPageURL() {
		return util.waitForURLContains(FrameworkConstants.ACCOUNT_PAGE_URL, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
	}
	
	public List<String> listAccountsHeaders() {
		List<WebElement> list = util.getElements(accHeaders);
		List<String> accHeaders = new ArrayList<String>();
		for(WebElement e : list) {
			accHeaders.add(e.getText());
		}		
		return accHeaders;
	}
	
}
