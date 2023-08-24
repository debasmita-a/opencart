package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil util;
	
	//1.private By locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By logo = By.id("logo");
	private By navBar = By.xpath("//ul[@class ='nav navbar-nav']");
	private By navBarMenu = By.xpath("//ul[@class ='nav navbar-nav']/li/a");
	private By breadcrumb = By.xpath("//ul[@class = 'breadcrumb']");
	private By breadcrumbMenu = By.xpath("//ul[@class = 'breadcrumb']/li/a");
	private By columnrightMenu = By.xpath("//aside[@id='column-right']/div/a");
	private By footerHeaders = By.xpath("//div/h5");
	private By footerMenu = By.xpath("//div[@class='col-sm-3']/ul/li");
	private By footerText = By.xpath("//div[@class='container']/p");
	private By registerLink = By.linkText("Register");
	
	//2.public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	//3.page actions/behavior
	public String getLoginPageTitle() {
		String title = util.waitForTitleIs(FrameworkConstants.LOGIN_PAGE_TITLE_VALUE, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT);
		System.out.println("Title of Login page : "+ title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Login page URL is : "+url);
		return url;
	}
	
	public boolean doesForgotPwdLinkExist() {
		return util.doIsDisplayed(forgotPwdLink);
	}
	
	public boolean doesLogoExist() {
		return util.waitForElementVisible(logo, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
	}
	
	public boolean doesNavBarExist() {
		return util.doIsDisplayed(navBar);
	}
	
	public List<String> allNavBarMenu() {
		List<WebElement> menu = util.getElements(navBarMenu);
		List<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}		
		return list;
	}
	
	public boolean doesBreadcrumbExist() {
		return util.doIsDisplayed(breadcrumb);
	}
	
	public ArrayList<String> allBreadcrumnMenu() {
		List<WebElement> menu = util.getElements(breadcrumbMenu);
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}		
		return list;
	}
	
	public ArrayList<String> allColumnRightMenu() {
		List<WebElement> menu = util.getElements(columnrightMenu);
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}	
		return list;
	}
	
	public List<String> allFooterHeaders(){
		List<WebElement> menu = util.getElements(footerHeaders);
		List<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}
		return list;
	}
	
	public List<String> allFooterMenu() {
		List<WebElement> menu = util.getElements(footerMenu);
		List<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}
		return list;
	}
	
	public String isFooterText() {		
		return util.doGetText(footerText);
	}

	public AccountsPage doLogin(String un, String pwd) {
		util.waitForElementPresence(emailID, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		util.doSendKeys(password, pwd);
		util.doClick(loginBtn);
		return new AccountsPage(driver); //TDD approach - Test Driven Development
	}
	
	public RegistrationPage clickRegisterLink() {
		util.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
	
}

//private properties wrapped in public methods -Encapsulation
//We don't want anyone to have direct access to locators.
//If we need to access via public methods.
