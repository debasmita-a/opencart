package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class ForgotPasswordPageTest extends BaseTest{

	@BeforeClass
	public void forgotPasswordPageSetup() {
		forgotPasswordPage = homePage.navigateToLoginPage().navigateToForgottenPasswordPage();
	}
	
	@Test
	public void getForgotPasswordPageTitleTest() {
		Assert.assertEquals(forgotPasswordPage.getForgotPasswordPageTitle(), FrameworkConstants.FORGOTTEN_PASSWORD_PAGE_TITLE);
	}
	
	@Test
	public void getForgotPasswordPageUrlTest() {
		Assert.assertTrue(forgotPasswordPage.getForgotPasswordPageUrl().contains(FrameworkConstants.FORGOTTEN_PASSWORD_PAGE_URL));
	}
	
	public String randomEmailGenerator() {
		return "testEmail_" + System.currentTimeMillis()+"_@gmail.com";
	}
	
	@Test
	public void enterIncorrectEmail() {
		Assert.assertTrue((forgotPasswordPage.enterIncorrectEmail(randomEmailGenerator()).contains(FrameworkConstants.FORGOT_PASSWORD_EMAIL_ERROR)));
	}
	
	@Test(enabled = true)
	public void enterEmailToResetPassword() {
		Assert.assertTrue(forgotPasswordPage.enterEmailToResetPassword("debasmita101@gmail.com").contains(FrameworkConstants.FORGOT_PASSWORD_RESET_EMAIL));
	}
}
