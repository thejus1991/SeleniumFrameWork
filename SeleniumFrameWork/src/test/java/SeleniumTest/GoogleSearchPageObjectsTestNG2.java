 package SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import googleSearchPages.GoogleSearchPageObjects;

public class GoogleSearchPageObjectsTestNG2 {
	 WebDriver driver =null;
	@SuppressWarnings("deprecation")
	@BeforeTest
		public  void InitialiseBrowser()
		{
			String ProjectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
	 @Test
		public void GoogleSearch2() throws InterruptedException 
		{	
			GoogleSearchPageObjects PageObject = new GoogleSearchPageObjects(driver);
			driver.get("https://google.com");
			PageObject.EnterTextInGoogleSearch("Automation");
			PageObject.SubmitTextInGoogleSearch();
			System.out.println("Test completed");
			Thread.sleep(3000);
			
		}
	 @AfterTest
		public void TearDown()
		{
			driver.close();
			driver.quit();
		}

}
