package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetUp() {
		loginPage.doLogin("debasmita5152@gmail.com", "TestOpen@23!");
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
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), "My Account");
	}
	
	@Test
	public void getAccountsPageURLTest() {
		Assert.assertTrue(accountsPage.getAccountsPageURL().contains("route=account/account"));
	}
	
	@Test
	public void listAccountsHeadersTest() {
		List<String> accHeaders = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	    Assert.assertEquals(accountsPage.listAccountsHeaders(), accHeaders);
	    Assert.assertEquals(accountsPage.listAccountsHeaders().size(), 4);
	}
	
}
