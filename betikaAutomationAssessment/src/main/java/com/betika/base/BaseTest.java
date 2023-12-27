package com.betika.base;


import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.Parameters;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.betika.utils.ReadConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest extends ReadConfig  {
	
	
	public static WebDriver driver;
	public ExtentSparkReporter spackReporter;
	public ExtentReports extent;
	public static ExtentTest logger;
	public static Logger logs;
	

	@BeforeClass
	
	public void beforeTestMethod() {		
		spackReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator+ "reports"+File.separator+"betikaExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spackReporter);

		spackReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "BETIKA");
		extent.setSystemInfo("Tester", "Usman");
		spackReporter.config().setDocumentTitle("Automation report for BETIKA application");
		spackReporter.config().setReportName("Usman Adewale");
		
		logs= LogManager.getLogger("test automation ");
		logs.info("Logging automation information");
		logs.info(" BETIKA web application under test");
		logs.info(getApplicationUrl());

	}

	@BeforeMethod
	@Parameters({"browser","headless"})
	public void beforeMethodMethod(String browser, Method testMethod, String headless) {
		logs.info(browser +" is the browser i am testing with now"); 
		logger =  extent.createTest(testMethod.getName());
		
		System.out.println(testMethod.getName());
		setUpDriver(browser, headless);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get(getApplicationUrl());
		logs.info(" BETIKA web application under test");
		
		 System.out.println("Checking extent: " + extent);
		    if (extent != null) {
		        extent.createTest("Your Test Name");
		    } else {
		        System.out.println("Extent object is null!");
		    }
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - TestCase Failed" , ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - TestStep Failed" , ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - TestCase Skipped" , ExtentColor.ORANGE));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - TestCase Pass" , ExtentColor.GREEN));
		}
		driver.quit();
		
	}
	
//	@AfterTest
//	public void closeBrowser()
//	{
//		driver.quit();
//	}

	@AfterClass
	public void afterTestMethod() {

		extent.flush();


	}	
	
	@AfterMethod
//	public void afterMethod() {
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - TestCase Failed" , ExtentColor.RED));
//			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - TestStep Failed" , ExtentColor.RED));
//		}
//		else if(result.getStatus() == ITestResult.SKIP) {
//			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - TestCase Skipped" , ExtentColor.ORANGE));
//		}
//		else if(result.getStatus() == ITestResult.SUCCESS) {
//			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - TestCase Pass" , ExtentColor.GREEN));
//		}
//		
//		driver.quit();
//		
//	}

	
	
//	WebDriverManager.chromedriver().setup();
//	ChromeOptions options = new ChromeOptions();
//	options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//	options.addArguments("start-maximized");
//	driver = new ChromeDriver();
//	
//	
//	
	
	
	
	public void setUpDriver(String browser, String headless) {
		if (browser.equalsIgnoreCase("Chrome")) {
			logs.info("Running test with Chrome browser headless");
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200");
			
			 WebDriverManager.chromedriver().setup();
		
				
			//System.setProperty("webdriver.chrome.driver", "/Users/mac/automation-task/betikaAutomationAssessment/drivers/chromedriver.exe");
			if(headless.equalsIgnoreCase("true")) {
			driver = new ChromeDriver(options);
			}
			else
			{
				logs.info("Running test with Chrome browser");
				driver = new ChromeDriver();
			}
		
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				
			logs.info("Running test with firefox browser headless");
			FirefoxOptions options = new FirefoxOptions ();
			options.addArguments("headless");
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe"); 
			if(headless.equalsIgnoreCase("true")) {
				 driver = new FirefoxDriver(options); 
			
		}
			else
			{
				logs.info("Running test with firefox browser");

				 driver = new FirefoxDriver(); 
				
			}
		}
		

		else if (browser.equalsIgnoreCase("edge")) {
			
			logs.info("Running test with edge browser headeless");
			EdgeOptions options=new EdgeOptions();
			options.addArguments("headless");

			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
			if(headless.equalsIgnoreCase("true")) {
				
				driver = new EdgeDriver(options);

			}
			else
			{
				logs.info("Running test with edge browser ");
				driver = new EdgeDriver();
			}

		}

	}
}

