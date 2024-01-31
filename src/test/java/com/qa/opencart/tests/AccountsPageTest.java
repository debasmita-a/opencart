package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accountsPageSetup() {
		accountsPage = homePage.navigateToLoginPage().navigateToAccountsPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void getAccountsPageURLTest() {
		Assert.assertTrue(accountsPage.getAccountsPageURL().contains(FrameworkConstants.ACCOUNT_PAGE_URL));
	}
	
	@Test
	public void getAccountsPageTitleTest() {
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), FrameworkConstants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void getAccountsPageHeadersTest() {
		Assert.assertEquals(accountsPage.getAccountsPageHeaders(), FrameworkConstants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test
	public void getAccountsPageHeadersCountTest() {
		Assert.assertEquals(accountsPage.getAccountsPageHeadersCount(), 4);
	}
	
	@Test
	public void doesLogoutLinkExistTest() {
		Assert.assertTrue(accountsPage.doesLogoutLinkExist());
	}
	
	@DataProvider
	public Object[][] searchProductTestdata(){
		return new Object[][] {
			{"samsung", 2},
			{"apple", 1},
			{"macbook", 3},
			{"imac", 1}
		};
	}
	
	@Test(dataProvider = "searchProductTestdata")
	public void searchTest(String searchKey, int productCount){
		searchResPage = accountsPage.doSearch(searchKey);
		Assert.assertEquals(searchResPage.getSearchResultCount(), productCount);
	}
	
}
