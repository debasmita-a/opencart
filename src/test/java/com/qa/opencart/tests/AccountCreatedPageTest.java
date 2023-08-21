package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountCreatedPage;

public class AccountCreatedPageTest extends BaseTest {
	
	@BeforeClass
	public AccountCreatedPage accCreatedPageSetUp() {
		return registrationPage.doRegistration("debasmitaTest", "test01", "debasmitaTest01@gmail.com", "123456789", "debasmitaTest", "debasmitaTest");
	}

	@Test
	public void isAccountCreatedTest() {
		Assert.assertEquals(accCreatedPage.isAccountCreated(), "Congratulations! Your new account has been successfully created!");
	}
	
	@Test
	public void doesEditAccountLinkExistTest() {
		Assert.assertTrue(accCreatedPage.doesEditAccountLinkExist());
	}
	
	@Test
	public void getAccountCreatedPageTitleTest() {
		Assert.assertEquals(accCreatedPage.getAccountCreatedPageTitle(), "Your Account Has Been Created!");
	}
	
	@Test
	public void getAccountCreatedPageURLTest() {
		Assert.assertEquals(accCreatedPage.getAccountCreatedPageURL(), "route=account/success");
	}
	
	@AfterClass
	public void doContinueTest() {
		
	}
}
