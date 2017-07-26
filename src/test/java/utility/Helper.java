package utility;

import java.io.File;
 

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	
	
	public static String screenShot(WebDriver driver, String screenshotName) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		 File scr =ts.getScreenshotAs(OutputType.FILE);
		 
		 String destination ="C:\\Users\\Dell\\practice\\com.hybride.framework"
		 		+ "\\Screenshots\\"+screenshotName+System.currentTimeMillis()+".jpg";
		 
		 
		 
		 FileUtils.copyFile(scr, new File(destination));
		
		return destination;
	}

}
