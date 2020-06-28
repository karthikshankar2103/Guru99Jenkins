package com.utile.files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtileClass {

	public static WebDriver driver;
	WebElement element;
	SoftAssert sa = new SoftAssert();
	String str;
	Properties pro;
	File file;
	FileInputStream fi;
	boolean empty;

	public WebDriver launch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("FF")) {
			try {
				System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
			} catch (Exception e) {
				WebDriverManager.firefoxdriver().setup();
			}
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}
		return driver;

	}

	public void launchURL(String url) {
		driver.get(url);
		System.out.println("URL launched");

	}

	public boolean isEmpty(WebElement ele) {

		try {
			String attribute = ele.getAttribute("str");

			empty = attribute.isEmpty();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return empty;

	}

	public Alert alertIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public void waitForTheFrame(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public WebElement waitForTheElementPresent(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public WebElement waitForTheElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			element = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public String readPro(String key) {
		pro = new Properties();
		try {

			file = new File(
					"C:\\Users\\Karthik Shankar\\eclipse-workspace\\Guru99Framework\\propertyFiles\\Repo.property");
			try {
				fi = new FileInputStream(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				pro.load(fi);
				str = pro.getProperty(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return str;

	}

	public void waitForTextBoxEnable(WebElement ele, String str) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void sendKeys(WebElement val, String keys) {

		try {
			val.sendKeys(keys);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public boolean isDisplayed(WebElement val) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.visibilityOf(val));
			empty = val.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empty;

	}

	public void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
