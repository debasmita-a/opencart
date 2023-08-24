package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountCreatedPage;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	protected RegistrationPage registrationPage;
	protected AccountCreatedPage accCreatedPage;
	protected SearchPage searchPage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		accountsPage = new AccountsPage(driver);
		registrationPage = new RegistrationPage(driver);
		accCreatedPage = new AccountCreatedPage(driver);
		searchPage = new SearchPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
