package smokeCase;

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

public class TestCase_25042 extends TestUtils
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

	    System.out.println("25042---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25042:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();

	  	waitForVisibilityOfElement(By.xpath("//span[text()='Welcome']"));
	  	findVisible(By.xpath("//span[text()='Welcome']"));
	  
	  	System.out.println("Test Case 25042: Cockpit Data Mashup Drill down===================");
	  	
	    //Try to Open any Report:======================================
	    waitForVisibilityOfElement(By.xpath("//span[text()='Sales by country']"));
	    clickableClick(By.xpath("//span[text()='Sales by country']"));
//  		//Take Count After open:===========
//  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Sales by country']"));
//
//  	  	System.out.println("list of report is:->"+ReportCount.size());
//  	  	try
//  	  	{
//  	  		if(ReportCount.size()>2)
//  	  		{
//  	  			System.out.println("Required Report is opened now");
//  	  		}
//
//  	  	}catch(Exception e)
//  	  		{
//  	  			System.out.println("Need to click again.");
//  	  			log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
//  	  			Utils.waitForElement("");
//  	  		}

		//Click on DataView Designer window:================
		waitForInvisibilityOfElement(By.xpath("//body[@class='ajaxLoading']"));
		waitForVisibilityOfElement(By.xpath("//img[@class='w20_image ']/parent::div[@class='w20_contentpane w20_kendo w20_layoutcomp']"));
		clickableClick(By.xpath("//span[text()='Dataview Designer']"));
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Dataview Designer']/following::div[text()='Background'][1]")));
		System.out.println("Data View Designer window is displaying.");
  	    
		//Click Time link in Column:===========
		waitForVisibilityOfElement(By.xpath("//div[text()='Columns']/following::span[text()='Time']"));
  	    Assert.assertTrue(findVisibleBool(By.xpath("//div[text()='Columns']/following::span[text()='Time']")));
  	    clickableClick(By.xpath("//div[text()='Columns']/following::span[text()='Time']"));
		System.out.println("Selection for column window opened now.");
		
		//Remove all base elements:===============
	  	waitForVisibilityOfElement(By.xpath("//button[@data-title='Removes all items from the selection list']"));
		clickableClick(By.xpath("//button[@data-title='Removes all items from the selection list']"));
		//Select 2014 & 2015:=========
	  	waitForVisibilityOfElement(By.xpath("//div[text()='2014']/preceding::div[1]"));
	  	clickableClick(By.xpath("//div[text()='2014']/preceding::div[1]"));
	  	waitForVisibilityOfElement(By.xpath("//div[text()='2015']/preceding::div[1]"));
	    clickableClick(By.xpath("//div[text()='2015']/preceding::div[1]"));
	  	waitForVisibilityOfElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']"));
	  	clickableClick(By.xpath("//button[@data-title='Inserts only selected items to the selection list']"));
  	    
	    //Select Mashup :==========
	    //Select calculated element from drop down list:======================
  		Actions action = new Actions(driver);
  	 	WebElement optionsList = findVisible(By.xpath("//span[contains(@class,'k-widget k-dropdown w20_kendo')]"));
  	 	action.moveToElement(optionsList);

//  	 	List<WebElement> options= findAllVisible(By.xpath("//span[contains(@class,'k-input')]"));
//  	 	for(WebElement option : options)
//  	 	{
//  	 		//System.out.println(option.getText());
//  	 	    if (option.getText().equals("Calculated elements"))
//  	 	    {
//  	 	        option.click();
//  	 	    }
//  	 	}

		clickableClick(By.xpath("//span[text()='Time']"));
  		
  		 Actions act = new Actions(driver);
  	     act.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.DOWN)).perform();
  	     Thread.sleep(500);
  	     act.sendKeys(Keys.ENTER).perform();
  	     Thread.sleep(500);
	    
  	    //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,findVisible(By.xpath("//div[text()='MASHUP']/parent::div/div[1]/input")).isSelected());
		 Thread.sleep(500);
		 System.out.println("Calculated element check boxs are unchecked.");
		 Thread.sleep(500);
		
		 //Rank Ascending element should be visible:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		Thread.sleep(500);
		System.out.println("MASHUP text is displaying now..");
		
		//Checkbox should be uncheck and select the checkbox:=============
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).isSelected());
		Thread.sleep(500);
		System.out.println("MASHUP checkbox is unchecked..");
		log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).click();
		Thread.sleep(500);
		
		log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		Thread.sleep(500);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(500);
		
		//Verify After Add Ascending Column:==================
		Assert.assertEquals(true,findVisible(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		Thread.sleep(500);
		System.out.println("MASHUP is added in Table.");
		Thread.sleep(500);
		//map can't:====
		//????Need to Look at
		//=======
		////div[@class='w20_grid_datapart']/div/div[3]
		//Mashup cell should display write on rightclick opt:=====
		waitForVisibilityOfElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/0']"));
		Utils.rightClick("//div[text()='MASHUP']/following::div[@id='2/0']");
		implicitWaitSeconds(1);

		Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Write...']")).isDisplayed());
		System.out.println("Write text is displaying.");

		//		act.contextClick(findVisible(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']"))).perform();
		clickableClick(By.xpath("//span[text()='Write...']"));

		Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Cell Value']")).isDisplayed());
		Thread.sleep(500);
		System.out.println("Cell Value window is displaying.");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Help']")).isEnabled());
		Thread.sleep(500);
		System.out.println("Write window buttons are enabled.");

		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(500);


		waitForVisibilityOfElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']"));
		Utils.rightClick("//div[text()='MASHUP']/following::div[@id='2/1']");
		implicitWaitSeconds(1);

		Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Write...']")).isDisplayed());
		System.out.println("Write text is displaying.");

//		act.contextClick(findVisible(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']"))).perform();
	  	clickableClick(By.xpath("//span[text()='Write...']"));

//		Thread.sleep(500);
//		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
//		Thread.sleep(500);
//		System.out.println("Single data Cell window is displaying.");
		
		Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Cell Value']")).isDisplayed());
		Thread.sleep(500);
		System.out.println("Cell Value window is displaying.");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		Thread.sleep(500);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Help']")).isEnabled());
		Thread.sleep(500);
		System.out.println("Write window buttons are enabled.");

		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(500);

	  	//TODO: retrieve actual value via xpath
		String ExptVal="€ 20,449,646.71";
	  	String ActualVal=findVisible(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']")).getText();
  	 
		Assert.assertEquals(ActualVal, ExptVal);
  	    System.out.println("Mashup Value is calculated properly as expected.");

  	    //Expand All Customer Row by Double click:====
  	    act.doubleClick(findVisible(By.xpath("//div[text()='All Customers']"))).perform();
  	    implicitWaitSeconds(2);
		//Thread.sleep(500);
  	    
		//Expand:==============
		clickableClick(By.xpath("//div[text()='All Customers']"));
	  	Utils.rightClick("//div[text()='All Customers']");
		implicitWaitSeconds(2);
		
		clickableClick(By.xpath("//span[text()='Navigate']"));

//		act.moveToElement(findVisible(By.xpath("//span[text()='DrillDown']"))).perform();
		implicitWaitSeconds(2);

		//waitForInvisibilityOfElement(By.xpath("//body[@class='ajaxLoading']"));
		clickableClick(By.xpath("//span[text()='DrillDown']"));
		implicitWaitSeconds(3);
		//Enter Write in some other column:===============

/*
		waitForVisibilityOfElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']"));
	  	waitForInvisibilityOfElement(By.xpath("//body[@class='ajaxLoading']"));
		clickableClick(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']"));
		waitForInvisibilityOfElement(By.xpath("//body[@class='ajaxLoading']"));
		Utils.rightClick("//div[text()='MASHUP']/following::div[@id='2/1']");
		implicitWaitSeconds(2);

//		Assert.assertEquals(true,findVisible(By.xpath("//span[text()='Write...']")).isDisplayed());
//		System.out.println("Write text is displaying again.");

		//		act.contextClick(findVisible(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']"))).perform();
//		waitForInvisibilityOfElement(By.xpath("//body[@class='ajaxLoading']"));
		waitForVisibilityOfElement(By.xpath("//span[text()='Write...']"));
		clickableClick(By.xpath("//span[text()='Write...']"));

		//enter input value for mashup cell:===========
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();

		implicitWaitSeconds(3);
*/


//		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']"))).perform();
//		Thread.sleep(500);
//		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
//		//enter input value for mashup cell:===========
//		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
//		Thread.sleep(500);
		
		String ActualVal2=findVisible(By.xpath("//div[text()='MASHUP']/following::div[@id='2/0']")).getText();
		Thread.sleep(500);
		//TODO: retrieve actual value via xpath
		String ExptVal2="€ 20,449,646.71";
		Thread.sleep(500);
		Assert.assertEquals(ActualVal2, ExptVal2);
  	    System.out.println("Case-2:->Mashup Value is showing properly as expected for other row.");
  	    Thread.sleep(500);
		
		//:===========================================
  	    //act.doubleClick(log.driver.findElement(By.xpath("//div[text()='All Customers']"))).perform();
		//Thread.sleep(500);
		//Expand:==============
		act.contextClick(findVisible(By.xpath("//div[text()='Australia']"))).perform();
		implicitWaitSeconds(2);
		
		clickableClick(By.xpath("//span[text()='Navigate']"));

//		act.moveToElement(findVisible(By.xpath("//span[text()='RollUp to Top Level']"))).perform();
		clickableClick(By.xpath("//span[text()='RollUp to Top Level']"));
		implicitWaitSeconds(2);
		
		//=====Verify roll up==============
	  	waitForInvisibilityOfElement(By.xpath("//div[text()='Australia']")); // Australia invisible

		String mashupCell = findVisible(By.xpath("//div[text()='MASHUP']/following::div[@id='2/0']")).getText();
		//TODO: retrieve actual value via xpath
		String ExptVal3="€ 163,352,917.42";
//		Thread.sleep(500);
//		String ActualVal3=log.driver.findElement(By.xpath("//div[text()='Australia']/following::div[@id='0/0']")).getText();
//		Thread.sleep(500);
		Assert.assertEquals(mashupCell, ExptVal3);
  	    System.out.println("Mashup Value is showing properly as expected after roll up action.");
//
//		//======Drill Down Action============
//  	    act.contextClick(log.driver.findElement(By.xpath("//div[text()='Australia']"))).perform();
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("//span[text()='Navigate']")).click();
//		Thread.sleep(500);
//		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='DrillDown']"))).perform();
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("//span[text()='DrillDown']")).click();
//		Thread.sleep(500);
		
		//Verify All Customer should not display:=================
//		try
//		{
//			Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Australia']")).isDisplayed(),false);
//		}catch(Exception e)
//		{
//			System.out.println("Drill down Action happen,so All Customers row is not displaying.");
//		}
//		//Verify Mashup Value for 1st Column:==============
//		String ExptVal5=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='2/1']")).getText();
//		Thread.sleep(500);
//		String ActualVal5=log.driver.findElement(By.xpath("//div[@id='0/0']")).getText();
//		Thread.sleep(500);
//		Assert.assertEquals(ExptVal5, ActualVal5);
//  	    System.out.println("Mashup Value is showing properly as expected after drillDown action.");
//  	    Thread.sleep(500);
  	    System.out.println("25042:-Testcase Done.....");
	  	
	  	
  }
  
}
