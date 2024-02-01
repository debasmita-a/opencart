package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ShoppingCartPageTest extends BaseTest{

	@BeforeClass
	public void shoppingCartPageSetup() {
		accountsPage = homePage.navigateToLoginPage()
		          .navigateToAccountsPage(prop.getProperty("username"), 
		        		  prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] productAddToCartTestdata() {
		return new Object[][] {
			{"macbook", "MacBook"},
			{"macbook", "MacBook Air"},
			{"imac", "iMac"}
		};
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void shoppingCartTest(String searchKey, String productName) {
		productInfoPage = accountsPage.doSearch(searchKey).selectProduct(productName);
		shoppingcartPage = productInfoPage.navigateToShoppingCartPage();
	}
	
}
