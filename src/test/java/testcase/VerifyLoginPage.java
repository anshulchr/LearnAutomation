package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPage {
	WebDriver driver;

	 ExtentReports report;
	 ExtentTest logger;
	 
	 
	
	@BeforeMethod
	public void setUp() {
		
		report = new ExtentReports("./Reports/LoginBrowser.html");
		// logger = new ExtentTest("Veify Login Page", "This page will verify sign out link");
		 
		logger = report.startTest("Veify Login Page", "This page will verify sign out link");
		// Start browser
		  driver = BrowserFactory.getBrowser("chrome");
		  logger.log(LogStatus.INFO, "Application is up and running.");
		  
		// Get Application URL
		driver.get(DataProviderFactory.getConfig().getApplication());
		logger.log(LogStatus.PASS, "Application is opended.");
		 
	
	}

	@Test
	public void testHomepage() throws Exception {
		
		// calling the HomePage
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String title = home.getApplicationTitle();
		System.out.println("Application Title is" + title);
		Assert.assertTrue(title.contains("Demo Sto,re"));
		logger.log(LogStatus.PASS, "Application Title verifed.");
		
		home.signInLink();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getExcelConfig().getData(0, 0, 0), DataProviderFactory.getExcelConfig().getData(0, 0, 1));
		
	//	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.screenShot(driver,"UNscreenshot")));
		
		logger.log(LogStatus.INFO, "Application data entered.");
		
		
	  //  login.verifyLogut();
	//    logger.log(LogStatus.INFO, "Application is logout.");
	    
	    
	//	login.loginApplication("mukesh@selenium.com", "mukesh@selenium.com");
		//DataProviderFactory.getExcelConfig().getData("Sheet1", 0, 1);

	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			try {
				String path = Helper.screenShot(driver,result.getName());

				// Attached screenshot to report for failed case
				logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
			} catch (Exception e) {
				 System.out.println(e.getMessage());
			}
			
			
		}
		
		
		
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
		
	}

}

