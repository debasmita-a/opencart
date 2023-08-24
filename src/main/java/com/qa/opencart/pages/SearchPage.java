package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By searchProductResults = By.cssSelector("div#content div.product-layout");
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	public int getSearchProductCount() {
		System.out.println("Product count is: "+ util.waitForElementsVisible(searchProductResults, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).size());
		return util.waitForElementsVisible(searchProductResults, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).size();
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By productLocator = By.linkText(productName);
		util.waitForElementVisible(productLocator, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).click();
		return new ProductInfoPage(driver);
	}
}
