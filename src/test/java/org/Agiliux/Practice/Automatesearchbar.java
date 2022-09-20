package org.Agiliux.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Agiliux.Genericutility.ExcelUtility;
import com.Agiliux.Genericutility.FileUtility;
import com.Agiliux.Genericutility.IConstantUtility;
import com.Agiliux.Genericutility.WebDriverUtility;

public class Automatesearchbar {
	public static void main(String[] args) throws IOException {
		WebDriverUtility web = new WebDriverUtility();
		FileUtility file = new FileUtility();
		ExcelUtility excel = new ExcelUtility();
		file.intializePropertyFile(IConstantUtility.Property_File_Path);

		String browser = file.getDataFromProperyfile("browser");
		String url = file.getDataFromProperyfile("url");
		WebDriver driver = web.openBrowserwithApplication(browser, 10,url);

		String username = file.getDataFromProperyfile("username");
		String password = file.getDataFromProperyfile("password");

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();

		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("//a[text()='Add Client']")).click();

		excel.openExcel(IConstantUtility.Excel_Path);
		String ClientPassword = excel.getDataFromExcel("ClientDetails", 1, 1);
		System.out.println(ClientPassword);
		driver.findElement(By.name("client_password")).sendKeys(ClientPassword);
		String Name = excel.getDataFromExcel("ClientDetails", 2, 1);
		String Image = excel.getDataFromExcel("ClientDetails", 3, 1);
		String GENDER = excel.getDataFromExcel("ClientDetails", 4, 1);
		String BirthDate = excel.getDataFromExcel("ClientDetails", 5, 1);
		String MaritalStatus = excel.getDataFromExcel("ClientDetails", 6, 1);
		String NationalID = excel.getDataFromExcel("ClientDetails", 7, 1);
		String Phone = excel.getDataFromExcel("ClientDetails", 8, 1);
		String Address = excel.getDataFromExcel("ClientDetails", 9, 1);
		String PolicyID = excel.getDataFromExcel("ClientDetails", 10, 1);
		String AgentID = excel.getDataFromExcel("ClientDetails", 11, 1);
		driver.findElement(By.name("name")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@class='img']")).sendKeys(Image);
		driver.findElement(By.name("sex")).sendKeys(GENDER);
		driver.findElement(By.name("birth_date")).sendKeys(BirthDate);
		driver.findElement(By.name("maritial_status")).sendKeys(MaritalStatus);
		driver.findElement(By.name("phone")).sendKeys(Phone);
		driver.findElement(By.name("nid")).sendKeys(NationalID);
		driver.findElement(By.name("address")).sendKeys(Address);
		driver.findElement(By.name("policy_id")).sendKeys(PolicyID);
		driver.findElement(By.name("agent_id")).sendKeys(AgentID);
		
		
		String Nname = excel.getDataFromExcel("ClientDetails", 1, 7);
		String NGENDER = excel.getDataFromExcel("ClientDetails", 2, 7);
		String NBirthDate = excel.getDataFromExcel("ClientDetails", 3, 7);
		String NnationalID = excel.getDataFromExcel("ClientDetails", 4, 7);
		String Nrelationship = excel.getDataFromExcel("ClientDetails", 5, 7);
		String Npriority = excel.getDataFromExcel("ClientDetails", 6, 7);
		String Nphone = excel.getDataFromExcel("ClientDetails", 7, 7);
		
		driver.findElement(By.name("nominee_name")).sendKeys(Nname);
		driver.findElement(By.name("nominee_sex")).sendKeys(NGENDER);
		driver.findElement(By.name("nominee_birth_date")).sendKeys(NBirthDate);
		driver.findElement(By.name("nominee_nid")).sendKeys(NnationalID);
		driver.findElement(By.name("nominee_relationship")).sendKeys(Nrelationship);
		driver.findElement(By.name("priority")).sendKeys(Npriority);
		driver.findElement(By.name("nominee_phone")).sendKeys(Nphone);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		driver.findElement(By.xpath("//a[text()='Aegon Life']")).click();
		
		
		String Namech = excel.getDataFromExcel("ClientDetails", 2, 1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Namech);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Client Status']")).click();
		driver.findElement(By.xpath("//a[text()='Edit Client']")).click();
		
		String Imagech = excel.getDataFromExcel("ClientDetails", 3, 1);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Imagech);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Aegon Life']")).click();
		if (driver.findElement(By.xpath("td[text()='Rahul']")).getText().equals(Namech)) {
			System.out.println(" client is added");
			
		} else {
			System.out.println("client is not added");

		}
		driver.close();
	}
	

}
