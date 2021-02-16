package packNew.TemplateFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//List of all page elements which need in the script 	
	
	@FindBy(id = "fld_email")
	WebElement email;

	@FindBy(id = "fld_pass")
	WebElement pass;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[14]/div/button")
	WebElement login_btn;
	
	void loginMethod(String Email,String Password)
	{
		email.sendKeys(Email);
		pass.sendKeys(Password);
		login_btn.click();
	}
}
