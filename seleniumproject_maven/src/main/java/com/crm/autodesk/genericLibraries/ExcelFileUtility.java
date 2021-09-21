package com.crm.autodesk.genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * this class contains generic method to read and writ data from excel
 * @author sah
 * 
 */

public class ExcelFileUtility {
	/*
	 * 
	 * this method to use data from excel sheet
	 * @return
	 * @thorws thorwable
	 * 
	 */
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		DataFormatter Df=new DataFormatter();
		Row row=sheet.getRow(rownum);
		Cell cell= row.getCell(cellnum);
		String value=Df.formatCellValue(cell);
		
		return value;
		
		
		
		
		
		
	}
	

}
