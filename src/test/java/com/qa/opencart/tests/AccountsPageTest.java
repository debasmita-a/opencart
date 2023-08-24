package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.pages.AccountsPage;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public AccountsPage accPageSetUp() {
		return loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void doesLogoutLinkExistTest() {
		Assert.assertTrue(accountsPage.doesLogoutLinkExist());
	}
	
	@Test
	public void doesSearchBoxExistTest() {
		Assert.assertTrue(accountsPage.doesSearchBoxExist());
	}
	
	@Test
	public void getAccountsPageTitleTest() {
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), FrameworkConstants.ACCOUNT_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void getAccountsPageURLTest() {
		Assert.assertTrue(accountsPage.getAccountsPageURL().contains(FrameworkConstants.ACCOUNT_PAGE_URL));
	}
	
	@Test
	public void listAccountsHeadersTest() {
		System.out.println("Actual account list headers: "+accountsPage.listAccountsHeaders());
		System.out.println("Expected account list headers: "+FrameworkConstants.ACCOUNT_PAGE_HEADERS);
	    Assert.assertEquals(accountsPage.listAccountsHeaders(), FrameworkConstants.ACCOUNT_PAGE_HEADERS);
	    Assert.assertEquals(accountsPage.listAccountsHeaders().size(), FrameworkConstants.ACCOUNT_PAGE_HEADER_COUNT);
	}
	
}
