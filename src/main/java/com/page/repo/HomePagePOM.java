package com.page.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utile.files.UtileClass;

public class HomePagePOM {
	static WebDriver driver;

	public HomePagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='logo']")
	public static WebElement guru99Logo;

	@FindBy(xpath = "//img[@src='images/pic01.jpg']")
	public static WebElement guru99Img;

	@FindBy(xpath = "//*[@class='flex-item left']//a[text()='Add Customer']")
	public static WebElement addCustomer;

	@FindBy(xpath = "//*[@class='flex-item right']//a[text()='Add Tariff Plan']")
	public static WebElement addTarrifPlan;

	@FindBy(xpath = "//div//a[text()='Add Tariff Plan to Customer']")
	public static WebElement addTaffirPlanToCustomer;

	@FindBy(xpath = "//div//a[text()='Pay Billing']")
	public static WebElement payBill;

	public static void verifyLogoAndImage() {
		UtileClass.waitForTheElement(guru99Logo).isDisplayed();
		UtileClass.waitForTheElement(guru99Img).isDisplayed();
		System.out.println("Logo and Image is Displayed");
	}

	public static void checkAllTheLinks() {
		UtileClass.waitForTheElement(addCustomer).click();
		UtileClass.verifyTitle(UtileClass.readPro("addCustomerTitle"));

		UtileClass.waitForTheElement(guru99Logo).click();
		UtileClass.waitForTheElement(addTarrifPlan).click();
		UtileClass.verifyTitle(UtileClass.readPro("addTarrifPlanTitle"));
		UtileClass.waitForTheElement(guru99Logo).click();
		UtileClass.waitForTheElement(addTaffirPlanToCustomer).click();
		UtileClass.verifyTitle(UtileClass.readPro("addTaffirPlanToCustomerTitle"));
		UtileClass.waitForTheElement(guru99Logo).click();

		UtileClass.waitForTheElement(payBill).click();
		UtileClass.verifyTitle(UtileClass.readPro("payBillTitle"));
		UtileClass.waitForTheElement(guru99Logo).click();

		System.out.println("All links Works properly");
	}

}
