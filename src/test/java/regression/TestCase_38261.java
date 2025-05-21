package regression;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class TestCase_38261 extends TestUtils
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
	   System.out.println("38261---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 28823: 12740 : TestCase for Cockpit Navigator functionality - Entry Report");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("===Test Case 28823: 12740 : TestCase for Cockpit Navigator functionality - Entry Report===");
	  	Utils.waitForElement("");
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
		log.driver.findElement(By.xpath("//span[text()='Entry Report']")).click();
  		Thread.sleep(1000);
  	 	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new management entry report.']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Entry Report Message is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed());
		Thread.sleep(1000);
		
		//====click next ,define actions window appear:===========
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Define Actions']")).isDisplayed());
		Thread.sleep(1000);
		
		//Click New Button:=============
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(1000);
		
		//Validate Actions in NEW window:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Action']")).isDisplayed());
		Thread.sleep(1000);
		
		String[] ActActionNameList={"Jump Action","Import Job Action","URL Link Action","Filter Action","Export Action","Export Call Action","Animated Action"};
		List<WebElement> ActionNamelist=log.driver.findElements(By.xpath("//span[text()='New Action']/following::span[@class='reportNametxt']"));
		
		int count_ActionName=0;
		for(int i=0;i<ActionNamelist.size();i++)
		{
			System.out.println(ActActionNameList[i]+" And "+ActionNamelist.get(i).getText());
			
			if(ActActionNameList[i].equals(ActionNamelist.get(i).getText()))
			{
				count_ActionName++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Action Name list is:->"+count_ActionName);
		Assert.assertEquals(7,count_ActionName);
		System.out.println("All the actions are available in action window.");
		Thread.sleep(2000);
		
		//Select URL Action:===========
		log.driver.findElement(By.xpath("//span[text()='URL Link Action']")).click();
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Action Target and Parameters']")).isDisplayed());
		Thread.sleep(1000);
  		
		//ProVide URL lINK:=========
		log.driver.findElement(By.xpath("//span[text()='URL link:']/following::input[1]")).sendKeys("https://www.cubeware.com/en/");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//td[contains(text(),'Context Variable')]")).click();
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		//Action Property Window Appear:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Action Properties']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Action Property window is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Caption for action buttons']/following::input[1]")).sendKeys("CUBEWARE");
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//div[text()='Caption for menus']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Name and Description window is displaying.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys(Keys.CONTROL,"a");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("URL Action");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='Finish'])[1]")).click();
		Thread.sleep(1000);
		
		//Click Next:================
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		//Whats Next Window:===========
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'next?')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("whats next window is displaying.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		//Finish Window:===
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Name and Description window is displaying.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys(Keys.CONTROL,"a");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Navigator functionality - Entry Report");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='Finish'])[1]")).click();
		Thread.sleep(1000);
		
		//Save:======
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
  		
  		//Then Click link:==================
  		log.driver.findElement(By.xpath("//font[text()='CUBEWARE']")).click();;
  		Thread.sleep(1000);
  		
  		//Validate:==============
  		Set<String> WindowHandel=log.driver.getWindowHandles();
  		Iterator<String> ID=WindowHandel.iterator();
  		String Parent=ID.next();
  		String Child=ID.next();
  		log.driver.switchTo().window(Child);
  		String Titleis=log.driver.getTitle();
  		System.out.println("Cockpit Title is:->"+Titleis);
  		Thread.sleep(2000);
  		Assert.assertEquals(Titleis,"Business Intelligence Software | Cubeware");
  		Thread.sleep(2000);
  		log.driver.switchTo().window(Parent);
  		Thread.sleep(2000);
  		
  		//Delete Created Report:==============
  		log.driver.findElement(By.xpath("(//span[text()='Navigator functionality - Entry Report'])[3]")).click();
  		Thread.sleep(3000);
  		Actions act=new Actions(log.driver);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Navigator functionality - Entry Report'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
  		
  }
}
