package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//By locators
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By passwordConfirm = By.id("input-confirm");
	private By newsletterSubscription = By.name("newsletter");
	private By privacyPolicyCheck = By.name("agree");// attribute= checked, value=1/0
	private By continueBtn = By.xpath("//input[@value='Continue']");
	
	//page actions
	
}
