package com.utile.files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.page.repo.AddCustomerPOM;
import com.page.repo.HomePagePOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtileClass {

	static WebDriver driver;
	public static AddCustomerPOM addCustomer;
	static Properties pro;
	static File file;
	static FileInputStream fi;
	public static HomePagePOM homePage;

	public UtileClass(WebDriver driver) {
		this.driver = driver;

	}

	public static String readPro(String key) {
		pro = new Properties();

		file = new File("C:\\Users\\Karthik Shankar\\eclipse-workspace\\Guru99Framework\\propertyFiles\\Repo.property");
		try {
			fi = new FileInputStream(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pro.load(fi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pro.getProperty(key);

	}

	public static void browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}

	public static void launchUrl(String url) {

		driver.get(url);
	}

	public static void click(String val) {

		driver.findElement(By.xpath(val)).click();
		;
	}

	public static void sendKeys(String val, String keys) {
		driver.findElement(By.xpath(val)).sendKeys(keys);
	}

	public static String getText(String val) {
		String text = driver.findElement(By.xpath(val)).getText();
		return text;

	}

	public static boolean isDisplayed(String val) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(val))));
		boolean displayed = driver.findElement(By.xpath(val)).isDisplayed();
		return displayed;

	}

	public static void close() {
		driver.close();

	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public static void assertion(String keys, String title) {
		Assert.assertEquals(keys, title);

	}

	public static void assertTrue(boolean flag) {

		assertTrue(flag);

	}

}
