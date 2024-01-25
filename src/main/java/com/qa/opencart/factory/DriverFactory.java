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

import com.qa.opencart.exceptions.FrameworkExceptions;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;

public class DriverFactory {

	private WebDriver driver;
	private Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		prop = initProp();
		
		switch (prop.getProperty("browser").toLowerCase().trim()) {
		case "chrome":
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			break;
		case "firefox":
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			break;
		case "edge":
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
			break;
		default:
			System.out.println("Provide a correct browser name.");
			new FrameworkExceptions("IncorrectBrowserNameException");
			break;
		}
		
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();

	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProp() {
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
}
