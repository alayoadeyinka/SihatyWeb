 package provider;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
 
public class ProviderProfile extends utility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
	
		  
	  log.info("START TEST- DOCTOR PROFILING"); 
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

		BasicConfigurator.configure();
	    Logger log = Logger.getLogger("devpinoyLogger");
	    
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		  XSSFSheet sheet = workbook.getSheet("Profile");
		   

		  Row phon = sheet.getRow(1);
		  Cell cell = phon.getCell(1);
		  String PHONE  = cell.getStringCellValue();
		  	  
		  Row secname = sheet.getRow(2);
		  Cell cell1 = secname.getCell(1);
		  String SECNAME  = cell1.getStringCellValue();
		  
		  Row lang = sheet.getRow(3);
		  Cell cell2 = lang.getCell(1);
		  String LANG  = cell2.getStringCellValue();
		    
		  Row uni = sheet.getRow(4);
		  Cell cell3 = uni.getCell(1);
		  String UNIVERSITY  = cell3.getStringCellValue();
	 
		  Row train = sheet.getRow(5);
		  Cell cell4 = train.getCell(1);
		  String TRAINING  = cell4.getStringCellValue();
		  
		  Row country = sheet.getRow(6);
		  Cell cell5 = country.getCell(1);
		  String COUNTRY  = cell5.getStringCellValue();
		  
		  Row fellow = sheet.getRow(7);
		  Cell cell6 = fellow.getCell(1);
		  String FELLOWSHIP  = cell6.getStringCellValue();
   
		  Row other = sheet.getRow(8);
		  Cell cell7 = other.getCell(1);
		  String OTHER  = cell7.getStringCellValue();
		  
		  Row board = sheet.getRow(9);
		  Cell cell8 = board.getCell(1);
		  String BOARD  = cell8.getStringCellValue();
		  
		  Row expertise = sheet.getRow(10);
		  Cell cell9 = expertise.getCell(1);
		  String EXPERTISE  = cell9.getStringCellValue();
		  
		  Row experience = sheet.getRow(11);
		  Cell cell10 = experience.getCell(1);
		  String EXPERIENCE  = cell10.getStringCellValue(); 
		  
		  Row padding = sheet.getRow(11);
		  Cell cell11 = padding.getCell(1);
		  String PADING  = cell11.getStringCellValue(); 
		  
		  
		  Row initialD = sheet.getRow(11);
		  Cell cell12 = padding.getCell(1);
		  String INITIALDURATION  = cell12.getStringCellValue(); 
		  
		  Row followupD = sheet.getRow(11);
		  Cell cell13 = padding.getCell(1);
		  String FOLLOWUPDURATION  = cell13.getStringCellValue(); 
				 Thread.sleep(2000);
				 
		 	 
				 driver.findElement(By.xpath("//span[contains(.,'Profile')]")).click(); 
				   
				   log.info("Profile Menu Clicked");
				   driver.findElement(By.xpath("(//div[contains(@class,'details-photo ng-tns')])")); 
				   log.info("Photo Checked");
				   
				   driver.findElement(By.xpath("//div[contains(@class,'details-head-spec')]")); 
				   log.info("Doctor Specialty Displayed");
				 
				   
				    driver.findElement(By.xpath("//span[contains(.,'Contact details')]")); 
				   driver.findElement(By.xpath("//span[contains(.,'Background information')]")); 
				 
				   driver.findElement(By.xpath("//span[contains(.,'Career details')]")); 
				   driver.findElement(By.xpath("//span[contains(.,'Personal details')]")); 
				   
				    
				   driver.findElement(By.xpath("//label[contains(.,'Phone')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'Email')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'University')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'Training')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'Fellowship')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'Other')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'Board')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'First name')]")); 
				   driver.findElement(By.xpath("//label[contains(.,'Second name')]"));
				   driver.findElement(By.xpath("//label[contains(.,'Second name')]"));
				   driver.findElement(By.xpath("//label[contains(.,'Last name')]"));
				   driver.findElement(By.xpath("//label[contains(.,'DOB')]"));
				   driver.findElement(By.xpath("//label[contains(.,'Civil ID number')]"));
				   driver.findElement(By.xpath("//label[contains(.,'Languages')]"));
				   driver.findElement(By.xpath("//label[contains(.,'Nationality')]"));
				   driver.findElement(By.xpath("//label[contains(.,'Experience')]"));
				   driver.findElement(By.xpath("//label[contains(.,'Areas of expertise')]"));
 	   driver.findElement(By.xpath("//mat-form-field[contains(.,'Medical licensure')]"));
     
  driver.findElement(By.xpath("//mat-form-field[contains(.,'Medical licensure')]")).click();
     
  driver.findElement(By.xpath("//button[@type='button'][contains(.,'SCHEDULE SETTINGS')]")).click();
 
  driver.findElement(By.xpath("//div[@class='title'][contains(.,'Schedule setting')]"));
  driver.findElement(By.xpath("//label[contains(.,'Time zone')]"));
  driver.findElement(By.xpath("//span[contains(.,'Availability')]"));
  driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'Sunday')]"));
  driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'Monday')]"));
  driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'Tuesday')]"));
  driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'Wednesday')]"));
  driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'Thursday')]"));
  driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'Friday')]"));
  driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'Saturday')]"));

  driver.findElement(By.xpath("//div[@class='title'][contains(.,'Consultation details')]"));
  driver.findElement(By.xpath("//span[@class='schedule-country-label'][contains(.,'Select country to view the details')]"));
  driver.findElement(By.xpath("(//span[contains(@class,'schedule-field-value')])"));

  
  
  driver.findElement(By.xpath("//label[contains(.,'Padding time')]"));
  driver.findElement(By.xpath("//div[@class='title schedule-title'][contains(.,'Initial consultation')]"));
  driver.findElement(By.xpath("//div[@class='title schedule-title'][contains(.,'Follow-up consultation')]"));
  driver.findElement(By.xpath("(//label[contains(.,'Duration')])"));
  driver.findElement(By.xpath("(//label[contains(.,'Fee (NGN)')])"));



  driver.findElement(By.xpath("//span[contains(.,'UPDATE')]")).click();
  driver.findElement(By.xpath("//input[contains(@role,'combobox')]")).click();
 
  driver.findElement(By.xpath("//input[contains(@role,'combobox')]")).sendKeys("Lagos", Keys.ENTER);
   
  
  Thread.sleep(2000);
  
  
  driver.findElement(By.xpath("//input[@placeholder='Start']")).clear();
  
  driver.findElement(By.xpath("//input[@placeholder='Start']")).sendKeys("2330");
 
  
 driver.findElement(By.xpath("//input[@placeholder='End']")).clear();
  
  driver.findElement(By.xpath("//input[@placeholder='End']")).sendKeys("2330");
  
  driver.findElement(By.xpath("//span[contains(.,'ADD SLOT')]")).click();
  

  driver.findElement(By.xpath("//span[contains(.,'The start and end times must be different')]"));
  Thread.sleep(2000);
  
driver.findElement(By.xpath("//input[@placeholder='Start']"));
   
 driver.findElement(By.xpath("//input[@placeholder='End']"));
  
   
  
  driver.findElement(By.xpath("//span[contains(.,'ADD SLOT')]")).click();
  
  
  WebElement element = driver.findElement(By.xpath("//select[@placeholder='Padding time, mins']"));
  Select select = new Select(element); 
  select.selectByIndex(1);
  
  
 // driver.findElement(By.xpath("//select[@placeholder='Padding time, mins']")).click();
//  driver.findElement(By.xpath("//*[text()='5']")).click	();
  
  
  
  
 log.info("END TEST- DOCTOR PROFILING"); 

 
 
 
 
 
 
 
 
   
   
   
   
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
