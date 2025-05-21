package features;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;
import junit.framework.Assert;

public class TestCase_37142 extends TestUtils
{
	Login log = null;
	Waits waits =null;
	Utils Utils = null;
	Login_BKP Create_Report=null;
	event.Excelnput Excelnput=null;
	
  @Test
  @Parameters("browser")
  public void f(String browser) throws Exception 
  {
	    System.out.println("37142--Testcase started........");
	  	//login to the application:================
	  	test =extent.createTest("Test Case 35808: Filter_LL_Value By Entry_Enter any element into filter from the middle of the list.");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");
	  	
	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  	
	  	System.out.println("Test Case 35808: Filter_LL_Value By Entry_Enter any element into filter from the middle of the list.===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000); 
	  	
	  //Open CM Manufacture ratio:=================
	  	log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		Thread.sleep(5000);
  		
  		//Take Count After open:===========
  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Sales by country']"));
  	  	
  	  	System.out.println("list of report is:->"+ReportCount.size());
  	  	try
  	  	{
  	  		if(ReportCount.size()>2)
  	  		{
  	  			System.out.println("Required Report is opened now");
  	  		}
  	  		
  	  	}catch(Exception e)
  	  		{
  	  			System.out.println("Need to click again.");
  	  			log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(3000);
	  	
  	  	//Check for Check boxes of element click:=================
  	  	Actions act_Check=new Actions(log.driver);
  	  	act_Check.contextClick(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::input[1]"))).perform();;
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Enable selection by drop-down menu']/span[@class='k-icon k-i-checkbox-checked']")).isDisplayed())
			{
				System.out.println("Enable selction drop down check box is checked.");
				Thread.sleep(3000);
				log.driver.navigate().refresh();
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Enable selction drop down check box is not checked,so need to check.");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//span[text()=' Enable selection by drop-down menu']")).click();
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		
		//Click on Filter Drop down icon and validate:================
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::span[4]")).click();
		Utils.waitForElement("");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).isDisplayed());
  	  	Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]/following::div[@role='tree'][1]")).isDisplayed());
  	  	Thread.sleep(1000);
		System.out.println("Type here to search text and Filter list are displaying now.");
	 	Thread.sleep(1000);
	 	
		//Type any Element in the middle of list and click enter:================
		log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).sendKeys("Honda");
		Utils.waitForElement("");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).sendKeys(Keys.ENTER);
		Utils.waitForElement("");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]/following::div[@role='tree'][1]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Validate After change:=============
		String FstValue=log.driver.findElement(By.xpath("//div[@id=\"0/0\"]")).getText();
		Thread.sleep(2000);
		System.out.println("Fst Value is:->"+FstValue);
		Thread.sleep(2000);
		
		
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::span[4]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).sendKeys("All Products");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).sendKeys(Keys.ENTER);
		Utils.waitForElement("");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]/following::div[@role='tree'][1]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String SndValue=log.driver.findElement(By.xpath("//div[@id=\"0/0\"]")).getText();
	  	
		if(FstValue==SndValue)
		{
			System.out.println("Text Value is equal,so Search filter is not working as expected.");
		}
		else
		{
			System.out.println("Text Value is not equal,so Search filter is working as expected.");
		}
		//Drop down and verify:================
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::span[4]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='All Products']")).click();
		Thread.sleep(2000);
		/*Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);	
        Thread.sleep(2000);	*/
		
		for(int i=0;i<=20;i++)
		{
			Robot robot = new Robot(); 
			robot.keyPress(KeyEvent.VK_DOWN);	
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//span[text()='All Products']")).isDisplayed());
        System.out.println("Page down is working as expected.");
        
	  	
	  	
  }
}
