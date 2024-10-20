package BizAutoFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BizAutoFramework.AbstarctComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	
		
		WebDriver driver;
		
		public ProductCatalogue(WebDriver driver)
		
		{
		     super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		
		
		// Page Factory
		
		@FindBy(css=".mb-3")
	    List<WebElement> products;
		
		
		
		@FindBy(css=".ng-animating")
		WebElement waitdisapper;
		
		
		
		
		By productBy = By.cssSelector(".mb-3");
		By addToCart = By.cssSelector(".card-body button:last-of-type");
		By toast = By.cssSelector("#toast-container");
		
		public List<WebElement> getproductList()
		{
			waitforElementAppear(productBy);
			return products;
			
			
		}
		
		public WebElement getProductByName(String ProductName)
		{
			
			
			WebElement prod = getproductList().stream().filter(product-> 
			product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		    return prod;
		
		}
		
		public void addProductToCart(String ProductName) throws InterruptedException
		{
			
			WebElement prod = getProductByName(ProductName);
			prod.findElement(addToCart).click();
			waitforElementAppear(toast);
			waitForElementtoDisappear(waitdisapper);
			
		}
		
		

}
