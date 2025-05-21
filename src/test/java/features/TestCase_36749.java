package features;

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

public class TestCase_36749 extends TestUtils
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
	  System.out.println("36749--Testcase started........");
	  	//login to the application:================
	  	test =extent.createTest("35668_Filter_LL_Verify Search field present having place holder: \"Type here to search....\"(ENG)");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");
	  	
	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  	
	  	System.out.println("35668_Filter_LL_Verify Search field present having place holder: \"Type here to search....\"(ENG)===================");
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
	   //Check for Check boxes of element click:=================
  	  	Actions act_Check=new Actions(log.driver);
  	  	act_Check.contextClick(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::input[1]"))).perform();;
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Enable selection by drop-down menu']/span[@class='k-icon k-i-checkbox-checked']")).isDisplayed())
			{
				System.out.println("Enable selction drop down check box is checked.");
				Thread.sleep(3000);
				log.driver.navigate().refresh();
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Enable selction drop down check box is not checked,so need to check.");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//span[text()=' Enable selection by drop-down menu']")).click();
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		
  		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::span[4]")).click();
		Utils.waitForElement("");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).isDisplayed());
  	  	Thread.sleep(1000);
		System.out.println("Type here to search text is displaying now.");
		
		log.driver.close();
  }
}
