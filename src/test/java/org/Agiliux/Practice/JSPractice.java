package org.Agiliux.Practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPractice {

	public static void main(String[] args) {
     
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		js.executeScript("window.location='http://rmgtestingserver/domain/Life_Insurance_Management_System/home'");
		//driver.get("http://loacalhost:8888");
		
	}

}
