package BizAutoFramework.BizAutomation;

import java.io.IOException;
import java.util.ArrayList;

import BizAutomation.Data.DataDrivenFromExcel;

public class DataDrivenFromExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		DataDrivenFromExcel dd =  new DataDrivenFromExcel();
		
		ArrayList data = dd.getDataFromExcel("Add Profile");
		
		System.out.println(data.get(0));
		
		System.out.println(data.get(1));
		
		System.out.println(data.get(2));
		
		System.out.println(data.get(3));
		
		

	}

}
