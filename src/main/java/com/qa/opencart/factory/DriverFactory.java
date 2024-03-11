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

import com.qa.opencart.exceptions.FrameworkExceptions;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionsManager optionManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * this method will initialize the WebDriver
	 * 
	 * @param prop
	 * @return
	 */
	public WebDriver initDriver(Properties prop) {
		
		prop = initProp();
		optionManager = new OptionsManager(prop);

		String browserName = prop.getProperty("browser").toLowerCase().trim();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			}else {
				tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
			}
		}else if(browserName.equalsIgnoreCase("firefox")) {
			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			}else {
				tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
			}
		}else if(browserName.equalsIgnoreCase("edge")){
			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("edge");
			}else {
				tlDriver.set(new EdgeDriver(optionManager.getEdgeOptions()));
			}
		}else {
			System.out.println("Provide a correct browser name.");
		}	

		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		return getDriver();

	}

	/**
	 * this method is used to initialize the driver with RemoteWebDriver
	 * 
	 * @param browser
	 */
	private void init_remoteDriver(String browser) {
		System.out.println("Running tests on selenium grid server:::" + browser);
		try {
			switch (browser) {
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
				System.out.println("Please pass correct browser for remote execution.." + browser);
				new FrameworkExceptions("NOREMOTEBROWSEREXCEPTION");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method will return the ThreadLocal<WebDriver> tlDriver instance
	 * @return tlDriver
	 */
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
