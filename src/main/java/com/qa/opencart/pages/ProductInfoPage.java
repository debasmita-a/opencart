package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By productTitle = By.xpath("//div[@id ='content']//h1");
	private By productImg = By.xpath("//ul[@class ='thumbnails']//img");
	private By productMetadata = By.xpath("(//div[@id='content']//div[@class = 'col-sm-4']//ul)[position()=1]//li");
	private By productPriceData = By.xpath("(//div[@id='content']//div[@class = 'col-sm-4']//ul)[position()=2]//li");
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	public String getProductTitle() {
		return util.doGetText(productTitle);
	}
	
	public int getProductImagesCount() {
		System.out.println("Product image count : "+ util.waitForElementsVisible(productImg, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).size());
		return util.waitForElementsVisible(productImg, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).size();
	}
	
	public void getProductInfoPageTitle() {
		
	}
	
	public void doesProductDescriptionExist() {
		
	}
	
	public void getProductInfo() {
		Map<String, String> productInfoMap = new HashMap<String, String>();
		List<WebElement> metaList = util.getElements(productMetadata);
		for(WebElement e : metaList) {
			String metaInfo = e.getText();
			String meta[] = metaInfo.split(":");
			String key = meta[0].trim();
			String value = meta[1].trim();
			productInfoMap.put(key, value);
		}
		
		List<WebElement> priceList = util.getElements(productPriceData);
		String price = priceList.get(0).getText();
		String exTax = priceList.get(1).getText();
		String exTaxVal = exTax.split(":")[1].trim();
	}
	
	
}
