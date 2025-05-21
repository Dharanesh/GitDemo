package regression;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
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

public class TestCase_38264 extends TestUtils
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
	    System.out.println("38264---Test Task started........");
		//login to the application:==========
	  	test =extent.createTest("Test Case 28826: 12743 : TestCase for Cockpit Navigator functionality - Open/Save/Save As/Close Report");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
		Thread.sleep(3000);
	  
	  	System.out.println("==Test Case 28826: 12743 : TestCase for Cockpit Navigator functionality - Open/Save/Save As/Close Report==");
	  	Thread.sleep(3000);
	  	
	  	//Enable the check box:====
	  	log.driver.findElement(By.xpath("//span[text()='Sales by country']/ancestor::div[1]/span[1]")).click();
  		Thread.sleep(3000);
  		
  		//Right click on Same Report:===========
  		Actions act=new Actions(log.driver);
  		act.contextClick(log.driver.findElement(By.xpath("//span[text()='Sales by country']"))).perform();
  		Thread.sleep(2000);
  		
		//click open:===
		log.driver.findElement(By.xpath("(//span[text()='Report'])[1]/following::span[text()='Open']")).click();
  		Thread.sleep(3000);
  		
  		//Validate After Open:====
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
  	  			e.printStackTrace();
  	  		}
  	  	Thread.sleep(3000);
		
  	  	//Save the Opened Report:=============
  	  	log.driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(2000);
		
		System.out.println("Report is saved.");
		Thread.sleep(1000);
		
		//Uncheck salesByCountry===================
  		log.driver.findElement(By.xpath("//span[text()='Sales by country']/ancestor::div[1]/span[1]")).click();
  		Thread.sleep(3000);
		
		//SaveAs the Opened Report:=============
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Save']/following::span[1]")).click();
  		Thread.sleep(2000);
  		//Click Down and do Save As:====================
  		log.driver.findElement(By.xpath("//span[text()='Save As']")).click();
  		Thread.sleep(2000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
  		Thread.sleep(1000);
  		System.out.println("Save Report as window is displaying now.");
  		
  		//Change Name:===========
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Sales by Country_1");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
		
  		//Validate Under Same Folder:=================
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Sales by Country_1'])[1]")).isDisplayed());
  		System.out.println("Save as Report is displaying.");
  		Thread.sleep(2000);
  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//span[text()='Sales by Country_1'])[3]")).click();
  		Thread.sleep(3000);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Sales by Country_1'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
			  
  }
  
}
