package com.page.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utile.files.UtileClass;

public class AddTariffPOM {

	UtileClass utileClass = new UtileClass();

	WebDriver driver;

	public AddTariffPOM(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name='customer_id']")
	public WebElement customerId;

	@FindBy(xpath = "//input[@name='submit']")
	public WebElement submit;

	@FindBy(xpath = "//input[@name='rental']")
	public WebElement monthyRental;

	@FindBy(xpath = "//input[@name='local_minutes']")
	public WebElement freeLocalMinutes;

	@FindBy(xpath = "//input[@name='inter_minutes']")
	public WebElement freeInternationalMinutes;

	@FindBy(xpath = "//input[@name='sms_pack']")
	public WebElement freeSMSPack;

	@FindBy(xpath = "//input[@name='minutes_charges']")
	public WebElement localPerMinutes;

	@FindBy(xpath = "//input[@name='inter_charges']")
	public WebElement internationalPerMinutes;

	@FindBy(xpath = "//input[@name='sms_charges']")
	public WebElement SMSPerCharges;

	@FindBy(xpath = "//iframe[@id='flow_close_btn_iframe']")
	public WebElement iframe;

	@FindBy(xpath = "//div[@id='closeBtn']")
	public WebElement clsButton;

	@FindBy(xpath = "//a[@class='button']")
	public WebElement home;

	public void closeButton() {
		utileClass.waitForTheFrame(iframe);
		utileClass.waitForTheElementPresent(clsButton).click();
		driver.switchTo().defaultContent();
	}

	public void addTariff(String args, String args1, String args2, String args3, String args4, String args5,
			String args6) {
		System.out.println("User waiting for the flash video add");
		closeButton();
		System.out.println("User close the flash video add");
		System.out.println("User enter the tariff plan details");
		utileClass.waitForTextBoxEnable(monthyRental, args);
		utileClass.waitForTextBoxEnable(freeLocalMinutes, args1);
		utileClass.waitForTextBoxEnable(freeInternationalMinutes, args2);
		utileClass.waitForTextBoxEnable(freeSMSPack, args3);
		utileClass.waitForTextBoxEnable(localPerMinutes, args4);
		utileClass.waitForTextBoxEnable(internationalPerMinutes, args5);
		utileClass.waitForTextBoxEnable(SMSPerCharges, args6);

	}

	public void clickTheButton() {
		utileClass.waitForTheElement(submit).click();
		System.out.println("User click the submit button");
		System.out.println("User waiting for the flash video add");
		
		closeButton();
		System.out.println("User close the flash video add");
		
		utileClass.waitForTheElement(home).click();
		System.out.println("User click the home Button");
	}
}
