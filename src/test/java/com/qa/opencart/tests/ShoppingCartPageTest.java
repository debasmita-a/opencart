package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class ShoppingCartPageTest extends BaseTest{
	
	@BeforeTest
	public void shoppingCartPageSetup() {
		accountsPage = homePage.navigateToLoginPage().navigateToAccountsPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void getShoppingCartpageURLTest() {
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertTrue(shoppingcartPage.getShoppingCartpageURL().contains(FrameworkConstants.SHOPPING_CART_PAGE_URL));
	}
	
	@Test
	public void getShoppingCartPageTitleTest() {
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertEquals(shoppingcartPage.getShoppingCartPageTitle(), FrameworkConstants.SHOPPING_CART_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[] productAddToCartTestdata(){
		List<String> data = new ArrayList<>(Arrays.asList("Samsung SyncMaster 941BW","MacBook","iMac"));
		return new Object[]{data};
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void getCartTotalItemsTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertEquals(shoppingcartPage.getCartTotalItems(), products.size());
		shoppingcartPage.removeAllItemsFromCart();
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void getProductsTotalPriceTest(List<String> products) {
	    for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertTrue(shoppingcartPage.getProductsTotalPrice());
		shoppingcartPage.removeAllItemsFromCart();
	}
	
	@Test(enabled = false, dataProvider = "productAddToCartTestdata")
	public void getCartPriceDetailsTest(List<String> products) {
		
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		System.out.println(shoppingcartPage.getCartPriceDetails());
	}

		
	
}
