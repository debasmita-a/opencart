package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
}
