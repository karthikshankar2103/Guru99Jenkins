package com.page.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePOM {
	static WebDriver driver;

	public static String guru99Logo = "//a[@class='logo']";
	public static String guru99Img = "//img[@src='images/pic01.jpg']";
	public static String addCustomer = "//*[@class='flex-item left']//a[text()='Add Customer']";
	public static String addTarrifPlan = "//*[@class='flex-item right']//a[text()='Add Tariff Plan']";
	public static String addTaffirPlanToCustomer = "//div//a[text()='Add Tariff Plan to Customer']";
	public static String payBill = "//div//a[text()='Pay Billing']";

}
