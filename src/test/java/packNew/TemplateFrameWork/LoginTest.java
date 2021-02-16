package packNew.TemplateFrameWork;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase
{

	@BeforeTest
	public void openLoginScreen() throws InterruptedException
	{
		driver.navigate().to("login screen Url");
		Thread.sleep(1000);
	}
	
	
	@Test
	public void TestLoginMethod()
	{
		LoginPage loginObj = new LoginPage(driver);
		loginObj.loginMethod("emilValue", "passValue");
		assertEquals("expected message", "actual message");
	}
}
