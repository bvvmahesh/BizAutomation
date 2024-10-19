package BizAutoFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BizAutoFramework.AbstarctComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	
		
		WebDriver driver;
		
		public LandingPage(WebDriver driver)
		
		{
		    super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		
		// Page Factory
		
		@FindBy(xpath="//input[@id='userEmail']")
		WebElement useremail;
		
		@FindBy(xpath="//input[@id='userPassword']")
		WebElement password;
		
		@FindBy(css="input[id='login']")
		WebElement login;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		public void goTo()
		{
			
			driver.get("https://rahulshettyacademy.com/client");
			
		}
		
		public void useremail()
		{
			
			useremail.sendKeys("mahesh245@gmail.com");
		}
		
		public void password()
		{
			
			password.sendKeys("Mahesh@123");
		}
		
		public void login()
		{
			
			login.click();
		}
		
		public ProductCatalogue loginApplication(String username, String pass)
		{
			
			useremail.sendKeys(username);
			password.sendKeys(pass);
			login.click();
			ProductCatalogue pc = new ProductCatalogue(driver);
			return pc;
		}
		
		public String getErrorMessage()
		{
			waitforWebElementAppear(errorMessage);
			return errorMessage.getText();
			
			
		}

}
