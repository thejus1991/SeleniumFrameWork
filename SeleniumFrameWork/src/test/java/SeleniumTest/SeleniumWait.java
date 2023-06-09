package SeleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {
	static WebDriver driver=null;
	public static void main(String[] args) {
		
			String ProjectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://google.com");
			driver.findElement(By.name("q")).sendKeys("Selenium");
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
			driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
			
			System.out.println("Test completed");
			driver.close();
			driver.quit();
		}	
		
		
	

}
