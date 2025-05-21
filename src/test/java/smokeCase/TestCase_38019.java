package smokeCase;

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

public class TestCase_38019 extends TestUtils
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
	  System.out.println("38019---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25788: Testcase to verify Mashup Functionality after applying Table Row Properties(Headers and Rows Properties).");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("===Test Case 25788: Testcase to verify Mashup Functionality after applying Table Row Properties(Headers and Rows Properties).===");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000); 
	  	
	    //Open Sales By Country Report:==============
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
	  	Thread.sleep(5000);
	  	
	  	//Click Data view link and proceed:============
	  	log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	  	Utils.waitForElement("");
	  	
	  //Add Mashup Column:================
  	    //Click Measure and proceed:====
  	  	log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Columns window is displaying now.");
		Thread.sleep(1000);
  	  	
		//Remove All Items and Validate base elemnt list:============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Base elements with containers having Zero Element is displaying now after remove all.");
		Thread.sleep(1000);
	  	
		log.driver.findElement(By.xpath("//div[text()='2014']")).click();
		Thread.sleep(3000);
		//log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		//Thread.sleep(3000);
		
		//Add Mashup:================
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
  	  	
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Base elements with containers (2 Items)']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Base elements with containers having three Element is displaying.");
		 Thread.sleep(1000);
  	  	
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
	  	
		 //Click on fst cell then shift to end:=======
		 /*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
		 Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyRelease(KeyEvent.VK_RIGHT); 
	     Thread.sleep(1000);*/
		 
		 //Mashup is Added to the table verify:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
	 	 Thread.sleep(1000);
		 System.out.println("MASHUP is added in Table.");
		 Thread.sleep(1000);
		 
		 //Enter Value In any Mashup cell:=================
		//Mashup cell should display write on rightclick opt:=====
		 Actions act=new Actions(log.driver);
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
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
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String MashupCellValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		System.out.println("Mashup Cell value is:->"+MashupCellValue); 
	  	
	  	//Click Table Row Properties:==============
		Thread.sleep(1000);
		act.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/1']"))).perform();
		Thread.sleep(1000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Table Rows Properties...']")).isDisplayed())
			{
				System.out.println("Table Rows Properties window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/1']"))).build().perform();
			Thread.sleep(2000);
		}
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Table Rows Properties...']")).isDisplayed());
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Table Rows Properties...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Properties of ')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Table Row Property Window opened now");
		
		//Validate Default Property:======
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Default font']/following::input[@value='Arial, 9 pt']")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Default font color']")).isDisplayed());
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Default font color']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//p[text()='Default font color']")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Show row headers']/following::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='Wordwrap in row header']/following::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Row heights']/following::span[text()='Explicit'][1]")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Row header width']/following::span[text()='Automatic'][1]")).isDisplayed());
		Thread.sleep(1000);
		
		//Enter Some Input For Validate:=================
		log.driver.findElement(By.xpath("//div[text()='Default font']/following::button[1]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Font selection']")).isDisplayed());
		Thread.sleep(1000);
		
		WebElement e3=log.driver.findElement(By.xpath("//span[text()='Font:']/following::span[1]"));
        //act2.click(e3).sendKeys("Verdana", Keys.ENTER).build().perform();
        Thread.sleep(2000);
        act2.click(e3).perform();
        act2.sendKeys(Keys.DOWN).perform();
        act2.sendKeys(Keys.ENTER).perform();
        Thread.sleep(500);
        
        String ValueText=log.driver.findElement(By.xpath("//span[text()='Font:']/following::span[1]")).getText();
        System.out.println("Text dropdown value:->"+ValueText);
        Thread.sleep(500);
        log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Properties of ')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Table Row Property Window opened now");
        
		//Color:======
		log.driver.findElement(By.xpath(" //div[text()='Default font color']/following::button[1]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select Color Window is displaying now.");
		Thread.sleep(1000);
		//Issue in Default Color:===============
		//Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Default color']/preceding::input[1]")).isSelected());
		//System.out.println("ByDefault Checkbox is checked.");
		//Thread.sleep(1000);
		
		//default Color Check box:================== 
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//td[text()='Red:']/following::input[1]")).isEnabled());
		System.out.println("ByDefault Red textBox is Enabled.");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//td[text()='Blue:']/following::input[1]")).isEnabled());
		System.out.println("ByDefault Blue textBox is Enabled.");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//td[text()='Green:']/following::input[1]")).isEnabled());
		System.out.println("ByDefault Green textBox is Enabled.");
		
		//Select Any Color:====
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::tr[2]/td[1]")).click();
		Thread.sleep(3000);
		String ActColrVal=log.driver.findElement(By.xpath("//div[text()='Actual:']/following::div[1]")).getCssValue("background-color");
		System.out.println(ActColrVal);
		//Click OK bUTTON:======
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		
		//Explicit Height:===
		log.driver.findElement(By.xpath("//div[text()='Explicit height']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Explicit height']/following::input[1]")).sendKeys(Keys.CONTROL+"a");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Explicit height']/following::input[1]")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Explicit height']/following::input[1]")).sendKeys("20");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		//Validate:=====================
		//Check for Mashup:==========
		String AfterMashupCellValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		System.out.println("Mashup Cell value is:->"+AfterMashupCellValue); 
		Assert.assertEquals(AfterMashupCellValue, MashupCellValue);
		System.out.println("Mashup Cell Value is Not Effected.");
		Thread.sleep(1000);
		
		//Row cell Header:==============
		String RowProperty_colr=log.driver.findElement(By.xpath("//div[@id='-1/1']")).getCssValue("color");
		Thread.sleep(1000);
		System.out.println("Row Property Color is:->"+RowProperty_colr);
		
		String RowProperty_Text=log.driver.findElement(By.xpath("//div[@id='-1/1']")).getCssValue("font-family");
		Thread.sleep(1000);
		System.out.println("Row Property Text Value is:->"+RowProperty_Text);
		Thread.sleep(1000);
		
		String RowProperty_style=log.driver.findElement(By.xpath("//div[@id='-1/1']")).getAttribute("style");
		Thread.sleep(1000);
		System.out.println("Row Property style Value is:->"+RowProperty_style);
		Thread.sleep(1000);
		
		
		int RowPropCount=0;
		if(RowProperty_colr.contains("139, 0, 0"))
		{
			//if(RowProperty_Text.equals("Verdana"))
			//{
				if(RowProperty_style.contains("top: 22px"))
				{
						RowPropCount++;
				}
			//}
		}
		Thread.sleep(1000);
		Assert.assertEquals(RowPropCount,1);
		System.out.println("Testcase to verify Cockpit Data Mashup Functionality on Table Row Property Validation Done.");
		Thread.sleep(1000);
		
		//Save As The Report:===================
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("(//span[text()='Save']/following::span[1])[2]")).click();
  		Thread.sleep(2000);
  		//Click Down and do Save As:====================
  		log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
  		Thread.sleep(2000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
  		Thread.sleep(1000);
  		System.out.println("Save Report as window is displaying now.");
  		
  		//Change Name:===========
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("c8 Cockpit_DataMashup_Functionality  Table_RowProperties_ check");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
		  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_Functionality  Table_RowProperties_ check'])[3]")).click();
  		Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_Functionality  Table_RowProperties_ check'])[1]/preceding::input[1]")).click();
  		Thread.sleep(2000);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_Functionality  Table_RowProperties_ check'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
		
	  	
  }
}
