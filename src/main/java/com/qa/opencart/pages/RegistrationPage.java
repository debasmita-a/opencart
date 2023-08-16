package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	private WebDriver driver;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By pwdConfirm = By.id("input-confirm");
	private By newsletterRadioBtn = By.name("newsletter");
	private By privacyPolicyCheck = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit']");
	
	//registration shouldn't be completed if Privacy policy is not checked.
	//"Your Account has been created" success message
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doRegistration() {
		driver.findElement(firstName).sendKeys("test01");
		driver.findElement(lastName).sendKeys("nameTest");
		driver.findElement(email).sendKeys("test01@gmail.com");
		driver.findElement(telephone).sendKeys("7766885");
		
	}
}
