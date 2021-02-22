 package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Date;
import java.util.Properties;
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
 
public class utility {
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
	  protected Properties objectrepo;
		
	@BeforeTest
	public void openApp() throws IOException {
		//Launch Browser
	
		baseUrl = "https://wakanow.com/en-ng";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
	  
	
	public void utilityclass() throws Exception {
		//Open wakanow Site
		  String filePath = System.getProperty("user.dir");
 	  FileInputStream fis = new FileInputStream(filePath+"/config/Testdata.xlsx");

	
	    
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		  XSSFSheet sheet = workbook.getSheet("Credentials");
		  XSSFSheet sheets = workbook.getSheet("Environment");
		  

		  objectrepo   = new Properties();
			File objfile = new File(System.getProperty("user.dir")+"//src//test//java//utils/objectrepo.properties");
			FileReader objrepo = new FileReader(objfile);
			objectrepo.load(objrepo);
		  
		  
		  Row plaform = sheets.getRow(1);
		  Cell cell11 = plaform.getCell(1);
		  String PLATFORM  = cell11.getStringCellValue();
		  
		  Row  validname = sheet.getRow(3);
		  Cell cell =  validname.getCell(1);
		  String StageValidUsername  = cell.getStringCellValue();
		  
		  Row validpass = sheet.getRow(4);
		  Cell cell1 =  validpass.getCell(1);
		  String  StageValidPassword  = cell1.getStringCellValue();

		  
		  Row  validnames = sheet.getRow(5);
		  Cell cell2 =  validnames.getCell(1);
		  String ProdValidUsername  = cell2.getStringCellValue();
		  
		  Row validpa = sheet.getRow(6);
		  Cell cell3 =  validpa.getCell(1);
		  String  ProdValidPassword  = cell3.getStringCellValue();
		  
		  
		  Row STAGEURL= sheets.getRow(2);
		  Cell cell5 = STAGEURL.getCell(1);
		  String EYADASTAGINGURL  = cell5.getStringCellValue();
		  
		  Row PRODURL= sheets.getRow(3);
		  Cell cell4 = PRODURL.getCell(1);
		  String EYADAPRODURL  = cell4.getStringCellValue();
		  
		  Row SIHASTAGEURL= sheets.getRow(4);
		  Cell cell6 = SIHASTAGEURL.getCell(1);
		  String SIHATYSTAGINGURL  = cell6.getStringCellValue();
		  
		  
		  Row validu = sheet.getRow(9);
		  Cell cell7 =  validu.getCell(1);
		  String  SihatyStageUsername  = cell7.getStringCellValue();
		  
		  Row validp = sheet.getRow(10);
		  Cell cell8 =  validp.getCell(1);
		  String  SihatyStagePassword  = cell8.getStringCellValue();
		  
		  Row valid = sheet.getRow(11);
		  Cell cell9 =  valid.getCell(1);
		  String  SihatyProdUsername  = cell9.getStringCellValue();
		  
		  Row vali = sheet.getRow(12);
		  Cell cell10 =  vali.getCell(1);
		  String  SihatyProdPassword  = cell10.getStringCellValue();
		  
		  Row SIHATYPROURL= sheets.getRow(5);
		  Cell cell12 = SIHATYPROURL.getCell(1);
		  String SIHATYPRODURL  = cell12.getStringCellValue();
		  
		  
		  
		  
	    
		  if (PLATFORM.equals("EYADASTAGING")){
			  baseUrl = EYADASTAGINGURL ;
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				    driver.get(baseUrl);
			    log.info("Test Execution Started On Eyada Staging");
			 
			    driver.findElement(By.xpath("//input[contains(@type,'email')]")).click();
			  driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(StageValidUsername);
			   driver.findElement(By.xpath("//input[@type='password']")).click();
			    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(StageValidPassword);
			    driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
				   
				   driver.findElement(By.xpath("//span[contains(.,'LOGOUT')]"));
				 
					  log.info("Correct Credentials Validated");
			    
					  
			}
			else if(PLATFORM.equals("EYADAPROD")){
				baseUrl = EYADAPRODURL;
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();  
			    driver.get(baseUrl);
			    log.info("Test Execution Started On Eyada Production");
			    
			    driver.findElement(By.xpath("//input[contains(@type,'email')]")).click();
				  driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(ProdValidUsername);
				  Thread.sleep(2000);
				  driver.findElement(By.xpath("//input[@type='password']")).clear();
				  Thread.sleep(2000);
				    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(ProdValidPassword);
				    driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
					   driver.findElement(By.xpath("//span[contains(.,'LOGOUT')]"));				 
   log.info("Correct Credentials Validated");
			}	
		 
 
	else if(PLATFORM.equals("SIHATYSTAGING")){
		baseUrl = SIHATYSTAGINGURL;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();  
	    driver.get(baseUrl);
	    log.info("Test Execution Started On SIHATY STAGING");
	    
	    driver.findElement(By.xpath("//input[contains(@type,'email')]")).click();
		  driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(SihatyStageUsername);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@type='password']")).clear();
		  Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(SihatyStagePassword);
		    driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
			   driver.findElement(By.xpath("//span[contains(.,'LOGOUT')]"));				 
log.info("Correct Credentials Validated");
	}	
  

	else if(PLATFORM.equals("SIHATYPROD")){
		baseUrl = SIHATYPRODURL;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();  
	    driver.get(baseUrl);
	    log.info("Test Execution Started On SIHATY Production");
	    
	    driver.findElement(By.xpath("//input[contains(@type,'email')]")).click();
		  driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(SihatyProdUsername);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@type='password']")).clear();
		  Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(SihatyProdPassword);
		    driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
			   driver.findElement(By.xpath("//span[contains(.,'LOGOUT')]"));				 
log.info("Correct Credentials Validated");
	}	
  log.info("Valid Login Test Execution Started ");


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

  @BeforeTest
  public void beforeTest() {
	  String filePath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver",filePath +"//Drivers/chromedriver2"); 
		driver = new ChromeDriver();	
  }

  
  
  
  @AfterMethod //AfterMethod annotation - This method executes after every test execution
  public void screenShot(ITestResult result){

  driver.quit();
  }}