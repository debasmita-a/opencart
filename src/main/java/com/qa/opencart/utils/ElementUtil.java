package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtil {

	private WebDriver driver;
	private JavaScriptUtils javaScriptUtil;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		javaScriptUtil = new JavaScriptUtils(driver);
	}
	
	public WebElement getElement(By locator) {
		if(Boolean.parseBoolean(DriverFactory.highlight)) {
			javaScriptUtil.flash(driver.findElement(locator));
		}
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
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetInnerText(By locator) {
		return getElement(locator).getAttribute("innerText");
	}
	
	public String doGetInnerHTML(By locator) {
		return getElement(locator).getAttribute("innerHTML");
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	public String doGetAttributeValue(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}
	
	public void clickOnElement(By locator, String value) {
		List<WebElement> list = getElements(locator);
		System.out.println(list.size());
		for(WebElement e : list) {
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public  List<String> getLinksTextList(By locator) {
		List<WebElement> listOfEle = getElements(locator);
		List<String> listOfLinkText = new ArrayList<String>();
		System.out.println(listOfEle.size());
		for(WebElement e : listOfEle) {
			listOfLinkText.add(e.getText());
		}
		return listOfLinkText;
		
	}
	
	public boolean doesElementExist(By locator) {
		List<WebElement> listOfEle = getElements(locator);
		
		if(listOfEle.size()>0) {
			System.out.println("Element is present.");
			return true;
		}else {
			System.out.println("Element is not present");
			return false;
		}
	}
	
	/*********************Drop down Utils (Select tag)**************/
	
	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public List<String> getDropdownListOptions(By locator) {
		List<WebElement> list = new Select(getElement(locator)).getOptions();
		System.out.println(list.size());
		List<String> listOfOptions = new ArrayList<String>();
		for(WebElement e : list) {
			listOfOptions.add(e.getText());
		}
		return listOfOptions;	
	}
	
	public void selectDropdownValue(By locator, String value) {
		List<WebElement> list = new Select(getElement(locator)).getOptions();
		System.out.println(list.size());
		for(WebElement e : list) {
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public void clickDropdownValue(By locator, String value) {
		List<WebElement> list = getElements(locator);
		System.out.println(list.size());
		for(WebElement e : list) {
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	/************************** User Actions Utils * ****************************/
	
	public void twoLevelMenuHandle(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();;
	}
	
	public void threeLevelMenuHandle(By parentMenu1, By parentMenu2, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(parentMenu2)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();;
	}
	
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	/******************************* Wait Utils ****************************************/
	
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();	
	}
	
	public void acceptAlert(int timeOut){
		waitForAlert(timeOut).accept();
	}
	
	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public void doSendKeysOnAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}
	
	public String waitForTitleContains(String titleValuePartial, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(timeOut));
		if(wait.until(ExpectedConditions.titleContains(titleValuePartial))){
			return driver.getTitle();
		}
		return null;
	}
	
	public String waitForTitleIs(String fullTitleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		if(wait.until(ExpectedConditions.titleIs(fullTitleValue))) {
			return driver.getTitle();
		}
		return null;
	}
	
	public String waitForURLContains(String URLvaluePartial, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		if(wait.until(ExpectedConditions.urlContains(URLvaluePartial))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	public String waitForFullURL(String URL, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(URL))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	public void waitForFrameAndSwitchToIt(String frameName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}
	
	public void waitForFrameAndSwitchToIt(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public void waitForFrameAndSwitchToIt(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	/*
	 * An expectation for checking element is present on the DOM of a page
	 * 
	 * @param timeOut
	 * @param locator
	 * @return
	 */
	
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/*
	 * 
	 * @param locator
	 * @param timeOut
	 * @param intervalTime
	 * 
	 */
	
	public WebElement waitForElementPresence(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));		
	}
	
	public WebDriver waitForFramePresenceWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(timeOut))
				.pollingEvery(Duration.ofMillis(intervalTime))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public void retryingElement(By locator, int maxAttempt) {
		
	}
	
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
