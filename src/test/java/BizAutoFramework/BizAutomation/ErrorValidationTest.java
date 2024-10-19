package BizAutoFramework.BizAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BizAutoFramework.TestComponents.BaseTest;
import BizAutoFramework.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups = {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException
	{
		String ProductName = "ZARA COAT 3";
		
		lp.loginApplication("mahesh245@gmail.com", "Mahesh@");
		Assert.assertEquals("Incorrect email or password.",lp.getErrorMessage());
		
		
	}

	

}
