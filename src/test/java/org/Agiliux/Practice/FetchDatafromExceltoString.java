package org.Agiliux.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDatafromExceltoString {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 try {
			    Sheet sheet = wb.getSheet("Sheet1");
			    String data = sheet.getRow(0).getCell(0).toString();
			    System.out.println(data);
		} finally {
			// TODO: handle finally clause
		}
		 
	}

}
