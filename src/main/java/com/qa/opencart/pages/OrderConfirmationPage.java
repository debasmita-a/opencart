package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class OrderConfirmationPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private By locators
	private By orderConfirmationHeader = By.xpath("//h1");
	private By continueBtn = By.linkText("Continue");
	
	//page actions
	
	public boolean getOrderConfirmPageTitle() {
		return util.waitForTitleToBePresent(5, "Your order has been placed!");
	}
	
	public String getOrderConfirmPageURL() {
		return util.getPageUrl();
	}
	
	public boolean getOrderConfirmationHeader() {
		return util.waitForTextToBePresent(orderConfirmationHeader, 5, "Your order has been placed!");
		//return util.waitForElementToBePresent(orderConfirmationHeader, 5).getText();
	}
	
	public HomePage clickContinueBtn() {
		util.doClick(continueBtn);
		return new HomePage(driver);
	}
}
