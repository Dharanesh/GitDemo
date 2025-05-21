package smokeCase;

import action.Login;
import action.TestUtils;
import event.Utils;
import event.Waits;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase_25387 extends TestUtils
{
	Login log = null;
	Waits waits =null;
	Utils Utils = null;
	event.Excelnput Excelnput=null;
	
  @Test
  @Parameters("browser")
  public void TestCase_25387_for_verifying_Automatic_Filter_Properties_General_Settings_Caption_Check (String browser) throws Exception
  {
	    //****Precondition:=======Teamserver need to have multiple language:============********8//
	  
	    System.out.println("25387---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase 25387: Web_Testcase to verify <Filters: Automatic Filter Properties_ General Settings (Caption check)>");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 25387: Web_Testcase to verify <Filters: Automatic Filter Properties_ General Settings (Caption check)>===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  //Try to Open any Report:======================================
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
	  	
  	  	//Open Component Manager:==========
  	  	log.driver.findElement(By.xpath("//span[text()='Components']")).click();
  	  	Utils.waitForElement("");
  	  	Thread.sleep(1000);
	  	
  	  	//Check/Validate Layout Components Text:============
  	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[contains(text(),'Layout Components')]")).isDisplayed());
  	  	Thread.sleep(1000);
  	  	System.out.println("Layout Components Text is displaying.");
  	  	Thread.sleep(1000);
  	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[contains(text(),'Layout Components')]/following::div[1]")).isDisplayed());
  	  	Thread.sleep(2000);
  	  	System.out.println("Separator as Layout Components Text is displaying.");
	  	
  	  	//Select Automatic Filter and proceed:===================
  	  	try 
  	  	{
 		   if(log.driver.findElement(By.xpath("(//div[text()='Automatic Filters']/preceding::div[contains(@class,'treeitemcollapsed')])[6]")).isDisplayed()) 
 		   {
 			 System.out.println("Automatic Filters need to click link");
 			 Thread.sleep(500);
 			 log.driver.findElement(By.xpath("//div[text()='Automatic Filters']")).click();
 			 Thread.sleep(500);
 			 Actions act=new Actions(log.driver);
 			 act.doubleClick(log.driver.findElement(By.xpath("(//div[text()='Automatic Filters']/preceding::div[contains(@class,'treeitemcollapsed')])[6]"))).perform();
 		   }
  	  	}
  	  	catch(Exception e)
  	  	{
 		   System.out.println("Already Selected Automatic Filters");
  	  	}
	  	
  	   Thread.sleep(500);
	   //Select sub Filters Under Automatic Filter filter:=============
	   Actions act=new Actions(log.driver);
	   act.contextClick(log.driver.findElement(By.xpath("//div[text()='Automatic Filters']/following::div[6]"))).perform();
	   Thread.sleep(1000);
	   //After Right click check Validation and all:==================
	   Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Elements...']")).isDisplayed());
	   Thread.sleep(500);
	   Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties...']")).isDisplayed());
	   Thread.sleep(500);
	   System.out.println("Right click context menus are displaying");
	   Thread.sleep(500);
	   //===Choose Select Element and proceed:====================
	   log.driver.findElement(By.xpath("//span[text()='Select Elements...']")).click();
	   Assert.assertEquals(true,findVisible(By.xpath("//span[contains(text(),'Select Element')]")).isDisplayed());
	   System.out.println("Select element window is displaying now.");
	   Thread.sleep(500);
	   //Element Group Availability check:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed());
		Thread.sleep(500);
		//Check Display check:=====================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display:']")).isDisplayed());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[@data-title='Search up']")).isDisplayed());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[@data-title='Search down']")).isDisplayed());
		Thread.sleep(500);
		
		//Check for Button Enable/not:==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Limits...']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Properties...']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='OK']")).isEnabled());
		Thread.sleep(500);
		System.out.println("Element property window all Buttons are enabled");
	   
		//Click on Properties and validate proceed::==============
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(500);
	  	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]")).isDisplayed());
 		Thread.sleep(500);
 		System.out.println("Property window is displaying now.");
 		
 		//Validate 	Default checkbox:======================
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Visible']/following::label[1]")).isEnabled());
 		Thread.sleep(500);
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Iterable']/following::label[1]")).isEnabled());
 		Thread.sleep(500);
 		System.out.println("default check boxes are enabled.");
 		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Selection type']/following::span[1]/span")).isEnabled());
 		Thread.sleep(500);
 		System.out.println("Drop down is enabled.");
 		Thread.sleep(1000);
		
		//Enter Caption texts:==============
 		log.driver.findElement(By.xpath("//div[text()='Caption']/following::input[1]")).sendKeys("Text");
 		Thread.sleep(500);
 		
 		log.driver.findElement(By.xpath("//div[text()='Caption']")).click();
 		//log.driver.findElement(By.xpath("//div[text()='Caption']")).click();
 		Thread.sleep(1000);
 		
		//Click on Three Dots and proceed:===================
 		log.driver.findElement(By.xpath("//div[text()='Caption']/following::button[1]")).click();
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Language text']")).isDisplayed());
 		Thread.sleep(500);
 		System.out.println("Language text window is displaying now.");
 		Thread.sleep(500);
 		
 		String NeutralText=log.driver.findElement(By.xpath("//div[text()=' <neutral>']/following::td[1]/div[1]")).getText();
 		if(NeutralText.equals("Text"))
 		{
 			System.out.println("Default texts are displaying for Language window.");
 		}
 		Thread.sleep(500);
 		//enter Values to Field:===================
 		click(By.xpath("//div[@class='w20_Kendoiconclass kendoGridEditCell']"));
 		log.driver.findElement(By.xpath("//textarea[@id='textareaCell']")).clear();

 		click(By.xpath("//td[@class='k-dirty-cell']"));
 		log.driver.findElement(By.xpath("//textarea[@id='textareaCell']")).sendKeys("Text_en");
 		
 		//Click ok Button:================
 		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(500);
 		
 		//Should Navigate to the property window:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]")).isDisplayed());
 		Thread.sleep(500);
 		System.out.println("Property window is displaying now.");
 		
 		//Click ok Button:================
 		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(500);
 		
		//Select Elemnt window is now displaying:==========================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Select Element')]")).isDisplayed());
		Thread.sleep(500);
		System.out.println("Select element window is displaying now.");
		Thread.sleep(1000);
		
		//Click ok Button:================
 		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		//Save as the report:=============

		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();

		click(By.xpath("//span[@id='hamburger_btn']"));
		click(By.xpath("//span[text()='Report']"));
		click(By.xpath("//span[text()='Save As']"));

		System.out.println("Save Report as window is displaying now.");
		
		//Change Name:===========
	    click(By.xpath("(//span[text()='Name'])[1]/following::input[1]"));
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Report_caption");
		Thread.sleep(2000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
		
		//Relogin and choose english as another language.:==============
		//Login as Admin user and Validate:=====================
		log.driver.findElement(By.xpath("//span[@id='hamburger_btn']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Log On C8 Server']")).isDisplayed());
		System.out.println("LogOn C8 Server window is displaying now.");
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys("Admin");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).sendKeys("Admin");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Server:']/following::input[1]")).sendKeys("localhost:10901");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		Thread.sleep(2000);
		
		//Select En as Language:==================
		WebElement Language=log.driver.findElement(By.xpath("(//span[@class='k-input'])[1]"));
        Actions act2=new Actions(log.driver);
        act2.click(Language).sendKeys("EN", Keys.ENTER).build().perform();
        Thread.sleep(2000);		
		
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		//open the Report and Validate:==============================
		List<WebElement> ReportList=log.driver.findElements(By.xpath("//span[text()='Sales by country']"));
		log.driver.findElement(By.xpath("(//span[text()='Sales by country'])"+"["+ReportList.size()+"]")).click();;
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='Report_caption']")).click();
  		Thread.sleep(3000);
  		//Take Count After open:===========
