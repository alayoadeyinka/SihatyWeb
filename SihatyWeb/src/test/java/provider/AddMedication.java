 package provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import utils.log;
import utils.utility;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileNotFoundException;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
public class AddMedication extends utility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
 log.info("-----------------------------------------START TEST- Add Medication--------------------------------------------------------------");

 		 try {
			utilityclass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 @SuppressWarnings("rawtypes")
	@Test
	
	public void testNewConsultation( ) throws Exception {
		 
		  String filePath = System.getProperty("user.dir");
 	  FileInputStream fis = new FileInputStream(filePath+"/config/Testdata.xlsx");
      
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		  XSSFSheet sheet = workbook.getSheet("Patients");
		  XSSFSheet sheets = workbook.getSheet("Consultation");
		  XSSFSheet sheetss = workbook.getSheet("Chat");
		  Row PatientName = sheet.getRow(1);
		  Cell cell1 = PatientName.getCell(1);
		  String PatientNames  = cell1.getStringCellValue();
  	  
		  Row FirstMess = sheetss.getRow(1);
		  Cell cell9 = FirstMess.getCell(1);
		  String FirstMessage  = cell9.getStringCellValue();
 
		  Row SecondMess = sheetss.getRow(2);
		  Cell cell10 = SecondMess.getCell(1);
		  String SecondMessage  = cell10.getStringCellValue();
		 	  
		Thread.sleep(2000);	
		 
   driver.findElement(By.xpath(objectrepo.getProperty("ProfileTab"))).click(); 
 	 
  driver.findElement(By.xpath(objectrepo.getProperty("PatientTab"))).click(); 
		  Thread.sleep(2000);	
		  log.info("Patient Tab Clicked ");
		 
		   
		  driver.findElement(By.xpath(objectrepo.getProperty("SearchPatient"))).clear();
		  driver.findElement(By.xpath(objectrepo.getProperty("SearchPatient"))).sendKeys(PatientNames);
		   
		  driver.findElement(By.xpath(objectrepo.getProperty("SelectPatient"))).click(); 
		  driver.getPageSource().contains(PatientNames);
		  log.info("Patient Selected ");
		 
   driver.findElement(By.xpath(objectrepo.getProperty("PatientContactDetails"))); 
		 
		   driver.findElement(By.xpath(objectrepo.getProperty("PatientProfilePicture"))); 
		   driver.findElement(By.xpath(objectrepo.getProperty("ChatButton"))); 
		   Thread.sleep(2000);
 	  driver.findElement(By.xpath("//*[@data-appt-status][contains(.,'waiting')]")).click();
			  log.info("Waiting Appintment Clicked");
			  Thread.sleep(2000);
		driver.findElement(By.xpath(objectrepo.getProperty("PrescriptionTAB"))).click();  	
		  Thread.sleep(2000);
		  log.info("Prescription Tab Clicked ");
			  
		  
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("(//div[contains(.,'No medication added yet')])"));
 		
			   if (driver.findElements(By.xpath("(//span[contains(.,'Add Medication')])")).size()>0) {
				   TakesScreenshot screenshot=(TakesScreenshot)driver;
					  // Call method to capture screenshot
					  File src=screenshot.getScreenshotAs(OutputType.FILE);
					  // Copy files to specific location 
					  // result.getName() will return name of test case so that screenshot name will be same as test case name
		  FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshots/"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
					 
			 Assert.fail("Add Medication Button was Shown for Waiting Appointments  ");
				  
			   }
				  else 
					  
				  {
					  log.info("Add Medication Button not available as expected for Waiting Appointments"); 
				  }
			   Thread.sleep(1000);
			   driver.findElement(By.xpath("//span[contains(.,'Profile')]")).click();
			   Thread.sleep(1000);
			   driver.findElement(By.xpath("//span[contains(.,'Patients')]")).click(); 
			    ; 
			   Thread.sleep(1000);	
				  log.info("Patient Tab Clicked ");
				 
				  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).clear();
				  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).sendKeys(PatientNames);

				  driver.findElement(By.xpath(objectrepo.getProperty("SelectPatient"))).click(); 
	    Thread.sleep(2000);
 
		  driver.findElement(By.xpath(objectrepo.getProperty("FinishedAppointmentStatus"))).click(); 
 
   Thread.sleep(2000);
	  log.info("Finished Appointment selected");
	  
	   driver.findElement(By.xpath(objectrepo.getProperty("FinishedPrescriptionTAB"))).click(); 
 	  
	  Thread.sleep(2000);
 	  
	  if(!driver.findElements(By.xpath("(//span[contains(.,'Add Medication')])")).isEmpty()){

		  driver.findElement(By.xpath(objectrepo.getProperty("AddMedicationButton"))).click();
		}else{
			 
			  
			  driver.findElement(By.xpath("//button[contains(.,'New Order')]")).click();
		}
	  
	  log.info("New Prescription Clicked ");
	  
 
  
 
 driver.findElement(By.xpath(objectrepo.getProperty("SearchMedication"))).sendKeys("whhdhdk");
 
	   driver.findElement(By.xpath("(//div[contains(.,'Nothing has been added yet')])"));
	   
	   driver.findElement(By.xpath(objectrepo.getProperty("EmptyMedicationImage"))); 
	   
	   driver.findElement(By.xpath(objectrepo.getProperty("SearchMedication"))).clear();

	   driver.findElement(By.xpath(objectrepo.getProperty("SearchMedication"))).sendKeys("Para");
 
		  driver.findElement(By.xpath("(//div[contains(.,'Result')])"));
		  log.info("Prescription Searched and Results Returned ");
		 
		  driver.findElement(By.xpath(objectrepo.getProperty("AddDrugsButton"))).click(); 
 		  driver.findElement(By.xpath("//div[@class='label'][contains(.,'Dosage, mg')]"));
		  driver.findElement(By.xpath("//div[@class='label'][contains(.,'Duration')]"));
		  driver.findElement(By.xpath("//div[@class='label'][contains(.,'Regimen')]"));
		  driver.findElement(By.xpath("//div[@class='label'][contains(.,'Refills')]"));
		  driver.findElement(By.xpath("//div[@class='label'][contains(.,'Indication')]"));
		  driver.findElement(By.xpath("//span[contains(.,'Dosage per kg')]"));
		 

		  driver.findElement(By.xpath(objectrepo.getProperty("DossageTextbox"))).clear();
		  driver.findElement(By.xpath(objectrepo.getProperty("DossageTextbox"))).sendKeys("1000");
 	  
		  driver.findElement(By.xpath("(//span[contains(.,'every 1 hour')])")).click();	  
		  driver.findElement(By.xpath("(//span[contains(.,'every 4 hours')])")).click();	
		  
		  driver.findElement(By.xpath(objectrepo.getProperty("IndicationTextbox"))).sendKeys("Akinade");	 
		
		  driver.findElement(By.xpath(objectrepo.getProperty("DossageKg"))).click();
 	  
		  driver.findElement(By.xpath(objectrepo.getProperty("UpdateMedicationButton"))).click();
		 
		  driver.findElement(By.xpath("(//div[contains(.,'ADDED')])"));
		  log.info("Prescription Added Successfully ");
		  driver.findElement(By.xpath(objectrepo.getProperty("DeleteMedicationRecord"))).click();
		  log.info("Prescription added is about to be deleted ");

		   if (driver.findElements(By.xpath("(//div[contains(.,'ADDED')])")).size()>0) {
			   TakesScreenshot screenshot=(TakesScreenshot)driver;
				  // Call method to capture screenshot
				  File src=screenshot.getScreenshotAs(OutputType.FILE);
				  // Copy files to specific location 
				  // result.getName() will return name of test case so that screenshot name will be same as test case name
				   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshots/"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
				 
		 Assert.fail("Deleted Medication is still showing   ");
			  
		   }
			  else 
				  
			  {
				  log.info("Medication added Deleted "); 
			  }
		  

			  driver.findElement(By.xpath(objectrepo.getProperty("AddDrugsButton"))).click(); 
			   
			  driver.findElement(By.xpath(objectrepo.getProperty("DossageTextbox"))).clear();
			  driver.findElement(By.xpath(objectrepo.getProperty("DossageTextbox"))).sendKeys("1000");
			 
			  driver.findElement(By.xpath("(//span[contains(.,'every 1 hour')])")).click();	  
			  driver.findElement(By.xpath("(//span[contains(.,'every 4 hours')])")).click();	
			  
			  driver.findElement(By.xpath(objectrepo.getProperty("IndicationTextbox"))).sendKeys("Akinade");	 
			
			  driver.findElement(By.xpath(objectrepo.getProperty("DossageKg"))).click();
			  
			  
			  driver.findElement(By.xpath(objectrepo.getProperty("UpdateMedicationButton"))).click();
			 
			  driver.findElement(By.xpath("(//div[contains(.,'ADDED')])"));
		 
		   Thread.sleep(2000);
			  log.info("New Prescription Added ");
			  driver.findElement(By.xpath(objectrepo.getProperty("SubmitMedicationButton"))).click();
    
  Thread.sleep(3000);
  log.info("Medication Created");
  
  driver.findElement(By.xpath(objectrepo.getProperty("ChatLabButton"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("PharmacyText"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("StatusText"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("NewStatus"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("SentDateText"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("CancelMedButton"))).click(); 
  driver.findElement(By.xpath(objectrepo.getProperty("CancelMedText"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("CancelYes"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("CancelNo"))).click();
  log.info("All Medication Details displayed successfully ");
  driver.findElement(By.xpath(objectrepo.getProperty("SharePrescription"))).click();
  driver.findElement(By.xpath(objectrepo.getProperty("SharePrescriptionConfirmation"))); 
  log.info("Prescription was Shared Successfully ");
  driver.findElement(By.xpath(objectrepo.getProperty("CancelMedButton"))).click(); 
  driver.findElement(By.xpath(objectrepo.getProperty("CancelYes"))).click();
  Thread.sleep(1000);
  
  driver.findElement(By.xpath(objectrepo.getProperty("CancelDateText"))); 
  driver.findElement(By.xpath(objectrepo.getProperty("CancelProviderLabel"))).click();
  Thread.sleep(1000);
  log.info("Prescription Cancelled  ");
  driver.findElement(By.xpath(objectrepo.getProperty("ChatButton"))).click();
  Thread.sleep(2000);
  log.info("Chat Button Clicked to chat with Pharmacy ");
  
  driver.findElement(By.xpath("(//div[contains(.,'Messages')])"));
  driver.findElement(By.xpath("//input[contains(@placeholder,'Start typing here')]"));
  driver.findElement(By.xpath("//i[@class='icon-attach']"));
  driver.findElement(By.xpath("//input[contains(@placeholder,'Start typing here')]")).sendKeys(FirstMessage);
  driver.findElement(By.xpath("//i[@class='icon-send']")).click();
  Thread.sleep(2000);
  driver.getPageSource().contains(FirstMessage);
  driver.findElement(By.xpath("//input[contains(@placeholder,'Start typing here')]")).sendKeys(SecondMessage);
  driver.findElement(By.xpath("//i[@class='icon-send']")).click();
  Thread.sleep(2000);
  driver.getPageSource().contains(SecondMessage);
  
  log.info("Chat was successsful with Provider ");
	 
	    }
      
 
  
  
  
  @AfterMethod //AfterMethod annotation - This method executes after every test execution
  public void screenShot(ITestResult result){
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
  if(ITestResult.FAILURE==result.getStatus()){
  try{
  // To create reference of TakesScreenshot
  TakesScreenshot screenshot=(TakesScreenshot)driver;
  // Call method to capture screenshot
  File src=screenshot.getScreenshotAs(OutputType.FILE);
  // Copy files to specific location 
  // result.getName() will return name of test case so that screenshot name will be same as test case name
   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshots/"+result.getName()+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	  
   
    

   
   
   
  System.out.println("Successfully captured a screenshot");
  }catch (Exception e){
  System.out.println("Exception while taking screenshot "+e.getMessage());
  } 
  }
  driver.quit();
  }
  
  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
  
  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	   
 
  
}
