package com.page.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utile.files.UtileClass;

public class AddCustomerPOM {
	static WebDriver driver;

	public AddCustomerPOM(WebDriver driver) {
		this.driver = driver;
		
	}

	@FindBy(xpath = "//label[@for='done']")
	public static WebElement done;

	@FindBy(xpath = "//label[@for='pending']")
	public static WebElement pending;

	@FindBy(xpath = "//*[@name='fname']")
	public static WebElement firstName;

	@FindBy(xpath = "//*[@name='lname']")
	public static WebElement lastName;

	@FindBy(xpath = "//*[@name='emailid']")
	public static WebElement email;

	@FindBy(xpath = "//*[@name='addr']")
	public static WebElement address;

	@FindBy(xpath = "//*[@name='telephoneno']")
	public static WebElement mobileNumber;

	@FindBy(xpath = "//*[@name='submit']")
	public static WebElement sumit;

	@FindBy(xpath = "//*[@value='Reset']")
	public static WebElement reset;

	@FindBy(xpath = "//h3")
	public static WebElement customerID;

	@FindBy(xpath = "//a[@class='button']")
	public static WebElement home;

	public static void passTheDatas(String fname, String lname, String mailId, String mbl) {
		UtileClass.waitForTheElement(done).click();
		UtileClass.waitForTextBoxEnable(firstName, fname);
		UtileClass.waitForTextBoxEnable(lastName, lname);
		UtileClass.waitForTextBoxEnable(email, mailId);
		UtileClass.waitForTextBoxEnable(mobileNumber, mbl);
		UtileClass.waitForTheElement(sumit).click();
		UtileClass.alertIsPresent().accept();
	}
	
	

}
