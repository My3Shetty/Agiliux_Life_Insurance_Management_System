package org.Agiliux.Practice;

import org.Agiliux.LifeInsurenceObjectRepositery.AddClientPage;
import org.Agiliux.LifeInsurenceObjectRepositery.ClientStatusPage;

import com.Agiliux.Genericutility.BaseClass;
import com.Agiliux.Genericutility.IConstantUtility;

public class Payments1TEstNG  extends BaseClass{
	
	
	public void AutomateSearchclientAndDeleteclient() {
		AddClientPage client = new AddClientPage(driver);
		ClientStatusPage status = new ClientStatusPage(driver);
		comman.Client();
		excel.openExcel(IConstantUtility.Excel_Path);
	}

}
