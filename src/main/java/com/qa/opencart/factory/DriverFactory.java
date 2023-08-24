package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionManager;
	
	public static String highlight;
	
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
			driver = new ChromeDriver(optionManager.getChromeOptions());
		}else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(optionManager.getEdgeOptions());		
		}else if (prop.getProperty("browser").equals("safari")) {
			driver = new SafariDriver();
		}else if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver(optionManager.getFirefoxOptions());
		}else {
			System.out.println("Please provide correct browser name."+ prop.getProperty("browser"));
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	/**
	 * This method is reading the properties from .properties file
	 * @return
	 */
	public Properties initProp(){
		prop = new Properties();
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
}
