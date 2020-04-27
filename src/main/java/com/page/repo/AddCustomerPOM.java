package com.page.repo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.data.provider.DataDriven;
import com.utile.files.UtileClass;

public class AddCustomerPOM {
	UtileClass utileClass = new UtileClass();

	WebDriver driver;

	public AddCustomerPOM(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//iframe[@id='flow_close_btn_iframe']")
	public WebElement iframe;

	@FindBy(xpath = "//label[@for='done']")
	public WebElement done;

	@FindBy(xpath = "//div[@id='closeBtn']")
	public WebElement clsButton;

	@FindBy(xpath = "//label[@for='pending']")
	public WebElement pending;

	@FindBy(xpath = "//*[@name='fname']")
	public WebElement firstName;

	@FindBy(xpath = "//*[@name='lname']")
	public WebElement lastName;

	@FindBy(xpath = "//*[@name='emailid']")
	public WebElement email;

	@FindBy(xpath = "//*[@name='addr']")
	public WebElement address;

	@FindBy(xpath = "//*[@name='telephoneno']")
	public WebElement mobileNumber;

	@FindBy(xpath = "//*[@name='submit']")
	public WebElement sumit;

	@FindBy(xpath = "//*[@value='Reset']")
	public WebElement reset;

	@FindBy(xpath = "//table/tbody//tr//td[2]")
	public WebElement customerID;

	@FindBy(xpath = "//a[@class='button']")
	public WebElement home;

	public String customerName = " ";

	public void passTheDatas(String fname, String lname, String mailId, String mbl) {
		utileClass.waitForTheElement(done).click();
		utileClass.waitForTextBoxEnable(firstName, fname);
		utileClass.waitForTextBoxEnable(lastName, lname);
		utileClass.waitForTextBoxEnable(email, mailId);
		utileClass.waitForTextBoxEnable(mobileNumber, mbl);
	}

	public void closeButton() {
		utileClass.waitForTheFrame(iframe);
		utileClass.waitForTheElementPresent(clsButton).click();
		driver.switchTo().defaultContent();
	}

	public void passTheDatas(String fname, String lname, String mailId, String add, String mbl) {
System.out.println("User Waiting for the flash video add");
		closeButton();
		System.out.println("User close the flash video add");
		customerName = fname;
		System.out.println("User enters the datas");
		utileClass.waitForTheElement(done).click();
		utileClass.waitForTextBoxEnable(firstName, fname);
		utileClass.waitForTextBoxEnable(lastName, lname);
		utileClass.waitForTextBoxEnable(email, mailId);
		utileClass.waitForTextBoxEnable(address, add);
		utileClass.waitForTextBoxEnable(mobileNumber, mbl);
//		utileClass.waitForTheElement(sumit).click();

	}

	public void clickTheResetButton() {
		utileClass.waitForTheElement(reset).click();

	}

	public void clickTheButton() {
		System.out.println("User click the submit button");
		utileClass.waitForTheElement(sumit).click();
		closeButton();
		
	}

	public String getCustomerId() {
		String id = utileClass.waitForTheElement(customerID).getText();
		System.out.println("Customer ID is generated");
		System.out.println("User click the home Button");
		return id;
	}

}
