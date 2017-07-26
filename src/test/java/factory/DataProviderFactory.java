package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	public static  ConfigDataProvider getConfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
		
	}
	
	
	public static  ExcelDataProvider getExcelConfig()
	{
		ExcelDataProvider excelconfig = new ExcelDataProvider();
		return excelconfig;
		
	}

}
