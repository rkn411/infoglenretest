package com.infoglenn.retest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.infoglenn.retest.base.BasePage;
import static com.infoglenn.retest.utilities.SeleniumWrapperMethods.*;

public class ToggleEffectPage extends BasePage {

	@FindBy(id = "button")
	private WebElement toggleButton;

	@FindBy(id = "effect")
	private WebElement toggleEffect;

	public void getFramesList() {
		List<WebElement> noOfFrames = driver.findElements(By.className("iframe"));
		System.out.println("no.of frames" + noOfFrames.size());
	}

	/**
	 * method to click toggle button in frame
	 */
	public void clickToggleButton() {
		driver.switchTo().frame(0);
		clickOnElement(toggleButton, "toggleButton");

	}

	/**
	 * method to verify color
	 */
	public void verifyColorRed() {
		String headerColor = toggleEffect.getCssValue("background-color");
		Assert.assertEquals(headerColor,"rgba(254, 254, 254, 1)");

	}
	/**
	 * method to verify window size
	 * 
	 */
	public void verifyWindowSize() {
		Dimension size = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-corner-all']")).getSize();
		System.out.println("Size of the window : "+ size);
		System.out.println("Width of the window with constant : "+ size.width);
		System.out.println("Height of the window with constant : "+ size.height);
		System.out.println("Width of the button with method: "+ size.getWidth());
		System.out.println("Height of the button with method: "+ size.getHeight());
		Assert.assertEquals(size.getWidth(),"256");
	}
}
