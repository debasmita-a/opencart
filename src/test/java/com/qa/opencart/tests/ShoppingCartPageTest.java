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
import com.qa.opencart.pages.ShoppingCartPage;

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
		List<String> data = new ArrayList<>(Arrays.asList("MacBook Pro","MacBook","iMac"));
		return new Object[]{data};
	}
	
	@Test(enabled = false, dataProvider = "productAddToCartTestdata")
	public void getCartTotalItemsTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertEquals(shoppingcartPage.getCartTotalItems(), products.size());
		shoppingcartPage.removeAllItemsFromCart();
	}
	
	@Test(enabled = false, dataProvider = "productAddToCartTestdata")
	public void getProductsTotalPriceTest(List<String> products) {
	    for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		
	}
	
	@Test(enabled = false, dataProvider = "productAddToCartTestdata")
	public void getCartPriceDetailsTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
	}
	
	@Test
	public void checkProductPriceOnCartTest() {
		productInfoPage = accountsPage.doSearch("MacBook").selectProduct("MacBook Pro");
		double productPriceFromInfoPage = (double)productInfoPage.getProductData().get("Product price");
		productInfoPage.addProductToCart();
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		double productPriceOnCartPage = shoppingcartPage.getProductPriceOnCart();
		Assert.assertEquals(productPriceFromInfoPage, productPriceOnCartPage);
		shoppingcartPage.removeAllItemsFromCart();
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void removeAllItemsFromCartTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertTrue(shoppingcartPage.removeAllItemsFromCart());
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void doesContinueShoppingBtnExistTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertTrue(shoppingcartPage.doesContinueShoppingBtnExist());
		shoppingcartPage.removeAllItemsFromCart();
	}
	
	@Test(dataProvider = "productAddToCartTestdata")
	public void doesCheckoutBtnExistTest(List<String> products) {
		for(String product : products) {
	    	accountsPage.doSearch(product).selectProduct(product).addProductToCart();
	    }
		shoppingcartPage = accountsPage.navigateToShoppingCartPage();
		Assert.assertTrue(shoppingcartPage.doesCheckoutBtnExist());
		shoppingcartPage.removeAllItemsFromCart();
	}
}
