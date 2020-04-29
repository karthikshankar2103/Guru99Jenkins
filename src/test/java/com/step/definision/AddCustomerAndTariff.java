package com.step.definision;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.page.repo.AddCustomerPOM;
import com.page.repo.AddTariffPOM;
import com.page.repo.AddTariffToCustomerPOM;
import com.page.repo.HomePagePOM;
import com.page.repo.PaayBillPOM;
import com.utile.files.UtileClass;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomerAndTariff extends UtileClass {

	HomePagePOM homePage = new HomePagePOM(driver);
	AddTariffPOM addTarrif = new AddTariffPOM(driver);
	AddTariffToCustomerPOM tariffToCustomer = new AddTariffToCustomerPOM(driver);
	PaayBillPOM payBill = new PaayBillPOM(driver);
	AddCustomerPOM addCustomer = new AddCustomerPOM(driver);
	String customerId = "";

	// Execution starts here

	@Given("^user on the application$")
	public void user_on_the_application() throws Throwable {
		addTarrif = PageFactory.initElements(driver, AddTariffPOM.class);
		homePage = PageFactory.initElements(driver, HomePagePOM.class);
		addCustomer = PageFactory.initElements(driver, AddCustomerPOM.class);

		waitForTheElement(homePage.addCustomer).click();

	}

	@When("^the user enter the customer details$")
	public void the_user_enter_the_customer_details(DataTable table) throws Throwable {
		List<String> asList = table.asList(String.class);

		addCustomer.passTheDatas(asList.get(0), asList.get(1), asList.get(2), asList.get(3), asList.get(4));
	}

	@Then("^user click the submit button$")
	public void user_click_the_submit_button() throws Throwable {
		addTarrif.clickTheButton();
	}

	@Then("^click the submit button$")
	public void click_the_submit_button() throws Throwable {
		addCustomer.clickTheButton();
	}

	@Then("^get the customer Id$")
	public void get_the_customer_Id() throws Throwable {
		customerId = addCustomer.getCustomerId();
		addCustomer.home.click();
	}

	@Then("^user on the tariff page$")
	public void user_on_the_tariff_page() throws Throwable {
		waitForTheElement(homePage.addTarrifPlan).click();

	}

	@When("^the user enter the tariff details$")
	public void the_user_enter_the_tariff_details(DataTable table) throws Throwable {
		List<String> asList = table.asList(String.class);
		addTarrif.addTariff(asList.get(0), asList.get(1), asList.get(2), asList.get(3), asList.get(4), asList.get(5),
				asList.get(6));

	}

	@Then("^user on the page$")
	public void user_on_the_page() throws Throwable {
		waitForTheElement(homePage.addTaffirPlanToCustomer).click();
	}

	@When("^the user enter the customer id$")
	public void the_user_enter_the_customer_id() throws Throwable {
		tariffToCustomer = PageFactory.initElements(driver, AddTariffToCustomerPOM.class);
		tariffToCustomer.enterTheCustomerId(customerId);

	}

	@When("^the user click ok$")
	public void the_user_click_ok() throws Throwable {
		tariffToCustomer.clickTheSubmitButton();
	}

	@Then("^the user choose the tariff plan$")
	public void the_user_choose_the_tariff_plan() throws Throwable {
		tariffToCustomer.chooseThePlan();
	}

	@Then("^the user click ok button$")
	public void the_user_click_ok_button() throws Throwable {
		tariffToCustomer.clickTheTariffButton();
	}

	@Then("^User on the bill payment page$")
	public void user_on_the_bill_payment_page() throws Throwable {

		waitForTheElement(homePage.payBill).click();
	}

	@Then("^the user check his bill$")
	public void the_user_check_his_bill() throws Throwable {
		payBill = PageFactory.initElements(driver, PaayBillPOM.class);
		payBill.enterTheCustomerId(customerId);
		Assert.assertTrue(payBill.checkTheName(addCustomer.customerName));
		System.out.println("Bill verified");
		System.out.println("All Scenario got excuted");
	}
}
