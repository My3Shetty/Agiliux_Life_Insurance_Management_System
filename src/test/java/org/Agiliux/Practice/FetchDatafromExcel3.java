package org.Agiliux.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDatafromExcel3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/test cases.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		try {
			Sheet sheet = wb.getSheet("Tracibility");
			      Cell cell = sheet.getRow(46).getCell(03);
			   String data = df.formatCellValue(cell);
			   System.out.println(data);
			
		} finally { 
			wb.close();
		}
		
	}

}
