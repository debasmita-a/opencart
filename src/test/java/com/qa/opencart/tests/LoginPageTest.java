package com.qa.opencart.tests;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC 100 : desing log in for open cart app")
@Story("User Login : 101 : design login page features for open cart")
public class LoginPageTest extends BaseTest{
	
	@Severity(SeverityLevel.MINOR)
	@Description("..Getting the title of the page..Author : Debasmita")
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, FrameworkConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("..Getting the url of the page..Author : Debasmita")
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(FrameworkConstants.LOGIN_PAGE_URL));
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("..Checking forgot password link on page..Author : Debasmita")
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.doesForgotPwdLinkExist());
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("..Checking logo on page..Author : Debasmita")
	@Test
	public void doesLogoExistTest() {
		Assert.assertTrue(loginPage.doesLogoExist());
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("..Checking Navigation bar on page..Author : Debasmita")
	@Test
	public void doesNavBarExistTest() {
		Assert.assertTrue(loginPage.doesNavBarExist());
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("..Checking Navigation menu on page..Author : Debasmita")
	@Test
	public void allNavBarMenuTest() {
		System.out.println("Actual Navigation Menu list: "+loginPage.allNavBarMenu());
		System.out.println("Expected Navigation Menu list: "+FrameworkConstants.LOGIN_NAV_BAR_MENU);
		Assert.assertEquals(loginPage.allNavBarMenu(),FrameworkConstants.LOGIN_NAV_BAR_MENU );
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("..Checking Breadcrumb on page..Author : Debasmita")
	@Test
	public void doesBreadcrumbExistTest() {
		Assert.assertTrue(loginPage.doesBreadcrumbExist());
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("..Checking right column menu on page..Author : Debasmita")
	@Test
	public void allColumnRightMenuTest() {
		System.out.println("Actual Right Column Menu List: "+loginPage.allColumnRightMenu());
		System.out.println("Expected Right Column Menu List: "+FrameworkConstants.ALL_RIGHT_COLUMN_MENU);
		Assert.assertEquals(loginPage.allColumnRightMenu(), FrameworkConstants.ALL_RIGHT_COLUMN_MENU);
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("..Checking footer headers menu on page..Author : Debasmita")
	@Test
	public void allFooterHeadersTest() {
		System.out.println("Actual footer header list: "+loginPage.allFooterHeaders());
		System.out.println("Expected footer header list: "+FrameworkConstants.ALL_FOOTER_HEADERS);
		Assert.assertEquals(loginPage.allFooterHeaders(), FrameworkConstants.ALL_FOOTER_HEADERS);
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("..Checking all footer menu on page..Author : Debasmita")
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
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("..Checking is user is able to log in to the app..Author : Debasmita")
	@AfterClass
	public void doLoginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accountsPage.doesLogoutLinkExist());
		
	}
	
	
}

//Page Object Model says that, if you are creating a page class, it shouldn't have any assertion
//Page classes will use Selenium API to manipulate the elements on the application
//Test classes will manipulate the returned values of a page class and use TestNG api for assertion


