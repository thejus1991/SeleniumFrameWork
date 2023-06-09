package SeleniumTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.channel.pool.FixedChannelPool.AcquireTimeoutAction;

public class HeadlessBrowsers {

	public static void main(String[] args) {
		Headless();
	}
		
		public static void Headless()
		{
			String ProjectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1368,768");
			WebDriver driver = new ChromeDriver(option);
					
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://google.com");
			System.out.println(driver.getTitle());
			driver.findElement(By.name("q")).sendKeys("Selenium");
			driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
			System.out.println("Completed");
			driver.close();
			driver.quit();
		}
	}

	

