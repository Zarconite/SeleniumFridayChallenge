package com.qa.SeleniumFridayChallenge;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	@FindBy(xpath = "/html/body/div/div/ul/li[10]/a")
	private WebElement linkToAutomatedTestingLoginPage;
	
	public void navigateToAutomatedTestingLoginPage() {
		linkToAutomatedTestingLoginPage.click();
	}
	
}