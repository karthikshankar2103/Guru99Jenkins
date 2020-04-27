package com.page.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utile.files.UtileClass;

public class HomePagePOM {
	UtileClass utileClass = new UtileClass();

	WebDriver driver;

	public HomePagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='logo']")
	public WebElement guru99Logo;

	@FindBy(xpath = "//img[@src='images/pic01.jpg']")
	public WebElement guru99Img;

	@FindBy(xpath = "//*[@class='flex-item left']//a[text()='Add Customer']")
	public WebElement addCustomer;

	@FindBy(xpath = "//*[@class='flex-item right']//a[text()='Add Tariff Plan']")
	public WebElement addTarrifPlan;

	@FindBy(xpath = "//div//a[text()='Add Tariff Plan to Customer']")
	public WebElement addTaffirPlanToCustomer;

	@FindBy(xpath = "//div//a[text()='Pay Billing']")
	public WebElement payBill;

	public void verifyLogoAndImage() {
		utileClass.waitForTheElement(guru99Logo).isDisplayed();
		utileClass.waitForTheElement(guru99Img).isDisplayed();
		System.out.println("Logo and Image is Displayed");
	}

	public void checkAllTheLinks() {
		utileClass.waitForTheElement(addCustomer).click();
		utileClass.verifyTitle(utileClass.readPro("addCustomerTitle"));

		utileClass.waitForTheElement(guru99Logo).click();
		utileClass.waitForTheElement(addTarrifPlan).click();
		utileClass.verifyTitle(utileClass.readPro("addTarrifPlanTitle"));
		utileClass.waitForTheElement(guru99Logo).click();
		utileClass.waitForTheElement(addTaffirPlanToCustomer).click();
		utileClass.verifyTitle(utileClass.readPro("addTaffirPlanToCustomerTitle"));
		utileClass.waitForTheElement(guru99Logo).click();

		utileClass.waitForTheElement(payBill).click();
		utileClass.verifyTitle(utileClass.readPro("payBillTitle"));
		utileClass.waitForTheElement(guru99Logo).click();

		System.out.println("All links Works properly");
	}

}
