package BizAutomation.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataBaseSQL {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/databasename" , "root", "root");
		
	    Statement s=con.createStatement();
	    
	    ResultSet rs =  s.executeQuery("Select * from credentilas where scenario='Zerobalanceaccount'");
		
	    
	   while(rs.next())
	   {
	    
	    String user = rs.getString("username");
	   
	    String pass = rs.getString("Password");
	    }
		
	   
	   WebDriver driver = new ChromeDriver();
	   
	   driver.get("");
	   
	   driver.findElement(By.xpath("")).sendKeys(rs.getString("username"));
	   
	   
	   driver.findElement(By.xpath("")).sendKeys(rs.getString("password"));
	   
	   
	   
	   
	   
	}

}
