package dataProvider;

import java.io.File;
import java.io.FileInputStream;
 
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro ;
	
	public ConfigDataProvider()
	{
		File scr = new File("./Configuration/config.properties");
		try {
			
			
			FileInputStream fi = new FileInputStream(scr);
			pro = new Properties();
			
			pro.load(fi);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
		  System.out.println(e.getMessage());;
		}
		 
	}
	public String getApplication()
	{
		String url = pro.getProperty("url");
	return url;
	}
	
	 
	public String getIEpath()
	{
		String IEpath = pro.getProperty("IEPath");
		return IEpath;
		
	}

}
