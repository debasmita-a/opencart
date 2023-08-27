package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public AccountsPage productInfoPageSetUp() {
		return loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@DataProvider
	public Object[][] getProductImgTestData() {
		return new Object[][] {
			{"MacBook", "MacBook Air", 4},
			{"MacBook", "MacBook Pro", 4},
			{"iMac", "iMac", 3},
			{"Apple", "Apple Cinema 30\"", 6},
			{"Samsung", "Samsung SyncMaster 941BW", 1}
		};
	}
	@Test(dataProvider = "getProductImgTestData")
	public void getProductImagesCountTest(String searchKey, String productName, int imgCount) {
		searchPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchPage.selectProduct(productName);
		int actualImgCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actualImgCount,imgCount);
	}
}
