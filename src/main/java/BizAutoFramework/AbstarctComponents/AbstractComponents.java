package BizAutoFramework.AbstarctComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;

		public AbstractComponents(WebDriver driver) {
		
			
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
	}

		
		@FindBy(css="[routerlink*='cart']")
		WebElement cart;
		
		
		
		
		public void waitforElementAppear(By findBy)
		{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
		}
		
		public void waitforWebElementAppear(WebElement findBy)
		{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
		}
	
		public void waitForElementtoDisappear(WebElement waitdis) throws InterruptedException
		{
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			//wait.until(ExpectedConditions.invisibilityOf(waitdis));
			
			Thread.sleep(2000);
		}
		
		
		public void goToCartPage()
		{
			cart.click();
		}
		
		
		
}
