package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class CheckoutPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private By locators
	private By newCustomerHeader = By.xpath("(//h2)[1]");
	private By returningCustomerHeader = By.xpath("(//h2)[2]");
	
}
