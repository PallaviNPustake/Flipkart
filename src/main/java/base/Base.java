package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base {
	
   static protected WebDriver driver;
	public void openingBrowser()
	{
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Reporter.log("Opening browser and navingating to Flipkart application", true);
	}

	public void closingBrowser() {
		
		Reporter.log("Closing browser", true);
		driver.quit();
		
	}
}
