package com.Agiliux.automationTestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Agiliux.Genericutility.WebDriverUtility;

public class MavenPracticeTest {
	@Test(groups="Sanity")
	public void step1Test()
	{
		String browser=System.getProperty("b");
		String url=System.getProperty("u");
		System.out.println("Browser name is=======>>>>>>>"+browser);
		System.out.println("URL is =======>>>>>>>>>>  " +url);
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		WebDriver driver = webDriverUtility.openBrowserwithApplication(browser,10l,url);
		driver.close();
	
	}

} 
