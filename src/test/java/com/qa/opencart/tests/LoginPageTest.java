package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, FrameworkConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(FrameworkConstants.LOGIN_PAGE_URL));
	}
	
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.doesForgotPwdLinkExist());
	}
	
	@Test
	public void doesLogoExistTest() {
		Assert.assertTrue(loginPage.doesLogoExist());
	}
	
	@Test
	public void doesNavBarExistTest() {
		Assert.assertTrue(loginPage.doesNavBarExist());
	}
	
	@Test
	public void allNavBarMenuTest() {
		System.out.println("Actual Navigation Menu list: "+loginPage.allNavBarMenu());
		System.out.println("Expected Navigation Menu list: "+FrameworkConstants.LOGIN_NAV_BAR_MENU);
		Assert.assertEquals(loginPage.allNavBarMenu(),FrameworkConstants.LOGIN_NAV_BAR_MENU );
	}
	
	@Test
	public void doesBreadcrumbExistTest() {
		Assert.assertTrue(loginPage.doesBreadcrumbExist());
	}
	
	@Test
	public void allColumnRightMenuTest() {
		System.out.println("Actual Right Column Menu List: "+loginPage.allColumnRightMenu());
		System.out.println("Expected Right Column Menu List: "+FrameworkConstants.ALL_RIGHT_COLUMN_MENU);
		Assert.assertEquals(loginPage.allColumnRightMenu(), FrameworkConstants.ALL_RIGHT_COLUMN_MENU);
	}
	
	@Test
	public void allFooterHeadersTest() {
		System.out.println("Actual footer header list: "+loginPage.allFooterHeaders());
		System.out.println("Expected footer header list: "+FrameworkConstants.ALL_FOOTER_HEADERS);
		Assert.assertEquals(loginPage.allFooterHeaders(), FrameworkConstants.ALL_FOOTER_HEADERS);
	}
	
	@Test
	public void allFooterMenuTest() {
		System.out.println("Actual footer menu list: "+loginPage.allFooterMenu());
		System.out.println("Expected footer menu list: "+FrameworkConstants.ALL_FOOTER_MENU);
		Assert.assertEquals(loginPage.allFooterMenu(), FrameworkConstants.ALL_FOOTER_MENU);
	}
	
	@Test
	public void isFooterTextTest() {
		Assert.assertEquals(loginPage.isFooterText(), FrameworkConstants.FOOTER_TEXT);
	}
	
	@AfterClass
	public void doLoginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accountsPage.doesLogoutLinkExist());
		
	}
	
	
}

//Page Object Model says that, if you are creating a page class, it shouldn't have any assertion
//Page classes will use Selenium API to manipulate the elements on the application
//Test classes will manipulate the returned values of a page class and use TestNG api for assertion


