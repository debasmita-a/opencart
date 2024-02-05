package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class SearchResultPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private page objects
	private By searchResults = By.xpath("//div[contains(@class,'product-layout')]");
	
	//public page actions
	public int getSearchResultCount() {
		return util.getElements(searchResults).size();
	}
	
	public ProductInfoPage selectProduct(String productName) {
		util.doClick(By.linkText(productName));
		//util.waitForElementToBePresent(By.linkText(productName), 5).click();
		return new ProductInfoPage(driver);
	}
}
