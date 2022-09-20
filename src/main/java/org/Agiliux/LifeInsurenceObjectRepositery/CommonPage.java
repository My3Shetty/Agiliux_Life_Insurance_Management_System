package org.Agiliux.LifeInsurenceObjectRepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Agiliux.Genericutility.WebDriverUtility;

public class CommonPage {
	private WebDriver driver;
	WebDriverUtility web;

	private String dynamicXpath = "//a[text()='%s']";
	private WebElement clients;
	@FindBy(xpath = "//a[text()='CLIENTS']")
	private WebElement Client;
	@FindBy(xpath = "//a[text()='Aegon Life']")
	private WebElement Homepage;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement Searchbox;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Searchbutton;
	@FindBy(xpath = "//a[text()='Client Status']")
	private WebElement clickClientStatus;
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement Logout;
	@FindBy(xpath = "//i[@class='fa fa-dollar fa-5x']/following-sibling::h5")
	private WebElement getText;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement convertDynamicXpathintowebElement(String dymamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dymamicXpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;
	}

	public void Client() {
		Client.click();
	}

	public void clickOnrequriedTab(String tabName) {
		new WebDriverUtility().convertDynamicXpathToWebElement(driver, tabName).click();
	}

	public void homePage() {
		Homepage.click();
	}

	public String searchBox(String object) {
		Searchbox.sendKeys(object);
		Searchbutton.click();
		return object;
	}

	public void clickclientstatus() {
		clickClientStatus.click();
	}

	public void logout() {
		Logout.click();
	}

	public String getTextOfTheElement() {
		return getText.getText();
	}
}
