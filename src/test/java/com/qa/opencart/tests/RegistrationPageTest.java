package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegistrationPageTest extends BaseTest{

	@AfterClass
	public void doRegistrationTest() {
		accCreatedPage = registrationPage.doRegistration("debasmitaTest", "test01", "debasmitaTest01@gmail.com", "123456789", "debasmitaTest", "debasmitaTest");
		Assert.assertEquals(accCreatedPage.isAccountCreated(),"Congratulations! Your new account has been successfully created!");
	}
	
	@Test
	public void isPrivacyPolicyCheckedTest() {
		Assert.assertTrue(registrationPage.isPrivacyPolicyChecked());
	}
	
	@Test
	public void isNewsletterSelectedNoTest() {
		Assert.assertEquals(registrationPage.isNewsletterSelectedNo(), " No");
	}
	
	@Test
	public void getRegistrationPageTitleTest() {
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");
	}
	
	@Test
	public void getRegistrationPageURLTest() {
		Assert.assertEquals(registrationPage.getRegistrationPageURL(), "route=account/register");
	}
	
	
}
