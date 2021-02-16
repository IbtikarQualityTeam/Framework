package packNew.TemplateFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase
{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(name = "first_name")
	WebElement first_name;

	@FindBy(name = "last_name")
	WebElement last_name;

	@FindBy(name = "fld_email")
	WebElement email;

	@FindBy(id = "fld_cemail")
	WebElement confirm_email;
	
	@FindBy(xpath = "//*[@id=\"contact_form\"]/fieldset/div[14]/div/button")
	WebElement submit_btn;
	
	@FindBy(id = "valid_message")
	WebElement validation;

	
	public void registerMethod(String FirstName,String LastName,String Email,String ConfirmEmail)
	{
		first_name.sendKeys(FirstName);
		last_name.sendKeys(LastName);
		email.sendKeys(Email);
		confirm_email.sendKeys(ConfirmEmail);
		submit_btn.click();
	}
	
	public String returnValidationMessage()
	{
		return validation.getText();
	}
	
}
