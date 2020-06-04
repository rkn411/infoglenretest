package com.infoglenn.retest.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.infoglenn.retest.drivermanager.DriverFactory;


public abstract class BasePage {
	public static WebDriver driver;

	public BasePage() {
		driver=DriverFactory.getDriver();
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	
}