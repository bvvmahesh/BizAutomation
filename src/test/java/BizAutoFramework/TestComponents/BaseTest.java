package BizAutoFramework.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import BizAutoFramework.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	

	
	public WebDriver InitializeDriver() throws IOException
	
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\BizAutoFramework\\Resources\\GlobalData.Properties");
		prop.load(fis);
		
		//String browserName = prop.getProperty("browser");
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")) {
		options.addArguments("--headless");
		}
		 driver = new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1400,900)); // it helps to run in full screen in headlessmode also
		 
		
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			 FirefoxOptions options = new FirefoxOptions();
		        options.addArguments("--headless");
			driver = new FirefoxDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions();
	        options.addArguments("--headless");
			 driver = new EdgeDriver();
			
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	// Screen shot code ---------------------------
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
			File source = 	ts.getScreenshotAs(OutputType.FILE);
			
			File destFile = new File(System.getProperty("user.dir")+"\\Reports\\"+ testCaseName + ".png");
			FileUtils.copyFile(source, destFile);
			return System.getProperty("user.dir")+"\\Reports\\"+ testCaseName + ".png";
			
	}
	
	//------------------------------------------------------------
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		// it will read/scan the entire json file and convert into a String Variable
		//1) Read Json to String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		
		//2) covert String to HashMap
		//jackson Databind will convert string to HashMap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
		
		//Finally we have a list of HashMaps created
		
	}
	
	
	
	
	
	
	//-----------------------------------------------------------
	
	@BeforeMethod(alwaysRun=true)
	public  LandingPage launchApplication() throws IOException
	{
		
		driver = InitializeDriver();
		 lp = new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		
		driver.quit();
	}
	
}
