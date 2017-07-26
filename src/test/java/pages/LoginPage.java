package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		
	}
	@FindBy(xpath="//input[@name='email']")WebElement uname;
	
	@FindBy(xpath="//input[@name='passwd']")WebElement passwd;
	
	@FindBy(xpath="//input[@value='Sign In']")WebElement signIn;
	
	By signOut = By.xpath("//div[@class='pre-header']//a[text90='Sign Out']");
	
	
	public void loginApplication(String username, String password)
	{
		
		uname.sendKeys(username);
		passwd.sendKeys(password);
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		signIn.click();
	}
	
	public void verifyLogut()
	{
		WebDriverWait wait = new WebDriverWait(driver,1);
	 
		
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signOut));
	String text = ele.getText();
	Assert.assertEquals(text, "Sign Out","Sign out link not verified");
	
	}

}
