package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.CheckoutPage;
import com.qa.opencart.pages.ForgottenYourPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.OrderConfirmationPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultPage;
import com.qa.opencart.pages.ShoppingCartPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected ForgottenYourPasswordPage forgotPasswordPage;
	protected AccountsPage accountsPage;
	protected SearchResultPage searchResPage;
	protected ProductInfoPage productInfoPage;
	protected ShoppingCartPage shoppingcartPage;
	protected CheckoutPage checkoutPage;
	protected OrderConfirmationPage orderConfirmPage;
	
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
