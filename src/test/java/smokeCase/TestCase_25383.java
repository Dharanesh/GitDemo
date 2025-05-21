package smokeCase;

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

public class TestCase_25383 extends TestUtils
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
	    System.out.println("25383---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase-25383:Web_Testcase to verify <Filters: Dimension Based Automatic Filters _Arrow Navigation by levels>");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	findVisible(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("TestCase-25383:Web_Testcase to verify <Filters: Dimension Based Automatic Filters _Arrow Navigation by levels>===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000); 
	  	
	   //Try to Open any Report:======================================
  		findVisible(By.xpath("//span[text()='Sales by country']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		Thread.sleep(5000);
  		//Take Count After open:===========
  	  	List<WebElement> ReportCount= findAllVisible(By.xpath("//span[text()='Sales by country']"));
  	  	
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
  	  			findVisible(By.xpath("//span[text()='Sales by country']")).click();
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(2000);
	  	
  	  	//Open Component Manager:==========
  	  	findVisible(By.xpath("//span[text()='Components']")).click();
  	  	Utils.waitForElement("");
  	  	Thread.sleep(1000);
	  	
  	  	//Check/Validate Layout Components Text:============
  	  	Assert.assertEquals(true,findVisible(By.xpath("//div[text()='Layout Components']")).isDisplayed());
  	  	Thread.sleep(1000);
  	  	System.out.println("Layout Components Text is displaying.");
  	  	Thread.sleep(1000);
//	  	click(By.xpath("//div[text()='Layout Components']"));
  	  	Assert.assertEquals(true, findVisible(By.xpath("(//body[1]/div[3]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]")));
  	  	Thread.sleep(2000);
  	  	System.out.println("Separator as Layout Components Text is displaying.");
  	    Thread.sleep(2000);
  	  	//Select Automatic Filter and proceed:===================
  	  	try 
  	  	{
 		   if(findVisible(By.xpath("(//div[text()='Automatic Filters']/preceding::div[contains(@class,'treeitemcollapsed')])[6]")).isDisplayed()) 
 		   {
 			 System.out.println("Automatic Filters need to click link");
 			 Thread.sleep(500);
 			 findVisible(By.xpath("//div[text()='Automatic Filters']")).click();
 			 Thread.sleep(500);
 			 Actions act=new Actions(log.driver);
 			 act.doubleClick(findVisible(By.xpath("(//div[text()='Automatic Filters']/preceding::div[contains(@class,'treeitemcollapsed')])[6]"))).perform();
 		   }
  	  	}
  	  	catch(Exception e)
  	  	{
 		   System.out.println("Already Selected Automatic Filters");
  	  	}
  	  	
  	   Thread.sleep(1000);
 	   //Select sub Filters Under Automatic Filter filter:=============
	   Actions act=new Actions(log.driver);
	   act.contextClick(findVisible(By.xpath("//div[text()='Automatic Filters']/following::div[6]"))).perform();
	   Thread.sleep(2000);
	   
	   //After Right click check Validation and all:==================
	   Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Select Elements...']")).isDisplayed());
	   Thread.sleep(500);
	   Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Properties...']")).isDisplayed());
	   Thread.sleep(500);
	   System.out.println("Right click context menus are displaying");
	   Thread.sleep(500);
	   //===Choose Select Element and proceed:====================
	   findVisible(By.xpath("//span[text()='Select Elements...']")).click();
	   Thread.sleep(1000);
	   Assert.assertEquals(true,findVisible(By.xpath("//span[contains(text(),'Select Element')]")).isDisplayed());
	   Thread.sleep(500);
	   System.out.println("Select element window is displaying now.");
	   Thread.sleep(500);
	   //Element Group Availability check:=============
		Assert.assertEquals(true,findVisible(By.xpath("//button[text()='Element Groups...']")).isDisplayed());
		Thread.sleep(500);
		//Check Display check:=====================
		Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Display:']")).isDisplayed());
		Thread.sleep(500);
		Assert.assertEquals(true,findVisible(By.xpath("//button[@data-title='Search up']")).isDisplayed());
		Thread.sleep(500);
		Assert.assertEquals(true,findVisible(By.xpath("//button[@data-title='Search down']")).isDisplayed());
		Thread.sleep(500);
		
		//Check for Button Enable/not:==============
		Assert.assertEquals(true,findVisible(By.xpath("//button[text()='Element Groups...']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,findVisible(By.xpath("//button[text()='Limits...']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,findVisible(By.xpath("//button[text()='Properties...']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,findVisible(By.xpath("//input[@value='OK']")).isEnabled());
		Thread.sleep(500);
		System.out.println("Element property window all Buttons are enabled");
	   
		//Click on Properties and validate proceed::==============
		findVisible(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(500);
  	  	
		Assert.assertEquals(true,findVisible(By.xpath("//span[contains(text(),'Properties of')]")).isDisplayed());
 		Thread.sleep(500);
 		System.out.println("Property window is displaying now.");
 		
 		//Validate 	Default checkbox:======================
 		Assert.assertEquals(true,findVisible(By.xpath("//div[text()='Visible']/following::label[1]")).isEnabled());
 		Thread.sleep(500);
 		Assert.assertEquals(true,findVisible(By.xpath("//div[text()='Iterable']/following::label[1]")).isEnabled());
 		Thread.sleep(500);
 		System.out.println("default check boxes are enabled.");
 		Assert.assertEquals(true,findVisible(By.xpath("//div[text()='Selection type']/following::span[1]/span")).isEnabled());
 		Thread.sleep(500);
 		System.out.println("Drop down is enabled.");
 		Thread.sleep(2000);
 		
 		//Select Checkbox Navigation by Arrow:================
 		findVisible(By.xpath("//div[text()='Enable navigation by arrow']/following::div[1]")).click();
 		Thread.sleep(3000);
 		
 		//Check Navigation mode:===============
 		String NavigationModeValue=findVisible(By.xpath("//div[text()='Navigation mode']/following::span[1]/span")).getAttribute("value");
  		System.out.println("Navigation Mode Value is:->"+NavigationModeValue);
  		Thread.sleep(2000);
 		
  		//Set to "By Level":=======================
  		WebElement e3=findVisible(By.xpath("//div[text()='Navigation mode']/following::span[1]"));
        Actions act2=new Actions(log.driver);
       // act2.click(e3).sendKeys("By level", Keys.ENTER).build().perform();
        act2.click(e3).perform();
        act2.sendKeys(Keys.DOWN).perform();
        act2.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
  		
        //Click Ok Button:===================
        findVisible(By.xpath("(//input[@value='OK'])[1]")).click();
 		Thread.sleep(500);
 		
 		//Select OK ,Validate Should navigate to Select Element window:=========================
 		Assert.assertEquals(true,findVisible(By.xpath("//span[contains(text(),'Select Element')]")).isDisplayed());
 		Thread.sleep(500);
 		System.out.println("Select element window is displaying now.");
 		Thread.sleep(500);
 		
 		//Click again ok Should Display report:==============
 		findVisible(By.xpath("(//input[@value='OK'])[1]")).click();
  		Thread.sleep(1000);
 		
  		//Validate Apply Value:=================
  		Assert.assertEquals(true,findVisible(By.xpath("//button[@class='cw_button filterUpArrow k-button k-button-icontext']")).isDisplayed());
 		Thread.sleep(500);
 		Assert.assertEquals(true,findVisible(By.xpath("//button[@class='cw_button filterDownArrow k-button k-button-icontext']")).isDisplayed());
 		Thread.sleep(500);
  		System.out.println("Both up and down arrow buttons are displaying on report.");
 	
		//Select Drop down and choose value:============================	
  		act.contextClick(findVisible(By.xpath("(//span[text()='Category'])[1]/following::span[3]"))).perform();
  		Thread.sleep(1000);
  		try 
  		{
  			if(findVisible(By.xpath("//span[text()='Enable selection by drop-down menu']/child::span[1]")).isDisplayed())
  			{
  				System.out.println("Value is Checked");
  				Thread.sleep(1000);
  				log.driver.navigate().refresh();
  				Thread.sleep(1000);
  				//findVisible(By.xpath("(//li[@id='refresh_report'])[2]")).click();
  				//Thread.sleep(1000);
  			}
  		}catch(Exception e)
  		{
  			System.out.println("catch block");
  			Thread.sleep(500);
  			findVisible(By.xpath("//span[text()='Enable selection by drop-down menu']")).click();
  	  		Thread.sleep(1000);
  		}
  		
  		findVisible(By.xpath("(//span[text()='Category'])[1]/following::span[3]")).click();
  		Thread.sleep(2000);
  		findVisible(By.xpath("//span[text()='Used Car']")).click();
  		Thread.sleep(2000);
  		
  		String BfDrpDwnValue=findVisible(By.xpath("(//span[text()='Category'])[1]/following::input[@class='k-input dropdowninput'][1]")).getAttribute("value");
  		System.out.println("Before DrpDwn Value is:->"+BfDrpDwnValue);
  		Thread.sleep(2000);
  		
  		//Select Up and down arrow:=================
  		findVisible(By.xpath("//button[@class='cw_button filterUpArrow k-button k-button-icontext']")).click();
  		Thread.sleep(2000);
  		
  		String AfDrpDwnValue=findVisible(By.xpath("(//span[text()='Category'])[1]/following::input[@class='k-input dropdowninput'][1]")).getAttribute("value");
  		System.out.println("After DrpDwn Value is:->"+AfDrpDwnValue);
  		Thread.sleep(2000);
  		
  		if(!(BfDrpDwnValue.equals(AfDrpDwnValue)))
	  	{
	  		System.out.println("Arrow Navigation by levels for Filters is working as expected.");
	  	}
  		Thread.sleep(1000);
  		
  		findVisible(By.xpath("//span[text()='Navigator']")).click();	
  		Thread.sleep(1000);
  		//Save as and Delete the report:===================
		findVisible(By.xpath("(//span[text()='Save']/following::span[1])[2]")).click();
		Thread.sleep(2000);
		//Click Down and do Save As:====================
		findVisible(By.xpath("(//span[text()='Save As'])[2]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Save report as']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Save Report as window is displaying now.");
		
		//Change Name:===========
		findVisible(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		Thread.sleep(2000);
		findVisible(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Report__ArrowNavigation_by levels");
		Thread.sleep(2000);
		
		//click folder:========
		findVisible(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		findVisible(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
		
		//Delete Report:==================
		findVisible(By.xpath("(//span[text()='Report__ArrowNavigation_by levels'])[3]")).click();
		Thread.sleep(3000);
		act.contextClick(findVisible(By.xpath("(//span[text()='Report__ArrowNavigation_by levels'])[1]"))).perform();
		Thread.sleep(2000);
		findVisible(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		findVisible(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		log.driver.close();
  		
  }
}
