package com.org.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.org.utility.ConfigDataProvider;

public class BookingActivityPage {
	
	public WebDriver driver;
	public ConfigDataProvider config;
	
	
	public BookingActivityPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(id="Username") WebElement uname;//
	@FindBy(id="Password") WebElement pass;
	@FindBy(name="button") WebElement loginButton;
	@FindBy(className="custom-navbar-toggler") WebElement bar;
	@FindBy(id="searchInput") WebElement search;
	@FindBy(id="SearchBooking") WebElement searchBooking;
	@FindBy(id="txtSearchInvoice") WebElement mainSearchInvoiceTextBox;//In Create Invoice Tab
	@FindBy(id="SearchInvoice") WebElement SearchInvoiceButton;
	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm']") WebElement okButton;
	@FindBy(xpath = "//div[@class='swal-text']") WebElement alertmsg;	
	@FindBy(id="AddNew") WebElement newButton;
	@FindBy(id="ChargesDetailsTab") WebElement chargesDetailsTab;
	@FindBy(id="AddNewCharge") WebElement addNewChargeButton;
	@FindBy(id="ChargeName") WebElement chargeNameTB;
	@FindBy(id="AmountReceivable") WebElement amountReceivableTB;
	@FindBy(id="ReceivableCurrency") WebElement receivableCurrency; //AmountPayable
	@FindBy(id="AmountPayable") WebElement amountPayable;
	@FindBy(id="ChargePaymentTerms") WebElement chargePaymentTerms;
	@FindBy(id="PayableTo") WebElement payableTo;
	@FindBy(id="ChargeRemarks") WebElement chargeRemarks;//AddChargeInBookingNo
	@FindBy(xpath="//label[@for='AddChargeInBookingYes']") WebElement noRadioButton;
	@FindBy(id="PayableCurrency") WebElement payableCurrency;//
	@FindBy(id="AddNewChargeToInvoice") WebElement addNewChargeToInvoice;
	@FindBy(xpath=".//*[@id='ui-id-1']/li") WebElement selectDetention;
	@FindBy(id="PerContainerReceivableAmount_1") WebElement perContainerReceivableAmount_1;
	@FindBy(id="PerContainerReceivableAmount_2") WebElement perContainerReceivableAmount_2;
	@FindBy(id="PerContainerReceivableAmount_3") WebElement perContainerReceivableAmount_3;
	@FindBy(id="PerContainerReceivableAmount_4") WebElement perContainerReceivableAmount_4;
	@FindBy(id="SaveInvoice") WebElement saveInvoice;
	@FindBy(id="SendMailToCustomer") WebElement sendMailToCustomer; //SaveCreditNote
	@FindBy(id="ToMailAddress") WebElement toMailAddress; 
	@FindBy(id="CCMailAddress") WebElement ccMailAddress; 
	@FindBy(id="SendMail") WebElement sendMail; 
	@FindBy(id="CancelFullInvoice") WebElement cancelFullInvoice; 
	@FindBy(id="SavereditNote") WebElement saveCreditNote; //CancelFullInvoice
	@FindBy(id="CloseSendMailModal") WebElement closeSendMailModal;

	
	public void login(String username, String password) 
	{
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
	}
	
	public void searchItem(String item) throws InterruptedException 
	{
		bar.click();
		Thread.sleep(500);
		search.sendKeys(item);
		List<WebElement> list = driver.findElements(By.id("sidebarMenu"));
		for(WebElement element : list) 
		{
			if(element.getText().contains(item)) 
			{
			  element.findElement(By.partialLinkText(item)).click();
			}
		}
		Thread.sleep(2000);
	}
	
	
	//Library for inputing the Data

	public void invoiceSearchTextBoxData(double data) throws Exception 
	{ 
		mainSearchInvoiceTextBox.sendKeys(String.valueOf(data));
		SearchInvoiceButton.click();
		Thread.sleep(500);
		System.out.println("Message from invoiceSearchTextBox() : "+"!!!!!! "+alertmsg.getText()+ " !!!!!!");
		String actualData = alertmsg.getText();
		okButton.click();
		mainSearchInvoiceTextBox.clear();
		String expextedData = "No Records Found for Booking No.";
		Assert.assertEquals(actualData, expextedData);
   }
	
	public void invoiceSearchTextBoxData(String randomString) throws Exception 
	{ 
		mainSearchInvoiceTextBox.sendKeys(randomString);//done
		SearchInvoiceButton.click();
		Thread.sleep(500);
		System.out.println("Message from invoiceSearchTextBox() : "+"!!!!!! "+alertmsg.getText()+ " !!!!!!");
		String actualData = alertmsg.getText();
		okButton.click();
		mainSearchInvoiceTextBox.clear();
		String expextedData = "No Records Found for Booking No.";
		Assert.assertEquals(actualData, expextedData);
   }
	public void SearchTextBoxBlankData() throws Exception 
	{ 
		mainSearchInvoiceTextBox.clear();
		SearchInvoiceButton.click();
		Thread.sleep(2000);
		System.out.println("Message from invoiceSearchTextBoxBlankData : "+"!!!!!! "+alertmsg.getText()+ " !!!!!!");
		String actualData = alertmsg.getText();
		okButton.click();
		String expextedData = "Please enter the Booking No.";
		Assert.assertEquals(actualData, expextedData);
   }
	public void SearchTextBoxCorrectData(int d) throws Exception 
	{ 
		mainSearchInvoiceTextBox.sendKeys(String.valueOf(d));
		SearchInvoiceButton.click();
		Thread.sleep(1000);
		//System.out.println("Message From SearchTextBoxCorrectData() : "+"Data Entered Correctly...!");
   }
	
