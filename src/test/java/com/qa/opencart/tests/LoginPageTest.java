package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains("route=account/login"));
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
		List<String> expectedList = Arrays.asList("Desktops","Laptops & Notebooks","Components","Tablets","Software","Phones & PDAs","Cameras","MP3 Players");
		Assert.assertEquals(loginPage.allNavBarMenu(),expectedList );
	}
	
	@Test
	public void isFooterTextTest() {
		String footerText = "Powered By OpenCart\nnaveenopencart © 2023";
		Assert.assertEquals(loginPage.isFooterText(), footerText);
	}
	
	@Test
	public void doLoginTest() {
		accountsPage = loginPage.doLogin("debasmita5152@gmail.com", "TestOpen@23!");
		Assert.assertTrue(accountsPage.doesLogoutLinkExist());
		
	}
	
	
}

//Page Object Model says that, if you are creating a page class, it shouldn't have any assertion
//Page classes will use Selenium API to manipulate the elements on the application
//Test classes will manipulate the returned values of a page class and use TestNG api for assertion


