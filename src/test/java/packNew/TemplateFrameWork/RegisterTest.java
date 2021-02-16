package packNew.TemplateFrameWork;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataDriven.DataReaderFromExcel;

public class RegisterTest extends TestBase
{
  
	@DataProvider(name = "data")
	public Object[][] Get_TestData () throws IOException
	{
		DataReaderFromExcel obj = new DataReaderFromExcel();
		// Number of columns is 4 and index tab is 0
		return obj.GetDataFromExcel(4,0);
	}
	
	
	//The number of excel sheet columns should be the same function parameters number
	@Test(dataProvider = "data")
	public void UserRegisterMethod(String fname, String lname, String mail, String cmail)
	{
		RegisterPage RegObj = new RegisterPage(driver);
		RegObj.registerMethod(fname, lname, mail, cmail);
		assertEquals("expected message", RegObj.returnValidationMessage());

	
	}
	
}
