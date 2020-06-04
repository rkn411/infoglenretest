package com.infoglenn.retest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.infoglenn.retest.base.BasePage;
import java.util.List;

public class NdtvMenuPage extends BasePage {

	@FindBy(id = "//a[@href]")
	private List<WebElement> listOfRefMenu;

	/**
	 * method to get top menu list size
	 * @return
	 */
	public int  getTopMenuSize() {

		WebElement parentElement = driver.findElement(By.xpath("//div[@class='nglobalnav_wrap']"));
		List<WebElement> elementList = parentElement.findElements(By.xpath("//a[@href]"));
		System.out.println("Top menu list size is :" + elementList.size());
		return elementList.size();
	}
	/**
	 * method to get footermwenu list size
	 * @return
	 */

	public int getFooterMenuSize() {
		WebElement parentElement = driver.findElement(By.xpath("//div[@class='footer_group']"));
		List<WebElement> elementList = parentElement.findElements(By.xpath("//a[@href]"));
		System.out.println("Bottom menu list size is :" + elementList.size());
		return elementList.size();

	}
}
