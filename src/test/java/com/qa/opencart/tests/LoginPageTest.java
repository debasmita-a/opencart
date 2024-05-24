package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class LoginPageTest extends BaseTest{
	
	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.navigateToLoginPage();
	}

	@Test
	public void getLoginPageTitleTest() {
		Assert.assertEquals(loginPage.getLoginPageTitle(), FrameworkConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void getLoginPageUrlTest() {
		Assert.assertTrue(loginPage.getLoginPageUrl().contains(FrameworkConstants.LOGIN_PAGE_URL));
	}
	
	@Test
	public void isForgotPwdLinkAvailableTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkAvailable());
	}
	
	@DataProvider
	public Object[][] negativeLoginTestdata(){
		return new Object[][] {
			{"test_user01", "test_pass01"},
			{"@testUser", "123456"}
		};
	}
	
	@Test(dataProvider = "negativeLoginTestdata")
	public void negativeLoginTest(String username, String password) {
		Assert.assertTrue(loginPage.negativeLogin(username, password).contains(FrameworkConstants.INCORRECT_LOGIN_WARNING_MSG_MULTIPLE_TRY));
	}
	
	@Test
	public void doLoginTest() {
		Assert.assertEquals(loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password")), FrameworkConstants.ACCOUNT_PAGE_TITLE);
		homePage.navigateToLoginPage();
	}
}
