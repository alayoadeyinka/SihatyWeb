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
public class EditWaitingConsultationNotes extends utility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
 log.info("-----------------------------------------START TEST- EDIT  CONSULTATION--------------------------------------------------------------");

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
		  Row PatientName = sheet.getRow(1);
		  Cell cell1 = PatientName.getCell(1);
		  String PatientNames  = cell1.getStringCellValue();
 
		  
		  Row NoPatientName = sheet.getRow(2);
		  Cell cell2 = NoPatientName.getCell(1);
		  String NoPatientNames  = cell2.getStringCellValue();
		  
		  Row consultreason = sheets.getRow(1);
		  Cell cell3 = consultreason.getCell(1);
		  String CONSULTREASON  = cell3.getStringCellValue();
		  
		  
		  
		  Row Medicalnote  = sheets.getRow(5);
		  Cell cell7 = Medicalnote.getCell(1);
		  String MEDICALNOTE  = cell7.getStringCellValue();
		  
		  Row Patientinstructions  = sheets.getRow(6);
		  Cell cell8 = Patientinstructions.getCell(1);
		  String PATIENTINSTRUCTION  = cell8.getStringCellValue();
		  
		  
		  Row Imaging  = sheets.getRow(9);
		  Cell cell6 = Imaging.getCell(1);
		  String IMAGING = cell6.getStringCellValue();
		 	  
		Thread.sleep(2000);	
		   driver.findElement(By.xpath("//span[contains(.,'Profile')]")).click(); 

		  driver.findElement(By.xpath("//span[contains(.,'Patients')]")).click(); 
		  Thread.sleep(2000);	
		  log.info("Patient Tab Clicked ");
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']"));
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).sendKeys(NoPatientNames);
		  driver.findElement(By.xpath("(//div[contains(.,'No patient')])"));
		   
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).clear();
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).sendKeys(PatientNames);
		  driver.findElement(By.xpath("(//div[@class='patient-name'])[1]")).click();
		  driver.getPageSource().contains(PatientNames);
		  log.info("Patient Selected ");
		  driver.findElement(By.xpath("//mat-panel-title[contains(.,'Contact Details')]"));
		  driver.findElement(By.xpath("//img[@alt='Profile Picture']"));
		  driver.findElement(By.xpath("//button[contains(.,'OPEN CHAT')]"));
		  driver.findElement(By.xpath("//span[contains(.,'New Consultation')]")).click();
	 	  log.info("New Consultation button clicked ");
		 	  driver.findElement(By.xpath("//div[@class='create-patient-consultation-header'][contains(.,'New Consultation')]"));

		  driver.findElement(By.xpath("//mat-label[contains(.,'Reason for consultation')]"));
		 	  driver.findElement(By.xpath("//mat-label[contains(.,'Type of consultation')]"));
		 	  driver.findElement(By.xpath("//mat-label[contains(.,'Time')]"));
		 	  driver.findElement(By.xpath("//span[contains(.,'Assign to me')]"));
		 	  driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).click();
		 	  driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys(CONSULTREASON);;
		  Thread.sleep(2000);
	 	  log.info("Reasons for consultation Selected ");
			   Actions action = new Actions(driver);
			   action.sendKeys(Keys.ENTER).build().perform();
			  
			   
			  
			  driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[3]")).click();
			 
		 	 Thread.sleep(1000);
		 	 driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(.,'New')]")).click();
		 	 Thread.sleep(1000);
		 
	 		 driver.findElement(By.xpath("(//button[contains(@tabindex,'0')])[2]")).click();
	  Thread.sleep(3000);
	  log.info("Appointment Date Picker Clicked ");
	 
	 
	 
		  driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
		 	 driver.findElement(By.xpath("(//div[@class='mat-calendar-body-cell-content'][contains(.,'7')])[1]")).click();
		 	 log.info("Day Selected is 6th of Next Month ");
		
		 	 driver.findElement(By.xpath("//span[@class='mat-button-wrapper'][contains(.,':')]")).click();
	 	 Thread.sleep(3000);
		 	 log.info("Timeslot Selected");
			 
			 
		  
			  driver.findElement(By.xpath("//span[contains(.,'Submit')]")).click();

		   driver.findElement(By.xpath("//span[contains(.,'Appointment successfully created')]")).click();
		 	 log.info("Appointment Created Successfully");
		 	 
	    Thread.sleep(3000);
	 
	 	 
	 	  driver.findElement(By.xpath("//*[@data-appt-status][contains(.,'waiting')]")).click();
		  Thread.sleep(2000);
		  log.info("Appointment selected");
		  driver.findElement(By.xpath("(//i[@class='icon-edit'])")).click();
		  Thread.sleep(2000);
		  log.info("Edit Button Clicked");
		  driver.findElement(By.xpath("(//label[contains(.,'Medical note')])"));
		  driver.findElement(By.xpath("(//label[contains(.,'Patient instructions')])"));
		   
		  driver.findElement(By.xpath("(//label[contains(.,'Imaging')])"));	
		  log.info("All Notes Fields Validated");
		  
		  
		  driver.findElement(By.xpath("//textarea[@formcontrolname='notes']")).clear();
		  driver.findElement(By.xpath("//textarea[@formcontrolname='instructions']")).clear();
		   
		  driver.findElement(By.xpath("//textarea[@formcontrolname='imaging']")).clear();	
		 
  
		  
		  driver.findElement(By.xpath("//textarea[@formcontrolname='notes']")).sendKeys(MEDICALNOTE);	
		  driver.findElement(By.xpath("//textarea[@formcontrolname='instructions']")).sendKeys(PATIENTINSTRUCTION);	
		  
		  driver.findElement(By.xpath("//textarea[@formcontrolname='imaging']")).sendKeys(IMAGING);	
  
		  
		  driver.findElement(By.xpath("(//button[contains(.,'Save')])")).click();	
		  Thread.sleep(3000);
		  log.info("All Notes Value Entered and Save Button Clicked ");
 	  
 	  driver.getPageSource().contains(MEDICALNOTE);
 	  driver.getPageSource().contains(PATIENTINSTRUCTION);
	 	   
		   driver.getPageSource().contains(IMAGING);
 
		   log.info("Notes Saved Successfully");
		   
 
		
		   if (driver.findElements(By.xpath("//input[@value='SIGN IN']")).size()>0) {
			   TakesScreenshot screenshot=(TakesScreenshot)driver;
				  // Call method to capture screenshot
				  File src=screenshot.getScreenshotAs(OutputType.FILE);
				  // Copy files to specific location 
				  // result.getName() will return name of test case so that screenshot name will be same as test case name
				   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshots/"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
				 
					 Assert.fail("Share Button Is Available for Waiting Appointment  ");
			  
		   }
			  else 
				  
			  {
				  log.info("Share Button is not Available for Waiting Appointment as Expected"); 
			  }
					  
					  
							  
		  
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
