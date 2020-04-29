package com.page.repo;

import java.util.LinkedHashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utile.files.UtileClass;

public class AddTariffToCustomerPOM {
	UtileClass utileClass = new UtileClass();

	WebDriver driver;
	@FindBy(xpath = "//input[@name='customer_id']")
	public WebElement customerId;

	@FindBy(xpath = "//input[@name='submit']")
	public WebElement submit;

	@FindBy(xpath = "//label[contains(text(),'')]")
	public WebElement clickthePlan;

	@FindBy(xpath = "//input[@name='submit']")
	public WebElement addtariffToCustomer;

	@FindBy(xpath = "//a[@class='button']")
	public WebElement home;

	@FindBy(xpath = "//iframe[@id='flow_close_btn_iframe']")
	public WebElement iframe;

	@FindBy(xpath = "//div[@id='closeBtn']")
	public WebElement clsButton;

	public AddTariffToCustomerPOM(WebDriver driver) {
		this.driver = driver;

	}

	public void closeButton() {
		utileClass.waitForTheFrame(iframe);
		utileClass.waitForTheElementPresent(clsButton).click();
		driver.switchTo().defaultContent();
	}

	public void enterTheCustomerId(String keys) {
		System.out.println("User enter the customer ID");
		utileClass.sendKeys(customerId, keys);

	}

	public void clickTheSubmitButton() {

		System.out.println("User click the submit button");
		utileClass.waitForTheElement(submit).click();

	}

	public void chooseThePlan() {
		System.out.println("User waiting for the flash video add");

		closeButton();
		System.out.println("User close the flash video add");

		// ((JavascriptExecutor)driver).executeScript("return
		// window.getComputedStyle(arguments[0],':before').getPropertyValue('content');",
		// clickthePlan).toString();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickthePlan);
		System.out.println("User click the plan");

	}

	public void clickTheTariffButton() {

		utileClass.waitForTheElement(addtariffToCustomer).click();
		System.out.println("User click the tariff button");

		utileClass.waitForTheElement(home).click();

		System.out.println("User click the home button");

	}
}
