package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	
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
	private By footerMenu = By.xpath("//div[@class='col-sm-3']/ul/li");
	private By footerText = By.xpath("//div[@class='container']/p");
	
	//Forgot password page
	//New user- registration page
	//Accounts page
	
	//2.public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3.page actions/behavior
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Title of Login page : "+ title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Login page URL is : "+url);
		return url;
	}
	
	public boolean doesForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AccountsPage(driver); //TDD approach - Test Driven Development
	}
	
	public boolean doesLogoExist() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean doesNavBarExist() {
		return driver.findElement(navBar).isDisplayed();
	}
	
	public List<String> allNavBarMenu() {
		List<WebElement> menu = driver.findElements(navBarMenu);
		List<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}		
		return list;
	}
	
	public boolean doesBreadcrumbExist() {
		return driver.findElement(breadcrumb).isDisplayed();
	}
	
	public ArrayList<String> allBreadcrumnMenu() {
		List<WebElement> menu = driver.findElements(breadcrumbMenu);
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}		
		return list;
	}
	
	public ArrayList<String> allColumnRightMenu() {
		List<WebElement> menu = driver.findElements(columnrightMenu);
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}	
		return list;
	}
	
	public ArrayList<String> allFooterMenu() {
		List<WebElement> menu = driver.findElements(footerMenu);
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement e : menu) {
			list.add(e.getText());
		}	
		return list;
	}
	
	public String isFooterText() {		
		return driver.findElement(footerText).getText();
	}
	
}

//private properties wrapped in public methods -Encapsulation
//We don't want anyone to have direct access to locators.
//If we need to access via public methods.
