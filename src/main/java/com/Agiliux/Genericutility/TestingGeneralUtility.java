package com.Agiliux.Genericutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class TestingGeneralUtility {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		new ExcelUtility().openExcel(IConstantUtility.Excel_Path);
		//String data=new ExcelUtility().getDataFromExcel(IConstantUtility, Excel_path, cellNum)
	}

}
