package regression;

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

public class TestCase_38239 extends TestUtils
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
		System.out.println("38239---Test Task started........");
		//login to the application:==========
	  	test =extent.createTest("Test Case 28821: 12738 : TestCase for Cockpit Navigator functionality - Relational Report");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Case 28821: 12738 : TestCase for Cockpit Navigator functionality - Relational Report==");
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
		log.driver.findElement(By.xpath("//span[text()='Relational Report']")).click();
  		Thread.sleep(1000);
  	 	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new report from a relational database.']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Relational database Message is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		//SQL window:==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='SQL Statement']")).isDisplayed());
		Thread.sleep(1000);
		//Input the SQL Query:========
		//DrpDown:====
		//Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("//span[text()='Connection']/following::span[1]"));
        Actions act2=new Actions(log.driver);
        act2.click(e2).sendKeys("", Keys.ENTER).build().perform();
        Thread.sleep(2000);
        
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_TAB); 
        robot.keyPress(KeyEvent.VK_BACK_SPACE); 
        
        robot.keyRelease(KeyEvent.VK_TAB); 
        Thread.sleep(3000);
		log.driver.findElement(By.xpath("((//div[text()='1'])[1]/following::span[@role='presentation'])[1]")).sendKeys("abc");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	  	
	  	
	  	
	  	
	  
  }
}
