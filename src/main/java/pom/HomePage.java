package pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import base.Base;

public class HomePage extends Base {

@FindBy(xpath = "//button[text()='✕']") private WebElement closeLoginPopUp;
@FindBy(xpath = "//input[@name='q']") private WebElement searchField;
@FindBy(xpath = "//button[@type='submit']") private WebElement searchIcon;
@FindBy(xpath = "//ul[@class='col-12-12 _1MRYA1 _38UFBk']/li") private List<WebElement> listElements;

//initalizing
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilizing
public void closingLoginPopUp()
{
	if(closeLoginPopUp.isDisplayed())
	{
	closeLoginPopUp.click();
	Reporter.log("Closed login popup", true);
	}
}
public boolean searchBarIsPresent()
{
	boolean searchStatus = searchField.isDisplayed();
	return searchStatus;
}
public void clickOnSearchField()
{
	searchField.click();
}
 public void enterProductInSearch(String productName)
 {
	 searchField.sendKeys(productName);
	 Reporter.log("Entering product in search bar"+productName,true);
	
 }
 
 public void clearProductFromSearch()
 {
	 //searchField.clear();
	 Actions act = new Actions(driver);
	 act.moveToElement(searchField).doubleClick().click().sendKeys(Keys.DELETE);
 }
 public void clickOnSearchICon()
 {
	 searchIcon.click();
	 Reporter.log("Clickinf on search icon",true);
 }
public List<WebElement> getListOfProducts()
{
	Reporter.log("Search products-",true);
	for(WebElement li:listElements)
	{
		Reporter.log(li.getText(), true);
		String expectedName = "iphone 14pro max";
	
		if(expectedName.equals(li.getText()))
		{
			li.click();
			break;
		}
	
	}
	return listElements;	
}

}