	public String generateInvoice(String chargeName) throws Exception 
	{
//		WebDriverWait wait = new WebDriverWait(driver,3000);
//		wait.until(ExpectedConditions.elementToBeClickable(okButton));
		Thread.sleep(4000);
      newButton.click();
	  Thread.sleep(1000);

     Select FY = new Select(driver.findElement(By.id("FinancialYear")));
	 Thread.sleep(500);
	  FY.selectByVisibleText("20-21");
	  Thread.sleep(500);

      chargesDetailsTab.click();
	  Thread.sleep(500);

      addNewChargeButton.click();
      Thread.sleep(1000);
      chargeNameTB.sendKeys(chargeName);
      Thread.sleep(1000);
      
      
      List<WebElement> list1 = driver.findElements(By.xpath(".//*[@id='ui-id-1']/li"));
    		  
		for(WebElement element : list1) 
		{
			System.out.println(element.getText());
			element.click();
			Thread.sleep(500);
			break;
		}
               
     
	  Select se = new Select(receivableCurrency);
	 Thread.sleep(500);
	  se.selectByVisibleText("USD");
	  Thread.sleep(500);
	   
	  Select se1 = new Select(payableCurrency);
	 Thread.sleep(500);
	  se1.selectByVisibleText("USD");
	  
	  Select se2 = new Select(chargePaymentTerms);
	 Thread.sleep(500); // ContainerRequirementDetailsForInvoice
	  se2.selectByVisibleText("Prepaid");
	  
	  payableTo.sendKeys("Arjun");
	  chargeRemarks.sendKeys("No Remark Needed");
	 // noRadioButton.click();
	  Thread.sleep(1000);
	  
//	  List<WebElement> NoOfCont =  driver.findElements(By.xpath("//*[contains(@id,'perContainerReceivableAmount')]"));
//	  for(WebElement individualContainer : NoOfCont) 
//	  {
//		  System.out.println("No. of Container "+individualContainer.getSize());
//	  }
//	  
	  perContainerReceivableAmount_1.clear();
	  Thread.sleep(1000);
	  perContainerReceivableAmount_1.sendKeys("1507");
//	  Thread.sleep(1000);
	  perContainerReceivableAmount_2.clear();
	  Thread.sleep(1000);
	  perContainerReceivableAmount_2.sendKeys("1600");
//	  Thread.sleep(1000);
//	  perContainerReceivableAmount_3.clear();
//	  Thread.sleep(1000);
//	  perContainerReceivableAmount_3.sendKeys("4500");
//	  Thread.sleep(500);
//      JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("window.scrollBy(0,1000)");
//      Thread.sleep(1000);
//      perContainerReceivableAmount_4.clear();
//	  perContainerReceivableAmount_4.sendKeys("4500");
//	  Thread.sleep(1000);
      addNewChargeToInvoice.click();
	  Thread.sleep(1000);
	  WebElement Inv_amount = driver.findElement(By.id("InvoiceAmount"));
		 Thread.sleep(2000);
		
		  System.out.println("Invoice generated Succesfully of Amount ="+"Eur "+Inv_amount.getText());
	  saveInvoice.click();
	  Thread.sleep(2000);
	  okButton.click();
	  Thread.sleep(8000);
	  String currentWindowHandle= driver.getWindowHandle();
	  driver.switchTo().window(currentWindowHandle);//-----------
	  Thread.sleep(5000);
	 
	 
//	  sendMailToCustomer.click();
//	  toMailAddress.clear();
//	  ccMailAddress.clear();
//      Thread.sleep(2000);
//      toMailAddress.sendKeys("mallikarjun.shivsharan@sharpitech.in");
//      Thread.sleep(3000);
//      JavascriptExecutor j = (JavascriptExecutor) driver;
//      j.executeScript("window.scrollBy(0,1200)");
//      Thread.sleep(3000);
//      sendMail.click();
//      Thread.sleep(4000);
//	  okButton.click();
//      Thread.sleep(10000);
//      closeSendMailModal.click();
	  
return Inv_amount.getText();
     }

	
	public String generateCreditNotes() throws Exception 
	{
		Thread.sleep(2000);
		chargesDetailsTab.click();
		//Thread.sleep(4000);
		WebElement CN_amount = driver.findElement(By.id("InvoiceAmount"));
		Thread.sleep(1000);
		System.out.println("Credit Note generated Succesfully of Amount = "+CN_amount.getText());
		
		cancelFullInvoice.click();
		Thread.sleep(3000);
		saveCreditNote.click();
//		Thread.sleep(3000);
		okButton.click();
		Thread.sleep(1000);
		String currentWindowHandle= driver.getWindowHandle();
		driver.switchTo().window(currentWindowHandle);
		Thread.sleep(5000);
		
		
		
		Thread.sleep(2000);
//		sendMailToCustomer.click();
//		toMailAddress.clear();
//		ccMailAddress.clear();
//	    Thread.sleep(2000);
//	    toMailAddress.sendKeys("mallikarjun.shivsharan@sharpitech.in");
//	    Thread.sleep(2000);
//	    JavascriptExecutor j = (JavascriptExecutor) driver;
//	    j.executeScript("window.scrollBy(0,1200)");
//	    Thread.sleep(2000);
//	    sendMail.click();
//	    Thread.sleep(5000);
//		okButton.click();
		return CN_amount.getText();
		
//	    
	    
	}
	
}


    









