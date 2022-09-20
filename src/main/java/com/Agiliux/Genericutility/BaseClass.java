package com.Agiliux.Genericutility;

import org.Agiliux.LifeInsurenceObjectRepositery.CommonPage;
import org.Agiliux.LifeInsurenceObjectRepositery.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	protected WebDriver driver;
	protected ExcelUtility excel;
	protected FileUtility file;
	protected WebDriverUtility web;
	private String username;
	private String password;
	protected LoginPage login; 
	protected CommonPage comman;
	protected JavaUtility java;
	public static JavaUtility sjavautility;
	public static WebDriver sdriver;
	
	@Parameters("browser")
	@BeforeClass(groups = {"sanity","regression"})
	public void classSetup() {
		 excel=new ExcelUtility();
		 file = new FileUtility();
		 web = new WebDriverUtility();
		  java=new JavaUtility();
		 sjavautility = java;
		file.intializePropertyFile(IConstantUtility.Property_File_Path);
		excel.openExcel(IConstantUtility.Excel_Path);

		String browser = file.getDataFromProperyfile("browser");
		String url = file.getDataFromProperyfile("url");
		driver = web.openBrowserwithApplication(browser, 10, url);
		sdriver=driver;
		 username = file.getDataFromProperyfile("username");
		 password = file.getDataFromProperyfile("password");
		 login = new LoginPage(driver);
		 comman = new CommonPage(driver);
		 
	}
	
	@BeforeMethod (groups = {"sanity","regression"})
	public void methodSetup() {
		login.loginAction(username, password);
	}
	
	@AfterMethod(groups = {"sanity","regression"})
	public void methodtearDown() {
		comman.logout();
	}
	@AfterClass(groups = {"sanity","regression"})
	public void classTeardown() {
		web.closeBrowser(driver);
		excel.closeExcelworkbook();
	}
}
