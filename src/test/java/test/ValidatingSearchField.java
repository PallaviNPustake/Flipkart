package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pom.HomePage;
import pom.SearchProductPage;
import utility.Utility;

public class ValidatingSearchField extends Base {
	HomePage homepg;
	SearchProductPage sp;
	
	@BeforeClass
	public void launchingFlipkart()
	{
		openingBrowser();
		Utility.implicitWait(driver, 1000);
		homepg = new HomePage(driver);
		homepg.closingLoginPopUp();
		sp = new SearchProductPage(driver);
	}
	
  @Test
  public void validateSearchBar() {
	  
	   boolean searchFlag = homepg.searchBarIsPresent();
	   Assert.assertTrue(searchFlag,"Search bar is not displaying");
	   Utility.implicitWait(driver, 1000);
	   homepg.clickOnSearchField();
	   
	   homepg.enterProductInSearch("Iphone14 pro max");
	  // homepg.clearProductFromSearch();
	   
	   homepg.clickOnSearchICon();
	   Utility.implicitWait(driver, 1000);
	   //homepg.clickOnSearchField();
	  
	   driver.navigate().back();
	//  homepg.clearProductFromSearch();
	  homepg.enterProductInSearch("Laptop");
       
	  
	  // homepg.getListOfProducts();
  }
 
   
}
