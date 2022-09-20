package org.Agiliux.LifeInsurenceObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Agiliux.Genericutility.ExcelUtility;

public class ClientStatusPage {

	@FindBy(xpath = "//a[text()='Add Payment']")
	private WebElement AddPayment;

	@FindBy(xpath = "//a[text()='Edit Client']")
	private WebElement EditClient;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement SubmitClient;
	@FindBy(xpath = "//a[text()='Delete Client']")
	private WebElement DeleteClient;
	@FindBy(xpath = "//input[@name='fileToUpload']")
	private WebElement image;

	public ClientStatusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Image(String cellvalue) {
		ExcelUtility ex = new ExcelUtility();
		image.sendKeys(cellvalue);
	}

	public void editClient() {
		EditClient.click();
	}

	public void submitClient() {
		SubmitClient.click();
	}

	public void deleteclient() {
		DeleteClient.click();
	}

	public void clickOnaddPaymentLink() {
		AddPayment.click();
	}

}
