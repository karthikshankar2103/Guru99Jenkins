package com.step.definision;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.page.repo.AddCustomerPOM;
import com.utile.files.UtileClass;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomer extends UtileClass {
	UtileClass utileClass = new UtileClass();

	AddCustomerPOM addCustomer = new AddCustomerPOM(driver);

	@Given("^launch the url$")
	public void launch_the_url() throws Throwable {
		addCustomer = PageFactory.initElements(driver, AddCustomerPOM.class);
		utileClass.launchURL(utileClass.readPro("addCustomerURL"));
		addCustomer.closeButton();

	}

	@When("^the user enter the details$")
	public void the_user_enter_the_details(DataTable table) throws Throwable {
		List<String> asList = table.asList(String.class);
		addCustomer.passTheDatas(asList.get(0), asList.get(1), asList.get(2), asList.get(3));

	}

	@When("^click the button$")
	public void click_the_button() throws Throwable {
		addCustomer.clickTheButton();
	}

	@Then("^checks wheather the alert is present or not$")
	public void checks_wheather_the_alert_is_present_or_not() throws Throwable {

		utileClass.alertIsPresent().accept();

	}

	@When("^click the reset button$")
	public void click_the_reset_button() throws Throwable {
		addCustomer.clickTheResetButton();
	}

	@Then("^checks wheather the textbox is empty or not$")
	public void checks_wheather_the_textbox_is_empty_or_not() throws Throwable {

		utileClass.assertTrue(utileClass.isEmpty(addCustomer.firstName));

	}

	@When("^User enters the details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enters_the_details(String fname, String lname, String mail, String add, String mbl)
			throws Throwable {

		addCustomer.passTheDatas(fname, lname, mail, add, mbl);

	}

	@Then("^get the customer id number$")
	public void get_the_customer_id_number() throws Throwable {
		String customerId = addCustomer.getCustomerId();

	}
}