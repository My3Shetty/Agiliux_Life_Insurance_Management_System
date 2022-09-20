package org.Agiliux.LifeInsurenceObjectRepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPaymentPage {
	private WebDriver driver;
	// declaration
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	// initialization
	public AddPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// business library
	public void clickOnSubmitButton() {
		submitButton.click();
	}

	public void setDataForRequiredTextField(String passTextFieldName, String passTheData) {
		driver.findElement(By.name(passTextFieldName)).sendKeys(passTheData);
	}
}
