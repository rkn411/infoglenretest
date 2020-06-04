package com.infoglenretest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.infoglenn.retest.drivermanager.DriverFactory;
import com.infoglenn.retest.pages.NdtvMenuPage;
import com.infoglenn.retest.pages.ToggleEffectPage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestSuite extends DriverFactory {

	@Test(priority = 1)
	public void verifyToggleActions() {
		ToggleEffectPage togglePage = new ToggleEffectPage();

		// Step :1
		togglePage.clickToggleButton();
		// Step :2
		togglePage.verifyColorRed();
		// Step :3
		togglePage.verifyWindowSize();

	}

	@Test(priority = 2)
	public void verifyMenuList() {
		NdtvMenuPage ndtvMenu = new NdtvMenuPage();
		// Step :1
		int toplevel = ndtvMenu.getTopMenuSize();
		// Step :2
		int bottomlevel = ndtvMenu.getFooterMenuSize();
		Assert.assertEquals(toplevel, bottomlevel);
	}

	@Test(priority = 3)
	public void postResponseShouldBe201() {
		RestAssured.baseURI = " https://reqres.in/api/";
		Response response = null;
		try {
			response = RestAssured.given().when().queryParam("page", "2").post("/users");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Response :" + response.asString());
		System.out.println("Status Code :" + response.getStatusCode());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");

	}

}
