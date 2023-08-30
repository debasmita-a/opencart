package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.utils.ExcelUtil;

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
	
	@Test
	public void getProductInfoPageTitleTest(String searchKey, String productName) {
		searchPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle(), productInfoPage.getProductTitle());
	}
	
	@Test
	public void doesProductDescriptionExistTest() {
		Assert.assertTrue(productInfoPage.doesProductDescriptionExist()>0);
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"MacBook", "MacBook Pro","MacBook Pro","Apple", "Product 18", "800","In Stock","$2,000.00","$2,000.00"},
			{"MacBook", "MacBook Air","MacBook Air","Apple", "Product 17", "700","In Stock","$1,202.00","$1,000.00"}
		};
		
	}
	
	@DataProvider
	public Object[][] getProductInfoExceldata() {
		Object[][] productInfo = ExcelUtil.getTestData(FrameworkConstants.PRODUCT_INFO_SHEET);
		return productInfo;
	}
	
	@Test(dataProvider = "getProductInfoExceldata")
	public void getProductInfoTest(String searchKey, String selectProduct, String productName, String brand, String productCode,
			String points, String availability, String price, String exVal) {
		
		searchPage = accountsPage.doSearch(searchKey);
		productInfoPage = searchPage.selectProduct(selectProduct);
		softAssert.assertEquals(productInfoPage.getProductInfo().get("productname"), productName);
		softAssert.assertEquals(productInfoPage.getProductInfo().get("Brand"), brand);
		softAssert.assertEquals(productInfoPage.getProductInfo().get("Product Code"), productCode);
		//softAssert.assertEquals(productInfoPage.getProductInfo().get("Reward Points"), points);
		softAssert.assertEquals(productInfoPage.getProductInfo().get("Availability"), availability);
		softAssert.assertEquals(productInfoPage.getProductInfo().get("productprice"), price);
		softAssert.assertEquals(productInfoPage.getProductInfo().get("exTax"), exVal);
		softAssert.assertAll();
	}
	//assert vs verfiy (soft assertion)
	
	@Test
	public void addProductToCartTest() {
		searchPage = accountsPage.doSearch("MacBook");
		productInfoPage = searchPage.selectProduct("MacBook Pro");
		productInfoPage.enterQuantity(2);
		String actualmsg = productInfoPage.addProductToCart();
		softAssert.assertTrue(actualmsg.contains("Success"));
		softAssert.assertTrue(actualmsg.contains("MacBook Pro"));
		
	}
}
