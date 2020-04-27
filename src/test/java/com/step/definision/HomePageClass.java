package com.step.definision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.page.repo.HomePagePOM;
import com.utile.files.UtileClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageClass extends UtileClass {

	HomePagePOM homePage = new HomePagePOM(driver);

	@Given("^the user verifys the image and logo$")
	public void verify_the_logo_verify_the_image_is_present_or_not() throws Throwable {
		homePage = PageFactory.initElements(driver, HomePagePOM.class);
		homePage.verifyLogoAndImage();

	}

	@Then("^check all the links$")
	public void check_all_the_links() throws Throwable {
		homePage.checkAllTheLinks();
	}

}