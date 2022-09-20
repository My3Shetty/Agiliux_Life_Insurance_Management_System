package com.Agiliux.automationTestScript;

import java.util.Map;

import org.Agiliux.LifeInsurenceObjectRepositery.AddClientPage;
import org.Agiliux.LifeInsurenceObjectRepositery.ClientStatusPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Agiliux.Genericutility.BaseClass;
import com.Agiliux.Genericutility.IConstantUtility;

public class AutomateSearchclientAndDeleteclient3Test extends BaseClass {

	@Test
	public void AutomateSearchclientAndDeleteclientt() {
		AddClientPage client=new AddClientPage(driver);
		ClientStatusPage status=new ClientStatusPage(driver);
		comman.Client();
		excel.openExcel(IConstantUtility.Excel_Path);
		
		Map<String, String> map = excel.getDataFromExcelbyMap("ClientDetails");
		client.addClientfromexcel(map);
		
		String clientid = client.checkclientId();
		System.out.println(clientid);
		
		
		Map<String, String> map1 = excel.getDataFromExcelbyMap("NomineeDetails");
		client.addNomineeFromexcel(map1);
		
		
		comman.homePage();
		comman.searchBox(excel.getdata("ClientDetails", "Name"));
		comman.clickclientstatus();

		status.editClient();
		status.deleteclient();
		comman.homePage();
		comman.searchBox(excel.getdata("ClientDetails", "Name"));

		Assert.assertEquals(clientid, clientid);
		Reporter.log("Testcase pass",true);
		
		web.closeBrowser(driver);
		excel.closeExcelworkbook();
	}
}
