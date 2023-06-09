package SeleniumTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITTest {


	public static void main(String[] args) throws Exception {
		AutoIt();
	}

	public static void AutoIt() throws Exception
	{
		String ProjectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://upload.photobox.com/en/");
		driver.findElement(By.xpath("//*[@id=\"computer_icone_name\"]")).click();
		driver.findElement(By.id("button_desktop")).click();
		Runtime.getRuntime().exec("G:\\Automation\\AutoIT.exe");
		driver.close();
		driver.quit();

	}
}
