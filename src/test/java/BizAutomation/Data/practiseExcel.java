package BizAutomation.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practiseExcel {

	static public void getData() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\mahesh.bavisetty\\Desktop\\mahesh.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testData"))
			{
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				XSSFRow firstrow = sheet.getRow(0);
				XSSFRow secondrow = sheet.getRow(1);
				
				String ce = firstrow.getCell(i).getStringCellValue();
				String ce1 = secondrow.getCell(i).getStringCellValue();
				
				System.out.println(ce);
				System.out.println(ce1);
				
				
			}
		
		//XSSFSheet sheets = workbook.getSheetAt(0);
		
		//String dataRow = sheets.getRow(0).getCell(0).getStringCellValue();
		
		
	//	System.out.println(dataRow);
		
		
		
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getData();
	}

}
