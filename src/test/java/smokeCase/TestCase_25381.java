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

public class TestCase_25381 extends TestUtils
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
	    System.out.println("25381---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase 25381: Web_Testcase to verify <Filters: Dimension Based Automatic Filters_Multiselection>");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("TestCase-25381:Web_Testcase to verify <Filters: Dimension Based Automatic Filters_Multiselection>===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	   //Try to Open any Report:======================================
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
  	  	Thread.sleep(2000);
	  	
  	  	//Open Component Manager:==========
  	   log.driver.findElement(By.xpath("//span[text()='Components']")).click();
  	   Utils.waitForElement("");
  	   Thread.sleep(1000);
  	   
  	   //Check/Validate Layout Components Text:============
  	   Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Layout Components']")).isDisplayed());
  	   Thread.sleep(1000);
  	   System.out.println("Layout Components Text is displaying.");
  	   Thread.sleep(1000);
  	  
	   //Select Automatic Filter and proceed:===================
	   try 
	   {
		   if(log.driver.findElement(By.xpath("(//div[text()='Automatic Filters']/preceding::div[contains(@class,'treeitemcollapsed')])[6]")).isDisplayed()) 
		   {
			 System.out.println("Automatic Filters need to click link");
			 Thread.sleep(500);
			 log.driver.findElement(By.xpath("//div[text()='Automatic Filters']")).click();
			 Thread.sleep(500);
			 Actions act=new Actions(log.driver);
			 act.doubleClick(log.driver.findElement(By.xpath("(//div[text()='Automatic Filters']/preceding::div[contains(@class,'treeitemcollapsed')])[6]"))).perform();
			 Thread.sleep(500);
		   }
	   }
	   catch(Exception e)
	   {
		   System.out.println("Already Selected Automatic Filters");
	   }
	   Thread.sleep(500);
  	   //Select sub Filters Under Automatic Filter filter:=============
	   Actions act=new Actions(log.driver);
	   act.contextClick(log.driver.findElement(By.xpath("//div[text()='Automatic Filters']/following::div[6]"))).perform();
	   Thread.sleep(2000);
	   //After Right click check Validation and all:==================
	   Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Elements...']")).isDisplayed());
	   Thread.sleep(500);
	   Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties...']")).isDisplayed());
	   Thread.sleep(500);
	   System.out.println("Right click context menus are displaying");
	   Thread.sleep(1000);
	   //===Choose Select Element and proceed:====================
	   log.driver.findElement(By.xpath("//span[text()='Select Elements...']")).click();
	   Thread.sleep(2000);
	   Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Select Element')]")).isDisplayed());
	   Thread.sleep(500);
	   System.out.println("Select element window is displaying now.");
	   Thread.sleep(500);
	   //Element Group Availability check:=============
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed());
 		Thread.sleep(500);
 		//Check Display check:=====================
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display:']")).isDisplayed());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[@data-title='Search up']")).isDisplayed());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[@data-title='Search down']")).isDisplayed());
 		Thread.sleep(500);
 		
 		//Check for Button Enable/not:==============
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Limits...']")).isEnabled());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Properties...']")).isEnabled());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='OK']")).isEnabled());
 		Thread.sleep(500);
 		System.out.println("Element property window all Buttons are enabled");
	   
 		//Click on Properties and validate proceed::==============
 		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]")).isDisplayed());
 		Thread.sleep(500);
 		System.out.println("Property window is displaying now.");
 		
 		//Validate 	Default checkbox:======================
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Visible']/following::label[1]")).isEnabled());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Iterable']/following::label[1]")).isEnabled());
 		Thread.sleep(500);
 		System.out.println("default check boxes are enabled.");
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Selection type']/following::span[1]/span")).isEnabled());
 		Thread.sleep(500);
 		System.out.println("Drop down is enabled.");
 		
 		//Select Multiple Selection from drop down list:======================
 		if(log.driver.findElement(By.xpath("//div[text()='Selection type']/following::span[1]/span")).getText().equals("Multiple selection"))
 		{
 			System.out.println("Multiple selection is selected.");
 			Thread.sleep(500);
 		}
 		else
 		{
 			System.out.println("Need to select multiple selection.");
 			Thread.sleep(500);
 			WebElement e3=log.driver.findElement(By.xpath("//div[text()='Selection type']/following::span[1]/span"));
 	        Actions act2=new Actions(log.driver);
 	       //act2.click(e3).sendKeys("Multiple selection", Keys.ENTER).build().perform();
 	        Thread.sleep(1000);
 	        act2.click(e3).perform();
 	        act2.sendKeys(Keys.DOWN).perform();
 	        act2.sendKeys(Keys.ENTER).perform();
 	        Thread.sleep(1000);
 		}
 		
        //Click Ok Button:===================
        log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
 		Thread.sleep(1000);
        
 		//Select OK ,Validate Should navigate to Select Element window:=========================
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Select Element')]")).isDisplayed());
 		Thread.sleep(500);
 		System.out.println("Select element window is displaying now.");
 		Thread.sleep(500);
 		
 		//Click again ok Should Display report:==============
 		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
  		Thread.sleep(2000);
 		
	    //Validate Apply Value:=================
  		Thread.sleep(1000);
  		
  		/* try 
 		{
 			if(log.driver.findElement(By.xpath("//span[text()='Enable selection by drop-down menu']")).isDisplayed())
 			{
 				System.out.println("Enable selection by drop-down menu text is displaying.");
 				Thread.sleep(1000);
 			}
 		}catch(Exception e)
 		{
 			Actions act_a=new Actions(log.driver);
 			act_a.contextClick(log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::span[3]"))).build().perform();
 			Thread.sleep(2000);
 		}
 		Thread.sleep(2000);
  		
  		try 
  		{
  			if(log.driver.findElement(By.xpath("//span[text()='Enable selection by drop-down menu']/child::span[1]")).isDisplayed())
  			{
  				System.out.println("Value is Checked");
  				Thread.sleep(1000);
  				log.driver.navigate().refresh();
  				Thread.sleep(1000);
  				//log.driver.findElement(By.xpath("(//li[@id='refresh_report'])[2]")).click();
  				//Thread.sleep(1000);
  			}
  		}catch(Exception e)
  		{
  			System.out.println("catch block");
  			Thread.sleep(500);
  			log.driver.findElement(By.xpath("//span[text()='Enable selection by drop-down menu']")).click();
  	  		Thread.sleep(1000);
  		}*/
  		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='ellipsisText'])[3]/span[1]");
		log.driver.findElement(By.xpath("(//div[@class='ellipsisText'])[3]/span[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='ellipsisText'])[3]/span[1]");
		Utils.rightClick("(//div[@class='ellipsisText'])[1]/span[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//div[@class='k-animation-container']/ul/li/span[1]")).isDisplayed())
			{
				System.out.println("Navigate Available");
			}
		}
		catch(Exception e)
		{
			 
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@class='ellipsisText'])[3]/span[1]"))).perform();
		     Thread.sleep(2000);
		}
  		
  		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='ellipsisText'])[3]/span[1]");
        log.driver.findElement(By.xpath("(//div[@class='ellipsisText'])[3]/span[1]")).click();
        Thread.sleep(1000);
       
        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='ellipsisText'])[3]/span[1]");
        Utils.rightClick("(//div[@class='ellipsisText'])[1]/span[1]");
        Thread.sleep(2000);
       
        try
        {
            if(log.driver.findElement(By.xpath("//div[@class='k-animation-container']/ul/li/span[1]")).isDisplayed())
            {
                System.out.println("Navigate Available");
            }
        }
        catch(Exception e)
        {
            
             act.contextClick(log.driver.findElement(By.xpath("(//div[@class='ellipsisText'])[3]/span[1]"))).perform();
             Thread.sleep(2000);
        }*/
  		
  		//Click on Drop down and proceed:============
  		String BfDrpDwnValue=log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::input[1]")).getAttribute("value");
  		System.out.println("Before DrpDwn Value is:->"+BfDrpDwnValue);
  		Thread.sleep(2000);
  		
  		log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::span[3]")).click();
  		Thread.sleep(2000);

  		//Validate Apply and Resolve button:===========
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Resolve']")).isDisplayed());
 		Thread.sleep(500);
  		System.out.println("Apply And Resolve button is displaying Due to Multiselect.");
  		Thread.sleep(1000);
  		
    	//Check Filter:=====================
  		log.driver.findElement(By.xpath("//span[text()='All Categories']")).click();
	  	Thread.sleep(1000);
	  		  
		//log.driver.findElement(By.xpath("//button[text()='Resolve']")).click();
  		//Thread.sleep(500);
  		log.driver.findElement(By.xpath("//button[text()='Apply']")).click();	
  		Thread.sleep(1000);
  		
  		String AfDrpDwnValue=log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::input[@class='k-input dropdowninput cwplaceholder']")).getAttribute("value");
  		System.out.println("After DrpDwn Value is:->"+AfDrpDwnValue);
	  	
	  	if(!(BfDrpDwnValue.equals(AfDrpDwnValue)))
	  	{
	  		System.out.println("Multi select For Filters is working as expected.");
	  	}
	  	
  		//Case-2:==========================
  		//Assign filter values:==============
	 	log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::span[3]")).click();
  		Thread.sleep(1000);
	  	//log.driver.findElement(By.xpath("//span[text()='All Categories']")).click();
	  	Thread.sleep(1000);
	  	log.driver.findElement(By.xpath("//span[text()='Used Car']")).click();
	  	Thread.sleep(1000);
  		
	  	//log.driver.findElement(By.xpath("//button[text()='Resolve']")).click();
  		//Thread.sleep(500);
  		log.driver.findElement(By.xpath("//button[text()='Apply']")).click();	
  		Thread.sleep(1000);
	  	
  		String AfApplyFilterValue=log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::input[@class='k-input dropdowninput cwplaceholder']")).getAttribute("value");
  		System.out.println("After Apply Filter Value is:->"+AfApplyFilterValue);
  		
  		if(!(AfApplyFilterValue.equals("All Categories, Used Car")))
	  	{
	  		System.out.println("Multi select For Filters is working as expected after apply Filter.");
	  	}
  		Thread.sleep(500);
  		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();	
  		Thread.sleep(1000);
  		//Save as and Delete the report:===================
  	 
		log.driver.findElement(By.xpath("(//span[text()='Save']/following::span[1])[2]")).click();
		Thread.sleep(2000);
		//Click Down and do Save As:====================
		log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Save Report as window is displaying now.");
		
		//Change Name:===========
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Report_Multiselection");
		Thread.sleep(2000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
		
		//Delete Report:==================
		log.driver.findElement(By.xpath("(//span[text()='Report_Multiselection'])[3]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//span[text()='Report_Multiselection'])[1]/preceding::input[1]")).click();
		Thread.sleep(1000);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Report_Multiselection'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		log.driver.close();
  		
  		
  		
  		
  }
  
}
