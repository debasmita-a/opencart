package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest{

	@BeforeClass
	public RegistrationPage registrationPageSetUp() {
		return loginPage.clickRegisterLink();
	}
	
	@AfterClass
	public void doRegistrationTest() {
		accCreatedPage = registrationPage.doRegistration("debasmitaTest01", "test01", "debasmitaTest014@gmail.com", "123456789", "debasmitaTest", "debasmitaTest");
		Assert.assertEquals(accCreatedPage.isAccountCreated(),"Congratulations! Your new account has been successfully created!");
	}
	
	@Test
	public void isPrivacyPolicyCheckedTest() {
		Assert.assertTrue(registrationPage.isPrivacyPolicyChecked());
	}
	
	@Test
	public void isNewsletterSelectedNoTest() {
		Assert.assertEquals(registrationPage.isNewsletterSelectedNo(), "0");
	}
	
	@Test
	public void getRegistrationPageTitleTest() {
		Assert.assertTrue(registrationPage.getRegistrationPageTitle().contains("Register Account"));
	}
	
	@Test
	public void getRegistrationPageURLTest() {
		Assert.assertTrue(registrationPage.getRegistrationPageURL().contains("route=account/register"));
	}
	
	
}
