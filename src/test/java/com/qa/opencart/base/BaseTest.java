package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		DriverFactory df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
	
	
}
