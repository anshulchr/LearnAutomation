package dataProvider;
 
import java.io.File;
import java.io.FileInputStream;
 

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File scr = new File("..\\com.hybride.framework\\ApplicationTestData\\AppData.xlsx");
		
		try {
			FileInputStream fi = new FileInputStream(scr);	
			 wb = new XSSFWorkbook(fi);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

		  
		  
	}
	
	public String getData( int sheetIndex, int row, int column)
	{
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	
	}
	 
	public String getData( String sheetName, int row, int column)
	{
		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	
	}	
	 

}
