 package provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
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
 
public class WaitingRoom extends utility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
	
		  
	  log.info("START TEST- WAITING ROOM"); 
		 try {
			utilityclass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	
	
	
	public void testProfile() throws Exception {
		  String filePath = System.getProperty("user.dir");
	 	  FileInputStream fis = new FileInputStream(filePath+"/config/Testdata.xlsx");
		   XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		XSSFSheet sheets = workbook.getSheet("Consultation");
		
		  Row Medicalnote  = sheets.getRow(5);
		  Cell cell3 = Medicalnote.getCell(1);
		  String MEDICALNOTE  = cell3.getStringCellValue();
		  
		  Row Patientinstructions  = sheets.getRow(6);
		  Cell cell2 = Patientinstructions.getCell(1);
		  String PATIENTINSTRUCTION  = cell2.getStringCellValue();
		  
		  Row Prescription  = sheets.getRow(7);
		  Cell cell4 = Prescription.getCell(1);
		  String PRESCRIPTION  = cell4.getStringCellValue();
		  
		  Row Laboratory  = sheets.getRow(8);
		  Cell cell5 = Laboratory.getCell(1);
		  String LABORATORY  = cell5.getStringCellValue();
		  
		  Row Imaging  = sheets.getRow(9);
		  Cell cell6 = Imaging.getCell(1);
		  String IMAGING = cell6.getStringCellValue();
		
		
		
   
   driver.findElement(By.xpath("//span[contains(.,'Waiting Room')]")).click(); 
   
   driver.findElement(By.xpath("(//div[contains(.,'Waiting room')])[3]"));
   driver.findElement(By.xpath("//h2[contains(.,'Emergency patients')]"));
   driver.findElement(By.xpath("//span[contains(.,'Reload')]")).click();
   driver.findElement(By.xpath("(//b[contains(.,'Symptom:')])")).click();

 
driver.findElement(By.xpath("//span[contains(.,'OPEN CHAT')]")); 
log.info("Clicking on User navigates to user profile");
  
driver.findElement(By.xpath("//span[contains(.,'Waiting Room')]")).click(); 
//driver.findElement(By.xpath("/html/body/app-root/layout/mat-sidenav-container/mat-sidenav-content/div/ng-component/data-page/div[2]/div[2]/div[2]/div/div[1]/div[3]/button[2]/span/i")).click(); 
 driver.findElement(By.xpath("/html/body/app-root/layout/mat-sidenav-container/mat-sidenav-content/div/ng-component/data-page/div[2]/div[2]/div/div/div[1]/div[3]/button[2]/span/i")).click(); 

log.info("Chat icon clicked from waiting room ");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[contains(@placeholder,'Start typing here')]"));
log.info("Chat Page Opened  ");
Thread.sleep(1000);
driver.navigate().back();
Thread.sleep(2000);
 driver.findElement(By.xpath("//span[contains(.,'Waiting Room')]")).click(); 
driver.findElement(By.xpath("(//i[contains(@class,'icon-video')])")).click(); 
log.info("Video Icon Clicked");
 driver.findElement(By.xpath("//h2[contains(.,'Personal details')]"));
 driver.findElement(By.xpath("//label[contains(.,'Civil ID number')]"));
 driver.findElement(By.xpath("//label[contains(.,'Gender')]"));
 driver.findElement(By.xpath("//label[contains(.,'First name')]"));
 driver.findElement(By.xpath("//label[contains(.,'Last name')]"));
 driver.findElement(By.xpath("//label[contains(.,'Phone')]"));
 driver.findElement(By.xpath("//mat-panel-title[contains(.,'Health information')]"));
 driver.findElement(By.xpath("//mat-panel-title[contains(.,'Clinical questionnaire')]"));
 driver.findElement(By.xpath("//label[contains(.,'Medical note')]"));
 driver.findElement(By.xpath("//textarea[contains(@formcontrolname,'notes')]")).sendKeys(MEDICALNOTE);

 
 driver.findElement(By.xpath("//label[contains(.,'Patient instructions')]"));
 driver.findElement(By.xpath("//textarea[@formcontrolname='instructions']")).sendKeys(PATIENTINSTRUCTION);

 driver.findElement(By.xpath("//label[contains(.,'Prescription')]"));
 driver.findElement(By.xpath("//textarea[@formcontrolname='prescription']")).sendKeys(PRESCRIPTION);

 
 driver.findElement(By.xpath("//label[contains(.,'Laboratory')]"));
 driver.findElement(By.xpath("//textarea[@formcontrolname='laboratory']")).sendKeys(LABORATORY);

 driver.findElement(By.xpath("//label[contains(.,'Imaging')]"));
 driver.findElement(By.xpath("//textarea[@formcontrolname='imaging']")).sendKeys(IMAGING);
 driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
 Thread.sleep(3000);

   
						 
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
