package event;

import action.BaseTest;
import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drag_Drop  extends TestUtils
{
	
	ConfigData config = new ConfigData();
	
	public Drag_Drop(WebDriver driver)
	{
		this.driver=driver;
	}
  
	/*public  void dragAndDrop(WebElement from , WebElement to)
	{
		Actions builder  = new Actions(driver);		
		builder.dragAndDrop(from, to).perform();
		Utils Utils=new Utils(driver);
		Utils.waitForElement("");
	}*/
	
	public  void dragdrop(String from, String to) throws Exception
	{
		 //Utils Utils=new Utils(driver);
		 //Utils.waitForElement("");
		ConfigData web = new ConfigData();
	  	 Thread.sleep(5000);

		  Actions builder  = new Actions(driver);  
		  builder.dragAndDrop(driver.findElement(By.xpath(web.getData(from))),driver.findElement(By.xpath(web.getData(from)))).perform();
		  
		  
		  
		  //builder.dragAndDrop(driver.findElement(By.xpath((web.getData(from)), driver.findElement(By.xpath(((Webdriver) driver).getData(to)))).perform();
		  // Utils.waitForElement("");
		  Thread.sleep(5000);
		  
		  try{
			WebDriverWait waitMeasure = new WebDriverWait(driver, 10);
			waitMeasure.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(((ConfigData) driver).getData(from))))));
			waitMeasure.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(((ConfigData) driver).getData(to))))));
			} catch (Exception e){
				try {
					Thread.sleep(Integer.parseInt(((ConfigData) driver).getData("TimeOutInMilliSecs"))/2);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

	}
}
