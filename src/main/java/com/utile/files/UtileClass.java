package com.utile.files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.page.repo.AddCustomerPOM;
import com.page.repo.AddTariffPOM;
import com.page.repo.AddTariffToCustomerPOM;
import com.page.repo.HomePagePOM;
import com.page.repo.PaayBillPOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtileClass {

	
	
	public static WebDriver driver;

	
	
	SoftAssert sa = new SoftAssert();
	
	
	Properties pro;
	File file;
	FileInputStream fi;

	
	public WebDriver launch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			try {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			} catch (Exception e) {
				WebDriverManager.chromedriver().setup();
			}
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else {
			try {
				System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
			} catch (Exception e) {
				WebDriverManager.firefoxdriver().setup();
			}
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}

		return driver;

	}
	
	public void launchURL(String url) {
		
		driver.get(url);
		
	}
	
	
	

	public boolean isEmpty(WebElement ele) {
		String attribute = ele.getAttribute("value");

		boolean empty = attribute.isEmpty();

		return empty;

	}

	public Alert alertIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		return wait.until(ExpectedConditions.alertIsPresent());

	}


	public void waitForTheFrame(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public WebElement waitForTheElementPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
		return until;
	}

	public WebElement waitForTheElement(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(element));
		return until;
	}

	public String readPro(String key) {
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

	public void waitForTextBoxEnable(WebElement ele, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(value);

	}

	public void sendKeys(WebElement val, String keys) {
		val.sendKeys(keys);
	}

	public boolean isDisplayed(WebElement val) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(val));
		boolean displayed =val.isDisplayed();
		return displayed;

	}

	public void close() {
		driver.close();

	}

	public void verifyTitle(String actual) {
		String title = driver.getTitle();
		sa.assertEquals(actual, title);
		sa.assertAll();
	}

	public void assertion(String keys, String title) {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(keys, title);
		sa.assertAll();
	}

	public void assertTrue(boolean flag) {

		assertTrue(flag);

	}

}
