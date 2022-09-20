package org.Agiliux.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Payment2 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[text()='login']")).click();
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("(//a[text()='Client Status'])[1]")).click();
		Thread.sleep(3000);

		String month = "august";
		String amount = "55556";
		String due = "556";
		String fine = "56";
		driver.findElement(By.xpath("//a[text()='Add Payment']")).click();
		driver.findElement(By.name("month")).sendKeys(month);
		driver.findElement(By.name("amount")).sendKeys(amount);
		driver.findElement(By.name("due")).sendKeys(due);
		driver.findElement(By.name("fine")).sendKeys(fine);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		driver.findElement(By.xpath("//a[text()='PAYMENTS']")).click();
		 List<WebElement> list = driver.findElements(By.xpath("//table/tbody//tr[last()]//td"));
		for (WebElement ele : list) {
			String data = ele.getText();
			if (data.equals(month) || data.equals(amount) || data.equals(due) || data.equals(fine)) {
				System.out.println(data+" addaed successfully");
			}
		}

		driver.findElement(By.xpath("//a[@title='Logout']")).click();

	}


}
