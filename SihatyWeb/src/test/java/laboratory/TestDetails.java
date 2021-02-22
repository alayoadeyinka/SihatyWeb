 package laboratory;

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
import utils.labutility;

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
 
public class TestDetails extends labutility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
	
		  
	  log.info("START TEST------------- Test Details----------"); 
		 try {
			labutilityclass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  @SuppressWarnings("rawtypes")
	@Test
	
	public void testTestDetails() throws Exception {
	   
		  
		  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 XSSFSheet sheet = workbook.getSheet("LABMODULE"); 
			 
		 
		   
		   Row patientname = sheet.getRow(2);
		   Cell cell2 = patientname.getCell(1);
	   String Patientname  = cell2.getStringCellValue();
	   
	  
		   
		     
		    driver.findElement(By.xpath(objectrepo.getProperty("ORDERMENU"))).click();
		    driver.findElement(By.xpath(objectrepo.getProperty("SEARCHBOX"))).clear();
      
  driver.findElement(By.xpath(objectrepo.getProperty("SEARCHBOX"))).sendKeys(Patientname); 
  Thread.sleep(3000);
   
		  driver.findElement(By.xpath("(//td[@role='gridcell'])[1]")).click(); 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("(//div[contains(.,'Test details')])")); 
		  
		  driver.findElement(By.xpath("//i[contains(@class,'icon-left')]")).click(); 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(objectrepo.getProperty("SEARCHBOX")));
		  driver.findElement(By.xpath("(//td[@role='gridcell'])[1]")).click(); 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[contains(.,'Print the order')]")); 
		  
		  driver.findElement(By.xpath("//span[@class='order-details-status-msg'][contains(.,'Change status here based on stage of the order')]")); 
		  
		
		  driver.findElement(By.xpath("//div[@class='header-title'][contains(.,'Tests')]"));
		  
		  driver.findElement(By.xpath("(//div[contains(.,'Indication')])")); 
		  driver.findElement(By.xpath("(//div[contains(.,'Collection date')])")); 
		  driver.findElement(By.xpath("(//div[contains(.,'fasting')])")); 
		  driver.findElement(By.xpath("(//div[contains(.,'Indication')])")); 
		  
 
	 	 String Testcategory= driver.findElement(By.xpath("//div[@class='order-details-test-category']")).getText()  ;   
	      log.info("Test Category is");
	      log.info(Testcategory);
	      Thread.sleep(1000); 
	   
	 	 String Testname= driver.findElement(By.xpath("//*[@data-test-name]")).getText()  ;   
	      log.info("Test Name is");
	      log.info(Testname);
	      Thread.sleep(1000); 
	      
	      String Testamount= driver.findElement(By.xpath("//*[@data-test-price]")).getText()  ;   
	      log.info("Test Amount is ");
	      log.info(Testamount);
	      Thread.sleep(1000); 
		  
	      String indication= driver.findElement(By.xpath("//div[@class='order-details-test-indication']")).getText()  ;   
	      log.info("Indication is ");
	      log.info(indication);
	      Thread.sleep(1000); 
	      
	      String fasting= driver.findElement(By.xpath("//*[@data-test-fasting]")).getText()  ;   
	      log.info("Fasting is ");
	      log.info(fasting);
	      Thread.sleep(1000); 
	      
	      String priority= driver.findElement(By.xpath("//*[@data-test-priority]")).getText()  ;   
	      log.info("Priority is ");
	      log.info(priority);
	      Thread.sleep(1000);
	      
	      
	      String collectiondate= driver.findElement(By.xpath("//*[@data-test-collection-date]")).getText()  ;   
	      log.info("Collection date is ");
	      log.info(collectiondate);
	      Thread.sleep(1000);
	      
	      
	    //  driver.findElement(By.xpath("//*[@data-value-title=\"Patient name\"]"));
	      String PatientName= driver.findElement(By.xpath("//*[@data-value-title=\"Patient name\"]")).getText()  ;   
	      log.info("PatientNamex is ");
	      log.info(PatientName);
	      Thread.sleep(1000);
	      
	      
		  
		  driver.findElement(By.xpath(objectrepo.getProperty("STATUSDROPDOWN"))).click();	
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(objectrepo.getProperty("NEWSTATUS")));
		  driver.findElement(By.xpath(objectrepo.getProperty("PREPARINGSTATUS")));
		  driver.findElement(By.xpath(objectrepo.getProperty("COMPLETEDSTATUS")));
		  driver.findElement(By.xpath(objectrepo.getProperty("PARTIALSTATUS")));
		  driver.findElement(By.xpath(objectrepo.getProperty("TRANSITSTATUS")));
		  driver.findElement(By.xpath(objectrepo.getProperty("CANCELLEDBYPROVIDER")));
		  driver.findElement(By.xpath(objectrepo.getProperty("CANCELLEDBYCUSTOMER")));

driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Patient name')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Civil ID')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'DOB')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Age')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Phone number')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Address')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Gender')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Weight')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Provider name')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Speciality')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'Phone number')]")); 
driver.findElement(By.xpath("//div[@class='details-title ng-star-inserted'][contains(.,'License number')]")); 
driver.findElement(By.xpath("//div[@class='header-title'][contains(.,'Patient Details')]")); 
driver.findElement(By.xpath("//div[@class='header-title'][contains(.,'Provider Details')]")); 
driver.findElement(By.xpath(objectrepo.getProperty("ChatProvider"))); 
 	  

log.info("END TEST------------- Test Details----------"); 

		  
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
	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
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
