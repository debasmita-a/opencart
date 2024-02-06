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

public class CheckoutPageTest extends BaseTest{

	@BeforeTest
	public void CheckoutPageSetup() {
		accountsPage = homePage.navigateToLoginPage().navigateToAccountsPage(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[] productAddToCartTestdata(){
		List<String> data = new ArrayList<>(Arrays.asList("MacBook Pro","MacBook"));
		return new Object[]{data};
	}
		
	@Test(dataProvider = "productAddToCartTestdata")
	public void getCheckoutPageURL(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		checkoutPage = shoppingcartPage.doCheckout();	
		Assert.assertTrue(checkoutPage.getCheckoutPageURL().contains(FrameworkConstants.CHECKOUT_PAGE_URL));
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		shoppingcartPage.removeAllItemsFromCart();
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void getCheckoutPageTitleTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		checkoutPage = shoppingcartPage.doCheckout();
		Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), FrameworkConstants.CHECKOUT_PAGE_TITLE);
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		shoppingcartPage.removeAllItemsFromCart();
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void confirmCheckoutDetailsTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		checkoutPage = shoppingcartPage.doCheckout();
		orderConfirmPage = checkoutPage.confirmCheckoutDetails();
		Assert.assertEquals(orderConfirmPage.getOrderConfirmationHeader(), FrameworkConstants.ORDER_CONFIRMATION);
	}
}
