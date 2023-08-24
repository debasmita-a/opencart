package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest{

	@BeforeClass
	public RegistrationPage registrationPageSetUp() {
		return loginPage.clickRegisterLink();
	}
	
	@AfterClass
	public void doRegistrationTest() {
		accCreatedPage = registrationPage.doRegistration(prop.getProperty("firstname").trim()
				,prop.getProperty("lastname").trim()
				,prop.getProperty("email")
				,prop.getProperty("telephone")
				,prop.getProperty("password")
				,prop.getProperty("password"));
		
		Assert.assertEquals(accCreatedPage.isAccountCreated(),FrameworkConstants.ACCOUNT_CREATED_SUCCESS_MSG);
	}
	
	@Test
	public void isPrivacyPolicyCheckedTest() {
		Assert.assertTrue(registrationPage.isPrivacyPolicyChecked());
	}
	
	@Test
	public void isNewsletterSelectedNoTest() {
		Assert.assertTrue(registrationPage.isNewsletterSelectedNo());
	}
	
	@Test
	public void getRegistrationPageTitleTest() {
		Assert.assertTrue(registrationPage.getRegistrationPageTitle().contains(FrameworkConstants.REGISTRATION_PAGE_TITLE_VALUE));
	}
	
	@Test
	public void getRegistrationPageURLTest() {
		Assert.assertTrue(registrationPage.getRegistrationPageURL().contains(FrameworkConstants.REGISTRATION_PAGE_URL));
	}
	
	@Test
	public void msgUserAccountAlreadyExistsTest() {
		Assert.assertEquals(registrationPage.msgUserAccountAlreadyExists(),FrameworkConstants.ACCOUNT_ALREADY_EXISTS_MSG);
	}
	
	
}
