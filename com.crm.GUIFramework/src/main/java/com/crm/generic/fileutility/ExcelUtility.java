package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcelFile(String sheetname,int rowno,int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/testscriptsdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row=sheet.getRow(rowno);
		Cell cell = row.getCell(column);
		return  cell.toString();
	}

}
