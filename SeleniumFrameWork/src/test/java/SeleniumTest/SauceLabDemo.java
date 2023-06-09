package SeleniumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceLabDemo {
	
	public class SeleniumTest {
		WebDriver driver=null;
	    @BeforeMethod
	    public void setup() throws MalformedURLException  {
	    	ChromeOptions browserOptions = new ChromeOptions();
	    	browserOptions.setPlatformName("Windows 11");
	    	browserOptions.setBrowserVersion("latest");
	    	Map<String, Object> sauceOptions = new HashMap<String, Object>();
	    	sauceOptions.put("username", "oauth-theju2007-0d15d");
	    	sauceOptions.put("accessKey", "5fa08a9c-07ea-463f-9a7b-0291fbc6503c");
	    	sauceOptions.put("build", "selenium-build-375UH");
	    	sauceOptions.put("name", "Selenium Test1");
	    	browserOptions.setCapability("sauce:options", sauceOptions);
	    	URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	    	driver = new RemoteWebDriver(url, browserOptions);
	    }

	    @Test
	    public void correctTitle() {
	    	driver.get("https://google.com");
			System.out.println(driver.getTitle());
			driver.findElement(By.name("q")).sendKeys("Selenium");
			driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
			System.out.println("Completed");
	    }

	    @AfterMethod
	    public void teardown() {
	       driver.close();
	       driver.quit();
	    }
	}

	

}
