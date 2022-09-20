package org.Agiliux.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static WebDriver main(String[] args) {
		String browser = null;
			WebDriver driver = null;
			switch (browser) {
			case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.chromedriver().setup();
				driver=new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.chromedriver().setup();
				driver=new InternetExplorerDriver();
				break;
			default:
				System.out.println("You entered wrong Browser key iin the proprty file");
				break;
			}
			return driver;
		}
			
			
		
			
	}


