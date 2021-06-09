package com.org.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.org.pages.BaseClass;
import com.org.pages.BookingActivityPage;

public class BookingActivityPageTest extends BaseClass
{
	
	public BookingActivityPage baPage;
	
   @Test(priority=1)
   public void loginApp() 
   {
	   logger = report.createTest("1.TestName: loginApp()");
	   baPage = PageFactory.initElements(driver, BookingActivityPage.class);
	   baPage.login(config.getUsername(),config.getPassword()); 
   }
   
   @Test(priority=2)
   public void searchItemTest() throws InterruptedException 
   {
	   logger = report.createTest("2.This Test will search Item in Side Bar");
	   baPage.searchItem(config.getItemFromCofigFile());
	   Thread.sleep(2000);

   }
   
   @Test(priority=3)
   public void invoiceSearchTextBoxStringDataTest() throws Exception 
   {
	   logger = report.createTest("3.This Test will try to find the Principle Booking No. by string value");
       baPage.invoiceSearchTextBoxData(config.getStringValueFromCofigFile());
   }
   @Test(priority=4)
   public void invoiceSearchTextBoxIntegerDataTest() throws Exception 
   {
	   logger = report.createTest("4.This Test will try to find the Principle Booking No. by Integer value");
       baPage.invoiceSearchTextBoxData(config.getNumericValueFromCofigFile());
   }
   @Test(priority=5)
   public void SearchTextBoxBlankDataTest() throws Exception 
   {
	   logger = report.createTest("5.This Test will try to find the Principle Booking No. by Blank value");
	   baPage.SearchTextBoxBlankData();
   }
  
   
   @Test(priority=6)
   public void invoiceSearchTextBoxSpecialCharacterTest() throws Exception 
   {
	  logger = report.createTest("6.This Test will try to find the Principle Booking No. by Special Character value");
	  baPage.invoiceSearchTextBoxData(config.getSpecialCharacterValueFromCofigFile());
   }
   @Test(priority=7)
   public void invoiceSearchTextBoxCorrectDataTest() throws Exception 
   {
	  logger = report.createTest("7.This Test will try to find the Principle Booking No. by correct Principle Booking No.");
	  baPage.SearchTextBoxCorrectData(config.getCorrectValueFromCofigFile());
   }
   @Test(priority=8)
   public void generateInvoiceTest() throws Exception 
   {
	  logger = report.createTest("8.This Test will Generate Invoice and send Email");
	  baPage.generateInvoice(config.getChargeName());

	}
   @Test(priority=9)
   public void  generateCreditotesTest() throws Exception 
   {
	   Thread.sleep(3000);
	   logger = report.createTest("9.This Test will Cancel  Invoice, Generate Credit Notes and send Email");
	   baPage.searchItem(config.getItemFromCofigFile());
	   baPage.SearchTextBoxCorrectData(config.getCorrectValueFromCofigFile());
	   Thread.sleep(3000);
	   		  
   }
   
}
