 package pharmacy;

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
import utils.pharmautility;

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
 
public class PharmaChangeOrderStatus extends pharmautility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
	
		  
	  log.info("START TEST------------- Pharmacy Change Order Status----------"); 
		 try {
			 pharmautilityclass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  @SuppressWarnings("rawtypes")
	@Test
	
	public void testpharmachangestatus() throws Exception {
	    
		  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 XSSFSheet sheet = workbook.getSheet("LABMODULE"); 
			 
			 
			   
			   Row patientname = sheet.getRow(2);
			   Cell cell2 = patientname.getCell(1);
		   String Patientname  = cell2.getStringCellValue();
		   
			   
			     
			    driver.findElement(By.xpath(objectrepo.getProperty("PHARMAORDERMENU"))).click();
			    driver.findElement(By.xpath(objectrepo.getProperty("SEARCHBOX"))).clear();
	      
	  driver.findElement(By.xpath(objectrepo.getProperty("SEARCHBOX"))).sendKeys(Patientname); 
	  Thread.sleep(3000);
	  
	  
	  log.info("Patient name serached"); 
			  driver.findElement(By.xpath("(//td[@role='gridcell'][contains(.,'NEW')])")).click(); 
			  Thread.sleep(2000);
			  log.info("New Test Clicked"); 
			  driver.findElement(By.xpath("(//div[contains(.,'Prescription details')])")); 
			  
			  
			  driver.findElement(By.xpath(objectrepo.getProperty("STATUSDROPDOWN"))).click();	
			  Thread.sleep(3000);
			  
			  
			  
			  driver.findElement(By.xpath(objectrepo.getProperty("PHARMAPREPARINGSTATUS")));
			  driver.findElement(By.xpath(objectrepo.getProperty("PHARMADELIVERYSTATUS")));
			  driver.findElement(By.xpath(objectrepo.getProperty("PHARMACANCELLEDBYPROVIDER")));
			  driver.findElement(By.xpath(objectrepo.getProperty("PHARMACANCELLEDBYCUSTOMER")));
			  driver.findElement(By.xpath(objectrepo.getProperty("PHARMACOMPLETEDSTATUS")));
 			  log.info("All Test Status Validated"); 
		
			
	   
			  driver.findElement(By.xpath(objectrepo.getProperty("PREPARINGSTATUS"))).click();
		  driver.findElement(By.xpath(objectrepo.getProperty("SUCCESSSTAT")));
		  
			  driver.getPageSource().contains("Preparing");
			  log.info("Status changed to Preparing"); 
			  driver.findElement(By.xpath(objectrepo.getProperty("STATUSDROPDOWN"))).click();	
			  Thread.sleep(3000);
			  driver.findElement(By.xpath(objectrepo.getProperty("PHARMADELIVERYSTATUS"))).click();
			  driver.findElement(By.xpath(objectrepo.getProperty("SUCCESSSTAT")));
			  log.info("Status changed to DELIVERY"); 
			  driver.getPageSource().contains("Delivery");
			  
			  
			  driver.findElement(By.xpath(objectrepo.getProperty("STATUSDROPDOWN"))).click();	
			  Thread.sleep(3000);
			  driver.findElement(By.xpath(objectrepo.getProperty("COMPLETEDSTATUS"))).click();
			  driver.findElement(By.xpath(objectrepo.getProperty("SUCCESSSTAT")));
			  log.info("Status changed to Completed"); 
			  
			  log.info("END TEST-------------ChangeOrderStatus----------"); 
			  
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
