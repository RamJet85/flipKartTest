package com.qa.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	// I don't give this information anyone so make it private
	private static String TEST_DATA_SHEET_PATH = "./src/main/java/com/qa/FraudShare/testdata/FraudShare_TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		
		// Object data[][] = new Object[rows][columns];
         // Object data[][] = null; 
		// data = new Object[3][2];
		
		Object data[][] = null;// we don't know the exact count so initially it is 0
		
		try {
			FileInputStream fs = new FileInputStream(ExcelUtils.TEST_DATA_SHEET_PATH);// It is used to connect with the excel file
			
			try {
				book = WorkbookFactory.create(fs);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//To interact with file we use workbook factory class, we have reached to workbook
			
			sheet = book.getSheet(sheetName);//Using this sheet we have reached to actual sheet, Import from ss user model
			
			int totalRows = sheet.getLastRowNum(); // give the total rows
			
			System.out.println("The total rows are: "+totalRows);
			
			short totalColumns = sheet.getRow(0).getLastCellNum(); // give the total columns in the row
			
			System.out.println("The total columns are: "+totalColumns);
			
			//To get the data from excel we use Object 2D array
			
			data = new Object[totalRows][totalColumns]; //two dimensional object array look like a matrix 
			//Here by object array we are converting the excel sheet data into java object form
			//To get the data we should iterate the excel data file
			
			for(int i=0;i<totalRows;i++) {
				
				for(int j=0;j<totalColumns;j++) {
					
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();// storing the data into data object
					//Converting all the excel data into string
					
				}
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
	}
	

}