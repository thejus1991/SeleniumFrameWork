package SeleniumTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitTest {

	public static void main(String[] args) {
		FluentTest();
	}

	public static void FluentTest()
	{
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectpath+ "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//driver.findElement(By.linkText("Changing Workplaces Everywhere")).click();
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 2 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(2L))
				.ignoring(NoSuchElementException.class,ElementNotInteractableException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement= driver.findElement(By.partialLinkText("Changing Workplaces Everywhere")); 
				
				if(linkElement.isEnabled())
				{
					System.out.println("Element found");
				}
				return linkElement;
			}
		});

		driver.close();
		driver.quit();
	}

}
