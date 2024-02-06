package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class CheckoutPage {

	private WebDriver driver;
	private ElementUtils util;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	//private By locators
	private By newCustomerHeader = By.xpath("(//h2)[1]");
	private By returningCustomerHeader = By.xpath("(//h2)[2]");
	private By checkoutOptions = By.xpath("//input[@type='radio']");
	//billing details:
	private By firstName = By.id("input-payment-firstname");
	private By lastName = By.id("input-payment-lastname");
	private By address1 = By.id("input-payment-address-1");
	private By city = By.id("input-payment-city");
	private By postalCode = By.id("input-payment-postcode");
	private By country = By.id("input-payment-country");
	private By region = By.id("input-payment-zone");
	private By continueBtnBillingDetails = By.id("button-payment-address");
	private By existingPaymentAddress = By.id("payment-existing");
	
	private By mandatoryFieldsErrorMessages = By.xpath("//div[@class='text-danger']");
	//delivery details:
	private By defaultDeliveryAddressRadioBtn = By.xpath("//input[@name='shipping_address']");
	private By existingShippingAddress = By.id("shipping-existing");
	private By continueBtnDeliveryDetails = By.id("button-shipping-address");
	//delivery method:
	private By continueBtnDeliveryMethod = By.id("button-shipping-method");
	private By flatRateText = By.xpath("//label/input[@name='shipping_method']");
	//payment method:
	private By cashOnDeliveryText = By.xpath("//label/input[@name='payment_method']");
	private By continueBtnPaymentMethod = By.id("button-payment-method");
	private By termsAndConditions = By.xpath("//input[@type='checkbox']");
	//confirm order:
	private By continueBtnConfirmOrder = By.id("button-confirm");
	
	//page actions
	public String getCheckoutPageURL() {
		return util.getPageUrl();
	}
	
	public String getCheckoutPageTitle() {
		return util.getPageTitle();
	}
	
	//********************* in case user is logged out ******************************
	public List<WebElement> getCheckoutOptions() {
		return util.getElements(checkoutOptions);
	}
	
	public String defaultCheckoutOptionSelected() {
		String checkoutOption = null;
		for(WebElement e : getCheckoutOptions()) {
			if(e.getAttribute("checked")=="checked") {
				checkoutOption = e.getText();
				break;
			}
		}	
		System.out.println(checkoutOption);
		return checkoutOption;
	}
	
	public boolean isNewCustomerHeaderAvailable() {
		return util.isElementDisplayed(newCustomerHeader);
	}
	
	public boolean isReturningCustomerHeaderAvailable() {
		return util.isElementDisplayed(returningCustomerHeader);
	}
//*************************************************************************************
	public List<String> checkMandatoryFields() {
		util.doClick(continueBtnBillingDetails);
		List<String> errorMsg = new ArrayList<>();
		for(WebElement e : util.getElements(mandatoryFieldsErrorMessages)) {
			errorMsg.add(e.getText());
		}
		return errorMsg;
	}
	//when checking out for first time users
	
	public void enterBillingDetails(String fn, String ln, String address, String cityName, String postal, String countryName, String regionName) {
		util.doSendKeys(firstName, fn);
		util.doSendKeys(lastName, ln);
		util.doSendKeys(address1, address);
		util.doSendKeys(city, cityName);
		util.doSendKeys(postalCode, postal);
		util.selectDropdownByVisibleText(country, countryName);
		util.selectDropdownByVisibleText(region, regionName);
		util.doClick(continueBtnBillingDetails);		
	}
	
	public boolean checkSelectedShippingAddress() {
		if(util.doGetAttributeValue(defaultDeliveryAddressRadioBtn, "checked")=="checked") {
			return true;
		}
		return false;
	}
	
	public String checkShippingAddressValue() {
		return util.doGetText(existingShippingAddress);
	}
	
	public void confirmDeliveryAddress() {
		util.doClick(continueBtnDeliveryDetails);
	}
	
	public String confirmDeliveryMethod() {
		String flatRateTextValue = util.doGetText(flatRateText);
		util.doClick(continueBtnDeliveryMethod);
		return flatRateTextValue;
	}
	
	public String confirmPaymentMethod() {
		String cashOnDeliveryTextValue = util.doGetText(cashOnDeliveryText);
		util.actionClick(termsAndConditions);
		util.doClick(continueBtnPaymentMethod);
		return cashOnDeliveryTextValue;
	}
	
	//for regular user :
	public OrderConfirmationPage confirmCheckoutDetails() {
		util.doClick(continueBtnBillingDetails);
		util.doClick(continueBtnDeliveryDetails);	
		util.doClick(continueBtnDeliveryMethod);
		util.actionClick(termsAndConditions);
		util.doClick(continueBtnPaymentMethod);
		util.doClick(continueBtnConfirmOrder);
		return new OrderConfirmationPage(driver);
	}
	
}
