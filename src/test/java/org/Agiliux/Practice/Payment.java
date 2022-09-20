package org.Agiliux.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Payment {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[text()='login']")).click();

		String s1 = driver.findElement(By.xpath("(//h5)[2]")).getText();
		String s2 = s1.replaceAll("[^0-9]", "");
		int n1 = Integer.parseInt(s2);
		System.out.println(n1);

		driver.findElement(By.xpath("//a[text()='PAYMENTS']")).click();
		driver.findElement(By.xpath("//a[text()='Add Payment']")).click();
		driver.findElement(By.name("client_id")).sendKeys("789459");
		driver.findElement(By.name("month")).sendKeys("august");
		driver.findElement(By.name("amount")).sendKeys("55555");
		driver.findElement(By.name("due")).sendKeys("5555");
		driver.findElement(By.name("fine")).sendKeys("555");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		driver.findElement(By.xpath("//a[text()='Aegon Life']")).click();

		String s3 = driver.findElement(By.xpath("(//h5)[2]")).getText();
		String s4 = s3.replaceAll("[^0-9]", "");
		int n2 = Integer.parseInt(s4);
		System.out.println(n2);

		if (n2 == n1 + 1) {
			System.out.println("passed: payment record increased");

		}
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
	}

}
