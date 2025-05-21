package smokeCase;

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

public class TestCase_37772 extends TestUtils
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
	    System.out.println("37772---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25577: Cockpit Data Mashup Nested Tables");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("======Test Case 25577: Cockpit Data Mashup Nested Tables======");
	  	Utils.waitForElement("");
	  	Thread.sleep(2000);
	  
	  	//Sales overview management ==Report Need to Open
		log.driver.findElement(By.xpath("//span[text()='Manangement overview']/preceding::span[@class='k-icon k-i-expand'][1]")).click();
		Thread.sleep(2000);
	  	
	  	 //Open Sales By Country Report:==============
	  	log.driver.findElement(By.xpath("//span[text()='Sales overview manangement']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		Thread.sleep(5000);
  		//Take Count After open:===========
  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Sales overview manangement']"));
  	  	
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
  	  			log.driver.findElement(By.xpath("//span[text()='Sales overview manangement']")).click();
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(5000);
	  	
	  	//Click on DataViewDesigner:=================
  	  	log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	  	Utils.waitForElement("");
	  	
	  	//Validate Time Dimension in row:============
	  	
	  	Assert.assertEquals(log.driver.findElement(By.xpath("((//div[text()='Rows'])[1]/following::span[text()='Time'])[1]")).isDisplayed(),true);
		Thread.sleep(3000);
		Assert.assertEquals(log.driver.findElement(By.xpath("((//div[text()='Columns'])[1]/following::span[text()='Category'])[1]")).isDisplayed(),true);
		Thread.sleep(3000);
		Assert.assertEquals(log.driver.findElement(By.xpath("((//div[text()='Columns'])[1]/following::span[text()='Measures'])[1]")).isDisplayed(),true);
		Thread.sleep(3000);
		
		//Click Measure and Proceed:==============
		log.driver.findElement(By.xpath("((//div[text()='Columns'])[1]/following::span[text()='Measures'])[1]")).click();
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Columns window is displaying now.");
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed());
		Thread.sleep(1000);
		//Select Mashup and click ok:=====
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
		 
		 List<WebElement> MashupList=log.driver.findElements(By.xpath("//div[text()='MASHUP']"));
		 System.out.println("Mashup list is->"+MashupList.size());
		 int Count=0;
		 if (MashupList.size()>1) 
		 {
			System.out.println("More number of Mashup columns are available as required.");
			Count++;
		 }
		 Assert.assertEquals(Count,1);
		 Thread.sleep(2000);
		
		 //Write Values:================
		 Actions act=new Actions(log.driver);
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/0']"))).perform();
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
				act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/0']"))).build().perform();
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
		 //=C(2,1)/2
		 log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=C(2,1)/2");
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
		 String FstMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/0']")).getText();
		 Thread.sleep(2000);
		 System.out.println("First Mashup Cell value is:->"+FstMashupValue);
		 
		 //2nd Formula for 2nd Mashup Cell:===============
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='5/0']"))).perform();
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
				act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='5/0']"))).build().perform();
				Thread.sleep(2000);
			}
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Single data Cell window is displaying.");
		 log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
				
		 log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=C(2,1)*2");
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
		 String SndMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='5/0']")).getText();
		 Thread.sleep(2000);
		 System.out.println("Second Mashup Cell value is:->"+SndMashupValue);
		
		 if(FstMashupValue!=SndMashupValue)
		 {
			 System.out.println("Mashup Value is changed as per formula for Nested Tables.");
		 }
		 
	  	//Save As the Report:==============
	  	log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(2000);
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
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("c8 Cockpit_DataMashup_Functionality Nested Table_Check");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_Functionality Nested Table_Check'])[3]")).click();
  		Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_Functionality Nested Table_Check'])[1]/preceding::input[1]")).click();
  		Thread.sleep(1000);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_Functionality Nested Table_Check'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
	  	
  }
}
