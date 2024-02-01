package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtils util;

	private Map<String, Object> productMap;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private By objects
	private By productImages = By.xpath("//a[@class='thumbnail']");
	private By productHeader = By.xpath("//h1");
	private By addToCartBtn = By.id("button-cart");
	private By qnty = By.id("input-quantity");
	private By productMetadata = By.xpath("(//h1/following-sibling::ul[@class='list-unstyled'])[1]/li");
	private By priceMetadata = By.xpath("(//h1/following-sibling::ul[@class='list-unstyled'])[2]/li");
	private By successMsg = By.xpath("//div[contains(@class,'alert-dismissible')]");
	
	private By cartTotalBtn = By.id("cart-total");
	private By viewCartBtn = By.xpath("//a//strong[contains(text(),'View Cart')]");
	private By checkoutBtn = By.xpath("//a//strong[contains(text(),'Checkout')]");
	//page actions :
	
	public String getProductInfoPageURL() {
		return util.getPageUrl();
	}
	
	public String getProductInfoPageTitle() {
		return util.getPageTitle();
	}
	
	public int getProductImageCount() {
		return util.getElements(productImages).size();
	}
	
	public void getProductMetadataMap() {		
		List<WebElement> eleList = util.getElements(productMetadata);
		for(WebElement e : eleList) {
			String element = e.getAttribute("innerText");
			String key = element.split(":")[0].trim();
			String value = element.split(":")[1].trim();
			productMap.put(key, value);
		}	
	}
	
	public void getPriceMetadataMap() {
		List<WebElement> eleList = util.getElements(priceMetadata);
		double actualPrice = Double.parseDouble(eleList.get(0).getText().replace("$", "").trim());
		productMap.put("Product price", actualPrice);
		String taxKey = eleList.get(1).getText().split(":")[0].trim();
		double taxValue = Double.parseDouble((eleList.get(1).getText().split(":")[1].replace("$", "").trim()));
		productMap.put(taxKey, taxValue);
	}
	
	public String addProductToCart() {
		util.doClick(addToCartBtn);
		return util.waitForElementToBeVisible(successMsg, 5).getAttribute("textContent");
	}
	
	public String getProductHeaderValue() {
		return util.doGetText(productHeader);
	}
	
	public Map<String, Object> getProductData() {
		productMap = new HashMap<String, Object>();
		productMap.put("Product name", getProductHeaderValue());
		productMap.put("Product images", getProductImageCount());
		//productMap.put("Product Images:", String.valueOf(getProductImageCount()));
		productMap.put("Quantity", util.doGetAttributeValue(qnty, "value"));
		getProductMetadataMap();
		getPriceMetadataMap();
		
		return productMap;
	}
	
	public ShoppingCartPage navigateToShoppingCartPage() {
		addProductToCart();
		util.doClick(cartTotalBtn);
		util.doClick(viewCartBtn);
		return new ShoppingCartPage(driver);
	}
}
