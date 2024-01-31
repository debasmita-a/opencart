package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private By objects
	private By productImages = By.xpath("//a[@class='thumbnail']");
	private By productHeader = By.xpath("//h1");
	private By addToCartBtn = By.id("button-cart");
	private By qnty = By.id("input-quantity");
	
}
