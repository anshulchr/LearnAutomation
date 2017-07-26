package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Start browser
		  driver = BrowserFactory.getBrowser("chrome");

		// Get Application URL
		driver.get(DataProviderFactory.getConfig().getApplication());
		
		System.out.println("***********Started***************");

	}

	@Test
	public void testHomepage() {

		// calling the HomePage
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String title = home.getApplicationTitle();
		System.out.println("Application Title is" + title);

		Assert.assertTrue(title.contains("Demo Store"));
		
		System.out.println("************Test****************");

	}

	@AfterMethod
	public void closeBrowser() {
		
		BrowserFactory.closeBrowser(driver);
		System.out.println("****************************");
	}

}

