package org.Agiliux.Practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class popup {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("file:///C:/Users/NItesh%20ambastha/Desktop/Naukri.html");
		
		File f=new File("./src/test/resources/amazon.png");
		String absolute = f.getAbsolutePath();
		driver.findElement(By.id("cv")).sendKeys(absolute);
	}

}
