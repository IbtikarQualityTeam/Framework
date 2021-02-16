package packNew.TemplateFrameWork;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver;
	
	//Called implicitly at the start of each test
	@BeforeSuite
	public void startDriver()
	{
		WebDriverManager.chromedriver().setup(); // You can replace .chromedriver with any other browser "FireFoxdriver" or "Safaridriver"
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://cb-demo-dashboard.monshaat.sa/");
	}
	
	//Called implicitly at the end of each test
	@AfterSuite
	public void endDriver()
	{
		
		driver.quit();
	}
	
	// To take screen shot in case of the test failure 
	@AfterMethod
	public void takeScreenShotWhenFailure(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
		   TakesScreenshot ts = (TakesScreenshot) driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(source,new File("/ScreenShots/"+result.getName()+".png"));
		}
		
	}
	
	//Click enter button of keyboard
	public void clickEnterAction()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		action.perform();
		
	}
	
	//Click Escape button of keyboard
	public void clickESCAction()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		action.perform();
		
	}

}
