package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class ShoppingCartPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private By locators
	private By shoppingCartHeader = By.xpath("//h1[contains(text(),'Shopping Cart')] ");
	private By continueShoppingBtn = By.linkText("Continue Shopping");
	private By checkoutBtn = By.linkText("Checkout");
	
	/**
	 * navigation steps to shopping cart page --
	 * 1.search an item
	 * 2.search results are displayed
	 * 3.click on the add to cart icon under the product
	 * 4.click on the shopping cart icon above
	 * 5.it will display a window which views all items added to cart
	 * 6.click on view cart button
	 * 7.it should open the shopping cart page.
	 * 
	 * navigation steps to shopping cart page --
	 * 1.search an item
	 * 2.click on the item
	 * 3.it should navigate to the item info page
	 * 4.click on the Add To cart button
	 * 5. click on the shopping cart link from success message
	 * 6.to add more items-- click on Continue shopping button
	 * 7.repeat steps 1-5
	 * 
	 */
}
