package org.Agiliux.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerAutomate {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		 String exporgName = "tcs";
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		 List<WebElement> Orglist = driver.findElements(By.xpath("//table[@class='lvt small']//tr//a[@tittle='Organizations']"));
		 
		 for (WebElement Org: Orglist) {
			String OrgName = Org.getText();
			if (OrgName.equals(exporgName)) {
				driver.findElement(By.xpath("//a[text()='"+exporgName+"']/parent::td/preceding-sibling::td/input")).click();
				break;
				
			}
		}
			driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
			driver.switchTo().alert().accept();
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='status']/img"))));
			
			
			
			
			
		}

	

	}


