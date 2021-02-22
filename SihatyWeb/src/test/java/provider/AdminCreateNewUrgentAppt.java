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
 
public class AdminCreateNewUrgentAppt {
	public WebDriver driver;
	private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private static Workbook wb;
	  private static Sheet sh;
	  private static FileInputStream fis; 
	  private static FileOutputStream fos; 
	  private static Row row;
	  private static Cell cell;

		
	@BeforeTest
	public void openApp() {
		//Launch Browser
		
		  
	  log.info("START TEST-  AdminCreateNewUrgentAppt"); 

		 
	}
	
	@Test
	
	public void testAdminCreateNewUrgentAppt() throws Exception {
	 
		  String filePath = System.getProperty("user.dir");
 	  FileInputStream fis = new FileInputStream(filePath+"/config/Testdata.xlsx");

		BasicConfigurator.configure();
	    Logger log = Logger.getLogger("devpinoyLogger");
	    
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		  XSSFSheet sheet = workbook.getSheet("Credentials");
		  XSSFSheet sheets = workbook.getSheet("Environment");
		  XSSFSheet sheetss = workbook.getSheet("Consultation");

		  Row plaform = sheets.getRow(1);
		  Cell cell11 = plaform.getCell(1);
		  String PLATFORM  = cell11.getStringCellValue();
		  
		  Row validname = sheet.getRow(13);
		  Cell cell = validname.getCell(1);
		  String ValidUsername  = cell.getStringCellValue();
		  
		  Row validpass = sheet.getRow(14);
		  Cell cell1 = validpass.getCell(1);
		  String ValidPassword  = cell1.getStringCellValue();
		 
		  Row STAGEURL= sheets.getRow(2);
		  Cell cell5 = STAGEURL.getCell(1);
		  String EYADASTAGINGURL  = cell5.getStringCellValue();
		  Row PRODURL= sheets.getRow(3);
		  Cell cell4 = PRODURL.getCell(1);
		  String EYADAPRODURL  = cell4.getStringCellValue();
		  
		  Row SIHASTAGEURL= sheets.getRow(4);
		  Cell cell6 = SIHASTAGEURL.getCell(1);
		  String SIHATYSTAGINGURL  = cell6.getStringCellValue();
		  
		  Row SIHATYPROURL= sheets.getRow(5);
		  Cell cell12 = SIHATYPROURL.getCell(1);
		  String SIHATYPRODURL  = cell12.getStringCellValue();
		  
		  Row Doctorname= sheetss.getRow(12);
		  Cell cell7 = Doctorname.getCell(1);
		  String DoctorName  = cell7.getStringCellValue();
		  
		  Row Patientname= sheetss.getRow(13);
		  Cell cell8 = Patientname.getCell(1);
		  String PatientName  = cell8.getStringCellValue();
		  
		  Row adminApptDate= sheetss.getRow(14);
		  Cell cell9 = adminApptDate.getCell(1);
		  String AdminApptDate  = cell9.getStringCellValue();
		  
		  
		  if (PLATFORM.equals("EYADASTAGING")){
	  
			    driver.get(EYADASTAGINGURL); 
			    log.info("Test Execution Started On Eyada Staging");
		  }
		 
		  else if(PLATFORM.equals("EYADAPROD")){
			  driver.get(EYADAPRODURL); 
			   log.info("Test Execution Started On Eyada Production");
		  }
		  else if(PLATFORM.equals("SIHATYSTAGING")){
			  driver.get(SIHATYSTAGINGURL); 
			    log.info("Test Execution Started On Sihaty Staging");

		  }	    
			
		  else if(PLATFORM.equals("SIHATYPROD")){
			  driver.get(SIHATYPRODURL); 
			   log.info("Test Execution Started On Sihaty Production"); 
		  }	    
		  
			 
		 
  driver.findElement(By.xpath("//input[@type='password']")); 
   driver.findElement(By.xpath("//input[contains(@type,'email')]")).click();
 driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(ValidUsername);
 log.info("Invalid Username Entered");
  driver.findElement(By.xpath("//input[@type='password']")).click();
   driver.findElement(By.xpath("//input[@type='password']")).sendKeys(ValidPassword);
   log.info("Invalid password Entered");

   driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
    
   log.info("Login Button Clicked");
   Thread.sleep(5000);

driver.findElement(By.xpath("(//input[contains(@type,'text')])[1]")).click();
driver.findElement(By.xpath("//span[contains(.,'New')]")).click();

Thread.sleep(3000);

driver.findElement(By.xpath("//div[@class='ng-placeholder'][contains(.,'Type of reservation')]"));
driver.findElement(By.xpath("//div[@class='ng-placeholder'][contains(.,'Type of consultation')]"));


driver.findElement(By.xpath("(//input[contains(@type,'text')])[2]")).click();
driver.findElement(By.xpath("//span[contains(.,'Urgent')]")).click();

driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).click();
driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys(DoctorName );
Actions action = new Actions(driver);
action.sendKeys(Keys.ENTER).build().perform();
Thread.sleep(3000);
log.info("Doctor Selected");

driver.findElement(By.xpath("(//input[contains(@type,'text')])[4]")).click();
driver.findElement(By.xpath("(//input[contains(@type,'text')])[4]")).sendKeys(PatientName );
Actions actions = new Actions(driver);
actions.sendKeys(Keys.ENTER).build().perform();
Thread.sleep(3000);
log.info("Patient Selected");

 driver.findElement(By.xpath("//input[contains(@formcontrolname,'date')]")).click();
 driver.findElement(By.xpath("//input[contains(@formcontrolname,'date')]")).sendKeys(AdminApptDate);
 Actions actionss = new Actions(driver);
 actionss.sendKeys(Keys.ENTER).build().perform();
 Thread.sleep(3000);
 log.info("Date Selected");
 
Thread.sleep(4000);

driver.findElement(By.xpath("//span[@class='mat-button-wrapper'][contains(.,':')]")).click();
Thread.sleep(3000);
log.info("Timeslot Selected");

driver.findElement(By.xpath("//button[contains(.,'Create Appointment')]")).click();



driver.findElement(By.xpath("//button[contains(.,'Create Appointment')]")).click();
 
String ApptMessage = driver.findElement(By.xpath("//div[contains(@class,'appointment-form-msg')]")).getText();

log.info("Appintment Message Displayed as ");  
log.info(ApptMessage);
	  log.info("END TEST-  ");  
	  Thread.sleep(2000);
	  String ApptMessages = driver.findElement(By.xpath("//div[contains(@class,'appointment-form-msg')]")).getText();

	  log.info("Appintment Message Displayed as ");  
	  log.info(ApptMessages);
	  	  log.info("END TEST-  ");  

	    }
      
	@BeforeTest
	  public void beforeTest() {
		  String filePath = System.getProperty("user.dir");
			
			System.setProperty("webdriver.chrome.driver",filePath +"//Drivers/chromedriver2"); 
			driver = new ChromeDriver();	
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

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
  
}
