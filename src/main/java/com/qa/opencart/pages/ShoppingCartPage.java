package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class ShoppingCartPage {

	private WebDriver driver;
	private ElementUtils util;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}

	// private By locators
	private By shoppingCartHeader = By.xpath("//h1[contains(text(),'Shopping Cart')] ");
	private By continueShoppingBtn = By.linkText("Continue Shopping");
	private By checkoutBtn = By.linkText("Checkout");
	private By continueBtn = By.linkText("Continue");

	private By cartItems = By.xpath("(//table)[3]//tbody//tr");

	private By priceTableRows = By.xpath("(//table)[4]/tbody/tr");

	private By removeItemBtn = By.xpath("//button[@data-original-title ='Remove']");
	private By emptyCartPageMessage = By.xpath("//div[@id='content']/p");

	/**
	 * navigation steps to shopping cart page -- 1.search an item 2.search results
	 * are displayed 3.click on the add to cart icon under the product 4.click on
	 * the shopping cart icon above 5.it will display a window which views all items
	 * added to cart 6.click on view cart button 7.it should open the shopping cart
	 * page.
	 * 
	 * navigation steps to shopping cart page -- 1.search an item 2.click on the
	 * item 3.it should navigate to the item info page 4.click on the Add To cart
	 * button 5. click on the shopping cart link from success message 6.to add more
	 * items-- click on Continue shopping button 7.repeat steps 1-5
	 * 
	 */

	// page actions
	public String getShoppingCartpageURL() {
		return util.getPageUrl();
	}

	public String getShoppingCartPageTitle() {
		return util.getPageTitle();
	}

	public boolean doesContinueShoppingBtnExist() {
		return util.isElementDisplayed(continueShoppingBtn);
	}

	public boolean doesCheckoutBtnExist() {
		return util.isElementDisplayed(checkoutBtn);
	}

	public int getCartTotalItems() {
		return util.getElements(cartItems).size();
	}

	public double getProductsTotalPrice() {
		// total price = qnty * unit price
		double expectedTotal = 0.0;
		double actualTotal = 0.0;
		for (int i = 1; i <= getCartTotalItems(); i++) {
			String qntyXpath = "((//table)[3]//tbody//tr//td[4]//input)[" + i + "]";
			String unitPriceXpath = "((//table)[3]//tbody//tr//td[5])[" + i + "]";
			int qnty = Integer.parseInt(util.doGetAttributeValue(By.xpath(qntyXpath), "value").trim());
			double unitPrice = Double
					.parseDouble(util.doGetText(By.xpath(unitPriceXpath)).replace("$", "").replace(",", "").trim());
			expectedTotal = expectedTotal + qnty * unitPrice;
		}

		for (int i = 1; i <= getCartTotalItems(); i++) {
			String totalPriceXpath = "((//table)[3]//tbody//tr//td[6])[" + i + "]";
			double totalPrice = Double
					.parseDouble(util.doGetText(By.xpath(totalPriceXpath)).replace("$", "").replace(",", "").trim());
			actualTotal = actualTotal + totalPrice;
		}

		return actualTotal;
	}

	public Map<String, Double> getCartPriceDetails() {
		Map<String, Double> cartPriceDetailsMap = new HashMap<>();
		for (int i = 1; i <= util.getElements(priceTableRows).size(); i++) {
			String leftColXpath = "((//table)[4]/tbody/tr/td/strong)[" + i + "]";
			String rightColXpath = "((//table)[4]/tbody/tr/td[2])[" + i + "]";
			String leftColumnKey = util.doGetText(By.xpath(leftColXpath)).replace(":", "").trim();
			double rightColumnValue = Double
					.parseDouble(util.doGetText(By.xpath(rightColXpath)).replace("$", "").replace(",", "").trim());

			cartPriceDetailsMap.put(leftColumnKey, rightColumnValue);
		}
		return cartPriceDetailsMap;
	}

	public double getProductPriceOnCart() {
		double productPrice = Double.parseDouble(
				util.doGetText(By.xpath("(//table)[3]//tbody//tr//td[5]")).replace("$", "").replace(",", "").trim());
		return productPrice;
	}

	public boolean removeAllItemsFromCart() {
		for (WebElement remove : util.getElements(removeItemBtn)) {
			remove.click();
		}
		return util.waitForTextToBePresent(emptyCartPageMessage, 5, "Your shopping cart is empty!");
	}

	public CheckoutPage doCheckout() {
		util.doClick(checkoutBtn);
		return new CheckoutPage(driver);
	}

}
