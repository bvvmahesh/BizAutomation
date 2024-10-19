package BizAutoFramework.BizAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import BizAutoFramework.PageObjects.CartPage;
import BizAutoFramework.PageObjects.LandingPage;
import BizAutoFramework.PageObjects.ProductCatalogue;

public class StandaloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String ProductName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get("https://rahulshettyacademy.com/client");
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.useremail();
		
		lp.password();
	
		lp.login();
		
		
		//driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("mahesh245@gmail.com");
		//driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Mahesh@123");
		//driver.findElement(By.cssSelector("input[id='login']")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		//List<WebElement> products =  driver.findElements(By.cssSelector(".mb-3"));
		
		//WebElement prod = products.stream().filter(product-> 
		//product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		ProductCatalogue pc = new ProductCatalogue(driver);
		List<WebElement> products = pc.getproductList();
		pc.addProductToCart(ProductName);
		
		
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		pc.goToCartPage();
		
		
		
		
		
		
		//List<WebElement> cartproducts =  driver.findElements(By.cssSelector(".cartSection h3"));
		//Boolean match = cartproducts.stream().anyMatch(cartprod-> cartprod.getText().equalsIgnoreCase(ProductName));
		//Assert.assertTrue(match);
		
		CartPage cp = new CartPage(driver);
		Boolean match = cp.verifyProductDisplay(ProductName);
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
		
		driver.quit();
		
		
		//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
		
		//List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results"));
		
		//countries.stream().filter(country-> 
		//country.findElement(By.cssSelector(".ta-results span i"))
		
		
		
		

	}

}
