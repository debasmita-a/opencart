package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.ForgottenYourPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected ForgottenYourPasswordPage forgotPasswordPage;
	
	@BeforeTest
	public void setup() {
		DriverFactory df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
	}
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
	
	
}
