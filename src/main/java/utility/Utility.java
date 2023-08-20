package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility {
	//common methods
	//scrollIntoView
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	//imlicitWait
	public static void implicitWait(WebDriver driver, long waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting to load page-"+waitTime, true);
	}
	
	//thread time
	public static void threadWait(long waitTime) throws InterruptedException
	{
		Thread.sleep(waitTime);
		Reporter.log("Hold script thread wait-"+waitTime, true);
	}
	
	//screenshot
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String str = RandomString.make(3);
		File dest = new File("C:\\Users\\palla\\EclipseWorksapce\\Flipkart\\screenshots\\"+fileName+"-"+str+".png");
		FileHandler.copy(src, dest);
		Reporter.log("Taking screenshot and stored at-"+dest, true);
	}
	
	//excelsheet
	public static String excelSheet(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		
	FileInputStream myFile = new FileInputStream("C:\\Users\\palla\\EclipseWorksapce\\Flipkart\\excelsheetData\\FlipkartData.xlsx");
	String data = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	Reporter.log("Reading data from excelsheet, row-"+rowNum+", cell-"+cellNum, true);
	return data;	
	}
	
	

}