/*  	  	List<WebElement> ReportCount2=log.driver.findElements(By.xpath("//span[text()='Report_caption']"));
  	  	System.out.println("list of report is:->"+ReportCount2.size());
  	  	try
  	  	{
  	  		if(ReportCount2.size()>2)
  	  		{
  	  			System.out.println("Required Report is opened now");
  	  		}
  	  		
  	  	}catch(Exception e)
  	  		{
  	  			System.out.println("Need to click again.");
  	  			log.driver.findElement(By.xpath("//span[text()='Report_caption']")).click();
  	  			Thread.sleep(1000);
  	  		}
  		
  	  	Thread.sleep(2000);
  	  	log.driver.findElement(By.xpath("//span[text()='Report_caption']")).click();
  		Thread.sleep(3000);*/
  	
  		//Validate::=======================
  		Assert.assertEquals(log.driver.findElement(By.xpath("//div[@class='cwfiltercaption']/following::span[text()='Text_en']")).isDisplayed(), true);
		System.out.println("Filter Caption is displaying properly after change the language.");
		Thread.sleep(2000);
		
		//Delete the report:====================
		//After Relogin as Normal language:=======================
		log.driver.findElement(By.xpath("//span[@id='hamburger_btn']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Log On C8 Server']")).isDisplayed());
		System.out.println("LogOn C8 Server window is displaying now.");
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys("Admin");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).sendKeys("Admin");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Server:']/following::input[1]")).sendKeys("localhost:10901");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		Thread.sleep(2000);
		
		//Select Neutral as Language:==================
		WebElement Language2=log.driver.findElement(By.xpath("(//span[@class='k-input'])[1]"));
        Actions act3=new Actions(log.driver);
        act3.click(Language2).sendKeys("<neutral>", Keys.ENTER).build().perform();
        Thread.sleep(2000);		
        
       /* WebElement Select1=log.driver.findElement(By.xpath("(//span[@class='k-input'])[1]"));
        Actions Select1act=new Actions(log.driver);
        Select1act.click(Select1).sendKeys("<neutral>", Keys.ENTER).build().perform();
        Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[@class='k-input'])[1]")).click();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(2000);*/
		log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		//log.driver.findElement(By.xpath("(//span[text()='Report_caption'])[2]/span[@id='tab_close_btn']")).click();
		//Thread.sleep(3000);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Report_caption'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
  }
}
