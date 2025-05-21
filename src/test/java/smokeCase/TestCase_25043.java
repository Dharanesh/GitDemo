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

public class TestCase_25043 extends TestUtils
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
	   System.out.println("25043---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25042:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 25043: Cockpit Data Mashup Planning hold check===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  	//New Report creation:=================
		//Create Report:==============
	  	log.driver.findElement(By.xpath("//span[text()='New']")).click();
	  	Utils.waitForElement("");
	  	Thread.sleep(2000);
	  	
	  	//Wait for new report window open:=================
		log.driver.findElement(By.xpath("//span[text()='New Report']")).isDisplayed();
		Thread.sleep(2000);
	  	//Select Standard Report and click next:==============
		log.driver.findElement(By.xpath("//span[text()='Standard Report']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		//Select Cube Window Verify:===========
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Cube']")).isDisplayed());
		Thread.sleep(2000);
		//Click Expand Button of PantaraCube:===========
		log.driver.findElement(By.xpath("(//div[@class='w20_treeitemcollapsed'])[1]")).click();
		Thread.sleep(3000);
		//Select Sales cube and click next:=============
		log.driver.findElement(By.xpath("//div[text()='A - Training HR']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		//Dimension window selection validate:================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dimension Selection']")).isDisplayed());
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		//Report Layout window validate and click next:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Report Layout']")).isDisplayed());
		Thread.sleep(2000);
		//select Table option:===========
		log.driver.findElement(By.xpath("//label[text()='Table only']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		//Filter Components:==============================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Filter Components']")).isDisplayed());
		Thread.sleep(2000);
		
		boolean ValueCheckBox=log.driver.findElement(By.xpath("//label[text()='Display filter bar']/preceding::input[1]")).isSelected();
		System.out.println("Check box value is:->"+ValueCheckBox);
		Thread.sleep(2000);
		
		if(ValueCheckBox)
		{
			System.out.println("Check box is selected , Need to uncheck.");
			log.driver.findElement(By.xpath("//label[text()='Display filter bar']")).click();
		}
		else
		{
			System.out.println("Check box is not selected.");
		}
		Thread.sleep(2000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Display filter bar']/preceding::input[1]")).isSelected());
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		//What's next window if display then click next:=============
		try
		{
			Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'What')]")).isDisplayed());
			Thread.sleep(2000);
			System.out.println("Whats Next Window is displaying now.");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Whats Next Window is not displaying.");
		}
		//Finish Window:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(2000);
		//Enter Report Value:============
		log.driver.findElement(By.xpath("(//input[@class='k-textbox w20_webedit_left'])[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		log.driver.findElement(By.xpath("(//input[@class='k-textbox w20_webedit_left'])[1]")).sendKeys(Keys.BACK_SPACE);
		
		log.driver.findElement(By.xpath("(//input[@class='k-textbox w20_webedit_left'])[1]")).sendKeys("Testcase_25043");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(3000);
		//Click Finish:====================
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(3000);
		
		//====================================
	  	//Add Measure in Column:====
		String ColumnObject=log.driver.findElement(By.xpath("//span[text()='Columns']/following::span[7]/span[2]")).getText();
		System.out.println("Column Object is:->"+ColumnObject);
		Thread.sleep(1000);
		Assert.assertEquals(ColumnObject,"Measures");
		Thread.sleep(3000);
	  	//Add Mashup Value in Column :==============
		log.driver.findElement(By.xpath("//span[text()='Columns']/following::span[text()='Measures']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Selection for column window opened now.");
	  	
		//Select Mashup :==========
	    //Select calculated element from drop down list:======================
  		Actions action = new Actions(log.driver);    
  	 	WebElement optionsList = log.driver.findElement(By.xpath("//span[contains(@class,'k-widget k-dropdown w20_kendo')]"));
  	 	action.moveToElement(optionsList);

  	 	List<WebElement> options=log.driver.findElements(By.xpath("//span[contains(@class,'k-input')]"));
  	 	for(WebElement option : options) 
  	 	{
  	 		//System.out.println(option.getText());
  	 	    if (option.getText().equals("Calculated elements")) 
  	 	    {
  	 	        option.click();
  	 	    }
  	 	}
  		log.driver.findElement(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo'])[1]/span[1]")).click();
  		Thread.sleep(3000);
  		
  		 Actions act = new Actions(log.driver);
  	     act.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.DOWN)).perform();
  	     Thread.sleep(2000);
  	     act.sendKeys(Keys.ENTER).perform();
  	     Thread.sleep(2000);
	    
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
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("MASHUP is added in Table.");
		Thread.sleep(1000);
		
		//Issue in Splashing Related Test case:===================
		
		
		
		
		
		
	  	
  }
}
