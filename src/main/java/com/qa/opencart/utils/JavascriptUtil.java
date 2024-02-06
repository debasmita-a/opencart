package com.qa.opencart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptUtil {

	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavascriptUtil(WebDriver driver) {
		this.driver = driver;
	    js = (JavascriptExecutor)this.driver;
	}
	
	public String getTitleByJS() {
		return js.executeScript("return document.title;").toString();
	}
	
	public void goBackWithJS() {
		js.executeScript("history.go(-1);");
	}
	
	public void goFrowardWithJS() {
		js.executeScript("history.go(1);");
	}
	
	public void pageRefreshWithJS() {
		js.executeScript("history.go(0);");
	}
	
	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
     
}
