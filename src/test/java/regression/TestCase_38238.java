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

public class TestCase_38238 extends TestUtils
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
	  	System.out.println("38238---Test Task started........");
		//login to the application:==========
	  	test =extent.createTest("Test Case 28820: 12737 : TestCase for Cockpit Navigator functionality - Empty Report");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Case 28820: 12737 : TestCase for Cockpit Navigator functionality - Empty Report==");
	  	Thread.sleep(3000);
	  	
	   //Validate New Report window Elements:=============
	  	log.driver.findElement(By.xpath("//span[text()='New']/preceding::span[1]")).click();
	  	Utils.waitForElement("");
	  	
	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Report']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Columns window is displaying now.");
		Thread.sleep(1000);
		
		String[] ActReportNameList={"Standard Report","ABC Classification","Empty Report","Relational Report","MDX Report","Entry Report","Report from a Template","Local Export"};
		List<WebElement> ReportNamelist=log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		
		int count=0;
		for(int i=0;i<ReportNamelist.size();i++)
		{
			System.out.println(ActReportNameList[i]+" And "+ReportNamelist.get(i).getText());
			
			if(ActReportNameList[i].equals(ReportNamelist.get(i).getText()))
			{
				count++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Report Name list is:->"+count);
		Assert.assertEquals(8,count);
	  	
		//select ABC Classification and proceed:==========
		log.driver.findElement(By.xpath("//span[text()='Empty Report']")).click();
  		Thread.sleep(1000);
  	 	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new empty report.']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Empty Report Message is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		//Whats next window:=======
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'next?')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Whats Next? window is displaying now.");
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
  		Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Name And Description window is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).clear();
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Navigator functionality - Empty Report");;
  		Thread.sleep(1000);
		
  		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
  		Thread.sleep(1000);
  		//Click on Finish Button:=====
  		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
  		Thread.sleep(1000);
  		System.out.println("Empty Report is created.");
  		Thread.sleep(1000);
  		
  		//Save:================
  		log.driver.findElement(By.xpath("//span[text()='Save']")).click();
  		Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Save report window is displaying now.");
		Thread.sleep(1000);
		
		//Click All Report:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();;
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();;
  		Thread.sleep(1000);
  		
  		//Delete Created one:=============
  		log.driver.findElement(By.xpath("(//span[text()='Navigator functionality - Empty Report'])[3]")).click();
  		Thread.sleep(3000);
  		Actions act=new Actions(log.driver);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Navigator functionality - Empty Report'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
  		
  }
}
