package org.Agiliux.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDatafromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// step 1--> convert the physical file into java readable object
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/Testdata.xlsx");
		// steo 2--> open the Excel workbook
		Workbook wb = WorkbookFactory.create(fisExcel);
		// step 3--> get the control on sheet
		Sheet sheet = wb.getSheet("CommonData");
		// step 4--> get the control on row
		Row row = sheet.getRow(2);
		// step 5--> get the control on cell
		Cell cell = row.getCell(1);
		// step 6--> fetch the deta
		String username = cell.getStringCellValue();
		// step 7--> close the workbook
		System.out.println(username);
		wb.close();

	}

}
