package BizAutoFramework.BizAutomation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BizAutoFramework.PageObjects.CartPage;
import BizAutoFramework.PageObjects.ProductCatalogue;
import BizAutoFramework.TestComponents.BaseTest;

public class StandaloneTestDatafromJsonFile extends BaseTest {

	@Test(dataProvider="getData")
	public void SubmitOrderDataFromJsonFile(HashMap<String,String> input) throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		
		//String ProductName = "ZARA COAT 3";
		//LandingPage landing = launchApplication();
		ProductCatalogue pc = lp.loginApplication(input.get("email"), input.get("password"));
		
		
		
		//ProductCatalogue pc = new ProductCatalogue(driver);
		List<WebElement> products = pc.getproductList();
		pc.addProductToCart(input.get("ProductName"));
		
		
		
		
		
		
		pc.goToCartPage();
		
		
		
		
		
		
		
		
		CartPage cp = new CartPage(driver);
		Boolean match = cp.verifyProductDisplay(input.get("ProductName"));
		Assert.assertTrue(match);
		
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,2000)");
		js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(5000);
		
		cp.goToCheckout();
		
		//driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//driver.quit();
				
		

	}
	
	
	
	
	
	
	
	// Data Driven testing- Getting Data from Json file to our Test Scripts
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//BizAutomation//Data//JSONDataFile.json");
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
