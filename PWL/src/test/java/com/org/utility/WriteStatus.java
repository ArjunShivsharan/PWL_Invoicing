package com.org.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.org.pages.BaseClass;

public class WriteStatus extends BaseClass {

	XSSFWorkbook workbook;
	XSSFSheet statusSheet;
	XSSFRow row;
	String testname;
	Method method;
	
	public WriteStatus()
	{
		workbook = new XSSFWorkbook();
		statusSheet = workbook.createSheet();
		row = statusSheet.createRow(0);
		row.createCell(0).setCellValue("Sr.No");
		row.createCell(1).setCellValue("Method Name");
		row.createCell(2).setCellValue("Description");
		row.createCell(3).setCellValue("Status");
	}
	public void WStatus(int s1) throws IOException {
		
		    
	    for(int i=1;i<=s1;i++) 
	    {
	    	row = statusSheet.createRow(i);
	    	row.createCell(0).setCellValue(i);
	    }
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Mallikarjun.Shivshar\\Desktop\\Project_Reports\\Status_Report.xlsx");
		workbook.write(fos);
	}
	
    
}