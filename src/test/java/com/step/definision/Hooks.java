package com.step.definision;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import com.page.repo.HomePagePOM;
import com.utile.files.UtileClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

@Before
	public static void launch() {
		UtileClass.launch();
	}

	@After
	public void close(Scenario scene) {

		if (scene.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) UtileClass.driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotAs, new File("./ScreenShot/failedTestCase/" + scene.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			TakesScreenshot ts = (TakesScreenshot) UtileClass.driver;

			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotAs, new File("./ScreenShot/passedTestCase" + scene.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

	}
}
