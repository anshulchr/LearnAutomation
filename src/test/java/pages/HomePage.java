package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	public  HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//a[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[text()='My cart']")
	WebElement myCart;
	
	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement checkOut;

	public void signInLink() {
		signIn.click();
	}

	public void myAccountLink() {
		myAccount.click();
	}

	public void myCartLink() {
		myCart.click();
	}

	public void checkOutLink() {
		checkOut.click();
	}
	
	public String getApplicationTitle()
	{
		 return driver.getTitle();
	}
}
