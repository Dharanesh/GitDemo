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

public class TestCase_37306 extends TestUtils
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
	   System.out.println("37306---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 37306: Cockpit Data Mashup Planning hold check");
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
	  	log.driver.findElement(By.xpath("(//span[text()='New'])[2]")).click();
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
			System.out.println("Check box is selected.");
		}
		else
		{
			System.out.println("Check box is not selected.");
			log.driver.findElement(By.xpath("//label[text()='Display filter bar']")).click();
		}
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Display filter bar']/preceding::input[1]")).isSelected());
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
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys(Keys.BACK_SPACE);
		
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Testcase_25043");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(3000);
		//Click Finish:====================
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(3000);
		
		//====================================
	  	//Add Measure in Column:===============
		String ColumnObject=log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).getText();
		System.out.println("Column Object is:->"+ColumnObject);
		Thread.sleep(1000);
		Assert.assertEquals(ColumnObject,"Measures");
		Thread.sleep(3000);
	  	//Add Mashup Value in Column :==============
		log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[text()='Measures']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Selection for column window opened now.");
	  	
		//Select Mashup :==========
	    //Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act2=new Actions(log.driver);
        //act2.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);
        act2.click(e2).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
	  	 
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
	
		 log.driver.navigate().refresh();
		 Thread.sleep(3000);
		 log.driver.findElement(By.xpath("(//span[text()='Refresh'])[2]")).click();
		 Thread.sleep(3000);
		//Double click the fst cell:=========
		// act2.doubleClick(log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]/img[1]"))).perform();
		 //log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]/ancestor::div[1]")).click();
		// Thread.sleep(2000);
		// log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]/ancestor::div[1]")).click();
		// Thread.sleep(2000);
		 act2.contextClick(log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]/img[1]"))).perform();
		 Thread.sleep(1000);
		 
		 try 
			{
				if(log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed())
				{
					System.out.println("Navigate text is displaying.");
					Thread.sleep(1000);
				}
			}catch(Exception e)
			{
				Actions act_a=new Actions(log.driver);
				act_a.contextClick(log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]/img[1]"))).build().perform();
				Thread.sleep(2000);
			}
		 
		 log.driver.findElement(By.xpath("//span[text()='Navigate']")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//span[text()='Expand']")).click();
		 Thread.sleep(2000);
		 
		 act2.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		 Thread.sleep(1000);
		 try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed())
			{
				System.out.println("Single data Cell window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).build().perform();
			Thread.sleep(2000);
		}
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Single data Cell window is displaying.");
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Write text is displaying.");
		
		 //Verify Write window after click on same:===========
		 log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Cell Value']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Cell Value window is displaying.");
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Help']")).isEnabled());
		 Thread.sleep(1000);
		 System.out.println("Write window buttons are enabled.");
		
	 	 //enter input value for mashup cell:===========
		 //=getcellvalue(1,1)
		 log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=getcellvalue(1,1)");
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
		 String FstMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		 Thread.sleep(2000);
		 System.out.println("First Mashup Cell value is:->"+FstMashupValue);
		 
		 //Roll Back Option is Not displaying on my screen:=====
		 
		log.driver.close();
		
		
		 
		 
		 
		 
		
   }
}
