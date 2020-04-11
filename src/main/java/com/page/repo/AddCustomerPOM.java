package com.page.repo;

import org.openqa.selenium.WebDriver;

public class AddCustomerPOM {
	static WebDriver driver;

	public static  String done = "//label[@for='done']";
	public static  String pending = "//label[@for='pending']";
	public static  String firstName = "//*[@name='fname']";
	public static   String lastName = "//*[@name='lname']";
	public static   String email = "//*[@name='emailid']";
	public static   String address = "//*[@name='addr']";
	public static   String mobileNumber = "//*[@name='telephoneno']";
	public static   String sumit = "//*[@name='submit']";
	public static   String reset = "//*[@value='Reset']";
	public static   String customerID = "//h3";
	public static   String home = "//a[@class='button']";

}
