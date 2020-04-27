package com.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "C:\\Users\\Karthik Shankar\\eclipse-workspace\\Guru99Framework\\src\\main\\java\\com\\feature\\files\\tariffPlan.feature", glue = "com.step.definision", dryRun = false, plugin = {
		"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/Reports/extendedReport/ExtentReport.html"},monochrome =  true ,tags="@tariffPlan")
public class RunnerTest extends AbstractTestNGCucumberTests {

}
