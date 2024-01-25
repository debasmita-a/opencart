package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.FrameworkConstants;

public class HomePageTest extends BaseTest{

	@Test
	public void getHomePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(), FrameworkConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void getHomePageURLTest() {
		Assert.assertTrue(homePage.getHomePageURL().contains(FrameworkConstants.HOME_PAGE_URL));
	}

}
