package com.org.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigDataProvider {
	
	XSSFSheet sheet1;
	XSSFWorkbook wb;

	public ConfigDataProvider() 
	{
		try 
		{
			File source = new File(System.getProperty("user.dir")+"\\testData\\DataSheet.xlsx");
			FileInputStream fis = new FileInputStream(source);
			wb = new XSSFWorkbook(fis);
			sheet1 =wb.getSheetAt(0);
		} 
		catch (Exception e) 
		{
			System.out.println("Not able to Load Excel File : "+e.getMessage());
		} 
	}
	
	
	public String getChargeName() 
	{
		return sheet1.getRow(11).getCell(1).getStringCellValue();
	}
	public String getBrowser() 
	{
		return sheet1.getRow(0).getCell(1).getStringCellValue();
	}
	
	public String getStagingURL() 
	{
		return sheet1.getRow(1).getCell(1).getStringCellValue();
	}
	public String getUsername() 
	{
		return sheet1.getRow(2).getCell(1).getStringCellValue();
	}
	public String getPassword() 
	{
		return sheet1.getRow(3).getCell(1).getStringCellValue();
	}
	public String getItemFromCofigFile() 
	{
		String actualitems = sheet1.getRow(4).getCell(1).getStringCellValue();
		String firstLetter = actualitems.substring(0, 1);
	    String remainingLetters = actualitems.substring(1, actualitems.length());
	    firstLetter = firstLetter.toUpperCase();
	    actualitems = firstLetter + remainingLetters;
		return actualitems;
	}
	public int getCorrectValueFromCofigFile() 
	{
		return (int)sheet1.getRow(10).getCell(1).getNumericCellValue();
	}
	public double getNumericValueFromCofigFile() 
	{
		return sheet1.getRow(8).getCell(1).getNumericCellValue();
	}
	public String getAlphaNumericValueFromCofigFile() 
	{
		return sheet1.getRow(7).getCell(1).getStringCellValue();
	}
	public String getStringValueFromCofigFile() 
	{
		return sheet1.getRow(9).getCell(1).getStringCellValue();
	}
	public String getSpecialCharacterValueFromCofigFile() 
	{
		return sheet1.getRow(6).getCell(1).getStringCellValue();
	}
	public String getBlankValueFromCofigFile() 
	{
		return sheet1.getRow(12).getCell(1).getStringCellValue();
	}
}
