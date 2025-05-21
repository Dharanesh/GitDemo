package smokeCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;

public class TestCase_37305 extends TestUtils
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
	  	System.out.println("37305---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase-37305: Cockpit Data Mashup Drill down");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("======TestCase-25042: Cockpit Data Mashup Drill down======");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  	//Open Sales By Country Report:==============
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
  	  	Thread.sleep(5000);
	  	
  	  	//Click Data view link and proceed:============
  	  	log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	  	Utils.waitForElement("");
  	  	//Click Measure and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Columns window is displaying now.");
		Thread.sleep(1000);
  	  	
		//Remove All Items and Validate base elemnt list:============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Base elements with containers having Zero Element is displaying now after remove all.");
		Thread.sleep(1000);
	  	
		log.driver.findElement(By.xpath("//div[text()='2014']")).click();
		Thread.sleep(3000);
		//log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		//Thread.sleep(3000);
		
		//Add Mashup:================
		//Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act2=new Actions(log.driver);
        //act2.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);
        act2.click(e2).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
	  	 
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Calculated element check boxs are unchecked.");
		 Thread.sleep(1000);
		
		 //Rank Ascending element should be visible:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("MASHUP text is displaying now..");
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("MASHUP checkbox is unchecked..");
		 log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
	  	
		 //Click on fst cel then shift to end:====
		/* log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
		 Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyRelease(KeyEvent.VK_RIGHT); 
	     Thread.sleep(1000);*/
		 
		 //Mashup is Added to the table verify:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
	 	 Thread.sleep(1000);
		 System.out.println("MASHUP is added in Table.");
		 Thread.sleep(1000);
		 
		 //Add Mashup value:===============
		 //Mashup cell should display write on rightclick opt:=====
		 log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).click();
		 Thread.sleep(1000);
		 Actions act=new Actions(log.driver);
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		 Thread.sleep(2000);
		 try 
		 {
			if(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed())
			{
				System.out.println("Single data Cell window is displaying.");
				Thread.sleep(1000);
			}
		 }catch(Exception e)
		 {
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).build().perform();
			Thread.sleep(2000);
		 }
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Single data Cell window is displaying.");
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Write text is displaying.");
		
		 //Verify Write window after click on same:===========
		 log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Cell Value']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Cell Value window is displaying.");
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Help']")).isEnabled());
		 Thread.sleep(1000);
		 System.out.println("Write window buttons are enabled.");
		
		//enter input value for mashup cell:===========
		//=E1
		//String Value="="+"getcellvalue"+"("+"1"+","+"1"+","+"\""+"MDX-Sales"+"\""+")";
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String FstRowMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		
		System.out.println("Mashup Cell value is:->"+FstRowMashupValue);
		Thread.sleep(1000);
		//2nd Value Type:====
		
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']"))).perform();
		Thread.sleep(1000);
		
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed())
			{
				System.out.println("Single data Cell window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']"))).build().perform();
			Thread.sleep(2000);
		}
		
		
		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String FstRowMashupValue2=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']")).getText();
		Thread.sleep(2000);
		System.out.println(" 2nd Mashup Cell value is:->"+FstRowMashupValue2);
		Thread.sleep(1000);
		log.driver.navigate().refresh();
		Thread.sleep(2000);
		//Double lick on fst row:==================
		log.driver.findElement(By.xpath("//div[@id='-1/0']")).click();
		Thread.sleep(1000);
	
		act.doubleClick(log.driver.findElement(By.xpath("//div[@id='-1/0']"))).perform();
		Thread.sleep(2000);
		act.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/0']"))).perform();
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed())
			{
				System.out.println("Navigate window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/0']"))).build().perform();
			Thread.sleep(2000);
		}
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed());
		Thread.sleep(1000);
		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='Navigate']"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Expand']")).click();
		Thread.sleep(2000);
		
		//===============
		act.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/0']"))).perform();
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed())
			{
				System.out.println("Navigate window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/0']"))).build().perform();
			Thread.sleep(2000);
		}
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed());
		Thread.sleep(1000);
		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='Navigate']"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Collapse']")).click();
		Thread.sleep(2000);
		
		//Backup
		act.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/0']"))).perform();
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed())
			{
				System.out.println("Navigate window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/0']"))).build().perform();
			Thread.sleep(2000);
		}
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed());
		Thread.sleep(1000);
		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='Navigate']"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='DrillDown'])[1]")).click();
		Thread.sleep(2000);
		
		//Right click And Proceed::================
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='Australia']"))).perform();
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed())
			{
				System.out.println("Navigate window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='Australia']"))).build().perform();
			Thread.sleep(2000);
		}
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed());
		Thread.sleep(1000);
		
		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='Navigate']"))).perform();
		Thread.sleep(1000);
		
		//Drill Down:======================
		//log.driver.findElement(By.xpath("//span[text()='Collapse to Parent']")).click();
		log.driver.findElement(By.xpath("(//span[text()='DrillDown'])[1]")).click();

		Thread.sleep(1000);
		//Rightclick on AllCustomer and Do DillDown:===========
		//div[text()='All Customers']
		/*act.contextClick(log.driver.findElement(By.xpath("//div[text()='All Customers']"))).perform();
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed())
			{
				System.out.println("Navigate window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='All Customers']"))).build().perform();
			Thread.sleep(2000);
		}
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed());
		Thread.sleep(1000);
		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='Navigate']"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='DrillDown'])[1]")).click();
		Thread.sleep(1000);
		
		//2nd Value Type:====
		String ValueAfterDrillDown=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
	  	
	  	//Assert.assertEquals(ValueAfterDrillDown, FstRowMashupValue2);
		int count=0;
	  	if(!(ValueAfterDrillDown.equals(FstRowMashupValue2)))
	  	{
	  		count++;
	  	}
	  	Assert.assertEquals(0,count);
	  	Thread.sleep(1000);
	  	System.out.println("Drill Down with Mashup value is working as expected.");
	  	Thread.sleep(1000);
	  	log.driver.close();
	  	Thread.sleep(1000);*/
		log.driver.close();
  }
  
}
