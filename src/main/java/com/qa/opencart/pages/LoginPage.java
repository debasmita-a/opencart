package com.qa.opencart.pages;

import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//By locators
	private By emailAddress = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgottenPasswordLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By allRightColumnLinks = By.xpath("//aside[@id='column-right']//a");
	private By warningMessage = By.xpath("//div[contains(@class,'alert-dismissible')]"); //getInnerText
	private By logoutLink = By.linkText("Logout");
	private By myAccDropdownBtn = By.xpath("//a[@title='My Account']");
	
	//page actions
	public String getLoginPageTitle() {
		return util.getPageTitle();
	}
	
	public String getLoginPageUrl() {
		return util.getPageUrl();
	}
	
	public boolean isRegisterLinkAvailable() {
		return util.isElementDisplayed(registerLink);
	}
	
	public boolean isForgotPwdLinkAvailable() {
		return util.isElementDisplayed(forgottenPasswordLink);
	}
	
	public void enterCredentials(String email, String pwd) { //utility to page class
		util.doSendKeys(emailAddress, email);
		util.doSendKeys(password, pwd);
		util.doClick(loginBtn);
	}
	
	public void doLogout() { //utility to page class
		util.doClick(myAccDropdownBtn);
		util.doClick(logoutLink);
	}
	
	public String negativeLogin(String email, String pwd) {	
		enterCredentials(email, pwd);
		String warningMsg = util.doGetTextWithInnerText(warningMessage);
		return warningMsg;
	}
	
	public String doLogin(String email, String pwd) {
		enterCredentials(email, pwd);
		String myAccountPageTitle = util.getPageTitle();//then logout
		doLogout();
		return myAccountPageTitle;
	}
	
	public LinkedHashSet<String> getAllRightColumnLinks() {
		LinkedHashSet<String> rightColumnLinks = new LinkedHashSet<>();
		List<WebElement> rightColumnLinkList = util.getElements(allRightColumnLinks);
		for(WebElement e : rightColumnLinkList) {
			String linkName = e.getText();
			rightColumnLinks.add(linkName);
		}		
		return rightColumnLinks;
	}
	
	public AccountsPage navigateToAccountsPage(String email, String pwd) {
		enterCredentials(email, pwd);		
		return new AccountsPage(driver);
	}
	
	public ForgottenYourPasswordPage navigateToForgottenPasswordPage() {
		util.doClick(forgottenPasswordLink);
		return new ForgottenYourPasswordPage(driver);
	}
	
	public RegistrationPage navigateToRegistrationPage() {
		util.doClick(registerLink);
		return new RegistrationPage(driver);
	}
}
