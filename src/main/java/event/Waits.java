package event;

import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import action.BaseTest;
import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits extends TestUtils {
	
	public Waits(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public  void waitUntil_Elmentis_visibilityOfElement(int timetowait , String xpath)
	{
		try 
		{
			WebDriverWait wait  =  new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}  
		
	}
	
	public void waituUnitil_Element_InvisiblityofElement(int timetowait , String xpath) 
	{
		
		WebDriverWait wait1 = new WebDriverWait(driver,timetowait);
		  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath((xpath))));
		
	}
	
	
	public void waituUnitil_Element_Clickable(int timetowait , String xpath) 
	{
		
		WebDriverWait wait1 = new WebDriverWait(driver,timetowait);
		  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath((xpath))));
		
	}
	
	
	public  boolean isClickable(WebElement webe)      
	{
	try
	{
		WebDriverWait wait  =  new WebDriverWait(driver,10);
	   wait.until(ExpectedConditions.elementToBeClickable(webe));
	   return true;
	}
	catch (Exception e)
	{
	  return false;
	}
	
//	public void fulientWait() 
//	{
//		 		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
//		 			withTimeout(30,TimeUnit.SECONDS)			       
//			       .pollingEvery(1, TimeUnit.SECONDS)
//			       .ignoring(NoSuchElementException.class);
//			 
//			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//			     public WebElement apply(WebDriver driver) {
//			       return driver.findElement(By.id("foo"));
//			     }
//			   });
//	}
	
	
}
}