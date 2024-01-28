package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		DriverFactory df = new DriverFactory();
		prop = df.initProp();
		
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
	}
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
	
	
}
