package org.Agiliux.Practice;

import java.util.List;
import java.util.Map;

import com.Agiliux.Genericutility.ExcelUtility;
import com.Agiliux.Genericutility.IConstantUtility;

public class fetchDatafromexcelthrouhgLiatMap {

	public static void main(String[] args) {
		
		ExcelUtility excel=new ExcelUtility();
		excel.openExcel(IConstantUtility.Excel_Path);
		List<Map<String, String>> list = excel.getDataFromExcelInList("ClientDetails");
		System.out.println(list.get(1).get("Name:"));
		System.out.println(list.get(6).get("Name:"));
		System.out.println(list.get(7).get("Name"));
		System.out.println(list.get(4).get("GENDER::"));
	}

}
