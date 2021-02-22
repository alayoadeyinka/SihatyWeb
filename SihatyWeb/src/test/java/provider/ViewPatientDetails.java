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
 
public class ViewPatientDetails extends utility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
	
		 log.info("START TEST- VIEW PATIENT DETAILS Begins");
		 try {
			utilityclass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	
	public void testViewPatientDetails() throws Exception {
	 
		  String filePath = System.getProperty("user.dir");
 	  FileInputStream fis = new FileInputStream(filePath+"/config/Testdata.xlsx");
 	 
		BasicConfigurator.configure();
	    Logger log = Logger.getLogger("devpinoyLogger");
	    
	    
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		  XSSFSheet sheet = workbook.getSheet("Patients");
		  
		  Row PatientName = sheet.getRow(1);
		  Cell cell1 = PatientName.getCell(1);
		  String PatientNames  = cell1.getStringCellValue();
 
		  
		  Row NoPatientName = sheet.getRow(2);
		  Cell cell2 = NoPatientName.getCell(1);
		  String NoPatientNames  = cell2.getStringCellValue();
	  
		Thread.sleep(2000);	
		   driver.findElement(By.xpath("//span[contains(.,'Profile')]")).click(); 

		  driver.findElement(By.xpath("//span[contains(.,'Patients')]")).click(); 
		  Thread.sleep(2000);	
	
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']"));
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).sendKeys(NoPatientNames);
		  driver.findElement(By.xpath("(//div[contains(.,'No patient')])"));
		   
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).clear();
		  driver.findElement(By.xpath("//input[@placeholder='Search patients']")).sendKeys(PatientNames);
		  driver.findElement(By.xpath("(//div[@class='patient-name'])[1]")).click();
		  driver.getPageSource().contains(PatientNames);
		  driver.findElement(By.xpath("//mat-panel-title[contains(.,'Contact Details')]"));
		  driver.findElement(By.xpath("//img[@alt='Profile Picture']"));
		  driver.findElement(By.xpath("//button[contains(.,'OPEN CHAT')]"));
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'Phone number')]"));
		  
		  
 		  driver.findElement(By.xpath("//mat-panel-title[contains(.,'Personal Details')]"));
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'First Name')]"));
 		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'Last Name')]"));
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'Civil ID Number')]"));
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'DOB')]"));
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'Age')]"));
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'Gender')]"));
		  driver.findElement(By.xpath("//mat-panel-title[contains(.,'Health Information')]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'Alcohol')]"));
		  driver.findElement(By.xpath("//div[@class='patient-info-title'][contains(.,'Smoking')]"));
		  log.info("Health Info Checked");
		  driver.findElement(By.xpath("//button[contains(.,'Steps tracker')]"));
		  driver.findElement(By.xpath("//button[contains(.,'Sleep tracker')]"));
		  log.info("Sleep and Steps Checked");
		   
		  driver.findElement(By.xpath("(//div[contains(.,'Consultations')])"));
		  driver.findElement(By.xpath("(//div[contains(.,'Specialist')])"));
		  driver.findElement(By.xpath("(//div[contains(.,'Urgent consultation')])"));
		 
		  
		  driver.findElement(By.xpath("(//span[@color='primary'][contains(.,'clear')])[1]"));
		  driver.findElement(By.xpath("(//span[@color='primary'][contains(.,'clear')])[2]"));
		  driver.findElement(By.xpath("(//div[contains(.,'Upcoming Consultations')])"));
		  driver.findElement(By.xpath("(//div[contains(.,'Past Consultations')])"));
		  driver.findElement(By.xpath("//span[contains(.,'New Consultation')]"));
		  log.info("Consultations Checked");
 		
		  driver.findElement(By.xpath("//label[contains(.,'Filter by date')]"));
		  driver.findElement(By.xpath("//label[contains(.,'Filter by provider')]"));
		  log.info("Filter Checked");
		  
		  
		
			 log.info("END TEST- VIEW PATIENT DETAILS Begins");

		  
   
   
		   
				   
 

   
   
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
