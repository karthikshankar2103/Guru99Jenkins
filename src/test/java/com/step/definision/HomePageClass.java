package com.step.definision;

import org.openqa.selenium.WebDriver;

import com.utile.files.UtileClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageClass {
	WebDriver driver;

	@Given("^launch the browser$")
	public void launch_the_browser() {
		UtileClass ut = new UtileClass(driver);
		UtileClass.browserLaunch(UtileClass.readPro("browser"));
		UtileClass.launchUrl(UtileClass.readPro("URL"));

	}

	@Then("^verify the logo$")
	public void verify_the_logo() throws Throwable {
		UtileClass.assertTrue(UtileClass.isDisplayed(UtileClass.homePage.guru99Logo));
		System.out.println("Logo is displayed");

	}

	@Then("^verify the image is present or not$")
	public void verify_the_image_is_present_or_not() throws Throwable {
		UtileClass.assertTrue(UtileClass.isDisplayed(UtileClass.homePage.guru99Img));
		System.out.println("Image is displayed");

	}

	@Then("^click the add customer and verify$")
	public void click_the_add_customer_and_verify() throws Throwable {
		UtileClass.click(UtileClass.homePage.addCustomer);
		UtileClass.assertion(UtileClass.getTitle(), UtileClass.readPro("addCustomerTitle"));
		UtileClass.click(UtileClass.homePage.guru99Logo);
		System.out.println("AddCustomer checked");

	}

	@Then("^click the add tariff plan and verify$")
	public void click_the_add_tariff_plan_and_verify() throws Throwable {
		UtileClass.click(UtileClass.homePage.addTarrifPlan);
		UtileClass.assertion(UtileClass.getTitle(), UtileClass.readPro("addTarrifPlanTitle"));

		UtileClass.click(UtileClass.homePage.guru99Logo);
		System.out.println("AddTarrifPlan checked");

	}

	@Then("^click the add tariff plan to customer and verify$")
	public void click_the_add_tariff_plan_to_customer_and_verify() throws Throwable {
		UtileClass.click(UtileClass.homePage.addTaffirPlanToCustomer);
		UtileClass.assertion(UtileClass.getTitle(), UtileClass.readPro("addTaffirPlanToCustomerTitle"));
		UtileClass.click(UtileClass.homePage.guru99Logo);
		System.out.println("AddTaffirPlanToCustomer checked");

	}

	@Then("^click the pay billing and verify$")
	public void click_the_pay_billing_and_verify() throws Throwable {
		UtileClass.click(UtileClass.homePage.payBill);
		UtileClass.assertion(UtileClass.getTitle(), UtileClass.readPro("payBillTitle"));
		UtileClass.click(UtileClass.homePage.guru99Logo);
		System.out.println("PayBill checked");

	}
}