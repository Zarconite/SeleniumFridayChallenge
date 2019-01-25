package com.qa.SeleniumFridayChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.SeleniumFridayChallenge.*;
import com.qa.SeleniumFridayChallengeExtras.*;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {
	
	private Actions action = new Actions(stackTest.driver);
	private LoginPage loginPage;
	
	@Before
	public void setup() {
		stackTest.test = stackTest.report.startTest("Verify scenarios..");
	}
	
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
		stackTest.driver.get(Constants.LANDINGPAGEURL);
		stackTest.test.log(LogStatus.INFO, "Chrome started..");
		stackTest.test.log(LogStatus.INFO, "Loading the landing page..");
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form(){
		stackTest.test.log(LogStatus.INFO, "Navigating to the login page..");
		LandingPage landingPage = PageFactory.initElements(stackTest.driver, LandingPage.class);
		landingPage.navigateToAutomatedTestingLoginPage();
		stackTest.test.log(LogStatus.INFO, "Navigation complete!");
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String country){
		stackTest.test.log(LogStatus.INFO, "Selecting a country..");
		 loginPage = PageFactory.initElements(stackTest.driver, LoginPage.class);
		loginPage.selectCountry(stackTest.driver, action, country);
		stackTest.test.log(LogStatus.INFO, "Selection of " + country + " complete!");
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String eMail){
		stackTest.test.log(LogStatus.INFO, "Entering eMail..");
		loginPage.enterEmail(stackTest.driver,eMail);
		stackTest.test.log(LogStatus.INFO, "Email: " + eMail + " successfully entered!");
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String passWord){
		stackTest.test.log(LogStatus.INFO, "Entering password..");
		loginPage.enterPassword1(passWord);
		stackTest.test.log(LogStatus.INFO, "Password: " + passWord + " successfully entered!");
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String passWord){
		stackTest.test.log(LogStatus.INFO, "Entering password again..");
		loginPage.enterPassword2(passWord);
		stackTest.test.log(LogStatus.INFO, "Password: " + passWord + " successfully re-entered!");
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message(){
		stackTest.test.log(LogStatus.INFO, "Checking the result..");
		String successResultString = loginPage.checkSuccessResult(stackTest.driver);
		
		if(successResultString.equals("Success!")) {
			stackTest.test.log(LogStatus.PASS, "Result should be successful | Expected: " + "Success!" + " | Actual: " + successResultString);
		}
		else {
			stackTest.test.log(LogStatus.FAIL, "Result should be successful | Expected: " + "Success!" + " | Actual: " + successResultString);
		}
		assertEquals("Result should be successful", "Success!", successResultString);
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String passWord){
		stackTest.test.log(LogStatus.INFO, "Entering incorrect password..");
		loginPage.enterPassword2(passWord);
		stackTest.test.log(LogStatus.INFO, "Password: " + passWord + " successfully entered!");
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match(){
		stackTest.test.log(LogStatus.INFO, "Checking the result..");
		String incorrectPasswordResultString = loginPage.checkIncorrectPasswordResult(stackTest.driver);
		
		if(incorrectPasswordResultString.equals("The passwords do not match")) {
			stackTest.test.log(LogStatus.PASS, "Result should be that the passwords dont match | Expected: " + "The passwords do not match" + " | Actual: " + incorrectPasswordResultString);
		}
		else {
			stackTest.test.log(LogStatus.FAIL, "Result should be that the passwords dont match | Expected: " + "The passwords do not match" + " | Actual: " + incorrectPasswordResultString);
		}
		assertEquals("Result should be that the passwords dont match", "The passwords do not match", incorrectPasswordResultString);
	}
	
	@When("^I fill click the \"([^\"]*)\" dropdown$")
	public void i_fill_click_the_dropdown(String country) {
		stackTest.test.log(LogStatus.INFO, "Selecting a country..");
		loginPage.selectCountry(stackTest.driver, action, country);
		stackTest.test.log(LogStatus.INFO, "Selection of " + country + " complete!");
	}

	@When("^I fill out the email field with an incorrect email \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with_an_incorrect_email(String eMail) {
		stackTest.test.log(LogStatus.INFO, "Entering eMail..");
		loginPage.enterEmail(stackTest.driver,eMail);
		stackTest.test.log(LogStatus.INFO, "Email: " + eMail + " successfully entered!");
	}

	@Then("^I should see a message saying that email contains incorrect characters$")
	public void i_should_see_a_message_saying_that_email_contains_incorrect_characters() {
		stackTest.test.log(LogStatus.INFO, "Checking the result..");
		String incorrectEmailResultString = loginPage.checkIncorrectEmailResult(stackTest.driver);
		
		if(incorrectEmailResultString.equals("email contains incorrect characters")) {
			stackTest.test.log(LogStatus.PASS, "Result should be that the email contains incorrect characters | Expected: " + "email contains incorrect characters" + " | Actual: " + incorrectEmailResultString);
		}
		else {
			stackTest.test.log(LogStatus.FAIL, "Result should be that the email contains incorrect characters | Expected: " + "email contains incorrect characters" + " | Actual: " + incorrectEmailResultString);
		}
		assertEquals("Result should be that the email contains incorrect characters", "email contains incorrect characters", incorrectEmailResultString);
	}
	
	@After
	public void end() {
		stackTest.report.endTest(stackTest.test);
		stackTest.report.flush();
	}
}
