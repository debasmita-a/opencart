package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By logoutLink = By.linkText("Logout");
	private By searchBox = By.name("search");
	private By accHeaders = By.xpath("//h2");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean doesLogoutLinkExist() {
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public boolean doesSearchBoxExist() {
		return driver.findElement(searchBox).isDisplayed();
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public String getAccountsPageURL() {
		return driver.getCurrentUrl();
	}
	
	public ArrayList<String> listAccountsHeaders() {
		List<WebElement> list = driver.findElements(accHeaders);
		ArrayList<String> accHeaders = new ArrayList<String>();
		for(WebElement e : list) {
			accHeaders.add(e.getText());
		}		
		return accHeaders;
	}
	
}
