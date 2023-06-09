package googleSearchPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class GoogleSearchPOMObjects {

	static WebElement element =null;
	public static WebElement GoogleSearchtextbox(WebDriver driver) 
	{
			
		element = driver.findElement(By.name("q"));
		return element;
	}
	public static WebElement GoogleSearchbutton(WebDriver driver) 
	{
			
		element = driver.findElement(By.name("btnK"));
		return element;
	}

}
