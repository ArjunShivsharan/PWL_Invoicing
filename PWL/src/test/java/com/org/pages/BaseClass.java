package com.org.pages;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.utility.BrowserFactory;
import com.org.utility.ConfigDataProvider;
import com.org.utility.Helper;

public class BaseClass 
{
  public WebDriver driver;
  public ConfigDataProvider config;
  public ExtentReports report;
  public ExtentTest logger;
 
//  public int methodCount ;
//  int c=1;
//  String name;
  
  @BeforeSuite
  public void setUpSuite() 
  {
	  config = new ConfigDataProvider();
	  ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\reports\\PWL_report_"+Helper.getCurrentDateTime()+".html"));
	  report = new ExtentReports();
	  report.attachReporter(extent);
  }
  
  @BeforeClass
  public void setUp() 
  {
	  driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
  }
  
  @AfterMethod
  public void tearDownReports(ITestResult result) throws IOException 
  {
	  
	  //methodCount =c++;
	  
	  
	  if(result.getStatus()==ITestResult.FAILURE) 
	  {
		  logger.fail("Incorrect details, Please enter Valid details..!", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		  
	  }
	  else if(result.getStatus()==ITestResult.SUCCESS) 
	  {
		  logger.pass("Executed Succesfully..!");
	  }
	report.flush();	  
}
  
  @AfterClass
  public void tearDown()  
  {
	 
	    BrowserFactory.quitBrowser(driver);
  }
  
//  @AfterSuite
//  public void getMethodCount(String m) throws IOException 
//  {
////	  WriteStatus w = new WriteStatus();
////	  w.WStatus(methodCount);
//  }
}

