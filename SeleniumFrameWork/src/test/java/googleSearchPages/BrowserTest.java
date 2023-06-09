package googleSearchPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		String ProjectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.gecko.driver",ProjectPath+"/Drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.ie.driver",ProjectPath+"/Drivers/IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();

		driver.get("https://google.com");
		
		driver.close();
		driver.quit();
	}

}
