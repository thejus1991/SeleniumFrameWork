	package googleSearchPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
  WebDriver driver =null;
  By GooglePage_textbox_search = By.name("q");
  By GooglePage_submit = By.name("btnK");
  
  public GoogleSearchPageObjects(WebDriver driver) {
	  this.driver=driver;
  }
  
  public void EnterTextInGoogleSearch(String text) {
	  driver.findElement(GooglePage_textbox_search).sendKeys(text);
  }
  public void SubmitTextInGoogleSearch() {
	  driver.findElement(GooglePage_submit).sendKeys(Keys.RETURN);
  }
}
