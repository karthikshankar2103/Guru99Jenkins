package com.step.definision;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.utile.files.UtileClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	UtileClass utileClass = new UtileClass();

	@Before(value = "@AddCustomer")
	public void launchBrowser() {
		utileClass.launch("chrome");
	}

	@Before(value = "@tariffPlan")
	public void launcher() {
		utileClass.launch("chrome");
		utileClass.launchURL(utileClass.readPro("URL"));
	}

	@After
	public void close(Scenario scene) {

		if (scene.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) utileClass.driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotAs, new File("./ScreenShot/failedTestCase/" + scene.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			TakesScreenshot ts = (TakesScreenshot) utileClass.driver;

			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotAs, new File("./ScreenShot/passedTestCase" + scene.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		utileClass.driver.quit();
	}
}
