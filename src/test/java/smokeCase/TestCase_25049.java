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

public class TestCase_25049 extends TestUtils
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
	    System.out.println("25049---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25049: Cockpit Data Mashup RDB");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 25049: Cockpit Data Mashup RDB===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  	//Open Exercise folder:=============
	  	Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Exercises - sample solutions']")).isDisplayed(),true);
	  	
	  	String ClassValue=log.driver.findElement(By.xpath("//span[text()='Exercises - sample solutions']/preceding::span[4]")).getAttribute("class");
	  	Thread.sleep(2000);
	  	if(ClassValue.contains("expand"))
	  	{
	  		System.out.println("Need to expand the exercises button.");
	  		Thread.sleep(2000);
	  		log.driver.findElement(By.xpath("//span[text()='Exercises - sample solutions']/preceding::span[4]")).click();
		  	Utils.waitForElement("");
	  	}
	  	else
	  	{
	  		System.out.println("Already expanded exercises button.");
	  		Thread.sleep(2000);
	  	}
	  	//Select 8b Report:===================
	  	log.driver.findElement(By.xpath("//span[text()='Exercise No. 8b']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(5000);
  		//Take Count After open:===========
  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Exercise No. 8b']"));
  	  	Thread.sleep(2000);
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
  	  			log.driver.findElement(By.xpath("//span[text()='Exercise No. 8b']")).click();
  	  			Thread.sleep(5000);
  	  		}
  	  	Thread.sleep(5000);
	  	
  	  	//Select DataView Designer:=============
  	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	    Thread.sleep(3000);
	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::span[text()='Pantara ERP'][1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Data View Designer window is displaying with Panthara ERP.");
		Thread.sleep(3000);
	  	
		 //Select Training Sales from Drop down:==============
		 WebElement e1=log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::span[@class='k-dropdown-wrap k-state-default'][7]"));
         Actions a1=new Actions(log.driver);
         a1.click(e1).perform();
         Thread.sleep(1000);
         a1.sendKeys(Keys.DOWN).perform();
         Thread.sleep(500);
         a1.sendKeys(Keys.ENTER).perform();
         Thread.sleep(3000);
        // a1.sendKeys("A - Training Sales - [A - Training Sales]", Keys.ENTER).build().perform();
         //Thread.sleep(2000);
         
         Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::div[text()='Background'][1]")).isDisplayed());
 		 Thread.sleep(2000);
	  	 System.out.println("Training sales changed.");
	  	
	  	 //Category should be display in Row:==========
  	     Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Rows']/following::span[text()='Category']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Category is displaying in Row area.");
	  	 
		 //Time should be display in Row:==========
  	     Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[text()='Time']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Time is displaying in Column area.");
	  	 
	  	 //click Time and Proceed:==========
		 log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[text()='Time']")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Selection for column window opened now.");
	  	 
	  	 //Select Mashup:===========
		 WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
         Actions act=new Actions(log.driver);
         act.click(e2).perform();
         /*act.sendKeys("Calculated elements", Keys.ENTER).build().perform();
         Thread.sleep(2000);*/
         a1.sendKeys(Keys.DOWN).perform();
         Thread.sleep(500);
         a1.sendKeys(Keys.DOWN).perform();
         Thread.sleep(500);
         a1.sendKeys(Keys.DOWN).perform();
         Thread.sleep(500);
         a1.sendKeys(Keys.ENTER).perform();
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
		Thread.sleep(2000);
	  	 
		//Verify After Add Ascending Column:==================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'actual language terms')]/following::div[text()='MASHUP']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("MASHUP is added in actual language terms Table.");
		Thread.sleep(4000);
	  	
		//Mashup cell should display write on right click opt:=====
		/*Actions act2=new Actions(log.driver);
		act2.contextClick(log.driver.findElement(By.xpath("(//div[@id='4/0'])[2]"))).perform();
		Thread.sleep(5000);*/
		
		log.driver.findElement(By.xpath("//div[@id='4/0']")).click();
		Thread.sleep(2000);
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='4/0']"))).perform();
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
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='4/0']"))).build().perform();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
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
		//getcellvalue(1,1,"Pantara  ERP")
		String MashupValue="="+"getcellvalue"+"("+"1"+","+"1"+","+"\""+"Pantara ERP"+"\""+")";
		
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys(MashupValue);
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		String ExptVal=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='4/0']")).getText();
		Thread.sleep(2000);
		
		String ActualVal=log.driver.findElement(By.xpath("//div[text()='Englisch']/following::div[@id='1/1']")).getText();
		Thread.sleep(2000);
  	 
		Assert.assertEquals(ExptVal, ActualVal);
  	    System.out.println("Mashup Value is Comming properly as expected For expected Table.");
  	    Thread.sleep(2000);
		
	  	//Save Report:============
  	    //click on Save:=================
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
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Testcase_25049");
		Thread.sleep(2000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
		
		//Delete Report:==================
		log.driver.findElement(By.xpath("(//span[text()='Testcase_25049'])[3]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//span[text()='Testcase_25049'])[1]/preceding::input[1]")).click();
		Thread.sleep(1000);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Testcase_25049'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		log.driver.close();
  	    
  	    
  	    
  	    
  	    
  	    
  }
  
}
