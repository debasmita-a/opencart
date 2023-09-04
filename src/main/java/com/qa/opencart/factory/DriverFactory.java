package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionManager;
	
	public static String highlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is initializing the driver on the basis of given browser name
	 * @param browserName
	 * @return the driver
	 */
	public WebDriver initDriver(Properties prop) {
		optionManager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();
		System.out.println("Browser name is : "+ prop.getProperty("browser").toLowerCase().trim());
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			//driver = new ChromeDriver(optionManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
		}else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			//driver = new EdgeDriver(optionManager.getEdgeOptions());	
			tlDriver.set(new EdgeDriver(optionManager.getEdgeOptions()));
		}else if (prop.getProperty("browser").equals("safari")) {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}else if (prop.getProperty("browser").equals("firefox")) {
			//driver = new FirefoxDriver(optionManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
		}else {
			System.out.println("Please provide correct browser name."+ prop.getProperty("browser"));
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	
	/*
	 * 
	 * get the local copy of the driver
	 */
	
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This method is reading the properties from .properties file
	 * @return
	 */
	public Properties initProp(){
		//mvn clean install -Denv=stage"
		//mvn clean install
		
		prop = new Properties();
		
		String envName = System.getProperty("env");
		System.out.println("Running test cases on Env: "+envName);
		
		if(envName==null) {
			System.out.println("No env passed. Running tests on QA env..");
			
		}
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile,destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
