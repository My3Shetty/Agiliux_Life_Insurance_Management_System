package org.Agiliux.LifeInsurenceObjectRepositery;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Agiliux.Genericutility.ExcelUtility;

public class AddClientPage {
	private static final String String = null;
	// private WebDriver driver;

	// private String dynamicXpath=""

	@FindBy(name = "client_id")
	private WebElement clientID;
	@FindBy(name = "client_password")
	private WebElement clientPassword;
	@FindBy(xpath = "//a[text()='Add Client']")
	private WebElement addClient;
	@FindBy(name = "name")
	private WebElement name;
	@FindBy(xpath = "//input[@class='img']")
	private WebElement image;
	@FindBy(name = "sex")
	private WebElement Gender;
	@FindBy(name = "birth_date")
	private WebElement Birthdate;
	@FindBy(name = "maritial_status")
	private WebElement MaritalStatus;
	@FindBy(name = "phone")
	private WebElement Phone;
	@FindBy(name = "nid")
	private WebElement NationalID;
	@FindBy(name = "address")
	private WebElement Address;
	@FindBy(name = "policy_id")
	private WebElement PolicyID;
	@FindBy(name = "agent_id")
	private WebElement AgentID;

	@FindBy(name = "nominee_name")
	private WebElement Nname;
	@FindBy(name = "nominee_sex")
	private WebElement Ngender;
	@FindBy(name = "nominee_birth_date")
	private WebElement Nbirthdate;
	@FindBy(name = "nominee_nid")
	private WebElement NnationalID;
	@FindBy(name = "nominee_relationship")
	private WebElement Nreletionship;
	@FindBy(name = "priority")
	private WebElement Npriorty;
	@FindBy(name = "nominee_phone")
	private WebElement Nphone;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	public AddClientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkclientId() {
		String s1 = clientID.getAttribute("value");
		return s1;
	}
	
	
	public void addClientfromexcel(Map<String, String> map) {

	
		addClient.click();
		clientPassword.sendKeys(map.get("Client_Password"));
		name.sendKeys(map.get("Name"));
		image.sendKeys(map.get("Image"));
		Gender.sendKeys(map.get("Gender"));
		Birthdate.sendKeys(map.get("Birth Date"));
		MaritalStatus.sendKeys(map.get("Marital Status"));
		Phone.sendKeys(map.get("Phone"));
		NationalID.sendKeys(map.get("National ID"));
		Address.sendKeys(map.get("Address"));
		PolicyID.sendKeys(map.get("Policy ID"));
		//AgentID.sendKeys(map.get("Agent ID"));
	}	
		public void addNomineeFromexcel(Map<String, String> map) {
		
		Nname.sendKeys(map.get("Name"));
		Ngender.sendKeys(map.get("Gender"));
		Nbirthdate.sendKeys(map.get("BirthDate"));
		NnationalID.sendKeys(map.get("National ID"));
		Nreletionship.sendKeys(map.get("Relationship"));
		Npriorty.sendKeys(map.get("Priority"));
		Nphone.sendKeys(map.get("Phone"));
		submit.click();


	}
	}
	

