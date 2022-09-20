package org.Agiliux.LifeInsurenceObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	 @FindBy(name = "username") private WebElement usernameTextField;
	 @FindBy(name="password") private WebElement passwordTextField;
	 @FindBy(xpath = "//button") private WebElement loginbutton;
	 
	 
	 public LoginPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void loginAction(String username, String password ) {
		 usernameTextField.sendKeys(username);
		 passwordTextField.sendKeys(password);
		 loginbutton.click();
	 }
	 
	 
}
