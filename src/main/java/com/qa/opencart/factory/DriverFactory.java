package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.exceptions.FrameworkException;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionManager;

	public static String highlight;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is initializing the driver on the basis of given browser name
	 * 
	 * @param browserName
	 * @return the driver
	 */
	public WebDriver initDriver(Properties prop) {

		optionManager = new OptionsManager(prop);
		
		highlight = prop.getProperty("highlight").trim();
		System.out.println("Browser name is : " + prop.getProperty("browser").toLowerCase().trim());

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run on remote/grid:
				init_remoteDriver("chrome");
			} else {
				// local execution
				// driver = new ChromeDriver(optionManager.getChromeOptions());
				tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
			}
		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run on remote/grid:
				init_remoteDriver("edge");
			} else {
				// driver = new EdgeDriver(optionManager.getEdgeOptions());
				tlDriver.set(new EdgeDriver(optionManager.getEdgeOptions()));
			}
		}
		
		else if (prop.getProperty("browser").equals("safari")) {
			// driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		
	    else if (prop.getProperty("browser").equals("firefox")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run on remote/grid:
				init_remoteDriver("firefox");
			} else {
				// driver = new FirefoxDriver(optionManager.getFirefoxOptions());
				tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
			}
	    }
		else {
			System.out.println("Please provide correct browser name." + prop.getProperty("browser"));
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	private void init_remoteDriver(String browser) {
		System.out.println("RUnning tests on grid server::::"+browser);
		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionManager.getChromeOptions()));
				break;
			case "firefox":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionManager.getFirefoxOptions()));
				break;
			case "edge":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionManager.getEdgeOptions()));
				break;
			default:
				System.out.println("Please pass right browser name.");
				break;
			// throw new FrameworkException("NOREMOTEBROWSEREXCEPTION");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
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
	 * 
	 * @return
	 */
	public Properties initProp() {

		// mvn clean install -Denv="qa"
		// mvn clean install
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		System.out.println("Running test cases on Env: " + envName);

		try {
			if (envName == null) {
				System.out.println("no env is passed....Running tests on QA env...");
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					System.out.println("....Wrong env is passed....No need to run the test cases....");
					// throw new FrameworkException("WRONG ENV IS PASSED...");
					// break;
				}

			}
		} catch (FileNotFoundException e) {

		}

		try {
			prop.load(ip);
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
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
