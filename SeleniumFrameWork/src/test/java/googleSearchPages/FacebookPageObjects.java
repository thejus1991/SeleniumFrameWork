package googleSearchPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FacebookPageObjects {

	WebDriver driver=null;
	By fbemail = By.id("email");
	By fbpassword = By.id("pass");
	By fbsubmit = By.name("login");
	
	public FacebookPageObjects(WebDriver driver)
	{
		this.driver =driver;
	}

	public void EnterFbEmail(String email)
	{
		driver.findElement(fbemail).sendKeys(email);
	}
	public void EnterFbPassword(String pass)
	{
		driver.findElement(fbpassword).sendKeys(pass);
	}
	public void FBSubmit()
	{
		driver.findElement(fbsubmit).click();
	}
}
