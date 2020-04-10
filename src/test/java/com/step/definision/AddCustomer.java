package com.step.definision;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.utile.files.UtileClass;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AddCustomer {
	static WebDriver driver;
	@Given("^launch the url$")
	public void launch_the_url() throws Throwable {
		UtileClass ut = new UtileClass(driver);
		UtileClass.browserLaunch(UtileClass.readPro("browser"));
		UtileClass.launchUrl(UtileClass.readPro("addCustomerURL"));

	}

	@Then("^enter the details$")
	public void enter_the_details(DataTable table) throws Throwable {
		List<List<String>> asLists = table.asLists(String.class);
		UtileClass.sendKeys(UtileClass.addCustomer.firstName,asLists.get(0).get(0) );
		UtileClass.sendKeys(UtileClass.addCustomer.lastName,asLists.get(0).get(1));
		UtileClass.sendKeys(UtileClass.addCustomer.email,asLists.get(0).get(2));
		UtileClass.sendKeys(UtileClass.addCustomer.mobileNumber,asLists.get(0).get(3));
	
	}

	@Then("^click the button$")
	public void click_the_button() throws Throwable {
		UtileClass.click(UtileClass.addCustomer.sumit);
	}

	@Then("^The checks wheather the alert is present or not$")
	public void the_checks_wheather_the_alert_is_present_or_not() throws Throwable {
	
	}

	@Then("^click the reset button$")
	public void click_the_reset_button() throws Throwable {
	UtileClass.click(UtileClass.addCustomer.reset);
	
	}

	@Then("^checks the textboxs are empty$")
	public void checks_the_textboxs_are_empty() throws Throwable {
	
	
	}

}
