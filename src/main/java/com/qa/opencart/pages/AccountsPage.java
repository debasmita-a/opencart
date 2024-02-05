package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//page objects
	private By searchBox = By.name("search");
	private By searchIcon = By.xpath("(//button[contains(@class,'btn-lg')])[1]");
	private By logoutLink = By.linkText("Logout");
	private By allHeaders = By.xpath("//h2");
	private By shoppingCartLink = By.linkText("Shopping Cart");
	private By cartTotal = By.id("cart");
	private By cartEmptyText = By.xpath("//div[@id='cart']//li");
	
	//page actions
	public String getAccountsPageURL() {
		return util.getPageUrl();
	}
	
	public String getAccountsPageTitle() {
		return util.getPageTitle();
	}
	
	public boolean doesLogoutLinkExist() {
		return util.isElementDisplayed(logoutLink);
	}
	
	public List<String> getAccountsPageHeaders() {
		List<WebElement> headerElements = util.getElements(allHeaders);
		List<String> headers = new ArrayList<>();
		
		for(WebElement e : headerElements) {
			headers.add(e.getText());
		}		
		return headers;		
	}
	
	public int getAccountsPageHeadersCount() {
		return getAccountsPageHeaders().size();
	}

	public SearchResultPage doSearch(String itemName) {
		util.doSendKeys(searchBox, itemName);
		//util.waitForElementToBePresent(searchBox, 5).sendKeys(itemName);
		util.doClick(searchIcon);
		//util.waitForElementToBeClickable(searchIcon, 5).click();
		return new SearchResultPage(driver);
	}
	
	public ShoppingCartPage navigateToShoppingCartPage() {
		util.doClick(shoppingCartLink);
		return new ShoppingCartPage(driver);
	}
	
	public String getEmptyCartText() {
		util.doClick(cartTotal);
		return util.doGetText(cartEmptyText);
	}
}
