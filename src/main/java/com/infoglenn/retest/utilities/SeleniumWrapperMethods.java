package com.infoglenn.retest.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infoglenn.retest.drivermanager.DriverFactory;

public class SeleniumWrapperMethods extends DriverFactory{
	/**
	 * method to click webelement
	 * @param element
	 * @param elementName
	 */
	public static void clickOnElement(WebElement element,String elementName) {
		element.click();
		
	}
	/**
	 * wait for element
	 */
	public static void waitForElement(String element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		
	}
	


}
