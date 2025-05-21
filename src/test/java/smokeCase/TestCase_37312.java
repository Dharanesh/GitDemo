package smokeCase;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;

public class TestCase_37312  extends TestUtils
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
	   System.out.println("37312---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase-25049:  Cockpit Data Mashup RDB");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("======TestCase-25049:-Cockpit Data Mashup RDB======");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	    //Expand Department and open Any Report:=============
	  	log.driver.findElement(By.xpath("//span[text()='Exercises - sample solutions']/preceding::span[@class='k-icon k-i-expand'][1]")).click();
	  	Thread.sleep(3000);
	  	
	  	log.driver.findElement(By.xpath("//span[text()='Exercise No. 8b']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		
  	   //Take Count After open:=========================
  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Exercise No. 8b']"));
  	  	
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
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(2000);
  		//select A Training sales:==================
  		
  	  log.driver.close();
  		
  		
  		
	  	
  }
  
}
