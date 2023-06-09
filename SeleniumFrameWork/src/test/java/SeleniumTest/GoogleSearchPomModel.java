 package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import googleSearchPages.GoogleSearchPOMObjects;

public class GoogleSearchPomModel {

	public static void main(String[] args) {
		GoogleSearch();
	}
	
		public static void GoogleSearch() 
		{
			String ProjectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://google.com");
			//POM
			GoogleSearchPOMObjects.GoogleSearchtextbox(driver).sendKeys("Automation");
			GoogleSearchPOMObjects.GoogleSearchtextbox(driver).sendKeys(Keys.RETURN);
			System.out.println("Test completed");
			driver.close();
			driver.quit();
		

	}

}
