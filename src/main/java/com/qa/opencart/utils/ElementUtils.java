package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {

	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	// *************** element utilities *********************//

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetTextWithInnerText(By locator) {
		return getElement(locator).getAttribute("innerText");
	}
	
	public String doGetTextWithContent(By locator) {
		return getElement(locator).getAttribute("content");
	}
	
	public String doGetAttributeValue(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}
	
	public String doGetTagNameValue(By locator) {
		return getElement(locator).getTagName();
	}
	
	//*********************** browser utilities *******************//
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	// *****************Action class utilities **********************//
	public void actionMoveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).build().perform();
	}

	public void actionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}

	public void actionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).build().perform();
	}

	// ******************* JS alert utilities *****************//

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();;
	}
	
	public void sendKeysToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);;
	}
	
	//**************************Select class utilities****************//
	
	
	//**************** wait utilities *********************************//
}
