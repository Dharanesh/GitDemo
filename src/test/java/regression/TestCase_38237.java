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

public class TestCase_38237 extends TestUtils
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
	  	System.out.println("38237---Test Task started........");
		//login to the application:==========
	  	test =extent.createTest("Test Task 38237:Test Case 28819: 12736 : TestCase for Cockpit Navigator functionality - ABC Classification");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Case 28819: 12736 : TestCase for Cockpit Navigator functionality - ABC Classification==");
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
		log.driver.findElement(By.xpath("//span[text()='ABC Classification']")).click();
  		Thread.sleep(1000);
  	 	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new report for ABC classification.']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("ABC Classification Report Message is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Cube']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Select Cube Window is displaying now.");
		Thread.sleep(1000);
		
		//Select Pantara:==========
		log.driver.findElement(By.xpath("//div[text()='Pantara AS2008']/preceding::div[1]")).click();
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("//div[text()='Sales']")).click();
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
  		Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dimension Selection']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Dimension Selection window is displaying now.");
		
		//Validate Default Value in Dimension selection window:=======
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Use all dimensions of cube']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Use only selected dimensions']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
  		Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Report Layout']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Report Layout window is displaying now.");
		
		//Validate Default Value:====================================
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Table only']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Chart only']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Table and chart tiled vertically']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Table and chart tiled horizontally']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
  		Thread.sleep(1000);
		
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Filter Components']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Filter Components window is displaying now.");
		
		//Validate Default Property in Filter Components window:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Display filter bar']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Display selection bar']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
  		Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'next?')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Whats Next? window is displaying now.");
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
  		Thread.sleep(1000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Name And Description window is displaying now.");
		
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).clear();
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Navigator functionality - ABC Classification");;
  		Thread.sleep(1000);
		
  		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
  		Thread.sleep(1000);
  		//Click on Finish Button:=====
  		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
  		Thread.sleep(1000);
  		
  		//Validate:===========
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Classification A in %']")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Classification B in %']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("ABC classification report is displaying now.");
		Thread.sleep(1000);
  
  		//Save the report:===========
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
  		log.driver.findElement(By.xpath("(//span[text()='Navigator functionality - ABC Classification'])[3]")).click();
  		Thread.sleep(3000);
  		Actions act=new Actions(log.driver);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Navigator functionality - ABC Classification'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
  		
  }
}
