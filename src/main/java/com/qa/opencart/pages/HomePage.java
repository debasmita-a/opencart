package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class HomePage {

	private WebDriver driver;
	private ElementUtils util;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private By locators
	
	private By myAccDropdownBtn = By.xpath("//a[@title='My Account']");
	private By loginLink = By.linkText("Login");
	private By registerLink = By.linkText("Register");
	
	//page actions
	public String getHomePageTitle() {
		return util.getPageTitle();
	}
	
	public String getHomePageURL() {
		return util.getPageUrl();
	}
	
	public LoginPage navigateToLoginPage() {
		util.doClick(myAccDropdownBtn);
		util.doClick(loginLink);
		return new LoginPage(driver);
	}
	
	public RegistrationPage navigateToRegistrationPage() {
		util.doClick(myAccDropdownBtn);
		util.doClick(registerLink);
		return new RegistrationPage(driver);
	}
}
