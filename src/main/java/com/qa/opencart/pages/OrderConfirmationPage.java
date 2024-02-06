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
	private By orderConfirmationHeader = By.xpath("//h2");
	private By continueBtn = By.linkText("Continue");
	
	//page actions
	
	public String getOrderConfirmPageTitle() {
		return util.getPageTitle();
	}
	
	public String getOrderConfirmPageURL() {
		return util.getPageUrl();
	}
	
	public String getOrderConfirmationHeader() {
		return util.doGetText(orderConfirmationHeader);
	}
	
	public HomePage clickContinueBtn() {
		util.doClick(continueBtn);
		return new HomePage(driver);
	}
}
