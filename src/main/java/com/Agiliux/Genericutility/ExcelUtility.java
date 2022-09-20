package com.Agiliux.Genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public final class ExcelUtility {
	private Workbook workbook;
	Sheet sheet;

	/**
	 * This method is use for Open Excel file
	 * 
	 * @author Maithri Shetty
	 * @param excelpath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void openExcel(String ExcelPath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is use to fetch data from excel
	 * 
	 * @author Nitesh ambastha
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) {
		sheet = workbook.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		return data;
	}

	public String getDataFromExcel(String sheetName, String Requiredkey, String TestCaseName) {
		sheet = workbook.getSheet(sheetName);
		String value = null;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String actualTestcaseName = sheet.getRow(i).getCell(0).getStringCellValue();
			if (actualTestcaseName.equalsIgnoreCase(TestCaseName)) {
				for (int j = 1; j <= sheet.getRow(i).getLastCellNum(); j++) {
					String actualkey = sheet.getRow(1).getCell(j).getStringCellValue();
					if (actualkey.equalsIgnoreCase(Requiredkey)) {
						value = sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					}
					break;
				}
			}
		}
		return value;
	}

	public String getdata(String sheetName, String reKey) {
		sheet = workbook.getSheet(sheetName);
		String value = null;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			if (key.equalsIgnoreCase(reKey)) {
				value = sheet.getRow(i).getCell(1).getStringCellValue();
			break;
			}
		}
		return value;
	}

	/**
	 * this method is use to fetch the data from excel and store into Map
	 * 
	 * @param sheetName
	 * @return
	 */
	public Map<String, String> getDataFromExcelbyMap(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		Map<String, String> map = new HashMap<String, String>();
		DataFormatter df = new DataFormatter();
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
	}

	/**
	 * this method is use to fetch the data from excel and store into list
	 * 
	 * @param sheetName
	 * @return
	 */
	public List<Map<String, String>> getDataFromExcelInList(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		DataFormatter df = new DataFormatter();
		for (int k = 0; k <= sheet.getLastRowNum(); k++) {
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));
			}
			list.add(map);
		}
		return list;
	}

	/**
	 * this method is use tp closse the workbook
	 * 
	 * @author Nitesh ambastha
	 * @throws IOException
	 */

	public void closeExcelworkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is use for set the data into Excel
	 * 
	 * @author Nitesh ambastha
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param text
	 */
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String text) {
		Sheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(rowNum).createCell(cellNum).setCellValue(text);
	}
	
	
//	public String setDataFromExcel(String sheetName, String reKey,String text) {
//		sheet = workbook.getSheet(sheetName);
//		String value = null;
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//			String key = sheet.getRow(i).getCell(1).getStringCellValue();
//			if (key.equalsIgnoreCase(reKey)) {
//				value = sheet.getRow(i).createCell(1).setCellValue(text);
//			break;
//			}
//		}
//		return value;
//		
//	}

	/**
	 * this method is use to save the data into Excel
	 * 
	 * @author Nitesh ambastha
	 * @param outputPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveDataIntoExcel(String outputPath) {
		try {
			workbook.write(new FileOutputStream(outputPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
