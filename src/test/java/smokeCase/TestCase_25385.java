package smokeCase;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
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

public class TestCase_25385 extends TestUtils
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
	  	System.out.println("25385---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase 25385: Web_Testcase to verify <Filters: Dimension Based Automatic Filters_Background Dimensions Check>");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("TestCase 25385: Web_Testcase to verify <Filters: Dimension Based Automatic Filters_Background Dimensions Check>===================");
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
  	  	Thread.sleep(2000);
	  	//Open Data view Designer:=================
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed());
	    Thread.sleep(1000);
	    System.out.println("Data view Designer window is available.");
	    Assert.assertEquals(true,log.driver.findElement(By.xpath(" (//div[text()='Background'])[1]/following::span[text()='Salesorg']")).isDisplayed());
	    Thread.sleep(1000);
	    System.out.println("Salesorg as default background dimension.");
  	  	
  	  	//Open Component manager window:=====================
	    log.driver.findElement(By.xpath("//span[text()='Components']")).click();
  	  	Utils.waitForElement("");
  	  	Thread.sleep(1000);
	  	
  	  	//Check/Validate Layout Components Text:============
  	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Layout Components']")).isDisplayed());
  	  	Thread.sleep(1000);
  	  	System.out.println("Layout Components Text is displaying.");
  	  	Thread.sleep(1000);
  	    //Assert.assertEquals(true,log.driver.findElement(By.xpath("(//div[text()='Layout Components']/following::div[text()='Separator'])[1]")).isDisplayed());
  	  	//Thread.sleep(2000);
  	  	//System.out.println("Separator as Layout Components Text is displaying.");
  	  	//Select Automatic Filter and proceed:===================
  	  	try 
  	  	{
 		   if(log.driver.findElement(By.xpath("//div[text()='Automatic Filters']/preceding::div[1]")).isDisplayed()) 
 		   {
 			 System.out.println("Automatic Filters need to click link");
 			 Thread.sleep(500);
 			 log.driver.findElement(By.xpath("//div[text()='Automatic Filters']")).click();
 			 Thread.sleep(500);
 			 Actions act=new Actions(log.driver);
 			 act.doubleClick(log.driver.findElement(By.xpath("//div[text()='Automatic Filters']/preceding::div[1]"))).perform();
 		   }
  	  	}
  	  	catch(Exception e)
  	  	{
 		   System.out.println("Already Selected Automatic Filters");
  	  	}
  	   Thread.sleep(2000);
  	   String bfValue=log.driver.findElement(By.xpath("//div[text()='Automatic Filters']/following::div[1]/div[2]")).getText();
  	   System.out.println("Before Value is:->"+bfValue);
  	   Thread.sleep(3000);
  	  // log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	  // Thread.sleep(1000);
  	   
	   //Try to Remove Background Dimension and validate in Automatic filter list:====================
  	   log.driver.findElement(By.xpath("(//div[text()='Background'])[1]/following::a[1]")).click();
	   Thread.sleep(1000);
	   
	   try {
		   String AFValue=log.driver.findElement(By.xpath("//div[text()='Automatic Filters']/following::div[1]/div[2]")).getText();
		   System.out.println("After Value is:->"+AFValue);
		   Thread.sleep(1000);
	   		}	
	   catch(Exception e)
	   {
		   System.out.println("No automatic filters because of uncheck background filter.");
	   }
	   Thread.sleep(3000);
	   
	   //Re check and validate:========================
	   log.driver.findElement(By.xpath("(//div[text()='Background'])[1]/following::a[2]")).click();
	   Thread.sleep(2000);
	   String ReAFValue=log.driver.findElement(By.xpath("//div[text()='Automatic Filters']/following::div[1]/div[2]")).getText();
	   System.out.println("Recheck After Value is:->"+ReAFValue);
	   Thread.sleep(2000);
	  	
	   //Validate:====================
	   Assert.assertEquals(ReAFValue,bfValue);
	   System.out.println("Automatic filter Value Validate as expected.");
	   Thread.sleep(1000);
	   
	   log.driver.close();
	   
  }
  
}

