package org.Agiliux.Practice;

import java.util.Map;

import org.Agiliux.LifeInsurenceObjectRepositery.AddClientPage;
import org.Agiliux.LifeInsurenceObjectRepositery.ClientStatusPage;
import org.Agiliux.LifeInsurenceObjectRepositery.CommonPage;
import org.Agiliux.LifeInsurenceObjectRepositery.LoginPage;
import org.openqa.selenium.WebDriver;

import com.Agiliux.Genericutility.ExcelUtility;
import com.Agiliux.Genericutility.FileUtility;
import com.Agiliux.Genericutility.IConstantUtility;
import com.Agiliux.Genericutility.WebDriverUtility;

public class AutomateSearchclientAndDeletePOM {
	public static void main(String[] args) {

		ExcelUtility excel = new ExcelUtility();
		FileUtility file = new FileUtility();
		WebDriverUtility web = new WebDriverUtility();

		file.intializePropertyFile(IConstantUtility.Property_File_Path);

		String browser = file.getDataFromProperyfile("browser");
		String url = file.getDataFromProperyfile("url");
		WebDriver driver = web.openBrowserwithApplication(browser, 10, url);

		String username = file.getDataFromProperyfile("username");
		String password = file.getDataFromProperyfile("password");

		LoginPage login = new LoginPage(driver);
		CommonPage comman = new CommonPage(driver);
		AddClientPage client = new AddClientPage(driver);
		ClientStatusPage status = new ClientStatusPage(driver);

		login.loginAction(username, password);
		comman.Client();
		excel.openExcel(IConstantUtility.Excel_Path);
		
		Map<String, String> map = excel.getDataFromExcelbyMap("ClientDetails");
		client.addClientfromexcel(map);
		
		String clientID = client.checkclientId();
		System.out.println(clientID);
  
		Map<String, String> map1 = excel.getDataFromExcelbyMap("NomineeDetails");
		client.addNomineeFromexcel(map1);
		
		
		comman.homePage();
		comman.searchBox(excel.getdata("ClientDetails", "Name"));
		comman.clickclientstatus();

		status.editClient();
		status.deleteclient();
		comman.homePage();
		comman.searchBox(excel.getdata("ClientDetails", "Name"));

		if (client.checkclientId()== clientID) {
			System.out.println("TC----is fail");

		} else {
			System.out.println("TC--is pass");
		}
		excel.closeExcelworkbook();
		web.closeBrowser(driver);

	}

}
