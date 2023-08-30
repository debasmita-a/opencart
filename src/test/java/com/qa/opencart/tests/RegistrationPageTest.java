package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{

	@BeforeClass
	public RegistrationPage registrationPageSetUp() {
		return loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getTestdata() {
		Object[][] registerData = ExcelUtil.getTestData(FrameworkConstants.REGISTER_SHEET_NAME);
		return registerData;
	}
	//Generate random emails test data
	public String getEmail() {
		Random random = new Random();
		//String email = "automation"+random.nextInt(1000)+"@gmail.com";
		String email = "automation"+System.currentTimeMillis()+"@gmail.com";
		return email;
	}
	
	@Test(dataProvider = "getTestdata")
	public void doRegistrationTest(String firstName, String lastName, 
			String telephone, String password, String subscribe) {
		Assert.assertTrue(registrationPage.doRegistration(firstName, lastName, getEmail(), 
				telephone, password, subscribe));
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
