package BizAutoFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BizAutoFramework.AbstarctComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	
	{
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	// Page Factory
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	
	
	public Boolean verifyProductDisplay(String ProductName)
	{
		
		Boolean match = productTitles.stream().anyMatch(cartprod-> cartprod.getText().equalsIgnoreCase(ProductName));
	    return match;
	
	}
	
	public void goToCheckout()
	{
		
		checkoutele.click();
	}

}
