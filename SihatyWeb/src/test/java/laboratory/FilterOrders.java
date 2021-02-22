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
 
public class FilterOrders extends labutility{
	 
		
	@BeforeTest
	public void openApp() {
		//Launch Browser
	
		  
	  log.info("START TEST------------- FILTER TEST ORDERS ----------"); 
		 try {
			labutilityclass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  @SuppressWarnings("rawtypes")
	@Test
	
	public void testfilterorders() throws Exception {
	   
 
		     
		    driver.findElement(By.xpath(objectrepo.getProperty("ORDERMENU"))).click();
		  
		   
		    driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	 
	  driver.findElement(By.xpath("//span[contains(.,'All')]")).click();
		    
	   driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	  driver.findElement(By.xpath("//span[contains(.,'Cancelled by customer')]")).click();
	  driver.findElement(By.xpath("//td[@role='gridcell'][contains(.,'CBC')]"));
	
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'NEW')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("CBC Status Filtered Successfully"); 
	   	  }
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBP')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("CBC Status Filtered Successfully"); 
	   	  }
	  
	  
		    
	  driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	  driver.findElement(By.xpath("//span[contains(.,'Cancelled by provider')]")).click();
	  
	  driver.findElement(By.xpath("//td[@role='gridcell'][contains(.,'CBP')]"));
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'NEW')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("CBP Status Filtered Successfully"); 
	   	  }
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBC')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("CBP Status Filtered Successfully"); 
	   	  }
	    
	  driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	  driver.findElement(By.xpath("//span[contains(.,'Completed')]")).click();
	  driver.findElement(By.xpath("//td[@role='gridcell'][contains(.,'COMPLETED')]"));
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'NEW')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("COMPLETED Status Filtered Successfully"); 
	   	  }
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBC')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("COMPLETED Status Filtered Successfully"); 
	   	  }  
	  
	   
	  driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	  driver.findElement(By.xpath("//span[contains(.,'New')]")).click();
	  driver.findElement(By.xpath("//td[@role='gridcell'][contains(.,'NEW')]"));
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBP')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- CBP Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("NEW Status Filtered Successfully"); 
	   	  }
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBC')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- CBC Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("NEW Status Filtered Successfully"); 
	   	  }  
	  
	 
	  driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	  driver.findElement(By.xpath("//span[contains(.,'Partial')]")).click();
	  driver.findElement(By.xpath("//td[@role='gridcell'][contains(.,'Partial')]"));
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBP')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- CBP Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("PARTIAL Status Filtered Successfully"); 
	   	  }
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBC')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- CBC Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("PARTIAL Status Filtered Successfully"); 
	   	  }  
	  
	   
	  
	  
	  driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	  driver.findElement(By.xpath("//span[contains(.,'Preparing')]")).click();
	  
	  driver.findElement(By.xpath("//td[@role='gridcell'][contains(.,'PREPARING')]"));
	  
	  
	  

	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'NEW')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   		  
	   	  {
	   		  log.info("PREPARING Status Filtered Successfully"); 
	   	  }
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBP')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("PREPARING Status Filtered Successfully"); 
	   	  }
	  
	  
	   
	  driver.findElement(By.xpath(objectrepo.getProperty("ORDERDROP"))).click();	
	  driver.findElement(By.xpath("//span[contains(.,'Transit')]")).click();
	  driver.findElement(By.xpath("//td[@role='gridcell'][contains(.,'In transit')]"));
	  
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'NEW')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("IN TRANSIT Status Filtered Successfully"); 
	   	  }
	  
	  
	  if (driver.findElements(By.xpath("//td[@role='gridcell'][contains(.,'CBP')]")).size()>0) {
	   	   TakesScreenshot screenshot=(TakesScreenshot)driver;
	   		  // Call method to capture screenshot
	   		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	   		  // Copy files to specific location 
	   		  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
	   		 
	    Assert.fail("Filter not working- NEW Returned ");
	   	  
	      }
	   	  else 
	   		  
	   	  {
	   		  log.info("IN TRANSIT Status Filtered Successfully"); 
	   	  }
	  
	  
	  
	  
	  
	  
		    
	 
		    
		    
			    log.info("End TEST------------- FILTER TEST ORDERS----------");     
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
