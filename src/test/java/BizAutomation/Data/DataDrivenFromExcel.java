package BizAutomation.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenFromExcel {

	//public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	public ArrayList<String> getDataFromExcel(String testcaseName) throws IOException
	{
		
	//	1) Create Object for XSSFWORKBOOK class

		ArrayList<String> ar = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\mahesh.bavisetty\\Desktop\\mahesh.xlsx");
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      
      // 2) Get Access to the sheet
      
     int sheets =  workbook.getNumberOfSheets();
      
      for(int i =0; i<sheets;i++)
      {
    	 if( workbook.getSheetName(i).equalsIgnoreCase("testData"))
    	 {
    		 
    		 XSSFSheet sheet =  workbook.getSheetAt(i);
    		 
    		 //Identify TestCases coloumn buy scanning the entire first row
    		 
    		 Iterator<Row> row = sheet.iterator();
    		Row firstrow =  row.next();
    		
    		Iterator<Cell> ce = firstrow.cellIterator(); // row is a collection of cells
    		
    		int k=0;
    		int coloumn = 0;
    		 
    		 while(ce.hasNext())
    		 {
    			 
    			 Cell value = ce.next();
    			 
    			 if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
    			 {
    				 
    				 coloumn=k;
    			 }
    			 
    			 k++;
    			 
    		 }
    		 
    		// System.out.println(coloumn);
    		 
    		 
    // once coloumn is idetified the scan entire TestCases Coloumn to identify purchase testcase row.
    		 
    		 
    		while( row.hasNext())
    		{
    			
    			Row r = row.next();
    			
    			if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
    				
    			{
    			
    				// After we grab Purchase testcase row , Pull all the data of that row and feed into test
    				
    				Iterator<Cell> cv = r.cellIterator();
    				while(cv.hasNext())
    				{
    					
    					//System.out.println(cv.next().getStringCellValue()); 
    					
    					ar.add(cv.next().getStringCellValue());
    				}
    				
    				
    			}
    			
    			//return ar;
    		}
    		
    		 
    	 }
    	  
      }
	return ar;
      


	}
	
	

}
