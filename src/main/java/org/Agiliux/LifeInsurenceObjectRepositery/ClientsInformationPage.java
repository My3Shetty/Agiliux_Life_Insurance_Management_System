package org.Agiliux.LifeInsurenceObjectRepositery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsInformationPage {
	private WebDriver driver;
	// declaration
	@FindBy(xpath = "//tbody//td[.='John Red']/following-sibling::td//a[.='Client Status']")
	private WebElement clientStatusLink;

	// initializing element variable
	public ClientsInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// business library
	public void clickOnClientStatusLink() {
		clientStatusLink.click();
	}

	public void clickOnReqClientStauts(String ClientName) {
		driver.findElement(By.xpath("//tbody//td[.='" + ClientName + "']/following-sibling::td//a[.='Client Status']"))
				.click();
	}
}
