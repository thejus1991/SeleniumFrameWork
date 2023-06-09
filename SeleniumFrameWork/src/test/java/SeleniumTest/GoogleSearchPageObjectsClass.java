 package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import googleSearchPages.GoogleSearchPageObjects;

public class GoogleSearchPageObjectsClass {

	public static void main(String[] args) {
		GoogleSearch();
	}
	
		public static void GoogleSearch() 
		{
			String ProjectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			GoogleSearchPageObjects PageObject = new GoogleSearchPageObjects(driver);
			
			driver.get("https://google.com");
			PageObject.EnterTextInGoogleSearch("Automation");
			PageObject.SubmitTextInGoogleSearch();
			System.out.println("Test completed");
			driver.close();
			driver.quit();
		

	}

}
