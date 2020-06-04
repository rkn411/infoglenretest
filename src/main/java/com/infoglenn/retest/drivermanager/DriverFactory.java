package com.infoglenn.retest.drivermanager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.infoglenn.restest.support.io.PropertiesFile;

public class DriverFactory {

	private static WebDriver driver;
	public static String baseDir = System.getProperty("user.dir");
	public static PropertiesFile propFile;
	
	@BeforeTest
	public void beforeTest() throws IOException {
		String path = baseDir + "/src/main/java/com/infoglenn/";
		propFile = new PropertiesFile(path + "/restest/support/io/config.properties");
		
	}
	
	@BeforeClass
	public void launchBrowser() {
		//voidLaunch(propFile.getProperty("URL"));
	}
	/**
	 * method to launch browser and navigate URL based on browser name given in xml
	 */
	public static void voidLaunch(String testUrl ) {
		System.setProperty("webdriver.chrome.driver", "/Users/treddi/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.get(testUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	

	/**
	 * This function closes all browser drivers.
	 */
	@AfterClass
	public  void closeDriver() {
		if (getDriver() != null) {
			try {
				getDriver().quit();
			} catch (NoSuchSessionException nsse) {
				nsse.printStackTrace();
			}
		}
	}

	/**
	 * method to get the driver instance
	 *
	 */
	public static WebDriver getDriver() {
		return driver;
	}
}
