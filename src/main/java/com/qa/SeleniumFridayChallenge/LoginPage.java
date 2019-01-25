package com.qa.SeleniumFridayChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	// Country
	@FindBy(xpath = "/html/body/div/div/div/div/button")
	private WebElement countryHoverButton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div")
	private WebElement countryDropDownList;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement countryUK;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement countryFrance;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement countryGermany;

	// Email
	@FindBy(xpath = "//*[@id=\"nameInput\"]")
	private WebElement eMailInputBox;

	// Password
	@FindBy(id = "passInput")
	private WebElement passWordInput1;
	@FindBy(id = "passInput2")
	private WebElement passWordInput2;
	@FindBy(xpath = "/html/body/div/div/div/button")
	private WebElement submitButton;

	// Results
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement resultString;
	@FindBy(xpath = "/html/body/div/div/div/p[10]")
	private WebElement nonMatchingString;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/p[5]")
	private WebElement incorrectEmailString;
	

	public void selectCountry(WebDriver driver, Actions action, String countryInput) {
		action.moveToElement(countryHoverButton).build().perform();
		WebElement waitForCountriesList = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(countryDropDownList));
		if (countryInput.equals("United Kingdom")) {
			action.moveToElement(countryUK).click().build().perform();
		} else if (countryInput.equals("France")) {
			action.moveToElement(countryFrance).click().build().perform();
		} else if (countryInput.equals("Germany")) {
			action.moveToElement(countryGermany).click().build().perform();
		}
	}

	public void enterEmail(WebDriver driver, String eMailString) {
		WebElement waitForEmailBox = (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nameInput\"]")));
		eMailInputBox.sendKeys(eMailString);
	}

	public void enterPassword1(String passwordString) {
		passWordInput1.click();
		passWordInput1.sendKeys(passwordString);
	}

	public void enterPassword2(String passwordString) {
		passWordInput2.click();
		passWordInput2.sendKeys(passwordString);
		submitButton.click();
	}

	public String checkSuccessResult(WebDriver driver) {
		WebElement waitForSuccessResult = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(resultString));
		return resultString.getAttribute("innerText");
	}

	public String checkIncorrectPasswordResult(WebDriver driver) {
		WebElement waitForIncorrectPasswordResult = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/p[10]")));
		return nonMatchingString.getAttribute("innerText");
	}
	public String checkIncorrectEmailResult(WebDriver driver) {
		WebElement waitForIncorrectEmailResult = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/p[5]")));
		return incorrectEmailString.getAttribute("innerText");
	}
}
