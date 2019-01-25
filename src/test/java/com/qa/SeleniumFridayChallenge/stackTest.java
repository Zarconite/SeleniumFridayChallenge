package com.qa.SeleniumFridayChallenge;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.SeleniumFridayChallengeExtras.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class stackTest {

	public static ExtentReports report;
	public static ExtentTest test;
	public static WebElement element;
	public static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
    	System.setProperty("webdriver.chrome.driver","C:\\Data\\chromedriver.exe");
    	report = new ExtentReports(Constants.REPORTLOCATION, true);
    	System.setProperty(Constants.CHROMEWEBDRIVER,Constants.CHROMEWEBDRIVERLOCATION);
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void teardown() {
		report.flush();
		driver.quit();
	}

	
}