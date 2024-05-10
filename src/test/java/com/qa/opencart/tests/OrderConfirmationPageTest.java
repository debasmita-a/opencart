package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class OrderConfirmationPageTest extends BaseTest{

	@BeforeClass
	public void orderConfirmationPageSetup() {
		accountsPage = homePage.navigateToLoginPage().navigateToAccountsPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[] productAddToCartTestdata(){
		List<String> data = new ArrayList<>(Arrays.asList("MacBook Pro","MacBook"));
		return new Object[]{data};
	}
	
	@Test(enabled = true, dataProvider = "productAddToCartTestdata")
	public void getOrderConfirmPageTitleTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		checkoutPage = shoppingcartPage.doCheckout();
		checkoutPage.confirmCheckoutDetails();
		orderConfirmPage = checkoutPage.confirmOrder();
		Assert.assertTrue(orderConfirmPage.getOrderConfirmPageTitle());
	}
	
	@Test(enabled = true, dataProvider = "productAddToCartTestdata")
	public void getOrderConfirmPageURLTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		checkoutPage = shoppingcartPage.doCheckout();
		checkoutPage.confirmCheckoutDetails();
		orderConfirmPage = checkoutPage.confirmOrder();
		Assert.assertTrue(orderConfirmPage.getOrderConfirmPageURL().contains(FrameworkConstants.ORDER_PLACED_PAGE_URL));
	}
}
