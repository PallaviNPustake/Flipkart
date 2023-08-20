package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class SearchProductPage extends Base {
	
	@FindBy(xpath = "(//div[@class='_13oc-S'])[1]") private WebElement firstProductField;
	
	
	
	//initialize
	public SearchProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFirstProductField()
	{
		firstProductField.click();
	}
	
	
	
}
