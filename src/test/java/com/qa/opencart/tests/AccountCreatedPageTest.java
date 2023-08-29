package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.pages.AccountCreatedPage;

public class AccountCreatedPageTest extends BaseTest {
	
	@BeforeClass
	public void accCreatedPageSetUp() {
		registrationPage = loginPage.navigateToRegisterPage();
		
	}

	@Test
	public void isAccountCreatedTest() {
		Assert.assertEquals(accCreatedPage.isAccountCreated(), FrameworkConstants.ACCOUNT_CREATED_SUCCESS_MSG);
	}
	
	@Test
	public void doesEditAccountLinkExistTest() {
		Assert.assertTrue(accCreatedPage.doesEditAccountLinkExist());
	}
	
	@Test
	public void getAccountCreatedPageTitleTest() {
		Assert.assertEquals(accCreatedPage.getAccountCreatedPageTitle(), FrameworkConstants.ACCOUNT_CREATED_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void getAccountCreatedPageURLTest() {
		Assert.assertTrue(accCreatedPage.getAccountCreatedPageURL().contains(FrameworkConstants.ACCOUNT_CREATED_URL));
	}
	
	@AfterClass
	public void doContinueTest() {
		Assert.assertEquals(accCreatedPage.doContinue().getAccountsPageTitle(), FrameworkConstants.ACCOUNT_PAGE_TITLE_VALUE);
	}
}
