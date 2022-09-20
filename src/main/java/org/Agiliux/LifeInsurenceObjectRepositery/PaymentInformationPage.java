package org.Agiliux.LifeInsurenceObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformationPage {

	//declaration
	@FindBy(xpath = "//a[text()='Add Payment']")
	private WebElement addPaymentButton;

	//initializing element variable
	public PaymentInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//business library
	public void clickOnAddPaymentButton() {
		addPaymentButton.click();  
	}
}
