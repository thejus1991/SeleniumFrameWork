package SeleniumTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utlity.XLFileUtils;
import googleSearchPages.FacebookPageObjects;

public class FBLoginPage {
	WebDriver driver =null;
	
	String ProjectPath = System.getProperty("user.dir");
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Browser() 
	{	
		System.setProperty("WebDriver.chrome.driver", ProjectPath+ "/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Test(dataProvider = "LoginData")
	public void loginpage(String User,String Password) throws Exception
	{	
	driver.get("https://www.facebook.com/");
	FacebookPageObjects FPObj = new FacebookPageObjects(driver);
	FPObj.EnterFbEmail(User);
	FPObj.EnterFbPassword(Password);
	FPObj.FBSubmit();
	Thread.sleep(3000);	
	String actualTitle = "Facebook";
	String expectedTitle = driver.getTitle();
	System.out.println(expectedTitle);
		if(expectedTitle.equals(actualTitle))
		{
			Assert.assertTrue(true); 
		}
		else
			Assert.assertFalse(true, "Login Failed");
	}
	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException
	{
		
		String path = ProjectPath+"/src/main/resources/ExcelFiles/LoginData.xlsx";
		XLFileUtils XLFUtil = new XLFileUtils(path);
		int totalrows = XLFUtil.getRowCount("Sheet1");
		int totalcolumn = XLFUtil.getCellCount("Sheet1", 1);
		String loginData[][] = new String[totalrows][totalcolumn];
		
		for(int i=1 ; i<=totalrows ; i++)
			{
			for(int j=0;j<totalcolumn;j++)
				{
				loginData[i-1][j]=XLFUtil.getCellData("Sheet1", i, j);
				}	
			}
			return loginData;
		
	}
	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}

}


