package utility;

import java.io.File;
 

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 

public class Screenshot {
	
	
	
	public static String screenshot(WebDriver driver,String screenshotName)
	{ 
		
	TakesScreenshot ts =(TakesScreenshot)driver;
		
	try {
		File scr= 	ts.getScreenshotAs(OutputType.FILE);
			
		FileUtils.copyDirectory(scr, new File("./Screenshots"+ screenshotName+".png"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
		
		return "Scrrenshot taken";
	}

}
