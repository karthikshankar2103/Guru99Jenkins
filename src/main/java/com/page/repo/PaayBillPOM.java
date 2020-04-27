package com.page.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utile.files.UtileClass;

public class PaayBillPOM {
	UtileClass utileClass = new UtileClass();

	WebDriver driver;

	@FindBy(xpath = "//input[@name='customer_id']")
	public WebElement customerId;

	@FindBy(xpath = "//input[@name='submit']")
	public WebElement submit;

	@FindBy(xpath = "//h3")
	public WebElement cusName;

	public PaayBillPOM(WebDriver driver) {
		this.driver = driver;

	}

	public void enterTheCustomerId(String keys) {
		System.out.println("User enter the customer ID");

		utileClass.sendKeys(customerId, keys);

		utileClass.waitForTheElement(submit).click();
		System.out.println("User click the submit button");

	}

	public boolean checkTheName(String keys) {
		
		boolean contains = cusName.getText().contains(keys);

		return contains;
	}

}
