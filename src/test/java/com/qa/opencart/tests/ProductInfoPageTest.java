package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class ProductInfoPageTest extends BaseTest{

	@BeforeClass
	public void productInfoPageSetup() {
		accountsPage = homePage.navigateToLoginPage()
				          .navigateToAccountsPage(prop.getProperty("username"), 
				        		  prop.getProperty("password"));
			                    
	}
	
	@DataProvider
	public Object[][] productTestdata(){
		return new Object[][] {
			{"samsung", "Samsung SyncMaster 941BW"},
			{"samsung", "Samsung Galaxy Tab 10.1"},
			{"macbook", "MacBook"},
			{"macbook", "MacBook Air"},
			{"macbook", "MacBook Pro"},
			{"imac", "iMac"}
		};
	}
	
	@Test(dataProvider = "productTestdata")
	public void productHeaderValueTest(String searchKey, String productName) {
		searchResPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);		
		Assert.assertEquals(productInfoPage.getProductHeaderValue(), productName);
	}

	@Test
	public void getProductDataTest() {
		searchResPage = accountsPage.doSearch("samsung");
		productInfoPage = searchResPage.selectProduct("Samsung Galaxy Tab 10.1");
		Map<String, Object> productActualData = productInfoPage.getProductData();
		System.out.println(productActualData);
	}
	
	@DataProvider
	public Object[][] productImgTestdata(){
		return new Object[][] {
			{"samsung", "Samsung SyncMaster 941BW", 1},
			{"samsung", "Samsung Galaxy Tab 10.1", 7},
			{"macbook", "MacBook", 5}
		};
	}
	
	@Test(dataProvider = "productImgTestdata")
	public void getProductImageCountTest(String searchKey, String productName, int imgCount) {
		searchResPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductImageCount(), imgCount);
	}
	
	@Test(dataProvider = "productTestdata")
	public void addProductToCartTest(String searchKey, String productName) {
		searchResPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		String actualMessage = productInfoPage.addProductToCart();
		Assert.assertTrue(actualMessage.contains(FrameworkConstants.PRODUCT_ADDED_TO_CART_First + productName + FrameworkConstants.PRODUCT_ADDED_TO_CART_Last));
	}
	
	@Test(dataProvider = "productTestdata")
	public void getProductInfoPageURL(String searchKey, String productName) {
		searchResPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		Assert.assertTrue(productInfoPage.getProductInfoPageURL().contains(FrameworkConstants.PRODUCT_INFO_PAGE_URL));
	}
	
	@Test(dataProvider = "productTestdata")
	public void getProductInfoPageTitleTest(String searchKey, String productName) {
		searchResPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle(), productName);
	}
}
