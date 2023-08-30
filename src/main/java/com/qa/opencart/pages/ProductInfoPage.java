package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.FrameworkConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private Map<String, String> productInfoMap;
	
	private By productTitle = By.xpath("//div[@id ='content']//h1");
	private By productImg = By.xpath("//ul[@class ='thumbnails']//img");
	private By productDescription = By.className("tab-content");
	private By productMetadata = By.xpath("(//div[@id='content']//div[@class = 'col-sm-4']//ul)[position()=1]//li");
	private By productPriceData = By.xpath("(//div[@id='content']//div[@class = 'col-sm-4']//ul)[position()=2]//li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.linkText("Add To Cart");
	private By cartSuccessMsg = By.xpath("//div[@class = 'alert alert-success alert-dismissible']");
	
	
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
	
	public String getProductInfoPageTitle() {
		return util.waitForTitleContains(getProductTitle(), FrameworkConstants.DEFAULT_SHORT_TIMEOUT);
	}
	
	public int doesProductDescriptionExist() {
		return util.doGetText(productDescription).length();
	}
	//product info data:
	public Map<String, String> getProductInfo() {
		//productInfoMap = new HashMap<String, String>(); 
		productInfoMap = new LinkedHashMap<String, String>(); //ordered - hashmap
		//productInfoMap = new TreeMap<String, String>(); //alphabetical order - hashmap
		productInfoMap.put("productname", getProductTitle());
		getProductMetadata();
		getProductPricedata();
		System.out.println("Product info data : "+ productInfoMap);
		return productInfoMap;
	}
	//product meta data:
	private void getProductMetadata() {
		List<WebElement> metaList = util.getElements(productMetadata);
		for(WebElement e : metaList) {
			String metaInfo = e.getText();
			String meta[] = metaInfo.split(":");
			String key = meta[0].trim();
			String value = meta[1].trim();
			productInfoMap.put(key, value);
		}
	}
	//product price data:
	private void getProductPricedata() {	
		List<WebElement> priceList = util.getElements(productPriceData);
		String price = priceList.get(0).getText();
		String exTax = priceList.get(1).getText();
		String exTaxVal = exTax.split(":")[1].trim();
		productInfoMap.put("productprice", price);
		productInfoMap.put("exTax", exTaxVal);
	}
	
	public void enterQuantity(int qty) {
		System.out.println("Product quantity : "+ qty);
		util.doSendKeys(quantity, String.valueOf(qty));
	}
	
	public String addProductToCart() {
		util.doClick(addToCartBtn);
		String successMessage = util.waitForElementVisible(cartSuccessMsg, FrameworkConstants.DEFAULT_MEDIUM_TIMEOUT).getText();
		System.out.println(successMessage);
		return successMessage;
	}
	
	
}
