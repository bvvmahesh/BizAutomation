package BizAutoFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BizAutoFramework.AbstarctComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	
WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	
	{
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

}
