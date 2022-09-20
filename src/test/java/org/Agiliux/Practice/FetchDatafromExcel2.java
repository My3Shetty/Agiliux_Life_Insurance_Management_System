package org.Agiliux.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDatafromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try {
		   Sheet sheet = wb.getSheet("Sheet1");
		       int data = (int)sheet.getRow(0).getCell(0).getNumericCellValue();
		        System.out.println(data);
		}
		finally {
			wb.close();
		}
	}

}
